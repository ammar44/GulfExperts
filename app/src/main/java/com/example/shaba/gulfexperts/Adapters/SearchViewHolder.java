package com.example.shaba.gulfexperts.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.shaba.gulfexperts.Exper;
import com.example.shaba.gulfexperts.R;

/**
 * Created by shaba on 2017-10-31.
 */

public class SearchViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

//    private final int numPages = movies.size();

    private TextView mName ;
   private TextView mMajor ;
  private   TextView mId ;
  private   TextView mMinor ;
  private   TextView mWork ;
   private TextView mCountry ;
    private TextView mQualification ;
    private Exper expert;
    private Context context;



    public SearchViewHolder( View itemView) {
        super(itemView);
      //  this.context = context ;
        this.mId = (TextView) itemView.findViewById(R.id.expert_id);
        this.mName = (TextView) itemView.findViewById(R.id.expert_name) ;
        this.mMajor = (TextView) itemView.findViewById(R.id.expert_major);
         this.mMinor = (TextView) itemView.findViewById(R.id.expert_minor);
        this.mWork = (TextView) itemView.findViewById(R.id.expert_work);
        this.mQualification = (TextView) itemView.findViewById(R.id.expert_qualification);
        this.mCountry = (TextView) itemView.findViewById(R.id.expert_country);


       // itemView.setOnClickListener(this);

    }

    public void updateUI(Exper expert) { // void bindBakery

//        String uri =  expert.getIdImage() ;
//        int imageResource = mainImage.getResources().getIdentifier(uri, "drawable" , mainImage.getContext().getPackageName());
//        mainImage.setImageResource(imageResource);
        mName.setText(expert.getName());
        mMajor.setText(expert.getMajor());
        mMinor.setText(expert.getMinor());
        mId.setText("ID: " + expert.getId());
        mWork.setText(expert.getWork());
        mCountry.setText(expert.getCountry());
        mQualification.setText(expert.getQualification());


//        this.expert = expert;

    }

    @Override
    public void onClick(View v) {
        // 5. Handle the onClick event for the ViewHolder
//        if (this.expert != null) {
//
//            Toast.makeText(this.context, "Clicked on " + this.expert.getName(), Toast.LENGTH_SHORT ).show();
//        }

    }




}
