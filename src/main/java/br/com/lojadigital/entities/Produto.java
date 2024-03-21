package br.com.lojadigital.entities;

import java.math.BigDecimal;

public class Produto {
    private int idP;
    private String nomeP;
    private String descricaoP;
    private BigDecimal preco;
    private int quantidadeEstoque;

    public Produto(int idP, String nomeP, String descricaoP, BigDecimal preco, int quantidadeEstoque) {
        this.idP = idP;
        this.nomeP = nomeP;
        this.descricaoP = descricaoP;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getNomeP() {
        return nomeP;
    }

    public void setNomeP(String nomeP) {
        this.nomeP = nomeP;
    }

    public String getDescricaoP() {
        return descricaoP;
    }

    public void setDescricaoP(String descricaoP) {
        this.descricaoP = descricaoP;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Produto produto = (Produto) obj;
        return idP == produto.idP;
    }

    @Override
    public int hashCode() {
        return idP;
    }

    @Override
    public String toString() {
        return "Produto {" +
                "idP=" + idP + '\'' +
                ", nomeP=" + nomeP + '\'' +
                ", descricaoP=" + descricaoP + '\'' +
                ", preco=" + preco + '\'' +
                ", quantidadeEstoque=" + quantidadeEstoque + '\'' +
                "}";
    }
}
