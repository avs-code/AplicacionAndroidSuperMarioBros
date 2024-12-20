package vicentesantos.antonio.ui.detallespersonaje;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import vicentesantos.antonio.R;
import vicentesantos.antonio.model.Personaje;

public class DetallesPersonajeFragment extends Fragment {

    private ImageView personajeImagenGrande;
    private TextView personajeNombre;
    private TextView personajeDescripcion;
    private TextView personajeCaracteristicas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalles_personaje, container, false);

        personajeImagenGrande = view.findViewById(R.id.personaje_imagen_grande);
        personajeNombre = view.findViewById(R.id.personaje_nombre);
        personajeDescripcion = view.findViewById(R.id.personaje_descripcion);
        personajeCaracteristicas = view.findViewById(R.id.personaje_caracteristicas);

        if (getArguments() != null) {
            Personaje personaje = (Personaje) getArguments().getSerializable("personaje", Personaje.class);
            if (personaje != null) {
                personajeImagenGrande.setImageResource(personaje.getImagenId());
                personajeNombre.setText(personaje.getNombre());
                personajeDescripcion.setText(personaje.getDescripcion());
                personajeCaracteristicas.setText(personaje.getCaracteristicas());
            }
        }

        return view;
    }
}