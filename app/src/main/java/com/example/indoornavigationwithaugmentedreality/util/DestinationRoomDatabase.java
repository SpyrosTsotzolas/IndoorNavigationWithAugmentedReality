package com.example.indoornavigationwithaugmentedreality.util;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.indoornavigationwithaugmentedreality.data.DestinationDao;
import com.example.indoornavigationwithaugmentedreality.model.Destination;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Destination.class}, version = 1, exportSchema = false)
public abstract class DestinationRoomDatabase extends RoomDatabase {

    public static final int NUMBER_OF_THREADS = 4;

    private static volatile DestinationRoomDatabase INSTANCE;
    public static final ExecutorService databaseWriteExecutor
            = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    private static final RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback() {
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);

                    databaseWriteExecutor.execute(() -> {
                        DestinationDao destinationDao = INSTANCE.destinationDao();
                        destinationDao.deleteAll();

                        Destination destination = new Destination("ΓΡΑΜΑΤΕΙΑ", 186, 19, 277, 19, 264, 122, 192, 120);
                        destinationDao.insert(destination);

                        destination = new Destination("ΓΡΑΦΕΙΟ 1",727,22,778,23,775,124,725,123);
                        destinationDao.insert(destination);

                        destination = new Destination("ΓΡΑΦΕΙΟ 2", 806,19,873,20,868,73,807,75);
                        destinationDao.insert(destination);

                        destination = new Destination("ΓΡΑΦΕΙΟ 3", 906,19,937,18,935,78,907,80);
                        destinationDao.insert(destination);

                        destination = new Destination("ΓΡΑΦΕΙΟ 4", 968,14,1044,14,1042,75,969,79);
                        destinationDao.insert(destination);

                        destination = new Destination("ΓΡΑΦΕΙΟ 5", 814,114,1042,114,1017,160,822,160);
                        destinationDao.insert(destination);

                        destination = new Destination("ΓΡΑΦΕΙΟ 6", 1068,22,1134,20,1130,129,1072,129);
                        destinationDao.insert(destination);

                        destination = new Destination("ΓΡΑΦΕΙΟ ΔΕΠ 1", 299,231,339,228,340,330,299,327);
                        destinationDao.insert(destination);

                        destination = new Destination("ΓΡΑΦΕΙΟ ΔΕΠ 2", 366,251,407,250,406,327,370,329);
                        destinationDao.insert(destination);

                        destination = new Destination("ΓΡΑΦΕΙΟ ΔΕΠ 3", 842,233,875,228,879,333,841,335);
                        destinationDao.insert(destination);

                        destination = new Destination("ΓΡΑΦΕΙΟ ΔΕΠ 4", 907,255,951,254,952,337,910,338);
                        destinationDao.insert(destination);

                        destination = new Destination("ΓΡΑΦΕΙΟ ΔΕΠ 5", 975,240,1016,237,1017,327,972,330);
                        destinationDao.insert(destination);

                        destination = new Destination("ΓΡΑΦΕΙΟ ΜΕΤΑΠΤΥΧΙΑΚΩΝ 1", 186,234,273,233,269,329,190,329);
                        destinationDao.insert(destination);

                        destination = new Destination("ΓΡΑΦΕΙΟ ΜΕΤΑΠΤΥΧΙΑΚΩΝ 2", 537,226,595,228,595,251,541,251);
                        destinationDao.insert(destination);

                        destination = new Destination("ΓΡΑΦΕΙΟ ΜΕΤΑΠΤΥΧΙΑΚΩΝ 3", 520,304,587,286,585,325,523,330);
                        destinationDao.insert(destination);

                        destination = new Destination("ΓΡΑΦΕΙΟ ΜΕΤΑΠΤΥΧΙΑΚΩΝ 4", 727,291,803,301,796,331,727,328);
                        destinationDao.insert(destination);

                        destination = new Destination("ΓΡΑΦΕΙΟ ΜΕΤΑΠΤΥΧΙΑΚΩΝ 5", 1052,240,1126,241,1126,322,1049,323);
                        destinationDao.insert(destination);

                        destination = new Destination("ΓΡΑΦΕΙΟ ΛΥΚΑ", 435,245,475,244,474,327,439,324);
                        destinationDao.insert(destination);

                        destination = new Destination("ΠΕΠ 2", 316,24,509,21,562,144,318,147);
                        destinationDao.insert(destination);

                        destination = new Destination("ΑΠΟΘΗΚΗ", 723,233,780,228,783,250,724,253);
                        destinationDao.insert(destination);


                    });
                }
            };

    public static DestinationRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DestinationRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),DestinationRoomDatabase.class, "destination_database").addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract DestinationDao destinationDao();

}
