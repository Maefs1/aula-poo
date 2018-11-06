package com.example.mathe.a05_controle_abastecimento;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class abastecimentoAdapter extends RecyclerView.Adapter
{
    public ArrayList<abastecimentoDados> listaAbastecimentos;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType)
    {
        View elementoPai = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        abastecimentoViewHolder minhaGaveta = new abastecimentoViewHolder(elementoPai);

        return minhaGaveta;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        abastecimentoViewHolder gaveta = (abastecimentoViewHolder) viewHolder;
        abastecimentoDados x = listaAbastecimentos.get(i);
        gaveta.atualizaGaveta(x);
    }

    public int getItemCount ()
    {
        return listaAbastecimentos.size();
    }
}
