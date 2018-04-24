package com.mobileapp.grady.sitcomsitdown.activitys;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mobileapp.grady.sitcomsitdown.R;
import com.mobileapp.grady.sitcomsitdown.database.DetailsAdapter;
import com.mobileapp.grady.sitcomsitdown.database.SitcomAdapter;
import com.mobileapp.grady.sitcomsitdown.database.SitcomDBHelper;

public class DetailsActivity extends AppCompatActivity {

    private long sitcomId;

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        sitcomId = getIntent().getIntExtra("SITCOM_ID", 1);

        //initialize variables
        mRecyclerView = findViewById(R.id.rv_details);
        mRecyclerView.setHasFixedSize(true);

        //set a grid layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //populate the recycler view
        populateRecyclerView();
    }

    /**
     * Populate recycler view
     */
    private void populateRecyclerView()
    {
        SitcomDBHelper dbHelper = new SitcomDBHelper(this);
        DetailsAdapter adapter = new DetailsAdapter(dbHelper.getCharacters((int) sitcomId), this, mRecyclerView);
        mRecyclerView.setAdapter(adapter);
    }

}
