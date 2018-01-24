package dilrong.memorypalace;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    //시간지정
    private final long FINISH_INTERVAL_TIME = 2000;
    //시간측정
    private long   backPressedTime = 0;

    private  static MediaPlayer bgm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        bgm = MediaPlayer.create(this, R.raw.darktimes);
        bgm.setLooping(true);
        bgm.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bgm.stop();
    }

    public void MenuClick(View v){
        Intent intent = new Intent(this, OutlineActivity.class);
        startActivity(intent);
        finish();
    }

    public void AdvantageClick(View v){
        Intent intent = new Intent(this, AdvantageActivity.class);
        startActivity(intent);
        finish();
    }

    public void MethodClick(View v){
        Intent intent = new Intent(this, Method1Activity.class);
        startActivity(intent);
        finish();
    }

    public void TipClick(View v){
        Intent intent = new Intent(this, Tip1Activity.class);
        startActivity(intent);
        finish();
    }

    public void TestClick(View v){
        Intent intent = new Intent(this, TestIndexActivity.class);
        startActivity(intent);
        finish();
    }

    public void OriginClick(View v){
        Intent intent = new Intent(this, OriginActivity.class);
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
