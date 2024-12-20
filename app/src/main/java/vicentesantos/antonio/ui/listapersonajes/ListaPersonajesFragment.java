package vicentesantos.antonio.ui.listapersonajes;
// Importamos las librerias necesarias

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
// Importamos las utilidades ArrayList y List de Java
import java.util.ArrayList;
import java.util.List;
// Importamos el adaptador y el modelo de personaje
import vicentesantos.antonio.R;
import vicentesantos.antonio.adapter.PersonajeAdapter;
import vicentesantos.antonio.model.Personaje;

// Clase Fragment de ListaPersonajes
public class ListaPersonajesFragment extends Fragment {

    // Atributos de la clase Fragment de ListaPersonajes que son un RecyclerView y un PersonajeAdapter
    private RecyclerView recyclerView;
    private PersonajeAdapter adapter;

    @Nullable
    @Override
    // Método que crea la vista del fragment y devuelve la vista creada con el RecyclerView y el adaptador de personajes con la lista de personajes
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lista_personajes_fragment, container, false);

        // Inicializamos el RecyclerView y le asignamos un LayoutManager y un adaptador con la lista de personajes creada en el método onCreate
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Creamos una lista de personajes y añadimos los personajes a la lista
        List<Personaje> characterList = new ArrayList<>();
        // Añadimos los personajes a la lista de personajes con su nombre, su imagen, su descripción y sus características correspondientes
        characterList.add(new Personaje("Mario", R.drawable.mario, "El héroe principal del Reino Champiñón. Mario es muy positivo y siempre está alegre. Lo podrás reconocer por sus overoles de color azul, su gorra roja y su característico bigote.\n" +
                "\n" +
                "La princesa Peach lo considera su amigo de confianza, y todo el mundo los conoce a él y a su hermano Luigi por sus actos de valentía.", "Mario se destaca en deportes como tenis, golf, béisbol, fútbol y hasta en las carreras de karts. ¡Es bueno en todos los deportes! Es plomero de profesión, pero la verdad es que es un experto en todos los oficios.\n" +
                "\n" +
                "Mario utiliza su poderosa habilidad para saltar y una gran cantidad de mejoras para enfrentarse a su archienemigo, Bowser."));
        characterList.add(new Personaje("Luigi", R.drawable.luigi, "Luigi es amable, pero un poco de nervioso, especialmente si hay fantasmas por ahí. Sin embargo, sus habilidades igualan las habilidades de Mario, así que cuando estos hermanos se unen, no hay nada que no puedan lograr.", "Luigi es más alto y puede saltar más alto que Mario. Si pones atención, también podrás notar que la forma de su bigote también es un poco diferente."));
        characterList.add(new Personaje("Peach", R.drawable.peach, "La querida princesa del Reino Champiñón. Es extremadamente amable y siempre está trabajando para crear un mundo en el que todos puedan convivir juntos y felices. Su famoso vestido color rosa es encantador.\n" +
                "\n" +
                "La princesa Peach siempre está lista para participar en una gran variedad de deportes, y también le encanta hornear y cocinar.", "Ella y Mario son muy buenos amigos y siempre están dispuestos a ayudarse mutuamente cuando pueden."));
        characterList.add(new Personaje("Toad", R.drawable.toad, "Residente del Reino Champiñón, trabaja al servicio de la Princesa Peach. Toad tiene manchas rojas en la cabeza, aunque otros de su especie vienen en una variedad de colores.", "Toad es muy alegre y leal. Hace todo lo posible por ayudar a Mario y a Luigi en sus esfuerzos por proteger el Reino Champiñón de Bowser, incluso si eso significa enfrentarse al peligro durante en el proceso."));

        // Creamos un adaptador de personajes con la lista de personajes y un listener
        adapter = new PersonajeAdapter(characterList, personaje -> {
            Bundle bundle = new Bundle();
            bundle.putSerializable("personaje", personaje);
            // Navegamos al fragment de DetallesPersonaje con el personaje seleccionado
            Navigation.findNavController(view).navigate(R.id.action_nav_character_list_to_nav_detalles_personaje, bundle);
        });
        // Asignamos el adaptador al RecyclerView
        recyclerView.setAdapter(adapter);

        return view;
    }
}