package com.example.t3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    EditText etUsername;
    EditText etPassword;

    Button valider;
    String trueUsername = "1";
    String truePassword = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        valider = findViewById(R.id.btn_valider);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etUsername = findViewById(R.id.et_username);
                etPassword = findViewById(R.id.et_code);
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                if ((username.equals(trueUsername)) && (password.equals(truePassword))) {
                    Toast.makeText(getBaseContext(), "Hello", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(MainActivity.this, afficherMessage.class);
                    intent.putExtra("name", username);
                    startActivity(intent);
                } else {
                    Toast.makeText(getBaseContext(), "Le mot de passe ou le code secret est incorrect", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void onClickValider(View view){
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_code);
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        if ((username.equals(trueUsername)) && (password.equals(truePassword))) {
            Toast.makeText(getBaseContext(), "Hello", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, afficherMessage.class);
            intent.putExtra("name", username);
            startActivity(intent);
        } else {
            Toast.makeText(getBaseContext(), "Le mot de passe ou le code secret est incorrect", Toast.LENGTH_LONG).show();
        }
    }
}
