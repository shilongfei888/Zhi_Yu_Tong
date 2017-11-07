package com.jstech.zhiyutong.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.jstech.zhiyutong.R;

import java.util.List;

/**
 * Created by Administrator on 2017/8/15.
 */

public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<String>datas;

    //添加头部
    public static final int TYPE_HEADER = 0;

    //正常数据类型
    public static final int TYPE_NORMAL = 1;

    //添加底部
    private static final int TYPE_FOOTER = 2;



    //上拉加载更多
    public static final int  PULLUP_LOAD_MORE=0;
    //正在加载中
    public static final int  LOADING_MORE=1;
    //上拉加载更多状态-默认为0
    private int load_more_status=0;


    private View mHeaderView;

    public CategoryAdapter(List<String> datas) {
        this.datas = datas;
    }

    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }

    public View getHeaderView() {
        return mHeaderView;
    }

    @Override
    public int getItemViewType(int position) {

        if(mHeaderView == null) return TYPE_NORMAL;
        if (position == 0) return TYPE_HEADER;
        if (mHeaderView != null && position + 1 == getItemCount()) return TYPE_FOOTER;
        if (mHeaderView == null && position == getItemCount()) return TYPE_FOOTER;
        return TYPE_NORMAL;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mHeaderView != null && viewType == TYPE_HEADER)
            return new HeaderViewHolder(mHeaderView);

        if (viewType == TYPE_FOOTER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.footer_layout, parent, false);
            return new FooterViewHolder(view);
        }

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);

    }

    /**
     * 1.重写onBindViewHolder(VH holder, int position, List<Object> payloads)这个方法
     * <p>
     * 2.执行两个参数的notifyItemChanged，第二个参数随便什么都行，只要不让它为空就OK~，
     * 这样就可以实现只刷新item中某个控件了！！！
     * payload 的解释为：如果为null，则刷新item全部内容
     * 那言外之意就是不为空就可以局部刷新了~！
     *
     * @param holder  服用的holder
     * @param position  当前位置
     * @param payloads  如果为null，则刷新item全部内容  否则局部刷新
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
        if (getItemViewType(position) == TYPE_HEADER) return;
        final int pos = getRealPosition(holder);
        if (holder instanceof ViewHolder) {
            ViewHolder holder1 = (ViewHolder) holder;
            if (pos == datas.size()) {
                return;
            }
            holder1.tv.setText(datas.get(pos));

            ((ViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.OnItemClick(view, pos, datas.get(pos));
                    }
                }
            });


        }else if (holder instanceof FooterViewHolder){

//            FooterViewHolder footerViewHolder= (FooterViewHolder) holder;
//            switch (load_more_status){
//                case PULLUP_LOAD_MORE:
//                    footerViewHolder.tv.setText("上拉加载更多...");
//                    break;
//                case LOADING_MORE:
//                    footerViewHolder.tv.setText("正在加载更多数据...");
//                    break;

//
//            }
        }

    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    public int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return mHeaderView == null ? position : position - 1;
    }

    @Override
    public int getItemCount() {

         return mHeaderView == null ? datas.size() + 1 : datas.size() + 2;

    }



    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tv;
        public ViewHolder(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);
        }
    }

    //添加头部
    class HeaderViewHolder extends RecyclerView.ViewHolder{

        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }

    //添加底部
    class FooterViewHolder extends RecyclerView.ViewHolder {

        public FooterViewHolder(View itemView) {
            super(itemView);
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

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {

        void OnItemClick(View view, int position, String s);

    }

}
