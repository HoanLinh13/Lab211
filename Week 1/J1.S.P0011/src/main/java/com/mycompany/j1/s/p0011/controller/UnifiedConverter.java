package com.mycompany.j1.s.p0011.controller;

import com.mycompany.j1.s.p0011.model.BaseConverter;

public class UnifiedConverter implements BaseConverter {

    public String convert(int inputBase, int outputBase, String inputValue) {
        try {
            // Phân tích đầu vào thành số thập phân
            int decimalValue = Integer.parseInt(inputValue, getBase(inputBase));

            // Chuyển đổi số thập phân thành đầu ra mong muốn
            switch (outputBase) {
                case 1:
                    return Integer.toBinaryString(decimalValue);
                case 2:
                    return Integer.toString(decimalValue);
                case 3:
                    return Integer.toHexString(decimalValue).toUpperCase();
                default:
                    throw new IllegalArgumentException("Invalid output base choice.");
            }
        } catch (NumberFormatException e) {
            return "Invalid input for the specified base.";
        }
    }

    private int getBase(int choice) {
        switch (choice) {
            case 1:
                return 2;
            case 2:
                return 10;
            case 3:
                return 16;
            default:
                throw new IllegalArgumentException("Invalid base choice. Please choose 1, 2, or 3.");
        }
    }
}
