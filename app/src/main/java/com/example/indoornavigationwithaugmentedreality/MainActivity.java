package com.example.indoornavigationwithaugmentedreality;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.indoornavigationwithaugmentedreality.adapter.RecyclerViewAdapter;
import com.example.indoornavigationwithaugmentedreality.model.Destination;
import com.example.indoornavigationwithaugmentedreality.model.DestinationViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        BroadcastReceiver broadcastReceiver = new WifiBroadcastReceiver();
//
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction(WifiManager.SUPPLICANT_STATE_CHANGED_ACTION);
//        registerReceiver(broadcastReceiver, intentFilter);

        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        DestinationViewModel destinationViewModel = new ViewModelProvider.AndroidViewModelFactory(MainActivity.this
                .getApplication())
                .create(DestinationViewModel.class);

        destinationViewModel.getAllDestinations().observe(this, destinations -> {

            // Set up adapter

            recyclerViewAdapter = new RecyclerViewAdapter(destinations, MainActivity.this);
            recyclerView.setAdapter(recyclerViewAdapter);

        });





    }

}