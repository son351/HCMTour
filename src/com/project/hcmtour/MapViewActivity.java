package com.project.hcmtour;

import java.io.File;
import java.util.List;

import org.mapsforge.android.maps.MapActivity;
import org.mapsforge.android.maps.MapView;
import org.mapsforge.android.maps.overlay.Overlay;
import org.mapsforge.android.maps.overlay.OverlayItem;
import org.mapsforge.core.model.GeoPoint;

import com.project.hcmtour.asynctask.CurrentLocationAsynctask;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MapViewActivity extends MapActivity {
	MapView mapView;
	CurrentLocationAsynctask currentLocationAsynctask;
	int count = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);

		File mapFile = new File(Environment.getExternalStorageDirectory()
				.getAbsolutePath() + "/HCMTour.map");
		mapView = (MapView) findViewById(R.id.mapView);
		mapView.setClickable(true);
		mapView.setBuiltInZoomControls(true);
		mapView.setMapFile(mapFile);
		
		GeoPoint firstPoint = new GeoPoint(10.781119, 106.691236);
		mapView.getController().setCenter(firstPoint);		
		
		/*mapView.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if (event.getAction() == MotionEvent.ACTION_UP) {
					GeoPoint gp = mapView.getProjection().fromPixels(
							(int) event.getX(), (int) event.getY());
					String address = "";
					Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.ENGLISH);
					try {
						List<Address> addresses = geocoder.getFromLocation(gp.getLatitude(), gp.getLongitude(), 1);
						if (addresses != null) {
							Address returnedAddress = addresses.get(0);
							String addressText = String.format(
									"%s, %s",
									returnedAddress.getMaxAddressLineIndex() > 0 ? returnedAddress
											.getAddressLine(0) : "", returnedAddress
											.getCountryName());

							address = addressText;
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//					Toast.makeText(getApplicationContext(), address,
//							Toast.LENGTH_SHORT).show();
				}
				return false;
			}
		});*/

		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.location_searching:
			if (checkGPS()) {
				Toast.makeText(this, "Waiting for location...",
						Toast.LENGTH_SHORT).show();
				if (count == 0) {
					// Use asynctask to get current location
					currentLocationAsynctask = new CurrentLocationAsynctask(
							this);
					currentLocationAsynctask.execute();
				} else {
					count++;
				}
				if (currentLocationAsynctask != null
						&& !currentLocationAsynctask.isCancelled()
						&& count != 0) {
					// Use asynctask to get current location
					currentLocationAsynctask.cancel(true);
					currentLocationAsynctask = new CurrentLocationAsynctask(
							this);
					currentLocationAsynctask.execute();
				}

				// display GeoPoint to MapView
				Globals g = (Globals) getApplication();
				if (g.getmCurrentLocation() != null) {
					findCurrentPosition(g.getmCurrentLocation());
				}
			} else {
				AlertDialog.Builder builder = new AlertDialog.Builder(this);
				builder.setTitle("GPS Service");
				builder.setMessage("In order to get your current location, please turn on GPS!");
				builder.setIcon(R.drawable.question);
				builder.setPositiveButton("YES",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								Intent intent = new Intent(
										Settings.ACTION_LOCATION_SOURCE_SETTINGS);
								startActivity(intent);
							}
						});
				builder.setNegativeButton("NO",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								dialog.cancel();
							}
						});
				builder.show();
			}

			break;

		case android.R.id.home:
			finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	public boolean checkGPS() {
		String provider = Settings.Secure.getString(getContentResolver(),
				Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
		if (!provider.equals("")) {
			return true;
		}
		return false;
	}

	public void findCurrentPosition(GeoPoint gp) {

		// set center location
		mapView.getController().setCenter(gp);

		// Put pins on map
		List<Overlay> mapOverlays = mapView.getOverlays();
		Drawable dr = getResources().getDrawable(
				R.drawable.currnet_location_marker);
		CustomItemizedOverlay itemizedOverlay = new CustomItemizedOverlay(dr,
				this);

		// Create points using lat, long
		GeoPoint geoPoint = new GeoPoint(gp.getLatitude(), gp.getLongitude());

		OverlayItem overlayItem = new OverlayItem(geoPoint, "You are here",
				"Description here");
		itemizedOverlay.addOverlay(overlayItem);

		// add to map
		mapOverlays.clear();
		mapOverlays.add(itemizedOverlay);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		// currentLocationAsynctask.cancel(true);

	}

}
