package kr.hs.emirim.mirimviewcontainer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class TapActivityTest extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tap);
        TabHost tabHost = getTabHost();
        TabHost.TabSpec tabSpecPark = tabHost.newTabSpec("PARK").setIndicator("박세리");
        tabSpecPark.setContent(R.id.park);
        tabHost.addTab((tabSpecPark));

        TabHost.TabSpec tabSpecSon = tabHost.newTabSpec("Son").setIndicator("손예진");
        tabSpecSon.setContent(R.id.son);
        tabHost.addTab((tabSpecSon));

        TabHost.TabSpec tabSpecAn = tabHost.newTabSpec("AN").setIndicator("안현모");
        tabSpecSon.setContent(R.id.an);
        tabHost.addTab((tabSpecAn));

        tabHost.setCurrentTab(0);
    }
}