package com.example.dialog_my;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by 李利红 on 2019/5/22.
 */

public class CustomDialog extends Dialog implements View.OnClickListener {
    //声明控件
    private TextView mTvTitle, mTvMessage, mTvCancel, mTvConfirm;
    //变量，参数，要传进来这些标题
    private String title, message, cancel, confirm;
    //声明
    private IOnCancelListener cancelListener;
    private IOnConfirmListener confirmListener;



    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, int themeId) {
        super(context, themeId);
    }
    //    public void setTitle(String title) {
//        this.title = title;
//    }
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public void setCancel(String cancel,IOnCancelListener listener) {
//        this.cancel = cancel;
//        this.cancelListener = listener;
//    }
//
//    public void setConfirm(String confirm,IOnConfirmListener listener) {
//        this.confirm = confirm;
//        this.confirmListener = listener;
//    }
//      这样写setTitle后面可以直接   点方法
    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }
    public CustomDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    public CustomDialog setCancel(String cancel,IOnCancelListener listener) {
        this.cancel = cancel;
        this.cancelListener = listener;
        return this;
    }

    public CustomDialog setConfirm(String confirm,IOnConfirmListener listener) {
        this.confirm = confirm;
        this.confirmListener = listener;
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);

        //设置宽度为屏幕宽度的百分比80%
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        Point size = new Point();
        d.getSize(size);
        //size.x表示他的一个宽度
        p.width = (int)(size.x * 0.8);//设置dialog的宽度为当前手机屏幕的宽度的80%
        getWindow().setAttributes(p);



        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mTvMessage = (TextView) findViewById(R.id.tv_message);
        mTvCancel = (TextView) findViewById(R.id.tv_cancel);
        mTvConfirm = (TextView) findViewById(R.id.tv_confirm);
        //前提是：不为null  且  不为双引号那个空(长度不为0)
        if (!TextUtils.isEmpty(title)) {
            mTvTitle.setText(title);
        }
        if (!TextUtils.isEmpty(message)) {
            mTvMessage.setText(message);
        }
        if (!TextUtils.isEmpty(cancel)) {
            mTvCancel.setText(cancel);
        }
        if (!TextUtils.isEmpty(confirm)) {
            mTvConfirm.setText(confirm);
        }
        //因为实现了View.OnClickListener这个接口，所以传入this就可以了
        mTvCancel.setOnClickListener(this);
        mTvConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_cancel:
                if(cancelListener != null){
                    //回调它的onCancel方法
                    cancelListener.onCancel(this);
                }
                //默认让dialog  dismiss()
                dismiss();
                break;
            case R.id.tv_confirm:
                if(confirmListener != null){
                    //this  把当前这个dialog传回去
                    confirmListener.onConfirm(this);
                }
                dismiss();
                break;
        }
    }

    //通过回调接口来写监听函数
    public interface IOnCancelListener{
        void onCancel(CustomDialog dialog);
    }
    public interface IOnConfirmListener{
        void onConfirm(CustomDialog dialog);
    }
}
