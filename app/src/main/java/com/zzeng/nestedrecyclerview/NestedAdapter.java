package com.zzeng.nestedrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 作者: zengxc
 * 描述:
 * 时间: 2018/09/30 11:38
 */

public class NestedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<Object> mDataList;
    private LayoutInflater mInflater;
    private NestedAdapter.OnItemClickListener mOnItemClickListener;

    private static final int TYPE_HEAD = 1;
    private static final int TYPE_CONTENT = 2;
    private static final int TYPE_FOOT = 3;

    public NestedAdapter(Context context, List<Object> dataList) {
        mContext = context;
        mDataList = dataList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEAD) {
            return new HeadViewHolder(mInflater.inflate(R.layout.item_head, parent, false));
        } else if (viewType == TYPE_CONTENT) {
            return new ContentViewHolder(mInflater.inflate(R.layout.item_content, parent, false));
        } else if (viewType == TYPE_FOOT) {
            return new FootViewHolder(mInflater.inflate(R.layout.item_foot, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeadViewHolder) {
            ((HeadViewHolder) holder).setHeadData((Head) mDataList.get(position));
        } else if (holder instanceof ContentViewHolder) {
            ((ContentViewHolder) holder).setContentData(mContext, (Content) mDataList.get(position));

            if (mOnItemClickListener != null) {
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mOnItemClickListener.onItemClick(v, holder.getAdapterPosition());
                    }
                });

            }
        } else if (holder instanceof FootViewHolder) {
            ((FootViewHolder) holder).mView.setVisibility(position == mDataList.size() - 1 ? View.VISIBLE : View.GONE);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mDataList.get(position) instanceof Head) {
            return TYPE_HEAD;
        } else if (mDataList.get(position) instanceof Content) {
            return TYPE_CONTENT;
        } else if (mDataList.get(position) instanceof Foot) {
            return TYPE_FOOT;
        }
        return TYPE_HEAD;
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }
}
