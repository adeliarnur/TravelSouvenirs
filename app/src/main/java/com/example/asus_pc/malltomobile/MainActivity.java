package com.example.asus_pc.malltomobile;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
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

public class MainActivity extends AppCompatActivity {
    Button login;
    Button daftar;

    String idUser;

    EditText username, password;

    DatabaseReference data;
    List<User> listUser;

    ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        listUser = new ArrayList<>();
        data = FirebaseDatabase.getInstance().getReference("User");
        loadData();

        loading = new ProgressDialog(this);


        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString();
                String pass = password.getText().toString();
                if (!TextUtils.isEmpty(uname)){
                    if (!TextUtils.isEmpty(pass)){
                        loading.setMessage("Wait a sec...");
                        loading.setCancelable(false);
                        loading.show();
                        if (findUser(uname, pass)){
                            final Intent intent = new Intent(MainActivity.this, Menu.class);
                            intent.putExtra("ID_USER", idUser);
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    loading.dismiss();
                                    startActivity(intent);
                                }
                            }, 2000);


                        }
                    } else{
                        Toast.makeText(MainActivity.this, "Pengguna tidak ditemukan :(", Toast.LENGTH_SHORT).show();
                    }
                }  else{
                    Toast.makeText(MainActivity.this, "Pengguna tidak ditemukan :(", Toast.LENGTH_SHORT).show();
                }
            }
        });

        daftar = (Button) findViewById(R.id.register);
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Daftar.class);
                startActivity(intent);
            }
        });
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

    private boolean findUser(String username, String password){
        boolean ketemu = false;

        for (int i=0; i<listUser.size(); i++){
            User user = listUser.get(i);
            if (user.getNama().equals(username)){
                if (user.getPassword().equals(password)){
                    idUser = user.getId();
                    ketemu = true;
                    break;
                }
            }
        }

        return ketemu;
    }
}
