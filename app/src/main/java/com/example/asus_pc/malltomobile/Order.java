package com.example.asus_pc.malltomobile;

/**
 * Created by ASUS-PC on 11/24/2017.
 */

public class Order {
//    private int size;
    private String harga;
    private String nama;

    public Order(String nama, String harga){
        this.nama = nama;
        this.harga = harga;
    }

    public Order(){
    }

    public String getNama(){
        return nama;
    }

    public String getHarga(){
        return harga;
    }

}
