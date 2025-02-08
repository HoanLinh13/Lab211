/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.j1.s.p0008.model;

import java.util.Map;

public interface DataCounter<K, V> {
    Map<K, V> count(String input);
}