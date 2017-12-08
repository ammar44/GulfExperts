package com.example.shaba.gulfexperts.placeholderClasses.feed;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.placeholder.annotations.Layout;
import com.example.placeholder.annotations.Resolve;
import com.example.placeholder.annotations.View;
import com.example.placeholder.annotations.expand.Collapse;
import com.example.placeholder.annotations.expand.Expand;
import com.example.placeholder.annotations.expand.Parent;
import com.example.placeholder.annotations.expand.ParentPosition;
import com.example.placeholder.annotations.expand.SingleTop;
import com.example.placeholder.annotations.expand.Toggle;
import com.example.shaba.gulfexperts.R;

/**
 * Created by janisharali on 24/08/16.
 */

@Parent
@SingleTop
@Layout(R.layout.feed_heading)
public class HeadingView {

    @View(R.id.headingTxt)
    private TextView headingTxt;

    @View(R.id.toggleIcon)
    private ImageView toggleIcon;

    @Toggle(R.id.toggleView)
    private LinearLayout toggleView;

    @ParentPosition
    private int mParentPosition;

    private Context mContext;
    private String mHeading;

    public HeadingView(Context context, String heading) {
        mContext = context;
        mHeading = heading;
    }

    @Resolve
    private void onResolved() {
        toggleIcon.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_keyboard_arrow_up_white_24dp));
        headingTxt.setText(mHeading);
    }

    @Expand
    private void onExpand(){
        toggleIcon.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_keyboard_arrow_down_white_24dp));
    }

    @Collapse
    private void onCollapse(){
        toggleIcon.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_keyboard_arrow_up_white_24dp));
    }

}
