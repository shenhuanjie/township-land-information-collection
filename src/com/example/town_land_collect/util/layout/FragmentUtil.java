/**
 * 
 */
package com.example.town_land_collect.util.layout;

import java.util.ArrayList;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

import com.example.town_land_collect.R;
import com.example.town_land_collect.util.CommonTypeUtil;

public class FragmentUtil {

	/**
	 * 获取EditText的值，赋给实体
	 * 
	 * @param view
	 * @param id
	 * @param name
	 * @return
	 */
	public String getEditText(View view, int id, String name) {
		try {
			EditText editText = (EditText) view.findViewById(id);
			if (editText != null) {
				return editText.getText().toString();
			}
		} catch (Exception e) {
			// Log.d("NotFindControl", "不存在Id为：" + name + "的EditText控件");
		}
		try {
			Spinner spinner = (Spinner) view.findViewById(id);
			if (spinner != null) {
				Log.d("NotFindControl", "控件Id为：" + name + "，是Spinner类型，请修改！！");
			} else {
				Log.d("NotFindControl", "不存在Id为：" + name + "的控件，是否为缺少页面定义");
			}
		} catch (Exception e) {
			Log.d("NotFindControl", "不存在Id为：" + name + "的控件，是否为缺少页面定义");
		}
		return null;
	}

	public void setEditText(View view, int id, String name, String text) {
		try {
			EditText editText = (EditText) view.findViewById(id);
			if (editText != null) {
				editText.setText(text);
			}
		} catch (Exception e) {
			Log.d("NotFindControl", "不存在Id为：" + name + "的EditText控件");
		}
	}

}
