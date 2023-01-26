package com.sourcey.check_in;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

import static com.sourcey.check_in.LoginActivity.TAG_EMAIL;
import static com.sourcey.check_in.LoginActivity.TAG_NAMA;
import static com.sourcey.check_in.LoginActivity.TAG_TELP;

import com.sourcey.check_in.R;
import com.sourcey.check_in.model.Order;

public class KonfirmasiActivity extends AppCompatActivity {

    String id_hotel, id_kamar, nama_hotel, nama_kamar, checkin, checkout, tot_malam, tot_tamu, tot_kamar, perjalanan,
            max_orang, ukuran_kamar, sarapan, wifi, tipe_kasur;
    TextView tv_nama_hotel, tv_checkin, tv_checkout, tv_jenis_kamar, tv_max_orang, tv_ukuran, tv_sarapan, tv_wifi,
            tv_tipe_kasur, tv_nama_pemesan, tv_tipe_kamar, tv_tot_malam_kamar;
    Button btn_lanjut;

    SharedPreferences sharedPreferences;
    String nama, email, no_telp;

    Locale localeID = new Locale("in", "ID");
    NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirmasi);

        sharedPreferences = getSharedPreferences(LoginActivity.my_shared_preferences, Context.MODE_PRIVATE);
        email =sharedPreferences.getString(TAG_EMAIL,null);
        nama =sharedPreferences.getString(TAG_NAMA,null);
        no_telp = sharedPreferences.getString(TAG_TELP, null);


        tv_nama_hotel = (TextView) findViewById(R.id.tv_nama_hotel);
        tv_checkin = (TextView) findViewById(R.id.tv_checkin);
        tv_checkout = (TextView) findViewById(R.id.tv_checkout);
        tv_jenis_kamar = (TextView) findViewById(R.id.tv_jenis_kamar);
        tv_max_orang = (TextView) findViewById(R.id.tv_max_orang);
        tv_ukuran = (TextView) findViewById(R.id.tv_ukuran);
        tv_sarapan = (TextView) findViewById(R.id.tv_sarapan);
        tv_wifi = (TextView) findViewById(R.id.tv_wifi);
        tv_tipe_kasur = (TextView) findViewById(R.id.tv_tipe_kasur);
        tv_nama_pemesan = (TextView) findViewById(R.id.tv_nama_pemesan);
        btn_lanjut = (Button) findViewById(R.id.btn_lanjut);

        Intent intent = getIntent();
        id_hotel = intent.getStringExtra("id_hotel");
        id_kamar = intent.getStringExtra("id_kamar");
        nama_hotel = intent.getStringExtra("nama_hotel");
        nama_kamar = intent.getStringExtra("nama_ruangan");
        checkin = intent.getStringExtra("checkin");
        checkout = intent.getStringExtra("checkout");
        tot_malam = intent.getStringExtra("tot_malam");
        tot_tamu = intent.getStringExtra("tot_tamu");
        tot_kamar = intent.getStringExtra("tot_kamar");
        perjalanan = intent.getStringExtra("perjalanan");

        tipe_kasur = intent.getStringExtra("tipe_ruangan");
        max_orang = intent.getStringExtra("max_orang");
        ukuran_kamar = intent.getStringExtra("ukuran_ruangan");
        sarapan = intent.getStringExtra("kelengkapan");
        wifi = intent.getStringExtra("wifi");

        if (sarapan.equals("yes")){
            tv_sarapan.setText("Termasuk Sarapan");
        } else{
            tv_sarapan.setText("Tanpa sarapan");
        }
        if (wifi.equals("yes")){
            tv_wifi.setText("Wi-fi gratis");
        } else {
            tv_wifi.setText("Tanpa Wi-fi");
        }

        tv_tipe_kasur.setText("Tipe kasur : " +tipe_kasur);
        tv_max_orang.setText("Maks. " + max_orang + " orang");
        tv_ukuran.setText(ukuran_kamar + " m");

        tv_nama_hotel.setText(nama_hotel);
        tv_checkin.setText(checkin);
        tv_checkout.setText(checkout);
        tv_jenis_kamar.setText(nama_kamar);
        tv_nama_pemesan.setText(nama);
        tv_tipe_kamar.setText(nama_kamar);
        tv_tot_malam_kamar.setText(tot_malam + " Malam - " + tot_kamar + " Kamar");


        btn_lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Order.class);
                intent.putExtra("id_hotel", id_hotel);
                intent.putExtra("id_kamar", id_kamar);
                intent.putExtra("nama_hotel", nama_hotel);
                intent.putExtra("nama_ruangan", nama_kamar);
                intent.putExtra("checkin", checkin);
                intent.putExtra("checkout", checkout);
                intent.putExtra("tot_malam", tot_malam);
                intent.putExtra("tot_tamu", tot_tamu);
                intent.putExtra("tot_kamar", tot_kamar);
                intent.putExtra("perjalanan", perjalanan);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public void back(View view){
        super.onBackPressed();
    }
}
