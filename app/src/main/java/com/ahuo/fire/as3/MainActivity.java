package com.ahuo.fire.as3;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.HorizontalScrollView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private GridLayoutManager mLayoutManager;

    private TestAdapter mTestAdapter;

    private List<TestEntity> mTestEntities;

    private HorizontalScrollView mHorizontalScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mHorizontalScrollView = findViewById(R.id.scrollView);
        mLayoutManager = new GridLayoutManager(this, 10);
        mLayoutManager.setReverseLayout(true);
        mRecyclerView.setLayoutManager(mLayoutManager);


    }


    private void initData() {
        mTestEntities = new ArrayList<>();
        for (int i = 1; i < 200; i++) {
            TestEntity entity = new TestEntity();
            entity.name = "liu" + i;
            mTestEntities.add(entity);
        }
        mTestAdapter = new TestAdapter(mTestEntities);
        mRecyclerView.setAdapter(mTestAdapter);
        mLayoutManager.scrollToPositionWithOffset(87, 0);
        mHandler.sendEmptyMessageDelayed(88, 1000);

    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //  mLayoutManager.smoothScrollToPosition(mRecyclerView,null,85);
          //  RecyclerView.ViewHolder holder = getItemHold(mLayoutManager, 87);
            mHorizontalScrollView.scrollBy((int) ((View)(getItemHold(mLayoutManager,87).getParent())).getX(), 0);
            //  mRecyclerView.smoothScrollBy(0, 10000);
            //   mRecyclerView.smoothScrollToPosition(33);
            //  mTestAdapter.notifyItemChanged(33);
            //     mTestEntities.get(85).name="hellsdsd盛世嫡妃水电费o";
            //   mTestAdapter.notifyItemChanged(85);
            //  mRecyclerView.smoothScrollToPosition(85);
        }
    };

    private View getItemHold(GridLayoutManager layoutManager, int position) {
        int firstItemPosition = layoutManager.findFirstVisibleItemPosition();
        if (position - firstItemPosition >= 0) {
            //得到要更新的item的view
            View view = mRecyclerView.getChildAt(position - firstItemPosition + 1);
          /*  if (null != mRecyclerView.getChildViewHolder(view)) {
                RecyclerView.ViewHolder viewHolder = mRecyclerView.getChildViewHolder(view);
                return viewHolder;
            }*/
          return view;
        }
        return null;
    }
}
