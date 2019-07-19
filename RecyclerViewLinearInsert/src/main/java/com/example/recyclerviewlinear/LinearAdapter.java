package com.example.recyclerviewlinear;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recyclerviewlinear.R;

//import com.example.mytest.R;//要用R.layout.layout_linear_item布局文件需要导入这个包

/**
 * Created by 李利红 on 2019/5/20.
 */
                                                    //传入泛型 //########################
public class LinearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    //创建一个上下文
    private Context mContext;
//    //实际开发要传入一个List数据
//    private List<String> list;

    //2.定义接口之后
    private OnItemClickListener mlistener;

    //构造方法
    public LinearAdapter(Context mContext/*,List<String> list*/, OnItemClickListener mlistener){
        this.mContext = mContext;
//        this.list = list;
        this.mlistener = mlistener;
    }
    //1.#########################################
    @Override        //修改返回值为泛型                         根据不同的viewType显示不同的itemView
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {//##################################
        //偶数
        if(viewType == 0){
            //new 一个LinearViewHolder(要传入一个View:就是每一个item长什么样子的那个布局)
            return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item,parent,false));
        }
        else {                                                                  //#################################
            return new LinearViewHolder2(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item_2,parent,false));
        }
    }

    @Override
    public int getItemViewType(int position) {//3.#########################################
        if (position % 2 == 0){
            return 0;//返回0就是偶数
        }
        else {
            return 1;//返回1就是奇数
        }
    }

    //绑定ViewHolder                   //######################################
    @Override                         //修改返回值为泛型
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        //如果是0   LinearViewHolder
        if(getItemViewType(position) == 0){//2.########################
            //通过holder去设置
            ((LinearViewHolder)holder).textView.setText("Hello World");

        }else {
            ((LinearViewHolder2)holder).textView.setText("WWWWWWW");
        }
        //3.点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(mContext,"click…"+position,Toast.LENGTH_SHORT).show();
                mlistener.onClick(position);
            }
        });

    }
    //获取列表长度
    @Override
    public int getItemCount() {
        return 30;
//        return  list.size();
    }

    //其中一个ViewHolder
    //<VH extends ViewHolder>泛型，所以在再写一个类
    class LinearViewHolder extends RecyclerView.ViewHolder{
        //在这里声明R.layout.layout_linear_item布局里面的控件
        private TextView textView;

        //构造方法
        public LinearViewHolder(View itemView) {
            super(itemView);
            //textView在itemView里面,控件在哪个布局里面，就要通过哪个布局文件去findViewById
            textView = itemView.findViewById(R.id.tv_title);
        }
    }
    //再写一个ViewHolder
    class LinearViewHolder2 extends RecyclerView.ViewHolder{
        //在这里声明R.layout.layout_linear_item布局里面的控件
        private TextView textView;
        private ImageView imageView;

        //构造方法
        public LinearViewHolder2(View itemView) {
            super(itemView);
            //textView在itemView里面,控件在哪个布局里面，就要通过哪个布局文件去findViewById
            textView = itemView.findViewById(R.id.tv_title);
            itemView = itemView.findViewById(R.id.iv_image);
        }
    }

    //1.写一个接口
    public interface  OnItemClickListener{
        void onClick(int pos);
    }
}


