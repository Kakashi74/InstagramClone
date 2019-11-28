package com.shanaptech.instagramclone.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.shanaptech.instagramclone.R;
import com.shanaptech.instagramclone.UniversalImageLoader;


public class Edit_Profile extends Fragment {


      //  ImageView imgprofile;


    public Edit_Profile() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.top_profile_stuff, container, false);


//        SetconfigImage();
//
//        imgprofile = v.findViewById(R.id.image_change_profile);
//        ImageView imgback = v.findViewById(R.id.back_settings);
//        imgback.setClickable(true);
//        imgback.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                getActivity().finish();
//            }
//        });
        return  v;

    }


//    private void SetconfigImage()
//    {
//        String uri = "https://damasnow.com/wp-content/uploads/2018/05/%D8%A3%D9%86%D8%AF%D8%B1%D9%88%D9%8A%D8%AF-%D8%A3%D9%88%D8%B1%D9%8A%D9%88.jpg";
//        UniversalImageLoader.SetImage(uri , imgprofile,null , "");
//
//    }

}
