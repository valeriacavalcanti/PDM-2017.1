package br.edu.ifpb.si.pdm.login;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etLogin, etSenha;
    private Button btOk, btCancela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getViews();
        this.setListeners();
    }

    private void getViews(){
        this.etLogin = (EditText) findViewById(R.id.etLogin);
        this.etSenha = (EditText) findViewById(R.id.etSenha);
        this.btOk = (Button) findViewById(R.id.btOk);
        this.btCancela = (Button) findViewById(R.id.btCancela);
    }

    private void setListeners(){
        this.btOk.setOnClickListener(new ClickBotao());
        this.btCancela.setOnClickListener(new ClickBotao());
    }

    private class ClickBotao implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            if (v.equals(MainActivity.this.btOk)){
                String login = MainActivity.this.etLogin.getText().toString();
                String senha = MainActivity.this.etSenha.getText().toString();
                if (login.equalsIgnoreCase("teste") && senha.equals("funfa")){
                    Intent it = new Intent();
                    it.putExtra("LOGIN", login);
                    setResult(RESULT_OK, it);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        finishAndRemoveTask();
                    }else{
                        finish();
                    }
                }else{
                    String msg = "Login/Senha inválido(s)!";
                    Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                }
            }else{
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    finishAndRemoveTask();
                }else{
                    finish();
                }
            }
        }
    }
}
