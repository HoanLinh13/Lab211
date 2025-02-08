package com.mycompany.j1.s.p0008.controller;

import com.mycompany.j1.s.p0008.model.DataCounter;
import java.util.HashMap;
import java.util.Map;

public class CharacterCounter implements DataCounter<Character, Integer>{
    @Override
    public Map<Character, Integer> count(String input) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
            }
        }
        return charCount;
    }
}
