package com.example.calculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalculatorMain extends Activity {

	EditText editText;
	
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

}
