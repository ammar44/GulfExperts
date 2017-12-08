package com.example.shaba.gulfexperts.Fragments;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shaba.gulfexperts.Adapters.SearchAdapter;
import com.example.shaba.gulfexperts.DataService;
import com.example.shaba.gulfexperts.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AdvanceResultFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AdvanceResultFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AdvanceResultFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
SearchAdapter adapter ;
    private static final String ARG_STATION_TYPE = "station_type";

    private int stationType ;
    public static final int STATION_TYPE_FEATURED = 0;
    public static final int STATION_TYPE_RECENT = 1;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public AdvanceResultFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param stationType Parameter 1.
     *
     * @return A new instance of fragment AdvanceResultFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AdvanceResultFragment newInstance(int  stationType) {
        AdvanceResultFragment fragment = new AdvanceResultFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_STATION_TYPE, stationType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            stationType = getArguments().getInt(ARG_STATION_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_advance_result, container, false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycler_search);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setHasFixedSize(true);
        adapter  = new SearchAdapter(DataService.getInstance().getFeaturedStations()) ;
        recyclerView.setLayoutManager(layoutManager);
      //  adapter = new SearchAdapter(getActivity(), R.layout.list_item_expert, experts);
//        setupActionBarTheme();
//        loadBakeries();
        recyclerView.setAdapter(adapter);

        //layoutManager.setOrientation(LinearLayoutManager );


        // 5. Handle the click
//        listingsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                ListView listView = (ListView) view.getParent();
//                if (listView != null) {
//
//                    Expert expert = experts.get(position);
//                    if (expert != null) {
//
//                        Toast.makeText(getContext(), "Clicked on " + expert.getName(), Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//        });


    return view ;
    }

    // Loads bakery data into List<Bakery>
    private void loadBakeries() {}

    // Sets the app title to use a custom font
    private void setupActionBarTheme() {}

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
