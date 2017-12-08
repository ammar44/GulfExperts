package com.example.shaba.gulfexperts.placeholderClasses.drawer;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.placeholder.annotations.Layout;
import com.example.placeholder.annotations.NonReusable;
import com.example.placeholder.annotations.Resolve;
import com.example.placeholder.annotations.View;
import com.example.shaba.gulfexperts.R;


/**
 * Created by janisharali on 19/08/16.
 */
@NonReusable
@Layout(R.layout.drawer_header)
public class DrawerHeader {

    @View(R.id.profileImageView)
    private ImageView profileImage;

    @View(R.id.nameTxt)
    private TextView nameTxt;

    @View(R.id.emailTxt)
    private TextView emailTxt;

    @Resolve
    private void onResolved() {
        nameTxt.setText("Janishar Ali");
        emailTxt.setText("janishar.ali@gmail.com");
    }

}
