package com.example.town_land_collect.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.town_land_collect.R;
import com.example.town_land_collect.activity.AboutActivity;
import com.example.town_land_collect.activity.CollectionRecordActivity;
import com.example.town_land_collect.activity.EditPswActivity;
import com.example.town_land_collect.activity.MapResourcesActivity;

public class UserFragment extends Fragment implements OnClickListener {

	private RelativeLayout relativeLayout_Map;
	private RelativeLayout relativeLayout_EditPsw;
	private RelativeLayout relativeLayout_Question;
	// private RelativeLayout relativeLayout_CollectionList;
	private RelativeLayout relativeLayout_Exit;
	private View view = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = (View) inflater.inflate(R.layout.fragment_user, null);
		initLayout();
		return view;
	}

	private void initLayout() {
		relativeLayout_Map = (RelativeLayout) view.findViewById(R.id.fragment_user_rl_map);
		relativeLayout_EditPsw = (RelativeLayout) view.findViewById(R.id.fragment_user_rl_editpsw);
		relativeLayout_Question = (RelativeLayout) view.findViewById(R.id.fragment_user_rl_question);
		// relativeLayout_CollectionList =
		// (RelativeLayout)view.findViewById(R.id.fragment_user_rl_collection_list);
		relativeLayout_Exit = (RelativeLayout) view.findViewById(R.id.fragment_user_rl_exit);
		relativeLayout_Map.setOnClickListener(this);
		relativeLayout_EditPsw.setOnClickListener(this);
		relativeLayout_Question.setOnClickListener(this);
		// relativeLayout_CollectionList.setOnClickListener(this);
		relativeLayout_Exit.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		int id = arg0.getId();
		switch (id) {
		case R.id.fragment_user_rl_map:
			Intent intent = new Intent(getActivity(), MapResourcesActivity.class);
			startActivity(intent);
			break;
		case R.id.fragment_user_rl_editpsw:
			intent = new Intent(getActivity(), EditPswActivity.class);
			startActivity(intent);
			break;
//		case R.id.fragment_user_rl_collection_list:
//			intent = new Intent(getActivity(), CollectionRecordActivity.class);
//			startActivity(intent);
//			break;
		case R.id.fragment_user_rl_exit:
			getActivity().finish();
			break;
		case R.id.fragment_user_rl_question:
			intent = new Intent(getActivity(), AboutActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}
	}
}
