package com.zzeng.nestedrecyclerview;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者: zengxc
 * 描述:
 * 时间: 2018/09/30 12:02
 */

public class ContentViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.content_tv)
    TextView mContentTv;
    @BindView(R.id.content_logo_iv)
    ImageView mContentLogoIv;

    public ContentViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setContentData(Context context, Content content) {
        mContentTv.setText(content.getName());
        mContentLogoIv.setImageDrawable(ContextCompat.getDrawable(context, content.getDrawableId()));
    }

}
