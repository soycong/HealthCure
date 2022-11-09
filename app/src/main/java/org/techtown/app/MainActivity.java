package org.techtown.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.appcompat.app.AppCompatActivity;

import org.techtown.app.databinding.ActivityMainBinding;
import org.techtown.app.exercise.ExerciseActivity;
import org.techtown.app.mypage.MyPageEdit_Fragment;
import org.techtown.app.mypage.MyPage_Fragment;
import org.techtown.app.ui.checkList.CheckList_Fragment;
import org.techtown.app.ui.exerciseList.Exercise1;
import org.techtown.app.ui.exerciseList.Exercise10;
import org.techtown.app.ui.exerciseList.Exercise11;
import org.techtown.app.ui.exerciseList.Exercise12;
import org.techtown.app.ui.exerciseList.Exercise13;
import org.techtown.app.ui.exerciseList.Exercise14;
import org.techtown.app.ui.exerciseList.Exercise15;
import org.techtown.app.ui.exerciseList.Exercise16;
import org.techtown.app.ui.exerciseList.Exercise17;
import org.techtown.app.ui.exerciseList.Exercise18;
import org.techtown.app.ui.exerciseList.Exercise19;
import org.techtown.app.ui.exerciseList.Exercise2;
import org.techtown.app.ui.exerciseList.Exercise20;
import org.techtown.app.ui.exerciseList.Exercise21;
import org.techtown.app.ui.exerciseList.Exercise22;
import org.techtown.app.ui.exerciseList.Exercise23;
import org.techtown.app.ui.exerciseList.Exercise24;
import org.techtown.app.ui.exerciseList.Exercise25;
import org.techtown.app.ui.exerciseList.Exercise26;
import org.techtown.app.ui.exerciseList.Exercise27;
import org.techtown.app.ui.exerciseList.Exercise28;
import org.techtown.app.ui.exerciseList.Exercise29;
import org.techtown.app.ui.exerciseList.Exercise3;
import org.techtown.app.ui.exerciseList.Exercise30;
import org.techtown.app.ui.exerciseList.Exercise31;
import org.techtown.app.ui.exerciseList.Exercise32;
import org.techtown.app.ui.exerciseList.Exercise33;
import org.techtown.app.ui.exerciseList.Exercise4;
import org.techtown.app.ui.exerciseList.Exercise5;
import org.techtown.app.ui.exerciseList.Exercise6;
import org.techtown.app.ui.exerciseList.Exercise7;
import org.techtown.app.ui.exerciseList.Exercise8;
import org.techtown.app.ui.exerciseList.Exercise9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    Home_Fragment fragment1;
    CheckList_Fragment fragment2;
    MyPage_Fragment fragment3;
    MyPageEdit_Fragment mypage_edit_fragment;
    Exercise1 exercise1;Exercise2 exercise2;Exercise3 exercise3;Exercise4 exercise4;Exercise5 exercise5;Exercise6 exercise6;Exercise7 exercise7;
    Exercise8 exercise8;Exercise9 exercise9;Exercise10 exercise10;Exercise11 exercise11;Exercise12 exercise12;Exercise13 exercise13;Exercise14 exercise14;
    Exercise15 exercise15;Exercise16 exercise16;Exercise17 exercise17;Exercise18 exercise18;Exercise19 exercise19;Exercise20 exercise20;Exercise21 exercise21;
    Exercise22 exercise22;Exercise23 exercise23;Exercise24 exercise24;Exercise25 exercise25;Exercise26 exercise26;Exercise27 exercise27;Exercise28 exercise28;
    Exercise29 exercise29;Exercise30 exercise30;Exercise31 exercise31;Exercise32 exercise32;Exercise33 exercise33;

    public int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fragment1 = new Home_Fragment();
        fragment2 = new CheckList_Fragment();
        fragment3 = new MyPage_Fragment();
        mypage_edit_fragment = new MyPageEdit_Fragment();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);

        //제일 처음 띄워주는 fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment1, "home").commitAllowingStateLoss();
        getSupportActionBar().setTitle("Home");

        bottomNavigation.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.tab1: {
                                Toast.makeText(getApplicationContext(), "Home 탭 선택됨", Toast.LENGTH_SHORT).show();
                                getSupportActionBar().setTitle("Home");

                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.container, fragment1, "home").commit();

                                return true;
                            }

                            case R.id.tab2: {
                                Toast.makeText(getApplicationContext(), "CheckList 탭 선택됨", Toast.LENGTH_SHORT).show();
                                getSupportActionBar().setTitle("CheckList");

                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.container, fragment2, "checkList").commit();

                                return true;
                            }

                            case R.id.tab3: {
                                Toast.makeText(getApplicationContext(), "MyPage 탭 선택됨", Toast.LENGTH_SHORT).show();
                                getSupportActionBar().setTitle("MyPage");

                                getSupportFragmentManager().beginTransaction()
                                            .replace(R.id.container, fragment3, "myPage").commit();
                                return true;
                            }
                            default: return false;
                        }
                    }
                });

        //csv 데이터 불러오기
        // eye:시각장애 , ear:청각장애, mental:지적장애, myelopathy:척수장애
        //배열 출력 형태 : [장애 유형, 준비운동, 본운동, 마무리운동]
        InputStream is_eye = this.getResources().openRawResource(R.raw.eyedata);
        InputStream is_ear = this.getResources().openRawResource(R.raw.eardata);
        InputStream is_mental = this.getResources().openRawResource(R.raw.mentaldata);
        InputStream is_myelopathy = this.getResources().openRawResource(R.raw.myelopathydata);

        BufferedReader reader_eye = new BufferedReader(new InputStreamReader(is_eye, StandardCharsets.UTF_8));
        BufferedReader reader_ear = new BufferedReader(new InputStreamReader(is_ear, StandardCharsets.UTF_8));
        BufferedReader reader_mental = new BufferedReader(new InputStreamReader(is_mental, StandardCharsets.UTF_8));
        BufferedReader reader_myelopathy = new BufferedReader(new InputStreamReader(is_myelopathy, StandardCharsets.UTF_8));

        List<String> eye_csvList = new ArrayList<String>();
        List<String> ear_csvList = new ArrayList<String>();
        List<String> mental_csvList = new ArrayList<String>();
        List<String> myelopathy_csvList = new ArrayList<String>();

        try {
            String line_eye;
            String line_ear;
            String line_mental;
            String line_myelopathy;

            while (((line_eye = reader_eye.readLine()) != null) && ((line_ear = reader_ear.readLine()) != null)
                    && ((line_mental = reader_mental.readLine()) != null) && ((line_myelopathy = reader_myelopathy.readLine()) != null)) {
                // do something with "line"
                List<String> eyeLine;
                List<String> earLine;
                List<String> mentalLine;
                List<String> myelopathyLine;

                String[] lineArr1 = line_eye.split(",");
                String[] lineArr2 = line_ear.split(",");
                String[] lineArr3 = line_mental.split(",");
                String[] lineArr4 = line_myelopathy.split(",");

                eyeLine = Arrays.asList(lineArr1);
                earLine = Arrays.asList(lineArr2);
                mentalLine = Arrays.asList(lineArr3);
                myelopathyLine = Arrays.asList(lineArr4);

                System.out.println(eyeLine);
                System.out.println(earLine);
                System.out.println(mentalLine);
                System.out.println(myelopathyLine);

                eye_csvList.add(String.valueOf(eyeLine));
                ear_csvList.add(String.valueOf(earLine));
                mental_csvList.add(String.valueOf(mentalLine));
                myelopathy_csvList.add(String.valueOf(myelopathyLine));
            }
        }
        catch (IOException ex) {
            // handle exception
            ex.printStackTrace();
        }
        finally {
            try {
                /*System.out.println(eye_csvList);
                System.out.println(ear_csvList);
                System.out.println(mental_csvList);
                System.out.println(myelopathy_csvList);*/

                //System.out.println(myelopathy_csvList.get(0));

                is_eye.close();
                is_ear.close();
                is_mental.close();
                is_myelopathy.close();
            }
            catch (IOException e) {
                // handle exception
                e.printStackTrace();
            }
        }
    }

    public void clickBtn(View view){
        Intent intent = new Intent(this, ExerciseActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        exercise1 = new Exercise1();exercise2 = new Exercise2();exercise3 = new Exercise3();exercise4 = new Exercise4();exercise5 = new Exercise5();
        exercise6 = new Exercise6();exercise7 = new Exercise7();exercise8 = new Exercise8();exercise9 = new Exercise9();exercise10 = new Exercise10();
        exercise11 = new Exercise11();exercise12 = new Exercise12();exercise13 = new Exercise13();exercise14 = new Exercise14();exercise15 = new Exercise15();
        exercise16 = new Exercise16();exercise17 = new Exercise17();exercise18 = new Exercise18();exercise19 = new Exercise19();exercise20 = new Exercise20();
        exercise21 = new Exercise21();exercise22 = new Exercise22();exercise23 = new Exercise23();exercise24 = new Exercise24();exercise25 = new Exercise25();
        exercise26 = new Exercise26();exercise27 = new Exercise27();exercise28 = new Exercise28();exercise29 = new Exercise29();exercise30 = new Exercise30();
        exercise31 = new Exercise31();exercise32 = new Exercise32();exercise33 = new Exercise33();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        switch(item.getItemId()) {

            case android.R.id.home:
                getSupportActionBar().setTitle("Home");
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, fragment1, "home").commit();
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                return true;
            case R.id.exercise1:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, exercise1, "exercise1").commitAllowingStateLoss();
                getSupportActionBar().setTitle("원판 던지기");
                break;
            case R.id.exercise2:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, exercise2, "exercise2").commitAllowingStateLoss();
                getSupportActionBar().setTitle("몸통 들어올리기");
                break;
            case R.id.exercise3:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, exercise3, "exercise3").commitAllowingStateLoss();
                getSupportActionBar().setTitle("앉아서 몸통 움츠리기");
                break;
            case R.id.exercise4:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, exercise4, "exercise4").commitAllowingStateLoss();
                getSupportActionBar().setTitle("앉아서 다리 밀기");
                break;
            case R.id.exercise5:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, exercise5, "exercise5").commitAllowingStateLoss();
                getSupportActionBar().setTitle("발 닿기");
                break;
            case R.id.exercise6:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, exercise6, "exercise6").commitAllowingStateLoss();
                getSupportActionBar().setTitle("앉아서 다리 펴기");
                break;
            case R.id.exercise7:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, exercise7, "exercise7").commitAllowingStateLoss();
                getSupportActionBar().setTitle("매달려서 다리 들기");
                break;
            case R.id.exercise8:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, exercise8, "exercise8").commitAllowingStateLoss();
                getSupportActionBar().setTitle("앉아서 모으기");
                break;
            case R.id.exercise9:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, exercise9, "exercise9").commitAllowingStateLoss();
                getSupportActionBar().setTitle("거꾸로 누워서 밀기");
                break;
            case R.id.exercise10:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, exercise10, "exercise10").commitAllowingStateLoss();
                getSupportActionBar().setTitle("앉아서 다리 모으기");
                break;
            case R.id.exercise11:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, exercise11, "exercise11").commitAllowingStateLoss();
                getSupportActionBar().setTitle("앉아서 위로 밀기");
                break;
            case R.id.exercise12:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, exercise12, "exercise12").commitAllowingStateLoss();
                getSupportActionBar().setTitle("서서 어깨 들어올리기");
                break;
            case R.id.exercise13:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, exercise13, "exercise13").commitAllowingStateLoss();
                getSupportActionBar().setTitle("바벨 끌어당기기");
                break;
            case R.id.exercise14:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, exercise14, "exercise14").commitAllowingStateLoss();
                getSupportActionBar().setTitle("턱걸이");
                break;
            case R.id.exercise15:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, exercise15, "exercise15").commitAllowingStateLoss();
                getSupportActionBar().setTitle("바벨 들어올리기");
                break;
            case R.id.exercise16:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, exercise16, "exercise16").commitAllowingStateLoss();
                getSupportActionBar().setTitle("앉아서 당겨 내리기");
                break;
            case R.id.exercise17:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, exercise17, "exercise17").commitAllowingStateLoss();
                getSupportActionBar().setTitle("앉아서 다리 벌리기");
                break;
            case R.id.exercise18:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, exercise18, "exercise18").commitAllowingStateLoss();
                getSupportActionBar().setTitle("비스듬히 누워서 밀기");
                break;
            case R.id.exercise19:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, exercise19, "exercise19").commitAllowingStateLoss();
                getSupportActionBar().setTitle("앉아서 다리 굽히기");
                break;
            case R.id.exercise20:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, exercise20, "exercise20").commitAllowingStateLoss();
                getSupportActionBar().setTitle("실내 자전거타기");
                break;
            case R.id.exercise21:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, exercise21, "exercise21").commitAllowingStateLoss();
                getSupportActionBar().setTitle("파워클린");
                break;
            case R.id.exercise22:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, exercise22, "exercise22").commitAllowingStateLoss();
                getSupportActionBar().setTitle("한발 앞으로 내밀고 앉았다 일어서기");
                break;
            case R.id.exercise23:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, exercise23, "exercise23").commitAllowingStateLoss();
                getSupportActionBar().setTitle("앉아서 뒤로 당기기");
                break;
            case R.id.exercise24:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, exercise24, "exercise24").commitAllowingStateLoss();
                getSupportActionBar().setTitle("뒤꿈치 들기");
                break;
            case R.id.exercise25:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, exercise25, "exercise25").commitAllowingStateLoss();
                getSupportActionBar().setTitle("트레드밀에서 걷기");
                break;
            case R.id.exercise26:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, exercise26, "exercise26").commitAllowingStateLoss();
                getSupportActionBar().setTitle("누워서 밀기");
                break;
            case R.id.exercise27:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, exercise27, "exercise27").commitAllowingStateLoss();
                getSupportActionBar().setTitle("허리 굽혀 덤벨 들기");
                break;
            case R.id.exercise28:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, exercise28, "exercise28").commitAllowingStateLoss();
                getSupportActionBar().setTitle("앉았다 일어서기");
                break;
            case R.id.exercise29:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, exercise29, "exercise29").commitAllowingStateLoss();
                getSupportActionBar().setTitle("계단 뛰어 오르기");
                break;
            case R.id.exercise30:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, exercise30, "exercise30").commitAllowingStateLoss();
                getSupportActionBar().setTitle("계단 올라갔다 내려오기");
                break;
            case R.id.exercise31:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, exercise31, "exercise31").commitAllowingStateLoss();
                getSupportActionBar().setTitle("앉아서 밀기");
                break;
            case R.id.exercise32:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, exercise32, "exercise32").commitAllowingStateLoss();
                getSupportActionBar().setTitle("몸 기울이기/회전하기");
                break;
            case R.id.exercise33:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, exercise33, "exercise33").commitAllowingStateLoss();
                getSupportActionBar().setTitle("옆구리 늘리기");
                break;

        }
        return super.onOptionsItemSelected((item));
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

}