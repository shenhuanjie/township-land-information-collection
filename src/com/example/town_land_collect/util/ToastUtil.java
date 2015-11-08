package com.example.town_land_collect.util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
	public static void ToastStr(Context context, String text, int duration) {
		Toast.makeText(context, text, duration).show();
	}
}
