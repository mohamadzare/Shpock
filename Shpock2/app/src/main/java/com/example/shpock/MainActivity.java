package com.example.shpock;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shpock.Controller.a_ListShip;
import com.example.shpock.Models.service.ApiService;
import com.example.shpock.Models.ArrayClassImport;
import com.example.shpock.Models.ships;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.TimeUnit;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getData();

    }


    public void getData()
    {

        final ProgressDialog Dialog = new ProgressDialog(MainActivity.this);

        Dialog.setMessage("Waiting...");
        Dialog.setCancelable(false);
        Dialog.show();

        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("Content-encoding", "gzip");
                request.addHeader("Accept", "application/json");

            }
        };

        Gson gson = new GsonBuilder().setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'").create();

        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(60, TimeUnit.SECONDS);
        okHttpClient.setReadTimeout(60, TimeUnit.SECONDS);


        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://assets.shpock.com")
                .setClient(new OkClient(okHttpClient))
                .setConverter(new GsonConverter(gson))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setRequestInterceptor(requestInterceptor)
                .build();
        ApiService service = restAdapter.create(ApiService.class);

        service.get_interview(new Callback<Object>() {

            @Override
            public void success(Object object, Response response) {
                String crappyPrefix = "null";
                Gson gson2 = new Gson();
                String json = gson2.toJson(object);

                try {
                    JSONObject jsonObj = new JSONObject(json);
                    JSONArray sh = jsonObj.getJSONArray("ships");
                    ArrayClassImport.shipsArrayList.clear();

                        for (int i = 0; i < sh.length(); i++) {

                            if(sh.get(i).toString().equals("null"))
                            {

                            }
                            else
                            {
                                JSONObject object1 = sh.getJSONObject(i);


                                ships ship = new ships();
                                if (object1.has("title")) {
                                    if (!(object1.getString("title").equals("null"))) {
                                        ship.setTitle(object1.getString("title"));
                                    }

                                }else {
                                    ship.setTitle(("TEST"));

                                }
                                if (object1.has("id")) {

                                    ship.setId(object1.getInt("id"));

                                }
                                if (object1.has("price")) {

                                    ship.setPrice(object1.getInt("price"));


                                }
                                if (object1.has("image")) {
                                    ship.setImage(object1.getString("image"));
                                }
                                if (object1.has("description")) {
                                    ship.setDescription(object1.getString("description"));
                                }
                                if (object1.has("greeting_type")) {
                                    if (!(object1.getString("greeting_type") .equals("null"))) {
                                        ship.setGreeting_type(object1.getString("greeting_type"));
                                    } else {
                                        ship.setGreeting_type(("greeting_type"));
                                    }
                                }
                                ArrayClassImport.shipsArrayList.add(ship);

                            }


                        }


                    Dialog.dismiss();
                    startActivity(new Intent(MainActivity.this, a_ListShip.class));
                    finish();


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });

    }
}