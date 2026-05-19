/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Main.Operasional;

import java.util.HashMap;

/**
 *
 * @author ASUS
 */
public abstract class Login  implements IUserActions{
    private String username;
    private String password;
    private static HashMap<String, String> users = new HashMap<>();

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
        users.put(username, password);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Login berhasil sebagai " + username;
    }

    protected boolean authenticate(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}

