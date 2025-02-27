package controller;

import model.LargeNumberCalculator;
import model.Number;

public class LargeNumberManager implements LargeNumberCalculator {

    @Override
    public Number addLargeNumbers(Number num1, Number num2) {
        int[] number1 = num1.getValue();
        int[] number2 = num2.getValue();
        int maxLength = Math.max(number1.length, number2.length);
        int[] result = new int[maxLength + 1];
        int carry = 0;

        for (int i = 0; i < maxLength; i++) {
            int digit1 = (i < number1.length) ? number1[number1.length - 1 - i] : 0;
            int digit2 = (i < number2.length) ? number2[number2.length - 1 - i] : 0;
            int sum = digit1 + digit2 + carry;

            result[result.length - 1 - i] = sum % 10;
            carry = sum / 10;
        }
        result[0] = carry;
        return new Number(result);
    }

    @Override
    public Number multiplyLargeNumbers(Number num1, Number num2) {
        int[] number1 = num1.getValue();
        int[] number2 = num2.getValue();
        int[] result = new int[number1.length + number2.length];

        for (int i = number1.length - 1; i >= 0; i--) {
            for (int j = number2.length - 1; j >= 0; j--) {
                int mul = number1[i] * number2[j];
                int sum = mul + result[i + j + 1];
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }
        return new Number(result);
    }


    public void printNumber(Number number) {
        int[] digits = number.getValue(); // Lấy mảng số từ Number
        int[] result = new int[digits.length]; // Mảng lưu kết quả
        int index = 0;

        // Bỏ qua các số 0 ở đầu
        while (index < digits.length && digits[index] == 0) {
            index++;
        }

        if (index == digits.length) {
            System.out.println("0"); // Nếu toàn bộ số là 0
            return;
        }

        // Lưu kết quả vào mảng
        for (int i = index, j = 0; i < digits.length; i++, j++) {
            result[j] = digits[i];
        }

        // In kết quả
        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0 || i >= index) {
                System.out.print(result[i]);
            }
        }
        System.out.println();
    }

}
