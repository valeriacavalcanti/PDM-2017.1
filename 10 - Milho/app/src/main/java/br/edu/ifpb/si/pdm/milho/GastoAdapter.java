package br.edu.ifpb.si.pdm.milho;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by admin on 19/06/17.
 */

public class GastoAdapter extends BaseAdapter {
    private Cadastro cadastro;
    private Context context;

    public GastoAdapter(Context context, Cadastro cadastro){
        this.cadastro = cadastro;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.cadastro.getQuantidade();
    }

    @Override
    public Object getItem(int position) {
        return this.cadastro.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View layout;

        if (convertView == null){
            LayoutInflater li = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = li.inflate(R.layout.gasto_layout, null);
        }else layout = convertView;

        TextView tvDescricao = (TextView) layout.findViewById(R.id.tvGastoDescricao);
        TextView tvQuantidade = (TextView) layout.findViewById(R.id.tvGastoQuantidade);
        TextView tvValor = (TextView) layout.findViewById(R.id.tvGastoValorUnitario);
        TextView tvTotal = (TextView) layout.findViewById(R.id.tvGastoTotal);

        Gasto g = this.cadastro.get(position);

        tvDescricao.setText(g.getDescricao());
        tvQuantidade.setText(String.format("Quantidade: %d", g.getQuantidade()));
        tvValor.setText(String.format("Valor Unitário: R$ %.2f", g.getValor()));
        tvTotal.setText(String.format("Total: R$ %.2f", g.getTotal()));

        layout.setMinimumHeight(300);

        if (position % 2 == 0)
            layout.setBackgroundColor(Color.rgb(220, 220, 220));
        else
            layout.setBackgroundColor(Color.WHITE);

        return layout;
    }
}
