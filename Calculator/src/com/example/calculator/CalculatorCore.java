package com.example.calculator;

public class CalculatorCore {

	public CalculatorCore() {
		
	}
	
	public double multiplicar(double x, double y) {
		return x * y;
	}
	
	public double dividir(double x, double y) {
		if (y != 0) {
			return x / y;
		}else {
			return 0;
		}
	}
	
	public double somar(double x, double y) {
		return x + y;
	}
	
	public double subtrair(double x, double y) {
		return x - y;
	}

	public double porcentagem(double x) {
		return x / 100;
	}

}
