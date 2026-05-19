/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Main.User;

import com.mycompany.Main.Operasional.Login;

/**
 *
 * @author ASUS
 */
public class Kurir extends Login{
    private String nomorTelephone;
    
    public Kurir(String User_name, String password, String nomorTelephone) {
        super(User_name, password);
        this.nomorTelephone = nomorTelephone;
    }

    public Kurir(String username, String password) {
        super(username, password);
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
        System.out.println("Logout berhasil sebagai Kurir: " + getUsername());
    }

    public String getNomorTelephone() {
        return nomorTelephone;
    }
    
}
