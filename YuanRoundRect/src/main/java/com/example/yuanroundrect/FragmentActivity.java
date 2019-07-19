package com.example.yuanroundrect;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentActivity extends AppCompatActivity {
        //创建6个文本
        private TextView textView_salary_standard;
        private TextView textView_list_project;
        private TextView textView_list_yi;
        private TextView textView_compele;
        private TextView textView_upload;
        private TextView textView_download;
        //创建一个图片控件
        private ImageView imageView;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_fragment);
            init();
            //开始状态
            textView_list_project.setBackgroundResource(R.drawable.textview_zhijiao_click);
            textView_list_project.setTextColor(getResources().getColor(R.color.colorWhite));
            //创建碎片
            Fragment fragment = new F2_List_Projects();
            //碎片管理者
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            //替换
            fragmentTransaction.replace(R.id.fragment_main,fragment);
            //提交
            fragmentTransaction.commit();

            //设置监听事件
            textView_salary_standard.setOnClickListener(onClickListener);
            textView_list_project.setOnClickListener(onClickListener);
            textView_list_yi.setOnClickListener(onClickListener);
            textView_compele.setOnClickListener(onClickListener);
            textView_upload.setOnClickListener(onClickListener);
            textView_download.setOnClickListener(onClickListener);
//        //设置图片点击监听事件
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
        }
        public void init(){
            //给文本赋值
            textView_salary_standard = (TextView)findViewById(R.id.salary_standard);
            textView_list_project = (TextView)findViewById(R.id.list_projects);
            textView_list_yi = (TextView)findViewById(R.id.list_yi);
            textView_compele = (TextView)findViewById(R.id.complete_text);
            textView_upload = (TextView)findViewById(R.id.upload_text);
            textView_download = (TextView)findViewById(R.id.download_text);
            //给图片空间初始化
            imageView = (ImageView)findViewById(R.id.image);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //创建碎片
                Fragment fragment = null;
                switch (view.getId()){
                    case R.id.salary_standard:
                        //背景颜色改变
                        textView_salary_standard.setBackgroundResource(R.drawable.textview_zhijiao_click);
                        textView_list_project.setBackgroundResource(R.drawable.textview_zhijiao);
                        textView_list_yi.setBackgroundResource(R.drawable.textview_zhijiao);
                        textView_compele.setBackgroundResource(R.drawable.textview_zhijiao);
                        textView_upload.setBackgroundResource(R.drawable.textview_zhijiao);
                        textView_download.setBackgroundResource(R.drawable.textview_zhijiao);
                        //字体颜色改变
                        textView_salary_standard.setTextColor(getResources().getColor(R.color.colorWhite));
                        textView_list_project.setTextColor(getResources().getColor(R.color.colorGreen));
                        textView_list_yi.setTextColor(getResources().getColor(R.color.colorGreen));
                        textView_compele.setTextColor(getResources().getColor(R.color.colorGreen));
                        textView_upload.setTextColor(getResources().getColor(R.color.colorGreen));
                        textView_download.setTextColor(getResources().getColor(R.color.colorGreen));
                        //碎片实例化
                        fragment = new F1_Salary_Standard();
                        break;
                    case R.id.list_projects:
                        textView_salary_standard.setBackgroundResource(R.drawable.textview_zhijiao);
                        textView_list_project.setBackgroundResource(R.drawable.textview_zhijiao_click);
                        textView_list_yi.setBackgroundResource(R.drawable.textview_zhijiao);
                        textView_compele.setBackgroundResource(R.drawable.textview_zhijiao);
                        textView_upload.setBackgroundResource(R.drawable.textview_zhijiao);
                        textView_download.setBackgroundResource(R.drawable.textview_zhijiao);
                        //字体颜色改变
                        textView_salary_standard.setTextColor(getResources().getColor(R.color.colorGreen));
                        textView_list_project.setTextColor(getResources().getColor(R.color.colorWhite));
                        textView_list_yi.setTextColor(getResources().getColor(R.color.colorGreen));
                        textView_compele.setTextColor(getResources().getColor(R.color.colorGreen));
                        textView_upload.setTextColor(getResources().getColor(R.color.colorGreen));
                        textView_download.setTextColor(getResources().getColor(R.color.colorGreen));
                        //碎片实例化
                        fragment = new F2_List_Projects();
                        break;
                    case R.id.list_yi:
                        textView_salary_standard.setBackgroundResource(R.drawable.textview_zhijiao);
                        textView_list_project.setBackgroundResource(R.drawable.textview_zhijiao);
                        textView_list_yi.setBackgroundResource(R.drawable.textview_zhijiao_click);
                        textView_compele.setBackgroundResource(R.drawable.textview_zhijiao);
                        textView_upload.setBackgroundResource(R.drawable.textview_zhijiao);
                        textView_download.setBackgroundResource(R.drawable.textview_zhijiao);
                        //字体颜色改变
                        textView_salary_standard.setTextColor(getResources().getColor(R.color.colorGreen));
                        textView_list_project.setTextColor(getResources().getColor(R.color.colorGreen));
                        textView_list_yi.setTextColor(getResources().getColor(R.color.colorWhite));
                        textView_compele.setTextColor(getResources().getColor(R.color.colorGreen));
                        textView_upload.setTextColor(getResources().getColor(R.color.colorGreen));
                        textView_download.setTextColor(getResources().getColor(R.color.colorGreen));
                        //碎片实例化
                        fragment = new F3_List_yi();
                        break;
                    case R.id.complete_text:
                        textView_salary_standard.setBackgroundResource(R.drawable.textview_zhijiao);
                        textView_list_project.setBackgroundResource(R.drawable.textview_zhijiao);
                        textView_list_yi.setBackgroundResource(R.drawable.textview_zhijiao);
                        textView_compele.setBackgroundResource(R.drawable.textview_zhijiao_click);
                        textView_upload.setBackgroundResource(R.drawable.textview_zhijiao);
                        textView_download.setBackgroundResource(R.drawable.textview_zhijiao);
                        //字体颜色改变
                        textView_salary_standard.setTextColor(getResources().getColor(R.color.colorGreen));
                        textView_list_project.setTextColor(getResources().getColor(R.color.colorGreen));
                        textView_list_yi.setTextColor(getResources().getColor(R.color.colorGreen));
                        textView_compele.setTextColor(getResources().getColor(R.color.colorWhite));
                        textView_upload.setTextColor(getResources().getColor(R.color.colorGreen));
                        textView_download.setTextColor(getResources().getColor(R.color.colorGreen));
                        //碎片实例化
                        fragment = new F4_Compele();
                        break;
                    case R.id.upload_text:
                        textView_salary_standard.setBackgroundResource(R.drawable.textview_zhijiao);
                        textView_list_project.setBackgroundResource(R.drawable.textview_zhijiao);
                        textView_list_yi.setBackgroundResource(R.drawable.textview_zhijiao);
                        textView_compele.setBackgroundResource(R.drawable.textview_zhijiao);
                        textView_upload.setBackgroundResource(R.drawable.textview_zhijiao_click);
                        textView_download.setBackgroundResource(R.drawable.textview_zhijiao);
                        //字体颜色改变
                        textView_salary_standard.setTextColor(getResources().getColor(R.color.colorGreen));
                        textView_list_project.setTextColor(getResources().getColor(R.color.colorGreen));
                        textView_list_yi.setTextColor(getResources().getColor(R.color.colorGreen));
                        textView_compele.setTextColor(getResources().getColor(R.color.colorGreen));
                        textView_upload.setTextColor(getResources().getColor(R.color.colorWhite));
                        textView_download.setTextColor(getResources().getColor(R.color.colorGreen));
                        //碎片实例化
                        fragment = new F5_UpLoad();
                        break;
                    case R.id.download_text:
                        textView_salary_standard.setBackgroundResource(R.drawable.textview_zhijiao);
                        textView_list_project.setBackgroundResource(R.drawable.textview_zhijiao);
                        textView_list_yi.setBackgroundResource(R.drawable.textview_zhijiao);
                        textView_compele.setBackgroundResource(R.drawable.textview_zhijiao);
                        textView_upload.setBackgroundResource(R.drawable.textview_zhijiao);
                        textView_download.setBackgroundResource(R.drawable.textview_zhijiao_click);
                        //字体颜色改变
                        textView_salary_standard.setTextColor(getResources().getColor(R.color.colorGreen));
                        textView_list_project.setTextColor(getResources().getColor(R.color.colorGreen));
                        textView_list_yi.setTextColor(getResources().getColor(R.color.colorGreen));
                        textView_compele.setTextColor(getResources().getColor(R.color.colorGreen));
                        textView_upload.setTextColor(getResources().getColor(R.color.colorGreen));
                        textView_download.setTextColor(getResources().getColor(R.color.colorWhite));
                        //碎片实例化
                        fragment = new F6_DownLoad();
                        break;
                }
                //创建碎片管理者
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                //替换
                fragmentTransaction.replace(R.id.fragment_main,fragment);
                //提交
                fragmentTransaction.commit();
            }
        };
    }
/*
问题：横屏后又会重置到开始状态
当屏幕的状态发生改变时，Activity的生命周期也重新被调用了。

后来通过百度，得到了解决方法：
在manifest中设置该Activity的configChanges为android:configChanges="screenSize|keyboardHidden|orientation"，
这样当横竖屏切换时，Activity的状态也没有改变。

以下别人的总结，引用一下：
1、不设置Activity的android:configChanges时，切屏会重新调用各个生命周期，切横屏时会执行一次，切竖屏时会执行两次
2、设置Activity的android:configChanges="orientation"时，切屏还是会重新调用各个生命周期，切横、竖屏时只会执行一次
3、设置Activity的android:configChanges="orientation|keyboardHidden"时，切屏不会重新调用各个生命周期，只会执行onConfigurationChanged方法

 */
