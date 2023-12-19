package com.example.t3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class imc extends AppCompatActivity{
    // Retrieve references to the views
    private EditText inputHeight;
    private EditText inputWeight;
    private TextView result;
    private TextView meaning;

    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);


        inputHeight = findViewById(R.id.inputHeight);
        inputWeight = findViewById(R.id.inputWeight);
        result = findViewById(R.id.result);
        meaning = findViewById(R.id.meaning);


        Button submitButton = findViewById(R.id.submitButton);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Call the imc() method to calculate the IMC
                Double imcResult = imcFunction();
                String interpretation = interpretation(imcResult);




                // Display the result in the TextView
                result.setText("Votre IMC est de : " + imcResult);
                meaning.setText(interpretation);




            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu_imc, menu);
        return (super.onCreateOptionsMenu(menu));
    }
    @Override
    public boolean onOptionsItemSelected (MenuItem item) {

        if (item.getItemId() == R.id.itm_annuaire) {
            Intent intent = new Intent(this, afficherMessage.class);
            startActivity(intent);
            return (true);
        }
        if (item.getItemId() == R.id.itm_principal) {

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return (true);
        }
        return false;
    }

    private double imcFunction() {
        try {
            String tailleStr = inputHeight.getText().toString();
            String poidsStr = inputWeight.getText().toString();


            // Convert the strings to numerical values
            double taille = Double.parseDouble(tailleStr) / 100; // in meters
            double poids = Double.parseDouble(poidsStr);
            // Calculate the IMC


            return poids / (taille * taille);


        } catch (NumberFormatException e) {
            // Handle the case where the input is not a valid number
            // For example, show an error message or log the error
            e.printStackTrace();
            return 0.0; // or any default value
        }
    }


    private String interpretation (double result){
        if (result < 16.5){
            meaning.setTextColor((Color.parseColor("#e76f51")));
            return "Vous êtes en état de dénutrition";
        } else if ((result >= 16.5) && (result < 18.5)){
            meaning.setTextColor((Color.parseColor("#f4a261")));
            return "Vous êtes en état de maigreur";
        } else if ((result >= 18.5) && (result < 25)){
            meaning.setTextColor((Color.parseColor("#2a9d8f")));
            return "Vous présentez un poid normal";
        } else if ((result >= 25) && (result < 30)){
            meaning.setTextColor((Color.parseColor("#e9c46a")));
            return "Vous êtes en état d'obésité modérée";
        } else if ((result >= 35) && (result < 40)){
            meaning.setTextColor((Color.parseColor("#f4a261")));
            return "Vous êtes en état d'obésité sévère";
        } else {
            meaning.setTextColor((Color.parseColor("#e76f51")));
            return "Vous êtes en état d'obésité morbide";
        }
    }
}
