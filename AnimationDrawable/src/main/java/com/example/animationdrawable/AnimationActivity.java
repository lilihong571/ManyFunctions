package com.example.animationdrawable;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class AnimationActivity extends AppCompatActivity {
        //创建一个bool值
        private boolean isPlay = true;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_animation);

            //获取布局文件
            LinearLayout linearLayout = (LinearLayout)findViewById(R.id.my_layout);
            //获取帧动画
            final AnimationDrawable animationDrawable = (AnimationDrawable) linearLayout.getBackground();

            //获取动画
            final Animation animation = AnimationUtils.loadAnimation(this,R.anim.alpha_action);

            //获取图片
            final ImageView imageView = (ImageView)findViewById(R.id.image_bg);



            //获取按钮
            ImageButton imageButton = (ImageButton)findViewById(R.id.image_play);
            //设置按钮监听
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(isPlay == true){
                        //开启帧动画
                        animationDrawable.start();
                        isPlay = false;
                        //从有到无动画
                        imageView.startAnimation(animation);
                    }
                    else {
                        //暂停帧动画
                        animationDrawable.stop();
                        isPlay = true;
                        //从无到有
                        imageView.startAnimation(animation);
                    }
                }
            });

        }
    }