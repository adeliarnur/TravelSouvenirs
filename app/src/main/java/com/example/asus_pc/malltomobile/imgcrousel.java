package com.example.asus_pc.malltomobile;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.asus_pc.malltomobile.R.mipmap.ic_uwong;

public class imgcrousel extends AppCompatActivity {
    ViewPager viewPager;
    Button button;
    Integer [] img = Menu.img;
    String a = Menu.a;

    String idUser;

    TextView Nama, Harga, Avaiable;
    ImageButton orderNow;

    DatabaseReference order;
    ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imgcrousel);

        idUser = getIntent().getStringExtra("ID_USER");

        order = FirebaseDatabase.getInstance().getReference("Order");

        Nama = (TextView) findViewById(R.id.textView);
        Harga = (TextView) findViewById(R.id.textView2);
        Avaiable = (TextView) findViewById(R.id.textView3);
        orderNow = (ImageButton) findViewById(R.id.orderNow);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, img);

        loading = new ProgressDialog(this);

        Nama.setText(Menu.Nama);
        Harga.setText(Menu.Price);
        Avaiable.setText(Menu.Avaiable);

        viewPager.setAdapter(viewPagerAdapter);

        orderNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading.setMessage("Wait a sec...");
                loading.setCancelable(false);
                loading.show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loading.dismiss();
                        Toast.makeText(imgcrousel.this, "Berhasil menambahkan !", Toast.LENGTH_SHORT).show();
                    }
                }, 1500);
                String nama = Nama.getText().toString();
                String harga = Harga.getText().toString();
                Order o = new Order(nama, harga);
                order.child(idUser).child(nama).setValue(o);
            }
        });
    }
}
