package vicentesantos.antonio.adapter;
// Importamos las clases necesarias para el adaptador

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
// Importamos la utilidad de lista
import java.util.List;
// Importamos la clase Personaje
import vicentesantos.antonio.R;
import vicentesantos.antonio.model.Personaje;

// La clase PersonajeAdapter extiende de RecyclerView.Adapter
public class PersonajeAdapter extends RecyclerView.Adapter<PersonajeAdapter.CharacterViewHolder> {

    // Atributos de la clase
    private List<Personaje> personajes;
    private OnItemClickListener listener;

    // Interfaz que define el método onItemClick
    public interface OnItemClickListener {
        void onItemClick(Personaje personaje);
    }

    // Constructor de la clase PersonajeAdapter
    public PersonajeAdapter(List<Personaje> personajes, OnItemClickListener listener) {
        this.personajes = personajes;
        this.listener = listener;
    }

    // Método que crea un nuevo CharacterViewHolder
    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_personaje, parent, false);
        return new CharacterViewHolder(view);
    }

    // Método que enlaza los datos con la vista
    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        Personaje personaje = personajes.get(position);
        holder.characterName.setText(personaje.getNombre());
        holder.characterImage.setImageResource(personaje.getImagenId());
        holder.itemView.setOnClickListener(v -> listener.onItemClick(personaje));
    }

    // Método que devuelve el número de elementos de la lista
    @Override
    public int getItemCount() {
        return personajes.size();
    }

    // Clase CharacterViewHolder
    static class CharacterViewHolder extends RecyclerView.ViewHolder {
        // Atributos de la clase, un ImageView y un TextView para mostrar la imagen y el nombre del personaje
        ImageView characterImage;
        TextView characterName;

        // Constructor
        public CharacterViewHolder(@NonNull View itemView) {
            // super(itemView) llama al constructor de la clase padre pasándole la vista characterImage y characterName
            super(itemView);
            characterImage = itemView.findViewById(R.id.character_image);
            characterName = itemView.findViewById(R.id.personaje_nombre);
        }
    }
}