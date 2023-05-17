package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import util.Mensagens;

public class ConnectFactory {

    public Connection getConnection() {

        try {
            //return DriverManager.getConnection("jdbc:mysql://34.95.190.240/programaProjetoIntegrador","root","G#e\\{;#juN'B4sSy");        
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/PI_SistemaVendas", "root", "123456");

            /* Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://34.95.190.240/programaProjetoIntegrador";
            String user = "Alex";
            String password = "123";
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;*/
        } catch (SQLException e) {
            Mensagens.mensagemErro("Erro ao tentar conectar no Banco de Dados!");
            return null;
        }
    }

}
