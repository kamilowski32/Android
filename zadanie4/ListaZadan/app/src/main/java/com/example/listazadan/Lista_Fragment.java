package com.example.listazadan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.fragment.app.ListFragment;

public class Lista_Fragment extends ListFragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lista_fragment, container, false);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Zadania, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        return view;
    }
}

