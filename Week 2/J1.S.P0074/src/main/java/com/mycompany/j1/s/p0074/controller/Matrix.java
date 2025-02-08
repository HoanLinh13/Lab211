package com.mycompany.j1.s.p0074.controller;

import com.mycompany.j1.s.p0074.model.IMatrix;

import java.util.Scanner;

public class Matrix implements IMatrix {
    private int rows;
    private int columns;
    private int[][] dataMatrix;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.dataMatrix = new int[rows][columns];
    }

    @Override
    public void insertMatrix() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter Matrix [" + (i + 1) + "][" + (j + 1) + "]: ");
                dataMatrix[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Matrix input completed!");
    }

    @Override
    public IMatrix additionMatrix(IMatrix matrix2) {
        if (this.rows != ((Matrix) matrix2).getRows() || this.columns != ((Matrix) matrix2).getColumns()) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for addition.");
        }
        Matrix result = new Matrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.dataMatrix[i][j] = this.dataMatrix[i][j] + ((Matrix) matrix2).dataMatrix[i][j];
            }
        }
        return result;
    }

    @Override
    public IMatrix subtractionMatrix(IMatrix matrix2) {
        if (this.rows != ((Matrix) matrix2).getRows() || this.columns != ((Matrix) matrix2).getColumns()) {
            throw new IllegalArgumentException("Matrices dimensions must match for subtraction.");
        }
        Matrix result = new Matrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.dataMatrix[i][j] = this.dataMatrix[i][j] - ((Matrix) matrix2).dataMatrix[i][j];
            }
        }
        return result;
    }

    @Override
    public IMatrix multiplicationMatrix(IMatrix matrix2) {
        if (this.columns != ((Matrix) matrix2).getRows()) {
            throw new IllegalArgumentException("Number of columns in the first matrix must match the number of rows in the second matrix.");
        }
        Matrix result = new Matrix(this.rows, ((Matrix) matrix2).getColumns());
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < ((Matrix) matrix2).getColumns(); j++) {
                for (int k = 0; k < this.columns; k++) {
                    result.dataMatrix[i][j] += this.dataMatrix[i][k] * ((Matrix) matrix2).dataMatrix[k][j];
                }
            }
        }
        return result;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void displayMatrix() {
        System.out.println("Displaying matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("[" + dataMatrix[i][j] + "] ");
            }
            System.out.println();  // Chuyển dòng sau mỗi hàng
        }
    }
}