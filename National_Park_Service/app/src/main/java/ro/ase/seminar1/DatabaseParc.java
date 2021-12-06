package ro.ase.seminar1;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Parc.class},version = 1,exportSchema = false)
public abstract class DatabaseParc extends RoomDatabase {
    public abstract ParcDAO parcDAO();
}
