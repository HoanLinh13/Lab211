package com.mycompany.j1.s.p0061.view;

import com.mycompany.j1.s.p0061.controller.Circle;
import com.mycompany.j1.s.p0061.controller.Rectangle;
import com.mycompany.j1.s.p0061.controller.Triangle;

import java.util.Scanner;

public class UserInterface {
    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=====Calculator Shape Program=====");

        System.out.print("Please input side width of Rectangle: ");
        double width = scanner.nextDouble();
        System.out.print("Please input length of Rectangle: ");
        double length = scanner.nextDouble();
        Rectangle rectangle = new Rectangle(width, length);

        System.out.print("Please input radius of Circle: ");
        double radius = scanner.nextDouble();
        Circle circle = new Circle(radius);

        System.out.print("Please input side A of Triangle: ");
        double sideA = scanner.nextDouble();
        System.out.print("Please input side B of Triangle: ");
        double sideB = scanner.nextDouble();
        System.out.print("Please input side C of Triangle: ");
        double sideC = scanner.nextDouble();
        Triangle triangle = new Triangle(sideA, sideB, sideC);

        rectangle.printResult();
        circle.printResult();
        triangle.printResult();

        scanner.close();
    }
}
