package com.example.subastapublica;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static String PACKAGE_NAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PACKAGE_NAME = getApplicationContext().getPackageName();


        ArrayList<ListaEmpresas> words = new ArrayList<ListaEmpresas>();

        String filepath = getFilesDir().getPath().toString();
        words.add(new ListaEmpresas("IAG.MC", filepath));
        words.add(new ListaEmpresas("APPS.MC", filepath));
        words.add(new ListaEmpresas("MAP.MC", filepath));
        words.add(new ListaEmpresas("ANA.MC", filepath));
        words.add(new ListaEmpresas("ELE.MC", filepath));
        words.add(new ListaEmpresas("FAE.MC", filepath));


        ListaAdapter itemsAdapter = new ListaAdapter(this, words);
        ListView lv = (ListView) findViewById(R.id.listofwords);
        lv.setAdapter(itemsAdapter);

    }

    public void ReturnGmail(View view){

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, "a904346@alumni.unav.es");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Hey tio");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


}