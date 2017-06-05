package br.edu.ifpb.si.pdm.milho;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 05/06/17.
 */

public class Cadastro {
    private List<Gasto> gastos;

    public Cadastro(){
        this.gastos = new ArrayList<Gasto>();
    }

    public void add(Gasto gasto){
        this.gastos.add(gasto);
    }

    public float getTotal(){
        float soma = 0;
        for (Gasto g: this.gastos) {
            soma += g.getTotal();
        }
        return soma;
    }
}
