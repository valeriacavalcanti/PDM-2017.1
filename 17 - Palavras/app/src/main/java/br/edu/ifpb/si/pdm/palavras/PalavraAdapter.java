package br.edu.ifpb.si.pdm.palavras;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by admin on 15/07/17.
 */

public class PalavraAdapter extends BaseAdapter {
    private Context context;
    private PalavraDAO dao;

    public PalavraAdapter(Context context, PalavraDAO dao){
        this.context = context;
        this.dao = dao;
    }

    @Override
    public int getCount() {
        return this.dao.size();
    }

    @Override
    public Object getItem(int position) {
        return this.dao.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null){
            LayoutInflater li = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = li.inflate(R.layout.palavra_layout, null);
        }else
            view = convertView;

        TextView tvPalavra = (TextView) view.findViewById(R.id.tvPalavra);
        TextView tvDH = (TextView) view.findViewById(R.id.tvDataHora);

        Palavra p = this.dao.get(position);

        tvPalavra.setText(p.getConteudo());
        tvDH.setText(p.getDataHora());

        view.setMinimumHeight(200);

        if (position % 2 == 0)
            view.setBackgroundColor(Color.rgb(244,244,244));
        else
            view.setBackgroundColor(Color.WHITE);

        return view;
    }
}
