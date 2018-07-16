package com.example.diegotorres.puntosdeventa.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diegotorres.puntosdeventa.Mapa.MapsActivity;
import com.example.diegotorres.puntosdeventa.R;
import com.google.android.gms.location.places.PlaceBuffer;

/**
 * Created by Diego Torres on 11/07/2018.
 */

public class PuntosVentaAdapter extends RecyclerView.Adapter<PuntosVentaAdapter.PuntoVentaViewHolder> {

    private Context mContext;
    private PlaceBuffer mPlaces;

    public PuntosVentaAdapter(Context mContext, PlaceBuffer mPlaces) {
        this.mContext = mContext;
        this.mPlaces = mPlaces;
    }

    @Override
    public PuntoVentaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.punto_venta_item, parent, false);
        return new PuntoVentaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PuntoVentaViewHolder holder, int position) {
        holder.txtNombrePlace.setText(mPlaces.get(position).getName().toString());
        holder.txtDireccionPlace.setText(mPlaces.get(position).getAddress().toString());

        holder.setmItemPVClickListener(new ItemPV_ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(mContext, MapsActivity.class);
                intent.putExtra("latlong",mPlaces.get(position).getLatLng());
                intent.putExtra("namePlace", mPlaces.get(position).getName().toString());
                intent.putExtra("placeId",mPlaces.get(position).getId().toString());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(mPlaces==null){
            return 0;
        }else{
            return mPlaces.getCount();
        }
    }

    public void swapPVs(PlaceBuffer pvs){
        mPlaces = pvs;
        if(mPlaces!=null){
            this.notifyDataSetChanged();
        }
    }

    class PuntoVentaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txtNombrePlace;
        TextView txtDireccionPlace;
        private ItemPV_ClickListener mItemPVClickListener;

        public PuntoVentaViewHolder(View itemView) {
            super(itemView);
            txtNombrePlace = (TextView) itemView.findViewById(R.id.txt_nombre_place);
            txtDireccionPlace = (TextView) itemView.findViewById(R.id.txt_direccion_place);

            itemView.setOnClickListener(this);
        }

        public void setmItemPVClickListener(ItemPV_ClickListener clickListener){
            this.mItemPVClickListener = clickListener;
        }

        @Override
        public void onClick(View view) {
            mItemPVClickListener.onClick(view, getAdapterPosition());
        }

    }
}
