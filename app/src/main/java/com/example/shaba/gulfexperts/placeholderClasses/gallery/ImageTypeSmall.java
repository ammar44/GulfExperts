package com.example.shaba.gulfexperts.placeholderClasses.gallery;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.placeholder.Animation;
import com.example.placeholder.PlaceHolderView;
import com.example.placeholder.annotations.Animate;
import com.example.placeholder.annotations.Layout;
import com.example.placeholder.annotations.LongClick;
import com.example.placeholder.annotations.NonReusable;
import com.example.placeholder.annotations.Resolve;
import com.example.placeholder.annotations.View;
import com.example.shaba.gulfexperts.R;


/**
 * Created by janisharali on 19/08/16.
 */
@Animate(Animation.CARD_TOP_IN_DESC)
@NonReusable
@Layout(R.layout.gallery_item_small)
public class ImageTypeSmall {

    @View(R.id.imageView)
    private ImageView imageView;

    private String mUlr;
    private Context mContext;
    private PlaceHolderView mPlaceHolderView;

    public ImageTypeSmall(Context context, PlaceHolderView placeHolderView, String ulr) {
        mContext = context;
        mPlaceHolderView = placeHolderView;
        mUlr = ulr;
    }

    @Resolve
    private void onResolved() {
        Glide.with(mContext).load(mUlr).into(imageView);
    }

    @LongClick(R.id.imageView)
    private void onLongClick(){
        mPlaceHolderView.removeView(this);
    }

}
