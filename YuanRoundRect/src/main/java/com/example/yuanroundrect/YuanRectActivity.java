package com.example.yuanroundrect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class YuanRectActivity extends AppCompatActivity {
    private TextView textView_one;
    private TextView textView_two;
    private TextView textView_three;
    private TextView textView_four;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuan_rect);
        //赋值
        textView_one = (TextView)findViewById(R.id.tv_one);
        textView_two = (TextView)findViewById(R.id.tv_two);
        textView_three = (TextView)findViewById(R.id.tv_three);
        textView_four = (TextView)findViewById(R.id.tv_four);
        //监听
        textView_one.setOnClickListener(onClickListener);
        textView_two.setOnClickListener(onClickListener);
        textView_three.setOnClickListener(onClickListener);
        textView_four.setOnClickListener(onClickListener);
    }
    //监听函数
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tv_one:
                    //背景颜色改变
                    textView_one.setBackgroundResource(R.drawable.textview_zhijiao_click);
                    textView_two.setBackgroundResource(R.drawable.textview_zhijiao);
                    textView_three.setBackgroundResource(R.drawable.textview_zhijiao);
                    textView_four.setBackgroundResource(R.drawable.textview_zhijiao);
                    //字体颜色改变
                    textView_one.setTextColor(getResources().getColor(R.color.colorWhite));
                    textView_two.setTextColor(getResources().getColor(R.color.colorGreen));
                    textView_three.setTextColor(getResources().getColor(R.color.colorGreen));
                    textView_four.setTextColor(getResources().getColor(R.color.colorGreen));
                    break;
                case R.id.tv_two:
                    textView_one.setBackgroundResource(R.drawable.textview_zhijiao);
                    textView_two.setBackgroundResource(R.drawable.textview_zhijiao_click);
                    textView_three.setBackgroundResource(R.drawable.textview_zhijiao);
                    textView_four.setBackgroundResource(R.drawable.textview_zhijiao);
                    //字体颜色改变
                    textView_one.setTextColor(getResources().getColor(R.color.colorGreen));
                    textView_two.setTextColor(getResources().getColor(R.color.colorWhite));
                    textView_three.setTextColor(getResources().getColor(R.color.colorGreen));
                    textView_four.setTextColor(getResources().getColor(R.color.colorGreen));
                    break;
                case R.id.tv_three:
                    textView_one.setBackgroundResource(R.drawable.textview_zhijiao);
                    textView_two.setBackgroundResource(R.drawable.textview_zhijiao);
                    textView_three.setBackgroundResource(R.drawable.textview_zhijiao_click);
                    textView_four.setBackgroundResource(R.drawable.textview_zhijiao);

                    //字体颜色改变
                    textView_one.setTextColor(getResources().getColor(R.color.colorGreen));
                    textView_two.setTextColor(getResources().getColor(R.color.colorGreen));
                    textView_three.setTextColor(getResources().getColor(R.color.colorWhite));
                    textView_four.setTextColor(getResources().getColor(R.color.colorGreen));

                    break;
                case R.id.tv_four:
                    textView_one.setBackgroundResource(R.drawable.textview_zhijiao);
                    textView_two.setBackgroundResource(R.drawable.textview_zhijiao);
                    textView_three.setBackgroundResource(R.drawable.textview_zhijiao);
                    textView_four.setBackgroundResource(R.drawable.textview_zhijiao_click);

                    //字体颜色改变
                    textView_one.setTextColor(getResources().getColor(R.color.colorGreen));
                    textView_two.setTextColor(getResources().getColor(R.color.colorGreen));
                    textView_three.setTextColor(getResources().getColor(R.color.colorGreen));
                    textView_four.setTextColor(getResources().getColor(R.color.colorWhite));
                    break;
            }
        }
    };
}
