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
            String sql = "SELECT p.produto AS PRODUTO, p.marca AS MARCA, vp.qtd AS QUANTIDADE, vp.subttotal AS SUBTOTAL "
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

                Produto produto = new Produto();
                produto.setProduto(produtos);
                produto.setMarca(marca);

                VendaProdutos vendaProduto = new VendaProdutos();
                vendaProduto.setProduto(produto);
                vendaProduto.setQuantidade(quantidade);
                vendaProduto.setSubTotal(subtotal);

                lista.add(vendaProduto);
            }
            return lista;

        } catch (HeadlessException e) {
            Mensagens.mensagemErro("Erro ao buscar o carrinho de Vendas");
            return null;
        }
    }

}
