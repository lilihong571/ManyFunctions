package com.example.recyclerviewnet;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by 李利红 on 2019/5/20.
 */

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.RecyclerViewHolder> {
    private Context context;

    //创建一个接口对象
    private OnHorClickListen horClickListen;

    //构造函数
    public GridAdapter(Context context, OnHorClickListen horClickListen){
        this.context = context;
        this.horClickListen = horClickListen;
    }
    @Override
    public GridAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //填充视图并返回
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_list,parent,false));
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(GridAdapter.RecyclerViewHolder holder, final int position) {
        //填充文本内容
        holder.textView_recycler.setText("ASDFGHJKL");
        //设置点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context,"click…"+position,Toast.LENGTH_SHORT).show();
                //Toast.makeText(mContext,"click…"+position,Toast.LENGTH_SHORT).show();
                horClickListen.click(position);
            }
        });
    }
    //获取链表大小
    @Override
    public int getItemCount() {
        return 800;
    }
    //创建一个自定义类
    static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        //声明布局中中的控件
        private static TextView textView_recycler;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            //给itemView中的文本赋值
            textView_recycler = itemView.findViewById(R.id.text_recycler);

        }

        public static TextView getTextView_recycler() {
            return textView_recycler;
        }
    }
    //定义一个接口
    public interface OnHorClickListen{
        void click(int index);
    }
}
