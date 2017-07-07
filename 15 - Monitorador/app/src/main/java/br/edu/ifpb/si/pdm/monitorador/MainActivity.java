package br.edu.ifpb.si.pdm.monitorador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 *
 * Criar receiver para:
 * - perceber que o dispositivo recebeu uma ligação
 * - perceber que a tela foi desbloqueada
 *
 * */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
