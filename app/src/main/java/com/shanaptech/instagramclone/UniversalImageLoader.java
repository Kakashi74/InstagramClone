package com.shanaptech.instagramclone;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

public class UniversalImageLoader {

    private static final int default_image = R.drawable.default_person ;
    private Context mcontext;

    public UniversalImageLoader(Context context)
    {
        this.mcontext = context;
    }
    public ImageLoaderConfiguration imageConfig()
    {
        DisplayImageOptions config = new DisplayImageOptions.Builder()
                .showImageOnLoading(default_image)
                .showImageOnFail(default_image)
                .showImageForEmptyUri(default_image)
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .considerExifParams(true)
                .cacheOnDisk(true)
                .resetViewBeforeLoading(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300))
                .build();


        ImageLoaderConfiguration imgconfig = new ImageLoaderConfiguration.Builder(mcontext)
                .defaultDisplayImageOptions(config)
                .memoryCache(new WeakMemoryCache())
                .diskCacheSize(100*1024*1024)
                .build();

        return  imgconfig;
    }
    public static void SetImage(String imguri , ImageView img , final ProgressBar mprogress , String append )
    {
        ImageLoader imgloader =  ImageLoader.getInstance();
        imgloader.displayImage(append + imguri, img, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                if(mprogress != null)
                {
                    mprogress.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                if(mprogress != null)
                {
                    mprogress.setVisibility(View.GONE);
                }

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                if(mprogress != null)
                {
                    mprogress.setVisibility(View.GONE);
                }
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                if(mprogress != null)
                {
                    mprogress.setVisibility(View.GONE);
                }
            }
        });
    }



}
