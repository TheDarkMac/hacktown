package com.hei.hackathon.hackathon.services;

public interface CryptoService {
    String decrypt(String encrypted);

    String encrypt(String decrypted);
}
