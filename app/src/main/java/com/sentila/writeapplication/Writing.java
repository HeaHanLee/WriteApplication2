package com.sentila.writeapplication;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Writing extends AppCompatActivity {

    private RecyclerView mrecyclerView;
    private Button madd_btn;
    private ArrayList<ToDoItem> mtoDoItems;
    private DBHelper mdbHelper;
    private CustomAdapter mAdapter;
    private Button btn_back;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_main);

        setInit();

    }

    private void setInit() {
        mdbHelper = new DBHelper(this);
        mrecyclerView = findViewById(R.id.rv_todo);
        madd_btn = findViewById(R.id.btn_write);
        mtoDoItems = new ArrayList<>();

        loadRecentDB(); //실행시, 이전에 DB가 존재한다면 LOAD해옴


        madd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog dialog = new Dialog(Writing.this, android.R.style.Theme_Material_Light_Dialog); //팝업창
                dialog.setContentView(R.layout.dialog_edit);

                //팝업창 정의
                EditText edit_title = dialog.findViewById(R.id.edit_title); //텍스트 타이틀
                EditText edit_content = dialog.findViewById(R.id.edit_content); //내용 텍스트
                Button dialog_btn = dialog.findViewById(R.id.dialog_btn); //글작성 버튼
                dialog_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //데이터베이스에 삽입
                        String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()); //현재시간 받아오기
                        mdbHelper.InsertTodo(edit_title.getText().toString(), edit_content.getText().toString(),currentTime); //db에 넣기

                        //UI에 삽입
                        ToDoItem item = new ToDoItem();
                        item.setTitle(edit_title.getText().toString());
                        item.setContent(edit_content.getText().toString());
                        item.setWriteDate(currentTime);

                        mAdapter.addItem(item); //객체를 넘겨줌(한 세트)
                        mrecyclerView.smoothScrollToPosition(0); //데이터가 올라갈때마다 ListView가 쫒아올라가서 이쁘게 해줌
                        dialog.dismiss();
                        Toast.makeText(Writing.this, "정상적으로 추가되었습니다.", Toast.LENGTH_SHORT).show();



                    }
                });
                dialog.show(); //필수

            }
        });

    }

    private void loadRecentDB() {
        //저장된 db가져옴
        mtoDoItems = mdbHelper.getToDoList();
        if(mAdapter == null){
            mAdapter = new CustomAdapter(mtoDoItems, this);
            mrecyclerView.setHasFixedSize(true); //성능 강화
            mrecyclerView.setAdapter(mAdapter);
        }

        btn_back = findViewById(R.id.button_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Writing.this,Frag_Main.class);
                startActivity(intent);
            }
        });
    }
}
