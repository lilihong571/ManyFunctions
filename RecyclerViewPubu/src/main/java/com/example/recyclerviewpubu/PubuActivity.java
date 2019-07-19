package com.example.recyclerviewpubu;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

public class PubuActivity extends AppCompatActivity {
    //声明控件
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pubu);
        recyclerView = (RecyclerView)findViewById(R.id.rv_pu);
        //垂直，数字：代表有多少列，     水平，数字：代表有多少行
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        //添加间距
        recyclerView.addItemDecoration(new MyItemDecoration());

        recyclerView.setAdapter(new StaggeredAdapter(this, new StaggeredAdapter.OnHorClickListen() {
            @Override
            public void click(int index) {
                Toast.makeText(PubuActivity.this,"click"+index,Toast.LENGTH_SHORT).show();
            }
        }));
    }
    class MyItemDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int gap = getResources().getDimensionPixelSize(R.dimen.divideHeight);
            //左，上
            outRect.set(gap,gap,gap,gap);
        }
    }
}
