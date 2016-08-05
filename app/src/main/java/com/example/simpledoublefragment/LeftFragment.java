package com.example.simpledoublefragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class LeftFragment extends Fragment {

    private static final String TAG = "LeftFragmentTAG_";
    private CallbackComponent mCallbackComponent;

    private ListView mListView;

    private NamesAdapter arrayAdapter;

    private ArrayList<Student> students;



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

        new Networking(this).execute();

        Log.d(TAG, "getView: " + getContext().getClass().getSimpleName()
                +" "+ view.getClass().getSimpleName());
    }

    public void loadJSON(String dataJSON) {

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
