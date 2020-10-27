package kr.hs.emirim.mirimhighlevelwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    RadioButton radioDate, radioTime;
    CalendarView calendar1;
    TimePicker tiempick;
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
}