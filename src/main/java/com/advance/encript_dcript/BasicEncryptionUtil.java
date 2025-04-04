package com.advance.encript_dcript;

import java.util.Base64;

public class BasicEncryptionUtil {

    // Encrypt data using Base64 encoding
    public static String encrypt(String data) {
        try {
            return Base64.getEncoder().encodeToString(data.getBytes());
        } catch (Exception e) {
            throw new RuntimeException("Error encrypting data", e);
        }
    }

    // Decrypt data using Base64 decoding
    public static String decrypt(String encryptedData) {
        if (encryptedData == null || encryptedData.isEmpty()) {
            return "Invalid Data";
        }
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
            return new String(decodedBytes);
        } catch (IllegalArgumentException e) {
            System.err.println("Decryption failed for data: " + encryptedData);
            return "Invalid Data";
        }
    }

    // Validates if the data is encrypted (Base64 encoded)
    public static boolean isValidEncryptedData(String data) {
        return data != null && data.matches("^[A-Za-z0-9+/=]+$");
    }
}


