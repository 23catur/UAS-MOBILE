package com.sourcey.check_in;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.sourcey.check_in.Server.Server;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

public class Editprofile extends AppCompatActivity {
    ProgressDialog pDialog;
    int success;
    private static final String TAG = Editprofile.class.getSimpleName();
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";
    ConnectivityManager conMgr;
    String tag_json_obj = "json_obj_req";
    private String url = Server.URL + "Android/ApiEdit.php";
    Boolean session = false;
    public final static String TAG_EMAIL = "email";
    public final static String TAG_NAMA = "nama";
    public final static String TAG_NIM = "nim";
    public final static String TAG_TELP = "no_telp";
    public final static String TAG_KELAS = "kelas";
    public final static String TAG_ID = "id_user";
    String id_user, nama, nim, email, no_telp, kelas, level;


    @BindView(R.id.input_name) EditText et_nama;
    @BindView(R.id.input_kelas) EditText et_kelas;
    @BindView(R.id.input_email) EditText et_email;
    @BindView(R.id.input_mobile) EditText et_no_telp;
    @BindView(R.id.input_password) EditText et_pass;
    @BindView(R.id.input_nim) EditText et_nim;
    @BindView(R.id.BTNUpdate) Button etButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);



        //Intent, get data from main
        nim = getIntent().getStringExtra("nim");
        nama = getIntent().getStringExtra("nama");
        email = getIntent().getStringExtra("email");
        no_telp = getIntent().getStringExtra("no_telp");
        kelas = getIntent().getStringExtra("kelas");

        //Toast.makeText(edit_mahasiswa.this,nim,Toast.LENGTH_LONG).show();

        et_nim = findViewById(R.id.input_nim);
        et_nama = findViewById(R.id.input_name);
        et_email = findViewById(R.id.input_email);
        et_no_telp = findViewById(R.id.input_mobile);
        et_kelas = findViewById(R.id.input_kelas);
        etButton = findViewById(R.id.BTNUpdate);

        et_nim.setText(nim);
        et_nama.setText(nama);
        et_email.setText(email);
        et_no_telp.setText(no_telp);
        et_kelas.setText(kelas);

        pDialog = new ProgressDialog(this);

        etButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pDialog.setMessage("Updating Data...");
                pDialog.setCancelable(false);
                pDialog.show();

                nim = et_nim.getText().toString();
                nama = et_nama.getText().toString();
                email = et_email.getText().toString();
                no_telp = et_no_telp.getText().toString();
                kelas = et_kelas.getText().toString();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        validatingData();
                    }
                }, 1000);
            }
        });

    }

    void validatingData() {
        if (nim.equals("") || nama.equals("") || email.equals("") || no_telp.equals("") || kelas.equals("")) {
            pDialog.dismiss();
            Toast.makeText(Editprofile.this, "Check your input!", Toast.LENGTH_SHORT).show();
        } else {
            updateData();
        }
    }

    void updateData() {
        AndroidNetworking.post("http://tekajeapunya.com/kelompok_4/ROOM_IN/Android/ApiEdit.php")
                .addBodyParameter("nim", "" + nim)
                .addBodyParameter("name", "" + nama)
                .addBodyParameter("email", "" + email)
                .addBodyParameter("no_telp", "" + no_telp)
                .addBodyParameter("kelas", "" + kelas)
                .setPriority(Priority.MEDIUM)
                .setTag("Update Data")
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        pDialog.dismiss();
                        Log.d("cekUpdate", "" + response);
                        try {
                            Boolean status = response.getBoolean("status");
                            String pesan = response.getString("result");
                            Toast.makeText(Editprofile.this, "" + pesan, Toast.LENGTH_SHORT).show();
                            Log.d("status", "" + status);
                            if (status) {
                                new AlertDialog.Builder(Editprofile.this)
                                        .setMessage("Data berhasil di update !")
                                        .setCancelable(false)
                                        .setPositiveButton("Kembali", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                //Intent i = getIntent();
                                                //setResult(RESULT_OK,i);
                                                //add_mahasiswa.this.finish();
                                            }
                                        })
                                        .show();
                            } else {
                                new AlertDialog.Builder(Editprofile.this)
                                        .setMessage("Gagal Menambahkan Data !")
                                        .setPositiveButton("Kembali", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                //Intent i = getIntent();
                                                //setResult(RESULT_CANCELED,i);
                                                //add_mahasiswa.this.finish();
                                            }
                                        })
                                        .setCancelable(false)
                                        .show();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    }

                    @Override
                    public void onError(ANError anError) {
                        //  Log.d("Tidak dapat memperbarui data Anda", "" + anError.getErrorBody());

                        Log.d("Tidak dapat memperbarui", "" + anError.getErrorBody());
                    }
                });
    }

    {

    };




    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

    public void back(View view) {
        super.onBackPressed();
    }

}
