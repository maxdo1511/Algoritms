package ru.hbb.algoritms.Tests;

import ru.hbb.algoritms.UtilClasses.Cryptographer.Cryptographer;
import ru.hbb.algoritms.UtilClasses.Cryptographer.KeyType;

public class CryptographerTest {

    public static void main(String[] args) {
        Cryptographer cryptographer = new Cryptographer(KeyType.CESAR);
        String encript_str = cryptographer.encrypt("max", "5");
        System.out.println(encript_str);
        System.out.println(cryptographer.decrypt(encript_str, "5"));
        cryptographer = new Cryptographer(KeyType.REPLACEMENT);
        encript_str = cryptographer.encrypt("Максим", "key");
        System.out.println(encript_str);
        System.out.println(cryptographer.decrypt(encript_str, "key"));
    }

}
