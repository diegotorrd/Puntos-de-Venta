package com.example.diegotorres.puntosdeventa.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.diegotorres.puntosdeventa.Beans.Producto;
import com.example.diegotorres.puntosdeventa.Beans.Usuario;
import com.example.diegotorres.puntosdeventa.bd.BD_contract.PuntoVentaEntry;
import com.example.diegotorres.puntosdeventa.bd.BD_contract.UsuarioEntry;
import com.example.diegotorres.puntosdeventa.bd.BD_contract.ProductoEntry;
import com.example.diegotorres.puntosdeventa.bd.BD_contract.PuntoVenta_ProductoEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diego Torres on 10/07/2018.
 */

public class BD_OpenHelper extends SQLiteOpenHelper {
    // The database name
    private static final String DATABASE_NAME = "puntos_venta.db";

    // If you change the database schema, you must increment the database version
    private static final int DATABASE_VERSION = 1;

    public BD_OpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryUsuario = "create table " + UsuarioEntry.TABLE_NAME + "(" +
                UsuarioEntry.COLUMN_USUARIO + " text primary key, " +
                UsuarioEntry.COLUMN_CONTRASEÑA + " text, " +
                UsuarioEntry.COLUMN_NOMBRE + " text, " +
                UsuarioEntry.COLUMN_AP_PATERNO + " text, " +
                UsuarioEntry.COLUMN_AP_MATERNO + " text, " +
                UsuarioEntry.COLUMN_EMAIL + " text " +
                ");";


        String queryPuntoVenta = "create table " + PuntoVentaEntry.TABLE_NAME + "(" +
                PuntoVentaEntry.COLUMN_PLACE_ID + " text PRIMARY KEY" +
                ");";

        String queryProducto = "create table " + ProductoEntry.TABLE_NAME + "(" +
                ProductoEntry.COLUMN_ID_PRODUCTO + " INTEGER PRIMARY KEY, " +
                ProductoEntry.COLUMN_DESCRIPCION + " text " +
                ");";

        String queryPV_Producto = "create table " + PuntoVenta_ProductoEntry.TABLE_NAME + "(" +
                PuntoVenta_ProductoEntry.COLUMN_ID_PV + " text, " +
                PuntoVenta_ProductoEntry.COLUMN_ID_PRODUCTO + " INTEGER, " +
                PuntoVenta_ProductoEntry.COLUMN_STOCK + " INTEGER " +
                ");";


        sqLiteDatabase.execSQL(queryUsuario);
        sqLiteDatabase.execSQL(queryPuntoVenta);
        sqLiteDatabase.execSQL(queryProducto);
        sqLiteDatabase.execSQL(queryPV_Producto);

        //crea data dummy
        //puntos de venta
        ContentValues pv1 = new ContentValues();
        ContentValues pv2 = new ContentValues();
        ContentValues pv3 = new ContentValues();
        ContentValues pv4 = new ContentValues();
        pv1.put(PuntoVentaEntry.COLUMN_PLACE_ID, "ChIJl3QgU4_FBZER7tuzVp0Uxr4");
        pv2.put(PuntoVentaEntry.COLUMN_PLACE_ID, "ChIJqyeDnbLHBZERNpbjq8XeoVM");
        pv3.put(PuntoVentaEntry.COLUMN_PLACE_ID, "ChIJhSjwtrfIBZERVcXAIWytglU");
        pv4.put(PuntoVentaEntry.COLUMN_PLACE_ID, "ChIJwbKXOBTIBZERln0A9E9sf7c");

        //productos
        ContentValues pd1 = new ContentValues();
        ContentValues pd2 = new ContentValues();
        ContentValues pd3 = new ContentValues();
        ContentValues pd4 = new ContentValues();
        pd1.put(ProductoEntry.COLUMN_DESCRIPCION, "Colgate Doble Frescura");
        pd1.put(ProductoEntry.COLUMN_ID_PRODUCTO, 1);
        pd2.put(ProductoEntry.COLUMN_DESCRIPCION, "Colgate Sensitive Pro-Alivio");
        pd2.put(ProductoEntry.COLUMN_ID_PRODUCTO, 2);
        pd3.put(ProductoEntry.COLUMN_DESCRIPCION, "Colgate Luminous White");
        pd3.put(ProductoEntry.COLUMN_ID_PRODUCTO, 3);
        pd4.put(ProductoEntry.COLUMN_DESCRIPCION, "Colgate Total 12");
        pd4.put(ProductoEntry.COLUMN_ID_PRODUCTO, 4);

        //PV_PRODUCTOS
        ContentValues pv1pd1 = new ContentValues();
        ContentValues pv1pd2 = new ContentValues();
        ContentValues pv1pd3 = new ContentValues();
        ContentValues pv1pd4 = new ContentValues();
        pv1pd1.put(PuntoVenta_ProductoEntry.COLUMN_ID_PV,"ChIJl3QgU4_FBZER7tuzVp0Uxr4");
        pv1pd1.put(PuntoVenta_ProductoEntry.COLUMN_ID_PRODUCTO,1);
        pv1pd1.put(PuntoVenta_ProductoEntry.COLUMN_STOCK,0);
        pv1pd2.put(PuntoVenta_ProductoEntry.COLUMN_ID_PV,"ChIJl3QgU4_FBZER7tuzVp0Uxr4");
        pv1pd2.put(PuntoVenta_ProductoEntry.COLUMN_ID_PRODUCTO,2);
        pv1pd2.put(PuntoVenta_ProductoEntry.COLUMN_STOCK,0);
        pv1pd3.put(PuntoVenta_ProductoEntry.COLUMN_ID_PV,"ChIJl3QgU4_FBZER7tuzVp0Uxr4");
        pv1pd3.put(PuntoVenta_ProductoEntry.COLUMN_ID_PRODUCTO,3);
        pv1pd3.put(PuntoVenta_ProductoEntry.COLUMN_STOCK,0);
        pv1pd4.put(PuntoVenta_ProductoEntry.COLUMN_ID_PV,"ChIJl3QgU4_FBZER7tuzVp0Uxr4");
        pv1pd4.put(PuntoVenta_ProductoEntry.COLUMN_ID_PRODUCTO,4);
        pv1pd4.put(PuntoVenta_ProductoEntry.COLUMN_STOCK,0);

        ContentValues pv2pd1 = new ContentValues();
        ContentValues pv2pd2 = new ContentValues();
        ContentValues pv2pd3 = new ContentValues();
        ContentValues pv2pd4 = new ContentValues();
        pv2pd1.put(PuntoVenta_ProductoEntry.COLUMN_ID_PV,"ChIJqyeDnbLHBZERNpbjq8XeoVM");
        pv2pd1.put(PuntoVenta_ProductoEntry.COLUMN_ID_PRODUCTO,1);
        pv2pd1.put(PuntoVenta_ProductoEntry.COLUMN_STOCK,0);
        pv2pd2.put(PuntoVenta_ProductoEntry.COLUMN_ID_PV,"ChIJqyeDnbLHBZERNpbjq8XeoVM");
        pv2pd2.put(PuntoVenta_ProductoEntry.COLUMN_ID_PRODUCTO,2);
        pv2pd2.put(PuntoVenta_ProductoEntry.COLUMN_STOCK,0);
        pv2pd3.put(PuntoVenta_ProductoEntry.COLUMN_ID_PV,"ChIJqyeDnbLHBZERNpbjq8XeoVM");
        pv2pd3.put(PuntoVenta_ProductoEntry.COLUMN_ID_PRODUCTO,3);
        pv2pd3.put(PuntoVenta_ProductoEntry.COLUMN_STOCK,0);
        pv2pd4.put(PuntoVenta_ProductoEntry.COLUMN_ID_PV,"ChIJqyeDnbLHBZERNpbjq8XeoVM");
        pv2pd4.put(PuntoVenta_ProductoEntry.COLUMN_ID_PRODUCTO,4);
        pv2pd4.put(PuntoVenta_ProductoEntry.COLUMN_STOCK,0);

        ContentValues pv3pd1 = new ContentValues();
        ContentValues pv3pd2 = new ContentValues();
        pv3pd1.put(PuntoVenta_ProductoEntry.COLUMN_ID_PV,"ChIJhSjwtrfIBZERVcXAIWytglU");
        pv3pd1.put(PuntoVenta_ProductoEntry.COLUMN_ID_PRODUCTO,1);
        pv3pd1.put(PuntoVenta_ProductoEntry.COLUMN_STOCK,0);
        pv3pd2.put(PuntoVenta_ProductoEntry.COLUMN_ID_PV,"ChIJhSjwtrfIBZERVcXAIWytglU");
        pv3pd2.put(PuntoVenta_ProductoEntry.COLUMN_ID_PRODUCTO,2);
        pv3pd2.put(PuntoVenta_ProductoEntry.COLUMN_STOCK,0);

        ContentValues pv4pd2 = new ContentValues();
        ContentValues pv4pd3 = new ContentValues();
        ContentValues pv4pd4 = new ContentValues();
        pv4pd2.put(PuntoVenta_ProductoEntry.COLUMN_ID_PV,"ChIJwbKXOBTIBZERln0A9E9sf7c");
        pv4pd2.put(PuntoVenta_ProductoEntry.COLUMN_ID_PRODUCTO,2);
        pv4pd2.put(PuntoVenta_ProductoEntry.COLUMN_STOCK,0);
        pv4pd3.put(PuntoVenta_ProductoEntry.COLUMN_ID_PV,"ChIJwbKXOBTIBZERln0A9E9sf7c");
        pv4pd3.put(PuntoVenta_ProductoEntry.COLUMN_ID_PRODUCTO,3);
        pv4pd3.put(PuntoVenta_ProductoEntry.COLUMN_STOCK,0);
        pv4pd4.put(PuntoVenta_ProductoEntry.COLUMN_ID_PV,"ChIJwbKXOBTIBZERln0A9E9sf7c");
        pv4pd4.put(PuntoVenta_ProductoEntry.COLUMN_ID_PRODUCTO,4);
        pv4pd4.put(PuntoVenta_ProductoEntry.COLUMN_STOCK,0);

        //INSERTS
        sqLiteDatabase.insert(PuntoVentaEntry.TABLE_NAME,null,pv1);
        sqLiteDatabase.insert(PuntoVentaEntry.TABLE_NAME,null,pv2);
        sqLiteDatabase.insert(PuntoVentaEntry.TABLE_NAME,null,pv3);
        sqLiteDatabase.insert(PuntoVentaEntry.TABLE_NAME,null,pv4);

        sqLiteDatabase.insert(ProductoEntry.TABLE_NAME,null,pd1);
        sqLiteDatabase.insert(ProductoEntry.TABLE_NAME,null,pd2);
        sqLiteDatabase.insert(ProductoEntry.TABLE_NAME,null,pd3);
        sqLiteDatabase.insert(ProductoEntry.TABLE_NAME,null,pd4);

        sqLiteDatabase.insert(PuntoVenta_ProductoEntry.TABLE_NAME,null,pv1pd1);
        sqLiteDatabase.insert(PuntoVenta_ProductoEntry.TABLE_NAME,null,pv1pd2);
        sqLiteDatabase.insert(PuntoVenta_ProductoEntry.TABLE_NAME,null,pv1pd3);
        sqLiteDatabase.insert(PuntoVenta_ProductoEntry.TABLE_NAME,null,pv1pd4);
        sqLiteDatabase.insert(PuntoVenta_ProductoEntry.TABLE_NAME,null,pv2pd1);
        sqLiteDatabase.insert(PuntoVenta_ProductoEntry.TABLE_NAME,null,pv2pd2);
        sqLiteDatabase.insert(PuntoVenta_ProductoEntry.TABLE_NAME,null,pv2pd3);
        sqLiteDatabase.insert(PuntoVenta_ProductoEntry.TABLE_NAME,null,pv2pd4);
        sqLiteDatabase.insert(PuntoVenta_ProductoEntry.TABLE_NAME,null,pv3pd1);
        sqLiteDatabase.insert(PuntoVenta_ProductoEntry.TABLE_NAME,null,pv3pd2);
        sqLiteDatabase.insert(PuntoVenta_ProductoEntry.TABLE_NAME,null,pv4pd2);
        sqLiteDatabase.insert(PuntoVenta_ProductoEntry.TABLE_NAME,null,pv4pd3);
        sqLiteDatabase.insert(PuntoVenta_ProductoEntry.TABLE_NAME,null,pv4pd4);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void abrirBD(){
        this.getReadableDatabase();
    }

    public void cerrarBD(){
        this.close();
    }

    public long insertarRegistro(String table, ContentValues contentValues){
        this.abrirBD();
        long result = this.getWritableDatabase().insert(table,null, contentValues);
        this.cerrarBD();
        return result;
    }

    public Usuario consultarUsuario(String usuario, String contraseña){
        Usuario usuRes = new Usuario();
        this.abrirBD();
        SQLiteDatabase db = this.getReadableDatabase();
        String  query = "Select " +
                UsuarioEntry.COLUMN_USUARIO + ", " +
                UsuarioEntry.COLUMN_NOMBRE + ", " +
                UsuarioEntry.COLUMN_AP_PATERNO + ", " +
                UsuarioEntry.COLUMN_AP_MATERNO + ", " +
                UsuarioEntry.COLUMN_EMAIL + " from " +
                UsuarioEntry.TABLE_NAME + " where " +
                UsuarioEntry.COLUMN_USUARIO + "= ? and " +
                UsuarioEntry.COLUMN_CONTRASEÑA + "= ?";

        Cursor c = db.rawQuery(query, new String[] {usuario, contraseña});

        if(c.moveToNext()){
            usuRes.setUsuario(c.getString(0));
            usuRes.setNombre(c.getString(1));
            usuRes.setAp_paterno(c.getString(2));
            usuRes.setAp_materno(c.getString(3));
            usuRes.setEmail(c.getString(4));

        }else{
            usuRes = null;
        }

        this.cerrarBD();

        return usuRes;
    }

    public List<String> getPlaceIDs(){
        List<String> ids = new ArrayList<>();
        this.abrirBD();
        SQLiteDatabase db = this.getReadableDatabase();
        String  query = "Select " +
                PuntoVentaEntry.COLUMN_PLACE_ID + " from " +
                PuntoVentaEntry.TABLE_NAME + " order by "+
                PuntoVentaEntry.COLUMN_PLACE_ID;

        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()){
            ids.add(cursor.getString(0));
        }

        this.cerrarBD();
        return ids;
    }

    public List<Producto> getProductosByPlace(String placeId){
        List<Producto> prods = new ArrayList<>();
        Producto prod;
        this.abrirBD();
        SQLiteDatabase db = this.getReadableDatabase();
        String  query = "Select a.id_producto, a.descripcion, b.stock " +
                " from " + ProductoEntry.TABLE_NAME + " a inner join " +
                PuntoVenta_ProductoEntry.TABLE_NAME + " b "+
                " on a.id_producto =b.id_producto " +
                " where b.id_pv = ?";

        Cursor cursor = db.rawQuery(query, new String[] {placeId});
        while (cursor.moveToNext()){
            prod = new Producto();
            prod.setId(Integer.parseInt(cursor.getString(0)));
            prod.setDescripcion(cursor.getString(1));
            prod.setStock(Integer.parseInt(cursor.getString(2)));
            prods.add(prod);
        }

        this.cerrarBD();
        return prods;
    }

    public int updateStock(String placeId, int productoId, int stock){
        ContentValues cv = new ContentValues();
        cv.put(PuntoVenta_ProductoEntry.COLUMN_STOCK, stock);
        String idPr = String.valueOf(productoId);
        int res;
        this.abrirBD();
        SQLiteDatabase db = this.getWritableDatabase();
        res = db.update(PuntoVenta_ProductoEntry.TABLE_NAME, cv,
                "id_pv = ? AND id_producto = ?", new String[]{placeId,idPr});
        this.cerrarBD();
        return res;
    }
}
