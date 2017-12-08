package com.example.shaba.gulfexperts.placeholderClasses.expandable;

import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.placeholder.ExpandablePlaceHolderView;
import com.example.placeholder.annotations.Click;
import com.example.placeholder.annotations.Layout;
import com.example.placeholder.annotations.Resolve;
import com.example.placeholder.annotations.View;
import com.example.placeholder.annotations.expand.ChildPosition;
import com.example.placeholder.annotations.expand.ParentPosition;
import com.example.shaba.gulfexperts.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by janisharali on 19/08/16.
 */

@Layout(R.layout.drawer_item)
public class ChildItem {

    private List<List<String>> childTitleList;

    @ParentPosition
    private int mParentPosition;

    @ChildPosition
    private int mChildPosition;

    @View(R.id.itemNameTxt)
    private TextView itemNameTxt;

    @View(R.id.itemIcon)
    private ImageView itemIcon;

    @View(R.id.mainView)
    private LinearLayout mainView;

    private ExpandablePlaceHolderView mExpandablePlaceHolderView;

    public ChildItem(ExpandablePlaceHolderView expandablePlaceHolderView) {

        mExpandablePlaceHolderView = expandablePlaceHolderView;

        childTitleList = new ArrayList<>();
        List<String>titleList1 = new ArrayList<>();
        titleList1.add("a");
        titleList1.add("b");
        titleList1.add("c");
        titleList1.add("d");
        titleList1.add("e");
        titleList1.add("e");
        titleList1.add("e");
        titleList1.add("e");
        titleList1.add("e");
        titleList1.add("e");
        childTitleList.add(titleList1);

        List<String>titleList2 = new ArrayList<>();
        titleList2.add("aa");
        titleList2.add("bb");
        titleList2.add("cc");
        titleList2.add("dd");
        titleList2.add("ee");
        titleList2.add("ee");
        titleList2.add("ee");
        titleList2.add("ee");
        titleList2.add("ee");
        titleList2.add("ee");
        titleList2.add("ee");
        childTitleList.add(titleList2);

        List<String>titleList3 = new ArrayList<>();
        titleList3.add("aaa");
        titleList3.add("bbb");
        titleList3.add("ccc");
        titleList3.add("ddd");
        titleList3.add("eee");
        titleList3.add("eee");
        titleList3.add("eee");
        titleList3.add("eee");
        titleList3.add("eee");
        titleList3.add("eee");
        childTitleList.add(titleList3);

        List<String>titleList4 = new ArrayList<>();
        titleList4.add("aaaa");
        titleList4.add("bbbb");
        titleList4.add("cccc");
        titleList4.add("dddd");
        titleList4.add("eeee");
        titleList4.add("eeee");
        titleList4.add("eeee");
        titleList4.add("eeee");
        titleList4.add("eeee");
        titleList4.add("eeee");
        titleList4.add("eeee");
        childTitleList.add(titleList4);

        childTitleList.add(titleList4);
        childTitleList.add(titleList4);
        childTitleList.add(titleList4);
        childTitleList.add(titleList4);
        childTitleList.add(titleList4);
        childTitleList.add(titleList4);
        childTitleList.add(titleList4);
        childTitleList.add(titleList4);
        childTitleList.add(titleList4);
    }

    @Resolve
    private void onResolved() {
        mainView.setBackgroundColor(Color.GRAY);
        itemNameTxt.setText(childTitleList.get(mParentPosition).get(mChildPosition));
        itemIcon.setImageDrawable(mExpandablePlaceHolderView.getResources().getDrawable(R.drawable.ic_book_black_18dp));
    }

    @Click(R.id.mainView)
    private void onItemClick(){
//        mExpandablePlaceHolderView.addChildView(mParentPosition, new ChildItem(mExpandablePlaceHolderView));
        mExpandablePlaceHolderView.removeView(this);
    }
}
