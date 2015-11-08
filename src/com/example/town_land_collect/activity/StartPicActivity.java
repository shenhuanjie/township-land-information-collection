package com.example.town_land_collect.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.example.town_land_collect.R;

public class StartPicActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_start_pic);
		new CountDownTimer(3000, 100) {
			@Override
			public void onTick(long millisUntilFinished) {

			}

			@Override
			public void onFinish() { // 倒计时结束后在这里实现activity跳转
				Intent intent = new Intent();
				intent.setClass(StartPicActivity.this, MainActivity.class);
				startActivity(intent);
				finish(); // 跳转后销毁自身的activity 否则按返回 还会跳回到图片
			}
		}.start();
	}
}
