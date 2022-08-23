package com.sentila.writeapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class Starter_second extends Fragment {
    private String title;
    private int page;
    private Button btn_skip;

    // newInstance constructor for creating fragment with arguments
    public static Starter_second newInstance(int page, String title) {
        Starter_second fragment = new Starter_second();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragment.setArguments(args);
        return fragment;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");

    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_starter_second, container, false);
        // EditText tvLabel = (EditText) view.findViewById(R.id.editText);
        //  tvLabel.setText(page + " -- " + title);
        btn_skip = (Button) view.findViewById(R.id.skip);
        btn_skip.setOnClickListener(new View.OnClickListener() { //프래그먼트 2로 이동
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Frag_Main.class);
                startActivity(intent);
            }
        });
        return view;
    }
}