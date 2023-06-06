package util;

import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import view.login.Cadastro;
import view.login.Entrar;
import view.login.Login;
import view.programa.AlterarProduto;
import view.programa.CadastrarProduto;
import view.programa.Devolucao;
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
    private Devolucao devolucao;

    private final DecimalFormat df = new DecimalFormat("#.##");

    public void irVenda1(String nome) {
        if (venda != null) {
            venda.dispose();
        }
        venda = new Venda(nome);
        venda.setTitle("Venda");
        venda.pack();
        venda.setExtendedState(JFrame.MAXIMIZED_BOTH);
        venda.setVisible(true);
    }

    public void irVenda2(String nome, String codigo) {
        if (venda == null) {
            venda = new Venda(nome, codigo);
            venda.setTitle("Venda");
            venda.pack();
            venda.setExtendedState(JFrame.MAXIMIZED_BOTH);
            venda.setVisible(true);           
        } else {
            venda.setExtendedState(JFrame.MAXIMIZED_BOTH);
            venda.atualizarCarrinho(nome, codigo);
        }
    }

    public void irVenda3(String nome) {
        venda.dispose();
        venda = new Venda(nome);
        venda.setTitle("Venda");
        venda.pack();
        venda.setExtendedState(JFrame.MAXIMIZED_BOTH);
        venda.setVisible(true);
    }

    public void irCadastrarProduto() {
        if (cadastrar == null) {
            cadastrar = new CadastrarProduto();
            cadastrar.setTitle("Cadastro de Estoque de Produtos");
            cadastrar.pack();
            cadastrar.setLocationRelativeTo(null);
            cadastrar.setVisible(true);           
        } else {
            cadastrar.setState(JFrame.NORMAL);
            cadastrar.setVisible(true);
        }
    }

    public void irPesquisarPreco(String nomes) {
        pesquisar = new PesquisarPreco(nomes);
        pesquisar.setTitle("Pesquisar Preço");
        pesquisar.pack();
        pesquisar.setLocationRelativeTo(null);        
        pesquisar.setVisible(true);
    }

    public void irAlterarProduto() {
        if (alterar == null) {
            alterar = new AlterarProduto();
            alterar.setTitle("Alterar Produtos");
            alterar.pack();
            alterar.setLocationRelativeTo(null);
            alterar.setVisible(true);           
        } else {
            alterar.setState(JFrame.NORMAL);
            alterar.setVisible(true);
        }
    }

    public void irPagamento(String nomes, double total, DefaultTableModel lista) {
        pag = new Pagamento(nomes, total, lista);
        pag.setTitle("Pagamento");
        pag.pack();
        pag.setExtendedState(JFrame.MAXIMIZED_BOTH);
        pag.setVisible(true);       
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
        login.pack();
        login.setLocationRelativeTo(null);
        login.setVisible(true);       
    }

    public void irEntrar() {
        entrar = new Entrar();
        entrar.setTitle("Login de Usuário");
        entrar.pack();
        entrar.setLocationRelativeTo(null);
        entrar.setVisible(true);       
    }

    public void irCadastro() {
        cadastro = new Cadastro();
        cadastro.setTitle("Cadastro de Usuário");
        cadastro.pack();
        cadastro.setLocationRelativeTo(null);
        cadastro.setVisible(true);       
    }

    public void irFechamentoCaixa(String nome) {
        caixa = new FechamentoCaixa(nome);
        caixa.setTitle("Fechamento de Caixa");
        caixa.pack();
        caixa.setLocationRelativeTo(null);
        caixa.setVisible(true);       
    }

    public void irMenuRelatorios() {
        menuRelatorios = new MenuRelatorios();
        menuRelatorios.setTitle("Menu de Relatorios");
        menuRelatorios.pack();
        menuRelatorios.setLocationRelativeTo(null);
        menuRelatorios.setVisible(true);        
    }

    public void irRelatorioVendas() {
        relatorioVendas = new RelatorioVendas();
        relatorioVendas.setTitle("Relatorio de Vendas");
        relatorioVendas.pack();
        relatorioVendas.setExtendedState(JFrame.MAXIMIZED_BOTH);
        relatorioVendas.setVisible(true);       
    }

    public void irCarrinhoVenda(int id) {
        car = new CarrinhoVenda(id);
        car.setTitle("Registro de Produtos Vendido por Venda");
        car.pack();
        car.setLocationRelativeTo(null);
        car.setVisible(true);        
    }
    
    public void irDevolucao(){
        devolucao = new Devolucao();
        devolucao.setTitle("Devolução");
        devolucao.pack();
        devolucao.setLocationRelativeTo(null);
        devolucao.setVisible(true);
    }

}
