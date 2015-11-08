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
	 * ��ȡEditText��ֵ������ʵ��
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
			// Log.d("NotFindControl", "������IdΪ��" + name + "��EditText�ؼ�");
		}
		try {
			Spinner spinner = (Spinner) view.findViewById(id);
			if (spinner != null) {
				Log.d("NotFindControl", "�ؼ�IdΪ��" + name + "����Spinner���ͣ����޸ģ���");
			} else {
				Log.d("NotFindControl", "������IdΪ��" + name + "�Ŀؼ����Ƿ�Ϊȱ��ҳ�涨��");
			}
		} catch (Exception e) {
			Log.d("NotFindControl", "������IdΪ��" + name + "�Ŀؼ����Ƿ�Ϊȱ��ҳ�涨��");
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
			Log.d("NotFindControl", "������IdΪ��" + name + "��EditText�ؼ�");
		}
	}

}
