package model;

import java.time.LocalDate;

public class RelatorioVenda {

    private int id;
    private LocalDate data;
    private String vendedor;
    private double vendaTotal;
    private String cpfCliente;
    private String pagamento;
    private double pagamentoTotal;

    public RelatorioVenda(int id, LocalDate data, String vendedor, double vendaTotal, String cpfCliente, String pagamento, double pagamentoTotal) {
        this.id = id;
        this.data = data;
        this.vendedor = vendedor;
        this.vendaTotal = vendaTotal;
        this.cpfCliente = cpfCliente;
        this.pagamento = pagamento;
        this.pagamentoTotal = pagamentoTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public double getVendaTotal() {
        return vendaTotal;
    }

    public void setVendaTotal(double vendaTotal) {
        this.vendaTotal = vendaTotal;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public double getPagamentoTotal() {
        return pagamentoTotal;
    }

    public void setPagamentoTotal(double pagamentoTotal) {
        this.pagamentoTotal = pagamentoTotal;
    }

}
