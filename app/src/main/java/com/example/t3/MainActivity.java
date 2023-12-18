package com.example.t3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        valider = (Button) findViewById(R.id.btn_valider);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etUsername = (EditText) findViewById(R.id.et_username);
                etPassword = (EditText) findViewById(R.id.et_code);
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                if ((username.equals(trueUsername)) && (password.equals(truePassword))){
                    Toast.makeText(getBaseContext(), "Hello", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(getBaseContext() , afficherMessage.class);
                    intent.putExtra("name", username);

                    startActivity(intent);
                } else{
                    Toast.makeText(getBaseContext(), "Le mot de passe ou le code secret est incorect", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void onClickValider(View view){
        etUsername = (EditText) findViewById(R.id.et_username);
        String username = etUsername.getText().toString();
        Intent intent = new Intent(this , afficherMessage.class);
        intent.putExtra("username", username);
        //  Toast.makeText(getBaseContext(), "Hello", Toast.LENGTH_LONG).show();
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return (super.onCreateOptionsMenu(menu));
    }
    @Override
    public boolean onOptionsItemSelected (MenuItem item) {

        if (item.getItemId() == R.id.itmSaluer) {
            Toast.makeText(this, "Hello", Toast.LENGTH_LONG).show();
            return (true);
        }
        if (item.getItemId() == R.id.itmEnregistrer) {
            etUsername = (EditText) findViewById(R.id.et_username);
            String username = etUsername.getText().toString();
            Intent intent = new Intent(this, imc.class);
            intent.putExtra("name", username);
            startActivity(intent);
            return (true);
        }

        return(super.onOptionsItemSelected(item));
    }
}