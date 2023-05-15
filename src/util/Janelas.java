package util;

import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import view.login.Cadastro;
import view.login.Entrar;
import view.login.Login;
import view.programa.AlterarProduto;
import view.programa.CadastrarProduto;
import view.programa.FechamentoCaixa;
import view.programa.MenuPrincipal;
import view.programa.Pagamento;
import view.programa.PesquisarPreco;
import view.programa.Venda;

public class Janelas {

    private static Venda venda;
    private static CadastrarProduto cadastrar;
    private PesquisarPreco pesquisar;
    private static AlterarProduto alterar;
    private Pagamento pag;
    private static MenuPrincipal menu;
    private Login login;
    private Entrar entrar;
    private Cadastro cadastro;
    private static FechamentoCaixa caixa;
    

    private DecimalFormat df = new DecimalFormat("#.##");

    public void irVenda1(String nome) {
        if (venda != null) {
            venda.dispose();
        }
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

    public void irVenda3(String nome) {
        venda.dispose();
        venda = new Venda(nome);
        venda.setExtendedState(JFrame.MAXIMIZED_BOTH);
        venda.setVisible(true);
        venda.pack();
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

    public void irPagamento(String nomes, double total, DefaultTableModel lista) {
        pag = new Pagamento(nomes, total, lista);
        pag.setExtendedState(JFrame.MAXIMIZED_BOTH);
        pag.setVisible(true);
        pag.pack();
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
        login = new Login();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        login.pack();
    }

    public void irEntrar() {
        entrar = new Entrar();
        entrar.setLocationRelativeTo(null);
        entrar.setVisible(true);
        entrar.pack();
    }

    public void irCadastro() {
        cadastro = new Cadastro();
        cadastro.setLocationRelativeTo(null);
        cadastro.setVisible(true);
        cadastro.pack();
    }

    public void irFechamentoCaixa(String nome) {
        caixa = new FechamentoCaixa(nome);
        caixa.setLocationRelativeTo(null);
        caixa.setVisible(true);
        caixa.pack();
    }

}
