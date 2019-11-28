package com.shanaptech.instagramclone.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shanaptech.instagramclone.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Chat_Fragment extends Fragment {

    public static  Chat_Fragment  newInstance() {
        Chat_Fragment f = new Chat_Fragment() ;
        return f;
    }
    public Chat_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {// Inflate the layout for this fragment

     View v = inflater.inflate(R.layout.fragment_chat_, container, false);
     return  v;
    }

}
