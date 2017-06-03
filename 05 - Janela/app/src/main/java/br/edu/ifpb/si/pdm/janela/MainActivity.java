package br.edu.ifpb.si.pdm.janela;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button btFilha;
    private static final int FILHA = 1;
    private ImageView image;

    public MainActivity(){
        Log.i("FOFO", "MainActivity - Construtor");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("FOFO", "MainActivity - onCreate");

        this.btFilha = (Button) findViewById(R.id.btFilha);
        this.btFilha.setOnClickListener(new BotaoClickListener());

        this.image = (ImageView) findViewById(R.id.ivImagem);
        //this.image.setBackgroundResource(R.drawable.ifpb);
    }

    private class BotaoClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent it = new Intent(MainActivity.this, FilhaActivity.class);
            it.putExtra("FOFO", "Funciona!");

            //startActivity(it);
            startActivityForResult(it, FILHA);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.i("FOFO", "MainActivity - onActivityResult");

        if (resultCode == RESULT_OK){
            if (requestCode == FILHA){
                Log.i("JANELA", data.getStringExtra("WALTER"));
            }else
                Log.i("JANELA", "Alguém (não foi Filha) trouxe informação");
        }else
            Log.i("JANELA", "Foi cancelado");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i("FOFO", "MainActivity - onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("FOFO", "MainActivity - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("FOFO", "MainActivity - onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("FOFO", "MainActivity - onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("FOFO", "MainActivity - onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("FOFO", "MainActivity - onDestroy");
    }
}
