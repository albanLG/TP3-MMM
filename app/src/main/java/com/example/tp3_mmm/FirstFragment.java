package com.example.tp3_mmm;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.tp3_mmm.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;

import data.Client;
import viewModel.ClientListViewModel;
import viewModel.ClientViewModel;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_first,container,false);
       // binding = FragmentFirstBinding.inflate(inflater, container, false);
        binding.setViewModel(new ClientViewModel(new Client("","","","","")));
        setHasOptionsMenu(true);
        View view = binding.getRoot();
        return view;

    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonValid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // we get a reference on the view model of a client

                ClientViewModel vm = binding.getViewModel();

                Log.i("CLICK","CLIENT = " +vm.getClient().getPrenom()+" "+vm.getClient().getNom());

                // we get a reference on the viewmodel of the ClientList

                ClientListViewModel clvm = new ViewModelProvider(requireActivity()).get(ClientListViewModel.class);

                // we extract the client and give it to the client list
                clvm.insert(vm.getClient());

                // and we move back to the first fragment
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu , MenuInflater inflater) {
        inflater.inflate(R.menu.menu_first_fragment , menu);
        super.onCreateOptionsMenu(menu , inflater );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.resetUserData:
                cleanDataUser();return true;
            case R.id.showPhoneNumber:
                displayPhoneNumber();return true;
            case R.id.wiki:
                String url="https://fr.wikipedia.org/wiki/"+binding.editBirthCity.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                return true;
            default:
                return false;
        }
    }

    public boolean isClientValid(){
        return true;
    }

    public List<View> getUserData(){
        List<View> res=new ArrayList<>();
        for(int i = 6; i < binding.userDataContainer.getChildCount(); i++) {
            res.add(binding.userDataContainer.getChildAt(i));
        }
        return res;
    }

    //Change Visibility state of phoneNumber
    public void displayPhoneNumber(){
        int phoneDisplayed=binding.editPhoneNum.getVisibility();
        if(phoneDisplayed==0){//visible
            binding.editPhoneNum.setVisibility(View.GONE);
            binding.textPhoneNum.setVisibility(View.GONE);
        }else{
            binding.editPhoneNum.setVisibility(View.VISIBLE);
            binding.textPhoneNum.setVisibility(View.VISIBLE);
        }
    }

    public void cleanDataUser(){
        List<View> l=getUserData();

        for(View e : l) {
            if(e instanceof EditText) {
                EditText child = (EditText) e;
                child.setText("");
            }else if(e instanceof Spinner){
                Spinner s= (Spinner)e;
                s.setSelection(0);
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    /*
    How I do interface style:
    create contenair
    fill it with your pairs (text, edit)
    Vertical align pairs (should text items get this style)
    Right align text items
    Left align edit items
    Create vertical chains on edit item
    */
}