package com.example.yuwzhang.baking.data;

import com.example.yuwzhang.baking.bean.Bake;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by yuwzhang on 2018/1/25.
 */

public interface BakeService {

    @GET("static-documents/nd801/ProjectResources/Baking/baking-cn.json")
    Call<List<Bake>> getBakeList();
}
