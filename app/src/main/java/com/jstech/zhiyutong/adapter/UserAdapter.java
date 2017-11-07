package com.jstech.zhiyutong.adapter;

import android.content.Context;
import android.widget.TextView;

import com.jstech.zhiyutong.R;
import com.jstech.zhiyutong.base.BaseRecyclerAdapter;
import com.jstech.zhiyutong.bean.UserData;

import java.util.List;

/**
 * Created by Administrator on 2017/8/28.
 */

public class UserAdapter extends BaseRecyclerAdapter<UserData> {

    public UserAdapter(List<UserData> mDatas, Context mContext, int layoutId) {
        super(mDatas, mContext, layoutId);
    }

    @Override
    protected void bindItemData(ViewHolder viewHolder, UserData data, int position) {
        TextView user=viewHolder.getView(R.id.user);
        TextView name=viewHolder.getView(R.id.name);
        user.setText(data.getUsrName());
        name.setText(data.getUsrPassword());
    }
}
