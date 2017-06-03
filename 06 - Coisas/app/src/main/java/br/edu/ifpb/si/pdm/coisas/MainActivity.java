package br.edu.ifpb.si.pdm.coisas;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btBrowser, btDiscar, btLigar, btEmail,
            btSMS, btCompartilhar, btPonto, btRota, btYoutube, btFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.botoes();
        this.setListenerBotoes();
    }

    private void botoes(){
        this.btBrowser = (Button) findViewById(R.id.btBrowser);
        this.btDiscar = (Button) findViewById(R.id.btDiscar);
        this.btLigar = (Button) findViewById(R.id.btLigar);
        this.btEmail = (Button) findViewById(R.id.btEmail);
        this.btSMS = (Button) findViewById(R.id.btSMS);
        this.btCompartilhar = (Button) findViewById(R.id.btCompartilhar);
        this.btPonto = (Button) findViewById(R.id.btVisualizarPonto);
        this.btRota = (Button) findViewById(R.id.btVisualizarRota);
        this.btYoutube = (Button) findViewById(R.id.btYoutube);
        this.btFoto = (Button) findViewById(R.id.btFoto);
    }

    private void setListenerBotoes(){
        this.btBrowser.setOnClickListener(new OnClickBotao());
        this.btDiscar.setOnClickListener(new OnClickBotao());
        this.btLigar.setOnClickListener(new OnClickBotao());
        this.btEmail.setOnClickListener(new OnClickBotao());
        this.btSMS.setOnClickListener(new OnClickBotao());
        this.btCompartilhar.setOnClickListener(new OnClickBotao());
        this.btPonto.setOnClickListener(new OnClickBotao());
        this.btRota.setOnClickListener(new OnClickBotao());
        this.btYoutube.setOnClickListener(new OnClickBotao());
        this.btFoto.setOnClickListener(new OnClickBotao());

    }

    private class OnClickBotao implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if (v.equals(MainActivity.this.btBrowser)){
                Log.i("FOFO", "Browser");
                Uri uri = Uri.parse("http://pdm.valeriacavalcanti.com.br");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
            }else if (v.equals(MainActivity.this.btDiscar)){
                Log.i("FOFO", "Discar");
            }else if (v.equals(MainActivity.this.btLigar)){
                Log.i("FOFO", "Ligar");
            }else if (v.equals(MainActivity.this.btEmail)){
                Log.i("FOFO", "e-mail");
            }else if (v.equals(MainActivity.this.btSMS)){
                Log.i("FOFO", "SMS");
            }else if (v.equals(MainActivity.this.btCompartilhar)){
                Log.i("FOFO", "Compartilhar Texto");
            }else if (v.equals(MainActivity.this.btPonto)){
                Log.i("FOFO", "Visualizar Ponto");
            }else if (v.equals(MainActivity.this.btRota)){
                Log.i("FOFO", "Visualizar Rota");
            }else if (v.equals(MainActivity.this.btYoutube)){
                Log.i("FOFO", "Youtube");
            }else{
                Log.i("FOFO", "Foto");
            }
        }
    }
}
