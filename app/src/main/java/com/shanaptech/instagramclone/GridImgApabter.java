package com.shanaptech.instagramclone;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.ArrayList;

public class GridImgApabter extends ArrayAdapter<String> {
    private Context mcontect;
    private LayoutInflater layout;
    private int resource;
    private String mappend;
    private ArrayList<String> imgurl;

    public GridImgApabter(Context context, int resource, String append, ArrayList<String> imgurl) {
        super(context, resource , imgurl);
        this.mcontect = context;
        this.layout = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        this.resource = resource;
        this.mappend = append;
        this.imgurl = imgurl;
    }
    private static class ViewHolder
    {
        SquareImageView img ;
        ProgressBar mprogress ;
    }


    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {

       final ViewHolder holder;

       if(convertView == null)
       {
           convertView = layout.inflate(resource , parent , false);
           holder = new ViewHolder();
           holder.mprogress = convertView.findViewById(R.id.progress_imgs_loaded);
           holder.img = convertView.findViewById(R.id.imgs_in_insta);

           convertView.setTag(holder);
       }
       else
       {
           holder = (ViewHolder) convertView.getTag();

       }
        String imgURL = getItem(position);

        ImageLoader imgloader = ImageLoader.getInstance();


        imgloader.displayImage(mappend + imgURL, holder.img, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                if (holder.mprogress != null)
                {
                    holder.mprogress.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                if (holder.mprogress != null)
                {
                    holder.mprogress.setVisibility(View.GONE);

                }
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                if (holder.mprogress != null)
                {
                    holder.mprogress.setVisibility(View.GONE);

                }
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                if (holder.mprogress != null)
                {
                    holder.mprogress.setVisibility(View.GONE);

                }
            }
        });





        return  convertView;



    }
}
