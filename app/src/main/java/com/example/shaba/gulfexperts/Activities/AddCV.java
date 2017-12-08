package com.example.shaba.gulfexperts.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.shaba.gulfexperts.R;
import com.example.shaba.gulfexperts.data.model.CV;
import com.example.shaba.gulfexperts.data.model.Country;
import com.example.shaba.gulfexperts.data.model.Expert;
import com.example.shaba.gulfexperts.data.model.Major;
import com.example.shaba.gulfexperts.data.model.Qualification;
import com.example.shaba.gulfexperts.data.model.Work;
import com.example.shaba.gulfexperts.data.repo.CVRepo;
import com.example.shaba.gulfexperts.data.repo.CountryRepo;
import com.example.shaba.gulfexperts.data.repo.ExpertRepo;
import com.example.shaba.gulfexperts.data.repo.MajorRepo;
import com.example.shaba.gulfexperts.data.repo.QualificationRepo;
import com.example.shaba.gulfexperts.data.repo.WorkRepo;
import com.example.shaba.gulfexperts.model.CVList;

import net.rimoto.intlphoneinput.IntlPhoneInput;

import java.util.List;

public class AddCV extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    TextInputEditText name, email, workTxt ;
    IntlPhoneInput phoneInput ;
    private Spinner majorSpinner, minorSpinner , countrySpinner, workSpinner ;
    private AppCompatButton button ;
  //  Expert expert ;
    Major major ;
    private final AppCompatActivity activity = AddCV.this;
    private static final String TAG = AddCV.class.getSimpleName().toString();
    Qualification qualification ;
    Country country ;
  //  CV cv ;
//    MinorRepo minorRepo = new MinorRepo();
   MajorRepo majorRepo ;
    CountryRepo countryRepo ;
    QualificationRepo qualificationRepo ;

    ArrayAdapter<CharSequence> adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cv);
        Intent intent = getIntent();
        addOther() ;
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();
        button.setOnClickListener(this);

    }


    public void addListenerOnSpinnerItemSelection() {
        majorSpinner = (Spinner) findViewById(R.id.major_spinner);
        workSpinner = (Spinner) findViewById(R.id.work_spinner);
        countrySpinner = (Spinner) findViewById(R.id.country_spinner);

    }


    public void addListenerOnButton() {

        majorSpinner = (Spinner) findViewById(R.id.major_spinner);
//        minorSpinner = (Spinner) findViewById(R.id.minor_spinner);
        workSpinner = (Spinner) findViewById(R.id.work_spinner);
        countrySpinner = (Spinner) findViewById(R.id.country_spinner);
        button = (AppCompatButton ) findViewById(R.id.appCompatButtonSend);
        name = (TextInputEditText) findViewById(R.id.textInputEditTextName);
        email = (TextInputEditText) findViewById(R.id.textInputEditTextEmail);
        phoneInput = (IntlPhoneInput)  findViewById(R.id.Input_Phone);
        workTxt = (TextInputEditText) findViewById(R.id.textInputEditTextWork);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {




                Toast.makeText(AddCV.this,
                        "OnClickListener : " +
                                "\n majorSpinner : "+ String.valueOf(majorSpinner.getSelectedItem()) +
                                "\n country : "+ String.valueOf(countrySpinner.getSelectedItem()) +
                                "\n work : "+ String.valueOf(workSpinner.getSelectedItem())+
                                "\n email : "+ email.getText().toString() +
                                "\n phone : "+ String.valueOf(phoneInput.getText()) +
                               "\n work : "+ workTxt.getText().toString() ,
                              //  "\n name : "+  String.valueOf(name.getText())

                        Toast.LENGTH_SHORT).show();






            }

        });





    }

    private void addOther(){
      MajorRepo  majorRepo = new MajorRepo();
      CountryRepo  countryRepo = new CountryRepo();
      QualificationRepo  qualificationRepo = new QualificationRepo();
     Qualification   qualification = new Qualification();
      Major  major = new Major();
     Country   country = new Country() ;
     countryRepo.delete();
       majorRepo.delete();
       qualificationRepo.delete();


//
        country.setCountryId("Saudi Arabia");
        countryRepo.insert(country);
//
        country.setCountryId("Bahrin");
        countryRepo.insert(country);
//
        country.setCountryId("UAE");
        countryRepo.insert(country);
//
        country.setCountryId("Oman");
        countryRepo.insert(country);
//
        country.setCountryId("Qatar");
        countryRepo.insert(country);
//
        country.setCountryId("kuwait");
        countryRepo.insert(country);



        major.setMajorId("Science");
//
        majorRepo.insert(major);
        major.setMajorId("Eduaction");
//
        majorRepo.insert(major);
        major.setMajorId("Art");
//
        majorRepo.insert(major);
        major.setMajorId("Islamic Studies");
//
        majorRepo.insert(major);
        major.setMajorId("Computer Science");
//
        majorRepo.insert(major);
        major.setMajorId("Law");
//
        majorRepo.insert(major);

        qualification.setQualificationId("PHD");
//
        qualificationRepo.insert(qualification);

        qualification.setQualificationId("Master");
//
        qualificationRepo.insert(qualification);
        qualification.setQualificationId("Bechlor");
//





    }
    private void CVData(){

        CVRepo cvRepo = new CVRepo() ;
        ExpertRepo expertRepo = new ExpertRepo() ;
       CV cv = new CV() ;
     Expert    expert = new Expert();
Work work = new Work()  ;
        WorkRepo workRepo = new WorkRepo() ;



      work.setWorkId(String.valueOf(workTxt.getText()));
        expert.setEmail(String.valueOf(email.getText()));
        expert.setName((String.valueOf(name.getText())));
        expert.setPhone((phoneInput.getText().toString()));

        expertRepo.insert(expert);
        workRepo.insert(work) ;

cv.setExpertEmail((String.valueOf(email.getText())));
        cv.setQualificationId(String.valueOf(workSpinner.getSelectedItem()));
        cv.setMajorId(String.valueOf(majorSpinner.getSelectedItem()));
        cv.setCountryId(String.valueOf(countrySpinner.getSelectedItem()));
        cv.setWorkId(String.valueOf(String.valueOf(workTxt.getText())));
        cvRepo.insert(cv);




    }

    @Override
    public void onClick(View v) {
        //Intent intent ;
        if (v == button) {
            CVData();

//    Toast.makeText(AddCV.this,
//            "OnClickListener : " +
//                    "\n majorSpinner : "+ String.valueOf(majorSpinner.getSelectedItem()) +
//                    "\n country : "+ String.valueOf(countrySpinner.getSelectedItem()) +
//                    "\n work : "+ String.valueOf(workSpinner.getSelectedItem())+
//                    "\n email : "+ email.getText().toString() +
//                    "\n phone : "+ String.valueOf(phoneInput.getText()) +
//                    "\n name : "+  String.valueOf(name.getText()),
//            Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, AdvanceSearchActivity.class);
          startActivity(intent);
            CVRepo cvRepo = new CVRepo();
            List<CVList> cvLists = cvRepo.getCVList();

            Log.d(TAG, String.format("%-11s", "Student ID") +
                    String.format("%-35s", "Student Name") +
                    String.format("%-7s", "Course") +
                    String.format("%-31s", "Course Name") +
                    String.format("%-6s", "Grade") +
                    String.format("%-6s", "Major") +
                    String.format("%-35s", "Major Name")
            );

            Log.d(TAG, "=============================================================");
            for (int i = 0; i < cvLists.size(); i++) {
                Log.d(TAG,
                        cvLists.get(i).getExpertEmail() +
                        " " + String.format("%-35s", cvLists.get(i).getExpertName()) +
                        String.format("%-7s", cvLists.get(i).getMajorId()) +
                        String.format("%-31s", cvLists.get(i).getCountryId()) +
                        String.format("%-6s", cvLists.get(i).getQualificationId())


                );

            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}


////        expertRepo.delete();
////           cvRepo.delete();
////     countryRepo.delete();
////       majorRepo.delete();
//////        minorRepo.delete();
////       qualificationRepo.delete();
//
////        WorkRepo workRepo = new WorkRepo();
////
//
//////        Expert expert = new Expert();
//        Qualification qualification = new Qualification();
//      Major major = new Major();
////        Minor minor = new Minor();
////        Work work = new Work() ;
//     Country country = new Country() ;
////
////        expert.setExpertId("1");
//
//       qualification.setQualificationId("work");
//        qualificationRepo.insert(qualification);
//
//        major.setMajorId("major");
//        majorRepo.insert(major) ;
//
//
//
////        major.setMajorId("Art");
////       major.setName("3");
////        majorRepo.insert(major);
//
//
//



//
//        // Expert
//


//
//        expert.setExpertId("2");
//        expert.setName("Jennifer Ames");
//        expert.setMajor("CI");
//        expertRepo.insert(expert);
//
//
//        expert.setExpertId("3");
//        expert.setName("Carl Hersey");
//        expert.setMajor("BU");
//        expertRepo.insert(expert);
//
//
//        expert.setExpertId("4");
//        expert.setName("Mary Stanton");
//        expert.setMajor("CI");
//        expertRepo.insert(expert);
//
//        expert.setExpertId("4");
//        expert.setName("John Richards");
//        expert.setMajor("CI");
//        expertRepo.insert(expert);
//MinorRepo minorRepo = new MinorRepo();
//    MajorRepo majorRepo = new MajorRepo();
//   CountryRepo countryRepo = new CountryRepo();
//   QualificationRepo qualificationRepo = new QualificationRepo();