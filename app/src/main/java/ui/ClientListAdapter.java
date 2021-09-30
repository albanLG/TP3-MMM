package ui;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp3_mmm.R;

import data.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientListAdapter extends RecyclerView.Adapter<ClientListAdapter.ClientHolder> {
    private List<Client> clients = new ArrayList<>();


    @NonNull
    @Override
    public ClientHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.client_item, parent, false);
        return new ClientHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientHolder holder, int position) {
        Client currentUser = clients.get(position);
        holder.prenom.setText(currentUser.getPrenom());
        holder.nom.setText(currentUser.getNom());
        holder.birthday.setText(currentUser.getBirthday());
        holder.villeDeNaissance.setText(currentUser.getVilleNaissance());
    }

    @Override
    public int getItemCount() {
        return clients.size();
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
        notifyDataSetChanged();
    }

    public Client getClientAt(int adapterPosition) {
        return clients.get(adapterPosition);
    }

    class ClientHolder extends RecyclerView.ViewHolder {
        private TextView prenom;
        private TextView nom;
        private TextView birthday;
        private TextView villeDeNaissance;


        public ClientHolder(View itemView) {
            super(itemView);
            prenom = itemView.findViewById(R.id.prenom);
            nom = itemView.findViewById(R.id.nom);
            birthday = itemView.findViewById(R.id.birthday);
            villeDeNaissance = itemView.findViewById(R.id.villeNaissance);
        }
    }
}