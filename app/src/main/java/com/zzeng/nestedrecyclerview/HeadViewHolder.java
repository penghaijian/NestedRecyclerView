package com.zzeng.nestedrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者: zengxc
 * 描述:
 * 时间: 2018/09/30 12:02
 */

public class HeadViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.head_title_tv)
    TextView mHeadTileTv;

    public HeadViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setHeadData(Head head) {
        mHeadTileTv.setText(head.getHeadName());
    }

}
