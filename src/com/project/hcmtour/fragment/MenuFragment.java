/**
 * 
 */
package com.project.hcmtour.fragment;

import com.project.hcmtour.Globals;
import com.project.hcmtour.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ArrayAdapter;

/**
 * @author DavidNguyen
 * 
 */
public class MenuFragment extends ListFragment {
	Fragment fragment;
	Bundle bundle;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		String[] menu_name = getResources().getStringArray(R.array.menu_items);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, menu_name);
		setListAdapter(adapter);

		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		/*
		 * LayoutInflater inflater = (LayoutInflater) getActivity()
		 * .getSystemService(Context.LAYOUT_INFLATER_SERVICE); View view =
		 * (View) inflater.inflate(R.layout.activity_main, null);
		 */

		switch (position) {
		case 0:
//			Intent intent = new Intent(getActivity(), MapViewActivity.class);
//			startActivity(intent);
			fragment = new MainFragment();
			bundle = new Bundle();
			bundle.putString(Globals.MENU_NAME, "Map");
			fragment.setArguments(bundle);

			getActivity().getSupportFragmentManager().beginTransaction()
					.replace(R.id.content_frame, fragment).commit();
			Globals.MENU.toggle();
			break;
		case 1:
			fragment = new MainFragment();
			bundle = new Bundle();
			bundle.putString(Globals.MENU_NAME, "Bookmarks");
			fragment.setArguments(bundle);

			getActivity().getSupportFragmentManager().beginTransaction()
					.replace(R.id.content_frame, fragment).commit();
			Globals.MENU.toggle();
			break;
		case 2:
			fragment = new MainFragment();
			bundle = new Bundle();
			bundle.putString(Globals.MENU_NAME, "What to see");
			fragment.setArguments(bundle);

			getActivity().getSupportFragmentManager().beginTransaction()
					.replace(R.id.content_frame, fragment).commit();
			Globals.MENU.toggle();
			break;
		case 3:
			fragment = new MainFragment();
			bundle = new Bundle();
			bundle.putString(Globals.MENU_NAME, "Search");
			fragment.setArguments(bundle);

			getActivity().getSupportFragmentManager().beginTransaction()
					.replace(R.id.content_frame, fragment).commit();
			Globals.MENU.toggle();
			break;
		case 4:
			fragment = new PicturesFragment();			

			getActivity().getSupportFragmentManager().beginTransaction()
					.replace(R.id.content_frame, fragment).commit();
			Globals.MENU.toggle();
			break;
		case 5:
			fragment = new MainFragment();
			bundle = new Bundle();
			bundle.putString(Globals.MENU_NAME, "About");
			fragment.setArguments(bundle);

			getActivity().getSupportFragmentManager().beginTransaction()
					.replace(R.id.content_frame, fragment).commit();
			Globals.MENU.toggle();
			break;
		case 6:
			getActivity().finish();
			break;
			
		}
	}

}
