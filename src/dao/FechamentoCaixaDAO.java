package dao;

import java.sql.Connection;
import jdbc.ConnectFactory;
import model.FechamentosCaixa;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import model.Usuario;
import util.Mensagens;

public class FechamentoCaixaDAO {

    private Connection con;

    public FechamentoCaixaDAO() {
        this.con = new ConnectFactory().getConnection();
    }

    //CADASTRAR TIPOS PAGAMENTOS
    public void cadastrarFechamentoCaixa(FechamentosCaixa caixa) {
        try {
            String sql = "insert into fechamentoCaixa(descricao, valor, usuario)" + "values(?,?,?)";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);

            ps.setString(1, caixa.getDescricao());
            ps.setDouble(2, caixa.getValor());
            ps.setInt(3, caixa.getUsuario().getId());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            Mensagens.mensagemErro("ERRO ao cadastrar o Fechamento de Caixa");
        }
    }

    //LIMPAR DADOS DA TABELA
    public void removerFechamentoCaixa(Usuario usuario) {
        try {
            String sql = "DELETE FROM fechamentoCaixa WHERE usuario = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, usuario.getId());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            Mensagens.mensagemErro("ERRO ao remover o Fechamento de Caixa");
        }
    }

    //MOSTRAR TODOS OS DADOS DO FECHAMENTO DE CAIXA
    public List<FechamentosCaixa> listaFechamentoCaixa(Usuario usuarios) {
        try {
            List<FechamentosCaixa> lista = new ArrayList<>();
            String sql = "SELECT descricao, SUM(valor) AS valorTotal FROM fechamentoCaixa WHERE usuario = ? GROUP BY descricao";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, usuarios.getId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                FechamentosCaixa caixa = new FechamentosCaixa();
                caixa.setDescricao(rs.getString("descricao"));
                caixa.setValor(rs.getDouble("valorTotal"));

                lista.add(caixa);
            }
            return lista;

        } catch (SQLException e) {
            Mensagens.mensagemErro("ERRO ao acessar o Fechamento de Caixa no Banco de Dados");
            return null;
        }
    }

}
