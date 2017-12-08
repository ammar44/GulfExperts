package com.example.shaba.gulfexperts.placeholderClasses.swipe;

import android.graphics.Color;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.placeholder.annotations.Click;
import com.example.placeholder.annotations.Layout;
import com.example.placeholder.annotations.NonReusable;
import com.example.placeholder.annotations.Resolve;
import com.example.placeholder.annotations.View;
import com.example.placeholder.annotations.swipe.SwipeCancelState;
import com.example.placeholder.annotations.swipe.SwipeHead;
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
public class TinderCard {

    private static int count;

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

    @Resolve
    private void onResolve(){
        nameAgeTxt.setText("Name " + count++);
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

    @SwipeHead
    private void onSwipeHead() {
        profileImageView.setBackgroundColor(Color.BLUE);
        Log.d("DEBUG", "onSwipeHead");
    }
}
