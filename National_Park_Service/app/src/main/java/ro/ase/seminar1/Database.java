package ro.ase.seminar1;

import android.content.Context;

import androidx.room.Room;

public class Database {

    private static Database database;
    private DatabaseParc databaseParc;
    private Database(Context context){
        databaseParc = Room.databaseBuilder(context,
                DatabaseParc.class, "parc-database").build();
    }

    public static Database getInstance(Context context){
        if(database == null){
            database = new Database(context);
        }
        return database;
    }
    public DatabaseParc getDataBase(){
        return databaseParc;
    }
}
