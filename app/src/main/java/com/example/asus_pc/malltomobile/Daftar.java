package com.example.asus_pc.malltomobile;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Daftar extends AppCompatActivity {

    EditText username, password, email, alamat;
    DatabaseReference data;
    String username1, password1, email1, alamat1;
    Button register;
    Button msuk;

    List<User> listUser;

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);                   //untuk menset activity yg mau dieksekusi

        data = FirebaseDatabase.getInstance().getReference("User");   //tempat menampung username,password,email, dan alamat
        loadData();

        register = (Button) findViewById(R.id.register);            //untuk menambahkan id register untuk menyimpan

        pd = new ProgressDialog(this);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email);
        alamat = (EditText) findViewById(R.id.alamat);

        username.setText("");
        password.setText("");
        email.setText("");
        alamat.setText("");

        listUser = new ArrayList<>();


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Memproses data...", Toast.LENGTH_SHORT).show();
                username1 = username.getText().toString();          //.toString = untuk convert ke type data string
                password1 = password.getText().toString();
                email1 = email.getText().toString();
                alamat1 = alamat.getText().toString();

                if (!TextUtils.isEmpty(username1)){
                    if(!TextUtils.isEmpty(password1)){
                        if(!TextUtils.isEmpty(email1)){
                            if(!TextUtils.isEmpty(alamat1)){
                                inputData();
                            } else{
                                Toast.makeText(getApplicationContext(), "Gagal mendaftar! Periksa kembali form anda!", Toast.LENGTH_SHORT).show();
                            }
                        }  else{
                            Toast.makeText(getApplicationContext(), "Gagal mendaftar! Periksa kembali form anda!", Toast.LENGTH_SHORT).show();
                        }
                    }  else{
                        Toast.makeText(getApplicationContext(), "Gagal mendaftar! Periksa kembali form anda!", Toast.LENGTH_SHORT).show();
                    }
                }  else{
                    Toast.makeText(getApplicationContext(), "Gagal mendaftar! Periksa kembali form anda!", Toast.LENGTH_SHORT).show();
                }
            }
        });
//        msuk = (Button) findViewById(R.id.register);
//        msuk.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Daftar.this, Menu.class);
//                startActivity(intent);
//            }
//        }
//        );
    }

    private void inputData(){
        pd.setMessage("Memproses data...");
        pd.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                pd.dismiss();
                boolean banding  = false;
                for (int i =0; i<listUser.size(); i++){
                    User u = listUser.get(i);
                    if (email1.equals(u.getEmail())){
                        banding = true;
                        break;
                    }
                }
                if(!banding) {
                    String id = data.push().getKey();
                    User user = new User(id, username1, password1, email1, alamat1);
                    data.child(id).setValue(user);
                    Intent intent = new Intent(getApplicationContext(), Menu.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Daftar Berhasil!!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "sudah terdaftar", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent (getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        }, 3000);

    }

    private void loadData(){
        data.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot getData : dataSnapshot.getChildren()){
                    User user = getData.getValue(User.class);
                    listUser.add(user);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
