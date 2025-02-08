package com.mycompany.j1.s.p0008.controller;

import com.mycompany.j1.s.p0008.model.DataCounter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class WordCounter implements DataCounter<String, Integer> {
    @Override
    public Map<String, Integer> count(String input) {
        Map<String, Integer> wordCount = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(input);

        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }
}
