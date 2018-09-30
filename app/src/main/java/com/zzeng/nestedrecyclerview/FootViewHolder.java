package com.zzeng.nestedrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者: zengxc
 * 描述:
 * 时间: 2018/09/30 12:02
 */

public class FootViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.view)
    View mView;

    public FootViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

}
