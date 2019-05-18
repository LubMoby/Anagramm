package com.example.anagramapplication;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnagramTest {

    @Test
    public void getAnagram() {
        String inputText = "a1bcd efg!h";
        String expectedResult = "d1cba hgf!e";
        String outputResult;

        Anagram anagram = new Anagram();
        outputResult = anagram.getAnagram(inputText);
        assertEquals(expectedResult,outputResult);
    }
}