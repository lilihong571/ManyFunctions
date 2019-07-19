package com.example.recyclerviewnet;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class NetActivity extends AppCompatActivity {
    //声明控件
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net);
        recyclerView = (RecyclerView) findViewById(R.id.rv_grid);
        //一行展示几列(几个)，
        recyclerView.setLayoutManager(new GridLayoutManager(this,10));
        //添加分隔线
        recyclerView.addItemDecoration(new MyItemDecoration());

//        //添加分隔线
//        mRvMain.addItemDecoration(new MyDecoration());
        //区别
        recyclerView.setAdapter(new GridAdapter(this, new GridAdapter.OnHorClickListen() {
            @Override
            public void click(int index) {
                Toast.makeText(NetActivity.this,"biubiubiu"+index,Toast.LENGTH_SHORT).show();
                //GridAdapter.RecyclerViewHolder.getTextView_recycler().setText("bbbbbbb");

            }
        }));
    }
    //自定义类用于添加分隔线
    class MyItemDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            //左上，右下
            outRect.set(0,0,getResources().getDimensionPixelOffset(R.dimen.divideHeight),getResources().getDimensionPixelOffset(R.dimen.divideHeight));
        }
    }
}
