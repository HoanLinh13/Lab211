package com.mycompany.j1.s.p0050.controller;

import com.mycompany.j1.s.p0050.model.DataProcessor;

import java.util.ArrayList;
import java.util.List;

public class EquationSolver implements DataProcessor {

    // giải phương trình bậc 1
    @Override
    public List<Float> calculateEquation(float a, float b) {
        List<Float> result = new ArrayList<>();
        if (a == 0 && b == 0) {
            return result; // Vô số nghiệm
        } else if (a == 0) {
            return null; // Vô nghiệm
        } else {
            result.add(-b / a); // Nghiệm x = -b / a
            return result;
        }
    }

    // giải phương trình bậc 2
    @Override
    public List<Float> calculateQuadraticEquation(float a, float b, float c) {
        List<Float> result = new ArrayList<>();
        if (a == 0) {
            return calculateEquation(b, c);
        }

        float delta = b * b - 4 * a * c;
        if (delta < 0) {
            return null; // Vô nghiệm
        } else if (delta == 0) {
            result.add(-b / (2 * a)); // Nghiệm kép
        } else {
            result.add((-b + (float) Math.sqrt(delta)) / (2 * a)); // Nghiệm x1
            result.add((-b - (float) Math.sqrt(delta)) / (2 * a)); // Nghiệm x2
        }
        return result;
    }

    // KT chẳn, lẻ
    @Override
    public boolean isOdd(float number) {
        return number % 2 != 0;
    }

    // KT số chính phương
    @Override
    public boolean isPerfectSquare(float number) {
        if (number < 0) return false;
        float sqrt = (float) Math.sqrt(number);
        return sqrt == Math.floor(sqrt);
    }
}

