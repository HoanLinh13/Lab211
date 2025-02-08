package com.mycompany.j1.s.p0051.controller;

public class BMICalculator {
    public String calculateBMI(double weight, double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than 0.");
        }
        double heightInMeters = height / 100;
        double bmi = weight / (heightInMeters * heightInMeters);

        if (bmi < 19) {
            return "Under-standard";
        } else if (bmi <= 25) {
            return "Standard";
        } else if (bmi <= 30) {
            return "Overweight";
        } else if (bmi <= 40) {
            return "Fat - should lose weight";
        } else {
            return "Very fat - should lose weight immediately";
        }
    }
}

