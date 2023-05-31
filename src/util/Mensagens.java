package util;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Mensagens {

    public static void mensagemAlerta(String e) {
        String[] options = {"Fechar"};
        int selectedOption = JOptionPane.showOptionDialog(null, e, "Atenção",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
    }

    public static void mensagemErro(String e) {
        String[] options = {"Fechar"};
        int selectedOption = JOptionPane.showOptionDialog(null, e, "Erro",
                JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
    }

    public static void mensagemExito(String e) {
        String[] options = {"Fechar"};
        int selectedOption = JOptionPane.showOptionDialog(null, e, "Sucesso",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    }

}
