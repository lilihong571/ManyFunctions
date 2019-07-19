package com.example.gridview_flower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class GridActivity extends AppCompatActivity {
    //声明控件
    private GridView mGv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        //赋值
        mGv = (GridView)findViewById(R.id.gv);
        //设置适配器
        mGv.setAdapter(new MyGridViewAdapter(this));
        //点击事件
        mGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //    显示的文字          时长LENGTH_SHORT
                Toast.makeText(GridActivity.this,"click"+i,Toast.LENGTH_SHORT).show();
            }
        });
        //长按事件
        mGv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GridActivity.this,"长按"+i,Toast.LENGTH_SHORT).show();
                return true;//这个事件，这个操作，已经处理完了，其他人不要再处理了
                //return false; //当执行了长按事件后，并不会把事件就此停止，点击事件同样也会被触发
            }
        });
    }
}

