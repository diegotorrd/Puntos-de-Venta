package com.example.diegotorres.puntosdeventa.Login;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diegotorres.puntosdeventa.Beans.Usuario;
import com.example.diegotorres.puntosdeventa.ListadoPV.PuntosVentaActivity;
import com.example.diegotorres.puntosdeventa.R;
import com.example.diegotorres.puntosdeventa.Registro.RegistroActivity;
import com.example.diegotorres.puntosdeventa.bd.BD_OpenHelper;

public class LoginActivity extends AppCompatActivity implements LoginView{
    private LoginPresenter mPresenter;
    private TextInputEditText txtUsuario,txtContraseña;
    private BD_OpenHelper openHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtUsuario = (TextInputEditText) findViewById(R.id.txtUsuario);
        txtContraseña = (TextInputEditText) findViewById(R.id.txtContraseña);

        openHelper = new BD_OpenHelper(this);

        TextView link_registrar = (TextView) findViewById(R.id.linkRegistrar);
        SpannableString link = new SpannableString("Regístrate");
        link.setSpan(new UnderlineSpan(), 0, link.length(), 0);
        link_registrar.setText(link);

        setPresenter(new LoginPresenterImp(this));
    }

    public void onLinkRegistrar(View view){
        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);

    }

    public void onIngresarClick(View view){
        String usu = txtUsuario.getText().toString().trim();
        String psw = txtContraseña.getText().toString().trim();

        mPresenter.obtenerLogin(usu, psw, openHelper);

    }

    @Override
    public void setPresenter(LoginPresenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void callActivity(Usuario usuario) {
        if(usuario!=null){
            Toast.makeText(this, "Bienvenido "+ usuario.getNombre() + " " + usuario.getAp_paterno(), Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, PuntosVentaActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Usuario no identificado, por favor regístrese.", Toast.LENGTH_LONG).show();
        }
    }
}
