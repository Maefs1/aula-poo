package com.example.mathe.a05_controle_abastecimento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class abastecimento extends AppCompatActivity {

    private abastecimentoAdapter adapter;

    public static final int ADD_ABASTECIMENTO = 1312;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abastecimento);

        RecyclerView rvAbastecimento = findViewById(R.id.rvLista);

        this. adapter = new abastecimentoAdapter();
        this.adapter.listaAbastecimentos = abastecimentoDAO.getLista(this.getApplicationContext());

        rvAbastecimento.setAdapter(this.adapter);
        rvAbastecimento.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
    }

    public void onClickFAB (View weiv)
    {
        Intent intencao = new Intent (this.getApplicationContext(), abastecimentoAdicionar.class);

        if (this.adapter.listaAbastecimentos.size() > 0)
        {
            intencao.putExtra("dKmAntigo", this.adapter.listaAbastecimentos.get(this.adapter.listaAbastecimentos.size() -1).getKm());
        }
        startActivityForResult(intencao, ADD_ABASTECIMENTO);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode == ADD_ABASTECIMENTO)
        {
            if(resultCode == 1)
            {
                this.adapter.notifyDataSetChanged();
            }else
            {
                Toast.makeText(this.getApplicationContext(), "Onde eu tô", Toast.LENGTH_LONG).show();
            }
        }else
        {
            Toast.makeText(this.getApplicationContext(),"eita", Toast.LENGTH_LONG).show();
        }
    }

    public void atualizaDatasetLista()
    {
        this.adapter.listaAbastecimentos = abastecimentoDAO.getLista(this.getApplicationContext());
        this.adapter.notifyDataSetChanged();
    }

}
