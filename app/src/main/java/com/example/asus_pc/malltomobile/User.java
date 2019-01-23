package com.example.asus_pc.malltomobile;

/**
 * Created by ASUS-PC on 11/17/2017.
 */

public class User {

    private String id;
    private  String nama;
    private String password;
    private String email;
    private String alamat;

    public User(){}

    public User(String id, String nama, String password, String email, String alamat) {
        this.id = id;
        this.nama = nama;
        this.password = password;
        this.email = email;
        this.alamat = alamat;

    }

    public String getNama() {
        return nama;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getId() {
        return id;
    }
}
