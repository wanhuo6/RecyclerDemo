package com.ahuo.fire.as3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private TestAdapter mTestAdapter;

    private List<TestEntity> mTestEntities;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    private void initView() {
        mRecyclerView=findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager=new GridLayoutManager(this,50){
            @Override
            public boolean canScrollVertically() {
                return true;
            }

            @Override
            public boolean canScrollHorizontally() {
                return false;
            }
        };
        layoutManager.setReverseLayout(true);
        mRecyclerView.setLayoutManager(layoutManager);



    }


    private void initData() {
        mTestEntities=new ArrayList<>();
        for (int i=1;i<500;i++){
            TestEntity entity=new TestEntity();
            entity.name="liu"+i;
            mTestEntities.add(entity);
        }
        mRecyclerView.setAdapter(new TestAdapter(mTestEntities));
        mRecyclerView.smoothScrollBy(0, -10000);

    }

}
