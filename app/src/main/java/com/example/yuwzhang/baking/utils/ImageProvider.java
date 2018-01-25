package com.example.yuwzhang.baking.utils;

import java.util.Random;

/**
 * Created by yuwzhang on 2018/1/25.
 */

public class ImageProvider {
    private static String [] imageUrlLists = {
            "https://images.unsplash.com/photo-1428895009712-de9e58a18409?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=a721a548d8aed97f5ae1b23f1a94c13a&auto=format&fit=crop&w=2550&q=80",
            "https://images.unsplash.com/photo-1499889808931-317a0255c0e9?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=d03fc9378e5f00d215a0eb88113cc39d&auto=format&fit=crop&w=2550&q=80",
            "https://images.unsplash.com/photo-1504205758521-892897f3a28e?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=1869c2bfbe3ebef5fbcc9845228ef6de&auto=format&fit=crop&w=1350&q=80",
            "https://images.unsplash.com/photo-1494280235352-5dd6a55df7fd?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=f7f4fc0153e272eb826f11e5d94e62b1&auto=format&fit=crop&w=1350&q=80"
    };

    public static String getRandomImageUrl() {
        int randomVaule = new Random().nextInt(4);
        return imageUrlLists[randomVaule];
    }
}
