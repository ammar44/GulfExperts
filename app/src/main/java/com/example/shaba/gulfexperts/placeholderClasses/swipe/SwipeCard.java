package com.example.shaba.gulfexperts.placeholderClasses.swipe;

import android.util.Log;

import com.example.placeholder.SwipePlaceHolderView;
import com.example.placeholder.annotations.Click;
import com.example.placeholder.annotations.Layout;
import com.example.placeholder.annotations.NonReusable;
import com.example.placeholder.annotations.Position;
import com.example.placeholder.annotations.swipe.SwipeCancelState;
import com.example.placeholder.annotations.swipe.SwipeIn;
import com.example.placeholder.annotations.swipe.SwipeInState;
import com.example.placeholder.annotations.swipe.SwipeOut;
import com.example.placeholder.annotations.swipe.SwipeOutState;
import com.example.shaba.gulfexperts.R;

/**
 * Created by janisharali on 19/08/16.
 */
@NonReusable
@Layout(R.layout.swipe_card_view)
public class SwipeCard {

//    @View(R.id.mainView)
//    private LinearLayout mainView;

    @Position
    private int mPosition;

    private SwipePlaceHolderView mSwipePlaceHolderView;

    public SwipeCard(SwipePlaceHolderView swipePlaceHolderView) {
        mSwipePlaceHolderView = swipePlaceHolderView;
    }

    @Click(R.id.rejectBtn)
    private void rejectBtnClick(){
        mSwipePlaceHolderView.doSwipe(this, false);
        Log.d("DEBUG", "rejectBtn");
    }

    @Click(R.id.acceptBtn)
    private void acceptBtnClick(){
        mSwipePlaceHolderView.doSwipe(this, true);
        Log.d("DEBUG", "acceptBtn");
    }

    @SwipeOut
    private void onSwipedOut(){
        Log.d("DEBUG", "onSwipedOut");
    }

    @SwipeCancelState
    private void onSwipeCancelState(){
        Log.d("DEBUG", "onSwipeCancelState");
    }

    @SwipeIn
    private void onSwipeIn(){
        Log.d("DEBUG", "onSwipedIn");
    }

    @SwipeInState
    private void onSwipeInState(){
        Log.d("DEBUG", "onSwipeInState");
    }

    @SwipeOutState
    private void onSwipeOutState(){
        Log.d("DEBUG", "onSwipeOutState");
    }
}
