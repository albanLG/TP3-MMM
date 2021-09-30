package data;

import androidx.lifecycle.LiveData;

import java.util.List;

// a simple interface to the data
public interface IRepository {

    public void insertClient(Client client);

    public void deleteClient(Client client);

    public void deleteAllClients();

    public LiveData<List<Client>> getAllClients();

}
