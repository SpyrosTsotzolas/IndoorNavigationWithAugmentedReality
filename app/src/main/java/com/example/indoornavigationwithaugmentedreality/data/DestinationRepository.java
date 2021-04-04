package com.example.indoornavigationwithaugmentedreality.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.indoornavigationwithaugmentedreality.model.Destination;
import com.example.indoornavigationwithaugmentedreality.util.DestinationRoomDatabase;

import java.util.List;

public class DestinationRepository {
    private DestinationDao destinationDao;
    private LiveData<List<Destination>> allDestinations;

    public DestinationRepository(Application application) {
        DestinationRoomDatabase db = DestinationRoomDatabase.getDatabase(application);
        destinationDao = db.destinationDao();

        allDestinations = destinationDao.getAllDestinations();
    }

    public LiveData<List<Destination>> getAllData() {
        return allDestinations;
    }

    public void insert(Destination destination) {
        DestinationRoomDatabase.databaseWriteExecutor.execute(() -> {
            destinationDao.insert(destination);
        });
    }
}
