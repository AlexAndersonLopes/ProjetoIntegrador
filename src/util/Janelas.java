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
import view.relatorios.CarrinhoVenda;
import view.relatorios.MenuRelatorios;
import view.relatorios.RelatorioVendas;

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
    private static MenuRelatorios menuRelatorios;
    private static RelatorioVendas relatorioVendas;
    private CarrinhoVenda car;

    private final DecimalFormat df = new DecimalFormat("#.##");

    public void irVenda1(String nome) {
        if (venda != null) {
            venda.dispose();
        }
        venda = new Venda(nome);
        venda.setTitle("Venda");
        venda.setExtendedState(JFrame.MAXIMIZED_BOTH);
        venda.setVisible(true);
        venda.pack();
    }

    public void irVenda2(String nome, String codigo) {
        if (venda == null) {
            venda = new Venda(nome, codigo);
            venda.setTitle("Venda");
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
        venda.setTitle("Venda");
        venda.setExtendedState(JFrame.MAXIMIZED_BOTH);
        venda.setVisible(true);
        venda.pack();
    }

    public void irCadastrarProduto() {
        if (cadastrar == null) {
            cadastrar = new CadastrarProduto();
            cadastrar.setTitle("Cadastro de Estoque de Produtos");
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
        pesquisar.setTitle("Pesquisar Preço");
        pesquisar.setLocationRelativeTo(null);
        pesquisar.setVisible(true);
        pesquisar.pack();
        pesquisar.setState(JFrame.NORMAL);
        pesquisar.setVisible(true);
    }

    public void irAlterarProduto() {
        if (alterar == null) {
            alterar = new AlterarProduto();
            alterar.setTitle("Alterar Produtos");
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
        pag.setTitle("Pagamento");
        pag.setExtendedState(JFrame.MAXIMIZED_BOTH);
        pag.setVisible(true);
        pag.pack();
    }

    public void irMenuPrincipal(String nome) {
        if (menu == null) {
            menu = new MenuPrincipal(nome);
            menu.setTitle("Menu Principal - Sistema de Vendas");
            menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
            menu.setVisible(true);
        } else {
            menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
            menu.setVisible(true);
        }
    }

    public void irLogin() {
        login = new Login();
        login.setTitle("Login de Usuário");
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        login.pack();
    }

    public void irEntrar() {
        entrar = new Entrar();
        entrar.setTitle("Login de Usuário");
        entrar.setLocationRelativeTo(null);
        entrar.setVisible(true);
        entrar.pack();
    }

    public void irCadastro() {
        cadastro = new Cadastro();
        cadastro.setTitle("Cadastro de Usuário");
        cadastro.setLocationRelativeTo(null);
        cadastro.setVisible(true);
        cadastro.pack();
    }

    public void irFechamentoCaixa(String nome) {
        caixa = new FechamentoCaixa(nome);
        caixa.setTitle("Fechamento de Caixa");
        caixa.setLocationRelativeTo(null);
        caixa.setVisible(true);
        caixa.pack();
    }
    
    public void irMenuRelatorios(){
        menuRelatorios = new MenuRelatorios();
        menuRelatorios.setTitle("Menu de Relatorios");
        menuRelatorios.setLocationRelativeTo(null);
        menuRelatorios.setVisible(true);
        menuRelatorios.pack();
    }
    
    public void irRelatorioVendas(){
        relatorioVendas = new RelatorioVendas();
        relatorioVendas.setTitle("Relatorio de Vendas");
        relatorioVendas.setExtendedState(JFrame.MAXIMIZED_BOTH);
        relatorioVendas.setVisible(true);
        relatorioVendas.pack();
    }
    
    public void irCarrinhoVenda(int id){
        car = new CarrinhoVenda(id);
        car.setTitle("Registro de Produtos Vendido por Venda");
        car.setLocationRelativeTo(null);
        car.setVisible(true);
        car.pack();
    }
        

}
