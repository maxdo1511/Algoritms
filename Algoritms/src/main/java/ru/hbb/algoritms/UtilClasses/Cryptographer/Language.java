package ru.hbb.algoritms.UtilClasses.Cryptographer;

public enum Language {
    
    RU("абвгдеёжзиклмнопрстуфхцчщъыьэюя"),
    EN("abcdefghijklmnopqrstuvwxyz");
    
    private final String alphabet;

    Language(String alphabet) {
        this.alphabet = alphabet;
    }

    public char[] getAlphabet() {
        return alphabet.toCharArray();
    }

    public static Language getLanguage(char c) {
        for (Language language : Language.values()) {
            if (language.alphabet.contains(String.valueOf(c))) {
                return language;
            }
        }
        throw new RuntimeException("no alphabet!");
    }

    public static int getCharPlace(char c, Language language) {
        for (int i = 0; i < language.alphabet.length(); i++) {
            if (language.getAlphabet()[i] == c) {
                return i;
            }
        }
        throw new RuntimeException("no char at alphabet!");
    }
}
