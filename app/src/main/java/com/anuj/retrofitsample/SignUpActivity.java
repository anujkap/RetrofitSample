package com.anuj.retrofitsample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.anuj.retrofitsample.Interface.APICalls;
import com.anuj.retrofitsample.Items.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUpActivity extends AppCompatActivity {

    Retrofit retrofit;

    ProgressDialog progressDialog;

    EditText name, email, pass;
    String sname,semail,spass;
    Button signUp;
    TextView link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api-linking.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        signUp = findViewById(R.id.signup);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUp();
            }
        });

        link = findViewById(R.id.linklogin);
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this,MainActivity.class));
            }
        });
    }

    void SignUp(){
        name = findViewById(R.id.etName);
        email = findViewById(R.id.etEmail);
        pass = findViewById(R.id.etPass);

        sname = name.getText().toString();
        semail = email.getText().toString();
        spass = pass.getText().toString();

        if (!semail.isEmpty() && !spass.isEmpty()) {
            progressDialog = new ProgressDialog(SignUpActivity.this);
            progressDialog.setMessage("Loading....");
            progressDialog.show();


            APICalls apiCalls = retrofit.create(APICalls.class);
            Call<User> getCred = apiCalls.registerUser(new User(sname,semail,spass));
            Log.d("Here","Before call");
            getCred.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    progressDialog.dismiss();
                    Log.d("Here","Call Response");
                    Toast.makeText(SignUpActivity.this,response.message(), Toast.LENGTH_LONG).show();
                    // TODO: Add what to do after receiving response
                    if(response.code() == 201){
                        Toast.makeText(getApplicationContext(),"User Created", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    progressDialog.dismiss();
                    Log.d("Here","Call Failed"+t.getMessage());
                    // TODO : Handle Failure
                }
            });
        }

    }
}