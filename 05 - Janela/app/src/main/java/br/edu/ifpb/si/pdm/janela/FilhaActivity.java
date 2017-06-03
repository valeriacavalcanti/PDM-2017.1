package br.edu.ifpb.si.pdm.janela;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

public class FilhaActivity extends AppCompatActivity {
    private TextView tvTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filha);

        this.tvTitulo = (TextView) findViewById(R.id.tvFilhaTitulo);

        Intent it = this.getIntent();
        this.tvTitulo.setText(it.getStringExtra("FOFO"));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Intent it = new Intent();
        it.putExtra("WALTER", "Muito bem!");
        setResult(RESULT_OK, it);
        finish();
        return super.onTouchEvent(event);
    }
}
