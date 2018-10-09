package com.example.mathe.a03_calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void meAjuda (View v)
    {
        EditText numero1 = findViewById(R.id.editText);
        EditText numero2 = findViewById(R.id.editText2);
        EditText numero3 = findViewById(R.id.editText3);
        TextView resultado = findViewById(R.id.textView3);


        String numeroDigitado = numero1.getText().toString();
        String numeroDigitado2 = numero2.getText().toString();
        String numeroDigitado3 = numero3.getText().toString();

        Integer numeroI = Integer.parseInt(numeroDigitado);

        if (numeroDigitado.equals(""))
        {
            numero1.setError("Informe um número válido");
        }
        if (numeroDigitado2.equals(""))
        {
            numero2.setError("Informe um número válido");
        }
        if (numeroDigitado3.equals(""))
        {
            numero3.setError("Informe um número válido");
        }

        try
        {
            double numero1I = Double.parseDouble(numeroDigitado);
            double numero2I = Double.parseDouble(numeroDigitado2);
            double numero3I = Double.parseDouble(numeroDigitado3);

            double resultado2 = (numero2I * numero3I) / numero1I;

            resultado.setText("X = "+resultado2);

            resultado.setVisibility(View.VISIBLE);
        }catch (Exception e)
        {
            Toast mensagemErro = Toast.makeText(this, "Algo errado aconteceu", Toast.LENGTH_LONG);
            mensagemErro.show();
        }

    }

}
