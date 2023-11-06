package es.iesoretania.ejemplosqlitelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MiAdaptadorArticulo extends ArrayAdapter {
    private Context ctx;
    private int layoutTemplate;
    private List<Articulo> articulolist;

    public MiAdaptadorArticulo(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.layoutTemplate = resource;
        this.articulolist = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layoutTemplate,parent,false);

        Articulo elementoActual = articulolist.get(position);

        TextView textviewproducto = (TextView)v.findViewById(R.id.textViewproducto);
        TextView textviewprecio = (TextView)v.findViewById(R.id.textViewprecio);

        textviewproducto.setText(elementoActual.getProducto());
        textviewprecio.setText(elementoActual.getPrecio());

        return v;
    }
}
