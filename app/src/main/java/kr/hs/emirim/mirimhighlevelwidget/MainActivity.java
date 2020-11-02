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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    RadioButton radioDate, radioTime;
    CalendarView calendar1;
    TimePicker tiempick;
    Chronometer chorono;
    TextView textResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioDate = findViewById(R.id.radio_date);
        radioTime = findViewById(R.id.radio_time);
        radioDate.setOnClickListener(radioListener);
        radioTime.setOnClickListener(radioListener);
        calendar1 = findViewById(R.id.calendar1);
        tiempick = findViewById(R.id.timepick);
        chorono = findViewById(R.id.chron1);
        textResult = findViewById(R.id.text_result);
        Button btnStart = findViewById(R.id.btn_start);
        Button btnStop = findViewById(R.id.btn_stop);
        btnStart.setOnClickListener(btnListener);
        btnStop.setOnClickListener(btnListener);
        calendar1.setOnDateChangeListener(calendarListener);
    }
    View.OnClickListener radioListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.radio_date:
                    calendar1.setVisibility(view.VISIBLE);
                    tiempick.setVisibility(view.INVISIBLE);
                    break;
                case R.id.radio_time:
                    calendar1.setVisibility(view.INVISIBLE);
                    tiempick.setVisibility(view.VISIBLE);
                    break;
            }
        }
    };
    View.OnClickListener btnListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_start:
                    chorono.setBase(SystemClock.elapsedRealtime());
                    chorono.start();
                    chorono.setTextColor(Color.RED);
                    break;
                case R.id.btn_stop:
                    chorono.stop();
                    chorono.setTextColor(Color.BLUE);
                    textResult.setText(tiempick.getCurrentHour() + "시" + tiempick.getCurrentMinute() +"분");
                    break;
            }
        }
    };
    String dateStr = "";
    CalendarView.OnDateChangeListener calendarListener = new CalendarView.OnDateChangeListener() {
        @Override
        public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
            dateStr = year + "년" + (month + 1) + "월" + dayOfMonth +"일";
        }
    };
}