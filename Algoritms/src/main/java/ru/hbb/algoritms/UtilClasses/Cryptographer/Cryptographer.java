package ru.hbb.algoritms.UtilClasses.Cryptographer;

import java.util.*;

public class Cryptographer {

    private final KeyType type;
    private Map<String, String> table_enc = new HashMap<>();
    private Map<String, String> table_dec = new HashMap<>();

    public Cryptographer(KeyType type) {
        this.type = type;
    }

    public String encrypt(String text, String key) {
        if (type.equals(KeyType.CESAR)) {
            return cesarEncrypt(text, key);
        }else if(type.equals(KeyType.REPLACEMENT)) {
            return replacementEncrypt(text, key);
        }
        return "";
    }

    public String decrypt(String text, String key) {
        if (type.equals(KeyType.CESAR)) {
            return cesarDecrypt(text, key);
        }else if(type.equals(KeyType.REPLACEMENT)) {
            return replacementDecrypt(text, key);
        }
        return "";
    }

    private String cesarEncrypt(String text, String key) {
        text = text.toLowerCase();
        Language language = Language.getLanguage(text.charAt(0));
        char[] lang_chars = language.getAlphabet();
        int int_key = Integer.parseInt(key);
        char[] new_lang_chars = new char[lang_chars.length];
        for (int i = 0; i < lang_chars.length; i++) {
            int place = i + int_key;
            if (place < 0) {
                place = lang_chars.length + place;
            }else {
                if (place >= lang_chars.length) {
                    place = Math.abs(lang_chars.length - place);
                }
            }
            new_lang_chars[place] = lang_chars[i];
        }
        int[] syms_array = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            syms_array[i] = Language.getCharPlace(text.charAt(i), language);
        }
        String res = "";
        for (int p : syms_array) {
            res = res + new_lang_chars[p];
        }
        return res;
    }

    private String cesarDecrypt(String text, String key) {
        return cesarEncrypt(text, String.valueOf(((-1) * Integer.parseInt(key))));
    }

    private String replacementEncrypt(String text, String key) {
        text = text.toLowerCase();
        Language language = Language.getLanguage(text.charAt(0));
        table_enc = createTable(language);
        String res = "";
        for (char c : text.toCharArray()) {
            res = res + table_enc.get(String.valueOf(c));
        }
        return res;
    }

    private String replacementDecrypt(String text, String key) {
        text = text.toLowerCase();
        String res = "";
        for (char c : text.toCharArray()) {
            res = res + table_dec.get(String.valueOf(c));
        }
        return res;
    }

    private Map<String, String> createTable(Language language) {
        char[] lang_chars = language.getAlphabet();
        ArrayList<String> lang_keys = new ArrayList<>();
        ArrayList<String> lang_vals = new ArrayList<>();
        for (char c : lang_chars) {
            lang_keys.add(String.valueOf(c));
            lang_vals.add(String.valueOf(c));
        }
        while (lang_keys.size() > 0) {
            int i = randInt(lang_keys.size());
            int j = randInt(lang_keys.size());
            table_enc.put(lang_keys.get(i), lang_vals.get(j));
            table_dec.put(lang_vals.get(j), lang_keys.get(i));
            lang_keys.remove(i);
            lang_vals.remove(j);
        }
        return table_enc;
    }

    private int getKeyInHash(String key, int len) {
        return Math.abs(hash(key) % len);
    }

    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public int randInt(int max) {
        max = max - 1;
        return (int) (Math.random() * ++max);
    }

}
