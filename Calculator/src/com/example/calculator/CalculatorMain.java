package com.example.calculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalculatorMain extends Activity {

	EditText editText;
	String operator;
	double valX = 0;
	static int opcounter = 0;
	static int op = 0;
	double undo;
	double resultado = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator_main);
		editText = (EditText)findViewById(R.id.txtDisplay);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calculator_main, menu);
		return true;
	}
	
	public void setNumber(View view) {
		Button btn = (Button)findViewById(view.getId());
		String val = editText.getText().toString();
		editText.setText(val+btn.getText().toString());
	}
	
	public void doUndo(View view) {
		editText.setText(Double.toString(undo));
	}
	
	public void doClear(View view) {
		editText.setText("");
	}
	
	public void resultado(View view) {
		editText.setText(Double.toString(resultado));
	}
	
	public void calculate(View view){
		if (opcounter == 0) {
			valX = Double.parseDouble(editText.getText().toString());
			if (R.id.btnPlus == view.getId()) {
				op = 1;
			}else if (R.id.btnMinus == view.getId()) {
				op = 2;
			}else if (R.id.btnMult == view.getId()) {
				op = 3;
			}else if (R.id.btnDiv == view.getId()) {
				op = 4;
			}
			opcounter = 1;
			editText.setText("");
		} else if (opcounter == 1) {
			if (op == 1) {
				undo = valX;
				valX = Double.parseDouble(editText.getText().toString()) + valX;
				op = 0;
				editText.setText(Double.toString(valX));
			} else if (op == 2) {
				undo = valX;
				valX = Double.parseDouble(editText.getText().toString()) - valX;
				op = 0;
				editText.setText(Double.toString(valX));
			} else if (op == 3) {
				undo = valX;
				valX = Double.parseDouble(editText.getText().toString()) * valX;
				op = 0;
				editText.setText(Double.toString(valX));
			} else if (op == 4) {
				undo = valX;
				valX = Double.parseDouble(editText.getText().toString()) / valX;
				op = 0;
				editText.setText(Double.toString(valX));
			}
			opcounter = 0;
		}
	}
}
