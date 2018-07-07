package in.arpaul.androicomponents.dataaccess;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import in.arpaul.androicomponents.dao.UserDao;
import in.arpaul.androicomponents.models.UserDO;

@Database(entities = {UserDO.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
//        if (INSTANCE == null) {
//            synchronized (AppDatabase.class) {
//                if (INSTANCE == null) {
//                    // Create database here
//                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
//                            AppDatabase.class, "app_database").build();
//                }
//            }
//        }
        return INSTANCE;
    }
}
