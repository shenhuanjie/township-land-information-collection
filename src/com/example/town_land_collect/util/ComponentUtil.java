package com.example.town_land_collect.util;

import android.app.Activity;
import android.widget.EditText;

import com.example.town_land_collect.R;

public class ComponentUtil extends Activity {

	public String getValue(String name) {
		EditText editText = (EditText) findViewById(R.id.edit_the_name);
		if (editText != null) {
			return editText.getText().toString();
		}
		return "";
	}

	public static String setValue(String name) {
		return null;
	}
}
