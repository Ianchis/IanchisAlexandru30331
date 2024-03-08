package ex1;

import java.util.Scanner;

class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(this.real - other.real, this.imaginary - other.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double newReal = (this.real * other.real) - (this.imaginary * other.imaginary);
        double newImaginary = (this.real * other.imaginary) + (this.imaginary * other.real);
        return new ComplexNumber(newReal, newImaginary);
    }

    @Override
    public String toString() {
        return real + (imaginary >= 0 ? "+" : "") + imaginary + "i";
    }
}

public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ComplexNumber num1 = new ComplexNumber(2, 5);
        ComplexNumber num2 = new ComplexNumber(4, -1);

        System.out.println("Select operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Addition result: " + num1.add(num2));
                break;
            case 2:
                System.out.println("Subtraction result: " + num1.subtract(num2));
                break;
            case 3:
                System.out.println("Multiplication result: " + num1.multiply(num2));
                break;
            default:
                System.out.println("Invalid choice");
        }

        scanner.close();
    }
}
