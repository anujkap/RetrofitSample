package com.anuj.retrofitsample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    Retrofit retrofit;
    String BASE_URL = "";

    String username;
    String pass;

    ProgressDialog progressDialog;

    Button login;
    TextView link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Login();
                startActivity(new Intent(MainActivity.this,ListActivity.class));
            }
        });

        link = findViewById(R.id.linksign);
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SignUpActivity.class));
            }
        });
    }
    void Login() {
        TextView email = findViewById(R.id.tvusername);
        TextView passw = findViewById(R.id.tvpassword);
        username = email.getText().toString();
        pass = passw.getText().toString();
        if (!username.isEmpty() && !pass.isEmpty()) {
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Loading....");
            progressDialog.show();


        }
    }

}