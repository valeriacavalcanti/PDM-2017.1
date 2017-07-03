package br.edu.ifpb.si.pdm.canivete;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tvNome = (TextView) findViewById(R.id.tvNome);

        Intent it = getIntent();
        String nome = it.getStringExtra("NOME");

        this.tvNome.setText(nome);
    }
}
