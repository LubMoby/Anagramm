package com.example.anagramapplication;

import org.jetbrains.annotations.NotNull;

public class Anagram {

    @org.jetbrains.annotations.NotNull
    public static String getAnagram(@NotNull String inputText){
        StringBuilder strForPrint = new StringBuilder();
        String[] words = inputText.split("\\s+");

        for (String word : words){
            String clearReversWord = word.trim().replaceAll("[\\W\\d]+","");
            clearReversWord = new StringBuilder(clearReversWord).reverse().toString();
            int pozition = 0;
            for (int i=0; i < word.length(); i++){
                char literalSymbol = word.charAt(i);
                if (Character.isLetter(literalSymbol)){
                    strForPrint.append(Character.toString(clearReversWord.charAt(pozition)));
                    pozition++;
                }else {
                    strForPrint.append(literalSymbol);
                }
            }
            strForPrint.append(" ");
        }
        return strForPrint.toString().trim();
    }
}
