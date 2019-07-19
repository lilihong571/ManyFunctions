package com.example.dialog_5;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class DialogActivity extends AppCompatActivity {
    //声明控件
    private Button mBtnDialog1,mBtnDialog2,mBtnDialog3,mBtnDialog4,mBtnDialog5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        mBtnDialog1 = (Button)findViewById(R.id.btn_dialog1);
        mBtnDialog2 = (Button)findViewById(R.id.btn_dialog2);
        mBtnDialog3 = (Button)findViewById(R.id.btn_dialog3);
        mBtnDialog4 = (Button)findViewById(R.id.btn_dialog4);
        mBtnDialog5 = (Button)findViewById(R.id.btn_dialog5);
        //实例化一个
        OnClick onClick = new OnClick();
        mBtnDialog1.setOnClickListener(onClick);
        mBtnDialog2.setOnClickListener(onClick);
        mBtnDialog3.setOnClickListener(onClick);
        mBtnDialog4.setOnClickListener(onClick);
        mBtnDialog5.setOnClickListener(onClick);
    }
    //设置点击事件            //这些OnClickListener是View下面的
    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_dialog1:
                    //Builder设置模式的一种：建造模式,传入一个context
                    AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
//                    builder.setTitle("请回答");//setTitle返回的就是一个builder
//                    //中间的文本内容
//                    builder.setMessage("你觉得课程如何");
                    //setPositiveButton   积极的button:，也就是肯定的
                    //这里的OnClickListener是DialogInterface下面的
                    builder.setTitle("请回答").setIcon(R.mipmap.ic_launcher).setMessage("你觉得课程如何").setPositiveButton("棒", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(DialogActivity.this,"你很诚实",Toast.LENGTH_SHORT).show();
                        }
                        //setNegativeButton 消极的button，也就是否定的
                        //setNeutralButton()中性的     也不好也不丑
                    }).setNeutralButton("还行", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(DialogActivity.this,"你再瞅瞅",Toast.LENGTH_SHORT).show();
                        }
                    }).setNegativeButton("不好", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(DialogActivity.this,"睁眼说瞎话",Toast.LENGTH_SHORT).show();
                        }
                        //最后要显示，调用show()方法
                    }).show();
                    break;
                case R.id.btn_dialog2:
                    //创建一个数组
                    final String[] array2 = new String[]{"男","女"};
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(DialogActivity.this);
                    builder2.setTitle("选择性别").setItems(array2, new DialogInterface.OnClickListener() {
                        //int i 是数组的索引，从0开始
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(DialogActivity.this,array2[i],Toast.LENGTH_SHORT).show();
                        }
                    }).show();
                    break;
                case R.id.btn_dialog3:
                    //创建一个数组
                    final String[] array3 = new String[]{"男","女"};
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(DialogActivity.this);
                    //选中checkedItem                                            //默认选择男，因为0是男
                    builder3.setTitle("请选择性别").setSingleChoiceItems(array3, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(DialogActivity.this,array3[i],Toast.LENGTH_SHORT).show();
                            //让它点击选项的时候消失
                            dialogInterface.dismiss();
                        }
                        //setCancelable(false)点击旁边对话框不能消失
                    }).setCancelable(false).show();
                    break;
                case R.id.btn_dialog4:
                    //创建一个数组
                    final String[] array4 = new String[]{"唱歌","跳舞","写代码"};
                    //默认选中写代码
                    final boolean[] isSelected = new boolean[]{false,false,true};
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(DialogActivity.this);
                    //boolean类型的数组里面有三个值，分别表示唱歌，跳舞，写代码是否选中
                    builder4.setTitle("选择兴趣").setMultiChoiceItems(array4, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                        //i表示我们点的第几个，boolean b表示选中还是取消选中
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                            Toast.makeText(DialogActivity.this,array4[i]+":"+b,Toast.LENGTH_SHORT).show();
                        }
                    }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(DialogActivity.this,"选中了",Toast.LENGTH_SHORT).show();
                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(DialogActivity.this,"取消了",Toast.LENGTH_SHORT).show();

                        }
                    }).show();
                    break;
                //自定义
                case R.id.btn_dialog5:
                    AlertDialog.Builder builder5 = new AlertDialog.Builder(DialogActivity.this);
                    //inflate返回的是一个View,用View 来接一下
                    View view = LayoutInflater.from(DialogActivity.this).inflate(R.layout.layout_dialog,null);
                    //声明视图里面的控件,并findViewByID
                    final EditText etUserName = (EditText) view.findViewById(R.id.et_username);
                    final EditText etPassWord = (EditText) view.findViewById(R.id.et_password);
                    Button btnLogin = (Button)view.findViewById(R.id.btn_login);
                    btnLogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //获取etUserName和etPassWord的值
                            Toast.makeText(DialogActivity.this,etUserName.getText()+"/"+etPassWord.getText(),Toast.LENGTH_SHORT).show();
                        }
                    });
                    //把要画的布局放在setView(view)里
                    builder5.setTitle("请先登录").setView(view).show();
                    break;
            }
        }
    }
}
//btnLogin.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View view) {
//        //获取etUserName和etPassWord的值
//        //Toast.makeText(DialogActivity.this,etUserName.getText()+"/"+etPassWord.getText(),Toast.LENGTH_SHORT).show();
//        }
//        });
