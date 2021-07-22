package com.example.cristianneyraev2.Objects;


import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.cristianneyraev2.Adapters.TeaListMenuAdapter;
import com.example.cristianneyraev2.R;
import com.example.cristianneyraev2.Utils.CardViewSeparator;
import java.util.ArrayList;
import java.util.List;


public class TeasList extends Fragment {

    View view;
    private List<TeaListMenu> lstTeas;

    public TeasList(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containter, Bundle saveInstanceState) {
        view = inflater.inflate(R.layout.fragment_teas_list, containter, false);
        RecyclerView myrecyclerview = view.findViewById(R.id.idRecyclerViewTeaList);
        CardViewSeparator itemSeparation = new CardViewSeparator(40);
        myrecyclerview.addItemDecoration(itemSeparation);
        TeaListMenuAdapter recyclerView = new TeaListMenuAdapter(getContext(), lstTeas);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerView);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstTeas = new ArrayList<>();
        lstTeas.add(new TeaListMenu(R.drawable.black_tea,"Black Tea"));
        lstTeas.add(new TeaListMenu(R.drawable.chamomile_tea,"Chamomile Tea"));
        lstTeas.add(new TeaListMenu(R.drawable.green_tea,"Green Tea"));
        lstTeas.add(new TeaListMenu(R.drawable.honey_lemon_tea,"Honey Lemon Tea"));
        lstTeas.add(new TeaListMenu(R.drawable.oolong_tea,"Oolong Tea"));
        lstTeas.add(new TeaListMenu(R.drawable.white_tea,"White Tea"));

    }


}