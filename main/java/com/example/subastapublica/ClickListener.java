package com.example.subastapublica;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ClickListener implements View.OnClickListener {

    public static String letittle;

    String mtittle;
    public ClickListener(String tittle){
        this.mtittle=tittle;
    }
    @Override
    public void onClick(View view){

        Intent n = new Intent(view.getContext(),IntentGraph.class);
        letittle=this.mtittle;
        view.getContext().startActivity(n);


    }
}
