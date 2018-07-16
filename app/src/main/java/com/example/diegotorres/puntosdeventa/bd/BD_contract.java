package com.example.diegotorres.puntosdeventa.bd;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Diego Torres on 10/07/2018.
 */

public class BD_contract {

    public static class UsuarioEntry implements BaseColumns{
        public static String TABLE_NAME = "usuario";
        public static String COLUMN_USUARIO = "usuario";
        public static String COLUMN_CONTRASEÑA = "contraseña";
        public static String COLUMN_NOMBRE = "nombre";
        public static String COLUMN_AP_PATERNO = "ap_paterno";
        public static String COLUMN_AP_MATERNO = "ap_materno";
        public static String COLUMN_EMAIL = "email";

    }

    public static class PuntoVentaEntry implements BaseColumns{
        public static String TABLE_NAME = "punto_venta";
        public static String COLUMN_PLACE_ID = "placeID";
    }

    public static class ProductoEntry implements BaseColumns{
        public static String TABLE_NAME = "producto";
        public static String COLUMN_ID_PRODUCTO = "id_producto";
        public static String COLUMN_DESCRIPCION = "descripcion";
    }

    public static class PuntoVenta_ProductoEntry implements BaseColumns{
        public static String TABLE_NAME = "punto_venta_producto";
        public static String COLUMN_ID_PV = "id_pv";
        public static String COLUMN_ID_PRODUCTO = "id_producto";
        public static String COLUMN_STOCK = "stock";
    }
}
