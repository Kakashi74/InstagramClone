package com.shanaptech.instagramclone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;



import java.util.ArrayList;

public class SettingsActivity extends AppCompatActivity {



    ArrayList<String> marraylist ;
    ListView listView;
    Context mcontext;
    ArrayAdapter madapter;
    ImageView imgback;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_settings);

       SetSettings();
       imgback = findViewById(R.id.back_settings);
       imgback.setClickable(true);
       imgback.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               startActivity(new Intent(SettingsActivity.this , Profile.class));
           }
       });

    }

    private void SetSettings()
    {
        marraylist = new ArrayList<>();
        listView = findViewById(R.id.list_view_settings);
        mcontext = SettingsActivity.this;

        marraylist.add("Edit Porfile");
        marraylist.add("Sign Out");

        madapter= new ArrayAdapter(mcontext , android.R.layout.simple_list_item_1 , marraylist);
        listView.setAdapter(madapter);

    }
}
