package com.example.shpock.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.shpock.Views.Adapter.ListShips;
import com.example.shpock.Models.ArrayClassImport;
import com.example.shpock.R;

public class a_ListShip extends AppCompatActivity {
    private ListShips adapter;

    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alist_ship);


        recyclerView = findViewById(R.id.shipRcView);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(a_ListShip.this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListShips(a_ListShip.this, ArrayClassImport.shipsArrayList);
        recyclerView.setAdapter(adapter);


    }
}