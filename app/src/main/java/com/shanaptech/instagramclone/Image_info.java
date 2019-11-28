package com.shanaptech.instagramclone;

public class Image_info {
    String description;
    String date;
    String Path;
    String img_id;
    String user_id;


    public Image_info()
    {

    }

    public Image_info(String description, String date, String path, String img_id, String user_id) {
        this.description = description;
        this.date = date;
        Path = path;
        this.img_id = img_id;
        this.user_id = user_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }

    public String getImg_id() {
        return img_id;
    }

    public void setImg_id(String img_id) {
        this.img_id = img_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Image_info{" +
                "description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", Path='" + Path + '\'' +
                ", img_id='" + img_id + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }
}
