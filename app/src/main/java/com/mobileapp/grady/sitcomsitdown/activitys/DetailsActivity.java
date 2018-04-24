package com.mobileapp.grady.sitcomsitdown.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mobileapp.grady.sitcomsitdown.R;

public class DetailsActivity extends AppCompatActivity {

    private long sitcomId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        sitcomId = getIntent().getIntExtra("SITCOM_ID", 1);
    }
}
