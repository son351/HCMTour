package com.project.hcmtour;

import android.net.Uri;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ShareActionProvider;

public class PicturesActivity extends Activity {
	ImageView img;
	private ShareActionProvider mShareActionProvider;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pictures);

		Bundle bundle = getIntent().getExtras();
		String imgName = bundle.getString(Globals.PICTURES);

		img = (ImageView) findViewById(R.id.fullImg);
		Resources res = getResources();
		int imgID = res.getIdentifier(imgName, "drawable", getPackageName());
		img.setImageResource(imgID);

		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@SuppressLint("NewApi")
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pictures, menu);
		mShareActionProvider = (ShareActionProvider) menu.findItem(R.id.share)
				.getActionProvider();

		mShareActionProvider.setShareIntent(getDefaultShareIntent());

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	private Intent getDefaultShareIntent() {
		Uri pngUri = Uri.parse("android.resource://com.project.hcmtour/drawable/aodai.jpg");
		Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
		shareIntent.setType("image/png");
		shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
				"YOUR TEXT HERE");
		shareIntent.putExtra(android.content.Intent.EXTRA_TEXT,
				"YOUR TEXT HERE");
		shareIntent.putExtra(android.content.Intent.EXTRA_STREAM, pngUri);
		return shareIntent;
	}
}
