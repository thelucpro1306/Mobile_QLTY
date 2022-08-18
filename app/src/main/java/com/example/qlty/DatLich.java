package com.example.qlty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.qlty.Model.Client;

public class DatLich extends AppCompatActivity implements ISendDataListener {
    private Client Client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_lich);
    }

    @Override
    public void sendData(Client client) {
        Client = client;
    }
}