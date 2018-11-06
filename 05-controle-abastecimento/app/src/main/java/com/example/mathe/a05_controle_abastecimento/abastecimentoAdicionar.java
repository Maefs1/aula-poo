package com.example.mathe.a05_controle_abastecimento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class abastecimentoAdicionar extends AppCompatActivity
{

    private EditText etKmAtual;
    private EditText etData;
    private EditText etAbastecido;
    private double dKmAntigo;
    private Spinner spPosto;
    private String posto[] = new String[] {"Ipiranga", "Petobras", "Shell", "Taxaco", "Outro"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abastecimento_adicionar);

        this.dKmAntigo = this.getIntent().getDoubleExtra("dKmAntigo",-1);

        ArrayAdapter <String> adaptador = new ArrayAdapter<String>(this.getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, posto);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spPosto = (Spinner) findViewById(R.id.sPosto);
        spPosto.setAdapter(adaptador);

        etData = findViewById(R.id.etData);
        etKmAtual = findViewById(R.id.etKmAtual);
        etAbastecido = findViewById(R.id.etLitros);

    }

    public void onClick (View weiv)
    {
        abastecimentoDados abastecimentoNovo = new abastecimentoDados();

        abastecimentoNovo.setData(etData.getText().toString());
        abastecimentoNovo.setPosto(spPosto.getSelectedItem().toString());
        abastecimentoNovo.setKm(Double.parseDouble(etKmAtual.getText().toString()));
        abastecimentoNovo.setLitragem(Double.parseDouble(etAbastecido.getText().toString()));

        boolean salvo = abastecimentoDAO.salvarNovo(this.getApplicationContext(), abastecimentoNovo);

        if(salvo){
            setResult(1);
            finish();
        }else{
            Toast.makeText(this.getApplicationContext(), "Erro ao salvar", Toast.LENGTH_SHORT).show();
        }
    }



}
