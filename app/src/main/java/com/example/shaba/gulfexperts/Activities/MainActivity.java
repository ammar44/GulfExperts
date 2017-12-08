package com.example.shaba.gulfexperts.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.placeholder.PlaceHolderView;
import com.example.shaba.gulfexperts.Model;
import com.example.shaba.gulfexperts.R;
import com.example.shaba.gulfexperts.placeholderClasses.Image;
import com.example.shaba.gulfexperts.placeholderClasses.Utils;
import com.example.shaba.gulfexperts.placeholderClasses.drawer.DrawerHeader;
import com.example.shaba.gulfexperts.placeholderClasses.drawer.DrawerMenuItem;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mindorks.butterknifelite.ButterKnifeLite;
import com.mindorks.butterknifelite.annotations.BindView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.drawerView)
    private PlaceHolderView mDrawerView;

    @BindView(R.id.drawerLayout)
    private DrawerLayout mDrawer;

    @BindView(R.id.toolbar)
    private Toolbar mToolbar;

    @BindView(R.id.galleryView)
    private PlaceHolderView mGalleryView;

    ArrayList<Model> models;
Button advaneceSearchBtn , simpleSearchBtn, aboutUsBtn , sponsorsBtn ,
    addCVBtn , expertsBooksBtn , partnersBtn , contactUsBtn , statistcsBtn , projectManagerBtn ;




    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    public static void setMainActivity(MainActivity mainActivity) {
        MainActivity.mainActivity = mainActivity;
    }

    private static MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ////////////////////////////////////////////////////////////////////

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("gulfexperts-2017");

        myRef.setValue("Hello, World!");





// Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                //Log.d(TAG, "Value is: " + value);
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
                Toast.makeText(MainActivity.this, error.toException().toString(), Toast.LENGTH_SHORT).show();
            }
        });

//////////////////////////////////////////////////////////////////////////
        
        
        Intent intent = getIntent();
        ButterKnifeLite.bind(this);
        setupDrawer();
        setupGallery();
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
       // GoogleSignInClient  mGoogleSignInClient = GoogleSignIn.getClient(this, gso);;

// define
        advaneceSearchBtn = (Button) findViewById(R.id.advanece_search_btn);
        simpleSearchBtn = (Button) findViewById(R.id.simple_search_btn);
        aboutUsBtn = (Button) findViewById(R.id.about_us_btn);
        sponsorsBtn = (Button) findViewById(R.id.sponsors_btn);
        addCVBtn = (Button) findViewById(R.id.add_CV_btn);
//        expertsBooksBtn = (Button) findViewById(R.id.experts_books_btn);
        partnersBtn = (Button) findViewById(R.id.partners_btn);
        contactUsBtn = (Button) findViewById(R.id.contact_us_btn);
//        statistcsBtn = (Button) findViewById(R.id.statistcs_btn);
//        projectManagerBtn = (Button) findViewById(R.id.project_manager_btn);

      // action

        advaneceSearchBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(MainActivity.this,AdvanceSearchActivity.class);
                startActivity(i);
            }
        });
//
//
//
        simpleSearchBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SimpleSearchActivity.class);
                startActivity(i);
            }
        });
        aboutUsBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(MainActivity.this,AboutUsActivity.class);
                startActivity(i);
            }
        });
//
//
//
        sponsorsBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SpnsorsActivity.class);
                startActivity(i);
            }
        });

        addCVBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(MainActivity.this,AddCV.class);
                startActivity(i);
            }
        });
//
//
//
//        expertsBooksBtn.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this,ExpertsBooksActivity.class);
//                startActivity(i);
//            }
//        });
        partnersBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(MainActivity.this,PartnersActivity.class);
                startActivity(i);
            }
        });
//
//
//
        contactUsBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ContactUsActivity.class);
                startActivity(i);
            }
        }); }

    private void setupDrawer(){
        mDrawerView
                .addView(new DrawerHeader())
                .addView(new DrawerMenuItem(this.getApplicationContext()))
                .addView(new DrawerMenuItem(this.getApplicationContext()))
                .addView(new DrawerMenuItem(this.getApplicationContext()))
                .addView(new DrawerMenuItem(this.getApplicationContext()))
                .addView(new DrawerMenuItem(this.getApplicationContext()))
                .addView(new DrawerMenuItem(this.getApplicationContext()))
                .addView(new DrawerMenuItem(this.getApplicationContext()))
                .addView(new DrawerMenuItem(this.getApplicationContext()));

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawer, mToolbar, R.string.open_drawer, R.string.close_drawer){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        mDrawer.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }
//    private void signIn() {
//        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
//        startActivityForResult(signInIntent, RC_SIGN_IN);
//    }

    private void setupGallery(){
        List<Image> imageList = Utils.loadImages(this.getApplicationContext());
        List<Image> newImageList = new ArrayList<>();
//        mGalleryView.getBuilder()
//                .setHasFixedSize(false)
//                .setItemViewCacheSize(10)
//                .setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
//             //   .setLayoutManager(new GridLayoutManager(this, 3));
//        for (Image image : imageList){
//            mGalleryView.addView(new ImageTypeBig(this.getApplicationContext(), mGalleryView, image.getUrl()));
//        }


//        for (int i = 0; i <  (imageList.size() > 10 ? 10 : imageList.size()); i++) {
//            newImageList.add(imageList.get(i));
//        }
//        mGalleryView.addView(new ImageTypeSmallPlaceHolder(this.getApplicationContext(), newImageList));
//
//        for (int i = imageList.size() - 1; i >= 0; i--) {
//            mGalleryView.addView(new ImageTypeBig(this.getApplicationContext(), mGalleryView, imageList.get(i).getUrl()));
//        }
//    }
    }}

//        statistcsBtn.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                Intent i = new Intent(MainActivity.this,StatistcsActivity.class);
//                startActivity(i);
//            }
//        });
//
//
//
//        projectManagerBtn.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this,ProjectManagerActivity.class);
//                startActivity(i);
//            }
//        });







//        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.RVModels);
//        // Initialize contacts
//        models = Model.createContactsList(20);
//        // Create adapter passing in the sample user data
//        RecycleViewAdapter adapter = new RecycleViewAdapter(this, models);
//        // Attach the adapter to the recyclerview to populate items
//        recyclerView.setAdapter(adapter);
//        // Set layout manager to position the items
//
//        // That's all!
//
//        GridLayoutManager manager = new GridLayoutManager(
//         this,2 /*number of grid cilmns*/ , GridLayoutManager.VERTICAL,false);
//
//        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(){
//            @Override
//            public int getSpanSize(int position) {
//                return   (position % 3 == 0 ? 2 : 1) ;
//            }
//        });
//
//        recyclerView.setLayoutManager(manager);


//
//    }
//
////    public void loadDetailsScreen (Model selectedStation){
////
////        getSupportFragmentManager().beginTransaction().
////                replace(R.id.main_container, new DetailsFragment())
////                .addToBackStack(null).commit();
////
////    }
//}

























//
//public class MainActivity extends ListActivity implements View.OnClickListener {
//    private int _Student_Id=0;
//    EditText editTextName, editTextMajor, editTextId ;
//    Button btnStuCourseGrade,btnCourseNameGradeTotal,btnCourseNotTakenByStudent,btnFail,btnDelete,btnInsert , btnGetAll;
//
//    public static final String TAG = MainActivity.class.getSimpleName();
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        btnStuCourseGrade= (Button)findViewById(R.id.btnStuCourseGrade);
//        btnStuCourseGrade.setOnClickListener(this);
//
//        btnCourseNameGradeTotal= (Button) findViewById(R.id.btnCourseNameGradeTotal);
//        btnCourseNameGradeTotal.setOnClickListener(this);
//
//        btnCourseNotTakenByStudent= (Button) findViewById(R.id.btnCourseNotTakenByStudent);
//        btnCourseNotTakenByStudent.setOnClickListener(this);
//
//        editTextName = (EditText) findViewById(R.id.NameText);
//        editTextMajor = (EditText) findViewById(R.id.MajorText);
//        editTextId = (EditText) findViewById(R.id.IdText);
//
//        btnFail= (Button) findViewById(R.id.btnFail);
//        btnFail.setOnClickListener(this);
//
//        btnDelete= (Button) findViewById(R.id.btnDelete);
//        btnDelete.setOnClickListener(this);
//
//        btnInsert= (Button) findViewById(R.id.btnInsert);
//        btnInsert.setOnClickListener(this);
//
//        btnGetAll= (Button) findViewById(R.id.btnGetAll);
//        btnGetAll.setOnClickListener(this);
//
//
//        insertSampleData();
////        _Student_Id =0;
////
////        Intent intent = getIntent();
////        _Student_Id =intent.getIntExtra("student_Id", 0);
////        ExpertRepo expertRepo = new ExpertRepo();
////        Expert expert = new Expert();
//        //expert = expertRepo.getExpertById(_Student_Id);
//
//
////        editTextId.setText(String.valueOf(expert.getExpertId()));
////        editTextName.setText(expert.getName());
////        editTextMajor.setText(expert.getMajorId());
//
//
//
//
//
//
//    }
//
//    private void insertSampleData(){
//
//        ExpertRepo expertRepo = new ExpertRepo();
//        BookRepo bookRepo   = new  BookRepo();
//        MajorRepo majorRepo = new MajorRepo();
//        StudentCourseRepo studentCourseRepo = new StudentCourseRepo();
//        MinorRepo minorRepo = new MinorRepo();
//        WorkRepo workRepo = new WorkRepo();
//        CountryRepo countryRepo = new CountryRepo();
//
//
//        studentCourseRepo.delete();
//        majorRepo.delete();
//        bookRepo.delete();
//        expertRepo.delete();
//
//        //Insert Sample data if the table is empty
//        Book book = new Book();
//
//        book.setName("Divine Reality");
//        book.setBookId("DR");
//        bookRepo.insert(book);
//
//        book.setName("Gulf Expert");
//        book.setBookId("GE");
//        bookRepo.insert(book);
//
//        book.setName("book3");
//        book.setBookId("b3");
//        bookRepo.insert(book);
//
//        book.setName("book4");
//        book.setBookId("b4");
//        bookRepo.insert(book);
//
//        book.setName("book5");
//        book.setBookId("b5");
//        bookRepo.insert(book);
//
//        book.setName("book6");
//        book.setBookId("b6");
//        bookRepo.insert(book);
//
//
//
//
//       Expert expert = new Expert();
//
//
//        expert.setName("Stephen Daniels");
//        expert.setPhone("ED");
//
//        expertRepo.insert(expert);
//
//
//        expert.setName("Jennifer Ames");
//        expert.setPhone("CI");
//        expert.setEmail("hotmail");
//        expertRepo.insert(expert);
//
//
//
//        expert.setName("Carl Hersey");
//        expert.setPhone("ED");
//        expertRepo.insert(expert);
//
//
//
//        expert.setName("Mary Stanton");
//        expert.setPhone("CI");
//        expert.setEmail("hotmail");
//        expertRepo.insert(expert);
//
//
//        expert.setName("John Richards");
//        expert.setPhone("CI");
//        expert.setEmail("hotmail");
//        expertRepo.insert(expert);
//
//
//
//        StudentCourse studentCourse = new StudentCourse();
//        studentCourse.setExpertId("1111");
//        studentCourse.setBookId("b4");
//        studentCourse.setGrade("A-");
//        studentCourseRepo.insert(studentCourse);
//
//        studentCourse.setExpertId("1111");
//        studentCourse.setBookId("b5");
//        studentCourse.setGrade("A");
//        studentCourseRepo.insert(studentCourse);
//
//
//
//        studentCourse.setExpertId("1111");
//        studentCourse.setBookId("DR");
//        studentCourse.setGrade("A");
//        studentCourseRepo.insert(studentCourse);
//
//        studentCourse.setExpertId("1212");
//        studentCourse.setBookId("b3");
//        studentCourse.setGrade("A");
//        studentCourseRepo.insert(studentCourse);
//
//
//        studentCourse.setExpertId("2222");
//        studentCourse.setBookId("GE");
//        studentCourse.setGrade("A");
//        studentCourseRepo.insert(studentCourse);
//
//
//        studentCourse.setExpertId("2222");
//        studentCourse.setBookId("b3");
//        studentCourse.setGrade("A-");
//        studentCourseRepo.insert(studentCourse);
//
//
//        studentCourse.setExpertId("3333");
//        studentCourse.setBookId("b4");
//        studentCourse.setGrade("B");
//        studentCourseRepo.insert(studentCourse);
//
//        studentCourse.setExpertId("3333");
//        studentCourse.setBookId("DR");
//        studentCourse.setGrade("B");
//        studentCourseRepo.insert(studentCourse);
//
//
//        studentCourse.setExpertId("3333");
//        studentCourse.setBookId("GE");
//        studentCourse.setGrade("B+");
//        studentCourseRepo.insert(studentCourse);
//
//
//        studentCourse.setExpertId("3333");
//        studentCourse.setBookId("b5");
//        studentCourse.setGrade("A-");
//        studentCourseRepo.insert(studentCourse);
//
//
//
//        studentCourse.setExpertId("2345");
//        studentCourse.setBookId("b4");
//        studentCourse.setGrade("I");
//        studentCourseRepo.insert(studentCourse);
//
//
//
//
//
//
//    }
//
//    private void ListStudentWithCourseNameAndGrade(){
//
//
//        StudentCourseRepo studentCourseRepo = new StudentCourseRepo();
//        List<StudentCourseList> studentCourseLists= studentCourseRepo.getStudentCourse();
//
//
//        Log.d(TAG,String.format("%-11s", "Expert ID") +
//                String.format("%-35s", "Expert Name") +
//                String.format("%-7s", "Book") +
//                String.format("%-31s", "Book Name") +
//                String.format("%-6s", "Grade") +
//                String.format("%-6s", "Major") +
//                String.format("%-35s", "Major Name")
//        );
//
////        if(studentCourseLists.size()!=0) {
////            ListView lv = getListView();
////
////            ListAdapter adapter = new SimpleAdapter( MainActivity.this,  studentCourseLists, R.layout.view_expert_entry, new String[] { "id","name", "book", "country", "major", "minor", "work"},
////                    new int[] {R.id.expert_Id, R.id.expert_name, R.id.expert_book, R.id.expert_country, R.id.expert_major, R.id.expert_minor,R.id.expert_work });
////            setListAdapter(adapter);
////        }else{
////            Toast.makeText(this,"No student!",Toast.LENGTH_SHORT).show();
////        }
//
//        Log.d(TAG,"=============================================================");
//
//        for (int i= 0; i< studentCourseLists.size();i++ ){
//            Log.d(TAG, "0000000000".substring( studentCourseLists.get(i).getExpertId().length())+ studentCourseLists.get(i).getExpertId() +
//                    " " + String.format("%-35s", studentCourseLists.get(i).getExpertName())+
//            String.format("%-7s", studentCourseLists.get(i).getBookId())+
//            String.format("%-31s", studentCourseLists.get(i).getBookName())+
//            String.format("%-6s", studentCourseLists.get(i).getGrade())+
//            String.format("%-6s", studentCourseLists.get(i).getMajorId())+
//            String.format("%-35s", studentCourseLists.get(i).getMajorName())
//
//
//            );
//
//
//        }
//        Log.d(TAG,"=============================================================");
//    }
//
//    private void ListCourseNameAndGradeCount(){
//
//        StudentCourseRepo studentCourseRepo = new StudentCourseRepo();
//        ArrayList<HashMap<String, String>> courseGradeCounts= studentCourseRepo.getCourseGradeCount();
//
///*
//  public List<StudentCourseList> getStudentCourse(){
//        StudentCourseList studentCourseList = new StudentCourseList();
//        List<StudentCourseList> studentCourseLists = new ArrayList<StudentCourseList>();
// */
//      //  ArrayList<HashMap<String, String>> courseGradeCounts= studentCourseRepo.getCourseGradeCount();
//
//        if(courseGradeCounts.size()!=0) {
//            ListView lv = getListView();
//
//            ListAdapter adapter = new SimpleAdapter( MainActivity.this,  courseGradeCounts, R.layout.view_expert_entry, new String[] { StudentCourse.KEY_BookId,Book.KEY_Name, StudentCourse.KEY_Grade, StudentCourse.KEY_Grade},
//                    new int[] {R.id.expert_Id, R.id.expert_name, R.id.expert_book, R.id.expert_country });
//            setListAdapter(adapter);
//        }else{
//            Toast.makeText(this,"No student!",Toast.LENGTH_SHORT).show();
//        }
//
//
//        Log.d(TAG,String.format("%-7s", "Book") +
//                String.format("%-31s", "Book Name") +
//                String.format("%-6s", "Grade") +
//                String.format("%-5s", "Total") );
//        Log.d(TAG,"=============================================================");
//        for (int i= 0; i< courseGradeCounts.size();i++ ){
//       //     Log.d(TAG,String.format("%-7s", courseGradeCounts.get(i).values()));
//            Log.d(TAG,String.format("%-7s", courseGradeCounts.get(i).values()));
//
//        }
//        Log.d(TAG,"=============================================================");
//
//    }
//
//    private void ListCourseNotTakenByStudent(){
//
//        StudentCourseRepo studentCourseRepo = new StudentCourseRepo();
//        List<CourseNotTakenByStudent> courseGradeCounts= studentCourseRepo.getCourseNotTakenByStudent("1212");
//
//        Log.d(TAG,"Book Not taken By Expert ID = 1212 (Jennifer Ames )") ;
//        Log.d(TAG, String.format("%-7s", "Book") +
//                String.format("%-31s", "Book Name"));
//        Log.d(TAG,"=============================================================");
//        for (int i= 0; i< courseGradeCounts.size();i++ ){
//            Log.d(TAG,String.format("%-7s", courseGradeCounts.get(i).getBookId())+
//                    String.format("%-31s", courseGradeCounts.get(i).getBookName()));
//        }
//        Log.d(TAG,"=============================================================");
//
//    }
//
////    private void ListExpert(){
////
////      ExpertRepo expertRepo = new ExpertRepo() ;
////
////        ArrayList<HashMap<String, String>> expertList =  expertRepo.getExpertList();
////
////        if(expertList.size()!=0) {
////            ListView lv = getListView();
////
////            ListAdapter adapter = new SimpleAdapter( MainActivity.this,  expertList, R.layout.view_expert_entry, new String[] {Expert.KEY_ExpertId,Expert.KEY_Name, Expert.KEY_MajorId},
////                    new int[] {R.id.expert_Id, R.id.expert_name, R.id.expert_major });
////            setListAdapter(adapter);
////        }else{
////            Toast.makeText(this,"No student!",Toast.LENGTH_SHORT).show();
////        }
////    }
//
//    private void failAllBUStudent(){
//        StudentCourseRepo studentCourseRepo = new StudentCourseRepo();
//        studentCourseRepo.failALLBUStudent();
//
//    }
//
//    private void deleteAllBUStudent(){
//        StudentCourseRepo studentCourseRepo = new StudentCourseRepo();
//        studentCourseRepo.deleteAllBUStudent();
//
//    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//
//
//
//    @Override
//    public void onClick(View view) {
//        if (view ==findViewById(R.id.btnStuCourseGrade)){
//
//
//            ListStudentWithCourseNameAndGrade();
//        }else if (view ==findViewById(R.id.btnCourseNameGradeTotal)){
//            ListCourseNameAndGradeCount();
//        }else if (view ==findViewById(R.id.btnCourseNotTakenByStudent)){
//            ListCourseNotTakenByStudent();
//        }else if (view ==findViewById(R.id.btnFail)){
//           failAllBUStudent();
//        }else if (view ==findViewById(R.id.btnDelete)) {
//            deleteAllBUStudent();
//        }else if (view ==findViewById(R.id.btnInsert)) {
//            insertSampleData();
//        }
//
//
//        else if (view ==findViewById(R.id.btnGetAll)) {
//btnCourseNameGradeTotal.setVisibility(view.INVISIBLE);
//            btnStuCourseGrade.setVisibility(view.INVISIBLE);
//            btnCourseNotTakenByStudent.setVisibility(view.INVISIBLE);
//            btnFail.setVisibility(view.INVISIBLE);
//
////            ExpertRepo expertRepo = new ExpertRepo();
////            Expert expert = new Expert();
////int count  =0 ;
////            for (int i =0  ; expertRepo.getExpert().get(i).getExpertId() != null ; i++ )
////                count ++ ;
////
////            expert.setID(""+count);
////            expert.setMajor(  editTextMajor.getText().toString());
////            expert.setName(editTextName.getText().toString()  );
////            expertRepo.insert(expert);
////            if (_Student_Id==0){
////
////
////                Toast.makeText(this,"New Student Insert",Toast.LENGTH_SHORT).show();
////            }else {
////
////
////            }
//
//
//             //   Intent intent = new Intent(this,ResultActivity.class);
//      //  intent.putExtra("student_Id",0);
//    //   startActivity(intent);
//           // ListCourseNameAndGradeCount() ;
//         //   ListExpert() ;
//
//
//        }
//
//
//
//}}
