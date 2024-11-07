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

public class MiAdaptadorArticulo extends ArrayAdapter<Articulo> {
    private final Context ctx;
    private final int layoutTemplate;
    private final List<Articulo> articulolist;

    public MiAdaptadorArticulo(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.layoutTemplate = resource;
        this.articulolist = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;
        if (v == null) {
            v = LayoutInflater.from(ctx).inflate(layoutTemplate, parent, false);
        }

        // Obtener el elemento actual de la lista
        Articulo elementoActual = articulolist.get(position);

        // Configurar los elementos de la vista con los datos del elemento actual
        TextView textviewproducto = v.findViewById(R.id.textViewproducto);
        TextView textviewprecio = v.findViewById(R.id.textViewprecio);

        // Establecer los valores en los elementos de la vista
        textviewproducto.setText(elementoActual.getProducto());
        textviewprecio.setText(String.valueOf(elementoActual.getPrecio()));

        return v;
    }
}
