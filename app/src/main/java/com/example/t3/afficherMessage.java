package com.example.t3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class afficherMessage extends AppCompatActivity {
    Bundle bundle;
    String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
//            etUsername = (EditText) findViewById(R.id.et_username);
//            String username = etUsername.getText().toString();
            //test
            Intent intent = new Intent(this, afficherMessage.class);
            intent.putExtra("name", "test");
            startActivity(intent);
            return (true);
        }

        return(super.onOptionsItemSelected(item));
    }
}