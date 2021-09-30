package data;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ClientDao {
    @Query("SELECT * FROM client_table ")
    LiveData<List<Client>> getAll();

    @Query("SELECT * FROM client_table WHERE uid IN (:userIds)")
    LiveData<List<Client>> loadAllByIds(int[] userIds);


    @Query("SELECT * FROM client_table WHERE prenom LIKE :prenom AND " +
            "nom LIKE :nom LIMIT 1")
    Client findByName(String prenom, String nom);

    @Insert
    void insertAll(Client... clients);

    @Insert
    void insert(Client client);

    @Delete
    void delete(Client client);

    @Delete
    void deleteAll(Client... clients);

}