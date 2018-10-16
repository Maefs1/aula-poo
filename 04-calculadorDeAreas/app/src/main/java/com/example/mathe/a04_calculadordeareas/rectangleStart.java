package com.example.mathe.a04_calculodeareas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mathe.a04_calculadordeareas.R;

public class rectangleStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle_start);
    }

    public void onClickCalculateRectangle (View weiv) {
        EditText tWidth = findViewById(R.id.enterWidth);
        EditText tHeight = findViewById(R.id.enterHeight);

        int condition = 1;

        if (tWidth.getText().toString().compareTo("") == 0) {
            tWidth.setError(getString(R.string.insertNumber));
            condition = 0;
        }
        if (tHeight.getText().toString().compareTo("") == 0) {
            tHeight.setError(getString(R.string.insertNumber));
            condition = 0;
        }
        if (condition == 0)
            return;

        double dHeight = 0;
        double dWidth = 0;

        try {
            dWidth = Double.parseDouble(tWidth.getText().toString());
            dHeight = Double.parseDouble(tHeight.getText().toString());
        } catch (Exception exc) {
            Toast errorMessage = Toast.makeText(this, "Something wrong happened", Toast.LENGTH_LONG);
            errorMessage.show();
            return;
        }

        Intent openRectangleResultScreen = new Intent(this.getApplicationContext(), com.example.mathe.a04_calculodeareas.rectangleResult.class);

        openRectangleResultScreen.putExtra("width",dWidth);
        openRectangleResultScreen.putExtra("height",dHeight);

        this.startActivity(openRectangleResultScreen);
    }
}
