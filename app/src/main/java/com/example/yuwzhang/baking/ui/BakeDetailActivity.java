package com.example.yuwzhang.baking.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuwzhang.baking.R;
import com.example.yuwzhang.baking.adapter.StepListAdapter;
import com.example.yuwzhang.baking.bean.IngredientsBean;
import com.example.yuwzhang.baking.bean.StepsBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;

public class BakeDetailActivity extends AppCompatActivity implements StepListAdapter.OnStepListAdapterClickListener{

    private TextView mRecipe_detail_tv;
    private RecyclerView mStepRecyclerView;
    private StepListAdapter mStepListAdapter;

    // data that pass to there
    private List<IngredientsBean> mIngredientsBeanList;
    private List<StepsBean> mStepsBeanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bake_detail);
        // get data form Intent
        String ingredientsJson = getIntent().getStringExtra("ingredientsBeanList");
        String stepListJson = getIntent().getStringExtra("stepsBeanList");
        this.mIngredientsBeanList = new Gson().fromJson(ingredientsJson, new TypeToken<List<IngredientsBean>>() {
        }.getType());
        this.mStepsBeanList = new Gson().fromJson(stepListJson, new TypeToken<List<StepsBean>>() {
        }.getType());
        // bind View
        bindView();
        // init View
        initView();
    }

    private void bindView() {
        mStepRecyclerView = (RecyclerView) findViewById(R.id.steps_detail_recyclerview);
        mRecipe_detail_tv = (TextView) findViewById(R.id.recipe_detail_tv);
    }

    private void initView() {
        // step view
        if (this.mStepsBeanList != null && this.mStepsBeanList.size() != 0) {
            mStepRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mStepRecyclerView.setHasFixedSize(true);
            mStepListAdapter = new StepListAdapter(this.mStepsBeanList, this, this);
            mStepRecyclerView.setAdapter(mStepListAdapter);
        }
        // ingredient view
        if (this.mIngredientsBeanList != null && this.mIngredientsBeanList.size() != 0) {
            String recipeFormatData = "";
            for (int i=0; i < this.mIngredientsBeanList.size(); i++) {
                recipeFormatData = recipeFormatData
                        + "Ingredient: " + this.mIngredientsBeanList.get(i).getIngredient()
                        + " Measure: " + this.mIngredientsBeanList.get(i).getMeasure()
                        + " Quantity: " + this.mIngredientsBeanList.get(i).getQuantity()
                        + "\n";
            }
            mRecipe_detail_tv.setText(recipeFormatData);
        }
    }

    @Override
    public void OnClickItem(int position) {
        Toast.makeText(this, "zhang", Toast.LENGTH_SHORT).show();
    }
}
