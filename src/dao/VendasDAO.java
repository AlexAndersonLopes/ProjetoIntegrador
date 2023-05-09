package dao;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import jdbc.ConnectFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Vendas;

public class VendasDAO {

    private Connection con;

    public VendasDAO() {
        this.con = new ConnectFactory().getConnection();
    }

    //EFETUAR UMA VENDA
    public void efetuarVenda(Vendas vendas) {
        try {
            String sql = "insert into cadVendas(data, total, cadUsuarios) values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setDate(1, (Date) vendas.getData());
            ps.setDouble(2, vendas.getTotal());
            ps.setInt(3, vendas.getUsuario().getId());

            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Venda cadastrada no Banco de Dados");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Venda NÃO cadastrada no Banco de Dados" + e);
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
