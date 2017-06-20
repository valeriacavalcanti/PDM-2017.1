package br.edu.ifpb.si.pdm.arrocha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tvMenor, tvMaior;
    private Button btChutar;
    private EditText etChute;
    private Arrocha jogo;

    public MainActivity(){
        this.jogo = new Arrocha();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tvMenor = (TextView) findViewById(R.id.tvMenor);
        this.tvMaior = (TextView) findViewById(R.id.tvMaior);
        this.btChutar = (Button) findViewById(R.id.btChutar);
        this.etChute = (EditText) findViewById(R.id.etChute);

        this.btChutar.setOnClickListener(new BotaoListener());

        this.atualizaInterface();
    }

    private void atualizaInterface(){
        this.etChute.setText("");
        this.tvMenor.setText(Integer.toString(this.jogo.getMenor()));
        this.tvMaior.setText(Integer.toString(this.jogo.getMaior()));
        Log.i("FOFO", MainActivity.this.jogo.toString());
    }

    private class BotaoListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {

            int chute = Integer.parseInt(MainActivity.this.etChute.getText().toString());
            try{
                MainActivity.this.jogo.jogar(chute);
            }catch(RuntimeException re){
                MainActivity.this.jogo = new Arrocha();
                Toast.makeText(MainActivity.this, re.getMessage(), Toast.LENGTH_SHORT).show();
            }
            MainActivity.this.atualizaInterface();
        }
    }
}