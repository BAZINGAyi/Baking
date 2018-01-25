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
import com.example.yuwzhang.baking.utils.ImageProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuwzhang on 2018/1/25.
 */

public class StepListAdapter extends RecyclerView.Adapter<StepListAdapter.StepAdapterViewHolder> {

    private List<Bake> mBakeList = new ArrayList<>();
    private Context mContext;

    // item callback
    public OnStepListAdapterClickListener onStepListAdapterClickListener;

    public StepListAdapter(List<Bake> data, Context context,
                           OnStepListAdapterClickListener onStepListAdapterClickListener) {
        this.mBakeList = data;
        this.mContext = context;
        this.onStepListAdapterClickListener = onStepListAdapterClickListener;
    }

    @Override
    public StepAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        if ( viewGroup instanceof RecyclerView ) {
            int layoutId = -1;
            layoutId = R.layout.list_item_step;
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(layoutId, viewGroup, false);
            view.setFocusable(true);
            return new StepAdapterViewHolder(view);
        } else {
            throw new RuntimeException("Not bound to RecyclerView");
        }
    }

    @Override
    public void onBindViewHolder(StepAdapterViewHolder holder, int position) {
        holder.mStepDescribe.setText("hhhhhhhhhhhhhhhhh");
        Glide.with(mContext)
                .load(ImageProvider.getRandomImageUrl())
                .into(holder.mStepImageFlag);
    }

    @Override
    public int getItemCount() {
        if (this.mBakeList != null && this.mBakeList.size() != 0) {
            return this.mBakeList.size();
        } else {
            return 0;
        }
    }

    public class StepAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private final TextView mStepDescribe;
        private final ImageView mStepImageFlag;

        public StepAdapterViewHolder(View view) {
            super(view);
            mStepDescribe = (TextView) view.findViewById(R.id.step_describe_tv);
            mStepImageFlag = (ImageView) view.findViewById(R.id.step_flag);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onStepListAdapterClickListener.OnClickItem(123457);
        }
    }

    public interface OnStepListAdapterClickListener {
        void OnClickItem(int position);
    }
}
