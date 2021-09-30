package data;


import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

// A basic API to access the data (can be replaced if needed by another implementation)
public class RoomRepository  implements IRepository {

    private ClientDao clientDao;
    private LiveData<List<Client>> allClients;



    public RoomRepository(Application application) {
            AppDataBase database = AppDataBase.getInstance(application);
            clientDao= database.clientDao();
            allClients = clientDao.getAll();
    }


    @Override
    public void insertClient(Client client) {
        new InsertClientAsyncTask(clientDao).execute(client);
    }


    @Override
    public void deleteClient(Client client) {
        new DeleteClientAsyncTask(clientDao).execute(client);
    }


    @Override
    public void deleteAllClients() {
        new DeleteAllClientsAsyncTask(clientDao).execute();
    }

    // shows how to transform a regular list to a LiveData list

    @Override
    public LiveData<List<Client>> getAllClients() {
        return allClients;
    }


    private static class InsertClientAsyncTask extends AsyncTask<Client, Void, Void> {
        private ClientDao clientDao;

        private InsertClientAsyncTask(ClientDao clientDao) {
            this.clientDao = clientDao;
        }

        @Override
        protected Void doInBackground(Client... clients) {
            clientDao.insert(clients[0]);
            return null;
        }
    }


    private static class DeleteClientAsyncTask extends AsyncTask<Client, Void, Void> {
        private ClientDao clientDao;

        private DeleteClientAsyncTask(ClientDao clientDao) {
            this.clientDao = clientDao;
        }

        @Override
        protected Void doInBackground(Client... clients) {
            clientDao.delete(clients[0]);
            return null;
        }
    }

    private static class DeleteAllClientsAsyncTask extends AsyncTask<Void, Void, Void> {
        private ClientDao clientDao;

        private DeleteAllClientsAsyncTask(ClientDao noteDao) {
            this.clientDao = clientDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            clientDao.deleteAll();
            return null;
        }
    }

}