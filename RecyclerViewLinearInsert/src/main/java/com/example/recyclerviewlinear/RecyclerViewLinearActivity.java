package com.example.recyclerviewlinear;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class RecyclerViewLinearActivity extends AppCompatActivity {
    //声明控件
    private RecyclerView mRvMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_linear);
        mRvMain = (RecyclerView)findViewById(R.id.rv_main);

        mRvMain.setLayoutManager(new LinearLayoutManager(RecyclerViewLinearActivity.this));
        //添加分隔线
        mRvMain.addItemDecoration(new MyDecoration());
        //那边实现接口之后
        mRvMain.setAdapter(new LinearAdapter(RecyclerViewLinearActivity.this, new LinearAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(RecyclerViewLinearActivity.this,"click "+pos,Toast.LENGTH_SHORT).show();
            }
        }));
        //
    }
    class MyDecoration extends RecyclerView.ItemDecoration{
        //实现抽象类的方法
//        @Override
//        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//            super.getItemOffsets(outRect, view, parent, state);
//            //左上，右下
//            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight));
//        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight));
        }
    }
}

