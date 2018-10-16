package com.example.mathe.a04_calculodeareas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.mathe.a04_calculadordeareas.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickCircle (View weiv)
    {
        Intent openCircleScreen = new Intent (this.getApplicationContext(), com.example.mathe.a04_calculodeareas.circleStart.class);
        this.startActivity(openCircleScreen);
    }

    public void onClickTriangle (View weiv)
    {
        Intent openTriangleScreen = new Intent (this.getApplicationContext(), com.example.mathe.a04_calculodeareas.triangleStart.class);
        this.startActivity(openTriangleScreen);
    }

    public void onClickRectangle (View weiv)
    {
        Intent openRectangleScreen = new Intent (this.getApplicationContext(), com.example.mathe.a04_calculodeareas.rectangleStart.class);
        this.startActivity(openRectangleScreen);
    }


}
