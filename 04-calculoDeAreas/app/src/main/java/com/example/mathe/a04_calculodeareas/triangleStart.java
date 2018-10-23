package com.example.mathe.a04_calculodeareas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class triangleStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle_start);
    }
    public void onClickCalculateTriangle (View weiv)
    {
        EditText eWidth = findViewById(R.id.enterWidth);
        EditText eHeight = findViewById(R.id.enterHeight);

        int condition = 1;

        if (eWidth.getText().toString().compareTo("") == 0)
        {
            eWidth.setError(getString(R.string.insertNumber));
            condition = 0;
        }

        if (eHeight.getText().toString().compareTo("") == 0)
        {
            eHeight.setError(getString(R.string.insertNumber));
            condition = 0;
        }

        if (condition == 0)
            return;

        double dWidth = 0;
        double dHeight = 0;

        try
        {
            dWidth = Double.parseDouble(eWidth.getText().toString());
            dHeight = Double.parseDouble(eHeight.getText().toString());
        }catch (Exception exc)
        {
            Toast errorMessage = Toast.makeText(this, "Something wrong happened", Toast.LENGTH_LONG);
            errorMessage.show();
            return;
        }

        Intent openTriangleResultScreen = new Intent (this.getApplicationContext(), triangleResult.class);

        openTriangleResultScreen.putExtra("width", dWidth);
        openTriangleResultScreen.putExtra("height", dHeight);

        this.startActivity(openTriangleResultScreen);
    }
}
