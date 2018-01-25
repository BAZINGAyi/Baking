package com.example.yuwzhang.baking.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yuwzhang.baking.R;
import com.example.yuwzhang.baking.bean.Bake;
import com.example.yuwzhang.baking.bean.IngredientsBean;
import com.example.yuwzhang.baking.bean.StepsBean;
import com.example.yuwzhang.baking.utils.ImageProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuwzhang on 2018/1/25.
 */

public class BakeListAdapter extends RecyclerView.Adapter<BakeListAdapter.BakeListAdapterViewHolder> {

    private List<Bake> mBakeList = new ArrayList<>();
    private Context mContext;

    // item type
    private static final int VIEW_TYPE_RECOMMEND = 0;
    private static final int VIEW_TYPE_NORMAL = 1;

    // item callback
    public OnBakeListAdapterClickListener onBakeListAdapterClickListener;

    public BakeListAdapter(List<Bake> data, Context context,
                           OnBakeListAdapterClickListener onBakeListAdapterClickListener) {
        this.mBakeList = data;
        this.mContext = context;
        this.onBakeListAdapterClickListener = onBakeListAdapterClickListener;
    }

    @Override
    public BakeListAdapter.BakeListAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        if ( viewGroup instanceof RecyclerView ) {
            int layoutId = -1;
            switch (viewType) {
                case VIEW_TYPE_NORMAL: {
                    layoutId = R.layout.list_item_bake;
                    break;
                }
                case VIEW_TYPE_RECOMMEND: {
                    layoutId = R.layout.list_item_bake_recommend;
                    break;
                }
            }
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(layoutId, viewGroup, false);
            view.setFocusable(true);
            return new BakeListAdapterViewHolder(view);
        } else {
            throw new RuntimeException("Not bound to RecyclerView");
        }
    }

    @Override
    public void onBindViewHolder(BakeListAdapter.BakeListAdapterViewHolder holder, int position) {
        holder.mBakeName.setText(this.mBakeList.get(position).getName());
        holder.mBakeIngredientsCount.setText("Ingredients Counts:" + this.mBakeList.get(position)
                .getIngredients().size()+"");
        holder.mBakeStepCount.setText("Step Count:" + this.mBakeList.get(position).getSteps().size()+"");
        Glide.with(mContext)
                .load(ImageProvider.getRandomImageUrl())
                .into(holder.mBakeImage);
    }

    @Override
    public int getItemCount() {
        if (this.mBakeList != null && this.mBakeList.size() != 0) {
            return this.mBakeList.size();
        } else {
            return 0;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return (position == 0) ? VIEW_TYPE_RECOMMEND : VIEW_TYPE_NORMAL;
    }

    public class BakeListAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private final TextView mBakeName;
        private final TextView mBakeIngredientsCount;
        private final TextView mBakeStepCount;
        private final ImageView mBakeImage;

        public BakeListAdapterViewHolder(View view) {
            super(view);
            mBakeName = (TextView) view.findViewById(R.id.bake_name_tv);
            mBakeIngredientsCount = (TextView) view.findViewById(R.id.bake_ingredients_count_tv);
            mBakeStepCount = (TextView) view.findViewById(R.id.bake_step_count_tv);
            mBakeImage = (ImageView) view.findViewById(R.id.bake_image_iv);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onBakeListAdapterClickListener.OnClickItem(mBakeList.get(getAdapterPosition()).getIngredients(),
                    mBakeList.get(getAdapterPosition()).getSteps());
        }
    }

    public interface OnBakeListAdapterClickListener {
        void OnClickItem(List<IngredientsBean> ingredientsBeanList, List<StepsBean> stepsBeanList);
    }
}
