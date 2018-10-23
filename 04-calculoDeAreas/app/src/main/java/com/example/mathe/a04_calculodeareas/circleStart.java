package com.example.mathe.a04_calculodeareas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class circleStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_start);
    }
    public void onClickCalculateCircle (View weiv)
    {
        double dRadius = 0;
        EditText radius = findViewById(R.id.circleRadius);

        if (radius.getText().toString().compareTo("") == 0)
        {
            radius.setError(getString(R.string.insertNumber));
            return;
        }

        try
        {
            dRadius = Double.parseDouble(radius.getText().toString());
        }catch (Exception exc)
        {
            Toast errorMessage = Toast.makeText(this, R.string.errorMessage, Toast.LENGTH_LONG);
            errorMessage.show();
            return;
        }

        Intent openCircleResultScreen = new Intent(this.getApplicationContext(), circleResult.class);

        openCircleResultScreen.putExtra("radius", dRadius);

        this.startActivity(openCircleResultScreen);
    }

}
