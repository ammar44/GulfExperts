package com.example.shaba.gulfexperts.placeholderClasses.swipe;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.placeholder.annotations.Click;
import com.example.placeholder.annotations.Layout;
import com.example.placeholder.annotations.NonReusable;
import com.example.placeholder.annotations.Resolve;
import com.example.placeholder.annotations.View;
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
@Layout(R.layout.tinder_card_view)
public class TinderCard2 {

    private static int count;
    private CardCallback callback;

    @View(R.id.profileImageView)
    private ImageView profileImageView;

    @View(R.id.nameAgeTxt)
    private TextView nameAgeTxt;

    @View(R.id.locationNameTxt)
    private TextView locationNameTxt;

    @Click(R.id.profileImageView)
    private void onClick(){
        Log.d("DEBUG", "profileImageView");
    }

    public TinderCard2(CardCallback callback) {
        this.callback = callback;
    }

    @Resolve
    private void onResolve(){
        nameAgeTxt.setText("Name " + count++);
    }

    @SwipeOut
    private void onSwipedOut(){
        callback.onSwipingEnd();
    }

    @SwipeCancelState
    private void onSwipeCancelState(){
        callback.onSwipingEnd();
    }

    @SwipeIn
    private void onSwipeIn(){
        callback.onSwipingEnd();
    }

    @SwipeInState
    private void onSwipeInState(){
        callback.onSwiping();
    }

    @SwipeOutState
    private void onSwipeOutState(){
        callback.onSwiping();
    }

    public interface CardCallback{
        void onSwiping();
        void onSwipingEnd();
    }
}
