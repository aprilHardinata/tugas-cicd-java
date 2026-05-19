/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Main.fitur;

/**
 *
 * @author ASUS
 */
public class Pembayaran {
    int id_pembayaran;
    long id_pesanan;
    String metode_pembayran;

    public Pembayaran(int id_pembayaran, long id_pesanan, String metode_pembayran) {
        this.id_pembayaran = id_pembayaran;
        this.id_pesanan = id_pesanan;
        this.metode_pembayran = metode_pembayran;
    }

    public int getId_pembayaran() {
        return id_pembayaran;
    }

    public long getId_pesanan() {
        return id_pesanan;
    }

    public String getMetode_pembayran() {
        return metode_pembayran;
    }

    public void setId_pembayaran(int id_pembayaran) {
        this.id_pembayaran = id_pembayaran;
    }

    public void setId_pesanan(int id_pesanan) {
        this.id_pesanan = id_pesanan;
    }

    public void setMetode_pembayran(String metode_pembayran) {
        this.metode_pembayran = metode_pembayran;
    }
}
