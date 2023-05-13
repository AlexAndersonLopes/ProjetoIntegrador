package dao;

import java.sql.Connection;
import jdbc.ConnectFactory;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Produto;
import java.sql.*;

public class ProdutoDAO {

    private Connection con;

    public ProdutoDAO() {
        //O ATRIBUTO CON VAI RECEBER UMA NOVA CONEXÃO COM O BD
        this.con = new ConnectFactory().getConnection();
    }

    //CADASTRAR PRODUTO
    public void cadastrarProduto(Produto p) {
        String sql = "insert into produtos(produto, marca, codigoBarras, preco, quantidade)" + "values(?,?,?,?,?)";
        try {
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getProduto());
            ps.setString(2, p.getMarca());
            ps.setString(3, p.getCodigoBarras());
            ps.setDouble(4, p.getPreco());
            ps.setInt(5, p.getQuantidade());

            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!!!");
            {
            }
        } catch (SQLException e) {
            String[] options = {"Fechar"};
            int selectedOption = JOptionPane.showOptionDialog(null, "Produto não Cadastrado no BD", "ERRO",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
        }
    }

    //PROCURAR POR CODIGO DE BARRAS
    public List<Produto> procurarCodigoBarras(String codigo) {
        try {
            List<Produto> lista = new ArrayList<>();
            String sql = "SELECT * FROM produtos WHERE codigoBarras = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produto pro = new Produto();
                pro.setCodigoBarras(rs.getString("codigoBarras"));
                lista.add(pro);
            }
            return lista;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao procurar o produto no Sistema");
            return null;
        }
    }

    //PROCURAR POR CODIGO DE BARRAS TODOS OS DADOS DO PRODUTO PESQUISADO
    public List<Produto> procurarAlterar(String codigo) {
        try {
            List<Produto> lista = new ArrayList<>();
            String sql = "SELECT * FROM produtos WHERE codigoBarras = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produto pro = new Produto();
                pro.setCodigoBarras(rs.getString("codigoBarras"));
                pro.setProduto(rs.getString("produto"));
                pro.setMarca(rs.getString("marca"));
                Double pre = rs.getDouble("preco");
                pro.setPreco(pre);
                pro.setQuantidade(rs.getInt("quantidade"));
                lista.add(pro);
            }
            return lista;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao procurar o produto no Sistema");
            return null;
        }
    }

    //ALTERAR ALGUM DADO DO PRODUTO
    public void alterarProduto(Produto pro) {
        try {
            String sql = "update produtos set produto=?, marca=?, preco=?, quantidade=? where codigoBarras=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pro.getProduto());
            ps.setString(2, pro.getMarca());
            ps.setDouble(3, pro.getPreco());
            ps.setInt(4, pro.getQuantidade());
            ps.setString(5, pro.getCodigoBarras());

            ps.execute();
            ps.close();

            String[] options = {"Fechar"};
            int selectedOption = JOptionPane.showOptionDialog(null, "Alterado com sucesso!", "Produto Alterado",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        } catch (Exception e) {
            String[] options = {"Fechar"};
            int selectedOption = JOptionPane.showOptionDialog(null, "Erro ao Alterar o Produto", "ERRO",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
        }

    }

    //GERAR A LISTA DE TODOS OS PRODUTOS
    public List<Produto> listaProdutos() {
        try {
            List<Produto> lista = new ArrayList<>();
            String sql = "select * from produtos";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Produto pro = new Produto();
                pro.setProduto(rs.getString("produto"));
                pro.setMarca(rs.getString("marca"));
                pro.setCodigoBarras(rs.getString("codigoBarras"));
                pro.setPreco(rs.getDouble("preco"));
                pro.setQuantidade(rs.getInt("quantidade"));

                lista.add(pro);
            }
            return lista;

        } catch (SQLException e) {
            String[] options = {"Fechar"};
            int selectedOption = JOptionPane.showOptionDialog(null, "Falha ao tentar acessar a Lista de Produtos", "ERRO",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
            return null;
        }
    }

    //GERAR A LISTA DE 1 PRODUTO POR NOME
    public List<Produto> listaProdutosPorNome(String produto) {
        try {
            List<Produto> lista = new ArrayList<>();
            String sql = "select * from produtos where produto like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            String busca = String.format("%%%s%%", produto);
            ps.setString(1, busca);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Produto pro = new Produto();
                pro.setProduto(rs.getString("produto"));
                pro.setMarca(rs.getString("marca"));
                pro.setCodigoBarras(rs.getString("codigoBarras"));
                pro.setPreco(rs.getDouble("preco"));
                pro.setQuantidade(rs.getInt("quantidade"));

                lista.add(pro);
            }
            return lista;

        } catch (SQLException e) {
            String[] options = {"Fechar"};
            int selectedOption = JOptionPane.showOptionDialog(null, "Falha ao tentar acessar a Lista de Produtos", "ERRO",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
            return null;
        }
    }

    //PROCURAR POR CODIGO DE BARRAS TODOS OS DADOS DO PRODUTO PESQUISADO
    public Produto procurarPorCodigoBarras(String codigo) {
        try {
            Produto pro = new Produto();
            String sql = "SELECT * FROM produtos WHERE codigoBarras = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                pro.setCodigoBarras(rs.getString("codigoBarras"));
                pro.setProduto(rs.getString("produto"));
                pro.setMarca(rs.getString("marca"));
                Double pre = rs.getDouble("preco");
                pro.setPreco(pre);
                pro.setQuantidade(rs.getInt("quantidade"));
            }

            if (pro.getCodigoBarras().isEmpty()) {
                return null;
            } else {
                return pro;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado");
            return null;
        }
    }

    //Pesquisar id do produto
    public Produto idProduto(String nome) {

        try {
            Produto pro = new Produto();
            String sql = "select * from produtos where produto like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                pro.setId(rs.getInt("id"));
                pro.setCodigoBarras(rs.getString("codigoBarras"));
                pro.setProduto(rs.getString("produto"));
                pro.setMarca(rs.getString("marca"));
                Double pre = rs.getDouble("preco");
                pro.setPreco(pre);
                pro.setQuantidade(rs.getInt("quantidade"));
            }
            return pro;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado");
            return null;
        }

    }

}
