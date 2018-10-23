package com.example.mathe.a04_calculodeareas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class triangleResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle_result);
        double dWidth = this.getIntent().getDoubleExtra("width",-1);
        double dHeight = this.getIntent().getDoubleExtra("height",-1);
        double dArea = (dWidth* dHeight) / 2;

        TextView tWidth = (TextView) findViewById(R.id.tWidth);
        tWidth.setText(Double.toString(dWidth));

        TextView tHeight = (TextView) findViewById(R.id.tHeight);
        tWidth.setText(Double.toString(dHeight));

        TextView tAreaResultTriangle = (TextView) findViewById(R.id.tAreaResult);
        NumberFormat numberF = DecimalFormat.getInstance();
        numberF.setMaximumFractionDigits(3);
        tAreaResultTriangle.setText(numberF.format(dArea));
    }

    public void onClickBack(View v){
        Intent openMainScreen = new Intent(this, MainActivity.class);
        openMainScreen.addFlags(openMainScreen.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(openMainScreen);
    }
}

