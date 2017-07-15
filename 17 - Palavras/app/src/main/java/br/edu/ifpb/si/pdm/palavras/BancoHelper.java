package br.edu.ifpb.si.pdm.palavras;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by admin on 15/07/17.
 */

public class BancoHelper extends SQLiteOpenHelper{
    public static final String BANCO = "bd_palavra";
    public static final String TABELA = "palavra";
    public static final int VERSAO = 1;

    public BancoHelper(Context context) {
        super(context, BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS palavra(codigo INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, conteudo VARCHAR, datahora DATETIME);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
