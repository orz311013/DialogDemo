package com.example.dialogdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5;

    String[] items = {"個人", "多人", "團體"};
    int ans = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        btn1 = findViewById(R.id.dialog01);
        btn2 = findViewById(R.id.dialog02);
        btn3 = findViewById(R.id.dialog03);
        btn4 = findViewById(R.id.dialog04);
        btn5 = findViewById(R.id.dialog05);

        btn1.setOnClickListener(btn1Lis);
        btn2.setOnClickListener(btn2Lis);
        btn3.setOnClickListener(btn3Lis);
        btn4.setOnClickListener(btn4Lis);
        btn5.setOnClickListener(btn5Lis);


    }

    private Button.OnClickListener btn1Lis = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            //對話框
            AlertDialog.Builder d = new AlertDialog.Builder(MainActivity.this);//(context) 使用他來跳出訊息框
            d.setTitle("開山里通報");//標題
            d.setMessage("里內有登革熱");//內容
            d.show();

        }
    };
    private Button.OnClickListener btn2Lis = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder d = new AlertDialog.Builder(MainActivity.this);
            d.setTitle("萬安演習")
                    .setMessage("9/1 13:00 萬安演習")
                    .setCancelable(false);//設定能不能按取消(不行) (點擊其他地方就可取消對話框)

            d.setPositiveButton("確認", new DialogInterface.OnClickListener() {//點及確認後
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    btn2.setText("已讀");
                }
            });
            d.show();
        }
    };
    private Button.OnClickListener btn3Lis = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder d = new AlertDialog.Builder(MainActivity.this);
            d.setTitle("詢問")
                    .setMessage("是否離開")
                    .setCancelable(false);//設定能不能按取消(不行) (點擊其他地方就可取消對話框)

            d.setPositiveButton("確認", new DialogInterface.OnClickListener() {//點及確認後
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    btn3.setText("離開");
                }
            });
            d.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    btn3.setText("取消");
                }
            });
            d.show();

        }
    };
    private Button.OnClickListener btn4Lis = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {

            AlertDialog.Builder d = new AlertDialog.Builder(MainActivity.this);
            d.setTitle("請選擇");
            d.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
                @Override   //預設 -1不選擇
                public void onClick(DialogInterface dialogInterface, int which) {
                    ans = which;
                }
            });
            d.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    if (ans != -1)//如果選擇不等於-1(不選擇)
                        btn4.setText(items[ans]);
                }
            });


        }
    };
    private Button.OnClickListener btn5Lis = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {


        }
    };
}
