package br.edu.ifpb.si.pdm.monitorador;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class CarregadorReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("APP_TESTE", intent.getAction());
        String msg;
        switch (intent.getAction()){
            case Intent.ACTION_POWER_CONNECTED:
                msg = "Carregando";
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                msg = "Não Carregando";
                break;
            default:
                msg = "Corre !";
        }
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
