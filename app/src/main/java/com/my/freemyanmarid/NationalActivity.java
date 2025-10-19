package com.my.freemyanmarid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.my.freemyanmarid.RequestNetwork;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes57.dex */
public class NationalActivity extends AppCompatActivity {
    private EditText Sign;
    private RequestNetwork.RequestListener _req_request_listener;
    private EditText birth1;
    private EditText birth2;
    private ImageView button;
    private Button button1;
    private TextView dd;
    private TextView dres;
    private TextView editText;
    private EditText edittext1;
    private TextView filename;
    private ImageView imageview1;
    private SharedPreferences img;
    private EditText juty;
    private TextView key;
    private TextView keying;
    private EditText lacer;
    private LinearLayout linear1;
    private LinearLayout linear13;
    private LinearLayout linear14;
    private LinearLayout linear15;
    private LinearLayout linear16;
    private LinearLayout linear168;
    private LinearLayout linear17;
    private LinearLayout linear18;
    private LinearLayout linear4;
    private LinearLayout linear5;
    private LinearLayout linear8;
    private LinearLayout linear9;
    private EditText myout;
    private EditText name1;
    private EditText name2;
    private EditText no1;
    private EditText no2;
    private EditText nrc1;
    private EditText nrc2;
    private RequestNetwork req;
    private TextView resect;
    private TextView textView;
    private TextView textview14;
    private TextView textview15;
    private TextView textview16;
    private TextView textview17;
    private TextView textview18;
    private TextView textview19;
    private TextView textview2;
    private TextView textview20;
    private TextView textview21;
    private TextView textview22;
    private TextView textview23;
    private TextView textview24;
    private TextView textview3;
    private TextView textview5;
    private TextView textview6;
    private TextView textview7;
    private TextView textview8;
    private TimerTask ti;
    private EditText type1;
    private ScrollView vscroll1;
    public final int REQ_CD_IMAGE = 101;
    private Timer _timer = new Timer();
    private String path = "";
    private String name = "";
    private double back = 0.0d;
    private String id = "";
    private Intent i = new Intent();
    private Intent image = new Intent("android.intent.action.GET_CONTENT");
    private Calendar c = Calendar.getInstance();

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.national);
        initialize(bundle);
        if (ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") == -1) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 1000);
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
        this.vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
        this.linear13 = (LinearLayout) findViewById(R.id.linear13);
        this.linear8 = (LinearLayout) findViewById(R.id.linear8);
        this.linear14 = (LinearLayout) findViewById(R.id.linear14);
        this.linear16 = (LinearLayout) findViewById(R.id.linear16);
        this.linear17 = (LinearLayout) findViewById(R.id.linear17);
        this.linear18 = (LinearLayout) findViewById(R.id.linear18);
        this.linear4 = (LinearLayout) findViewById(R.id.linear4);
        this.keying = (TextView) findViewById(R.id.keying);
        this.filename = (TextView) findViewById(R.id.filename);
        this.textview2 = (TextView) findViewById(R.id.textview2);
        this.linear9 = (LinearLayout) findViewById(R.id.linear9);
        this.linear5 = (LinearLayout) findViewById(R.id.linear5);
        this.textview19 = (TextView) findViewById(R.id.textview19);
        this.imageview1 = (ImageView) findViewById(R.id.imageview1);
        this.linear168 = (LinearLayout) findViewById(R.id.linear168);
        this.editText = (TextView) findViewById(R.id.editText);
        this.textView = (TextView) findViewById(R.id.textView);
        this.resect = (TextView) findViewById(R.id.resect);
        this.key = (TextView) findViewById(R.id.key);
        this.dd = (TextView) findViewById(R.id.dd);
        this.dres = (TextView) findViewById(R.id.dres);
        this.linear15 = (LinearLayout) findViewById(R.id.linear15);
        this.textview14 = (TextView) findViewById(R.id.textview14);
        this.no1 = (EditText) findViewById(R.id.no1);
        this.textview15 = (TextView) findViewById(R.id.textview15);
        this.no2 = (EditText) findViewById(R.id.no2);
        this.textview16 = (TextView) findViewById(R.id.textview16);
        this.name1 = (EditText) findViewById(R.id.name1);
        this.textview17 = (TextView) findViewById(R.id.textview17);
        this.name2 = (EditText) findViewById(R.id.name2);
        this.textview3 = (TextView) findViewById(R.id.textview3);
        this.nrc1 = (EditText) findViewById(R.id.nrc1);
        this.textview18 = (TextView) findViewById(R.id.textview18);
        this.nrc2 = (EditText) findViewById(R.id.nrc2);
        this.textview6 = (TextView) findViewById(R.id.textview6);
        this.birth1 = (EditText) findViewById(R.id.birth1);
        this.textview7 = (TextView) findViewById(R.id.textview7);
        this.birth2 = (EditText) findViewById(R.id.birth2);
        this.textview8 = (TextView) findViewById(R.id.textview8);
        this.type1 = (EditText) findViewById(R.id.type1);
        this.textview20 = (TextView) findViewById(R.id.textview20);
        this.edittext1 = (EditText) findViewById(R.id.edittext1);
        this.textview21 = (TextView) findViewById(R.id.textview21);
        this.juty = (EditText) findViewById(R.id.juty);
        this.textview22 = (TextView) findViewById(R.id.textview22);
        this.lacer = (EditText) findViewById(R.id.lacer);
        this.textview23 = (TextView) findViewById(R.id.textview23);
        this.myout = (EditText) findViewById(R.id.myout);
        this.textview24 = (TextView) findViewById(R.id.textview24);
        this.Sign = (EditText) findViewById(R.id.Sign);
        this.button = (ImageView) findViewById(R.id.button);
        this.textview5 = (TextView) findViewById(R.id.textview5);
        this.button1 = (Button) findViewById(R.id.button1);
        this.image.setType("image/*");
        this.image.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        this.img = getSharedPreferences("img", 0);
        this.req = new RequestNetwork(this);
        this.imageview1.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.NationalActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NationalActivity.this.startActivityForResult(NationalActivity.this.image, 101);
                NationalActivity.this._clickAnimation(NationalActivity.this.imageview1);
            }
        });
        this.button.setOnClickListener(new AnonymousClass2());
        this.button1.setOnClickListener(new AnonymousClass3());
        this._req_request_listener = new RequestNetwork.RequestListener() { // from class: com.my.freemyanmarid.NationalActivity.4
            @Override // com.my.freemyanmarid.RequestNetwork.RequestListener
            public void onResponse(String str, String str2, HashMap<String, Object> map) {
            }

            @Override // com.my.freemyanmarid.RequestNetwork.RequestListener
            public void onErrorResponse(String str, String str2) {
            }
        };
    }

    /* renamed from: com.my.freemyanmarid.NationalActivity$2, reason: invalid class name */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NationalActivity.this.back == 1.0d) {
                SketchwareUtil.showMessage(NationalActivity.this.getApplicationContext(), "success");
            } else {
                SketchwareUtil.showMessage(NationalActivity.this.getApplicationContext(), "အတည်ပြုရန်နှစ်ချက်နိတ်ပါ");
                NationalActivity.this.back = 1.0d;
                NationalActivity.this.ti = new TimerTask() { // from class: com.my.freemyanmarid.NationalActivity.2.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        NationalActivity.this.runOnUiThread(new Runnable() { // from class: com.my.freemyanmarid.NationalActivity.2.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                NationalActivity.this.back = 0.0d;
                            }
                        });
                    }
                };
                NationalActivity.this._timer.schedule(NationalActivity.this.ti, 1500L);
            }
            NationalActivity.this.button.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.NationalActivity.2.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    String string = NationalActivity.this.editText.getText().toString();
                    StringBuilder sb = new StringBuilder();
                    char[] charArray = string.toCharArray();
                    for (char c : charArray) {
                        if (Character.isDigit(c)) {
                            sb.append(c);
                        }
                    }
                    NationalActivity.this.textView.setText(sb.toString());
                }
            });
            NationalActivity.this._clickAnimation(NationalActivity.this.button);
        }
    }

    /* renamed from: com.my.freemyanmarid.NationalActivity$3, reason: invalid class name */
    class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!NationalActivity.this.filename.getText().toString().equals("")) {
                if (!NationalActivity.this.textView.getText().toString().equals("")) {
                    NationalActivity.this.resect.setText(String.valueOf((long) (Double.parseDouble(NationalActivity.this.textView.getText().toString()) + Double.parseDouble("194076"))));
                    NationalActivity.this.dres.setText(String.valueOf((long) (Double.parseDouble(NationalActivity.this.resect.getText().toString()) * Double.parseDouble(NationalActivity.this.dd.getText().toString()))));
                    if (NationalActivity.this.key.getText().toString().equals(NationalActivity.this.dres.getText().toString())) {
                        NationalActivity.this.i.setAction("android.intent.action.VIEW");
                        NationalActivity.this.i.putExtra("no1", NationalActivity.this.no1.getText().toString());
                        NationalActivity.this.i.putExtra("no2", NationalActivity.this.no2.getText().toString());
                        NationalActivity.this.i.putExtra("na1", NationalActivity.this.name1.getText().toString());
                        NationalActivity.this.i.putExtra("na2", NationalActivity.this.name2.getText().toString());
                        NationalActivity.this.i.putExtra("nr1", NationalActivity.this.nrc1.getText().toString());
                        NationalActivity.this.i.putExtra("nr2", NationalActivity.this.nrc2.getText().toString());
                        NationalActivity.this.i.putExtra("bi1", NationalActivity.this.birth1.getText().toString());
                        NationalActivity.this.i.putExtra("bi2", NationalActivity.this.birth2.getText().toString());
                        NationalActivity.this.i.putExtra("ty1", NationalActivity.this.type1.getText().toString());
                        NationalActivity.this.i.putExtra("key", NationalActivity.this.keying.getText().toString());
                        NationalActivity.this.i.putExtra("am2", NationalActivity.this.edittext1.getText().toString());
                        NationalActivity.this.i.putExtra("jt1", NationalActivity.this.juty.getText().toString());
                        NationalActivity.this.i.putExtra("lc1", NationalActivity.this.lacer.getText().toString());
                        NationalActivity.this.i.putExtra("mn1", NationalActivity.this.myout.getText().toString());
                        NationalActivity.this.i.putExtra("sig1", NationalActivity.this.Sign.getText().toString());
                        NationalActivity.this.i.putExtra("dd", NationalActivity.this.dd.getText().toString());
                        NationalActivity.this.i.setClass(NationalActivity.this.getApplicationContext(), NationalidActivity.class);
                        NationalActivity.this.startActivity(NationalActivity.this.i);
                    } else {
                        NationalActivity.this.ti = new TimerTask() { // from class: com.my.freemyanmarid.NationalActivity.3.1
                            @Override // java.util.TimerTask, java.lang.Runnable
                            public void run() {
                                NationalActivity.this.runOnUiThread(new Runnable() { // from class: com.my.freemyanmarid.NationalActivity.3.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        NationalActivity.this.i.setAction("android.intent.action.VIEW");
                                        NationalActivity.this.i.setClass(NationalActivity.this.getApplicationContext(), BypassActivity.class);
                                        NationalActivity.this.startActivity(NationalActivity.this.i);
                                    }
                                });
                            }
                        };
                        NationalActivity.this._timer.schedule(NationalActivity.this.ti, 500L);
                        SketchwareUtil.showMessage(NationalActivity.this.getApplicationContext(), "Device Error - 📵");
                    }
                } else {
                    SketchwareUtil.showMessage(NationalActivity.this.getApplicationContext(), "Key Error - 🔑");
                }
            } else {
                SketchwareUtil.showMessage(NationalActivity.this.getApplicationContext(), "Please Choose Image'");
            }
            NationalActivity.this._clickAnimation(NationalActivity.this.button1);
        }
    }

    /* JADX WARN: Type inference failed for: r1v11, types: [com.my.freemyanmarid.NationalActivity$8] */
    /* JADX WARN: Type inference failed for: r1v13, types: [com.my.freemyanmarid.NationalActivity$9] */
    /* JADX WARN: Type inference failed for: r1v15, types: [com.my.freemyanmarid.NationalActivity$10] */
    /* JADX WARN: Type inference failed for: r1v17, types: [com.my.freemyanmarid.NationalActivity$11] */
    /* JADX WARN: Type inference failed for: r1v19, types: [com.my.freemyanmarid.NationalActivity$12] */
    /* JADX WARN: Type inference failed for: r1v21, types: [com.my.freemyanmarid.NationalActivity$13] */
    /* JADX WARN: Type inference failed for: r1v23, types: [com.my.freemyanmarid.NationalActivity$14] */
    /* JADX WARN: Type inference failed for: r1v25, types: [com.my.freemyanmarid.NationalActivity$15] */
    /* JADX WARN: Type inference failed for: r1v27, types: [com.my.freemyanmarid.NationalActivity$16] */
    /* JADX WARN: Type inference failed for: r1v29, types: [com.my.freemyanmarid.NationalActivity$17] */
    /* JADX WARN: Type inference failed for: r1v31, types: [com.my.freemyanmarid.NationalActivity$18] */
    /* JADX WARN: Type inference failed for: r1v33, types: [com.my.freemyanmarid.NationalActivity$19] */
    /* JADX WARN: Type inference failed for: r1v35, types: [com.my.freemyanmarid.NationalActivity$20] */
    /* JADX WARN: Type inference failed for: r1v37, types: [com.my.freemyanmarid.NationalActivity$21] */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.my.freemyanmarid.NationalActivity$5] */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.my.freemyanmarid.NationalActivity$6] */
    /* JADX WARN: Type inference failed for: r1v9, types: [com.my.freemyanmarid.NationalActivity$7] */
    private void initializeLogic() {
        if (Build.VERSION.SDK_INT > 19) {
            Window window = getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(-16777034);
        }
        this.keying.setText(getIntent().getStringExtra("key"));
        this.key.setText(getIntent().getStringExtra("key"));
        this.keying.setVisibility(8);
        this.button1.setBackground(new GradientDrawable() { // from class: com.my.freemyanmarid.NationalActivity.5
            public GradientDrawable getIns(int i, int i2, int i3, int i4) {
                setCornerRadius(i);
                setStroke(i2, i3);
                setColor(i4);
                return this;
            }
        }.getIns(15, 0, -16777034, -16777034));
        this.linear16.setBackground(new GradientDrawable() { // from class: com.my.freemyanmarid.NationalActivity.6
            public GradientDrawable getIns(int i, int i2, int i3, int i4) {
                setCornerRadius(i);
                setStroke(i2, i3);
                setColor(i4);
                return this;
            }
        }.getIns(10, 15, -16777034, -16777034));
        this.linear8.setBackground(new GradientDrawable() { // from class: com.my.freemyanmarid.NationalActivity.7
            public GradientDrawable getIns(int i, int i2, int i3, int i4) {
                setCornerRadius(i);
                setStroke(i2, i3);
                setColor(i4);
                return this;
            }
        }.getIns(10, 15, -16777034, -16777034));
        this.no1.setBackground(new GradientDrawable() { // from class: com.my.freemyanmarid.NationalActivity.8
            public GradientDrawable getIns(int i, int i2, int i3, int i4) {
                setCornerRadius(i);
                setStroke(i2, i3);
                setColor(i4);
                return this;
            }
        }.getIns(15, 0, -657931, -657931));
        this.no2.setBackground(new GradientDrawable() { // from class: com.my.freemyanmarid.NationalActivity.9
            public GradientDrawable getIns(int i, int i2, int i3, int i4) {
                setCornerRadius(i);
                setStroke(i2, i3);
                setColor(i4);
                return this;
            }
        }.getIns(15, 0, -657931, -657931));
        this.name1.setBackground(new GradientDrawable() { // from class: com.my.freemyanmarid.NationalActivity.10
            public GradientDrawable getIns(int i, int i2, int i3, int i4) {
                setCornerRadius(i);
                setStroke(i2, i3);
                setColor(i4);
                return this;
            }
        }.getIns(15, 0, -657931, -657931));
        this.name2.setBackground(new GradientDrawable() { // from class: com.my.freemyanmarid.NationalActivity.11
            public GradientDrawable getIns(int i, int i2, int i3, int i4) {
                setCornerRadius(i);
                setStroke(i2, i3);
                setColor(i4);
                return this;
            }
        }.getIns(15, 0, -657931, -657931));
        this.nrc1.setBackground(new GradientDrawable() { // from class: com.my.freemyanmarid.NationalActivity.12
            public GradientDrawable getIns(int i, int i2, int i3, int i4) {
                setCornerRadius(i);
                setStroke(i2, i3);
                setColor(i4);
                return this;
            }
        }.getIns(15, 0, -657931, -657931));
        this.nrc2.setBackground(new GradientDrawable() { // from class: com.my.freemyanmarid.NationalActivity.13
            public GradientDrawable getIns(int i, int i2, int i3, int i4) {
                setCornerRadius(i);
                setStroke(i2, i3);
                setColor(i4);
                return this;
            }
        }.getIns(15, 0, -657931, -657931));
        this.birth1.setBackground(new GradientDrawable() { // from class: com.my.freemyanmarid.NationalActivity.14
            public GradientDrawable getIns(int i, int i2, int i3, int i4) {
                setCornerRadius(i);
                setStroke(i2, i3);
                setColor(i4);
                return this;
            }
        }.getIns(15, 0, -657931, -657931));
        this.birth2.setBackground(new GradientDrawable() { // from class: com.my.freemyanmarid.NationalActivity.15
            public GradientDrawable getIns(int i, int i2, int i3, int i4) {
                setCornerRadius(i);
                setStroke(i2, i3);
                setColor(i4);
                return this;
            }
        }.getIns(15, 0, -657931, -657931));
        this.type1.setBackground(new GradientDrawable() { // from class: com.my.freemyanmarid.NationalActivity.16
            public GradientDrawable getIns(int i, int i2, int i3, int i4) {
                setCornerRadius(i);
                setStroke(i2, i3);
                setColor(i4);
                return this;
            }
        }.getIns(15, 0, -657931, -657931));
        this.edittext1.setBackground(new GradientDrawable() { // from class: com.my.freemyanmarid.NationalActivity.17
            public GradientDrawable getIns(int i, int i2, int i3, int i4) {
                setCornerRadius(i);
                setStroke(i2, i3);
                setColor(i4);
                return this;
            }
        }.getIns(15, 0, -657931, -657931));
        this.juty.setBackground(new GradientDrawable() { // from class: com.my.freemyanmarid.NationalActivity.18
            public GradientDrawable getIns(int i, int i2, int i3, int i4) {
                setCornerRadius(i);
                setStroke(i2, i3);
                setColor(i4);
                return this;
            }
        }.getIns(15, 0, -657931, -657931));
        this.lacer.setBackground(new GradientDrawable() { // from class: com.my.freemyanmarid.NationalActivity.19
            public GradientDrawable getIns(int i, int i2, int i3, int i4) {
                setCornerRadius(i);
                setStroke(i2, i3);
                setColor(i4);
                return this;
            }
        }.getIns(15, 0, -657931, -657931));
        this.myout.setBackground(new GradientDrawable() { // from class: com.my.freemyanmarid.NationalActivity.20
            public GradientDrawable getIns(int i, int i2, int i3, int i4) {
                setCornerRadius(i);
                setStroke(i2, i3);
                setColor(i4);
                return this;
            }
        }.getIns(15, 0, -657931, -657931));
        this.Sign.setBackground(new GradientDrawable() { // from class: com.my.freemyanmarid.NationalActivity.21
            public GradientDrawable getIns(int i, int i2, int i3, int i4) {
                setCornerRadius(i);
                setStroke(i2, i3);
                setColor(i4);
                return this;
            }
        }.getIns(15, 0, -657931, -657931));
        _round_image(this.button);
        _round_image(this.imageview1);
        this.filename.setVisibility(8);
        this.id = Settings.Secure.getString(getApplicationContext().getContentResolver(), "android_id");
        this.editText.setText(this.id);
        this.linear168.setVisibility(8);
        this.textView.setText(this.editText.getText().toString().replaceAll("[^0-9]", ""));
        this.dd.setText(getIntent().getStringExtra("dd"));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 101:
                if (i2 == -1) {
                    ArrayList arrayList = new ArrayList();
                    if (intent != null) {
                        if (intent.getClipData() != null) {
                            for (int i3 = 0; i3 < intent.getClipData().getItemCount(); i3++) {
                                arrayList.add(FileUtil.convertUriToFilePath(getApplicationContext(), intent.getClipData().getItemAt(i3).getUri()));
                            }
                        } else {
                            arrayList.add(FileUtil.convertUriToFilePath(getApplicationContext(), intent.getData()));
                        }
                    }
                    this.path = (String) arrayList.get(0);
                    this.name = Uri.parse(this.path).getLastPathSegment();
                    this.filename.setText(this.name);
                    this.imageview1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(this.path, 1024, 1024));
                    this.img.edit().putString("image", this.path).commit();
                    break;
                }
                break;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dd.getText().toString().equals("")) {
            this.dd.setText("0");
        }
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

    public void _clickAnimation(View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.9f, 1.0f, 0.9f, 1.0f, 1, 0.5f, 1, 0.7f);
        scaleAnimation.setDuration(300L);
        scaleAnimation.setFillAfter(true);
        view.startAnimation(scaleAnimation);
    }

    public void _save_assets_folder(String str, String str2) {
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
