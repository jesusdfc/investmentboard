package com.example.subastapublica;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListaAdapter extends ArrayAdapter<ListaEmpresas> {



    public ListaAdapter(Activity context, ArrayList<ListaEmpresas> itemsAdapter){
        super(context,0,itemsAdapter);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.listaempresas, parent, false);
        }

        // Get the {@link ListaEmpresas} object located at this position in the list
        ListaEmpresas currentEmpresa = getItem(position);

        TextView titulo = (TextView) listItemView.findViewById(R.id.titulo);

        titulo.setText(currentEmpresa.getMtitulo());

        // Find the ImageView in the archivos_web.xml layout with the ID list_grafica
        ImageView grafica = (ImageView) listItemView.findViewById(R.id.list_grafica);

        // Get the image resource ID from the current Listaempresas object and
        // set the image to grafica

        int resId=getContext().getResources().getIdentifier(currentEmpresa.getimgid(currentEmpresa.getMtitulo()), "drawable", MainActivity.PACKAGE_NAME);
        grafica.setImageResource(resId);

        ClickListener click = new ClickListener(currentEmpresa.getMtitulo());
        titulo.setOnClickListener(click);

        // Return the whole list item layout (containing an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
