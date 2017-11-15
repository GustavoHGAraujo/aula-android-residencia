package com.gustavogoma.aulas.spinner;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by gustavo on 11/15/17.
 */

public class Adapter extends ArrayAdapter<Usuario> {

    // Layout de cada item
    private static final int resource = R.layout.item_usuario;

    // O Construtor é obrigatório pois precisamos chamar o construtor da classe ArrayAdapter
    public Adapter(@NonNull Context context, @NonNull List<Usuario> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    // Esse método é responsável pro inflar e aplicar o dado de cada item em uma View
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null){ // Se a view estiver nula, precisamos inflar o layout
            // Aqui inflamos o layout criado e salvamos em View
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(resource, null);
        }

        Usuario u = getItem(position); // Pega o usuário da posição atual

        // Pegamos os componentes que queremos alterar e que estão dentro do layout
        TextView idUsuario = (TextView) view.findViewById(R.id.id_usuario);
        TextView nomeUsuario = (TextView) view.findViewById(R.id.nome_usuario);

        // Colocamos os valores dentro dos componentes
        String id = String.format("#%d", u.getId()); // Formata o id no formado "#0"

        idUsuario.setText(id);
        nomeUsuario.setText(u.getNome());

        return view; // retorna a View que inflamos e configuramos
    }

    @Override
    //Quando é necessário aparecer todas as opções, devemos fazer a mesma coisa que no getView
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getView(position, convertView, parent);
    }
}
