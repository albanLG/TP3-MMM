package com.example.tp3_mmm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp3_mmm.databinding.FragmentSecondBinding;

import java.util.List;

import data.Client;
import ui.ClientListAdapter;
import viewModel.ClientListViewModel;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private ClientListViewModel viewModel;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

       // binding = FragmentSecondBinding.inflate(inflater, container, false);

        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
/**
 binding.createClient.setOnClickListener(new View.OnClickListener() {
@Override public void onClick(View view) {
NavHostFragment.findNavController(SecondFragment.this)
.navigate(R.id.action_SecondFragment_to_FirstFragment);
}
});
 **/
        RecyclerView recyclerView = view.findViewById(R.id.clients);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        // on créée une instance d'adapter
        final ClientListAdapter adapter = new ClientListAdapter();
        recyclerView.setAdapter(adapter);

        // on crée une instance de notre ViewModel

        viewModel = new ViewModelProvider(requireActivity()).get(ClientListViewModel.class);

        //viewModel = ViewModelProvider.of(this).get(viewModel.class);
        // et on ajoute un observer sur les clients...
        viewModel.getAllUsers().observe(getViewLifecycleOwner(), new Observer<List<Client>>() {
            @Override
            public void onChanged(@Nullable List<Client> clients) {
                adapter.setClients(clients);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                viewModel.delete(adapter.getClientAt(viewHolder.getAdapterPosition()));
            }
        }).attachToRecyclerView(recyclerView);


        view.findViewById(R.id.createClient).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }


        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}