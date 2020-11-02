package kr.hs.emirim.mirimhighlevelwidget;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    RadioButton radioDate, radioTime;
    TimePicker tiempick;
    Chronometer chorono;
    TextView textResult;
    DatePicker datepick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioDate = findViewById(R.id.radio_date);
        radioTime = findViewById(R.id.radio_time);
        datepick = findViewById(R.id.date_pick);
        tiempick = findViewById(R.id.timepick);
        chorono = findViewById(R.id.chron1);
        textResult = findViewById(R.id.text_result);
        chorono.setOnClickListener(chronoListener);
        textResult.setOnLongClickListener(textListener);
        radioDate.setVisibility((View.INVISIBLE));
        radioTime.setVisibility(View.INVISIBLE);
        datepick.setVisibility(View.INVISIBLE);
        tiempick.setVisibility(View.INVISIBLE);
    }

    View.OnClickListener chronoListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            chorono.setBase(SystemClock.elapsedRealtime());
            chorono.start();
            chorono.setTextColor(Color.RED);
            radioDate.setVisibility(View.VISIBLE);
            radioTime.setVisibility(View.VISIBLE);
        }
    };
    View.OnLongClickListener textListener = new View.OnLongClickListener(){

        @Override
        public boolean onLongClick(View v) {
            chorono.stop();
            chorono.setTextColor(Color.BLUE);
            textResult.setText(datepick.getYear() + "년" + (datepick.getMonth()+1)+"월 " + datepick.getDayOfMonth()+"일" + tiempick.getCurrentHour() +"시" + tiempick.getCurrentMinute() +"분");
            radioDate.setVisibility(View.INVISIBLE);
            radioTime.setVisibility(View.INVISIBLE);
            datepick.setVisibility(View.INVISIBLE);
            tiempick.setVisibility(View.INVISIBLE);
            return false;
        }
    };
}