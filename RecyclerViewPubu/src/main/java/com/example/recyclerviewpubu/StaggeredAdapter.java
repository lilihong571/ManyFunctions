package com.example.recyclerviewpubu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by 李利红 on 2019/5/20.
 */

public class StaggeredAdapter extends RecyclerView.Adapter<StaggeredAdapter.RecyclerViewHolder> {
    private Context context;

    //创建一个接口对象
    private OnHorClickListen horClickListen;

    //构造函数
    public StaggeredAdapter(Context context, OnHorClickListen horClickListen){
        this.context = context;
        this.horClickListen = horClickListen;
    }
    @Override
    public StaggeredAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //填充视图并返回
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.staggered_list,parent,false));
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(StaggeredAdapter.RecyclerViewHolder holder, final int position) {
        //奇数
        //填充内容
        if(position%2!=0){
            holder.imageView.setImageResource(R.drawable.btn_music1);
        }
        else {
            holder.imageView.setImageResource(R.drawable.on2_4);
        }
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
        return 30;
    }
    //创建一个自定义类
    class RecyclerViewHolder extends RecyclerView.ViewHolder{
        //声明布局中中的控件
        private ImageView imageView;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            //给itemView中的文本赋值
            imageView = (ImageView) itemView.findViewById(R.id.iv);

        }

        public ImageView getImageView() {
            return imageView;
        }
    }
    //定义一个接口
    public interface OnHorClickListen{
        void click(int index);
    }
}
