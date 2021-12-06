package ro.ase.seminar1;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ParcDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Parc... parc);

    @Delete
    void delete(Parc parc);

    @Query("SELECT * FROM parcuri")
    public List<Parc> getParcs();

    @Query("SELECT * FROM parcuri WHERE pret> :pret")
    List<Parc> getAllPret(int pret);
}
