package br.edu.ifpb.si.pdm.milho;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * TAREFAS PARA 26/06 - segunda
 * SEM FALTA !!!!
 *
 * LongPress - Excluir, antes apresentando uma janela popup de confirmação.
 * Cada gasto registre a data (data e hora) que foi cadastrado
 * Opções de Ordenação no Menu: descrição, quantidade, valor unitário, valor total e data.
 * Imagem: Foto do item ou android
 */


public class MainActivity extends AppCompatActivity {
    private static final int FORMULARIO_INSERIR = 1, FORMULARIO_EDITAR = 2;
    private Cadastro cadastro;
    private ListView lvGastos;

    public MainActivity(){
        this.cadastro = new Cadastro();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new BotaoClickListener());

//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Adicionar novo item?", Snackbar.LENGTH_LONG)
//                        .setAction("Sim", new BotaoClickListener()).show();
//            }
//        });

        this.lvGastos = (ListView) findViewById(R.id.lvMainGastos);

        //ArrayAdapter<Gasto> adapter = new ArrayAdapter<Gasto>(this, android.R.layout.simple_list_item_1, this.cadastro.getLista());
        GastoAdapter adapter = new GastoAdapter(this, this.cadastro);
        this.lvGastos.setAdapter(adapter);

        this.lvGastos.setOnItemClickListener(new ListaClickListener());
        this.lvGastos.setOnItemLongClickListener(new ListaLongClickListener());
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
        if (id == R.id.action_orcamento) {
            String msg = String.format("Total: R$ %.2f", this.cadastro.getTotal());
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }else if (id == R.id.action_sobre){
            Toast.makeText(this, "Valéria Cavalcanti", Toast.LENGTH_SHORT).show();
        }else if (id == R.id.action_zerar){
            this.cadastro.clear();
            this.atualizaLista();
        }

        return super.onOptionsItemSelected(item);
    }

    public void atualizaLista(){
        this.cadastro.sort();
        ((BaseAdapter)this.lvGastos.getAdapter()).notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            if (requestCode == FORMULARIO_INSERIR){
                Gasto g = (Gasto) data.getSerializableExtra("GASTO");
                this.cadastro.add(g);
                this.atualizaLista();
                Log.i("MILHO", String.format("Qtde = %d", cadastro.getQuantidade()));
            }else if (requestCode == FORMULARIO_EDITAR) {
                int pos = data.getIntExtra("POSICAO", -1);
                try {
                    // alteracao
                    Gasto gAlterado = (Gasto) data.getSerializableExtra("GASTO");
                    Gasto gOriginal = MainActivity.this.cadastro.get(pos);
                    gOriginal.setDescricao(gAlterado.getDescricao());
                    gOriginal.setQuantidade(gAlterado.getQuantidade());
                    gOriginal.setValor(gAlterado.getValor());
                } catch (Exception e) {
                    // exclusao
                    this.cadastro.excluir(pos);
                }
                this.atualizaLista();
            }
        }
    }

    private class BotaoClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent it = new Intent(MainActivity.this, FormularioActivity.class);
            startActivityForResult(it, FORMULARIO_INSERIR);
        }
    }

    private class ListaClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Gasto g = MainActivity.this.cadastro.get(position);
            Intent it = new Intent(MainActivity.this, FormularioActivity.class);
            it.putExtra("GASTO", g);
            it.putExtra("POSICAO", position);
            startActivityForResult(it, FORMULARIO_EDITAR);
            Log.i("MILHO", g.toString());
        }
    }

    private class ListaLongClickListener implements AdapterView.OnItemLongClickListener{
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            Gasto g = MainActivity.this.cadastro.get(position);
            String msg = String.format("Total: R$ %.2f", g.getTotal());
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            return true;
        }
    }
}
