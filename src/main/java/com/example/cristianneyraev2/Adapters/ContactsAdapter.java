package com.example.cristianneyraev2.Adapters;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.cristianneyraev2.Objects.CardContacts;
import com.example.cristianneyraev2.R;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.MyViewHolder>{

   Context mContext;
   List<CardContacts> mData;

    public ContactsAdapter(Context mContext, List<CardContacts> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;
        v= LayoutInflater.from(mContext).inflate(R.layout.contact_card, parent, false);
        MyViewHolder vHolder= new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.name.setText(mData.get(position).getNombre());
        holder.contact.setText(mData.get(position).getContacto());
        holder.img.setImageResource(mData.get(position).getImge());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView contact;
        private ImageView img;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.txtNombre);
            contact = (TextView) itemView.findViewById(R.id.txtContacto);
            img = (ImageView) itemView.findViewById(R.id.imgFoto);
        }
    }
}
