package projetointegrador;

import view.login.Login;

public class Main {

    public static void main(String[] args) {
            
        Login login = new Login();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        login.pack();
    }
    
}
