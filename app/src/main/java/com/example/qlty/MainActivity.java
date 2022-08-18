package com.example.qlty;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qlty.Model.Users;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText edtUsername, edtPassword;
    private Button btnLogin,btnDK;
    private Users mUsers;
    private List<Users> listUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        btnDK = findViewById(R.id.btnDangXuat);
        btnLogin= findViewById(R.id.btnDangnhap);
        Context tx = this;
        Context tc = this;
        edtUsername = findViewById(R.id.username);
        edtPassword = findViewById(R.id.password);
        listUser = new ArrayList<>();
        getListUsers();
        btnDK.setOnClickListener(view -> {
            Intent intent = new Intent(tx, DangKy.class);
            startActivity(intent);
        });
        btnLogin.setOnClickListener(view -> {
            clkLogin();
        });
    }

    private void clkLogin(){
        String username = edtUsername.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        boolean isHasUser = false;
        if(listUser == null || listUser.isEmpty())
        {
            return ;
        }
        for (Users users : listUser){
            if(username.equals(users.getUserName())&&MD5.getMd5(password).equals(users.getPassword())){
                isHasUser = true;
                mUsers = users;

                break;
            }
        }
        if (isHasUser){
            Intent intent = new Intent(MainActivity.this, trangchu.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("Users",mUsers );
            intent.putExtras(bundle);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(MainActivity.this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
        }

    }

    private void getListUsers(){
        ApiServices.apiService.GetUsers().enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                listUser = response.body();
                Log.e("list user: ", listUser.size()+"");
                Toast.makeText(MainActivity.this,"load api success",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.toString(),Toast.LENGTH_SHORT).show();
                Log.e("Eror: ", t.toString());
            }
        });
    }
}