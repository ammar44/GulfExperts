package com.example.shaba.gulfexperts.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shaba.gulfexperts.Exper;
import com.example.shaba.gulfexperts.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by shaba on 2017-10-31.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> {
    private int lastPosition = -1;
    List<Exper> expertList ;
   // DataProvider dataProvider = new DataProvider( expertList) ;
   // List<Expert>   experts = dataProvider.getExpertList() ;
    private Context context;
    private int itemResource;

    // from HW4
    private ArrayList<Exper> experts ;
    public SearchAdapter(ArrayList<Exper> experts){

        this.experts = experts ;
    }





    public SearchAdapter(Context context, int itemResource,List<Exper> experts){

        this.context = context;
        this.itemResource = itemResource;
        expertList = experts ;
    }


    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

//      View view = LayoutInflater.from(parent.getContext()).inflate(this.itemResource, parent, false);
//       return new SearchViewHolder(this.context, view);



        View movieCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_expert, parent, false);
        return new SearchViewHolder(movieCard);
    }
//
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        // 2. Have we inflated this view before?
//        View itemView;
//        if (convertView != null) {
//
//            // 2a. We have so let's reuse.
//            itemView = convertView;
//        }
//        else {
//
//            // 2b. We have NOT so let's inflate
//            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            itemView = inflater.inflate(this.itemResource, parent, false);
//        }
//
//        // 3. Get the bakery to appear in this item
//        Expert expert = this.experts.get(position);
//        if (expert != null) {
//
//            // 4. Inflate the UI widgets
//
//            TextView expertName = (TextView) itemView.findViewById(R.id.expert_name);
//            TextView expertMajor = (TextView) itemView.findViewById(R.id.expert_major);
//            TextView expertMinor = (TextView) itemView.findViewById(R.id.expert_minor);
//            TextView expertWork = (TextView) itemView.findViewById(R.id.expert_work);
//            TextView expertCountry = (TextView) itemView.findViewById(R.id.expert_country);
//            TextView expertQualification = (TextView) itemView.findViewById(R.id.expert_qualification);
//            // 5. Set the UI widgets with appropriate data from the Bakery model
//            expertName.setText(expert.getName());
//            expertMajor.setText(expert.getMajor());
//            expertMinor.setText(expert.getMinor());
//            expertWork.setText(expert.getWork());
//            expertCountry.setText(expert.getCountry());
//            expertQualification.setText(expert.getQualification());
//        }
//
//        return itemView;
//    }
//

    @Override
    public void onBindViewHolder(SearchViewHolder holder, final int position) {
        final int pos = position;
        final Exper expert = experts.get(position);
        holder.updateUI(expert) ; // bindBakery

//        setAnimation(holder.mainImage , position);

//        holder.itemView.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//                RecycleViewActivity.getRecycleViewActivity().loadDetailsScreen(movie);
//            }
//        });





//        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//
//                deleteItemFromList(v, pos);
//
//
//            }
//        });



    }




    private void deleteItemFromList(View v, final int position) {

        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());

        //builder.setTitle("Dlete ");
        builder.setMessage("Delete Item ?")
                .setCancelable(false)
                .setPositiveButton("CONFIRM",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                expertList.remove(position);
                                notifyDataSetChanged();


                            }
                        })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {


                    }
                });

        builder.show();

    }


//    public Fragment getItem(int position) {
//        return MovieFragment.newInstance(movies.get(position)) ;
//
//    }


//    @Override
//    public int getItemCount() {
//        return dataProvider.getCount(expertList);
//    }

    @Override
    public int getItemCount() {
        return experts.size();
    }



    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void delete(int position) { //removes the row
        expertList.remove(position);
        notifyItemRemoved(position);
    }

//    private void setAnimation(View view , int position) { if (position > lastPosition) {
//        Animation animation = AnimationUtils.loadAnimation(view.getContext (), android.R.anim.slide_in_left);
//        view.startAnimation(animation);
//        lastPosition = position; }}


}
