package vinho;

import java.time.LocalDate;

public class Vinho {
 
    private String idProduto;
    private float valor;
    private String descricao;
    private String tipoDaUva;
    private int anoDaSafra;
    private int quantidade;
    private LocalDate diaDaVenda;

    public Vinho(String idProduto, float valor, String descricao, String tipoDaUva, int anoDaSafra, int quantidade, LocalDate diaDaVenda) {
        this.idProduto = idProduto;
        this.valor = valor;
        this.descricao = descricao;
        this.tipoDaUva = tipoDaUva;
        this.anoDaSafra = anoDaSafra;
        this.quantidade = quantidade;
        this.diaDaVenda = diaDaVenda;
    }
    
    public Vinho() {
        this.idProduto = "";
        this.valor = 0;
        this.descricao = "";
        this.tipoDaUva = "";
        this.anoDaSafra = 0;
        this.quantidade = 0;
        this.diaDaVenda = LocalDate.of(0000, 0,0);
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoDaUva() {
        return tipoDaUva;
    }

    public void setTipoDaUva(String tipoDaUva) {
        this.tipoDaUva = tipoDaUva;
    }

    public int getAnoDaSafra() {
        return anoDaSafra;
    }

    public void setAnoDaSafra(int anoDaSafra) {
        this.anoDaSafra = anoDaSafra;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getDiaDaVenda() {
        return diaDaVenda;
    }

    public void setDiaDaVenda(LocalDate diaDaVenda) {
        this.diaDaVenda = diaDaVenda;
    }

    @Override
    public String toString() {
        return "idProduto=" + idProduto + ", valor=" + valor + ", descricao=" + descricao + ", tipoDaUva=" + tipoDaUva + ", anoDaSafra=" + anoDaSafra + ", quantidade=" + quantidade + ", diaDaVenda=" + diaDaVenda;
    }
    
    
    
    
    
}
