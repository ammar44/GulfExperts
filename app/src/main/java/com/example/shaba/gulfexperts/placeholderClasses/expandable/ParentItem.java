package com.example.shaba.gulfexperts.placeholderClasses.expandable;

import android.content.Context;
import android.graphics.Color;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by janisharali on 19/08/16.
 */
@Parent
@SingleTop
@Layout(R.layout.drawer_item)
public class ParentItem {

    private List<String> titleList;

    @ParentPosition
    private int mParentPosition;

    @View(R.id.itemNameTxt)
    private TextView itemNameTxt;

    @Toggle(R.id.itemIcon)
    @View(R.id.itemIcon)
    private ImageView itemIcon;

    @View(R.id.mainView)
    private LinearLayout mainView;

    private Context mContext;

    public ParentItem(Context context) {
        mContext = context;
        titleList = new ArrayList<>();
        titleList.add("Apple");
        titleList.add("Mango");
        titleList.add("Orange");
        titleList.add("Banana");
        titleList.add("Papaya");
        titleList.add("Papaya");
        titleList.add("Papaya");
        titleList.add("Papaya");
        titleList.add("Papaya");
        titleList.add("Papaya");
        titleList.add("Papaya");
        titleList.add("Papaya");
        titleList.add("Papaya");
    }

    @Resolve
    private void onResolved() {
        itemIcon.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_keyboard_arrow_up_white_24dp));
        mainView.setBackgroundColor(Color.RED);
        itemNameTxt.setText(titleList.get(mParentPosition));
    }

    @Expand
    private void onExpand(){
        itemIcon.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_keyboard_arrow_down_white_24dp));
    }

    @Collapse
    private void onCollapse(){
        itemIcon.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_keyboard_arrow_up_white_24dp));
    }
}
