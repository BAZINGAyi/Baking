package com.example.yuwzhang.baking.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.yuwzhang.baking.R;
import com.example.yuwzhang.baking.adapter.BakeListAdapter;
import com.example.yuwzhang.baking.base.Constant;
import com.example.yuwzhang.baking.bean.Bake;
import com.example.yuwzhang.baking.bean.IngredientsBean;
import com.example.yuwzhang.baking.bean.StepsBean;
import com.example.yuwzhang.baking.data.BakeService;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yuwzhang on 2018/1/25.
 */

public class BakeListFragment extends Fragment implements BakeListAdapter.OnBakeListAdapterClickListener {

    // RecyclerView 相关
    private RecyclerView mBakeListRecyclerView;
    private BakeListAdapter mBakeListAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bake_list, container, false);
        bindView(view);
        requestBakingData();
        return view;
    }

    private void initRecyclerView() {
        mBakeListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mBakeListRecyclerView.setHasFixedSize(true);
        mBakeListRecyclerView.setAdapter(mBakeListAdapter);
    }

    private void bindView(View view) {
        mBakeListRecyclerView = (RecyclerView) view.findViewById(R.id.bake_list_recyclerview);
    }
    private void requestBakingData() {
        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constant.BASE_URL).build();
        BakeService bakeService = retrofit.create(BakeService.class);
        Call<List<Bake>> call = bakeService.getBakeList();
        call.enqueue(new Callback<List<Bake>>() {
            @Override
            public void onResponse(Call<List<Bake>> call, Response<List<Bake>> response) {
                List<Bake> data = response.body();
                if (data != null) {
                    mBakeListAdapter = new BakeListAdapter(data, getActivity(), BakeListFragment.this);
                    // 初始化RecyclerView
                    initRecyclerView();
                    Log.e("MainActivity", "onResponse: " + data.get(0).getName());
                } else {
                    Log.e("MainActivity", "onResponse: " + "No data");
                }
            }

            @Override
            public void onFailure(Call<List<Bake>> call, Throwable t) {
                t.printStackTrace();
                Log.e("MainActivity", "onResponse: " + "ERROR");
            }
        });
    }

    /**
     * BakeListAdapter Callback
     * @param ingredientsBeanList
     * @param stepsBeanList
     */
    @Override
    public void OnClickItem(List<IngredientsBean> ingredientsBeanList, List<StepsBean> stepsBeanList) {
        // Toast.makeText(getActivity(), "张玉诶"+ position, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getActivity(), BakeDetailActivity.class);
        // put recipe data
        intent.putExtra("ingredientsBeanList", new Gson().toJson(ingredientsBeanList));
        intent.putExtra("stepsBeanList", new Gson().toJson(stepsBeanList));
        startActivity(intent);
    }
}
