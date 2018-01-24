package dilrong.memorypalace;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SteveJobsSpeechActivity extends AppCompatActivity {
    //시간지정
    private final long FINISH_INTERVAL_TIME = 2000;
    //시간측정
    private long   backPressedTime = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stevejobs);

        try{
            InputStream in = getResources().openRawResource(R.raw.stevejobsspeech);

            if(in != null){
                InputStreamReader stream = new InputStreamReader(in, "utf-8");
                BufferedReader buffer = new BufferedReader(stream);

                String read;
                StringBuilder sb = new StringBuilder("");

                while ((read=buffer.readLine()) != null){
                    sb.append(read+"\n");
                }

                in.close();
                TextView SteveJobsSpeech = (TextView)findViewById(R.id.SteveJobsSpeechtxt);
                SteveJobsSpeech.setText(sb.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void ToMenu(View v){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        finish();
    }

    public void SteveJobsSpeechVedio(View v){
        Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=UF8uR6Z6KLc&t=239s"));
        startActivity(intent);
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
