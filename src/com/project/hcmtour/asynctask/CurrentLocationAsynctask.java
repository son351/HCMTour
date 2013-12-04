/**
 * 
 */
package com.project.hcmtour.asynctask;

import org.mapsforge.core.model.GeoPoint;

import com.project.hcmtour.Globals;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

/**
 * @author DavidNguyen
 * 
 */
public class CurrentLocationAsynctask extends AsyncTask<Void, Void, Void> {

	Context context;
	LocationManager mLocManager;
	LocationListener mLocListener;
	double lat = 0.0, lon = 0.0;

	public CurrentLocationAsynctask(Context mContext) {
		// TODO Auto-generated constructor stub
		context = mContext;
	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		mLocManager = (LocationManager) context
				.getSystemService(Context.LOCATION_SERVICE);
		mLocListener = new MyLocationListener();
		mLocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,
				mLocListener);
	}

	@Override
	protected void onCancelled() {
		// TODO Auto-generated method stub
		super.onCancelled();
		// delete LocationManager
		//mLocManager.removeUpdates(mLocListener);
	}

	@Override
	protected Void doInBackground(Void... params) {
		// TODO Auto-generated method stub
		while (lat == 0.0) {
			
		}
		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);		
	}

	public class MyLocationListener implements LocationListener {

		@Override
		public void onLocationChanged(Location location) {
			// TODO Auto-generated method stub			
			Globals g = (Globals) context.getApplicationContext();
			g.setmCurrentLocation(new GeoPoint(location.getLatitude(), location.getLongitude()));
		}

		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
			Toast.makeText(context, "GPS is OFF", Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			Toast.makeText(context, "GPS is ON", Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub

		}

	}

}
