/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.Main;

import com.mycompany.Main.fitur.Produk;
import com.mycompany.Main.Operasional.Login;
import com.mycompany.Main.User.Pembeli;
import com.mycompany.Main.User.Penjual;
import com.mycompany.Main.User.Kurir;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
class menuPembeli{
    public static void menu(){
        System.out.println("-----------------E-commerce-----------------");
        System.out.println("1. lihat barang");
        System.out.println("2. checkout");
        System.out.println("3. Logout");
        System.out.print("Masukkan pilihan: ");
    }
}

class menuPenjual{
    public static void menu(){
        System.out.println("-----------------E-commerce-----------------");
        System.out.println("1. Tampil barang ");
        System.out.println("2. Tambah barang");
        System.out.println("3. Edit Barang");
        System.out.println("4. Hapus Barang");
        System.out.println("5. Logout");
        System.out.print("Masukkan pilihan: ");
    }
}

public class Tubess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Produk> dataProduk = new ArrayList<>();
        dataProduk.add(new Produk(1, 101, "Laptop", "Elektronik", 15000000, 10));
        dataProduk.add(new Produk(2, 102, "Smartphone", "Elektronik", 5000000, 20));
        
        ArrayList<Kurir> daftarKurir = new ArrayList<>();
        daftarKurir.add(new Kurir("Kurir1", "password1", "081234567890"));
        daftarKurir.add(new Kurir("April", "password2", "089876543210"));
        daftarKurir.add(new Kurir("JNE", "anomali"));
        
        Login pembeli = new Pembeli("Angga", "anggaKetua", "Sukabirus", 1111, "Angga@gmail.com");
        Login penjual = new Penjual("1001", "ariff", "ariff555", dataProduk);

        int pilihan = -1;
            while (pilihan != 3) {
                System.out.println("-----------------E-commerce-----------------");
                System.out.println("1. Login sebagai pembeli");
                System.out.println("2. Login sebagai penjual");
                System.out.println("3. Keluar");
                System.out.print("Masukkan pilihan: ");
                pilihan = scanner.nextInt();

                switch (pilihan) {
                    case 1 -> {
                    try {
                        System.out.println("\n=== Login sebagai Pembeli ===");
                        scanner.nextLine(); 
                        System.out.print("Masukkan Username: ");
                        String username = scanner.nextLine();

                        System.out.print("Masukkan Password: ");
                        String password = scanner.nextLine();

                        pembeli.login(username, password); 

                        int subPilihan = -1;
                        while (subPilihan != 3) {
                            menuPembeli.menu();
                            subPilihan = scanner.nextInt();
                            scanner.nextLine(); 

                            switch (subPilihan) {
                                case 1 -> ((Pembeli) pembeli).lihatBarang(dataProduk);
                                case 2 -> ((Pembeli) pembeli).checkOut(dataProduk, daftarKurir);
                                case 3 -> pembeli.logout();
                                default -> System.out.println("Pilihan tidak valid.");
                            }
                        }
                    } catch (SecurityException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                    case 2 -> {
                    try {
                        System.out.println("\n=== Login sebagai Penjual ===");
                        scanner.nextLine(); 
                        System.out.print("Masukkan Username: ");
                        String username = scanner.nextLine();

                        System.out.print("Masukkan Password: ");
                        String password = scanner.nextLine();

                        penjual.login(username, password); 

                        int pilihanPenjual = -1;
                        while (pilihanPenjual != 5) { 
                            menuPenjual.menu(); 
                            pilihanPenjual = scanner.nextInt();

                            switch (pilihanPenjual) {
                                case 1 -> ((Penjual)penjual).lihatBarang(); 
                                case 2 -> ((Penjual)penjual).tambahBarang();
                                case 3 -> ((Penjual)penjual).updateBarang();
                                case 4 -> ((Penjual)penjual).deleteBarang();
                                case 5 -> System.out.println("Log out Sebagai penjual.");
                                default -> System.out.println("Pilihan tidak valid.");
                            }
                        }
                    } catch (SecurityException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                    
                    case 3 -> System.out.println("Keluar dari aplikasi.");
                    default -> System.out.println("Pilihan tidak valid.");
                }
            }

    }
}
