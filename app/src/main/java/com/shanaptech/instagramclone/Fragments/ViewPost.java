package com.shanaptech.instagramclone.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.shanaptech.instagramclone.Additions.Heart;
import com.shanaptech.instagramclone.Image_info;
import com.shanaptech.instagramclone.R;
import com.shanaptech.instagramclone.SquareImageView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class ViewPost extends Fragment {
    SquareImageView squareImageView;
    Image_info img_info;
    TextView time_text;
    ImageView imglike , imgdislike ;
    GestureDetector mgestureDetector;
    Heart heart;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.view_post_layout, container, false);

        squareImageView = v.findViewById(R.id.square_post_img);


        time_text = v.findViewById(R.id.time);

        imglike = v.findViewById(R.id.like_imgs);
        imglike.setVisibility(View.GONE);
        imglike.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return mgestureDetector.onTouchEvent(event);
            }
        });

        imgdislike = v.findViewById(R.id.dislike_imgs);
        imgdislike.setVisibility(View.VISIBLE);
        imgdislike.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return mgestureDetector.onTouchEvent(event);
            }
        });
        mgestureDetector = new GestureDetector(getActivity() , new glistener());


        heart = new Heart(imglike , imgdislike);


//        Bundle bundle = this.getArguments();
//
//        bundle.getInt("position");
//
//        try {
//            UniversalImageLoader.SetImage(String.valueOf(bundle.getInt("position")), squareImageView, null, "");
//        }
//        catch (NullPointerException e)
//        {
//            e.printStackTrace();
//        }

      //  init_time();

   return  v;
    }
//    private String getTime()
//    {
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
//        sdf.setTimeZone(TimeZone.getTimeZone("Africa/Cairo"));
//
//
//        return sdf.format(new Date());
//    }

    public class glistener extends  GestureDetector.SimpleOnGestureListener
    {
        @Override
            public boolean onDown(MotionEvent e) {
                return true;
            }

            @Override
            public boolean onDoubleTap(MotionEvent e) {
                heart.liek();
                return true;
        }
    }

//    private void init_time()
//    {
//        String TimeDiff = Time();
//        if (!TimeDiff.equals("0"))
//        {
//            time_text.setText( TimeDiff + " Ago " );
//        }
//        else {
//            time_text.setText("Today");
//        }
//
//
//    }

}



