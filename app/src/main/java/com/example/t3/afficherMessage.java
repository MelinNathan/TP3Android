package com.example.t3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class afficherMessage extends AppCompatActivity {
    Bundle bundle;
    String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_message);

        bundle = getIntent().getExtras();
        TextView tvUser;
        tvUser = (TextView) findViewById(R.id.tv_user);
        user = bundle.getString("name").toString() ;
        tvUser.setText("Bonjour " + user);

    }

}