package com.example.farmbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class pHRecommendation extends AppCompatActivity {

    String pH;
    TextView displaypH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrecommendation);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        LottieAnimationView lottieAnimationView = findViewById(R.id.lottie_pH);
        lottieAnimationView.playAnimation();

        displaypH = findViewById(R.id.id_display_pH);


        Intent intent = getIntent();
        if(intent != null) {
            pH = intent.getStringExtra("phData");
        }

        displaypH.setText(pH);

    }
}