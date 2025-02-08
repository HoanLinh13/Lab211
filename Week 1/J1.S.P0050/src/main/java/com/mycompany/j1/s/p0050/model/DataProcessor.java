package com.mycompany.j1.s.p0050.model;

import java.util.List;

public interface DataProcessor {
    List<Float> calculateEquation(float a, float b);
    List<Float> calculateQuadraticEquation(float a, float b, float c);
    boolean isOdd(float number);
    boolean isPerfectSquare(float number);
}
