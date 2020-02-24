package com.slf.carplay;

import android.app.Activity;
import android.content.Context;
import android.graphics.Camera;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import androidx.appcompat.app.AppCompatActivity;

public class CarActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_car);
		if (null == savedInstanceState) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.carContainer, CarFragment.newInstance())
                    .commit();
        }
	}

	
}
