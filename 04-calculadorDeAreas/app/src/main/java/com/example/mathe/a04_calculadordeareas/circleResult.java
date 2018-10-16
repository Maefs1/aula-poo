package com.example.mathe.a04_calculodeareas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mathe.a04_calculadordeareas.R;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class circleResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_result);

        double dRadius = this.getIntent().getDoubleExtra("radius", -1);

        double dArea = Math.PI * (dRadius * dRadius);

        TextView showRadius = (TextView) findViewById(R.id.showRadius);
        showRadius.setText(Double.toString(dRadius));

        TextView areaResult = (TextView) findViewById(R.id.areaResult);
        NumberFormat numberF = DecimalFormat.getInstance();
        numberF.setMaximumFractionDigits(3);
        areaResult.setText(numberF.format(dArea));
    }

    public void onClickBack (View weiv)
    {
        Intent openMainScreen = new Intent (this.getApplicationContext(), com.example.mathe.a04_calculodeareas.MainActivity.class);
        this.startActivity(openMainScreen);
    }
}