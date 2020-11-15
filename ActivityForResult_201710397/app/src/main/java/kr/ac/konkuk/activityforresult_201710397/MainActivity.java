package kr.ac.konkuk.activityforresult_201710397;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String INPUT_TEXT1 = "INPUT_TEXT1"; //첫번째 문자열 name
    public static final String INPUT_TEXT2 = "INPUT_TEXT2"; //두번째 문자열 name

    static final int GET_STRING = 1; //문자열 요청

    TextView text1; //첫번째 문자열 (sub -> Main) textView
    TextView text2; //두번째 문자열 (sub2 -> Main) textView

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);

        button.setOnClickListener((arg0) -> {
            Intent in = new Intent(MainActivity.this,SubActivity.class); //버튼을 클릭하면 subActivity로
            startActivityForResult(in,GET_STRING); //결과를 반환받음
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == GET_STRING) {
            if (resultCode == RESULT_OK) {
                text1.setText(data.getStringExtra(INPUT_TEXT1)); //인텐트 객체에서 subActivity에서 입력한 문자열을 가져옴
                text2.setText(data.getStringExtra(INPUT_TEXT2)); //인텐트 객체에서 subActivity2에서 입력한 문자열을 가져옴
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}