package com.sentila.writeapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag2 extends Fragment {
    private View view;
    private Button free_writing;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag2,container,false);

        free_writing = (Button) view.findViewById(R.id.free_writing);
        free_writing.setOnClickListener(new View.OnClickListener() { //프래그먼트 2로 이동
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Writing.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
