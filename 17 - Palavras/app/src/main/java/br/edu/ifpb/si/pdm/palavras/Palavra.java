package br.edu.ifpb.si.pdm.palavras;

import java.util.Calendar;

/**
 * Created by admin on 15/07/17.
 */

public class Palavra {
    private int id;
    private String conteudo;
    private Calendar dataHora;

    public Palavra(){}

    public Palavra(String conteudo){
        this.conteudo = conteudo;
        this.dataHora = Calendar.getInstance();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    private String getData(){
        return String.format("%d/%d/%d", dataHora.get(Calendar.DAY_OF_MONTH),
                                         dataHora.get(Calendar.MONTH) + 1,
                                         dataHora.get(Calendar.YEAR));
    }

    private String getHora(){
        return String.format("%d:%d:%d", dataHora.get(Calendar.HOUR_OF_DAY),
                                         dataHora.get(Calendar.MINUTE),
                                         dataHora.get(Calendar.SECOND));
    }

    public String getDataHora(){
        return String.format("%s - %sh", this.getData(), this.getHora());
    }

    public long getDataHoraLong(){
        return this.dataHora.getTimeInMillis();
    }

    public void setDataHoraLong(long tempo){
        this.dataHora = Calendar.getInstance();
        this.dataHora.setTimeInMillis(tempo);
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.conteudo, this.getDataHora());
    }
}
