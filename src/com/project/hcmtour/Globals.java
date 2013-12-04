/**
 * 
 */
package com.project.hcmtour;

import org.mapsforge.core.model.GeoPoint;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import android.app.Application;

/**
 * @author DavidNguyen
 * 
 */
public class Globals extends Application {
	public static final String MENU_NAME = "menu";
	public static final String PICTURES = "pictures";
	public static SlidingMenu MENU = null;
	private GeoPoint mCurrentLocation = null;

	/**
	 * @return the mCurrentLocation
	 */
	public GeoPoint getmCurrentLocation() {
		return mCurrentLocation;
	}

	/**
	 * @param mCurrentLocation
	 *            the mCurrentLocation to set
	 */
	public void setmCurrentLocation(GeoPoint mCurrentLocation) {
		this.mCurrentLocation = mCurrentLocation;
	}
}
