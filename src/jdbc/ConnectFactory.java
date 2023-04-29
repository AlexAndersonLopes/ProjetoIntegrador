package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectFactory {
    
    public Connection getConnection(){
        
        try {
           //Conectar no Banco de Dados Usuario e definir o usuario para acessar o BD
          return DriverManager.getConnection("jdbc:mysql://34.95.190.240/programaProjetoIntegrador","root","G#e\\{;#juN'B4sSy");
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
