package br.edu.ifpb.si.pdm.milho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.Normalizer;

public class FormularioActivity extends AppCompatActivity {
    private EditText etDescricao, etValor, etQuantidade;
    private Button btSalvar, btCancelar, btExcluir;
    private int posicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        this.setReferencias();
        this.setListeners();

        try {
            Gasto g = (Gasto) getIntent().getSerializableExtra("GASTO");
            this.posicao = getIntent().getIntExtra("POSICAO", -1);
            this.etDescricao.setText(g.getDescricao());
            this.etQuantidade.setText(Integer.toString(g.getQuantidade()));
            this.etValor.setText(Float.toString(g.getValor()));
            this.btExcluir.setVisibility(View.VISIBLE);
            Log.i("MILHO", g.toString());
        }catch (Exception e) {

        }
    }

    private void setReferencias(){
        this.etDescricao = (EditText) findViewById(R.id.etFormularioDescricao);
        this.etQuantidade = (EditText) findViewById(R.id.etFormularioQtde);
        this.etValor = (EditText) findViewById(R.id.etFormularioValor);
        this.btSalvar = (Button) findViewById(R.id.btFormularioSalvar);
        this.btCancelar = (Button) findViewById(R.id.btFormularioCancelar);
        this.btExcluir = (Button) findViewById(R.id.btFormularioExcluir);
    }

    private void setListeners(){
        this.btSalvar.setOnClickListener(new OnClickBotao());
        this.btCancelar.setOnClickListener(new OnClickBotao());
        this.btExcluir.setOnClickListener(new OnClickBotao());
    }

    private class OnClickBotao implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if (v.equals(FormularioActivity.this.btSalvar)){
                String desc = FormularioActivity.this.etDescricao.getText().toString();
                int qtde = Integer.parseInt(FormularioActivity.this.etQuantidade.getText().toString());
                float valor = Float.parseFloat(FormularioActivity.this.etValor.getText().toString());
                Gasto g = new Gasto(desc, qtde, valor);
                Intent it = new Intent();
                it.putExtra("GASTO", g);
                it.putExtra("POSICAO", FormularioActivity.this.posicao);
                setResult(RESULT_OK, it);
            }else if (v.equals(FormularioActivity.this.btCancelar)){

            }else{
                // excluir
                Intent it = new Intent();
                it.putExtra("POSICAO", FormularioActivity.this.posicao);
                setResult(RESULT_OK, it);
            }
            finish();
        }
    }
}
