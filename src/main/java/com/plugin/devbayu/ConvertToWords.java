package com.plugin.devbayu;

import net.sf.jasperreports.engine.JRDefaultScriptlet;

public class ConvertToWords extends JRDefaultScriptlet {
    static String[] numberToWords = {"", "Satu", "Dua", "Tiga", "Empat", "Lima", "Enam", "Tujuh", "Delapan", "Sembilan", "Sepuluh", "Sebelas"};

    public ConvertToWords() {
    }

    public static String convertNumbers(Double number) {
        if (number < 12)
            return numberToWords[number.intValue()];
        if (number <= 19)
            return numberToWords[number.intValue() % 10] + " Belas";
        if (number <= 99)
            return convertNumbers(number / 10) + " Puluh " + numberToWords[number.intValue() % 10];
        if (number <= 199)
            return "Seratus " + convertNumbers(number % 100);
        if (number <= 999)
            return convertNumbers(number / 100) + " Ratus " + convertNumbers(number % 100);
        if (number <= 1999)
            return "Seribu " + convertNumbers(number % 1000);
        if (number <= 999999)
            return convertNumbers(number / 1000) + " Ribu " + convertNumbers(number % 1000);
        if (number <= 999999999)
            return convertNumbers(number / 1000000) + " Juta " + convertNumbers(number % 1000000);
        if (number <= 999999999999L)
            return convertNumbers(number / 1000000000) + " Milyar " + convertNumbers(number % 1000000000);
        if (number <= 999999999999999L)
            return convertNumbers(number / 1000000000000L) + " Triliun " + convertNumbers(number % 1000000000000L);
        if (number <= 999999999999999999L)
            return convertNumbers(number / 1000000000000000L) + " Quadrilyun " + convertNumbers(number % 1000000000000000L);
        return "";
    }

}