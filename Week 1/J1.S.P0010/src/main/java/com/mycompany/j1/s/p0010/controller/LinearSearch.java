package com.mycompany.j1.s.p0010.controller;

import com.mycompany.j1.s.p0010.model.DataOperation;

import java.util.Random;

public class LinearSearch implements DataOperation {

    private int[] array;
    private int size;

    public LinearSearch(int size) {
        this.size = size;
        this.array = new int[size];
        generateRandomArray();  // Tạo mảng ngẫu nhiên khi khởi tạo
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
        this.size = array.length; // Đồng bộ kích thước với mảng
    }


    private int[] generateRandomArray() {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            this.array[i] = rand.nextInt(array.length); //  Giới hạn từ -50 đến 50
        }

        return array;
    }

    public int search(int x) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x) {
                return i; // Trả về vị trí tìm thấy
            }
        }
        return -1; // Không tìm thấy
    }

    public void displayArray() {
        System.out.print("The array: [ ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println("]");
    }
}
