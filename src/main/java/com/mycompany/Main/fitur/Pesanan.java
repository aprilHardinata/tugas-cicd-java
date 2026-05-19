/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Main.fitur;

/**
 *
 * @author ASUS
 */
public class Pesanan {
    private String idPesanan;
    private String tglPesanan;
    private int totalHarga;
    private String idPelanggan;

    public Pesanan(String idPesanan, String tglPesanan, int totalHarga, String idPelanggan) {
        this.idPesanan = idPesanan;
        this.tglPesanan = tglPesanan;
        this.totalHarga = totalHarga;
        this.idPelanggan = idPelanggan;
    }

    public void buatPesanan() {
        System.out.println("sistem telah membuat pesanan");
    }
    
    public void ubahStatus() {
        System.out.println("sistem telah berhasil mengubah status");
    }
}

