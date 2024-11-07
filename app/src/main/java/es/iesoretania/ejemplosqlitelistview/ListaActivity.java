package es.iesoretania.ejemplosqlitelistview;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import es.iesoretania.ejemplosqlitelistview.databinding.ActivityListaBinding;

public class ListaActivity extends AppCompatActivity {
    private ActivityListaBinding binding;
    List<Articulo> milistaarticulos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getReadableDatabase();

        Cursor cursor = null;
        milistaarticulos = new ArrayList<>();
        try {
            // Realizar la consulta a la base de datos
            cursor = BaseDeDatos.rawQuery("SELECT * FROM articulos", null);
            if (cursor.moveToFirst()) {
                do {
                    // Obtener los valores de cada columna
                    int codigo = cursor.getInt(0);
                    String producto = cursor.getString(1);
                    double precio = cursor.getDouble(2);
                    // Crear un objeto Articulo y agregarlo a la lista
                    milistaarticulos.add(new Articulo(codigo, producto, precio));
                } while (cursor.moveToNext());
            }
        } finally {
            // Cerrar el cursor y la base de datos
            if (cursor != null) cursor.close();
            BaseDeDatos.close();
        }

        // Configurar el adaptador y la lista
        MiAdaptadorArticulo miadaptador = new MiAdaptadorArticulo(this,
                R.layout.articulos_item, milistaarticulos);
        binding.lvLista.setAdapter(miadaptador);
    }
}
