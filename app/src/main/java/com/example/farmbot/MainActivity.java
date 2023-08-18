package com.example.farmbot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CardView tempCard, humidCard, moistCard, pHCard, gasCard;
    TextView temperature, humidity, moisture, ph, air;
    Button refreshBtn;
    String value, temperatureData="0", humidityData="_", moistureData="_", phData="_", gasData="_";
    RetrofitClientInstance retrofitClientInstance = new RetrofitClientInstance();
    NodeMCUApiService nodeMCUApiService = retrofitClientInstance.getApiService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        temperature = findViewById(R.id.TemperatureData);
        moisture = findViewById(R.id.MoistureData);
        ph = findViewById(R.id.PHData);
        air = findViewById(R.id.GasData);
        refreshBtn = findViewById(R.id.refreshID);
        humidity = findViewById(R.id.HumidityData);

        tempCard = findViewById(R.id.Id_card_Temperature);
        humidCard = findViewById(R.id.Id_card_DHT);
        moistCard = findViewById(R.id.Id_card_Moisture);
        pHCard = findViewById(R.id.Id_card_PH);
        gasCard = findViewById(R.id.Id_card_Air);
        tempCard.setOnClickListener(this);
        humidCard.setOnClickListener(this);
        moistCard.setOnClickListener(this);
        pHCard.setOnClickListener(this);
        gasCard.setOnClickListener(this);



        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMoisture();
            }
        });

    }


    private String getMoisture() {


        // Background work here
        // Make an API call
        Call<ModelClass> call = nodeMCUApiService.getDataFromNodeMCU();

        // UI Thread work here
        try {
            call.enqueue(new Callback<ModelClass>() {
                @Override
                public void onResponse(Call<ModelClass> call, Response<ModelClass> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        ModelClass data = response.body();
                        value = data.getSensorData();

                        try{
                            Toast.makeText(MainActivity.this, " "+value, Toast.LENGTH_SHORT).show();
                            if (value != null) {
                                String str[] = value.split("\\s");


                                temperatureData = str[0];
                                humidityData = str[1] + " %";

                                String getMositure = str[2];
                                double miostureSensorAnalog = Double.parseDouble(getMositure);
                                double moisturePercentage = ( 100 - ( (miostureSensorAnalog / 1023.00) * 100 ) );
                                moistureData = String.format("%.2f %%", moisturePercentage);


                                gasData = str[3];
                                phData = str[4];

                                temperature.setText(str[0]);
                                humidity.setText(humidityData);
                                moisture.setText(moistureData);
                                air.setText(str[3]);
                                ph.setText(str[4]);

                            }
                        }catch (Exception e){
                            Toast.makeText(MainActivity.this, " "+e, Toast.LENGTH_SHORT).show();
                        }


                    } else {
                        Toast.makeText(MainActivity.this, "No data received", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ModelClass> call, Throwable t) {
                    Toast.makeText(MainActivity.this, " "+t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, " " + e, Toast.LENGTH_LONG).show();
        }


        return value;

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Id_card_Temperature:
            {
                Intent intent = new Intent(this, TempRecommendation.class);
                intent.putExtra("tempData", temperatureData);
                startActivity(intent);
                break;
            }
            case R.id.Id_card_DHT:
            {
                Intent intent = new Intent(this, HumidityRecommendation.class);
                intent.putExtra("humData", humidityData);
                startActivity(intent);
                break;
            }
            case R.id.Id_card_Moisture:
            {
                Intent intent = new Intent(this, MoistureRecommendation.class);
                intent.putExtra("moisData", moistureData);
                startActivity(intent);
                break;
            }
            case R.id.Id_card_PH:
            {
                Intent intent = new Intent(this, pHRecommendation.class);
                intent.putExtra("phData", phData);
                startActivity(intent);
                break;
            }
            case R.id.Id_card_Air:
            {
                Intent intent = new Intent(this, GasRecommendation.class);
                intent.putExtra("gasData", gasData);
                startActivity(intent);
                break;
            }
        }
    }
}