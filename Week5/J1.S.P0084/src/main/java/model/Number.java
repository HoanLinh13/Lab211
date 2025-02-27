package model;

import java.util.Arrays;

public class Number {
    private int[] value;

    public Number(String value) {
        this.value = convertStringToArray(value);
    }

    public Number(int[] digits) {
        this.value = normalize(digits);
    }

    public int[] getValue() {
        return value;
    }

    public void setValue(int[] value) {
        this.value = value;
    }

//    Chuyển đổi chuỗi số thành mảng số nguyên
    private int[] convertStringToArray(String num) {
        int[] result = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            result[i] = num.charAt(i) - '0';
        }
        return result;
    }

    //Loại bỏ các số 0 đứng đầu trong mảng số lớn
    private int[] normalize(int[] digits) {
        // Loại bỏ số 0 đứng đầu
        int start = 0;
        while (start < digits.length - 1 && digits[start] == 0) {
            start++;
        }
        //Sao chép phần số hợp lệ vào một mảng mới
        return Arrays.copyOfRange(digits, start, digits.length);
    }

}
