package dao;

import java.sql.Connection;
import jdbc.ConnectFactory;
import model.TipoPagamento;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.Mensagens;

public class TipoPagamentoDAO {

    private Connection con;

    public TipoPagamentoDAO() {
        this.con = new ConnectFactory().getConnection();
    }

    //Cadastrar o tipo de Pagamento
    public void tipoPagamento(TipoPagamento pg) {
        try {
            String sql = "Insert into pagamento(descricao, valor, cadVendas) values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, pg.getDescricao());
            ps.setDouble(2, pg.getValor());
            ps.setInt(3, pg.getVenda().getId());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            Mensagens.mensagemErro("Pagamento não cadastrado no Banco de dados");
        }
    }

}
