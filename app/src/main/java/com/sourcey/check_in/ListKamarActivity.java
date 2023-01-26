package com.sourcey.check_in;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.sourcey.check_in.App.MySingleton;
import com.sourcey.check_in.Server.Server;
import com.sourcey.check_in.adapter.KamarAdapter;
import com.sourcey.check_in.model.Kamar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListKamarActivity extends AppCompatActivity {

    private static final String URL_KAMAR = Server.URL + "Android/ApiKamar.php";
    private KamarAdapter myAdapter;
    ArrayList<Kamar> mItems = new ArrayList<>();
    RecyclerView mRecyclerView;
    SwipeRefreshLayout swipeRefreshLayout;

    String id_hotel, nama_hotel, alamat_hotel, checkin, checkout, tamu, kamar, tot_malam, tujuan;
    int tot_kamar;

    TextView tv_nama_hotel,tv_alamat;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_kamar);

        Toolbar topToolBar = findViewById(R.id.toolbar);
        setSupportActionBar(topToolBar);

        Intent intent = getIntent();
        id_hotel = intent.getStringExtra("id_hotel");
        nama_hotel = intent.getStringExtra("nama_hotel");
        alamat_hotel = intent.getStringExtra("alamat_hotel");
        checkin = intent.getStringExtra("checkin");
        checkout = intent.getStringExtra("checkout");
        tamu = intent.getStringExtra("tamu");
        kamar = intent.getStringExtra("kamar");
        tot_malam = intent.getStringExtra("tot_malam");
        tujuan = intent.getStringExtra("tujuan");

        tot_kamar = Integer.parseInt(kamar);

        tv_nama_hotel = (TextView) findViewById(R.id.tv_nama_hotel);
        tv_alamat = (TextView) findViewById(R.id.tv_alamat);

        mRecyclerView = findViewById(R.id.recycler_view_kamar);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.setHasFixedSize(true);
        myAdapter = new KamarAdapter(getApplicationContext(), mItems,
                checkin, checkout, tamu, kamar, tot_malam, tujuan);
        mRecyclerView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();

        swipeRefreshLayout = findViewById(R.id.swipe);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                        myAdapter.clear();
                        loadJson();
                    }
                }, 1000);
            }
        });

        //Toast.makeText(getApplicationContext(), "Detail kamar"+kamar, Toast.LENGTH_SHORT).show();

        tv_nama_hotel.setText(nama_hotel);
        tv_alamat.setText(alamat_hotel);

        loadJson();
    }

    private void loadJson() {
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        //making the progressbar visible
        progressBar.setVisibility(View.VISIBLE);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_KAMAR,
                new Response.Listener<String>() {
                    public void onResponse(String response){
                        progressBar.setVisibility(View.INVISIBLE);
                        Log.d("json", response.toString());

                        try {
                            JSONArray jsonArray =  new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                if(jsonObject.getString("id_hotel").equals(id_hotel)) {
                                    if(jsonObject.getInt("stok_ruangan") >= tot_kamar){
                                        mItems.add(new Kamar(jsonObject.getString("id_kamar"),
                                                jsonObject.getString("id_hotel"),
                                                jsonObject.getString("nama_hotel"),
                                                jsonObject.getString("nama_ruangan"),
                                                jsonObject.getString("max_orang"),
                                                jsonObject.getInt("stok_ruangan"),
                                                jsonObject.getString("ukuran_ruangan"),
                                                jsonObject.getString("kelengkapan"),
                                                jsonObject.getString("wifi"),
                                                jsonObject.getString("tipe_ruangan"),
                                                jsonObject.getString("deskripsi_ruangan"),
                                                Server.URL_FOTO +  jsonObject.getString("foto1"),
                                                Server.URL_FOTO +  jsonObject.getString("foto2")));
                                   }
                                }


                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }

    public void back(View view){
        super.onBackPressed();
    }
}
