package com.shanaptech.instagramclone;

import java.io.File;
import java.util.ArrayList;

public class SearchDir {

    public static ArrayList<String> getDirpath (String  directory)
    {

        ArrayList<String> paths = new ArrayList<>();

        File file = new File(directory);

        File[] sfiel = file.listFiles();
        for(int i =0 ; i< sfiel.length ; i++)
        {
         if(sfiel[i].isDirectory())
         {
             paths.add(sfiel[i].getAbsolutePath());
         }
        }
return paths ;
    }


    public static ArrayList<String> getFilePath (String  directory)
    {

        ArrayList<String> paths = new ArrayList<>();

        File file = new File(directory);

        File[] sfiel = file.listFiles();
        for(int i =0 ; i< sfiel.length ; i++)
        {
            if(sfiel[i].isFile())
            {
                paths.add(sfiel[i].getAbsolutePath());
            }
        }
        return paths ;
    }


}
