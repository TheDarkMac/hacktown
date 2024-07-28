package com.hei.hackathon.hackathon.services.implementation;

import com.hei.hackathon.hackathon.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    final String ALGORITHM = "AES";
    final byte[] KEY = "capdata2023capdat".getBytes();

    @Override
    public byte[] encryptPassword(String password)
            throws NoSuchPaddingException,
            NoSuchAlgorithmException,
            InvalidKeyException,
            IllegalBlockSizeException,
            BadPaddingException {

        SecretKey secretKey = new SecretKeySpec(KEY, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        return cipher.doFinal(password.getBytes());
    }

    @Override
    public String decryptPassword(byte[] encryptedPassword)
            throws NoSuchPaddingException,
            NoSuchAlgorithmException,
            InvalidKeyException,
            IllegalBlockSizeException,
            BadPaddingException {

        SecretKey secretKey = new SecretKeySpec(KEY, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        return new String(cipher.doFinal(encryptedPassword));
    }
}
