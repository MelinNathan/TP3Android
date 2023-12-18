package com.example.t3;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class afficherMessage extends AppCompatActivity {

    String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_message); // Assurez-vous que le layout correct est utilisé
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Récupérer les données passées depuis l'intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            user = extras.getString("name");
            // Faites ce que vous devez faire avec la variable "user"
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.itmSaluer) {
            Toast.makeText(this, "Hello", Toast.LENGTH_LONG).show();
            return true;
        }
        if (item.getItemId() == R.id.itmEnregistrer) {
            // Vous pouvez utiliser la variable "user" ici
            Toast.makeText(this, "User: " + user, Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
