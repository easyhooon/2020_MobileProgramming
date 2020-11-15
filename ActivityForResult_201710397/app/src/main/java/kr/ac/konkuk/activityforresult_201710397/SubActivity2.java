package kr.ac.konkuk.activityforresult_201710397;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity2 extends AppCompatActivity {
    EditText edit2; //두번째 문자열 입력 TextView
    Button button_ok2; // 문자열 입력 완료 버튼
    Button button_cancel2; // 문자열 입력 취소 버튼

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub2);

        edit2 = findViewById(R.id.edit2);
        button_ok2 = findViewById(R.id.button_ok2);
        button_ok2.setOnClickListener((v)->{
            Intent intent = new Intent();
            intent.putExtra(SubActivity.INPUT_TEXT, edit2.getText().toString()); //두번째 입력 문자열을 가져옴
            setResult(RESULT_OK, intent); //결과값 완료
            finish(); //subActivity2 종료
        });

        button_cancel2 = findViewById(R.id.button_cancel2);
        button_cancel2.setOnClickListener((v)->{
            setResult(RESULT_CANCELED); // 결과값 취소
            finish(); //subActivity2 종료
        });
    }
}