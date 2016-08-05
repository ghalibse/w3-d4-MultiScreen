package com.example.simpledoublefragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class RightFragment extends Fragment {

    private String[] url = new String[]{"https://goo.gl/iXJNuf", "http://goo.gl/dPs4IF", "http://goo.gl/N6CfR0","https://goo.gl/NqJtxe", "http://goo.gl/aGM2Qq"};

    private ImageView mImageView;

    public RightFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_right, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mImageView = (ImageView) view.findViewById(R.id.f_right_img);
    }

    public void loadImage(int name) {

        Picasso.with(getContext()).load(url[name]).into(mImageView);
    }
}
