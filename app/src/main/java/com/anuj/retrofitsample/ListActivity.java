package com.anuj.retrofitsample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.anuj.retrofitsample.Adapters.RecyclerAdapter;
import com.anuj.retrofitsample.Items.Data;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private List<Data> mData = new ArrayList<>();
    private int RecyclerViewItemPosition;
    RecyclerAdapter adapter;
    RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        list = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getApplicationContext());
        list.setLayoutManager(layoutManager);
        getItems();
        findViewById(R.id.floatingActionButton).setOnClickListener(v -> {
            // TODO: send add request
            startActivity(new Intent(ListActivity.this,AddActivity.class));
        });
    }

    void getItems(){
        // TODO: Add get call
        if(!mData.isEmpty()){
            findViewById(R.id.na).setVisibility(View.INVISIBLE);
            adapter = new RecyclerAdapter(mData);
            list.setAdapter(adapter);
        }

    }
}