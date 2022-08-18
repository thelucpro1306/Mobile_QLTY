package com.example.qlty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class User extends AppCompatActivity {

    private Button btnLuuTT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        btnLuuTT = findViewById(R.id.btnLuuTT);
        btnLuuTT.setOnClickListener(v -> startActivity(new Intent(this,trangchu.class)));



    }
}
