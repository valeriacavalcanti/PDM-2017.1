package br.edu.ifpb.si.pdm.palavras;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 15/07/17.
 */

public class PalavraDAO {
    private SQLiteDatabase banco;

    public PalavraDAO(Context context){
        this.banco = new BancoHelper(context).getWritableDatabase();
    }

    public void insert(Palavra nova){
        ContentValues cv = new ContentValues();
        cv.put("conteudo", nova.getConteudo());
        cv.put("datahora", nova.getDataHoraLong());
        this.banco.insert(BancoHelper.TABELA, null, cv);
    }

    public Palavra get(int index){
        return null;
    }

    public List<Palavra> get(){
        List<Palavra> lista = new ArrayList<Palavra>();
        String[] colunas = {"codigo", "conteudo", "datahora"};
        Cursor c = this.banco.query(BancoHelper.TABELA, colunas, null, null, null, null, null);
        Palavra p;

        if (c.getCount() > 0){
            c.moveToFirst();
            do{
                p = new Palavra();
                p.setId(c.getInt(c.getColumnIndex("codigo")));
                p.setConteudo(c.getString(c.getColumnIndex("conteudo")));
                p.setDataHoraLong(c.getLong(c.getColumnIndex("datahora")));
                lista.add(p);
            }while(c.moveToNext());
        }

        return lista;
    }

    public int size(){
        return 0;
    }
}
