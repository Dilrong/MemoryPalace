package dilrong.memorypalace;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class Tip1Activity extends AppCompatActivity {
    //시간지정
    private final long FINISH_INTERVAL_TIME = 2000;
    //시간측정
    private long   backPressedTime = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip1);
    }

    public void ToTip2(View v){
        Intent intent = new Intent(this, Tip2Activity.class);
        startActivity(intent);
        finish();
    }

    //백키 함수
    @Override
    public void onBackPressed()
    {
        long tempTime        = System.currentTimeMillis();
        long intervalTime    = tempTime - backPressedTime;

        if (0 <= intervalTime && FINISH_INTERVAL_TIME >= intervalTime)
        {
            super.onBackPressed();
        }
        else
        {
            backPressedTime = tempTime;
            Toast.makeText(getApplicationContext(), "기억의 궁전을 나가시겠습니까?", Toast.LENGTH_SHORT).show();
        }
    }
}
