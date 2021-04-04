package com.example.indoornavigationwithaugmentedreality.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.indoornavigationwithaugmentedreality.data.DestinationRepository;

import java.util.List;

public class DestinationViewModel extends AndroidViewModel {

    public static DestinationRepository repository;
    public final LiveData<List<Destination>> allDestinations;

    public DestinationViewModel(@NonNull Application application) {
        super(application);
        repository = new DestinationRepository(application);
        allDestinations = repository.getAllData();
    }

    public LiveData<List<Destination>> getAllDestinations() {
        return allDestinations;
    }

    public static void insert(Destination destination) {
        repository.insert(destination);
    }
}
