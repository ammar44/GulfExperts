package com.example.shaba.gulfexperts.placeholderClasses.gallery;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import com.example.placeholder.Animation;
import com.example.placeholder.PlaceHolderView;
import com.example.placeholder.annotations.Animate;
import com.example.placeholder.annotations.Layout;
import com.example.placeholder.annotations.NonReusable;
import com.example.placeholder.annotations.Resolve;
import com.example.placeholder.annotations.View;
import com.example.shaba.gulfexperts.R;
import com.example.shaba.gulfexperts.placeholderClasses.Image;

import java.util.List;

/**
 * Created by janisharali on 19/08/16.
 */
@Animate(Animation.CARD_TOP_IN_DESC)
@NonReusable
@Layout(R.layout.gallery_item_small_placeholder)
public class ImageTypeSmallPlaceHolder {

    @View(R.id.placeholderview)
    private PlaceHolderView mPlaceHolderView;

    private Context mContext;
    private List<Image> mImageList;

    public ImageTypeSmallPlaceHolder(Context context, List<Image> imageList) {
        mContext = context;
        mImageList = imageList;
    }

    @Resolve
    private void onResolved() {
        mPlaceHolderView.getBuilder()
                .setHasFixedSize(false)
                .setItemViewCacheSize(10)
                .setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));

        for(Image image : mImageList) {
            mPlaceHolderView.addView(new ImageTypeSmall(mContext, mPlaceHolderView, image.getUrl()));
        }
    }
}
