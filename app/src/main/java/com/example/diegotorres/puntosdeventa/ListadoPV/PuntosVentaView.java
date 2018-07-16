package com.example.diegotorres.puntosdeventa.ListadoPV;

import com.google.android.gms.location.places.PlaceBuffer;

import java.util.List;

/**
 * Created by Diego Torres on 12/07/2018.
 */

public interface PuntosVentaView {
    public void setPresenter(PuntosVentaPresenter presenter);
    public void listarPVs(List<String> placesIDs);
}
