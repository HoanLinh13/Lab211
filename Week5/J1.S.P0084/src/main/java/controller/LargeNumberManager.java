package controller;

import model.LargeNumberCalculator;

public class LargeNumberManager implements LargeNumberCalculator {
    @Override
    public int[] addLargeNumbers(int[] num1, int[] num2) {
        int maxLength = Math.max(num1.length, num2.length);
        int[] result = new int[maxLength + 1];
        int carry = 0;

        for (int i = 0; i < maxLength; i++) {
            int digit1 = (i < num1.length) ? num1[num1.length - 1 - i] : 0;
            int digit2 = (i < num2.length) ? num2[num2.length - 1 - i] : 0;
            int sum = digit1 + digit2 + carry;
            result[result.length - 1 - i] = sum % 10;
            carry = sum / 10;
        }
        result[0] = carry;
        return result;
    }

    @Override
    public int[] multiplyLargeNumbers(int[] num1, int[] num2) {
        int[] result = new int[num1.length + num2.length];
        for (int i = num1.length - 1; i >= 0; i--) {
            for (int j = num2.length - 1; j >= 0; j--) {
                int mul = num1[i] * num2[j];
                int sum = mul + result[i + j + 1];
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }
        return result;
    }
}
