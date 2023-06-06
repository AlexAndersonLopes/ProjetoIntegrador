package dao;

import java.math.BigDecimal;
import jdbc.ConnectFactory;
import java.sql.PreparedStatement;
import model.RelatorioVenda;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import util.Mensagens;

public class RelatoriosDAO {

    private Connection con;

    public RelatoriosDAO() {
        this.con = new ConnectFactory().getConnection();
    }

    public List<RelatorioVenda> mostrarDadosVenda(LocalDate dataInicial, LocalDate dataFinal, String usuario, String tipoPagamento) {
        try {
            String sql = "SELECT v.id AS VENDA_ID, v.data AS DATA, u.nome AS VENDEDOR, v.total AS VENDA_TOTAL, v.cpf AS CPF_CLIENTE, "
                    + "p.descricao AS PAGAMENTO, p.valor AS PAG_TOTAL "
                    + "FROM cadVendas v "
                    + "INNER JOIN cadUsuarios u ON u.id = v.cadUsuarios "
                    + "INNER JOIN pagamento p ON p.cadVendas = v.id ";

            if (dataInicial != null) {
                sql += "WHERE v.data BETWEEN ? AND ?";
            } else {
                sql += "WHERE v.data <= ?";
            }

            if (!usuario.equalsIgnoreCase("Todos")) {
                sql += " AND u.nome = ?";
            }

            if (!tipoPagamento.equalsIgnoreCase("Todos")) {
                sql += " AND p.descricao = ?";
            }

            PreparedStatement ps = con.prepareStatement(sql);
            int parameterIndex = 1;

            if (dataInicial != null) {
                ps.setDate(parameterIndex++, java.sql.Date.valueOf(dataInicial));
                ps.setDate(parameterIndex++, java.sql.Date.valueOf(dataFinal));
            } else {
                ps.setDate(parameterIndex++, java.sql.Date.valueOf(dataFinal));
            }

            if (!usuario.equalsIgnoreCase("Todos")) {
                ps.setString(parameterIndex++, usuario);
            }

            if (!tipoPagamento.equalsIgnoreCase("Todos")) {
                ps.setString(parameterIndex++, tipoPagamento);
            }

            ResultSet resultSet = ps.executeQuery();

            List<RelatorioVenda> lista = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("VENDA_ID");
                LocalDate data = resultSet.getDate("DATA").toLocalDate();
                String vendedor = resultSet.getString("VENDEDOR");
                double vendaTotal = resultSet.getDouble("VENDA_TOTAL");
                String cpfCliente = resultSet.getString("CPF_CLIENTE");
                String pagamento = resultSet.getString("PAGAMENTO");
                double pagamentoTotal = resultSet.getDouble("PAG_TOTAL");

                RelatorioVenda vendaDetalhada = new RelatorioVenda(id, data, vendedor, vendaTotal, cpfCliente, pagamento, pagamentoTotal);
                lista.add(vendaDetalhada);
            }
            return lista;
        } catch (SQLException e) {
            Mensagens.mensagemErro("Erro ao fazer a busca no Banco de Dados");
            return null;
        }
    }


    public BigDecimal obterTotalVenda(LocalDate dataInicial, LocalDate dataFinal, String usuario, String tipoPagamento) {
    try {
        String sql = "SELECT p.descricao, SUM(p.valor) AS TOTAL_PAGAMENTOS "
                + "FROM cadVendas v "
                + "INNER JOIN pagamento p ON p.cadVendas = v.id "
                + "INNER JOIN cadUsuarios u ON u.id = v.cadUsuarios "
                + "WHERE ";

        if (dataInicial != null) {
            sql += "v.data BETWEEN ? AND ? ";
        } else {
            sql += "v.data <= ? ";
        }

        if (!usuario.equalsIgnoreCase("Todos")) {
            sql += "AND u.nome = ? ";
        }

        if (!tipoPagamento.equalsIgnoreCase("Todos")) {
            sql += "AND p.descricao = ? ";
        }

        sql += "GROUP BY p.descricao";

        PreparedStatement ps = con.prepareStatement(sql);
        int parameterIndex = 1;

        if (dataInicial != null) {
            ps.setDate(parameterIndex++, java.sql.Date.valueOf(dataInicial));
            ps.setDate(parameterIndex++, java.sql.Date.valueOf(dataFinal));
        } else {
            ps.setDate(parameterIndex++, java.sql.Date.valueOf(dataFinal));
        }

        if (!usuario.equalsIgnoreCase("Todos")) {
            ps.setString(parameterIndex++, usuario);
        }

        if (!tipoPagamento.equalsIgnoreCase("Todos")) {
            ps.setString(parameterIndex++, tipoPagamento);
        }

        ResultSet resultSet = ps.executeQuery();

        BigDecimal totalPagamentos = BigDecimal.ZERO;

        while (resultSet.next()) {
            BigDecimal pagamentoVenda = resultSet.getBigDecimal("TOTAL_PAGAMENTOS");
            totalPagamentos = totalPagamentos.add(pagamentoVenda);
        }

        return totalPagamentos;
    } catch (SQLException e) {
        System.out.println("Erro ao obter o total dos pagamentos: " + e.getMessage());
        return BigDecimal.ZERO;
    }
}


    
    public BigDecimal obterTotalPagamentos(LocalDate dataInicial, LocalDate dataFinal, String usuario, String tipoPagamento) {
    try {
        String sql = "SELECT SUM(vp.subttotal) AS TOTAL_VENDA " +
                     "FROM cadVendas v " +
                     "INNER JOIN vendaProdutos vp ON vp.cadVendas = v.id " +
                     "INNER JOIN cadUsuarios u ON u.id = v.cadUsuarios " +
                     "WHERE ";

        if (dataInicial != null) {
            sql += "v.data BETWEEN ? AND ? ";
        } else {
            sql += "v.data <= ? ";
        }

        if (!usuario.equalsIgnoreCase("Todos")) {
            sql += "AND u.nome = ? ";
        }

        if (!tipoPagamento.equalsIgnoreCase("Todos")) {
            sql += "AND v.id IN (SELECT cadVendas FROM pagamento WHERE descricao = ?) ";
        }

        PreparedStatement ps = con.prepareStatement(sql);
        int parameterIndex = 1;

        if (dataInicial != null) {
            ps.setDate(parameterIndex++, java.sql.Date.valueOf(dataInicial));
            ps.setDate(parameterIndex++, java.sql.Date.valueOf(dataFinal));
        } else {
            ps.setDate(parameterIndex++, java.sql.Date.valueOf(dataFinal));
        }

        if (!usuario.equalsIgnoreCase("Todos")) {
            ps.setString(parameterIndex++, usuario);
        }

        if (!tipoPagamento.equalsIgnoreCase("Todos")) {
            ps.setString(parameterIndex++, tipoPagamento);
        }

        ResultSet resultSet = ps.executeQuery();

        BigDecimal totalVenda = BigDecimal.ZERO;

        if (resultSet.next()) {
            totalVenda = resultSet.getBigDecimal("TOTAL_VENDA");
        }

        return totalVenda;
    } catch (SQLException e) {
        System.out.println("Erro ao fazer a busca no Banco de Dados: " + e.getMessage());
        return BigDecimal.ZERO;
    }
}

}
