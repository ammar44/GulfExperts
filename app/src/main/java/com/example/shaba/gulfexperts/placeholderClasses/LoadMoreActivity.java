package com.example.shaba.gulfexperts.placeholderClasses;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.placeholder.InfinitePlaceHolderView;
import com.example.shaba.gulfexperts.R;
import com.example.shaba.gulfexperts.placeholderClasses.gallery.ImageTypeBig;
import com.example.shaba.gulfexperts.placeholderClasses.infinite.LoadMoreView;
import com.mindorks.butterknifelite.ButterKnifeLite;
import com.mindorks.butterknifelite.annotations.BindView;

import java.util.List;


public class LoadMoreActivity extends AppCompatActivity {

    @BindView(R.id.loadMoreView)
    private InfinitePlaceHolderView mLoadMoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_more_test);
        ButterKnifeLite.bind(this);
        setupView();
    }

    private void setupView(){

        List<Image> imageList = Utils.loadImages(this.getApplicationContext());
        for (int i = 0; i <  LoadMoreView.LOAD_VIEW_SET_COUNT && imageList.size() > i; i++) {
            mLoadMoreView.addView(new ImageTypeBig(this.getApplicationContext(), mLoadMoreView, imageList.get(i).getUrl()));
        }
//        mLoadMoreView.setLoadMoreResolver(new LoadMoreView(mLoadMoreView, imageList));
    }
}
