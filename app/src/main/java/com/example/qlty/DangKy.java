package com.example.qlty;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.qlty.Model.Users;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DangKy extends AppCompatActivity {

    public EditText tendangnhap, email, matkhau,nhaplaimatkhau,sodienthoai;
    private Button btnDangKy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        ActionBar actionBar = getSupportActionBar();

        actionBar.hide();

        tendangnhap = findViewById(R.id.tendangnhap);
        email = findViewById(R.id.email);
        matkhau = findViewById(R.id.matkhau);
        nhaplaimatkhau = findViewById(R.id.nhaplaimatkhau);
        sodienthoai = findViewById(R.id.sodienthoai);
        btnDangKy = findViewById(R.id.btnDangKy);

        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Users users = new Users();
                users.setUserName(tendangnhap.getText().toString().trim());
                users.setPassword(MD5.getMd5(matkhau.getText().toString().trim()));
                users.setEmail(email.getText().toString().trim());
                users.setPhone(sodienthoai.getText().toString().trim());

                ApiServices.apiService.addUser(users).enqueue(new Callback<Users>() {
                    @Override
                    public void onResponse(Call<Users> call, Response<Users> response) {


                    }

                    @Override
                    public void onFailure(Call<Users> call, Throwable t) {

                    }
                });
                startActivity(new Intent(DangKy.this,MainActivity.class));

            }
        });



    }
}