package com.example.shaba.gulfexperts.placeholderClasses;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.placeholder.SwipeDecor;
import com.example.placeholder.SwipePlaceHolderView;
import com.example.shaba.gulfexperts.R;
import com.example.shaba.gulfexperts.placeholderClasses.swipe.SwipeCard;


public class ActivitySwipeTest extends AppCompatActivity {

    private SwipePlaceHolderView mSwipView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_test);
        mSwipView = (SwipePlaceHolderView) findViewById(R.id.swipeView);

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mSwipView.getBuilder()
                .setSwipeType(SwipePlaceHolderView.SWIPE_TYPE_HORIZONTAL)
                .setDisplayViewCount(3)
                .setSwipeDecor(
                        new SwipeDecor()
                                .setPaddingTop(20)
                                .setRelativeScale(0.01f)
                                .setSwipeInMsgLayoutId(R.layout.swipe_in_msg_view)
                                .setSwipeOutMsgLayoutId(R.layout.swipe_out_msg_view));

        mSwipView.addView(new SwipeCard(mSwipView))
                .addView(new SwipeCard(mSwipView))
                .addView(new SwipeCard(mSwipView))
                .addView(new SwipeCard(mSwipView))
                .addView(new SwipeCard(mSwipView))
                .addView(new SwipeCard(mSwipView))
                .addView(new SwipeCard(mSwipView))
                .addView(new SwipeCard(mSwipView))
                .addView(new SwipeCard(mSwipView))
                .addView(new SwipeCard(mSwipView));
    }
}
