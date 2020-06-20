package com.anuj.retrofitsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText etTitle, etDesc, etqty;
    String title, desc, qty;
    Button add,cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        findViewsByIDs();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    void findViewsByIDs(){
        etTitle = findViewById(R.id.etTitle);
        etDesc = findViewById(R.id.etDesc);
        etqty = findViewById(R.id.etQty);
        add = findViewById(R.id.addButton);
        cancel = findViewById(R.id.cancelButton);
    }
}