package com.ahuo.fire.as3;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * description :
 * author : LiuHuiJie
 * created on : 2017-11-2
 */
public class TestAdapter extends Adapter<TestAdapter.MyViewHold>{

    private List<TestEntity> mTestEntities;

    public TestAdapter(List<TestEntity> entities){

        this.mTestEntities=entities;

    }

    @Override
    public MyViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, null);
        return new MyViewHold(view);
    }

    @Override
    public void onBindViewHolder(MyViewHold holder, int position) {
        TestEntity entity=mTestEntities.get(position);
        holder.mTvName.setText(entity.name);

    }

    @Override
    public int getItemCount() {
        if (mTestEntities!=null&&!mTestEntities.isEmpty()){
            return mTestEntities.size();
        }
        return 0;
    }

    protected class MyViewHold extends RecyclerView.ViewHolder{

        private TextView mTvName;


        public MyViewHold(View itemView) {
            super(itemView);
            mTvName=itemView.findViewById(R.id.tvName);
        }
    }

}
