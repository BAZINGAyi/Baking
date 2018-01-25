package com.example.yuwzhang.baking.bean;

/**
 * Created by yuwzhang on 2018/1/25.
 */

public class StepsBean {
    /**
     * id : 0
     * shortDescription : Recipe Introduction
     * description : Recipe Introduction
     * videoURL : https://s3.cn-north-1.amazonaws.com.cn/static-documents/nd801/ProjectResources/Baking/-intro-creampie.mp4
     * thumbnailURL :
     */

    private int id;
    private String shortDescription;
    private String description;
    private String videoURL;
    private String thumbnailURL;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }
}