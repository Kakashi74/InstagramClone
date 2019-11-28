package com.shanaptech.instagramclone.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.shanaptech.instagramclone.EditProfile;
import com.shanaptech.instagramclone.GridImgApabter;
import com.shanaptech.instagramclone.R;
import com.shanaptech.instagramclone.UniversalImageLoader;

import java.util.ArrayList;

public class fragment_profile extends Fragment {

    private int NUMBER_GRID_COLUMN = 3;
        Context mcontext;
        ProgressBar progressBar;
        GridView gridView;
        ImageView img1 ;
        ImageView Settings_img;
    public interface  GridImageSelectedListener
    {
         void onGridImageSelected(int position);
    }
     GridImageSelectedListener gridImageSelectedListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile , container , false );

        mcontext = getActivity();

        Settings_img = v.findViewById(R.id.edit);
        Settings_img.setClickable(true);
        Settings_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mcontext , EditProfile.class);
                startActivity(intent);
            }
        });

        img1 = v.findViewById(R.id.my_photo);
        gridView = v.findViewById(R.id.grid_view_images);

       progressBar = v.findViewById(R.id.home_progressbar);
       progressBar.setVisibility(View.GONE);

        init();
        setProfileImg();
        ImgofGrid();
        return  v;
    }

    private void setProfileImg ()
        {
            String uri = "https://media.kasperskydaily.com/wp-content/uploads/sites/92/2014/11/06042229/Android-2.png";

            UniversalImageLoader.SetImage(uri, img1, progressBar, "");
        }
        private void init()
        {
            UniversalImageLoader imageLoader = new UniversalImageLoader(mcontext);
            ImageLoader.getInstance().init(imageLoader.imageConfig());
        }

       private void ImgofGrid()
        {
        ArrayList<String> URLs = new ArrayList<>();
         URLs.add("https://media.kasperskydaily.com/wp-content/uploads/sites/92/2014/11/06042229/Android-2.png");
         URLs.add("https://media.kasperskydaily.com/wp-content/uploads/sites/92/2014/11/06042229/Android-2.png");
         URLs.add("https://media.kasperskydaily.com/wp-content/uploads/sites/92/2014/11/06042229/Android-2.png");
         URLs.add("https://media.kasperskydaily.com/wp-content/uploads/sites/92/2014/11/06042229/Android-2.png");
         URLs.add("https://media.kasperskydaily.com/wp-content/uploads/sites/92/2014/11/06042229/Android-2.png");
         URLs.add("https://media.kasperskydaily.com/wp-content/uploads/sites/92/2014/11/06042229/Android-2.png");
         URLs.add("https://media.kasperskydaily.com/wp-content/uploads/sites/92/2014/11/06042229/Android-2.png");
         URLs.add("https://regmedia.co.uk/2018/01/12/android_embarassed.jpg?x=442&y=293&crop=1");
         URLs.add("https://regmedia.co.uk/2018/01/12/android_embarassed.jpg?x=442&y=293&crop=1");


            SetUp_ImgGrid(URLs);

}
    private void SetUp_ImgGrid(ArrayList<String> imgUrls)
    {

        int gridwidth =  getResources().getDisplayMetrics().widthPixels;
        int imgwidth =  gridwidth/NUMBER_GRID_COLUMN;

       gridView.setColumnWidth(imgwidth);

       GridImgApabter apabter = new GridImgApabter(mcontext , R.layout.layout_grid_imgview ,"" , imgUrls);        gridView.setAdapter(apabter);
       gridView.setAdapter(apabter);
       gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               gridImageSelectedListener.onGridImageSelected(position);
           }
       });

    }

    @Override
    public void onAttach(Context context) {
        try {
            gridImageSelectedListener = (GridImageSelectedListener) getActivity();
        }
        catch (ClassCastException e)
        {
            e.printStackTrace();
        }
        super.onAttach(context);
    }
}
