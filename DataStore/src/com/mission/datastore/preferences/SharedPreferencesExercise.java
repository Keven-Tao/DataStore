package com.mission.datastore.preferences;

import com.mission.datastore.R;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SharedPreferencesExercise extends Activity {

	private Button saveData;
	private Button restoreData;
	private SharedPreferences pref;
	private SharedPreferences.Editor editor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_share);
		saveData = (Button)findViewById(R.id.save_data);
		restoreData = (Button)findViewById(R.id.restore_data);
		pref = getSharedPreferences("data", Context.MODE_PRIVATE);
		
		saveData.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				editor = pref.edit();
				
				editor.putString("name", "Tome");
				editor.putInt("age", 28);
				editor.putBoolean("married", false);
				editor.commit();
			}
		});
		
		restoreData.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				String name = pref.getString("name", "");
				int age = pref.getInt("age", 0);
				boolean married = pref.getBoolean("married", false);
				Log.d("SharedPreferencesExercise", "name is " + name);
				Log.d("SharedPreferencesExercise", "age is " + age);
				Log.d("SharedPreferencesExercise", "married is " + married);
			}
		});
	}
	
	
}
