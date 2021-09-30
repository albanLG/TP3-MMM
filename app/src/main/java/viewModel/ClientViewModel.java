package viewModel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import data.Client;

public class ClientViewModel extends BaseObservable {

    private Client client;

    public Client getClient(){return client;}

    public void setClient(Client client){this.client = client;}

    public ClientViewModel(Client client) {
        this.client = client;
    }

    @Bindable
    public String getNom(){return client.getNom();}
    public void setNom(String nom){client.setNom(nom);}

    @Bindable
    public String getPrenom(){return client.getPrenom();}
    public void setPrenom(String prenom){client.setPrenom(prenom);}


    @Bindable
    public String getDateNaissance(){return client.getBirthday();}
    public void setDateNaissance(String birthday){client.setBirthday(birthday);}

    @Bindable
    public String getVilleNaissance(){return client.getVilleNaissance();}
    public void setVilleNaissance(String villeNaissance){ client.setVilleNaissance(villeNaissance);}

    @Bindable
    public String getDepartment(){return client.getDepartement();}
    public void setDepartment(String department){client.setDepartement(department);}
}
