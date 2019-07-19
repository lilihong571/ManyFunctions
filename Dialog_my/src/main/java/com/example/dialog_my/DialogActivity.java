package com.example.dialog_my;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {
    private Button mBtnDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        mBtnDialog = (Button)findViewById(R.id.btn_custom_dialog);
        //设置点击事件
        mBtnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //实例化一下
                CustomDialog customDialog = new CustomDialog(DialogActivity.this);
                customDialog.setTitle("提示").setMessage("确认删除此项").setCancel("取消", new CustomDialog.IOnCancelListener() {
                    @Override
                    public void onCancel(CustomDialog dialog) {
                        Toast.makeText(DialogActivity.this,"cancel…",Toast.LENGTH_SHORT).show();
                    }
                }).setConfirm("确定", new CustomDialog.IOnConfirmListener() {
                    @Override
                    public void onConfirm(CustomDialog dialog) {
                        Toast.makeText(DialogActivity.this,"confirm" +
                                "…",Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });
    }
}
