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

public class Frag1 extends Fragment {

    private View view;
    private Button reader, author;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag1,container,false);

        reader = (Button) view.findViewById(R.id.reader);
        author = (Button) view.findViewById(R.id.author);
        reader.setOnClickListener(new View.OnClickListener() { //프래그먼트 2로 이동
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Reader.class);
                startActivity(intent);
            }
        });
        author.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Writer_Main.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
