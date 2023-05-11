package util;

import java.text.DecimalFormat;
import javax.swing.JFrame;
import view.login.Cadastro;
import view.login.Entrar;
import view.login.Login;
import view.programa.AlterarProduto;
import view.programa.CadastrarProduto;
import view.programa.MenuPrincipal;
import view.programa.Pagamento;
import view.programa.PesquisarPreco;
import view.programa.Venda;

public class Janelas {

    private static Venda venda;
    private static CadastrarProduto cadastrar;
    private PesquisarPreco pesquisar;
    private static AlterarProduto alterar;
    private static Pagamento pag;
    private static MenuPrincipal menu;
    private static Login login;
    private static Entrar entrar;
    private static Cadastro cadastro;

    private DecimalFormat df = new DecimalFormat("#.##");

    public void irVenda1(String nome) {
        venda = new Venda(nome);
        venda.setExtendedState(JFrame.MAXIMIZED_BOTH);
        venda.setVisible(true);
        venda.pack();
    }

    public void irVenda2(String nome, String codigo) {
        if (venda == null) {
            venda = new Venda(nome, codigo);
            venda.setExtendedState(JFrame.MAXIMIZED_BOTH);
            venda.setVisible(true);
            venda.pack();
        } else {
            venda.setExtendedState(JFrame.MAXIMIZED_BOTH);
            venda.atualizarCarrinho(nome, codigo);
        }
    }

    public void irCadastrarProduto() {
        if (cadastrar == null) {
            cadastrar = new CadastrarProduto();
            cadastrar.setLocationRelativeTo(null);
            cadastrar.setVisible(true);
            cadastrar.pack();
        } else {
            cadastrar.setState(JFrame.NORMAL);
            cadastrar.setVisible(true);
        }
    }

    public void irPesquisarPreco(String nomes) {
            pesquisar = new PesquisarPreco(nomes);
            pesquisar.setLocationRelativeTo(null);
            pesquisar.setVisible(true);
            pesquisar.pack();
            pesquisar.setState(JFrame.NORMAL);
            pesquisar.setVisible(true);
    }

    public void irAlterarProduto() {
        if (alterar == null) {
            alterar = new AlterarProduto();
            alterar.setLocationRelativeTo(null);
            alterar.setVisible(true);
            alterar.pack();
        } else {
            alterar.setState(JFrame.NORMAL);
            alterar.setVisible(true);
        }
    }

    public void irPagamento(String nomes, double total) {
        if (pag == null) {
            pag = new Pagamento(nomes, total);
            pag.setExtendedState(JFrame.MAXIMIZED_BOTH);
            pag.setVisible(true);
            pag.pack();
        } else {
            pag.setExtendedState(JFrame.MAXIMIZED_BOTH);
            pag.setVisible(true);
        }
    }

    public void irMenuPrincipal(String nome) {
        if (menu == null) {
            menu = new MenuPrincipal(nome);
            menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
            menu.setVisible(true);
        } else {
            menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
            menu.setVisible(true);
        }
    }

    public void irLogin() {
        if (login == null) {
            login = new Login();
            login.setLocationRelativeTo(null);
            login.setVisible(true);
            login.pack();
        } else {
            login.setState(JFrame.NORMAL);
            login.setVisible(true);
        }
    }

    public void irEntrar() {
        if (login == null) {
            entrar = new Entrar();
            entrar.setLocationRelativeTo(null);
            entrar.setVisible(true);
            entrar.pack();
        } else {
            entrar.setState(JFrame.NORMAL);
            entrar.setVisible(true);
        }
    }

    public void irCadastro() {
        if (login == null) {
            cadastro = new Cadastro();
            cadastro.setLocationRelativeTo(null);
            cadastro.setVisible(true);
            cadastro.pack();
        } else {
            cadastro.setState(JFrame.NORMAL);
            cadastro.setVisible(true);
        }
    }

}
