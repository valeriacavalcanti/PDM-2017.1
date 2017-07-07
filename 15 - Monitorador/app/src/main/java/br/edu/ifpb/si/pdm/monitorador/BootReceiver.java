package br.edu.ifpb.si.pdm.monitorador;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class BootReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        Uri uri = Uri.parse("http://pdm.valeriacavalcanti.com.br");
        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(it);
    }
}
