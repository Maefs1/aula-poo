package com.example.mathe.a05_controle_abastecimento;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fm = MainActivity.this.getSupportFragmentManager();
        setContentView(R.layout.activity_main);
        for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }

        setContentView(R.layout.activity_main);

        ArrayList<abastecimentoDados> abastecimentos =  new ArrayList<abastecimentoDados>();

        abastecimentos = abastecimentoDAO.getLista(this.getApplicationContext());

        if(abastecimentos.size()>1){
            double autonomia;
            double kmPercorridos;
            double litros = 0;

            kmPercorridos = abastecimentos.get(abastecimentos.size()-1).getKm() - abastecimentos.get(0).getKm();
            for (int i = 0; i < abastecimentos.size()-1; i++) {
                litros += abastecimentos.get(i).getLitragem();
            }

            autonomia = kmPercorridos/litros;

            TextView tvResult = findViewById(R.id.tvAutonomiaLitros);

            tvResult.setText(String.valueOf(autonomia));
        }
    }

    public void next(View view) {
        Intent intent = new Intent(this.getApplicationContext(), abastecimento.class);
        startActivity(intent);
    }
}
