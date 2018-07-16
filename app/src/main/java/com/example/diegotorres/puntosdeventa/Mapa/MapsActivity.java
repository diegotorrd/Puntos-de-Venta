package com.example.diegotorres.puntosdeventa.Mapa;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.diegotorres.puntosdeventa.ListadoProductos.ProductosActivity;
import com.example.diegotorres.puntosdeventa.R;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng mLatLng;
    private String mNamePlace;
    private String mPlaceId;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mContext = this;
        mLatLng = getIntent().getExtras().getParcelable("latlong");
        mNamePlace = getIntent().getStringExtra("namePlace");
        mPlaceId = getIntent().getStringExtra("placeId");
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Intent intent = new Intent(mContext, ProductosActivity.class);
                intent.putExtra("placeId", mPlaceId);
                mContext.startActivity(intent);
                return false;
            }
        });

        // Add a marker in Sydney and move the camera
        Marker marker = mMap.addMarker(new MarkerOptions().position(mLatLng).title("Punto de Venta: "+ mNamePlace));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mLatLng, 17));
    }
}
