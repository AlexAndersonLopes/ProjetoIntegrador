package model;

import java.util.Date;

public class Vendas {
    
    private int id;
    private Date data;
    private double total;
    private Usuario usuario;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
  
    
}
