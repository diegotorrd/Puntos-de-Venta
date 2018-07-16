package com.example.diegotorres.puntosdeventa.ListadoPV;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.diegotorres.puntosdeventa.Adapter.PuntosVentaAdapter;
import com.example.diegotorres.puntosdeventa.R;
import com.example.diegotorres.puntosdeventa.bd.BD_OpenHelper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.Places;

import java.util.List;

public class PuntosVentaActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, PuntosVentaView{

    public static String TAG = PuntosVentaActivity.class.getName();
    private GoogleApiClient mGoogleApiClient;
    private RecyclerView mRecyclerView;
    private PuntosVentaAdapter mAdapter;
    private PuntosVentaPresenter mPresenter;
    private BD_OpenHelper openHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntos_venta);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_puntos_venta);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new PuntosVentaAdapter(this, null);
        mRecyclerView.setAdapter(mAdapter);

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .addApi(Places.GEO_DATA_API)
                .enableAutoManage(this, this)
                .build();


        setPresenter(new PuntosVentaPresenterImp(this));
        openHelper = new BD_OpenHelper(this);
        mPresenter.obtenerListaPVs(openHelper);
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Log.i(TAG,"Api client se conectó exitosamente");
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i(TAG,"Conexión api client suspendida");
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.e(TAG,"Falló la conexión con el API client");
    }

    @Override
    public void setPresenter(PuntosVentaPresenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void listarPVs(List<String> placesIDs) {
        PendingResult<PlaceBuffer> pendingResult = Places.GeoDataApi.getPlaceById(
                mGoogleApiClient, placesIDs.toArray(new String[placesIDs.size()]));

        pendingResult.setResultCallback(new ResultCallback<PlaceBuffer>() {
            @Override
            public void onResult(@NonNull PlaceBuffer places) {
                mAdapter.swapPVs(places);
            }
        });
    }
}
