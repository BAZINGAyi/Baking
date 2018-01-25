package com.example.yuwzhang.baking.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.yuwzhang.baking.R;
import com.example.yuwzhang.baking.adapter.StepListAdapter;
import com.example.yuwzhang.baking.bean.IngredientsBean;
import com.example.yuwzhang.baking.bean.StepsBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class BakeDetailActivity extends AppCompatActivity {

    private RecyclerView stepRecyclerView;
    private StepListAdapter stepListAdapter;

    // data that pass to there
    private List<IngredientsBean> ingredientsBeanList;
    private List<StepsBean> stepsBeanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bake_detail);
        // get data form Intent
        String ingredientsJson = getIntent().getStringExtra("ingredientsBeanList");
        String stepListJson = getIntent().getStringExtra("stepsBeanList");
        this.ingredientsBeanList = new Gson().fromJson(ingredientsJson, new TypeToken<List<IngredientsBean>>() {
        }.getType());
        this.stepsBeanList = new Gson().fromJson(stepListJson, new TypeToken<List<StepsBean>>() {
        }.getType());
    }
}
