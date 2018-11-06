package com.example.mathe.a05_controle_abastecimento;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class abastecimentoViewHolder extends RecyclerView.ViewHolder
{
    private TextView tvData;
    private TextView tvKm;
    private TextView tvLitragem;
    private ImageView ivPostos;

    public abastecimentoViewHolder(View itemView)
    {
        super(itemView);

        this.tvData = itemView.findViewById(R.id.tvDataItem);
        this.tvKm = itemView.findViewById(R.id.tvKmLista);
        this.tvLitragem = itemView.findViewById(R.id.tvComb);
        this.ivPostos = itemView.findViewById(R.id.ivPosto);
    }

    public void atualizaGaveta (abastecimentoDados objetoAbastecimento)
    {
        this.tvData.setText(objetoAbastecimento.getData());
        this.tvKm.setText(String.valueOf(objetoAbastecimento.getKm()));
        this.tvLitragem.setText(String.valueOf(objetoAbastecimento.getLitragem()));

        if (ivPostos.equals("Ipiranga")) {
            ivPostos.setImageDrawable(ContextCompat.getDrawable(App.getContext(), R.drawable.ipiranga));
        }
        if(ivPostos.equals("Shell")) {
            ivPostos.setImageDrawable(ContextCompat.getDrawable(App.getContext(), R.drawable.shell));
        }
        if(ivPostos.equals("Petrobras")) {
            ivPostos.setImageDrawable(ContextCompat.getDrawable(App.getContext(), R.drawable.petrobras));
        }
        if(ivPostos.equals("Texaco")) {
            ivPostos.setImageDrawable(ContextCompat.getDrawable(App.getContext(), R.drawable.texaco));
        }
        if(ivPostos.equals("Outro"))
            ivPostos.setImageDrawable(ContextCompat.getDrawable(App.getContext(), R.drawable.posto));
    }
}
