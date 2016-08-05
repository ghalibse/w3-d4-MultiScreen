package com.example.simpledoublefragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class LeftFragment extends Fragment {

    private CallbackComponent mCallbackComponent;

    private ListView mListView;

    private NamesAdapter arrayAdapter;

    private ArrayList<Student> students;


    private String dataJSON = "[{\"name\":\"Juan\",\"age\":20,\"grade\":8.1},{\"name\":\"Miguel\",\"age\":23,\"grade\":8.3},{\"name\":\"Roberto\",\"age\":39,\"grade\":9.3},{\"name\":\"Luis\",\"age\":19,\"grade\":6.9},{\"name\":\"Gaudencio\",\"age\":25,\"grade\":4.3}]";

    interface CallbackComponent {
        void itemClicked(int name);
    }

    public LeftFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallbackComponent = (CallbackComponent) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_left, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mListView = (ListView) view.findViewById(R.id.rf_list_view);

        Type listType = new TypeToken<List<Student>>() {
        }.getType();
        Gson gson = new GsonBuilder().create();

        students = gson.fromJson(dataJSON, listType);

        arrayAdapter = new NamesAdapter(getContext(), students);

        mListView.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Student aStudent =  arrayAdapter.getItem(i);
                Toast.makeText(getContext(), aStudent.name.toUpperCase(), Toast.LENGTH_SHORT).show();
                mCallbackComponent.itemClicked(i);
            }
        });

    }
}
