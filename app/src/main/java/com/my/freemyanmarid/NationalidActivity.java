package com.my.freemyanmarid;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.ScaleAnimation;
import android.widget.AbsoluteLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.my.freemyanmarid.RequestNetwork;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes57.dex */
public class NationalidActivity extends AppCompatActivity {
    private RequestNetwork.RequestListener _req_request_listener;
    private TextView am2;
    private LinearLayout bg_linear;
    private TextView birth1;
    private TextView birth2;
    private TextView blood1;
    private ImageView button;
    private AlertDialog.Builder d;
    private TextView dd;
    private TextView dres;
    private TextView editText;
    private HorizontalScrollView hscroll2;
    private ImageView imageview;
    private ImageView imageview1;
    private ImageView imageview2;
    private ImageView imageview63;
    private ImageView imageview64;
    private ImageView imageview65;
    private ImageView imageview66;
    private ImageView imageview67;
    private ImageView imageview68;
    private ImageView imageview69;
    private ImageView imageview70;
    private ImageView imageview72;
    private ImageView imageview75;
    private ImageView imageview77;
    private ImageView imageview78;
    private ImageView imageview79;
    private ImageView imageview80;
    private ImageView imageview81;
    private ImageView imageview82;
    private ImageView imageview83;
    private ImageView imageview84;
    private ImageView imageview85;
    private ImageView imageview86;
    private ImageView imageview87;
    private ImageView imageview88;
    private ImageView imageview89;
    private SharedPreferences img;
    private TextView key;
    private LinearLayout linear1;
    private LinearLayout linear113;
    private LinearLayout linear118;
    private LinearLayout linear119;
    private LinearLayout linear120;
    private LinearLayout linear121;
    private LinearLayout linear122;
    private LinearLayout linear123;
    private LinearLayout linear124;
    private LinearLayout linear126;
    private LinearLayout linear127;
    private LinearLayout linear128;
    private LinearLayout linear129;
    private LinearLayout linear130;
    private LinearLayout linear144;
    private LinearLayout linear145;
    private LinearLayout linear152;
    private LinearLayout linear153;
    private LinearLayout linear154;
    private LinearLayout linear155;
    private LinearLayout linear156;
    private LinearLayout linear157;
    private LinearLayout linear158;
    private LinearLayout linear160;
    private LinearLayout linear161;
    private LinearLayout linear162;
    private LinearLayout linear164;
    private LinearLayout linear165;
    private LinearLayout linear168;
    private AbsoluteLayout linear169;
    private LinearLayout linear170;
    private LinearLayout linear171;
    private LinearLayout linear172;
    private LinearLayout linear173;
    private LinearLayout linear174;
    private LinearLayout linear175;
    private LinearLayout linear177;
    private LinearLayout linear182;
    private LinearLayout linear183;
    private LinearLayout linear184;
    private LinearLayout linear185;
    private LinearLayout linear187;
    private LinearLayout linear3;
    private AbsoluteLayout linear4;
    private TextView name1;
    private TextView name2;
    private TextView no1;
    private TextView no2;
    private TextView nrc1;
    private TextView nrc2;
    private RequestNetwork req;
    private TextView resect;
    private LinearLayout saveid1;
    private LinearLayout saveid2;
    private SeekBar seekbar3;
    private SeekBar seekbar4;
    private SeekBar seekbar5;
    private TimerTask t;
    private TextView textView;
    private TextView textview17;
    private TextView textview18;
    private TextView textview19;
    private TextView textview20;
    private TextView textview21;
    private TextView textview22;
    private TextView textview23;
    private TextView textview30;
    private TextView textview31;
    private TextView textview32;
    private TextView textview33;
    private TextView textview34;
    private TextView textview35;
    private TextView textview36;
    private TextView textview37;
    private TextView textview38;
    private TimerTask ti;
    private TimerTask timer5;
    private TimerTask timer6;
    private ScrollView vscroll1;
    private Timer _timer = new Timer();
    private String id = "";
    private String text_size = "";
    private double num1 = 0.0d;
    private double num2 = 0.0d;
    private double num3 = 0.0d;
    private double back = 0.0d;
    private Calendar c = Calendar.getInstance();
    private Intent i = new Intent();
    private Bitmap myImg = null;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.nationalid);
        initialize(bundle);
        if (ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") == -1 || ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == -1) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1000);
        } else {
            initializeLogic();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 1000) {
            initializeLogic();
        }
    }

    private void initialize(Bundle bundle) {
        this.linear1 = (LinearLayout) findViewById(R.id.linear1);
        this.linear156 = (LinearLayout) findViewById(R.id.linear156);
        this.linear155 = (LinearLayout) findViewById(R.id.linear155);
        this.vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
        this.linear119 = (LinearLayout) findViewById(R.id.linear119);
        this.bg_linear = (LinearLayout) findViewById(R.id.bg_linear);
        this.linear172 = (LinearLayout) findViewById(R.id.linear172);
        this.linear173 = (LinearLayout) findViewById(R.id.linear173);
        this.imageview77 = (ImageView) findViewById(R.id.imageview77);
        this.imageview83 = (ImageView) findViewById(R.id.imageview83);
        this.textview17 = (TextView) findViewById(R.id.textview17);
        this.imageview1 = (ImageView) findViewById(R.id.imageview1);
        this.linear145 = (LinearLayout) findViewById(R.id.linear145);
        this.linear152 = (LinearLayout) findViewById(R.id.linear152);
        this.linear158 = (LinearLayout) findViewById(R.id.linear158);
        this.linear160 = (LinearLayout) findViewById(R.id.linear160);
        this.hscroll2 = (HorizontalScrollView) findViewById(R.id.hscroll2);
        this.button = (ImageView) findViewById(R.id.button);
        this.imageview70 = (ImageView) findViewById(R.id.imageview70);
        this.linear120 = (LinearLayout) findViewById(R.id.linear120);
        this.linear121 = (LinearLayout) findViewById(R.id.linear121);
        this.linear122 = (LinearLayout) findViewById(R.id.linear122);
        this.linear123 = (LinearLayout) findViewById(R.id.linear123);
        this.linear124 = (LinearLayout) findViewById(R.id.linear124);
        this.linear126 = (LinearLayout) findViewById(R.id.linear126);
        this.linear127 = (LinearLayout) findViewById(R.id.linear127);
        this.linear128 = (LinearLayout) findViewById(R.id.linear128);
        this.linear129 = (LinearLayout) findViewById(R.id.linear129);
        this.linear130 = (LinearLayout) findViewById(R.id.linear130);
        this.linear162 = (LinearLayout) findViewById(R.id.linear162);
        this.linear164 = (LinearLayout) findViewById(R.id.linear164);
        this.linear165 = (LinearLayout) findViewById(R.id.linear165);
        this.linear168 = (LinearLayout) findViewById(R.id.linear168);
        this.imageview63 = (ImageView) findViewById(R.id.imageview63);
        this.imageview64 = (ImageView) findViewById(R.id.imageview64);
        this.imageview65 = (ImageView) findViewById(R.id.imageview65);
        this.imageview66 = (ImageView) findViewById(R.id.imageview66);
        this.imageview67 = (ImageView) findViewById(R.id.imageview67);
        this.imageview72 = (ImageView) findViewById(R.id.imageview72);
        this.imageview75 = (ImageView) findViewById(R.id.imageview75);
        this.linear174 = (LinearLayout) findViewById(R.id.linear174);
        this.linear175 = (LinearLayout) findViewById(R.id.linear175);
        this.linear182 = (LinearLayout) findViewById(R.id.linear182);
        this.linear187 = (LinearLayout) findViewById(R.id.linear187);
        this.textview32 = (TextView) findViewById(R.id.textview32);
        this.seekbar3 = (SeekBar) findViewById(R.id.seekbar3);
        this.textview33 = (TextView) findViewById(R.id.textview33);
        this.seekbar4 = (SeekBar) findViewById(R.id.seekbar4);
        this.textview34 = (TextView) findViewById(R.id.textview34);
        this.seekbar5 = (SeekBar) findViewById(R.id.seekbar5);
        this.textview38 = (TextView) findViewById(R.id.textview38);
        this.imageview84 = (ImageView) findViewById(R.id.imageview84);
        this.imageview85 = (ImageView) findViewById(R.id.imageview85);
        this.imageview86 = (ImageView) findViewById(R.id.imageview86);
        this.imageview87 = (ImageView) findViewById(R.id.imageview87);
        this.imageview88 = (ImageView) findViewById(R.id.imageview88);
        this.imageview89 = (ImageView) findViewById(R.id.imageview89);
        this.textview35 = (TextView) findViewById(R.id.textview35);
        this.linear113 = (LinearLayout) findViewById(R.id.linear113);
        this.linear177 = (LinearLayout) findViewById(R.id.linear177);
        this.saveid1 = (LinearLayout) findViewById(R.id.saveid1);
        this.linear161 = (LinearLayout) findViewById(R.id.linear161);
        this.linear118 = (LinearLayout) findViewById(R.id.linear118);
        this.saveid2 = (LinearLayout) findViewById(R.id.saveid2);
        this.editText = (TextView) findViewById(R.id.editText);
        this.key = (TextView) findViewById(R.id.key);
        this.resect = (TextView) findViewById(R.id.resect);
        this.dd = (TextView) findViewById(R.id.dd);
        this.dres = (TextView) findViewById(R.id.dres);
        this.textView = (TextView) findViewById(R.id.textView);
        this.linear153 = (LinearLayout) findViewById(R.id.linear153);
        this.linear170 = (LinearLayout) findViewById(R.id.linear170);
        this.linear184 = (LinearLayout) findViewById(R.id.linear184);
        this.imageview82 = (ImageView) findViewById(R.id.imageview82);
        this.textview19 = (TextView) findViewById(R.id.textview19);
        this.linear144 = (LinearLayout) findViewById(R.id.linear144);
        this.textview30 = (TextView) findViewById(R.id.textview30);
        this.imageview79 = (ImageView) findViewById(R.id.imageview79);
        this.imageview80 = (ImageView) findViewById(R.id.imageview80);
        this.linear185 = (LinearLayout) findViewById(R.id.linear185);
        this.imageview81 = (ImageView) findViewById(R.id.imageview81);
        this.textview36 = (TextView) findViewById(R.id.textview36);
        this.imageview2 = (ImageView) findViewById(R.id.imageview2);
        this.linear3 = (LinearLayout) findViewById(R.id.linear3);
        this.linear4 = (AbsoluteLayout) findViewById(R.id.linear4);
        this.no1 = (TextView) findViewById(R.id.no1);
        this.no2 = (TextView) findViewById(R.id.no2);
        this.name1 = (TextView) findViewById(R.id.name1);
        this.name2 = (TextView) findViewById(R.id.name2);
        this.nrc1 = (TextView) findViewById(R.id.nrc1);
        this.birth2 = (TextView) findViewById(R.id.birth2);
        this.nrc2 = (TextView) findViewById(R.id.nrc2);
        this.birth1 = (TextView) findViewById(R.id.birth1);
        this.blood1 = (TextView) findViewById(R.id.blood1);
        this.am2 = (TextView) findViewById(R.id.am2);
        this.imageview = (ImageView) findViewById(R.id.imageview);
        this.linear171 = (LinearLayout) findViewById(R.id.linear171);
        this.linear183 = (LinearLayout) findViewById(R.id.linear183);
        this.textview18 = (TextView) findViewById(R.id.textview18);
        this.linear154 = (LinearLayout) findViewById(R.id.linear154);
        this.textview31 = (TextView) findViewById(R.id.textview31);
        this.imageview69 = (ImageView) findViewById(R.id.imageview69);
        this.linear157 = (LinearLayout) findViewById(R.id.linear157);
        this.imageview78 = (ImageView) findViewById(R.id.imageview78);
        this.textview37 = (TextView) findViewById(R.id.textview37);
        this.imageview68 = (ImageView) findViewById(R.id.imageview68);
        this.linear169 = (AbsoluteLayout) findViewById(R.id.linear169);
        this.textview20 = (TextView) findViewById(R.id.textview20);
        this.textview21 = (TextView) findViewById(R.id.textview21);
        this.textview22 = (TextView) findViewById(R.id.textview22);
        this.textview23 = (TextView) findViewById(R.id.textview23);
        this.img = getSharedPreferences("img", 0);
        this.d = new AlertDialog.Builder(this);
        this.req = new RequestNetwork(this);
        this.imageview77.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.NationalidActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NationalidActivity.this.linear173.setVisibility(0);
                NationalidActivity.this.imageview77.setVisibility(8);
                NationalidActivity.this.imageview83.setVisibility(0);
            }
        });
        this.imageview83.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.NationalidActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NationalidActivity.this.linear173.setVisibility(8);
                NationalidActivity.this.imageview83.setVisibility(8);
                NationalidActivity.this.imageview77.setVisibility(0);
            }
        });
        this.imageview1.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.NationalidActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NationalidActivity.this.d.setTitle("မျဥ်းစောင်းများ");
                NationalidActivity.this.d.setIcon(R.drawable.nrc_2);
                NationalidActivity.this.d.setMessage("၁ / ကချင်ပြည်နယ်✅\n၂ / ကယားပြည်နယ်✅\n၃ / ကရင်ပြည်နယ်✅\n၄ / ချင်းပြည်နယ်✅\n၅ / စကိုင်းတိုင်း✅\n၆ / တနသ်ာရီတိုင်း✅\n၇ / ပဲးခူးတိုင်း✅\n၈ / မကွေးတိုင်း✅\n၉ / မန္တလေး / နေပြည်တော်✅\n၁၀ / မွန်ပြည်နယ်✅\n၁၁ / ရခိုင်ပြည်နယ်✅\n၁၂ / ရန်ကုန်တိုင်းဒေသကြီး✅\n၁၃ / ရှမ်းပြည်နယ်✅\n၁၄ / ဧရာဝတီတိုင်းဒေသကြီး✅");
                NationalidActivity.this.d.setPositiveButton("Ok", new DialogInterface.OnClickListener() { // from class: com.my.freemyanmarid.NationalidActivity.3.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SketchwareUtil.showMessage(NationalidActivity.this.getApplicationContext(), "ok");
                    }
                });
                NationalidActivity.this._clickAnimation(NationalidActivity.this.imageview1);
                NationalidActivity.this.d.create().show();
            }
        });
        this.button.setOnClickListener(new AnonymousClass4());
        this.imageview70.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.NationalidActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!NationalidActivity.this.textView.getText().toString().equals("")) {
                    NationalidActivity.this.resect.setText(String.valueOf((long) (Double.parseDouble(NationalidActivity.this.textView.getText().toString()) + Double.parseDouble("194076"))));
                    NationalidActivity.this.dres.setText(String.valueOf((long) (Double.parseDouble(NationalidActivity.this.resect.getText().toString()) * Double.parseDouble(NationalidActivity.this.dd.getText().toString()))));
                    if (NationalidActivity.this.key.getText().toString().equals(NationalidActivity.this.dres.getText().toString())) {
                        NationalidActivity.this.no1.setTextColor(-13762378);
                        NationalidActivity.this.no2.setTextColor(-13762378);
                        NationalidActivity.this.name1.setTextColor(-13762378);
                        NationalidActivity.this.name2.setTextColor(-13762378);
                        NationalidActivity.this.nrc1.setTextColor(-13762378);
                        NationalidActivity.this.birth2.setTextColor(-13762378);
                        NationalidActivity.this.nrc2.setTextColor(-13762378);
                        NationalidActivity.this.birth1.setTextColor(-13762378);
                        NationalidActivity.this.blood1.setTextColor(-13762378);
                        NationalidActivity.this.am2.setTextColor(-13762378);
                        NationalidActivity.this.textview20.setTextColor(-13762378);
                        NationalidActivity.this.textview21.setTextColor(-13762378);
                        NationalidActivity.this.textview22.setTextColor(-13762378);
                        NationalidActivity.this.textview23.setTextColor(-13762378);
                    } else {
                        SketchwareUtil.showMessage(NationalidActivity.this.getApplicationContext(), "Device Error - 📵");
                    }
                } else {
                    SketchwareUtil.showMessage(NationalidActivity.this.getApplicationContext(), "Device Error - 📵");
                }
                NationalidActivity.this._clickAnimation(NationalidActivity.this.imageview70);
            }
        });
        this.imageview63.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.NationalidActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!NationalidActivity.this.textView.getText().toString().equals("")) {
                    NationalidActivity.this.resect.setText(String.valueOf((long) (Double.parseDouble(NationalidActivity.this.textView.getText().toString()) + Double.parseDouble("194076"))));
                    NationalidActivity.this.dres.setText(String.valueOf((long) (Double.parseDouble(NationalidActivity.this.resect.getText().toString()) * Double.parseDouble(NationalidActivity.this.dd.getText().toString()))));
                    if (NationalidActivity.this.key.getText().toString().equals(NationalidActivity.this.dres.getText().toString())) {
                        NationalidActivity.this.no1.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                        NationalidActivity.this.no2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                        NationalidActivity.this.name1.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                        NationalidActivity.this.name2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                        NationalidActivity.this.nrc1.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                        NationalidActivity.this.birth2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                        NationalidActivity.this.nrc2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                        NationalidActivity.this.birth1.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                        NationalidActivity.this.blood1.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                        NationalidActivity.this.am2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                        NationalidActivity.this.textview20.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                        NationalidActivity.this.textview21.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                        NationalidActivity.this.textview22.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                        NationalidActivity.this.textview23.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    } else {
                        SketchwareUtil.showMessage(NationalidActivity.this.getApplicationContext(), "Device Error - 📵");
                    }
                } else {
                    SketchwareUtil.showMessage(NationalidActivity.this.getApplicationContext(), "Device Error - 📵");
                }
                NationalidActivity.this._clickAnimation(NationalidActivity.this.imageview63);
            }
        });
        this.imageview64.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.NationalidActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!NationalidActivity.this.textView.getText().toString().equals("")) {
                    NationalidActivity.this.resect.setText(String.valueOf((long) (Double.parseDouble(NationalidActivity.this.textView.getText().toString()) + Double.parseDouble("194076"))));
                    NationalidActivity.this.dres.setText(String.valueOf((long) (Double.parseDouble(NationalidActivity.this.resect.getText().toString()) * Double.parseDouble(NationalidActivity.this.dd.getText().toString()))));
                    if (NationalidActivity.this.key.getText().toString().equals(NationalidActivity.this.dres.getText().toString())) {
                        NationalidActivity.this.no1.setTextColor(-14934503);
                        NationalidActivity.this.no2.setTextColor(-14934503);
                        NationalidActivity.this.name1.setTextColor(-14934503);
                        NationalidActivity.this.name2.setTextColor(-14934503);
                        NationalidActivity.this.nrc1.setTextColor(-14934503);
                        NationalidActivity.this.birth2.setTextColor(-14934503);
                        NationalidActivity.this.nrc2.setTextColor(-14934503);
                        NationalidActivity.this.birth1.setTextColor(-14934503);
                        NationalidActivity.this.blood1.setTextColor(-14934503);
                        NationalidActivity.this.am2.setTextColor(-14934503);
                        NationalidActivity.this.textview20.setTextColor(-14934503);
                        NationalidActivity.this.textview21.setTextColor(-14934503);
                        NationalidActivity.this.textview22.setTextColor(-14934503);
                        NationalidActivity.this.textview23.setTextColor(-14934503);
                    } else {
                        SketchwareUtil.showMessage(NationalidActivity.this.getApplicationContext(), "Device Error - 📵");
                    }
                } else {
                    SketchwareUtil.showMessage(NationalidActivity.this.getApplicationContext(), "Device Error - 📵");
                }
                NationalidActivity.this._clickAnimation(NationalidActivity.this.imageview64);
            }
        });
        this.imageview65.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.NationalidActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!NationalidActivity.this.textView.getText().toString().equals("")) {
                    NationalidActivity.this.resect.setText(String.valueOf((long) (Double.parseDouble(NationalidActivity.this.textView.getText().toString()) + Double.parseDouble("194076"))));
                    NationalidActivity.this.dres.setText(String.valueOf((long) (Double.parseDouble(NationalidActivity.this.resect.getText().toString()) * Double.parseDouble(NationalidActivity.this.dd.getText().toString()))));
                    if (NationalidActivity.this.key.getText().toString().equals(NationalidActivity.this.dres.getText().toString())) {
                        NationalidActivity.this.no1.setTextColor(-16446821);
                        NationalidActivity.this.no2.setTextColor(-16446821);
                        NationalidActivity.this.name1.setTextColor(-16446821);
                        NationalidActivity.this.name2.setTextColor(-16446821);
                        NationalidActivity.this.nrc1.setTextColor(-16446821);
                        NationalidActivity.this.birth2.setTextColor(-16446821);
                        NationalidActivity.this.nrc2.setTextColor(-16446821);
                        NationalidActivity.this.birth1.setTextColor(-16446821);
                        NationalidActivity.this.blood1.setTextColor(-16446821);
                        NationalidActivity.this.am2.setTextColor(-16446821);
                        NationalidActivity.this.textview20.setTextColor(-16446821);
                        NationalidActivity.this.textview21.setTextColor(-16446821);
                        NationalidActivity.this.textview22.setTextColor(-16446821);
                        NationalidActivity.this.textview23.setTextColor(-16446821);
                    } else {
                        SketchwareUtil.showMessage(NationalidActivity.this.getApplicationContext(), "Device Error - 📵");
                    }
                } else {
                    SketchwareUtil.showMessage(NationalidActivity.this.getApplicationContext(), "Device Error - 📵");
                }
                NationalidActivity.this._clickAnimation(NationalidActivity.this.imageview65);
            }
        });
        this.imageview66.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.NationalidActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!NationalidActivity.this.textView.getText().toString().equals("")) {
                    NationalidActivity.this.resect.setText(String.valueOf((long) (Double.parseDouble(NationalidActivity.this.textView.getText().toString()) + Double.parseDouble("194076"))));
                    NationalidActivity.this.dres.setText(String.valueOf((long) (Double.parseDouble(NationalidActivity.this.resect.getText().toString()) * Double.parseDouble(NationalidActivity.this.dd.getText().toString()))));
                    if (NationalidActivity.this.key.getText().toString().equals(NationalidActivity.this.dres.getText().toString())) {
                        NationalidActivity.this.linear169.setBackgroundResource(R.drawable.nrc2);
                        NationalidActivity.this.linear4.setBackgroundResource(R.drawable.nrc1);
                    } else {
                        SketchwareUtil.showMessage(NationalidActivity.this.getApplicationContext(), "Device Error - 📵");
                    }
                } else {
                    SketchwareUtil.showMessage(NationalidActivity.this.getApplicationContext(), "Device Error - 📵");
                }
                NationalidActivity.this._clickAnimation(NationalidActivity.this.imageview66);
            }
        });
        this.imageview67.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.NationalidActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!NationalidActivity.this.textView.getText().toString().equals("")) {
                    NationalidActivity.this.resect.setText(String.valueOf((long) (Double.parseDouble(NationalidActivity.this.textView.getText().toString()) + Double.parseDouble("194076"))));
                    NationalidActivity.this.dres.setText(String.valueOf((long) (Double.parseDouble(NationalidActivity.this.resect.getText().toString()) * Double.parseDouble(NationalidActivity.this.dd.getText().toString()))));
                    if (NationalidActivity.this.key.getText().toString().equals(NationalidActivity.this.dres.getText().toString())) {
                        NationalidActivity.this.linear169.setBackgroundResource(R.drawable.ic_expand_less_white);
                        NationalidActivity.this.linear4.setBackgroundResource(R.drawable.ic_expand_more_white);
                    } else {
                        SketchwareUtil.showMessage(NationalidActivity.this.getApplicationContext(), "Device Error - 📵");
                    }
                } else {
                    SketchwareUtil.showMessage(NationalidActivity.this.getApplicationContext(), "Device Error - 📵");
                }
                NationalidActivity.this._clickAnimation(NationalidActivity.this.imageview67);
            }
        });
        this.imageview72.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.NationalidActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!NationalidActivity.this.textView.getText().toString().equals("")) {
                    NationalidActivity.this.resect.setText(String.valueOf((long) (Double.parseDouble(NationalidActivity.this.textView.getText().toString()) + Double.parseDouble("194076"))));
                    NationalidActivity.this.dres.setText(String.valueOf((long) (Double.parseDouble(NationalidActivity.this.resect.getText().toString()) * Double.parseDouble(NationalidActivity.this.dd.getText().toString()))));
                    if (NationalidActivity.this.key.getText().toString().equals(NationalidActivity.this.dres.getText().toString())) {
                        NationalidActivity.this.linear4.setBackgroundResource(R.drawable.put_2);
                        NationalidActivity.this.linear169.setBackgroundResource(R.drawable.put_1);
                    } else {
                        SketchwareUtil.showMessage(NationalidActivity.this.getApplicationContext(), "Device Error - 📵");
                    }
                } else {
                    SketchwareUtil.showMessage(NationalidActivity.this.getApplicationContext(), "Device Error - 📵");
                }
                NationalidActivity.this._clickAnimation(NationalidActivity.this.imageview72);
            }
        });
        this.imageview75.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.NationalidActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!NationalidActivity.this.textView.getText().toString().equals("")) {
                    NationalidActivity.this.resect.setText(String.valueOf((long) (Double.parseDouble(NationalidActivity.this.textView.getText().toString()) + Double.parseDouble("194076"))));
                    NationalidActivity.this.dres.setText(String.valueOf((long) (Double.parseDouble(NationalidActivity.this.resect.getText().toString()) * Double.parseDouble(NationalidActivity.this.dd.getText().toString()))));
                    if (NationalidActivity.this.key.getText().toString().equals(NationalidActivity.this.dres.getText().toString())) {
                        NationalidActivity.this.linear4.setBackgroundResource(R.drawable.nrc_2);
                        NationalidActivity.this.linear169.setBackgroundResource(R.drawable.nrc_1);
                    } else {
                        SketchwareUtil.showMessage(NationalidActivity.this.getApplicationContext(), "Device Error - 📵");
                    }
                } else {
                    SketchwareUtil.showMessage(NationalidActivity.this.getApplicationContext(), "Device Error - 📵");
                }
                NationalidActivity.this._clickAnimation(NationalidActivity.this.imageview75);
            }
        });
        this.seekbar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.my.freemyanmarid.NationalidActivity.13
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (NationalidActivity.this.myImg == null) {
                    NationalidActivity.this.myImg = ((BitmapDrawable) NationalidActivity.this.imageview.getDrawable()).getBitmap();
                }
                Matrix matrix = new Matrix();
                matrix.postRotate(i);
                NationalidActivity.this.imageview.setImageBitmap(Bitmap.createBitmap(NationalidActivity.this.myImg, 0, 0, NationalidActivity.this.myImg.getWidth(), NationalidActivity.this.myImg.getHeight(), matrix, true));
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.seekbar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.my.freemyanmarid.NationalidActivity.14
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                NationalidActivity.this.seekbar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.my.freemyanmarid.NationalidActivity.14.1
                    @Override // android.widget.SeekBar.OnSeekBarChangeListener
                    public void onProgressChanged(SeekBar seekBar2, int i2, boolean z2) {
                        NationalidActivity.this.imageview.getLayoutParams().width = i2;
                        NationalidActivity.this.imageview.getLayoutParams().height = i2;
                        NationalidActivity.this.imageview.requestLayout();
                    }

                    @Override // android.widget.SeekBar.OnSeekBarChangeListener
                    public void onStartTrackingTouch(SeekBar seekBar2) {
                    }

                    @Override // android.widget.SeekBar.OnSeekBarChangeListener
                    public void onStopTrackingTouch(SeekBar seekBar2) {
                    }
                });
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.seekbar5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.my.freemyanmarid.NationalidActivity.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                NationalidActivity.this._text_sizee(NationalidActivity.this.textview20, i);
                NationalidActivity.this._text_sizee(NationalidActivity.this.textview21, i);
                NationalidActivity.this._text_sizee(NationalidActivity.this.textview22, i);
                NationalidActivity.this._text_sizee(NationalidActivity.this.textview23, i);
                NationalidActivity.this._text_sizee(NationalidActivity.this.no1, i);
                NationalidActivity.this._text_sizee(NationalidActivity.this.no2, i);
                NationalidActivity.this._text_sizee(NationalidActivity.this.name1, i);
                NationalidActivity.this._text_sizee(NationalidActivity.this.name2, i);
                NationalidActivity.this._text_sizee(NationalidActivity.this.nrc1, i);
                NationalidActivity.this._text_sizee(NationalidActivity.this.nrc2, i);
                NationalidActivity.this._text_sizee(NationalidActivity.this.birth2, i);
                NationalidActivity.this._text_sizee(NationalidActivity.this.birth1, i);
                NationalidActivity.this._text_sizee(NationalidActivity.this.blood1, i);
                NationalidActivity.this._text_sizee(NationalidActivity.this.am2, i);
                NationalidActivity.this.textview35.setText(new DecimalFormat("0").format(i));
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.imageview84.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.NationalidActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NationalidActivity.this.no1.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/oo8.ttf"), 0);
                NationalidActivity.this.no2.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/oo8.ttf"), 0);
                NationalidActivity.this.name1.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/oo8.ttf"), 0);
                NationalidActivity.this.name2.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/oo8.ttf"), 0);
                NationalidActivity.this.nrc1.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/oo8.ttf"), 0);
                NationalidActivity.this.nrc2.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/oo8.ttf"), 0);
                NationalidActivity.this.birth2.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/oo8.ttf"), 0);
                NationalidActivity.this.birth1.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/oo8.ttf"), 0);
                NationalidActivity.this.blood1.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/oo8.ttf"), 0);
                NationalidActivity.this.am2.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/oo8.ttf"), 0);
                NationalidActivity.this.textview20.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/oo8.ttf"), 0);
                NationalidActivity.this.textview21.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/oo8.ttf"), 0);
                NationalidActivity.this.textview22.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/oo8.ttf"), 0);
                NationalidActivity.this.textview23.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/signn.ttf"), 1);
                NationalidActivity.this._clickAnimation(NationalidActivity.this.imageview84);
            }
        });
        this.imageview85.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.NationalidActivity.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NationalidActivity.this.no1.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/burma.ttf"), 0);
                NationalidActivity.this.no2.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/burma.ttf"), 0);
                NationalidActivity.this.name1.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/burma.ttf"), 0);
                NationalidActivity.this.name2.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/burma.ttf"), 0);
                NationalidActivity.this.nrc1.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/burma.ttf"), 0);
                NationalidActivity.this.nrc2.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/burma.ttf"), 0);
                NationalidActivity.this.birth2.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/burma.ttf"), 0);
                NationalidActivity.this.birth1.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/burma.ttf"), 0);
                NationalidActivity.this.blood1.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/burma.ttf"), 0);
                NationalidActivity.this.am2.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/burma.ttf"), 0);
                NationalidActivity.this.textview20.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/burma.ttf"), 0);
                NationalidActivity.this.textview21.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/burma.ttf"), 0);
                NationalidActivity.this.textview22.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/burma.ttf"), 0);
                NationalidActivity.this.textview23.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/signn.ttf"), 1);
                NationalidActivity.this._clickAnimation(NationalidActivity.this.imageview85);
            }
        });
        this.imageview86.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.NationalidActivity.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NationalidActivity.this.no1.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/burma1.ttf"), 0);
                NationalidActivity.this.no2.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/burma1.ttf"), 0);
                NationalidActivity.this.name1.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/burma1.ttf"), 0);
                NationalidActivity.this.name2.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/burma1.ttf"), 0);
                NationalidActivity.this.nrc1.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/burma1.ttf"), 0);
                NationalidActivity.this.nrc2.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/burma1.ttf"), 0);
                NationalidActivity.this.birth2.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/burma1.ttf"), 0);
                NationalidActivity.this.birth1.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/burma1.ttf"), 0);
                NationalidActivity.this.blood1.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/burma1.ttf"), 0);
                NationalidActivity.this.am2.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/burma1.ttf"), 0);
                NationalidActivity.this.textview20.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/burma1.ttf"), 0);
                NationalidActivity.this.textview21.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/burma1.ttf"), 0);
                NationalidActivity.this.textview22.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/burma1.ttf"), 0);
                NationalidActivity.this.textview23.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/signn.ttf"), 1);
                NationalidActivity.this._clickAnimation(NationalidActivity.this.imageview86);
            }
        });
        this.imageview87.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.NationalidActivity.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NationalidActivity.this.no1.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/oo8.ttf"), 0);
                NationalidActivity.this.no2.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/burma.ttf"), 0);
                NationalidActivity.this.name1.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/oo8.ttf"), 0);
                NationalidActivity.this.name2.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/burma.ttf"), 0);
                NationalidActivity.this.nrc1.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/oo8.ttf"), 0);
                NationalidActivity.this.nrc2.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/burma.ttf"), 0);
                NationalidActivity.this.birth2.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/oo8.ttf"), 0);
                NationalidActivity.this.birth1.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/burma.ttf"), 0);
                NationalidActivity.this.blood1.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/oo8.ttf"), 0);
                NationalidActivity.this.am2.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/burma.ttf"), 0);
                NationalidActivity.this.textview20.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/oo8.ttf"), 0);
                NationalidActivity.this.textview21.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/burma.ttf"), 0);
                NationalidActivity.this.textview22.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/oo8.ttf"), 0);
                NationalidActivity.this.textview23.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/signn.ttf"), 1);
                NationalidActivity.this._clickAnimation(NationalidActivity.this.imageview87);
            }
        });
        this.imageview88.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.NationalidActivity.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NationalidActivity.this.no1.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/pitopatcatchree.ttf"), 0);
                NationalidActivity.this.no2.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/pitopatcatchree.ttf"), 0);
                NationalidActivity.this.name1.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/pitopatcatchree.ttf"), 0);
                NationalidActivity.this.name2.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/pitopatcatchree.ttf"), 0);
                NationalidActivity.this.nrc1.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/pitopatcatchree.ttf"), 0);
                NationalidActivity.this.nrc2.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/pitopatcatchree.ttf"), 0);
                NationalidActivity.this.birth2.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/pitopatcatchree.ttf"), 0);
                NationalidActivity.this.birth1.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/pitopatcatchree.ttf"), 0);
                NationalidActivity.this.blood1.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/pitopatcatchree.ttf"), 0);
                NationalidActivity.this.am2.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/pitopatcatchree.ttf"), 0);
                NationalidActivity.this.textview20.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/pitopatcatchree.ttf"), 0);
                NationalidActivity.this.textview21.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/pitopatcatchree.ttf"), 0);
                NationalidActivity.this.textview22.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/pitopatcatchree.ttf"), 0);
                NationalidActivity.this.textview23.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/signn.ttf"), 1);
                NationalidActivity.this._clickAnimation(NationalidActivity.this.imageview88);
            }
        });
        this.imageview89.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.NationalidActivity.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NationalidActivity.this.no1.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/bezee.ttf"), 0);
                NationalidActivity.this.no2.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/bezee.ttf"), 0);
                NationalidActivity.this.name1.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/bezee.ttf"), 0);
                NationalidActivity.this.name2.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/bezee.ttf"), 0);
                NationalidActivity.this.nrc1.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/bezee.ttf"), 0);
                NationalidActivity.this.nrc2.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/bezee.ttf"), 0);
                NationalidActivity.this.birth2.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/bezee.ttf"), 0);
                NationalidActivity.this.birth1.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/bezee.ttf"), 0);
                NationalidActivity.this.blood1.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/bezee.ttf"), 0);
                NationalidActivity.this.am2.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/bezee.ttf"), 0);
                NationalidActivity.this.textview20.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/bezee.ttf"), 0);
                NationalidActivity.this.textview21.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/bezee.ttf"), 0);
                NationalidActivity.this.textview22.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/bezee.ttf"), 0);
                NationalidActivity.this.textview23.setTypeface(Typeface.createFromAsset(NationalidActivity.this.getAssets(), "fonts/signn.ttf"), 1);
                NationalidActivity.this._clickAnimation(NationalidActivity.this.imageview89);
            }
        });
        this.imageview82.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.NationalidActivity.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NationalidActivity.this.imageview.setAlpha((float) (NationalidActivity.this.imageview.getAlpha() - 0.1d));
                NationalidActivity.this._clickAnimation(NationalidActivity.this.imageview82);
            }
        });
        this.linear144.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.NationalidActivity.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.imageview79.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.NationalidActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NationalidActivity.this.no1.setAlpha((float) (NationalidActivity.this.no1.getAlpha() + 0.1d));
                NationalidActivity.this.no2.setAlpha((float) (NationalidActivity.this.no2.getAlpha() + 0.1d));
                NationalidActivity.this.name1.setAlpha((float) (NationalidActivity.this.name1.getAlpha() + 0.1d));
                NationalidActivity.this.name2.setAlpha((float) (NationalidActivity.this.name2.getAlpha() + 0.1d));
                NationalidActivity.this.nrc1.setAlpha((float) (NationalidActivity.this.nrc1.getAlpha() + 0.1d));
                NationalidActivity.this.birth2.setAlpha((float) (NationalidActivity.this.birth2.getAlpha() + 0.1d));
                NationalidActivity.this.nrc2.setAlpha((float) (NationalidActivity.this.nrc2.getAlpha() + 0.1d));
                NationalidActivity.this.birth1.setAlpha((float) (NationalidActivity.this.birth1.getAlpha() + 0.1d));
                NationalidActivity.this.blood1.setAlpha((float) (NationalidActivity.this.blood1.getAlpha() + 0.1d));
                NationalidActivity.this.am2.setAlpha((float) (NationalidActivity.this.am2.getAlpha() + 0.1d));
                NationalidActivity.this._clickAnimation(NationalidActivity.this.imageview79);
            }
        });
        this.imageview80.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.NationalidActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NationalidActivity.this.no1.setAlpha((float) (NationalidActivity.this.no1.getAlpha() - 0.1d));
                NationalidActivity.this.no2.setAlpha((float) (NationalidActivity.this.no2.getAlpha() - 0.1d));
                NationalidActivity.this.name1.setAlpha((float) (NationalidActivity.this.name1.getAlpha() - 0.1d));
                NationalidActivity.this.name2.setAlpha((float) (NationalidActivity.this.name2.getAlpha() - 0.1d));
                NationalidActivity.this.nrc1.setAlpha((float) (NationalidActivity.this.nrc1.getAlpha() - 0.1d));
                NationalidActivity.this.birth2.setAlpha((float) (NationalidActivity.this.birth2.getAlpha() - 0.1d));
                NationalidActivity.this.nrc2.setAlpha((float) (NationalidActivity.this.nrc2.getAlpha() - 0.1d));
                NationalidActivity.this.birth1.setAlpha((float) (NationalidActivity.this.birth1.getAlpha() - 0.1d));
                NationalidActivity.this.blood1.setAlpha((float) (NationalidActivity.this.blood1.getAlpha() - 0.1d));
                NationalidActivity.this.am2.setAlpha((float) (NationalidActivity.this.am2.getAlpha() - 0.1d));
                NationalidActivity.this._clickAnimation(NationalidActivity.this.imageview80);
            }
        });
        this.imageview81.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.NationalidActivity.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NationalidActivity.this.imageview.setAlpha((float) (NationalidActivity.this.imageview.getAlpha() + 0.1d));
                NationalidActivity.this._clickAnimation(NationalidActivity.this.imageview81);
            }
        });
        this.imageview2.setOnClickListener(new AnonymousClass27());
        this.imageview.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.NationalidActivity.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.imageview69.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.NationalidActivity.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NationalidActivity.this.textview20.setAlpha((float) (NationalidActivity.this.textview20.getAlpha() + 0.1d));
                NationalidActivity.this.textview21.setAlpha((float) (NationalidActivity.this.textview21.getAlpha() + 0.1d));
                NationalidActivity.this.textview22.setAlpha((float) (NationalidActivity.this.textview22.getAlpha() + 0.1d));
                NationalidActivity.this.textview23.setAlpha((float) (NationalidActivity.this.textview23.getAlpha() + 0.1d));
                NationalidActivity.this._clickAnimation(NationalidActivity.this.imageview69);
            }
        });
        this.imageview78.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.NationalidActivity.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NationalidActivity.this.textview20.setAlpha((float) (NationalidActivity.this.textview20.getAlpha() - 0.1d));
                NationalidActivity.this.textview21.setAlpha((float) (NationalidActivity.this.textview21.getAlpha() - 0.1d));
                NationalidActivity.this.textview22.setAlpha((float) (NationalidActivity.this.textview22.getAlpha() - 0.1d));
                NationalidActivity.this.textview23.setAlpha((float) (NationalidActivity.this.textview23.getAlpha() - 0.1d));
                NationalidActivity.this._clickAnimation(NationalidActivity.this.imageview78);
            }
        });
        this.imageview68.setOnClickListener(new AnonymousClass31());
        this._req_request_listener = new RequestNetwork.RequestListener() { // from class: com.my.freemyanmarid.NationalidActivity.32
            @Override // com.my.freemyanmarid.RequestNetwork.RequestListener
            public void onResponse(String str, String str2, HashMap<String, Object> map) {
            }

            @Override // com.my.freemyanmarid.RequestNetwork.RequestListener
            public void onErrorResponse(String str, String str2) {
            }
        };
    }

    /* renamed from: com.my.freemyanmarid.NationalidActivity$4, reason: invalid class name */
    class AnonymousClass4 implements View.OnClickListener {
        AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NationalidActivity.this.back == 1.0d) {
                SketchwareUtil.showMessage(NationalidActivity.this.getApplicationContext(), "success");
            } else {
                SketchwareUtil.showMessage(NationalidActivity.this.getApplicationContext(), "အတည်ပြုရန်နှစ်ချက်နိတ်ပါ");
                NationalidActivity.this.back = 1.0d;
                NationalidActivity.this.ti = new TimerTask() { // from class: com.my.freemyanmarid.NationalidActivity.4.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        NationalidActivity.this.runOnUiThread(new Runnable() { // from class: com.my.freemyanmarid.NationalidActivity.4.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                NationalidActivity.this.back = 0.0d;
                            }
                        });
                    }
                };
                NationalidActivity.this._timer.schedule(NationalidActivity.this.ti, 1500L);
            }
            NationalidActivity.this.button.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.NationalidActivity.4.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    String string = NationalidActivity.this.editText.getText().toString();
                    StringBuilder sb = new StringBuilder();
                    char[] charArray = string.toCharArray();
                    for (char c : charArray) {
                        if (Character.isDigit(c)) {
                            sb.append(c);
                        }
                    }
                    NationalidActivity.this.textView.setText(sb.toString());
                }
            });
            NationalidActivity.this._clickAnimation(NationalidActivity.this.button);
        }
    }

    /* renamed from: com.my.freemyanmarid.NationalidActivity$27, reason: invalid class name */
    class AnonymousClass27 implements View.OnClickListener {
        AnonymousClass27() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IOException {
            if (!NationalidActivity.this.textView.getText().toString().equals("")) {
                NationalidActivity.this.resect.setText(String.valueOf((long) (Double.parseDouble(NationalidActivity.this.textView.getText().toString()) + Double.parseDouble("194076"))));
                NationalidActivity.this.dres.setText(String.valueOf((long) (Double.parseDouble(NationalidActivity.this.resect.getText().toString()) * Double.parseDouble(NationalidActivity.this.dd.getText().toString()))));
                if (NationalidActivity.this.key.getText().toString().equals(NationalidActivity.this.dres.getText().toString())) {
                    NationalidActivity.this.c = Calendar.getInstance();
                    NationalidActivity.this._SaveViewAsImage(NationalidActivity.this.linear4, FileUtil.getPublicDir(Environment.DIRECTORY_PICTURES).concat("/Myanmar 3in1/Nrc/Front/".concat(new SimpleDateFormat("ddMMyyyy-hhmmss").format(NationalidActivity.this.c.getTime()).concat(".png"))));
                } else {
                    NationalidActivity.this.ti = new TimerTask() { // from class: com.my.freemyanmarid.NationalidActivity.27.1
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            NationalidActivity.this.runOnUiThread(new Runnable() { // from class: com.my.freemyanmarid.NationalidActivity.27.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    NationalidActivity.this.i.setAction("android.intent.action.VIEW");
                                    NationalidActivity.this.i.setClass(NationalidActivity.this.getApplicationContext(), BypassActivity.class);
                                    NationalidActivity.this.startActivity(NationalidActivity.this.i);
                                }
                            });
                        }
                    };
                    NationalidActivity.this._timer.schedule(NationalidActivity.this.ti, 500L);
                    SketchwareUtil.showMessage(NationalidActivity.this.getApplicationContext(), "Device Error - 📵");
                }
            } else {
                SketchwareUtil.showMessage(NationalidActivity.this.getApplicationContext(), "Device Error - 📵");
            }
            NationalidActivity.this._clickAnimation(NationalidActivity.this.imageview2);
        }
    }

    /* renamed from: com.my.freemyanmarid.NationalidActivity$31, reason: invalid class name */
    class AnonymousClass31 implements View.OnClickListener {
        AnonymousClass31() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IOException {
            if (!NationalidActivity.this.textView.getText().toString().equals("")) {
                NationalidActivity.this.resect.setText(String.valueOf((long) (Double.parseDouble(NationalidActivity.this.textView.getText().toString()) + Double.parseDouble("194076"))));
                NationalidActivity.this.dres.setText(String.valueOf((long) (Double.parseDouble(NationalidActivity.this.resect.getText().toString()) * Double.parseDouble(NationalidActivity.this.dd.getText().toString()))));
                if (NationalidActivity.this.key.getText().toString().equals(NationalidActivity.this.dres.getText().toString())) {
                    NationalidActivity.this.c = Calendar.getInstance();
                    NationalidActivity.this._SaveViewAsImage(NationalidActivity.this.linear169, FileUtil.getPublicDir(Environment.DIRECTORY_PICTURES).concat("/Myanmar 3in1/Nrc/Back/".concat(new SimpleDateFormat("ddMMyyyy-hhmmss").format(NationalidActivity.this.c.getTime()).concat(".png"))));
                } else {
                    NationalidActivity.this.ti = new TimerTask() { // from class: com.my.freemyanmarid.NationalidActivity.31.1
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            NationalidActivity.this.runOnUiThread(new Runnable() { // from class: com.my.freemyanmarid.NationalidActivity.31.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    NationalidActivity.this.i.setAction("android.intent.action.VIEW");
                                    NationalidActivity.this.i.setClass(NationalidActivity.this.getApplicationContext(), BypassActivity.class);
                                    NationalidActivity.this.startActivity(NationalidActivity.this.i);
                                }
                            });
                        }
                    };
                    NationalidActivity.this._timer.schedule(NationalidActivity.this.ti, 500L);
                    SketchwareUtil.showMessage(NationalidActivity.this.getApplicationContext(), "Device Error - 📵");
                }
            } else {
                SketchwareUtil.showMessage(NationalidActivity.this.getApplicationContext(), "Device Error - 📵");
            }
            NationalidActivity.this._clickAnimation(NationalidActivity.this.imageview68);
        }
    }

    private void initializeLogic() {
        if (Build.VERSION.SDK_INT > 19) {
            Window window = getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(-16777034);
        }
        this.no1.setText(getIntent().getStringExtra("no1"));
        this.no2.setText(getIntent().getStringExtra("no2"));
        this.name1.setText(getIntent().getStringExtra("na1"));
        this.name2.setText(getIntent().getStringExtra("na2"));
        this.nrc1.setText(getIntent().getStringExtra("nr1"));
        this.nrc2.setText(getIntent().getStringExtra("nr2"));
        this.birth1.setText(getIntent().getStringExtra("bi1"));
        this.birth2.setText(getIntent().getStringExtra("bi2"));
        this.blood1.setText(getIntent().getStringExtra("ty1"));
        this.key.setText(getIntent().getStringExtra("key"));
        this.am2.setText(getIntent().getStringExtra("am2"));
        this.textview20.setText(getIntent().getStringExtra("jt1"));
        this.textview21.setText(getIntent().getStringExtra("lc1"));
        this.textview22.setText(getIntent().getStringExtra("mn1"));
        this.textview23.setText(getIntent().getStringExtra("sig1"));
        _Dragable(this.no1);
        _Dragable(this.no2);
        _Dragable(this.name1);
        _Dragable(this.name2);
        _Dragable(this.nrc1);
        _Dragable(this.nrc2);
        _Dragable(this.birth1);
        _Dragable(this.birth2);
        _Dragable(this.blood1);
        _Dragable(this.imageview);
        _Dragable(this.am2);
        _Dragable(this.textview20);
        _Dragable(this.textview21);
        _Dragable(this.textview22);
        _Dragable(this.textview23);
        this.no1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oo8.ttf"), 1);
        this.no2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oo8.ttf"), 1);
        this.name1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oo8.ttf"), 1);
        this.name2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oo8.ttf"), 1);
        this.nrc1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oo8.ttf"), 1);
        this.nrc2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oo8.ttf"), 1);
        this.birth1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oo8.ttf"), 1);
        this.birth2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oo8.ttf"), 1);
        this.blood1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oo8.ttf"), 1);
        this.textview34.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/hal.ttf"), 0);
        this.textview19.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/bold.ttf"), 0);
        this.textview18.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/bold.ttf"), 0);
        this.am2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oo8.ttf"), 1);
        this.textview17.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/bold.ttf"), 0);
        this.textview30.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/hal.ttf"), 0);
        this.textview31.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/hal.ttf"), 0);
        this.textview32.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/hal.ttf"), 0);
        this.textview33.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/hal.ttf"), 0);
        this.textview36.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/hal.ttf"), 0);
        this.textview37.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/hal.ttf"), 0);
        this.textview38.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/hal.ttf"), 0);
        this.textview20.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oo8.ttf"), 1);
        this.textview21.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oo8.ttf"), 1);
        this.textview22.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oo8.ttf"), 1);
        this.textview23.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/signn.ttf"), 1);
        _setTextSize(this.no1, Double.parseDouble("18"));
        _setTextSize(this.no2, Double.parseDouble("18"));
        _setTextSize(this.name1, Double.parseDouble("18"));
        _setTextSize(this.name2, Double.parseDouble("18"));
        _setTextSize(this.nrc1, Double.parseDouble("18"));
        _setTextSize(this.nrc2, Double.parseDouble("18"));
        _setTextSize(this.birth1, Double.parseDouble("18"));
        _setTextSize(this.birth2, Double.parseDouble("18"));
        _setTextSize(this.blood1, Double.parseDouble("18"));
        _setTextSize(this.am2, Double.parseDouble("18"));
        _setTextSize(this.textview20, Double.parseDouble("18"));
        _setTextSize(this.textview21, Double.parseDouble("18"));
        _setTextSize(this.textview22, Double.parseDouble("18"));
        _setTextSize(this.textview23, Double.parseDouble("18"));
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#0000B6"), Color.parseColor("#0000B6")});
        gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 50.0f, 50.0f, 50.0f, 50.0f});
        gradientDrawable.setStroke(0, Color.parseColor("#000000"));
        this.linear156.setElevation(3.0f);
        this.linear156.setBackground(gradientDrawable);
        this.id = Settings.Secure.getString(getApplicationContext().getContentResolver(), "android_id");
        this.editText.setText(this.id);
        this.textView.setVisibility(8);
        this.resect.setVisibility(8);
        this.key.setVisibility(8);
        this.editText.setVisibility(8);
        this.t = new TimerTask() { // from class: com.my.freemyanmarid.NationalidActivity.33
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                NationalidActivity.this.runOnUiThread(new Runnable() { // from class: com.my.freemyanmarid.NationalidActivity.33.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NationalidActivity.this.linear4.setBackgroundResource(R.drawable.nrc1);
                    }
                });
            }
        };
        this._timer.schedule(this.t, 500L);
        this.t = new TimerTask() { // from class: com.my.freemyanmarid.NationalidActivity.34
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                NationalidActivity.this.runOnUiThread(new Runnable() { // from class: com.my.freemyanmarid.NationalidActivity.34.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NationalidActivity.this.linear4.setBackgroundResource(R.drawable.nrc1);
                    }
                });
            }
        };
        this._timer.schedule(this.t, 500L);
        if (this.img.getString("image", "").equals("")) {
            this.imageview.setImageResource(R.drawable.depositphotos);
        } else {
            this.imageview.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(this.img.getString("image", ""), 1024, 1024));
        }
        _rippleRoundStroke(this.linear121, "#FF0000B6", "#27282D", 15.0d, 3.0d, "#27282D");
        _rippleRoundStroke(this.linear123, "#FF0000B6", "#27282D", 15.0d, 3.0d, "#27282D");
        _rippleRoundStroke(this.linear126, "#FF0000B6", "#27282D", 15.0d, 3.0d, "#27282D");
        _rippleRoundStroke(this.linear128, "#FF0000B6", "#27282D", 15.0d, 3.0d, "#27282D");
        _rippleRoundStroke(this.linear130, "#FF0000B6", "#27282D", 15.0d, 3.0d, "#27282D");
        _rippleRoundStroke(this.bg_linear, "#FFFFFF", "#27282D", 15.0d, 3.0d, "#27282D");
        _rippleRoundStroke(this.linear144, "#FF0000B6", "#27282D", 15.0d, 0.0d, "#27282D");
        _rippleRoundStroke(this.linear154, "#FF0000B6", "#27282D", 15.0d, 0.0d, "#27282D");
        _rippleRoundStroke(this.linear145, "#FF0000B6", "#27282D", 15.0d, 3.0d, "#27282D");
        _rippleRoundStroke(this.linear158, "#FF0000B6", "#27282D", 15.0d, 3.0d, "#27282D");
        _rippleRoundStroke(this.linear164, "#FF0000B6", "#27282D", 15.0d, 3.0d, "#27282D");
        _rippleRoundStroke(this.linear168, "#FF0000B6", "#27282D", 15.0d, 3.0d, "#27282D");
        _rippleRoundStroke(this.linear183, "#FF313131", "#27282D", 15.0d, 0.0d, "#27282D");
        _rippleRoundStroke(this.linear184, "#FF313131", "#27282D", 15.0d, 0.0d, "#27282D");
        this.t = new TimerTask() { // from class: com.my.freemyanmarid.NationalidActivity.35
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                NationalidActivity.this.runOnUiThread(new Runnable() { // from class: com.my.freemyanmarid.NationalidActivity.35.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Build.VERSION.SDK_INT >= 11) {
                            NationalidActivity.this.textview20.setLayerType(1, null);
                        }
                        NationalidActivity.this.textview20.getPaint().setMaskFilter(new BlurMaskFilter(NationalidActivity.this.textview20.getTextSize() / 40.0f, BlurMaskFilter.Blur.NORMAL));
                    }
                });
            }
        };
        this._timer.schedule(this.t, 100L);
        this.t = new TimerTask() { // from class: com.my.freemyanmarid.NationalidActivity.36
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                NationalidActivity.this.runOnUiThread(new Runnable() { // from class: com.my.freemyanmarid.NationalidActivity.36.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Build.VERSION.SDK_INT >= 11) {
                            NationalidActivity.this.textview21.setLayerType(1, null);
                        }
                        NationalidActivity.this.textview21.getPaint().setMaskFilter(new BlurMaskFilter(NationalidActivity.this.textview21.getTextSize() / 40.0f, BlurMaskFilter.Blur.NORMAL));
                    }
                });
            }
        };
        this._timer.schedule(this.t, 100L);
        this.t = new TimerTask() { // from class: com.my.freemyanmarid.NationalidActivity.37
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                NationalidActivity.this.runOnUiThread(new Runnable() { // from class: com.my.freemyanmarid.NationalidActivity.37.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Build.VERSION.SDK_INT >= 11) {
                            NationalidActivity.this.textview22.setLayerType(1, null);
                        }
                        NationalidActivity.this.textview22.getPaint().setMaskFilter(new BlurMaskFilter(NationalidActivity.this.textview22.getTextSize() / 40.0f, BlurMaskFilter.Blur.NORMAL));
                    }
                });
            }
        };
        this._timer.schedule(this.t, 100L);
        this.t = new TimerTask() { // from class: com.my.freemyanmarid.NationalidActivity.38
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                NationalidActivity.this.runOnUiThread(new Runnable() { // from class: com.my.freemyanmarid.NationalidActivity.38.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Build.VERSION.SDK_INT >= 11) {
                            NationalidActivity.this.textview23.setLayerType(1, null);
                        }
                        NationalidActivity.this.textview23.getPaint().setMaskFilter(new BlurMaskFilter(NationalidActivity.this.textview23.getTextSize() / 40.0f, BlurMaskFilter.Blur.NORMAL));
                    }
                });
            }
        };
        this._timer.schedule(this.t, 100L);
        this.t = new TimerTask() { // from class: com.my.freemyanmarid.NationalidActivity.39
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                NationalidActivity.this.runOnUiThread(new Runnable() { // from class: com.my.freemyanmarid.NationalidActivity.39.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Build.VERSION.SDK_INT >= 11) {
                            NationalidActivity.this.no1.setLayerType(1, null);
                        }
                        NationalidActivity.this.no1.getPaint().setMaskFilter(new BlurMaskFilter(NationalidActivity.this.no1.getTextSize() / 40.0f, BlurMaskFilter.Blur.NORMAL));
                    }
                });
            }
        };
        this._timer.schedule(this.t, 100L);
        this.t = new TimerTask() { // from class: com.my.freemyanmarid.NationalidActivity.40
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                NationalidActivity.this.runOnUiThread(new Runnable() { // from class: com.my.freemyanmarid.NationalidActivity.40.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Build.VERSION.SDK_INT >= 11) {
                            NationalidActivity.this.no2.setLayerType(1, null);
                        }
                        NationalidActivity.this.no2.getPaint().setMaskFilter(new BlurMaskFilter(NationalidActivity.this.no2.getTextSize() / 40.0f, BlurMaskFilter.Blur.NORMAL));
                    }
                });
            }
        };
        this._timer.schedule(this.t, 100L);
        this.t = new TimerTask() { // from class: com.my.freemyanmarid.NationalidActivity.41
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                NationalidActivity.this.runOnUiThread(new Runnable() { // from class: com.my.freemyanmarid.NationalidActivity.41.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Build.VERSION.SDK_INT >= 11) {
                            NationalidActivity.this.name1.setLayerType(1, null);
                        }
                        NationalidActivity.this.name1.getPaint().setMaskFilter(new BlurMaskFilter(NationalidActivity.this.name1.getTextSize() / 40.0f, BlurMaskFilter.Blur.NORMAL));
                    }
                });
            }
        };
        this._timer.schedule(this.t, 100L);
        this.t = new TimerTask() { // from class: com.my.freemyanmarid.NationalidActivity.42
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                NationalidActivity.this.runOnUiThread(new Runnable() { // from class: com.my.freemyanmarid.NationalidActivity.42.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Build.VERSION.SDK_INT >= 11) {
                            NationalidActivity.this.name2.setLayerType(1, null);
                        }
                        NationalidActivity.this.name2.getPaint().setMaskFilter(new BlurMaskFilter(NationalidActivity.this.name2.getTextSize() / 40.0f, BlurMaskFilter.Blur.NORMAL));
                    }
                });
            }
        };
        this._timer.schedule(this.t, 100L);
        this.t = new TimerTask() { // from class: com.my.freemyanmarid.NationalidActivity.43
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                NationalidActivity.this.runOnUiThread(new Runnable() { // from class: com.my.freemyanmarid.NationalidActivity.43.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Build.VERSION.SDK_INT >= 11) {
                            NationalidActivity.this.nrc1.setLayerType(1, null);
                        }
                        NationalidActivity.this.nrc1.getPaint().setMaskFilter(new BlurMaskFilter(NationalidActivity.this.nrc1.getTextSize() / 40.0f, BlurMaskFilter.Blur.NORMAL));
                    }
                });
            }
        };
        this._timer.schedule(this.t, 100L);
        this.t = new TimerTask() { // from class: com.my.freemyanmarid.NationalidActivity.44
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                NationalidActivity.this.runOnUiThread(new Runnable() { // from class: com.my.freemyanmarid.NationalidActivity.44.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Build.VERSION.SDK_INT >= 11) {
                            NationalidActivity.this.birth2.setLayerType(1, null);
                        }
                        NationalidActivity.this.birth2.getPaint().setMaskFilter(new BlurMaskFilter(NationalidActivity.this.birth2.getTextSize() / 40.0f, BlurMaskFilter.Blur.NORMAL));
                    }
                });
            }
        };
        this._timer.schedule(this.t, 100L);
        this.t = new TimerTask() { // from class: com.my.freemyanmarid.NationalidActivity.45
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                NationalidActivity.this.runOnUiThread(new Runnable() { // from class: com.my.freemyanmarid.NationalidActivity.45.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Build.VERSION.SDK_INT >= 11) {
                            NationalidActivity.this.nrc2.setLayerType(1, null);
                        }
                        NationalidActivity.this.nrc2.getPaint().setMaskFilter(new BlurMaskFilter(NationalidActivity.this.nrc2.getTextSize() / 40.0f, BlurMaskFilter.Blur.NORMAL));
                    }
                });
            }
        };
        this._timer.schedule(this.t, 100L);
        this.t = new TimerTask() { // from class: com.my.freemyanmarid.NationalidActivity.46
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                NationalidActivity.this.runOnUiThread(new Runnable() { // from class: com.my.freemyanmarid.NationalidActivity.46.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Build.VERSION.SDK_INT >= 11) {
                            NationalidActivity.this.birth1.setLayerType(1, null);
                        }
                        NationalidActivity.this.birth1.getPaint().setMaskFilter(new BlurMaskFilter(NationalidActivity.this.birth1.getTextSize() / 40.0f, BlurMaskFilter.Blur.NORMAL));
                    }
                });
            }
        };
        this._timer.schedule(this.t, 100L);
        this.t = new TimerTask() { // from class: com.my.freemyanmarid.NationalidActivity.47
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                NationalidActivity.this.runOnUiThread(new Runnable() { // from class: com.my.freemyanmarid.NationalidActivity.47.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Build.VERSION.SDK_INT >= 11) {
                            NationalidActivity.this.blood1.setLayerType(1, null);
                        }
                        NationalidActivity.this.blood1.getPaint().setMaskFilter(new BlurMaskFilter(NationalidActivity.this.blood1.getTextSize() / 40.0f, BlurMaskFilter.Blur.NORMAL));
                    }
                });
            }
        };
        this._timer.schedule(this.t, 100L);
        this.t = new TimerTask() { // from class: com.my.freemyanmarid.NationalidActivity.48
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                NationalidActivity.this.runOnUiThread(new Runnable() { // from class: com.my.freemyanmarid.NationalidActivity.48.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Build.VERSION.SDK_INT >= 11) {
                            NationalidActivity.this.am2.setLayerType(1, null);
                        }
                        NationalidActivity.this.am2.getPaint().setMaskFilter(new BlurMaskFilter(NationalidActivity.this.am2.getTextSize() / 40.0f, BlurMaskFilter.Blur.NORMAL));
                    }
                });
            }
        };
        this._timer.schedule(this.t, 100L);
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#FF0000B6"), Color.parseColor("#FFFFFF")});
        gradientDrawable2.setCornerRadii(new float[]{30.0f, 30.0f, 30.0f, 30.0f, 30.0f, 30.0f, 30.0f, 30.0f});
        gradientDrawable2.setStroke(0, Color.parseColor("#FFFFFF"));
        this.linear173.setElevation(4.0f);
        this.linear173.setBackground(gradientDrawable2);
        _round_image(this.imageview63);
        _round_image(this.imageview64);
        _round_image(this.imageview65);
        _round_image(this.imageview66);
        _round_image(this.imageview67);
        _round_image(this.imageview72);
        _round_image(this.imageview75);
        _round_image(this.imageview70);
        this.seekbar3.setMax(360);
        this.seekbar4.setMax(360);
        this.textview20.setTextIsSelectable(true);
        this.textview21.setTextIsSelectable(true);
        this.textview22.setTextIsSelectable(true);
        this.textview23.setTextIsSelectable(true);
        this.no1.setTextIsSelectable(true);
        this.no2.setTextIsSelectable(true);
        this.name1.setTextIsSelectable(true);
        this.name2.setTextIsSelectable(true);
        this.nrc1.setTextIsSelectable(true);
        this.nrc2.setTextIsSelectable(true);
        this.birth1.setTextIsSelectable(true);
        this.birth2.setTextIsSelectable(true);
        this.blood1.setTextIsSelectable(true);
        this.am2.setTextIsSelectable(true);
        this.linear173.setVisibility(8);
        this.imageview83.setVisibility(8);
        this.textview35.setVisibility(8);
        this.key.setText(getIntent().getStringExtra("key"));
        this.dd.setText(getIntent().getStringExtra("dd"));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.dd.setVisibility(8);
        this.dres.setVisibility(8);
        this.textView.setText(this.editText.getText().toString().replaceAll("[^0-9]", ""));
        if (this.dd.getText().toString().equals("")) {
            this.dd.setText("0");
        }
    }

    public void _setTextSize(TextView textView, double d) {
        textView.setTextSize((float) d);
    }

    public void _rippleRoundStroke(View view, String str, String str2, double d, double d2, String str3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius((float) d);
        gradientDrawable.setStroke((int) d2, Color.parseColor("#" + str3.replace("#", "")));
        view.setBackground(new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor(str2)}), gradientDrawable, null));
    }

    public void _round_image(ImageView imageView) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(android.R.color.transparent);
        gradientDrawable.setCornerRadius(360.0f);
        imageView.setClipToOutline(true);
        imageView.setBackground(gradientDrawable);
    }

    public void _Dragable(final View view) {
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.my.freemyanmarid.NationalidActivity.49
            PointF DownPT = new PointF();
            PointF StartPT = new PointF();

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.DownPT.x = motionEvent.getX();
                        this.DownPT.y = motionEvent.getY();
                        this.StartPT = new PointF(view.getX(), view.getY());
                        break;
                    case 2:
                        PointF pointF = new PointF(motionEvent.getX() - this.DownPT.x, motionEvent.getY() - this.DownPT.y);
                        view.setX((int) (this.StartPT.x + pointF.x));
                        view.setY((int) (pointF.y + this.StartPT.y));
                        this.StartPT = new PointF(view.getX(), view.getY());
                        break;
                }
                return true;
            }
        });
    }

    public void _SaveViewAsImage(View view, String str) throws IOException {
        FileUtil.makeDir(str.substring(0, str.lastIndexOf("/")));
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Drawable background = view.getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(0);
        }
        view.draw(canvas);
        File file = new File(str);
        if (file == null) {
            showMessage("Error creating media file, check storage permissions: ");
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.close();
            showMessage("Image Saved in " + str + " folder");
        } catch (FileNotFoundException e) {
            showMessage("File not found: " + e.getMessage());
        } catch (IOException e2) {
            showMessage("Error accessing file: " + e2.getMessage());
        }
    }

    public void _extra() {
    }

    public void _text_sizee(TextView textView, double d) {
        textView.setTextSize((float) d);
    }

    public void _clickAnimation(View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.9f, 1.0f, 0.9f, 1.0f, 1, 0.5f, 1, 0.7f);
        scaleAnimation.setDuration(300L);
        scaleAnimation.setFillAfter(true);
        view.startAnimation(scaleAnimation);
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
