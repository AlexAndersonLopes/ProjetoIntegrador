package dao;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import jdbc.ConnectFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Vendas;
import util.Mensagens;

public class VendasDAO {

    private Connection con;

    public VendasDAO() {
        this.con = new ConnectFactory().getConnection();
    }

    //EFETUAR UMA VENDA
    public void efetuarVenda(Vendas vendas) {
        try {
            String sql = "insert into cadVendas(data, cadUsuarios, total, cpf) values(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDate(1, (Date) vendas.getData());
            ps.setInt(2, vendas.getUsuario().getId());
            ps.setDouble(3, vendas.getTotal());
            ps.setString(4, vendas.getCpfCliente());

            ps.execute();
            ps.close();

            Mensagens.mensagemExito("Venda Efetuada com Sucesso");

        } catch (HeadlessException | SQLException e) {
            Mensagens.mensagemErro("Venda NÃO cadastrada no Banco de Dados");
        }
    }

    //VENDA ATUAL
    public int vendaAtual() {
        try {
            int idV = 0;

            String sql = "select max(id) id from cadVendas";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Vendas vendas = new Vendas();
                vendas.setId(rs.getInt("id"));
                idV = vendas.getId();
            }
            return idV;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
