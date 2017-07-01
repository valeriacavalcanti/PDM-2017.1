package br.edu.ifpb.si.pdm.facebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.btLogin = (Button) findViewById(R.id.btLogin);
        this.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent("LOGIN");
                startActivityForResult(it, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        
        if (resultCode == RESULT_OK){
            if (requestCode == 1){
                String login = data.getStringExtra("LOGIN");
                Toast.makeText(this, login, Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Cancelou", Toast.LENGTH_SHORT).show();
        }
    }
}
