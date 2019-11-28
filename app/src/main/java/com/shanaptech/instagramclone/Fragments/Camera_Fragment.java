package com.shanaptech.instagramclone.Fragments;


import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraMetadata;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.shanaptech.instagramclone.R;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;



public class Camera_Fragment extends Fragment implements SurfaceHolder.Callback {


    private Camera camera;
    SurfaceView surfaceView ;
    SurfaceHolder surfaceHolder;
    final int REQUEST_CODE = 1;
    Camera.PictureCallback pictureCallback;
    private Button img;
    public static  Camera_Fragment  newInstance() {
        Camera_Fragment f = new Camera_Fragment() ;
        return f;
    }
    public Camera_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_camera_, container, false);

        surfaceView = v.findViewById(R.id.camera_view);
       img = v.findViewById(R.id.take_pic);
       img.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Take_picture();
           }
       });

        return v;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        camera = Camera.open();
        Camera.Parameters  parameters ;
        parameters = camera.getParameters();

        camera.setDisplayOrientation(90);
        parameters.setPreviewFormat(30);
        parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);
        Camera.Size size = null;

        List<Camera.Size> list = camera.getParameters().getSupportedPreviewSizes();


        size = list.get(0);
        for (int i = 1 ; i<list.size() ; i++)
        {
            if ((list.get(i).width * list.get(i).height) > size.width * size.height){

                size = list.get(i);

            }}
        parameters.setPreviewSize(size.width , size.height);

        camera.setParameters(parameters);

        try {
            camera.setPreviewDisplay(surfaceHolder);
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }

        camera.startPreview();

    }



    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode)
        {
            case REQUEST_CODE :
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {

                    surfaceHolder.addCallback(this);
                    surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
                }
                else {
                    Toast.makeText(getActivity() , " Permission Not Granted" , Toast.LENGTH_LONG).show();
                }

        }

    }

    private void logout() {

        // logout code here

        new AlertDialog.Builder(getActivity())
                .setTitle("LogOut")
                .setMessage("Are you sure you want to Logout?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    //    auth.signOut();
                    }
                })

                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

    }

    private void Take_picture() {
        // take pic code here

        camera.takePicture(null , null , pictureCallback);

        pictureCallback = new Camera.PictureCallback() {
            @Override
            public void onPictureTaken(byte[] data, Camera camera) {

                Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0 , data.length);
                Bitmap  rotate = rotate(bitmap);
                String file = Img_path(rotate);

                if(file != null) {
            //        Intent i = new Intent(getActivity(), Capturedimg.class);
              //      startActivity(i);

                    return;
                }
            }
        };

    }


    public String Img_path(Bitmap bitmap) {
        String fname = " Imgs";

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            FileOutputStream fos = getContext().openFileOutput(fname, Context.MODE_PRIVATE);
            fos.write(baos.toByteArray());
            fos.close();
        } catch (Exception e) {

            e.printStackTrace();
            fname = null ;
        }
        return  fname;
    }


    private Bitmap rotate(Bitmap bitmap) {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();

        Matrix matrix = new Matrix();
        matrix.setRotate(90);
        return  Bitmap.createBitmap(bitmap ,0,0,w ,h, matrix , true);

    }

}
