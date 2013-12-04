/**
 * 
 */
package com.project.hcmtour.fragment;

import com.project.hcmtour.Globals;
import com.project.hcmtour.PicturesActivity;
import com.project.hcmtour.R;
import com.project.hcmtour.adapter.PicturesAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

/**
 * @author DavidNguyen
 * 
 */
public class PicturesFragment extends Fragment {
	View v;
	GridView gridView;
	String[] items;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		v = inflater.inflate(R.layout.picture_gridview, null);
		gridView = (GridView) v.findViewById(R.id.gridView);
		items = getResources().getStringArray(R.array.pictures);
		PicturesAdapter adapter = new PicturesAdapter(v.getContext(),
				R.layout.picture_gridview_adapter, items);
		gridView.setAdapter(adapter);		
		
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View v, int position,
					long id) {
				// TODO Auto-generated method stub				
				Intent intent = new Intent(getActivity().getApplicationContext(),
						PicturesActivity.class);
				intent.putExtra(Globals.PICTURES, items[position]);
				startActivity(intent);
			}

		});
		return v;
	}
	// Intent intent = new Intent(getActivity(), PicturesActivity.class);
	// intent.putExtra(Globals.PICTURES, items[position]);
	// startActivity(intent);

}
