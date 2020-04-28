package com.example.subastapublica;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;

import java.io.File;

public class ListaEmpresas{

    private String mtitulo;
    private String mpath;

    public ListaEmpresas(String titulo,String path){
        mpath=path;
        mtitulo=titulo;
    }

    public Bitmap callPy(String url,String path) {

        String filePath = path.toString();

        Python py = Python.getInstance();
        PyObject pyfile = py.getModule("getgraphAttr");
        PyObject textito = pyfile.callAttr("callit",url,filePath);

        File imgFile = new File(filePath+url.toString()+".png");
        Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

        return myBitmap;

    }

    public String getMtitulo(){
        return mtitulo;
    }
    public String getPath(){
        return mpath;
    }

    public String getimgid(String s){
        return s.substring(0,s.indexOf(".")).toLowerCase();
    }



}
