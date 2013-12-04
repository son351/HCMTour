/**
 * 
 */
package com.project.hcmtour;

import java.util.ArrayList;

import org.mapsforge.android.maps.overlay.ItemizedOverlay;
import org.mapsforge.android.maps.overlay.OverlayItem;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.Toast;

/**
 * @author DavidNguyen
 * 
 */
public class CustomItemizedOverlay extends ItemizedOverlay<OverlayItem> {

	public ArrayList<OverlayItem> mapOverlays = new ArrayList<OverlayItem>();
	private Context context;

	// public MapsForgeViewer mActivtyl;

	public CustomItemizedOverlay(Drawable defaultMarker) {
		super(boundCenterBottom(defaultMarker));
	}

	public CustomItemizedOverlay(Drawable defaultMarker, Context context) {
		this(defaultMarker);
		this.context = context;
	}

	@Override
	protected OverlayItem createItem(int i) {
		return mapOverlays.get(i);
	}

	@Override
	public int size() {
		return mapOverlays.size();
	}

	@Override
	protected boolean onTap(int index) {
		OverlayItem item = mapOverlays.get(index);
		Toast.makeText(context, index + " ", Toast.LENGTH_SHORT).show();
		AlertDialog.Builder dialog = new AlertDialog.Builder(context);
		dialog.setTitle(item.getTitle());
		dialog.setMessage(item.getSnippet());
		dialog.show();
		return true;
	}

	public void addOverlay(OverlayItem overlay) {
		mapOverlays.add(overlay);
		this.populate();
	}
}