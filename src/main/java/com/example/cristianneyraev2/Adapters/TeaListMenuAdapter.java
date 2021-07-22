package com.example.cristianneyraev2.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.cristianneyraev2.Interface.IComunicaFragment;
import com.example.cristianneyraev2.GlobalClass;
import com.example.cristianneyraev2.Objects.TeaListMenu;
import com.example.cristianneyraev2.R;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TeaListMenuAdapter extends RecyclerView.Adapter<TeaListMenuAdapter.MyViewHolder> {
    Activity actividad;
    Context mContext;
    List<TeaListMenu> mData;
    IComunicaFragment interfaceComunicaFragments;
    //GlobalClass claseGlobal = (GlobalClass) getApplicationContext();

    public TeaListMenuAdapter(Context mContext, List<TeaListMenu> mData) {
        this.mContext = mContext;
        this.mData = mData;
        if (mContext instanceof Activity){
            actividad=(Activity) mContext;
            interfaceComunicaFragments = (IComunicaFragment) actividad;
        }

    }

    @Override
    public TeaListMenuAdapter.@NotNull MyViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {

        View v;
        v= LayoutInflater.from(mContext).inflate(R.layout.tea_list_menu, parent, false);


        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.img.setImageResource(mData.get(position).getImge());
        holder.name.setText(mData.get(position).getNombre());
        //Captura y pasa el nombre del Té al MainActivity
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                interfaceComunicaFragments.capturaCardView(mData.get(position).getNombre());
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView img;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_tea);
            img = itemView.findViewById(R.id.image_tea_list_menu);
            
        }
    }




}
