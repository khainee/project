package com.my.freemyanmarid;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes57.dex */
public class MainActivity extends AppCompatActivity {
    private TextView id2;
    private ImageView imageview1;
    private LinearLayout linear1;
    private LinearLayout linear2;
    private LinearLayout linear3;
    private TimerTask t;
    private TextView textview1;
    private Timer _timer = new Timer();
    private String idd = "";
    private Intent i = new Intent();

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.main);
        initialize(bundle);
        initializeLogic();
    }

    private void initialize(Bundle bundle) {
        this.linear1 = (LinearLayout) findViewById(R.id.linear1);
        this.linear2 = (LinearLayout) findViewById(R.id.linear2);
        this.imageview1 = (ImageView) findViewById(R.id.imageview1);
        this.linear3 = (LinearLayout) findViewById(R.id.linear3);
        this.textview1 = (TextView) findViewById(R.id.textview1);
        this.id2 = (TextView) findViewById(R.id.id2);
        this.id2.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.MainActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void initializeLogic() {
        if (Build.VERSION.SDK_INT > 19) {
            Window window = getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(-16777034);
        }
        this.idd = Settings.Secure.getString(getApplicationContext().getContentResolver(), "android_id");
        this.id2.setText(this.idd);
        this.t = new TimerTask() { // from class: com.my.freemyanmarid.MainActivity.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MainActivity.this.runOnUiThread(new Runnable() { // from class: com.my.freemyanmarid.MainActivity.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MainActivity.this.i.setClass(MainActivity.this.getApplicationContext(), HomeActivity.class);
                        MainActivity.this.startActivity(MainActivity.this.i);
                        MainActivity.this.finish();
                    }
                });
            }
        };
        this._timer.schedule(this.t, 2000L);
        this.id2.setVisibility(8);
    }

    @Deprecated
    public void showMessage(String str) {
        Toast.makeText(getApplicationContext(), str, 0).show();
    }

    @Deprecated
    public int getLocationX(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[0];
    }

    @Deprecated
    public int getLocationY(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[1];
    }

    @Deprecated
    public int getRandom(int i, int i2) {
        return new Random().nextInt((i2 - i) + 1) + i;
    }

    @Deprecated
    public ArrayList<Double> getCheckedItemPositionsToArray(ListView listView) {
        ArrayList<Double> arrayList = new ArrayList<>();
        SparseBooleanArray checkedItemPositions = listView.getCheckedItemPositions();
        for (int i = 0; i < checkedItemPositions.size(); i++) {
            if (checkedItemPositions.valueAt(i)) {
                arrayList.add(Double.valueOf(checkedItemPositions.keyAt(i)));
            }
        }
        return arrayList;
    }

    @Deprecated
    public float getDip(int i) {
        return TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
    }

    @Deprecated
    public int getDisplayWidthPixels() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    @Deprecated
    public int getDisplayHeightPixels() {
        return getResources().getDisplayMetrics().heightPixels;
    }
}
