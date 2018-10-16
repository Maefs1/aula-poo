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

public class rectangleResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle_result);

        double dWidth = this.getIntent().getDoubleExtra("width",-1);
        double dHeight = this.getIntent().getDoubleExtra("height",-1);
        double dArea = dWidth * dHeight;

        TextView tHeight = (TextView) findViewById(R.id.tHeight);
        tHeight.setText(Double.toString(dHeight));

        TextView tWidth = (TextView) findViewById(R.id.tWidth);
        tWidth.setText(Double.toString(dWidth));

        TextView tAreaResultRectangle = (TextView) findViewById(R.id.tAreaResultRectangle);
        NumberFormat numberF = DecimalFormat.getInstance();
        numberF.setMaximumFractionDigits(3);
        tAreaResultRectangle.setText(numberF.format(dArea));
    }

    public void onClickBack (View weiv)
    {
        Intent openMainScreen = new Intent(this.getApplicationContext(), com.example.mathe.a04_calculodeareas.MainActivity.class);
        this.startActivity(openMainScreen);
    }
}
