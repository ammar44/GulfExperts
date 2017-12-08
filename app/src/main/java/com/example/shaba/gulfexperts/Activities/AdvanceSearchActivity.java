package com.example.shaba.gulfexperts.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.shaba.gulfexperts.R;
import com.example.shaba.gulfexperts.data.model.Major;

public class AdvanceSearchActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner majorSpinner , countrySpinner, workSpinner ;
    private AppCompatButton button ;

    Major major ;
    private final AppCompatActivity activity = AdvanceSearchActivity.this;
    private static final String TAG = AddCV.class.getSimpleName().toString();
    public static final String Qualification_MESSAGE = "Qualification_MESSAGE";
    public static final String Country_MESSAGE = "Country_MESSAGE";
    public static final String Major_MESSAGE = "Major_MESSAGE";

    ArrayAdapter<CharSequence> adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_search);
        Intent intent = getIntent();


        addListenerOnButton();
        addListenerOnSpinnerItemSelection();
        button.setOnClickListener(this);

    }

    public void sendMessage() {
        Intent intent = new Intent(this, AdvanceSearchResult.class);

        majorSpinner = (Spinner) findViewById(R.id.major_spinner);
        workSpinner = (Spinner) findViewById(R.id.work_spinner);
        countrySpinner = (Spinner) findViewById(R.id.country_spinner);



        intent.putExtra(Qualification_MESSAGE, String.valueOf(workSpinner));
        intent.putExtra(Country_MESSAGE, String.valueOf(countrySpinner));
        intent.putExtra(Major_MESSAGE,String.valueOf(majorSpinner) );

        startActivity(intent);
    }



    public void addListenerOnSpinnerItemSelection() {
        majorSpinner = (Spinner) findViewById(R.id.major_spinner);
        workSpinner = (Spinner) findViewById(R.id.work_spinner);
        countrySpinner = (Spinner) findViewById(R.id.country_spinner);

    }


    public void addListenerOnButton() {

        majorSpinner = (Spinner) findViewById(R.id.major_spinner);
        workSpinner = (Spinner) findViewById(R.id.work_spinner);
        countrySpinner = (Spinner) findViewById(R.id.country_spinner);
        button = (AppCompatButton ) findViewById(R.id.appCompatButtonSend);


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(AdvanceSearchActivity.this,
                        "OnClickListener : " +
                                "\n majorSpinner : "+ String.valueOf(majorSpinner.getSelectedItem()) +
                                "\n country : "+ String.valueOf(countrySpinner.getSelectedItem()) +
                                "\n work : "+ String.valueOf(workSpinner.getSelectedItem()),
                        //  "\n name : "+  String.valueOf(name.getText())

                        Toast.LENGTH_SHORT).show();

            }

        });

    }






   // @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }
//    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent e) {
//        AdvanceResultFragment advanceResultFragment ;
//        advanceResultFragment = AdvanceResultFragment.newInstance(AdvanceResultFragment.STATION_TYPE_RECENT);
//        if (keyCode == KeyEvent.KEYCODE_MENU) {
//
//            getSupportFragmentManager().beginTransaction().replace(R.id.main_container, advanceResultFragment).addToBackStack(null).commit();
//        }
//    return true ;
//    }





//    public void loadResultFragment(){
//        AdvanceResultFragment advanceResultFragment ;
//        advanceResultFragment = AdvanceResultFragment.newInstance(AdvanceResultFragment.STATION_TYPE_RECENT);
//
//
//         {
//            getSupportFragmentManager().beginTransaction().replace(R.id.main_container, advanceResultFragment).addToBackStack(null).commit();
//        }
//
//
//
//    }


//    @Override
//    public void onClicked(View v) {
//
//        AdvanceResultFragment advanceResultFragment = new AdvanceResultFragment() ;
//        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, advanceResultFragment).addToBackStack(null).commit();
//    }
//
//    @Override
//    public void onFragmentInteraction(Uri uri) {
//
//    }
//
//    @Override
//    public void onClicked(View v) {
//
//
//
//
//    }

    @Override
    public void onClick(View v) {

        //Intent intent ;
        if (v == button) {


            sendMessage() ;




        }

    }
}
