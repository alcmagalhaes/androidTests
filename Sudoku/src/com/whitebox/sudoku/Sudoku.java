package com.whitebox.sudoku;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class Sudoku extends Activity implements OnClickListener {

	private static final String TAG = "Sudoku" ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Set up click listeners for all the buttons
		View continueButton = findViewById(R.id.continue_button);
		continueButton.setOnClickListener(this);
		View newButton = findViewById(R.id.new_button);
		newButton.setOnClickListener(this);
		View aboutButton = findViewById(R.id.about_button);
		aboutButton.setOnClickListener(this);
		View exitButton = findViewById(R.id.exit_button);
		exitButton.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.new_button:
			openNewGameDialog();
			break;
		case R.id.exit_button:
			finish();
			break;
		case R.id.about_button:
			Intent i = new Intent(this, About.class);
			startActivity(i);
			break;
		}
		
	}
	
	private void openNewGameDialog() {
		new AlertDialog.Builder(this)
		.setTitle(R.string.new_game_title)
		.setItems(R.array.difficulty,
		new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialoginterface,int i) {
				startGame(i);
			}
		}).show();
	}

	private void startGame(int i) {
		Log.d(TAG, "clicked on " + i);
		Intent intent = new Intent(Sudoku.this, Game.class);
		intent.putExtra(Game.KEY_DIFFICULTY, i);
		startActivity(intent);
	}

	public boolean onOptiotnsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.settings:
			startActivity(new Intent(this, Prefs.class));
			return true;
		default:
			return false;
		}
	}

}
