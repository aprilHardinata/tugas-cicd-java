package com.mycompany.Main.Operasional;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

// Import subclass yang kamu miliki di project
import com.mycompany.Main.User.Pembeli;

public class LoginTest {

    @Test
    public void testAuthenticateBerhasil() {
        // Constructor Pembeli: nama, password, alamat, id, email (disesuaikan dengan kode Tubess.java)
        Pembeli testPembeli = new Pembeli("Angga", "anggaKetua", "Sukabirus", 1111, "Angga@gmail.com");

        // gunakan Java Assertion untuk mengecek method authenticate bawaan dari parent class (Login)
        assertTrue(testPembeli.authenticate("Angga", "anggaKetua"), 
                "true karena username dan password benar.");
    }

    @Test
    public void testAuthenticateGagalPasswordSalah() {
        Pembeli testPembeli = new Pembeli("Angga", "anggaKetua", "Sukabirus", 1111, "Angga@gmail.com");

        // Memastikan login gagal kalau password sengaja disalahkan
        assertFalse(testPembeli.authenticate("Angga", "salahPassword"), 
                "false karena password salah.");
    }
}