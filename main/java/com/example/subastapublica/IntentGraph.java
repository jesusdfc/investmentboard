package com.example.subastapublica;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;

import java.io.File;

public class IntentGraph extends AppCompatActivity {

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_graph);

        callPy(ClickListener.letittle);

    }


    public void callPy(String str) {


        String filePath = getFilesDir().getPath();

        if (!fileExists(this,str+".png")){

        Python py = Python.getInstance();
        PyObject pyfile = py.getModule("getgraphAttr");
        PyObject textito = pyfile.callAttr("callit",str,filePath);
        }

        ImageView grafica = findViewById(R.id.intentgraph);

        File imgFile = new File(getFilesDir().getPath()+'/'+str+".png");
        Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

        grafica.setImageBitmap(myBitmap);


    }

    public boolean fileExists(Context context, String filename) {
        File file = context.getFileStreamPath(filename);
        if(file == null || !file.exists()) {
            return false;
        }
        return true;
    }
}


