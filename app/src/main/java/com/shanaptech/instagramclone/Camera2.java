package com.shanaptech.instagramclone;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraMetadata;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.util.Size;
import android.view.Surface;
import android.view.TextureView;

import java.util.Arrays;

public class Camera2 {
//    TextureView textureView;
//    CameraDevice cameraDevice;
//    Size img_d;
//    String Cam_ID;
//    CameraDevice.StateCallback statecallback ;
//    CaptureRequest.Builder mcaptuer;
//    CameraCaptureSession msession;
//    Handler backgroundHandler;
//    HandlerThread handlerThread;
//    textureView = v.findViewById(R.id.camera_view);
//      textureView.setSurfaceTextureListener(surfacetexturelistener);
//    TextureView.SurfaceTextureListener surfacetexturelistener = new TextureView.SurfaceTextureListener() {
//        @Override
//        public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
//
//            try {
//                Open_Camera();
//            } catch (CameraAccessException e) {
//                e.printStackTrace();
//            }
//        }
//
//        @Override
//        public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
//
//        }
//
//        @Override
//        public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
//            return false;
//        }
//
//        @Override
//        public void onSurfaceTextureUpdated(SurfaceTexture surface) {
//
//        }
//    };
//
//    private void Open_Camera() throws CameraAccessException {
//        CameraManager cameraManager = (CameraManager) getActivity().getSystemService(Context.CAMERA_SERVICE);
//
//        Cam_ID = cameraManager.getCameraIdList()[0];
//        CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(Cam_ID);
//
//        StreamConfigurationMap map = cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
//        img_d = map.getOutputSizes(TextureView.class)[0];
//        if(ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
//            return ;
//        }
//
//        cameraManager.openCamera(Cam_ID , statecallback , null);
//        statecallback = new CameraDevice.StateCallback() {
//            @Override
//            public void onOpened(@NonNull CameraDevice camera) {
//                cameraDevice = camera ;
//                startCamerapreView();
//
//
//            }
//
//            @Override
//            public void onDisconnected(@NonNull CameraDevice camera) {
//                cameraDevice.close();
//
//            }
//
//            @Override
//            public void onError(@NonNull CameraDevice camera, int error) {
//                cameraDevice.close();
//                cameraDevice = null;
//
//            }
//        };
//
//    }
//
//    private void startCamerapreView() {
//
//        SurfaceTexture surfaceTexture = textureView.getSurfaceTexture();
//        surfaceTexture.setDefaultBufferSize(img_d.getWidth(), img_d.getHeight());
//        Surface previewSurface = new Surface(surfaceTexture);
//        try {
//            mcaptuer = cameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW);
//            mcaptuer.addTarget(previewSurface);
//            cameraDevice.createCaptureSession(Arrays.asList(previewSurface), new CameraCaptureSession.StateCallback() {
//                @Override
//                public void onConfigured(@NonNull CameraCaptureSession session) {
//                    if(cameraDevice == null){
//                        return;
//                    }
//                    msession = session;
//                    try {
//                        Update_preview();
//                    } catch (CameraAccessException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//
//                @Override
//                public void onConfigureFailed(@NonNull CameraCaptureSession session) {
//
//                }
//            }, null );
//        } catch (CameraAccessException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//    private void Update_preview() throws CameraAccessException {
//        if(cameraDevice == null){
//            return;
//        }
//        mcaptuer.set(CaptureRequest.CONTROL_MODE , CameraMetadata.CONTROL_MODE_AUTO);
//        msession.setRepeatingRequest(mcaptuer.build(), null , backgroundHandler);
//
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        StartBackgroundThread();
//        if(textureView.isAvailable()){
//            try {
//                Open_Camera();
//            } catch (CameraAccessException e) {
//                e.printStackTrace();
//            }
//
//
//        }
//        else {
//
//            textureView.setSurfaceTextureListener(surfacetexturelistener);
//        }
//
//    }
//
//    private void StartBackgroundThread() {
//
//        handlerThread = new HandlerThread("Camera Background");
//        handlerThread.start();
//        backgroundHandler = new Handler( handlerThread.getLooper());
//    }
//
//    @Override
//    public void onPause() {
//        StopBackgroundThread();
//        super.onPause();
//    }
//
//    private void StopBackgroundThread() {
//
//        handlerThread.quitSafely();
//        try {
//            handlerThread.join();
//            backgroundHandler = null;
//            handlerThread = null;
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}
