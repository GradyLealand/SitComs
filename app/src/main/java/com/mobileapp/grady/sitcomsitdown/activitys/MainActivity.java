package com.mobileapp.grady.sitcomsitdown.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mobileapp.grady.sitcomsitdown.R;
import com.mobileapp.grady.sitcomsitdown.database.SitcomAdapter;
import com.mobileapp.grady.sitcomsitdown.database.SitcomDBHelper;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private SitcomDBHelper dbHelper;
    private SitcomAdapter adapter;
    private final int GRID_ROWS = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize variables
        mRecyclerView = (RecyclerView)findViewById(R.id.rv);
        mRecyclerView.setHasFixedSize(true);
        //set a grid layout manager
        mLayoutManager = new GridLayoutManager(this.getApplicationContext(), GRID_ROWS);
        mRecyclerView.setLayoutManager(mLayoutManager);
        //populate the recycler view
        populaterecyclerView();
    }

    private void populaterecyclerView()
    {
        dbHelper = new SitcomDBHelper(this);
        adapter = new SitcomAdapter(dbHelper.getSitcoms(), this, mRecyclerView);

    }
}
