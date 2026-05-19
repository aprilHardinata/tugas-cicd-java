/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Main.User;

import com.mycompany.Main.Operasional.Login;
import com.mycompany.Main.fitur.Pembayaran;
import com.mycompany.Main.fitur.Pengiriman;
import com.mycompany.Main.fitur.Pesanan;
import com.mycompany.Main.fitur.Produk;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Pembeli extends Login{
    private String alamat;
    private int no_telp;
    private String email;
    private Kurir kurirTerpilih;
    private Produk produkDipesan;

    public Pembeli(String username, String password, String alamat, int no_telp, String email) {
        super(username, password);
        this.alamat = alamat;
        this.no_telp = no_telp;
        this.email = email;
    }
    
    @Override
    public void login(String username, String password) {
        if (authenticate(username, password)) {
            System.out.println(super.toString());
        } else {
            throw new SecurityException("Username atau password salah!");
        }
    }

    @Override
    public void logout() {
        System.out.println("Logout berhasil sebagai Pembeli: " + getUsername());
    }

    public String getAlamat() {
        return alamat;
    }

    public int getNo_telp() {
        return no_telp;
    }

    public String getEmail() {
        return email;
    }
   
    public void lihatBarang(ArrayList<Produk> dataProduk) {
        if (dataProduk.isEmpty()) {
            System.out.println("Tidak ada produk yang tersedia.");
        } else {
            int nomor = 1;
            System.out.println("Daftar Produk: ");
            for (Produk produk : dataProduk) {
                System.out.println("Nomor: "+nomor);
                System.out.println("Nama: "+ produk.getNamaBarang());
                System.out.println("Harga: " + String.format("%.0f", produk.getHargaBarang()));
                System.out.println("Jenis: " + produk.getJenisBarang());
                System.out.println("Stok: "+ produk.getStok());
                System.out.println("----------------------------");
                nomor++;
            }
        }
    }
    
    public void checkOut(ArrayList<Produk> daftarProduk, ArrayList<Kurir> daftarKurir) {
        Scanner scanner = new Scanner(System.in);
        lihatBarang(daftarProduk);
        ArrayList<Produk> keranjang = new ArrayList<>();
        while (true) {
            System.out.println("\nMasukkan nomor barang yang ingin dibeli (atau 0 untuk selesai): ");
            int pilihan = scanner.nextInt();
            if (pilihan == 0) break;

            if (pilihan > 0 && pilihan <= daftarProduk.size()) {
                Produk produkDipilih = daftarProduk.get(pilihan - 1);

                // Masukkan ke keranjang dan kurangi stok
                System.out.println("Berapa banyak yang ingin Anda beli?");
                int jumlah = scanner.nextInt();
                if (jumlah <= produkDipilih.getStok() && jumlah > 0) {
                    produkDipilih.setStok(produkDipilih.getStok() - jumlah);
                    keranjang.add(new Produk(produkDipilih.getId(), produkDipilih.getKodeBarang(), produkDipilih.getNamaBarang(),
                                              produkDipilih.getJenisBarang(), produkDipilih.getHargaBarang(), jumlah));
                    System.out.println("Produk ditambahkan ke keranjang!");
                } else {
                    System.out.println("Stok tidak mencukupi atau jumlah tidak valid!");
                }
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }

        // 3. Hitung total harga
        int totalHarga = 0;
        for (Produk produk : keranjang) {
            totalHarga += produk.getHargaBarang()* produk.getStok(); // Di keranjang, "stok" digunakan sebagai jumlah yang dibeli
        }

        // 4. Lanjutkan ke proses checkout
        System.out.println("\nSistem sedang membuat pesanan...");
        String idPesanan = "PES" + System.currentTimeMillis();
        String tglPesanan = "2024-12-17";
        Pesanan pesanan = new Pesanan(idPesanan, tglPesanan, totalHarga, this.getUsername());
        pesanan.buatPesanan();

        // 5. Pilih metode pembayaran
        System.out.println("\nPilih metode pembayaran:");
        System.out.println("1. Transfer Bank");
        System.out.println("2. E-Wallet");
        System.out.println("3. Cash on Delivery (COD)");
        int pilihanMetode = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        String metodePembayaran = switch (pilihanMetode) {
            case 1 -> "Transfer Bank";
            case 2 -> "E-Wallet";
            case 3 -> "COD";
            default -> "COD";
        };
        long idPesananNumeric = Long.parseLong(idPesanan.substring(3));

        Pembayaran pembayaran = new Pembayaran(1, idPesananNumeric, metodePembayaran);

        // 6. Pilih kurir
        System.out.println("\nPilih kurir untuk pengiriman:");
        for (int i = 0; i < daftarKurir.size(); i++) {
            Kurir kurir = daftarKurir.get(i);
            System.out.println((i + 1) + ". Nama Kurir: " + kurir.getUsername()+
                               ", Nomor Telepon: " + kurir.getNomorTelephone());
        }
        int pilihanKurir = scanner.nextInt();
        scanner.nextLine();
        Kurir kurirTerpilih = daftarKurir.get(pilihanKurir - 1);

        // 7. Masukkan alamat pengiriman
        System.out.println("\nMasukkan alamat pengiriman:");
        String alamatPengiriman = scanner.nextLine();

        Pengiriman pengiriman = new Pengiriman(1, idPesananNumeric, pilihanKurir, alamatPengiriman.hashCode());
        System.out.println("Pengiriman telah diinputkan!");

        System.out.println("\n-----------------------Checkout berhasil!-----------------------");
        System.out.println("ID Pesanan: " + idPesanan);
        System.out.println("Barang yang dipesan:");
        for (Produk produk : keranjang) {
            System.out.println("- Nama: " + produk.getNamaBarang() + ", Jumlah: " + produk.getStok() + 
                               ", Harga per unit: " + produk.getHargaBarang());
        }
        System.out.println("Alamat Pengiriman: " + alamatPengiriman);
        System.out.println("Kurir: " + kurirTerpilih.getUsername());
        System.out.println("Total harga: "+ totalHarga);
    }
}
