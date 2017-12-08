package com.example.shaba.gulfexperts.Activities;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.shaba.gulfexperts.Pageable;
import com.example.shaba.gulfexperts.R;
import com.example.shaba.gulfexperts.data.model.CV;
import com.example.shaba.gulfexperts.data.model.Country;
import com.example.shaba.gulfexperts.data.model.Expert;
import com.example.shaba.gulfexperts.data.model.Major;
import com.example.shaba.gulfexperts.data.model.Minor;
import com.example.shaba.gulfexperts.data.model.Qualification;
import com.example.shaba.gulfexperts.data.repo.CVRepo;
import com.example.shaba.gulfexperts.model.AdvanceList;

import java.util.ArrayList;
import java.util.List;


public class ResultActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String TAG = ResultActivity.class.getSimpleName();
    TableLayout maintable;
    TableRow tableRow,rowHead;
    LinearLayout separator;
    TextView value;
    TextView textView;
    Pageable<AdvanceList> pageableArray;
    Button buttonNext;
    Button buttonPrev;
    Expert expert ;
    Major major ;
    Minor minor ;
    Qualification qualification ;
    Country country ;
    CV cv ;
    EditText editTextName, editTextMajor, editTextId ;
    TextView textViewPageCount;
    ArrayList<AdvanceList> myValues;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        textView = (TextView) findViewById(R.id.tvID);
        maintable = (TableLayout) findViewById(R.id.main);
        rowHead = (TableRow) findViewById(R.id.rowHeader);
        buttonNext = (Button) findViewById(R.id.btnNext);
        buttonPrev = (Button) findViewById(R.id.btnPrevious);
        textViewPageCount = (TextView) findViewById(R.id.txtPageCount);
        myValues = new ArrayList<>();
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pageableArray.setPage(pageableArray.getNextPage());
                tableRow.removeAllViews();
                displayPage();
                textViewPageCount.setText("Page " + pageableArray.getPage() + " of " + pageableArray.getMaxPages());
            }
        });

        buttonPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pageableArray.setPage(pageableArray.getPreviousPage());
                tableRow.removeAllViews();
                displayPage();
                textViewPageCount.setText("Page " + pageableArray.getPage() + " of " + pageableArray.getMaxPages());

            }
        });

        CVRepo cvRepo = new CVRepo();
     //   CVData() ;
        List<AdvanceList> advanceLists= cvRepo.getAdvanceSearch("hh", "ll", "li");

        for(int i= 0; i< advanceLists.size();i++ ){
            myValues.add(advanceLists.get(i));
        }




        pageableArray = new Pageable<>(myValues);
        pageableArray.setPageSize(10);
        pageableArray.setPage(1);
        textViewPageCount.setText("Page " + pageableArray.getPage() + " of " + pageableArray.getMaxPages());
        displayPage();
    }

    public void displayPage() {
        maintable.removeAllViews();
        maintable.addView(rowHead);
        for (AdvanceList v : pageableArray.getListForPage()) {
            tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));

            value = new TextView(this);
            value.setLayoutParams(textView.getLayoutParams());
            value.setGravity(Gravity.CENTER_HORIZONTAL);
            value.setText(v.getExpertEmail());
            tableRow.addView(value);

            value = new TextView(this);
            value.setLayoutParams(textView.getLayoutParams());
            value.setGravity(Gravity.CENTER_HORIZONTAL);
            value.setText(String.valueOf(v.getExpertName()));
            tableRow.addView(value);


            value = new TextView(this);
            value.setLayoutParams(textView.getLayoutParams());
            value.setGravity(Gravity.CENTER_HORIZONTAL);
            value.setText(v.getQualificationId());
            tableRow.addView(value);

//

            value = new TextView(this);
            value.setLayoutParams(textView.getLayoutParams());
            value.setGravity(Gravity.CENTER_HORIZONTAL);
            value.setText(v.getMajorId());
            tableRow.addView(value);



            value = new TextView(this);
            value.setLayoutParams(textView.getLayoutParams());
            value.setGravity(Gravity.CENTER_HORIZONTAL);
            value.setText(v.getCountryId());
            tableRow.addView(value);




            maintable.addView(tableRow);
            addSeparator();
        }
    }










    private void addSeparator() {
        Resources res = ResultActivity.this.getResources();
        separator = new LinearLayout(ResultActivity.this);
        separator.setOrientation(LinearLayout.VERTICAL);
        separator.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 2));
        separator.setBackgroundColor(Color.parseColor("#5e7974"));
        separator.setDividerDrawable(res.getDrawable(R.drawable.radius_middle));
        maintable.addView(separator);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

    }
}
