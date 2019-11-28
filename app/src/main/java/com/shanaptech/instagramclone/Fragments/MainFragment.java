package com.shanaptech.instagramclone.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.shanaptech.instagramclone.ChooseActivity;
import com.shanaptech.instagramclone.InstaStuff.FindUser;
import com.shanaptech.instagramclone.Profile;
import com.shanaptech.instagramclone.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    ImageView img1 , img2 ,img3 ;
    public static  MainFragment  newInstance() {
        MainFragment f = new MainFragment() ;
        return f;
    }

    public MainFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_main2, container, false);
        img1 = v.findViewById(R.id.person);
        img1.setClickable(true);

        img2 = v.findViewById(R.id.search);
        img2.setClickable(true);

        img3 = v.findViewById(R.id.add);
        img3.setClickable(true);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        Intent intent = new Intent(getActivity(), Profile.class);
                        startActivity(intent);
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getActivity(), FindUser.class);
                startActivity(intent1);
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getActivity(), ChooseActivity.class);
                startActivity(intent2);
            }
        });

   return v ;
    }

}
