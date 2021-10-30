package com.my.discriminant.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.my.discriminant.R;
import com.my.discriminant.adapters.DiscriminantAdapter;

public class DiscriminantList extends AppCompatActivity {

    RecyclerView recyclerView;
    DiscriminantAdapter adapter = new DiscriminantAdapter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discriminant_list);
        recyclerView = findViewById(R.id.rID);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(view ->
                startActivity(new Intent(DiscriminantList.this, DiscriminantDetails.class)));

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.RefreshData();
        adapter.notifyDataSetChanged();
    }
}
