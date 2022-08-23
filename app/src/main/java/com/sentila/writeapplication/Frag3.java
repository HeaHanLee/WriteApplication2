package com.sentila.writeapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class Frag3 extends Fragment {
    private View view;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth mAuth ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag3,container,false);
        ListView listView = view.findViewById(R.id.list);


        mFirebaseAuth = FirebaseAuth.getInstance();

        List<String> list = new ArrayList<>();
        list.add("로그인");
        list.add("탈퇴하기");
        list.add("공지사항");


        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    //로그인 화면 이동
                    Intent intent = new Intent(getActivity(),LoginActivity.class);
                    startActivity(intent);

                }else if(position==1) {
                    //탈퇴 처리
                    mFirebaseAuth.getCurrentUser().delete();
                    Toast.makeText(getActivity(), "탈퇴가 정상 처리되었습니다.", Toast.LENGTH_SHORT).show();

                }else if(position==2){
                    //공지사항
                    Intent intent = new Intent(getActivity(),NoticeActivity.class);
                    startActivity(intent);
                }
            }
        });


        return view;

    }
}

