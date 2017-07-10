package br.edu.ifpb.si.pdm.monitorador;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Criar receiver para:
 * - Explorar as notificações broadcast do android.
 *  Pesquise e implemente o máximo que conseguir de notificações.
 *
 * */

public class MainActivity extends AppCompatActivity {
    private CarregadorReceiver carregadorReceiver;
    private IntentFilter intentFilter;
    private ListView listView;
    private List<String> lista;

    public MainActivity(){
        this.lista = new ArrayList<String>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.carregadorReceiver = new CarregadorReceiver();
        this.intentFilter = new IntentFilter();
        this.intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        this.intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);

        this.listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        this.listView.setAdapter(adapter);
    }

    private void atualizaLista(){
        ((ArrayAdapter)this.listView.getAdapter()).notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.registerReceiver(this.carregadorReceiver, this.intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.unregisterReceiver(this.carregadorReceiver);
    }

    private class CarregadorReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            MainActivity.this.lista.add(intent.getAction());
            MainActivity.this.atualizaLista();
        }
    }
}
