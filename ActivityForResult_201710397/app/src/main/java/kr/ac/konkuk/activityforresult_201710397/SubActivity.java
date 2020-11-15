package kr.ac.konkuk.activityforresult_201710397;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
    public static final String INPUT_TEXT = "INPUT_TEXT"; // 두 번째 문자열 name

    public static final int GET_STRING_SECOND = 2; // 두 번째 문자열 Request 값

    EditText edit; // 첫 번째 문자열을 입력할 EditText

    TextView textInput2; // 두 번쨰 문자열을 보여줄 TextView

    Button button_input2; // 누르면 SubActivity2를 띄워줄 버튼
    Button button_ok; // MainActivity로 문자열을 반환할 버튼
    Button button_cancel; // 문자열 입력 취소 버튼

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);

        edit = findViewById(R.id.edit);
        textInput2 = findViewById(R.id.textInput2);

        button_input2 = findViewById(R.id.button_input2);
        button_input2.setOnClickListener((arg0) -> {
            Intent in = new Intent(SubActivity.this,SubActivity2.class); ////버튼을 클릭하면 subActivity2로
            startActivityForResult(in, GET_STRING_SECOND); //결과를 반환받음
        });


        button_ok = findViewById(R.id.button_ok);
        button_ok.setOnClickListener((v)->{
            Intent intent = new Intent();
            intent.putExtra(MainActivity.INPUT_TEXT1, edit.getText().toString()); //첫번째 문자열을 인텍트 객체에 넣음
            intent.putExtra(MainActivity.INPUT_TEXT2, textInput2.getText().toString());//두번째 문자열을 인텍트 객체에 넣음
            setResult(RESULT_OK, intent); //결과값 완료
            finish(); //subActivity 종료
        });

        button_cancel = findViewById(R.id.button_cancel);
        button_cancel.setOnClickListener((v)->{
            setResult(RESULT_CANCELED); //결과값 취소
            finish(); //subActivity 종료
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == GET_STRING_SECOND) { //두번째 문자열 요청에 대한 결과라면
            if (resultCode == RESULT_OK) { //결과값 완료 이면
                textInput2.setText(data.getStringExtra(INPUT_TEXT)); //두번째 문자열을 보여줄 textView를  입력한 문자열로 설정
            }
        } else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
