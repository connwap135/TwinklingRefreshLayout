package com.lcodecore.twinklingrefreshlayout.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lcodecore.twinklingrefreshlayout.R;
import com.lcodecore.twinklingrefreshlayout.adapter.base.BaseRecyclerAdapter;
import com.lcodecore.twinklingrefreshlayout.adapter.base.CommonHolder;
import com.lcodecore.twinklingrefreshlayout.beans.Food;
import com.lcodecore.twinklingrefreshlayout.utils.ToastUtil;
import com.lcodecore.twinklingrefreshlayout.views.CircleImageView;

// ...existing code... (removed ButterKnife)

/**
 * Created by lcodecore on 2016/12/6.
 */

public class FoodAdapter extends BaseRecyclerAdapter<Food> {
    @Override
    public CommonHolder<Food> setViewHolder(ViewGroup parent) {
        return new CardHolder(parent.getContext(), parent);
    }

    class CardHolder extends CommonHolder<Food> {

        CircleImageView avatar;
        TextView tv_food;
        TextView tv_info;
        ImageView iv_food;

        public CardHolder(Context context, ViewGroup root) {
            super(context, root, R.layout.item_food);
            // manual view binding instead of ButterKnife
            avatar = itemView.findViewById(R.id.avatar);
            tv_food = itemView.findViewById(R.id.tv_food);
            tv_info = itemView.findViewById(R.id.tv_info);
            iv_food = itemView.findViewById(R.id.iv_food);
        }

        @Override
        public void bindData(Food food) {
            avatar.setImageResource(food.avatar_id);
            iv_food.setImageResource(food.imageSrc);
            tv_food.setText(food.title);
            tv_info.setText(food.info);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ToastUtil.show("item clicked!");
                }
            });
        }
    }
}
