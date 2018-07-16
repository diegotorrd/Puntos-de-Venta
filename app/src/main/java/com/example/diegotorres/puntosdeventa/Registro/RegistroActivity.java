package com.example.diegotorres.puntosdeventa.Registro;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diegotorres.puntosdeventa.Beans.Usuario;
import com.example.diegotorres.puntosdeventa.Login.LoginActivity;
import com.example.diegotorres.puntosdeventa.R;
import com.example.diegotorres.puntosdeventa.bd.BD_OpenHelper;

public class RegistroActivity extends AppCompatActivity implements RegistroView {
    public static final String TAG = RegistroActivity.class.getName();
    private RegistroPresenter mPresenter;
    private ProgressDialog mDialog;
    private TextInputEditText txtUsuario,txtContraseña, txtNombre, txtAp_paterno, txtAp_materno, txtEmail;
    private BD_OpenHelper openHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        openHelper = new BD_OpenHelper(this);
    }

    public void onRegistrarClick(View view){

        txtUsuario = (TextInputEditText) findViewById(R.id.txtUsuario_registro);
        txtContraseña = (TextInputEditText) findViewById(R.id.txtContraseña_registro);
        txtNombre = (TextInputEditText) findViewById(R.id.txtNombre_registro);
        txtAp_paterno = (TextInputEditText) findViewById(R.id.txtApPaterno_registro);
        txtAp_materno = (TextInputEditText) findViewById(R.id.txtApMaterno_registro);
        txtEmail = (TextInputEditText) findViewById(R.id.txtEmail_registro);

        Usuario usuario = new Usuario();
        usuario.setUsuario(txtUsuario.getText().toString());
        usuario.setContraseña(txtContraseña.getText().toString());
        usuario.setNombre(txtNombre.getText().toString());
        usuario.setAp_paterno(txtAp_paterno.getText().toString());
        usuario.setAp_materno(txtAp_materno.getText().toString());
        usuario.setEmail(txtEmail.getText().toString());


        setPresenter(new RegistroPresenterImpl(this));
        mPresenter.registrarUsuario(usuario, openHelper);

    }

    @Override
    public void setPresenter(RegistroPresenter presenter) {
        this.mPresenter=presenter;
    }

    @Override
    public void callActivity(long resp) {
        Log.i(TAG, "La respuesta es: " + resp);
        //Resultado -1 significa error al insertar
        if(resp == -1){
            Toast.makeText(this, "No se pudo registrar el usuario, intente nuevamente", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Usuario registrado correctamente", Toast.LENGTH_LONG).show();
//            Intent intent = new Intent(this, LoginActivity.class);
//            startActivity(intent);
            this.finish();
        }

    }
}
