package com.fgarcia.aluraviagens.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fgarcia.aluraviagens.R;
import com.fgarcia.aluraviagens.model.Pacote;
import com.fgarcia.aluraviagens.util.DiasUtil;
import com.fgarcia.aluraviagens.util.MoedaUtil;
import com.fgarcia.aluraviagens.util.ResourcesUtil;

import java.util.List;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context) {
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int position) {
        return pacotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);

        Pacote pacote = pacotes.get(position);

        mostrarLocal(viewCriada, pacote);
        mostrarImagem(viewCriada, pacote);
        mostrarDias(viewCriada, pacote);
        mostrarPreco(viewCriada, pacote);

        return viewCriada;
    }

    private void mostrarPreco(View viewCriada, Pacote pacote) {
        TextView preco = viewCriada.findViewById(R.id.item_pacote_preco);
        String moedaBrasileira = MoedaUtil.formataMoedaBr(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }


    private void mostrarDias(View viewCriada, Pacote pacote) {
        TextView dias = viewCriada.findViewById(R.id.item_pacote_dias);
        String diasEmTexto = DiasUtil.formataEmTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }


    private void mostrarImagem(View viewCriada, Pacote pacote) {
        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        Drawable drawable = ResourcesUtil.devolveDrawable(context,pacote.getImagem());
        imagem.setImageDrawable(drawable);
    }

    private void mostrarLocal(View viewCriada, Pacote pacote) {
        TextView local = viewCriada.findViewById(R.id.item_pacote_local);
        local.setText(pacote.getLocal());
    }

}
