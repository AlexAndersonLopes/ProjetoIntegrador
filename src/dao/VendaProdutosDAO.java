package dao;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jdbc.ConnectFactory;
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

}
