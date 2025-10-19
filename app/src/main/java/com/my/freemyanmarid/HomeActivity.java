package com.my.freemyanmarid;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes57.dex */
public class HomeActivity extends AppCompatActivity {
    private Button button1;
    private AlertDialog.Builder d;
    private TextView dd;
    private TextView dres;
    private TextView editText;
    private TextView edittext;
    private EditText edittext1;
    private ImageView imageview1;
    private ImageView imageview14;
    private ImageView imageview15;
    private ImageView imageview17;
    private ImageView imageview18;
    private ImageView imageview2;
    private ImageView imageview7;
    private ImageView imageview8;
    private ImageView imageview9;
    private LinearLayout linear1;
    private LinearLayout linear11;
    private LinearLayout linear12;
    private LinearLayout linear13;
    private LinearLayout linear15;
    private LinearLayout linear16;
    private LinearLayout linear17;
    private LinearLayout linear18;
    private LinearLayout linear19;
    private LinearLayout linear2;
    private LinearLayout linear26;
    private LinearLayout linear27;
    private LinearLayout linear28;
    private LinearLayout linear29;
    private LinearLayout linear3;
    private LinearLayout linear30;
    private LinearLayout linear31;
    private LinearLayout linear32;
    private LinearLayout linear33;
    private LinearLayout linear34;
    private LinearLayout linear35;
    private LinearLayout linear36;
    private LinearLayout linear4;
    private LinearLayout linear5;
    private LinearLayout linear7;
    private LinearLayout linear8;
    private LinearLayout linear9;
    private ImageView on;
    private TextView resect;
    private SharedPreferences reset;
    private SharedPreferences save;
    private TextView savedd;
    private TimerTask t;
    private TextView textView;
    private TextView textview1;
    private TextView textview11;
    private TextView textview12;
    private TextView textview2;
    private TextView textview3;
    private TextView textview5;
    private TextView textview6;
    private TextView textview7;
    private TextView textview8;
    private ScrollView vscroll1;
    private Timer _timer = new Timer();
    private String id = "";
    private String clipdata = "";
    private double back = 0.0d;
    private Intent i = new Intent();
    private Calendar c = Calendar.getInstance();

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.home);
        initialize(bundle);
        initializeLogic();
    }

    private void initialize(Bundle bundle) {
        this.linear1 = (LinearLayout) findViewById(R.id.linear1);
        this.linear2 = (LinearLayout) findViewById(R.id.linear2);
        this.linear15 = (LinearLayout) findViewById(R.id.linear15);
        this.vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
        this.linear18 = (LinearLayout) findViewById(R.id.linear18);
        this.linear36 = (LinearLayout) findViewById(R.id.linear36);
        this.imageview1 = (ImageView) findViewById(R.id.imageview1);
        this.textview1 = (TextView) findViewById(R.id.textview1);
        this.textview5 = (TextView) findViewById(R.id.textview5);
        this.imageview18 = (ImageView) findViewById(R.id.imageview18);
        this.linear26 = (LinearLayout) findViewById(R.id.linear26);
        this.linear31 = (LinearLayout) findViewById(R.id.linear31);
        this.linear30 = (LinearLayout) findViewById(R.id.linear30);
        this.linear3 = (LinearLayout) findViewById(R.id.linear3);
        this.linear13 = (LinearLayout) findViewById(R.id.linear13);
        this.linear27 = (LinearLayout) findViewById(R.id.linear27);
        this.linear32 = (LinearLayout) findViewById(R.id.linear32);
        this.linear33 = (LinearLayout) findViewById(R.id.linear33);
        this.linear28 = (LinearLayout) findViewById(R.id.linear28);
        this.imageview14 = (ImageView) findViewById(R.id.imageview14);
        this.linear29 = (LinearLayout) findViewById(R.id.linear29);
        this.textview11 = (TextView) findViewById(R.id.textview11);
        this.imageview15 = (ImageView) findViewById(R.id.imageview15);
        this.linear34 = (LinearLayout) findViewById(R.id.linear34);
        this.on = (ImageView) findViewById(R.id.on);
        this.linear35 = (LinearLayout) findViewById(R.id.linear35);
        this.textview12 = (TextView) findViewById(R.id.textview12);
        this.imageview17 = (ImageView) findViewById(R.id.imageview17);
        this.linear5 = (LinearLayout) findViewById(R.id.linear5);
        this.linear12 = (LinearLayout) findViewById(R.id.linear12);
        this.linear8 = (LinearLayout) findViewById(R.id.linear8);
        this.linear4 = (LinearLayout) findViewById(R.id.linear4);
        this.imageview7 = (ImageView) findViewById(R.id.imageview7);
        this.linear7 = (LinearLayout) findViewById(R.id.linear7);
        this.textview2 = (TextView) findViewById(R.id.textview2);
        this.imageview8 = (ImageView) findViewById(R.id.imageview8);
        this.linear9 = (LinearLayout) findViewById(R.id.linear9);
        this.imageview2 = (ImageView) findViewById(R.id.imageview2);
        this.linear11 = (LinearLayout) findViewById(R.id.linear11);
        this.textview3 = (TextView) findViewById(R.id.textview3);
        this.imageview9 = (ImageView) findViewById(R.id.imageview9);
        this.textview6 = (TextView) findViewById(R.id.textview6);
        this.edittext = (TextView) findViewById(R.id.edittext);
        this.linear16 = (LinearLayout) findViewById(R.id.linear16);
        this.linear17 = (LinearLayout) findViewById(R.id.linear17);
        this.button1 = (Button) findViewById(R.id.button1);
        this.linear19 = (LinearLayout) findViewById(R.id.linear19);
        this.editText = (TextView) findViewById(R.id.editText);
        this.savedd = (TextView) findViewById(R.id.savedd);
        this.textview8 = (TextView) findViewById(R.id.textview8);
        this.dd = (TextView) findViewById(R.id.dd);
        this.dres = (TextView) findViewById(R.id.dres);
        this.resect = (TextView) findViewById(R.id.resect);
        this.textView = (TextView) findViewById(R.id.textView);
        this.edittext1 = (EditText) findViewById(R.id.edittext1);
        this.textview7 = (TextView) findViewById(R.id.textview7);
        this.save = getSharedPreferences("save", 0);
        this.reset = getSharedPreferences("reset", 0);
        this.d = new AlertDialog.Builder(this);
        this.imageview18.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.HomeActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HomeActivity.this.d.setTitle("Myanmar national registration card (NRC)");
                HomeActivity.this.d.setIcon(R.drawable.tyuii);
                HomeActivity.this.d.setMessage("National identity card myanmar \n.\n.\n.\n.\n.\n.\n.\n✴✴✴✴✴✴✴✴✴✴✴✴✴✴");
                HomeActivity.this.d.setPositiveButton("Front", new DialogInterface.OnClickListener() { // from class: com.my.freemyanmarid.HomeActivity.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        HomeActivity.this.i.setAction("android.intent.action.VIEW");
                        HomeActivity.this.i.putExtra("nrc", "/Pictures/Myanmar 3in1/Nrc/Front/");
                        HomeActivity.this.i.putExtra("nrt", "Myanmar National Registration Card (NRC_FORNT)");
                        HomeActivity.this.i.setClass(HomeActivity.this.getApplicationContext(), ImageActivity.class);
                        HomeActivity.this.startActivity(HomeActivity.this.i);
                    }
                });
                HomeActivity.this.d.setNegativeButton("Back", new DialogInterface.OnClickListener() { // from class: com.my.freemyanmarid.HomeActivity.1.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        HomeActivity.this.i.setAction("android.intent.action.VIEW");
                        HomeActivity.this.i.putExtra("nrc", "/Pictures/Myanmar 3in1/Nrc/Back/");
                        HomeActivity.this.i.putExtra("nrt", "Myanmar National Registration Card (NRC_BACK)");
                        HomeActivity.this.i.setClass(HomeActivity.this.getApplicationContext(), ImageActivity.class);
                        HomeActivity.this.startActivity(HomeActivity.this.i);
                    }
                });
                HomeActivity.this.d.create().show();
                HomeActivity.this._clickAnimation(HomeActivity.this.imageview18);
            }
        });
        this.imageview14.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.HomeActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!HomeActivity.this.resect.getText().toString().equals("") && HomeActivity.this.dres.getText().toString().equals(HomeActivity.this.resect.getText().toString())) {
                    HomeActivity.this.i.setAction("android.intent.action.VIEW");
                    HomeActivity.this.i.putExtra("key", HomeActivity.this.resect.getText().toString());
                    HomeActivity.this.i.putExtra("dd", HomeActivity.this.savedd.getText().toString());
                    HomeActivity.this.i.setAction("android.intent.action.VIEW");
                    HomeActivity.this.i.setData(Uri.parse("https://t.me/itbox404/246"));
                    HomeActivity.this.startActivity(HomeActivity.this.i);
                    SketchwareUtil.showMessage(HomeActivity.this.getApplicationContext(), "Join It Box");
                } else {
                    SketchwareUtil.showMessage(HomeActivity.this.getApplicationContext(), "Not Device");
                }
                HomeActivity.this._clickAnimation(HomeActivity.this.imageview14);
            }
        });
        this.on.setOnClickListener(new AnonymousClass3());
        this.imageview7.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.HomeActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!HomeActivity.this.resect.getText().toString().equals("") && HomeActivity.this.dres.getText().toString().equals(HomeActivity.this.resect.getText().toString())) {
                    HomeActivity.this.i.setAction("android.intent.action.VIEW");
                    HomeActivity.this.i.putExtra("key", HomeActivity.this.resect.getText().toString());
                    HomeActivity.this.i.putExtra("dd", HomeActivity.this.savedd.getText().toString());
                    HomeActivity.this.i.setAction("android.intent.action.VIEW");
                    HomeActivity.this.i.setData(Uri.parse("https://t.me/itbox404/246"));
                    HomeActivity.this.startActivity(HomeActivity.this.i);
                    SketchwareUtil.showMessage(HomeActivity.this.getApplicationContext(), "Join It Box");
                } else {
                    SketchwareUtil.showMessage(HomeActivity.this.getApplicationContext(), "Not Device");
                }
                HomeActivity.this._clickAnimation(HomeActivity.this.imageview7);
            }
        });
        this.imageview2.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.HomeActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!HomeActivity.this.resect.getText().toString().equals("") && HomeActivity.this.dres.getText().toString().equals(HomeActivity.this.resect.getText().toString())) {
                    HomeActivity.this.i.setAction("android.intent.action.VIEW");
                    HomeActivity.this.i.putExtra("key", HomeActivity.this.resect.getText().toString());
                    HomeActivity.this.i.putExtra("dd", HomeActivity.this.savedd.getText().toString());
                    HomeActivity.this.i.setClass(HomeActivity.this.getApplicationContext(), NationalActivity.class);
                    HomeActivity.this.startActivity(HomeActivity.this.i);
                } else {
                    SketchwareUtil.showMessage(HomeActivity.this.getApplicationContext(), "Not Device");
                }
                HomeActivity.this._clickAnimation(HomeActivity.this.imageview2);
            }
        });
        this.edittext.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.HomeActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.button1.setOnClickListener(new AnonymousClass7());
        this.editText.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.my.freemyanmarid.HomeActivity.8
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.editText.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.HomeActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HomeActivity.this.editText.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.HomeActivity.9.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        String string = HomeActivity.this.editText.getText().toString();
                        StringBuilder sb = new StringBuilder();
                        char[] charArray = string.toCharArray();
                        for (char c : charArray) {
                            if (Character.isDigit(c)) {
                                sb.append(c);
                            }
                        }
                        HomeActivity.this.textView.setText(sb.toString());
                    }
                });
                HomeActivity.this.save.edit().putString("dd", HomeActivity.this.dd.getText().toString()).commit();
                HomeActivity homeActivity = HomeActivity.this;
                HomeActivity.this.getApplicationContext();
                ((ClipboardManager) homeActivity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("clipboard", HomeActivity.this.editText.getText().toString()));
                SketchwareUtil.showMessage(HomeActivity.this.getApplicationContext(), "copy");
            }
        });
        this.savedd.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.my.freemyanmarid.HomeActivity.10
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.textView.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.HomeActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HomeActivity.this.textview8.setText(String.valueOf((long) (Double.parseDouble(HomeActivity.this.textView.getText().toString()) + Double.parseDouble("194076"))));
                HomeActivity.this._clickAnimation(HomeActivity.this.textView);
            }
        });
        this.edittext1.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.HomeActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.textview7.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.HomeActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    /* renamed from: com.my.freemyanmarid.HomeActivity$3, reason: invalid class name */
    class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (HomeActivity.this.back == 1.0d) {
                HomeActivity.this.on.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.HomeActivity.3.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        HomeActivity.this.edittext.setText(HomeActivity.this.edittext1.getText().toString().replaceAll("[^0-9]", ""));
                    }
                });
            } else {
                HomeActivity.this._ClipBoard(HomeActivity.this.edittext1);
                HomeActivity.this.on.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.HomeActivity.3.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        HomeActivity.this.edittext.setText(HomeActivity.this.edittext1.getText().toString().replaceAll("[^0-9]", ""));
                    }
                });
                SketchwareUtil.showMessage(HomeActivity.this.getApplicationContext(), "Dubble Tap To Back");
                HomeActivity.this.back = 1.0d;
                HomeActivity.this.t = new TimerTask() { // from class: com.my.freemyanmarid.HomeActivity.3.3
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        HomeActivity.this.runOnUiThread(new Runnable() { // from class: com.my.freemyanmarid.HomeActivity.3.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HomeActivity.this.back = 0.0d;
                            }
                        });
                    }
                };
                HomeActivity.this._timer.schedule(HomeActivity.this.t, 1500L);
            }
            HomeActivity.this._clickAnimation(HomeActivity.this.on);
        }
    }

    /* renamed from: com.my.freemyanmarid.HomeActivity$7, reason: invalid class name */
    class AnonymousClass7 implements View.OnClickListener {
        AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!HomeActivity.this.savedd.getText().toString().equals("")) {
                if (!HomeActivity.this.textView.getText().toString().equals("")) {
                    HomeActivity.this.textview8.setText(String.valueOf((long) (Double.parseDouble(HomeActivity.this.textView.getText().toString()) + Double.parseDouble("194076"))));
                    HomeActivity.this.dres.setText(String.valueOf((long) (Double.parseDouble(HomeActivity.this.textview8.getText().toString()) * Double.parseDouble(HomeActivity.this.savedd.getText().toString()))));
                    HomeActivity.this.t = new TimerTask() { // from class: com.my.freemyanmarid.HomeActivity.7.1
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            HomeActivity.this.runOnUiThread(new Runnable() { // from class: com.my.freemyanmarid.HomeActivity.7.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (HomeActivity.this.dres.getText().toString().equals(HomeActivity.this.edittext.getText().toString())) {
                                        HomeActivity.this.save.edit().putString("id", HomeActivity.this.edittext.getText().toString()).commit();
                                        HomeActivity.this.imageview8.setImageResource(R.drawable.ic_check_circle_white);
                                        HomeActivity.this.imageview8.setColorFilter(-16725933, PorterDuff.Mode.MULTIPLY);
                                        HomeActivity.this.imageview9.setImageResource(R.drawable.ic_check_circle_white);
                                        HomeActivity.this.imageview9.setColorFilter(-16725933, PorterDuff.Mode.MULTIPLY);
                                        HomeActivity.this.imageview17.setImageResource(R.drawable.ic_check_circle_white);
                                        HomeActivity.this.imageview17.setColorFilter(-16725933, PorterDuff.Mode.MULTIPLY);
                                        HomeActivity.this.imageview15.setImageResource(R.drawable.ic_check_circle_white);
                                        HomeActivity.this.imageview15.setColorFilter(-16725933, PorterDuff.Mode.MULTIPLY);
                                        HomeActivity.this.on.setColorFilter(-16725933, PorterDuff.Mode.MULTIPLY);
                                        HomeActivity.this.on.setImageResource(R.drawable.confirm);
                                        HomeActivity.this.textview7.setText("အသုံးပြုခွင့်ရရှိပါပြီ။");
                                        HomeActivity.this.button1.setVisibility(8);
                                        HomeActivity.this.editText.setVisibility(8);
                                        HomeActivity.this.save.edit().putString("reset", HomeActivity.this.dres.getText().toString()).commit();
                                        HomeActivity.this.finishAffinity();
                                        return;
                                    }
                                    HomeActivity.this.i.setAction("android.intent.action.VIEW");
                                    HomeActivity.this.i.setClass(HomeActivity.this.getApplicationContext(), ContactActivity.class);
                                    HomeActivity.this.startActivity(HomeActivity.this.i);
                                    SketchwareUtil.showMessage(HomeActivity.this.getApplicationContext(), "Key အတည်ပြု၍မရပါ။");
                                }
                            });
                        }
                    };
                    HomeActivity.this._timer.schedule(HomeActivity.this.t, 500L);
                } else {
                    SketchwareUtil.showMessage(HomeActivity.this.getApplicationContext(), "Not devive");
                }
            } else {
                SketchwareUtil.showMessage(HomeActivity.this.getApplicationContext(), "First Copy Id");
            }
            HomeActivity.this._clickAnimation(HomeActivity.this.button1);
        }
    }

    private void initializeLogic() {
        if (Build.VERSION.SDK_INT > 19) {
            Window window = getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(-16777034);
        }
        this.id = Settings.Secure.getString(getApplicationContext().getContentResolver(), "android_id");
        this.editText.setText(this.id);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#0000B6"), Color.parseColor("#0000B6")});
        gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 60.0f, 60.0f, 60.0f, 60.0f});
        gradientDrawable.setStroke(0, Color.parseColor("#000000"));
        this.linear2.setElevation(3.0f);
        this.linear2.setBackground(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TR_BL, new int[]{Color.parseColor("#BF4259"), Color.parseColor("#CC6F07")});
        gradientDrawable2.setCornerRadii(new float[]{29.0f, 29.0f, 29.0f, 29.0f, 29.0f, 29.0f, 29.0f, 29.0f});
        gradientDrawable2.setStroke(0, Color.parseColor("#000000"));
        this.linear13.setElevation(5.0f);
        this.linear13.setBackground(gradientDrawable2);
        _round_image(this.imageview7);
        _round_image(this.imageview2);
        _rippleRoundStroke(this.linear5, "#FF0000B6", "#27282D", 15.0d, 3.0d, "#27282D");
        _rippleRoundStroke(this.linear8, "#FF0000B6", "#27282D", 15.0d, 3.0d, "#27282D");
        _rippleRoundStroke(this.linear27, "#FF0000B6", "#27282D", 15.0d, 3.0d, "#27282D");
        _rippleRoundStroke(this.linear33, "#FF0000B6", "#27282D", 15.0d, 3.0d, "#27282D");
        _rippleRoundStroke(this.editText, "#FFFFFF", "#27282D", 15.0d, 3.0d, "#27282D");
        _rippleRoundStroke(this.button1, "#FFFFFF", "#27282D", 15.0d, 3.0d, "#27282D");
        this.textview1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/hel.ttf"), 0);
        this.textview6.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/fril.ttf"), 0);
        this.textview2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/hal.ttf"), 0);
        this.textview3.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/hal.ttf"), 0);
        this.textview11.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/hal.ttf"), 0);
        this.textview12.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/hal.ttf"), 0);
        this.textview7.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/hal.ttf"), 0);
        this.textview5.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/hel.ttf"), 0);
        this.button1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/hal.ttf"), 0);
        this.textView.setVisibility(8);
        this.textview8.setVisibility(8);
        this.resect.setVisibility(8);
        this.edittext1.setVisibility(8);
        this.edittext.setVisibility(8);
        this.imageview8.setColorFilter(-769226, PorterDuff.Mode.MULTIPLY);
        this.imageview9.setColorFilter(-769226, PorterDuff.Mode.MULTIPLY);
        this.imageview17.setColorFilter(-769226, PorterDuff.Mode.MULTIPLY);
        this.on.setColorFilter(-769226, PorterDuff.Mode.MULTIPLY);
        this.imageview15.setColorFilter(-769226, PorterDuff.Mode.MULTIPLY);
        this.edittext1.setText(this.save.getString("id", ""));
        this.resect.setText(this.save.getString("id", ""));
        this.dres.setText(this.save.getString("reset", ""));
        this.savedd.setText(this.save.getString("dd", ""));
        this.textview12.setSelected(true);
        this.textview12.setSingleLine(true);
        this.textview12.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.dd.setVisibility(8);
        this.dres.setVisibility(8);
        this.savedd.setVisibility(8);
        this.dd.setText(new SimpleDateFormat("dd").format(this.c.getTime()));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.resect.getText().toString().equals("") && this.dres.getText().toString().equals(this.resect.getText().toString())) {
            this.on.setImageResource(R.drawable.confirm);
            this.on.setColorFilter(-16725933, PorterDuff.Mode.MULTIPLY);
            this.imageview8.setColorFilter(-16725933, PorterDuff.Mode.MULTIPLY);
            this.imageview17.setColorFilter(-16725933, PorterDuff.Mode.MULTIPLY);
            this.imageview9.setColorFilter(-16725933, PorterDuff.Mode.MULTIPLY);
            this.imageview15.setColorFilter(-16725933, PorterDuff.Mode.MULTIPLY);
            this.imageview8.setImageResource(R.drawable.ic_check_circle_white);
            this.imageview9.setImageResource(R.drawable.ic_check_circle_white);
            this.imageview17.setImageResource(R.drawable.ic_check_circle_white);
            this.imageview15.setImageResource(R.drawable.ic_check_circle_white);
            this.textview12.setText("Phone verification successful❤");
            this.textview7.setText("အသုံးပြုခွင့်ရရှိပါပြီ။");
            this.textview6.setText("Verification Confirmed");
            this.editText.setVisibility(8);
            this.button1.setVisibility(8);
        }
        this.textView.setText(this.editText.getText().toString().replaceAll("[^0-9]", ""));
        this.textview7.setVisibility(0);
        this.savedd.setText(this.save.getString("dd", ""));
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
        gradientDrawable.setCornerRadius(30.0f);
        imageView.setClipToOutline(true);
        imageView.setBackground(gradientDrawable);
    }

    public void _ClipBoard(TextView textView) {
        this.clipdata = "";
        ClipData primaryClip = ((ClipboardManager) getSystemService("clipboard")).getPrimaryClip();
        if (primaryClip != null) {
            this.clipdata = primaryClip.getItemAt(0).getText().toString();
            textView.setText(this.clipdata);
        } else {
            SketchwareUtil.showMessage(getApplicationContext(), "Clipboard is empty!");
        }
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
