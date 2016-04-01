package com.mission.datastore.preferences;

import com.mission.datastore.R;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SharedPreferencesTest extends Activity {

	private Button saveData;
	private Button restoreData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_share);
		saveData = (Button) findViewById(R.id.save_data);
		restoreData = (Button) findViewById(R.id.restore_data);
		
		saveData.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				//调用SharedPreferences的edit方法
				//使用Context类中的getSharedPreferences()方法
				SharedPreferences.Editor edit = getSharedPreferences("data", MODE_PRIVATE).edit();
				//使用Activity类中的GetPreferences()方法
//				SharedPreferences.Editor edit = getPreferences(MODE_PRIVATE).edit();
				//使用PreferenceManager类中的getDefaultSharedPreferences()方法
//				SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(SharedPreferencesTest.this);
//				Editor edit =  shared.edit();
				edit.putString("name", "Tome");
				edit.putInt("age", 28);
				edit.putBoolean("married", false);
				edit.commit();
			}
		});
		
		restoreData.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
				String name = pref.getString("name", "");
				int age = pref.getInt("age", 0);
				boolean married = pref.getBoolean("married", false);
				Log.d("SharedPreferencesTest", "name is " + name);
				Log.d("SharedPreferencesTest", "age is " + age);
				Log.d("SharedPreferencesTest", "married is " + married);

			}
		});
	}

	
}
