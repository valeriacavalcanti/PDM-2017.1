package br.edu.ifpb.si.pdm.palavras;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;

/**
 * MainActivity
 * - Add funcionalidades:
 *      onclick: editar
 *      onlongclick: excluir
 *
 *  Para: Segunda (17/07/2017)
 * */

public class MainActivity extends AppCompatActivity {
    private EditText etPalavra;
    private ListView listView;
    private PalavraDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.dao = new PalavraDAO(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new ClickBotao());

        this.listView = (ListView) findViewById(R.id.listView);
        PalavraAdapter adapter = new PalavraAdapter(this, this.dao);
        this.listView.setAdapter(adapter);

        this.listView.setOnItemClickListener(new ClickItemLista());
        this.listView.setOnItemLongClickListener(new ClickLongItemLista());
    }

    private void atualizaLista(){
        ((BaseAdapter)this.listView.getAdapter()).notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class ClickBotao implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            MainActivity.this.etPalavra = new EditText(MainActivity.this);

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Nova Palavra");
            builder.setMessage("Informe a nova palavra");
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Log.i("APP_PALAVRAS", MainActivity.this.etPalavra.getText().toString());
                    Palavra p = new Palavra(MainActivity.this.etPalavra.getText().toString());
                    MainActivity.this.dao.insert(p);
                    Log.i("APP_PALAVRAS", MainActivity.this.dao.get().toString());
                    MainActivity.this.atualizaLista();
                }
            });
            builder.setNegativeButton("Cancelar", null);
            builder.setView(MainActivity.this.etPalavra);
            builder.create().show();
        }
    }

    private class ClickItemLista implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            MainActivity.this.etPalavra = new EditText(MainActivity.this);
            final Palavra p = MainActivity.this.dao.get(position);
            MainActivity.this.etPalavra.setText(p.getConteudo());

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Editar Palavra");
            builder.setMessage("Palavra");
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Palavra nova = new Palavra(MainActivity.this.etPalavra.getText().toString());
                    MainActivity.this.dao.update(p, nova);
                    MainActivity.this.atualizaLista();
                }
            });
            builder.setNegativeButton("Cancelar", null);
            builder.setView(MainActivity.this.etPalavra);
            builder.create().show();
        }
    }

    private class ClickLongItemLista implements AdapterView.OnItemLongClickListener{
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            final Palavra p = MainActivity.this.dao.get(position);

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Excluir Palavra");
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setMessage(String.format("Deseja excluir '%s'", p.getConteudo()));
            builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    MainActivity.this.dao.delete(p);
                    MainActivity.this.atualizaLista();
                }
            });
            builder.setNegativeButton("Não", null);
            builder.create().show();

            return true;
        }
    }
}
