package com.lcodecore.twinklingrefreshlayout.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lcodecore.twinklingrefreshlayout.R;
import com.lcodecore.twinklingrefreshlayout.adapter.base.BaseRecyclerAdapter;
import com.lcodecore.twinklingrefreshlayout.adapter.base.CommonHolder;
import com.lcodecore.twinklingrefreshlayout.beans.Photo;
import com.lcodecore.twinklingrefreshlayout.utils.ToastUtil;

// ...existing code... (removed ButterKnife)

/**
 * Created by lcodecore on 2016/12/7.
 */

public class PhotoAdapter extends BaseRecyclerAdapter<Photo> {
    @Override
    public CommonHolder<Photo> setViewHolder(ViewGroup parent) {
        return new CardHolder(parent.getContext(), parent);
    }

    class CardHolder extends CommonHolder<Photo> {

        TextView tv_info;
        ImageView iv_pic;

        public CardHolder(Context context, ViewGroup root) {
            super(context, root, R.layout.item_photo);
            // manual view binding
            tv_info = itemView.findViewById(R.id.tv_info);
            iv_pic = itemView.findViewById(R.id.iv_pic);
        }

        @Override
        public void bindData(Photo photo) {
            iv_pic.setImageResource(photo.imgSrc);
            tv_info.setText(photo.name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ToastUtil.show("item clicked!");
                }
            });
        }
    }
}