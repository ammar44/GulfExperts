package com.example.shaba.gulfexperts.placeholderClasses.feed;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.placeholder.annotations.Layout;
import com.example.placeholder.annotations.Resolve;
import com.example.placeholder.annotations.View;
import com.example.placeholder.annotations.expand.ChildPosition;
import com.example.placeholder.annotations.expand.ParentPosition;
import com.example.shaba.gulfexperts.R;
import com.example.shaba.gulfexperts.placeholderClasses.feed.data.Info;

/**
 * Created by janisharali on 24/08/16.
 */
@Layout(R.layout.feed_item)
public class InfoView {

    @ParentPosition
    private int mParentPosition;

    @ChildPosition
    private int mChildPosition;

    @View(R.id.titleTxt)
    private TextView titleTxt;

    @View(R.id.captionTxt)
    private TextView captionTxt;

    @View(R.id.timeTxt)
    private TextView timeTxt;

    @View(R.id.imageView)
    private ImageView imageView;

    private Info mInfo;
    private Context mContext;

    public InfoView(Context context, Info info) {
        mContext = context;
        mInfo = info;
    }

    @Resolve
    private void onResolved() {
        titleTxt.setText(mInfo.getTitle());
        captionTxt.setText(mInfo.getCaption());
        timeTxt.setText(mInfo.getTime());
        Glide.with(mContext).load(mInfo.getImageUrl()).into(imageView);
    }
}
