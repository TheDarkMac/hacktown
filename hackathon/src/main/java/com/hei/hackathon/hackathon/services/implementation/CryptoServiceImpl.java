package com.hei.hackathon.hackathon.services.implementation;

public class CryptoServiceImpl {

    public static int charCode(char c) {
        c = Character.toUpperCase(c);
        return (int) c - 65;
    }

    public static String encrypts(String decrypted) {
        String s = decrypted.toUpperCase();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = decrypted.charAt(i);

            if (Character.isLetter(currentChar)) {
                boolean isUpperCase =
                        (String.valueOf(currentChar)
                                .equals(String.valueOf(currentChar).toUpperCase()));

                int unicode = charCode(currentChar) + 13;
                unicode = unicode % 26;
                char res = (char) (unicode + 65);

                if (isUpperCase) {
                    result.append(res);
                } else {
                    result.append(Character.toLowerCase(res));
                }
            } else {
                result.append(currentChar);
            }
        }
        return result.toString();
    }

    public static String decrypts(String encrypted) {
        String s = encrypted.toUpperCase();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = encrypted.charAt(i);

            if (Character.isLetter(currentChar)) {
                boolean isUpperCase =
                        (String.valueOf(currentChar)
                                .equals(String.valueOf(currentChar).toUpperCase()));

                int unicode = charCode(currentChar) + 13;
                unicode = unicode % 26;
                char res = (char) (unicode + 65);

                if (isUpperCase) {
                    result.append(res);
                } else {
                    result.append(Character.toLowerCase(res));
                }
            } else {
                result.append(currentChar);
            }
        }
        return result.toString();
    }
}
