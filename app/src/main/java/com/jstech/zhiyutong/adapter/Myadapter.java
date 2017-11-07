package com.jstech.zhiyutong.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.jstech.zhiyutong.R;

import java.util.List;

/**
 * Created by Administrator on 2017/8/2.
 */

public class Myadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    //上拉加载更多
    public static final int  PULLUP_LOAD_MORE=0;
    //正在加载中
    public static final int  LOADING_MORE=1;
    //上拉加载更多状态-默认为0
    private int load_more_status=0;

    private List<String>datas;

    private static int TYPE_FOOTER=1;
    private static int TYPE_ITEM=0;

    public Myadapter(List<String>datas){
        this.datas=datas;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //进行判断显示类型，来创建返回不同的View
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        if(viewType==TYPE_ITEM){
            View view=mInflater.inflate(R.layout.item_layout,parent,false);
            //这边可以做一些属性设置，甚至事件监听绑定
            //view.setBackgroundColor(Color.RED);
            ItemViewHolder itemViewHolder=new ItemViewHolder(view);
            return itemViewHolder;

        }else if(viewType==TYPE_FOOTER){
            View viewfoot=mInflater.inflate(R.layout.footer_layout,parent,false);
            //这边可以做一些属性设置，甚至事件监听绑定
            //view.setBackgroundColor(Color.RED);
            FootViewHolder footViewHolder=new FootViewHolder(viewfoot);
            return footViewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof ItemViewHolder) {
            ((ItemViewHolder)holder).tv.setText(datas.get(position));
            holder.itemView.setTag(position);
        }else if(holder instanceof FootViewHolder){
//
//            FootViewHolder footViewHolder=(FootViewHolder)holder;
//            switch (load_more_status){
//                case PULLUP_LOAD_MORE:
//                    footViewHolder.tv.setText("上拉加载更多...");
//                    break;
//                case LOADING_MORE:
//                    footViewHolder.tv.setText("正在加载更多数据...");
//                    break;
//            }
        }

    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{

        public TextView tv;
        public ItemViewHolder(View view) {
            super(view);
            // TODO Auto-generated constructor stub
            tv = (TextView) view.findViewById(R.id.tv);
        }
    }

    public class FootViewHolder extends RecyclerView.ViewHolder{

        public FootViewHolder(View view) {
            super(view);

        }
    }


    @Override
    public int getItemCount() {
        return datas.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }

    //添加数据
    public void addItem(List<String> newDatas) {
        //mTitles.add(position, data);
        //notifyItemInserted(position);
        newDatas.addAll(datas);
        datas.removeAll(datas);
        datas.addAll(newDatas);
        notifyDataSetChanged();
    }

    public void addMoreItem(List<String> newDatas) {
        datas.addAll(newDatas);
        notifyDataSetChanged();
    }

    /**
     * //上拉加载更多
     * PULLUP_LOAD_MORE=0;
     * //正在加载中
     * LOADING_MORE=1;
     * //加载完成已经没有更多数据了
     * NO_MORE_DATA=2;
     * @param status
     */
    public void changeMoreStatus(int status){
        load_more_status=status;
        notifyDataSetChanged();
    }

}
