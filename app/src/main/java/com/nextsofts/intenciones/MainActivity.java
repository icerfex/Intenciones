package com.nextsofts.intenciones;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /*este metodo va a ser asignado a un atributo onclick de un objrto View para que luego de una accion al boton
    * ejecute este metodo, abriendo una pagina web*/
    public void pgweb(View v) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.androidcurso.com/"));
        startActivity(i);
    }

    public void llamadaTelefonica(View v) {
        Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:68537981"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(i);
    }
    public void googleMaps(View v){
        Intent i=new Intent(Intent.ACTION_VIEW,Uri.parse("geo:41.643454,-0.345456"));
        startActivity(i);
    }
    public void tomarFoto(View v){
        Intent i=new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(i);
    }
    public void mandarCorreo(View v){
        Intent i=new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT,"asunto");
        i.putExtra(Intent.EXTRA_TEXT,"texto del correo");
        i.putExtra(Intent.EXTRA_EMAIL,new String[]{"icerfex@gmail.com"});
        startActivity(i);
    }
}
