package com.example.recyclerviewhor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclerviewhor.R;

/**
 * Created by 李利红 on 2019/5/20.
 */

public class HorAdapter extends RecyclerView.Adapter<HorAdapter.HorViewHolder> {
    //创建一个上下文
    private Context context;
    //创建一个监听对象
    private OndddClick ondddClick;
    //构造函数
    public HorAdapter(Context context, OndddClick ondddClick){
        this.context = context;
        this.ondddClick = ondddClick;
    }
    @Override
    public HorAdapter.HorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HorViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.hor_list,parent,false));
    }

    @Override
    public void onBindViewHolder(HorAdapter.HorViewHolder holder, final int position) {
        //不写泛型，这里就不会出现
        holder.textView_title.setText("Hello!");
        //设置监听
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context,"click"+position,Toast.LENGTH_SHORT).show();
                ondddClick.click(position);
            }
        });
    }
    //获取列表大小
    @Override
    public int getItemCount() {
        return 30;
    }
    //创建自定义类
    class HorViewHolder extends RecyclerView.ViewHolder{
        //声明文本控件
        private TextView textView_title;
        public HorViewHolder(View itemView) {
            super(itemView);
            //给文本控件赋值
            textView_title = itemView.findViewById(R.id.tv_title);
        }
    }
    //自定义接口
    public interface OndddClick{
        void click(int i);
    }
}
