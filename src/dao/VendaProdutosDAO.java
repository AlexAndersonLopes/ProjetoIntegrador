package dao;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.ConnectFactory;
import model.Produto;
import model.VendaProdutos;
import util.Mensagens;

public class VendaProdutosDAO {

    private Connection con;

    public VendaProdutosDAO() {
        this.con = new ConnectFactory().getConnection();
    }

    //Cadastrar lista de produto de uma compra
    public void listaItemVenda(VendaProdutos item) {
        try {
            String sql = "Insert into vendaProdutos(qtd, subttotal, produtos, cadVendas) values(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, item.getQuantidade());
            ps.setDouble(2, item.getSubTotal());
            ps.setInt(3, item.getProduto().getId());
            ps.setInt(4, item.getVendas().getId());

            ps.execute();
            ps.close();

        } catch (HeadlessException | SQLException e) {
            Mensagens.mensagemErro("Os Itens não foram cadastrados no Banco de Dados");
        }
    }

    public List<VendaProdutos> listaVendaItens(int ids) throws SQLException {
        try {
            List<VendaProdutos> lista = new ArrayList<>();
            String sql = "SELECT p.produto AS PRODUTO, p.marca AS MARCA, vp.qtd AS QUANTIDADE, vp.subttotal AS SUBTOTAL, vp.id AS IDVENDAPRODUTO "
                    + "FROM vendaprodutos vp "
                    + "INNER JOIN produtos p ON p.id = vp.produtos "
                    + "INNER JOIN cadvendas v ON v.id = vp.cadvendas "
                    + "WHERE v.id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ids);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                String produtos = resultSet.getString("PRODUTO");
                String marca = resultSet.getString("MARCA");
                int quantidade = resultSet.getInt("QUANTIDADE");
                double subtotal = resultSet.getDouble("SUBTOTAL");
                int id = resultSet.getInt("IDVENDAPRODUTO");

                Produto produto = new Produto();
                produto.setProduto(produtos);
                produto.setMarca(marca);

                VendaProdutos vendaProduto = new VendaProdutos();
                vendaProduto.setProduto(produto);
                vendaProduto.setQuantidade(quantidade);
                vendaProduto.setSubTotal(subtotal);
                vendaProduto.setId(id);

                lista.add(vendaProduto);
            }
            return lista;

        } catch (HeadlessException e) {
            Mensagens.mensagemErro("Erro ao buscar o carrinho de Vendas");
            return null;
        }
    }

    public void excluirProdutoDaVenda(int vendaProdutoId) throws SQLException {
        String sql = "SELECT vp.qtd AS quantidade, vp.produtos AS produto_id "
                + "FROM vendaProdutos vp "
                + "WHERE id = ?";

        String sqlDeleteVendaProduto = "DELETE FROM vendaProdutos WHERE id = ?";
        String sqlUpdateEstoque = "UPDATE produtos SET quantidade = quantidade + ? WHERE id = ?";

        try ( PreparedStatement psSelect = con.prepareStatement(sql);  PreparedStatement psDeleteVendaProduto = con.prepareStatement(sqlDeleteVendaProduto);  PreparedStatement psUpdateEstoque = con.prepareStatement(sqlUpdateEstoque)) {

            psSelect.setInt(1, vendaProdutoId);

            ResultSet rs = psSelect.executeQuery();

            if (rs.next()) {
                int quantidade = rs.getInt("quantidade");
                int produtoId = rs.getInt("produto_id");

                psDeleteVendaProduto.setInt(1, vendaProdutoId);

                int rowsDeleted = psDeleteVendaProduto.executeUpdate();

                if (rowsDeleted > 0) {

                    psUpdateEstoque.setInt(1, quantidade);
                    psUpdateEstoque.setInt(2, produtoId);

                    int rowsUpdatedEstoque = psUpdateEstoque.executeUpdate();
                    Mensagens.mensagemExito("Produto excluído com Sucesso!");

                } else {
                    Mensagens.mensagemAlerta("O produto não foi encontrado na venda!");
                }
            } else {
                Mensagens.mensagemAlerta("O produto não foi encontrado na venda!");
            }
        } catch (SQLException e) {
            Mensagens.mensagemErro("Erro ao excluír o produto da venda: \n" + e.getMessage());
        }
    }

    public void alterarProdutoDaVenda(int vendaProdutoId, int quantidadeExcluir) throws SQLException {
        String sqlSubtotal = "SELECT vp.qtd - ? AS nova_qtd, (vp.qtd - ?) * (SELECT preco FROM produtos WHERE id = vp.produtos) AS novo_subtotal, vp.produtos "
                + "FROM vendaProdutos vp "
                + "WHERE id = ?";
        String sqlUpdateVendaProduto = "UPDATE vendaProdutos SET qtd = ?, subttotal = ? WHERE id = ?";
        String sqlUpdateEstoque = "UPDATE produtos SET quantidade = quantidade + ? WHERE id = ?";

        try ( PreparedStatement psSubtotal = con.prepareStatement(sqlSubtotal);  PreparedStatement psUpdateVendaProduto = con.prepareStatement(sqlUpdateVendaProduto);  PreparedStatement psUpdateEstoque = con.prepareStatement(sqlUpdateEstoque)) {

            psSubtotal.setInt(1, quantidadeExcluir);
            psSubtotal.setInt(2, quantidadeExcluir);
            psSubtotal.setInt(3, vendaProdutoId);

            ResultSet rs = psSubtotal.executeQuery();

            if (rs.next()) {
                int novaQtd = rs.getInt("nova_qtd");
                double novoSubtotal = rs.getDouble("novo_subtotal");
                int produtoId = rs.getInt("produtos");

                psUpdateVendaProduto.setInt(1, novaQtd);
                psUpdateVendaProduto.setDouble(2, novoSubtotal);
                psUpdateVendaProduto.setInt(3, vendaProdutoId);

                int rowsUpdated = psUpdateVendaProduto.executeUpdate();

                psUpdateEstoque.setInt(1, quantidadeExcluir);
                psUpdateEstoque.setInt(2, produtoId);

                int rowsUpdatedEstoque = psUpdateEstoque.executeUpdate();
                Mensagens.mensagemExito("Produto excluído com Sucesso!");

            } else {
                Mensagens.mensagemAlerta("O produto não foi encontrado na venda!");
            }
        } catch (SQLException e) {
            Mensagens.mensagemErro("Erro ao atualizar o produto da venda: \n" + e.getMessage());
        }
    }

}
