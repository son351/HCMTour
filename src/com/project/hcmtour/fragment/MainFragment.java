/**
 * 
 */
package com.project.hcmtour.fragment;

import com.project.hcmtour.Globals;
import com.project.hcmtour.MapViewActivity;
import com.project.hcmtour.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

/**
 * @author DavidNguyen
 * 
 */
public class MainFragment extends Fragment {
	View v;
	TextView txtText;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Bundle bundle = getArguments();
		String menuName = bundle.getString(Globals.MENU_NAME);

		if (menuName.equals("Map")) {
			v = inflater.inflate(R.layout.map_fragment, null);
			Button btnShowMap = (Button) v.findViewById(R.id.btnShowMap);
			btnShowMap.setOnClickListener(new Button.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(getActivity(),
							MapViewActivity.class);
					startActivity(intent);
				}
			});
		} else {
			v = new LinearLayout(getActivity());
			v.setLayoutParams(new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
			v.setBackgroundColor(getResources().getColor(R.color.purple_light));

			txtText = new TextView(getActivity());
			txtText.setText(menuName);

			((ViewGroup) v).addView(txtText);

		}

		return v;
	}
}
