package com.shanaptech.instagramclone;

import android.os.Environment;

public class DirectoryPath {

    public String Dir = Environment.getExternalStorageDirectory().getPath();

    public String Pic = Dir + "/Pictures";
    public String  Cam = Dir + "/DCIM/camera";

}
