/**
 * 
 */
package com.project.hcmtour.adapter;

import com.project.hcmtour.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author DavidNguyen
 * 
 */
public class PicturesAdapter extends BaseAdapter {
	private Context context;
	private String[] items;
	private int layoutResourceId;

	/**
	 * @param context
	 * @param items
	 */
	public PicturesAdapter(Context context, int resourceId, String[] items) {
		super();
		this.context = context;
		this.layoutResourceId = resourceId;
		this.items = items;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return items.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	static class ViewHolder {
		ImageView img;
		TextView txtDesc;
	}

	@SuppressLint("DefaultLocale")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if (convertView == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			convertView = inflater.inflate(layoutResourceId, parent, false);
			holder = new ViewHolder();
			holder.img = (ImageView) convertView.findViewById(R.id.image);
			holder.txtDesc = (TextView) convertView.findViewById(R.id.text);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		Resources res = context.getResources();
		int imgID = res.getIdentifier(items[position].toLowerCase(),
				"drawable", context.getPackageName());
		holder.img.setImageResource(imgID);
		holder.txtDesc.setText(items[position]);
		return convertView;
	}

}
