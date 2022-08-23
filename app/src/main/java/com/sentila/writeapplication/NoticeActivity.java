package com.sentila.writeapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

public class NoticeActivity extends AppCompatActivity {
    private ListView noticeListView;
    private NoticeListAdapter Adapter;
    private List<Notice> noticeList;
    private ImageButton btn_back4;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        btn_back4 = findViewById(R.id.btn_back4);
        btn_back4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NoticeActivity.this,Frag_Main.class);
                startActivity(intent);
            }
        });

        noticeListView = (ListView)  findViewById(R.id.noticeListView);
        noticeList = new ArrayList<Notice>();
        noticeList.add(new Notice("일기장 사용 방법","이해한","2022-07-24"));
        noticeList.add(new Notice("일기장 작성 이벤트 ","김모씨","2021-05-19"));
        noticeList.add(new Notice("새해 이벤트 실시!","박모씨","2020-02-09"));
        noticeList.add(new Notice("크리스마스 이벤트 참가자 모집","이모씨","2019-11-05"));
        noticeList.add(new Notice("이땡땡 작가와 함께하는 일기 대회 개최","최모씨","2019-05-14"));
//        noticeList.add(new Notice("코로나19 예방 행동수칙 및 대응 안내","윤모씨","2019-04-13"));
//        noticeList.add(new Notice("신입생 웹메일 신청 및 사용 방법 안내.","강모씨","2018-07-25"));
//        noticeList.add(new Notice("2022-2 학산관(기숙사) 사생모집 안내","신모씨","2018-02-01"));
//        noticeList.add(new Notice("신입생 웹메일 신청 및 사용 방법 안내.","임모씨","2017-05-31"));
//        noticeList.add(new Notice("2022-2 학산관(기숙사) 사생모집 안내","진모씨","2017-03-04"));

        Adapter = new NoticeListAdapter(getApplicationContext(), noticeList);
        noticeListView.setAdapter(Adapter);



        /* 아이템 클릭시 작동 */
        noticeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Intent intent = new Intent(NoticeActivity.this, Frag_Main.class);
                /* putExtra의 첫 값은 식별 태그, 뒤에는 다음 화면에 넘길 값 */
                startActivity(intent);
            }
        });





    }
    private  long lastTimeBackPressed;

    @Override
    public void onBackPressed(){
        if(System.currentTimeMillis() - lastTimeBackPressed < 1500){
            finish();
            return;

        }
        Toast.makeText(this,"'뒤로' 버튼을 한 번 더 눌러 종료합니다.",Toast.LENGTH_SHORT);
        lastTimeBackPressed = System.currentTimeMillis();


    }
}
