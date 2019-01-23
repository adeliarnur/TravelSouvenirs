package com.example.asus_pc.malltomobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Menu extends AppCompatActivity {
    ImageButton button1, button2, button3, button4, button5, button6;
    public static Integer [] img;
    public static String a;
    public static String Nama,Price, Avaiable;

    public String idUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        idUser = getIntent().getStringExtra("ID_USER");

        button1 = (ImageButton) findViewById(R.id.orang);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, imgcrousel.class);
                Integer [] images1 = {R.drawable.bali1, R.drawable.bali2, R.drawable.bali3};
                img = images1;
                Nama = "Oleh-oleh khas BALI";
                Price = "Rp. 60.000,00";
                Avaiable = "2 Days";
                intent.putExtra("ID_USER", idUser);
                startActivity(intent);
            }
        });


        button2 = (ImageButton) findViewById(R.id.gramd);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, imgcrousel.class);
                Integer [] images2 = {R.drawable.bdg1, R.drawable.bdg2, R.drawable.bdg3};
                img = images2;
                Nama = "Oleh-oleh khas BANDUNG";
                Price = "Rp. 90.000,00";
                Avaiable = "3 Days";
                intent.putExtra("ID_USER", idUser);
                startActivity(intent);
            }
        });

        button3 = (ImageButton) findViewById(R.id.vcrs);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, imgcrousel.class);
                Integer [] images3 = {R.drawable.lmg1, R.drawable.lmg2, R.drawable.lmg3};
                img = images3;
                Nama = "Oleh-oleh khas LAMONGAN";
                Price = "Rp. 50.000,00";
                Avaiable = "1 days";
                intent.putExtra("ID_USER", idUser);
                startActivity(intent);
            }
        });

        button4 = (ImageButton) findViewById(R.id.mthr);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, imgcrousel.class);
                Integer [] images4 = {R.drawable.mlg1, R.drawable.mlg2, R.drawable.mlg3};
                img = images4;
                Nama = "Oleh-oleh khas MALANG";
                Price = "Rp. 150.000,00";
                Avaiable = "2 days";
                intent.putExtra("ID_USER", idUser);
                startActivity(intent);
            }
        });

        button5 = (ImageButton) findViewById(R.id.lvs);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, imgcrousel.class);
                Integer [] images5 = {R.drawable.smrng1, R.drawable.smrng2, R.drawable.smrng3};
                img = images5;
                Nama = "Oleh-oleh khas SEMARANG";
                Price = "Rp. 125.000,00";
                Avaiable = "1 days";
                intent.putExtra("ID_USER", idUser);
                startActivity(intent);
            }
        });

        button6 = (ImageButton) findViewById(R.id.vans);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, imgcrousel.class);
                Integer [] images6 = {R.drawable.ygy1, R.drawable.ygy2, R.drawable.ygy3};
                img = images6;
                Nama = "Oleh-oleh khas YOGYAKARTA";
                Price = "Rp. 60.000,00";
                Avaiable = "2 days";
                intent.putExtra("ID_USER", idUser);
                startActivity(intent);
            }
        });

    }

}