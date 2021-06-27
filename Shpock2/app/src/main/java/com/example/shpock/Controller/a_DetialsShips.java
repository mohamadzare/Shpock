package com.example.shpock.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.shpock.MainActivity;
import com.example.shpock.Models.ArrayClassImport;
import com.example.shpock.R;
import com.squareup.picasso.Picasso;


public class a_DetialsShips extends AppCompatActivity {


    TextView header_title,Description,Price;
    ImageView img_d;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_adetials_ships);

        header_title=(TextView)findViewById(R.id.Title);
        Description=(TextView)findViewById(R.id.Description);
        Price=(TextView)findViewById(R.id.Price);
        img_d=(ImageView)findViewById(R.id.img_d);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                id= null;
            } else {
                id= extras.getString("id");
            }
        } else {
            id= (String) savedInstanceState.getSerializable("id");
        }

        header_title.setText(ArrayClassImport.shipsArrayList.get(Integer.parseInt(id)).getTitle());
        Description.setText(ArrayClassImport.shipsArrayList.get(Integer.parseInt(id)).getDescription());
        Price.setText(String.valueOf(ArrayClassImport.shipsArrayList.get(Integer.parseInt(id)).getPrice()));
        Picasso.with(a_DetialsShips.this).load(ArrayClassImport.shipsArrayList.get(Integer.parseInt(id)).getImage()).into(img_d);
    }

    @Override
    public void onBackPressed() {

        startActivity(new Intent(a_DetialsShips.this, a_ListShip.class));
        finish();
    }
}