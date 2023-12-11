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

public class MainActivity extends AppCompatActivity {

    EditText edPrenom;
    TextView tvPrenom;
    Button valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valider = (Button) findViewById(R.id.btn_valider);
      /*  valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edPrenom = (EditText) findViewById(R.id.et_prenom);
                String prenom = edPrenom.getText().toString();
                Intent intent = new Intent(getBaseContext() , afficherMessage.class);
                intent.putExtra("name", prenom);
              //  Toast.makeText(getBaseContext(), "Hello", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });*/
    }
    public void onClickValider(View view){
        edPrenom = (EditText) findViewById(R.id.et_prenom);
        String prenom = edPrenom.getText().toString();
        Intent intent = new Intent(this , afficherMessage.class);
        intent.putExtra("name", prenom);
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
            edPrenom = (EditText) findViewById(R.id.et_prenom);
            String prenom = edPrenom.getText().toString();
            Intent intent = new Intent(this, afficherMessage.class);
            intent.putExtra("name", prenom);
            startActivity(intent);
            return (true);
        }

        return(super.onOptionsItemSelected(item));
    }
}