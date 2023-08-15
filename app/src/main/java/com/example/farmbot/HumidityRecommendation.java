package com.example.farmbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class HumidityRecommendation extends AppCompatActivity {

    String humidity;
    TextView displayHumidity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humidity_recommandation);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        LottieAnimationView lottieAnimationView = findViewById(R.id.lottie_humidity);
        lottieAnimationView.playAnimation();


        displayHumidity = findViewById(R.id.id_display_humidity);


        Intent intent = getIntent();
        if(intent != null) {
             humidity = intent.getStringExtra("humData");
        }

        displayHumidity.setText(humidity);




    }
}