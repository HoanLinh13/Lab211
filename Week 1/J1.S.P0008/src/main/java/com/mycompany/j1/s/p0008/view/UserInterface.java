/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.j1.s.p0008.view;

import com.mycompany.j1.s.p0008.controller.*;
import java.util.Map;
import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner = new Scanner(System.in);
    private final WordCounter wordCounter = new WordCounter();
    private final CharacterCounter characterCounter = new CharacterCounter();

    public void start() {
        System.out.println("Enter your content: ");
        String input = scanner.nextLine().trim();

        // Đếm chữ
        Map<String, Integer> wordCount = wordCounter.count(input);
        System.out.println(wordCount);

        // Đếm ký tự
        Map<Character, Integer> charCount = characterCounter.count(input);
        System.out.println(charCount);
    }
}
