package br.edu.ifpb.si.pdm.milho;

import java.io.Serializable;

/**
 * Created by admin on 05/06/17.
 */

public class Gasto implements Serializable{
    private String descricao;
    private int quantidade;
    private float valor;

    public Gasto(String descricao, int quantidade, float valor){
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getTotal(){
        return this.valor * this.quantidade;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
