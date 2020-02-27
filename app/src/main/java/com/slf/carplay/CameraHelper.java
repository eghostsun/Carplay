package com.slf.carplay;

import android.app.Activity;
import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.Surface;

public class CameraHelper {
    /**
     * Conversion from screen rotation to JPEG orientation.
     */
    private static final SparseIntArray ORIENTATIONS = new SparseIntArray();

    /**
     * Orientation of the camera sensor
     */
    private int mSensorOrientation;
    static {
        ORIENTATIONS.append(Surface.ROTATION_0, 90);
        ORIENTATIONS.append(Surface.ROTATION_90, 0);
        ORIENTATIONS.append(Surface.ROTATION_180, 270);
        ORIENTATIONS.append(Surface.ROTATION_270, 180);
    }
    /**
     * Retrieves the JPEG orientation from the specified screen rotation.
     *
     * @param rotation The screen rotation.
     * @return The JPEG orientation (one of 0, 90, 270, and 360)
     */
    public static int getOrientation(Activity activity,int rotation,String cameraId) throws CameraAccessException {
        // Sensor orientation is 90 for most devices, or 270 for some devices (eg. Nexus 5X)
        // We have to take that into account and rotate JPEG properly.
        // For devices with orientation of 90, we simply return our mapping from ORIENTATIONS.
        // For devices with orientation of 270, we need to rotate the JPEG 180 degrees.
        CameraManager manager = (CameraManager) activity.getSystemService(Context.CAMERA_SERVICE);

        CameraCharacteristics characteristics
                = manager.getCameraCharacteristics(cameraId);
        // Find out if we need to swap dimension to get the preview size relative to sensor
        // coordinate.
        int mSensorOrientation = characteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
        return (ORIENTATIONS.get(rotation) + mSensorOrientation + 270) % 360;
    }

}
