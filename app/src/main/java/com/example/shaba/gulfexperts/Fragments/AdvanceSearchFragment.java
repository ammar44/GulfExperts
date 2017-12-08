package com.example.shaba.gulfexperts.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.shaba.gulfexperts.Activities.AdvanceSearchActivity;
import com.example.shaba.gulfexperts.CustomOnItemSelectedListener;
import com.example.shaba.gulfexperts.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AdvanceSearchFragment.AdvanceSearchListener} interface
 * to handle interaction events.
 * Use the {@link AdvanceSearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AdvanceSearchFragment extends Fragment implements AdapterView.OnItemSelectedListener, View.OnClickListener {


    EditText name ;
    private Spinner majorSpinner, minorSpinner , countrySpinner, workSpinner ;
    private Button btnSubmit;
    ArrayAdapter<CharSequence> adapter ;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private AdvanceSearchListener mListener;

    public AdvanceSearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AdvanceSearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AdvanceSearchFragment newInstance(String param1, String param2) {
        AdvanceSearchFragment fragment = new AdvanceSearchFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_advance_search, container, false);

        EditText name = (EditText) view.findViewById(R.id.nameTxt);
        btnSubmit = (Button) view.findViewById(R.id.btnSubmit);

//        btnSubmit.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){buttonClicked(v) ; }
//                                     });


//        btnSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                AdvanceSearchActivity advanceSearchActivity = (AdvanceSearchActivity)getActivity();
//                advanceSearchActivity.loadResultFragment();
//            }
//        });


//        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
//        adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
//        // Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//// Apply the adapter to the spinner
//        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener(this);
        addItemsOnMinorSpinner(view);
        addListenerOnButton(view);
        addListenerOnSpinnerItemSelection(view);




        return view ;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(View uri) {
        if (mListener != null) {
            mListener.onClicked(uri);
        }
    }

    public void buttonClicked( View v ) {
        mListener.onClicked(v);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof AdvanceSearchListener) {
            mListener = (AdvanceSearchListener) context;
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {

        AdvanceSearchActivity activity = (AdvanceSearchActivity) getActivity();
        // Now you can contact your activity through activity e.g.:
        activity.onKeyDown(KeyEvent.KEYCODE_MENU, null);

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
    public interface AdvanceSearchListener {

       public   void onClicked(View v);
    }




    // add items into spinner dynamically
    public void addItemsOnMinorSpinner(View view) {

        minorSpinner = (Spinner) view.findViewById(R.id.minor_spinner);
        List<String> list = new ArrayList<String>();
        list.add("minor 1");
        list.add("minor 2");
        list.add("minor 3");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        minorSpinner.setAdapter(dataAdapter);
    }

    public void addListenerOnSpinnerItemSelection(View view) {
        majorSpinner = (Spinner) view.findViewById(R.id.major_spinner);
        majorSpinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        workSpinner = (Spinner) view.findViewById(R.id.work_spinner);
        countrySpinner = (Spinner) view.findViewById(R.id.country_spinner);

    }


    public void addListenerOnButton(View view) {

        majorSpinner = (Spinner) view.findViewById(R.id.major_spinner);
        minorSpinner = (Spinner) view.findViewById(R.id.minor_spinner);
        workSpinner = (Spinner) view.findViewById(R.id.work_spinner);
        countrySpinner = (Spinner) view.findViewById(R.id.country_spinner);
        btnSubmit = (Button) view.findViewById(R.id.btnSubmit);
        name = (EditText) view.findViewById(R.id.nameTxt);

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(),
                        "OnClickListener : " +
                                "\n majorSpinner : "+ String.valueOf(majorSpinner.getSelectedItem()) +
                                "\n minorSpinner : "+ String.valueOf(minorSpinner.getSelectedItem())+
                                "\n country : "+ String.valueOf(workSpinner.getSelectedItem()) +
                                "\n work : "+ String.valueOf(workSpinner.getSelectedItem())+
                                "\n name : "+ String.valueOf(name.getText()),
                        Toast.LENGTH_SHORT).show();
            }

        });
    }


}
