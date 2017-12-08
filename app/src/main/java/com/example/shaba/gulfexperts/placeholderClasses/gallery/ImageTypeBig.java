package com.example.shaba.gulfexperts.placeholderClasses.gallery;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.placeholder.Animation;
import com.example.placeholder.PlaceHolderView;
import com.example.placeholder.annotations.Animate;
import com.example.placeholder.annotations.Layout;
import com.example.placeholder.annotations.LongClick;
import com.example.placeholder.annotations.NonReusable;
import com.example.placeholder.annotations.Position;
import com.example.placeholder.annotations.Resolve;
import com.example.placeholder.annotations.View;
import com.example.shaba.gulfexperts.R;


/**
 * Created by janisharali on 19/08/16.
 */
@Animate(Animation.ENTER_LEFT_DESC)
@NonReusable
@Layout(R.layout.gallery_item_big)
public class ImageTypeBig {

    @View(R.id.imageView)
    private ImageView imageView;

    @Position
    private int position;

    private String mUlr;
    private Context mContext;
    private PlaceHolderView mPlaceHolderView;

    public ImageTypeBig(Context context, PlaceHolderView placeHolderView, String ulr) {
        mContext = context;
        mPlaceHolderView = placeHolderView;
        mUlr = ulr;
    }

    @Resolve
    private void onResolved() {
        Glide.with(mContext).load(mUlr).into(imageView);
        Log.d("DEBUG", "position " + position);
    }

    @LongClick(R.id.imageView)
    private void onLongClick(){
        mPlaceHolderView.removeView(this);
    }

}
