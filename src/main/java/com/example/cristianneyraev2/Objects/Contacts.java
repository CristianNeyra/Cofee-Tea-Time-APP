package com.example.cristianneyraev2.Objects;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.cristianneyraev2.Adapters.ContactsAdapter;
import com.example.cristianneyraev2.R;
import java.util.ArrayList;
import java.util.List;


public class Contacts extends Fragment {

    View v;
    private List<CardContacts> lstContacts;


    public Contacts(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup containter, @Nullable Bundle saveInstanceState) {
        v = inflater.inflate(R.layout.fragment_contacts, containter, false);
        RecyclerView myrecyclerview = (RecyclerView) v.findViewById(R.id.idRecyclerViewContacts);
        ContactsAdapter recyclerView = new ContactsAdapter(getContext(),lstContacts);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerView);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstContacts = new ArrayList<>();
        lstContacts.add(new CardContacts(R.drawable.foto,"Cristián Neyra Avilés", "cristian.neyra@cftsa.cl"));

    }
}