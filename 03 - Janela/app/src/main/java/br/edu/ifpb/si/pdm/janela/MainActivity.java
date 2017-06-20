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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        if (resultCode == RESULT_OK){
            if (requestCode == FILHA){
                Log.i("JANELA", data.getStringExtra("WALTER"));
            }else
                Log.i("JANELA", "Alguém (não foi Filha) trouxe informação");
        }else
            Log.i("JANELA", "Foi cancelado");
    }
}
