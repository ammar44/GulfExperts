package com.example.shaba.gulfexperts.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.shaba.gulfexperts.Model;
import com.example.shaba.gulfexperts.R;
import com.example.shaba.gulfexperts.RecycleViewHolder;

import java.util.List;

/**
 * Created by shaba on 2017-10-22.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewHolder>{

    // Store a member variable for the contacts
    private List<Model> mContacts;
    // Store the context for easy access
    private Context mContext;

    // Pass in the contact array into the constructor
    public RecycleViewAdapter(Context context, List<Model> contacts) {
        mContacts = contacts;
        mContext = context;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }

    @Override
    public RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_model, parent, false);

        // Return a new holder instance
        RecycleViewHolder viewHolder = new RecycleViewHolder(contactView);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(RecycleViewHolder holder, int position) {

        // Get the data model based on position
        Model model = mContacts.get(position);

        // Set item views based on your views and data model
        TextView textView = holder.nameTextView;
        textView.setText(model.getName());
        Button button = holder.messageButton;


    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }
}
