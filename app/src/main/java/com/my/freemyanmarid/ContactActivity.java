package com.my.freemyanmarid;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;

/* loaded from: classes57.dex */
public class ContactActivity extends AppCompatActivity {
    private Intent i = new Intent();
    private ImageView imageview1;
    private ImageView imageview2;
    private ImageView imageview3;
    private ImageView imageview4;
    private LinearLayout linear1;
    private LinearLayout linear10;
    private LinearLayout linear11;
    private LinearLayout linear12;
    private LinearLayout linear129;
    private LinearLayout linear130;
    private LinearLayout linear2;
    private TextView textview1;
    private TextView textview2;
    private TextView textview4;
    private TextView textview6;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) throws IOException {
        super.onCreate(bundle);
        setContentView(R.layout.contact);
        initialize(bundle);
        initializeLogic();
    }

    private void initialize(Bundle bundle) {
        this.linear1 = (LinearLayout) findViewById(R.id.linear1);
        this.imageview4 = (ImageView) findViewById(R.id.imageview4);
        this.textview1 = (TextView) findViewById(R.id.textview1);
        this.linear12 = (LinearLayout) findViewById(R.id.linear12);
        this.linear11 = (LinearLayout) findViewById(R.id.linear11);
        this.linear2 = (LinearLayout) findViewById(R.id.linear2);
        this.linear10 = (LinearLayout) findViewById(R.id.linear10);
        this.textview6 = (TextView) findViewById(R.id.textview6);
        this.textview4 = (TextView) findViewById(R.id.textview4);
        this.textview2 = (TextView) findViewById(R.id.textview2);
        this.imageview1 = (ImageView) findViewById(R.id.imageview1);
        this.linear129 = (LinearLayout) findViewById(R.id.linear129);
        this.imageview2 = (ImageView) findViewById(R.id.imageview2);
        this.linear130 = (LinearLayout) findViewById(R.id.linear130);
        this.imageview3 = (ImageView) findViewById(R.id.imageview3);
        this.textview6.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.ContactActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ContactActivity contactActivity = ContactActivity.this;
                ContactActivity.this.getApplicationContext();
                ((ClipboardManager) contactActivity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("clipboard", ContactActivity.this.textview6.getText().toString()));
                SketchwareUtil.showMessage(ContactActivity.this.getApplicationContext(), "Copy");
            }
        });
        this.textview4.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.ContactActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ContactActivity.this.i.setAction("android.intent.action.VIEW");
                ContactActivity.this.i.setData(Uri.parse("https://".concat(ContactActivity.this.textview4.getText().toString())));
                ContactActivity.this.startActivity(ContactActivity.this.i);
                ContactActivity contactActivity = ContactActivity.this;
                ContactActivity.this.getApplicationContext();
                ((ClipboardManager) contactActivity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("clipboard", ContactActivity.this.textview4.getText().toString()));
                SketchwareUtil.showMessage(ContactActivity.this.getApplicationContext(), "Telegram copy user name");
            }
        });
        this.textview2.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.ContactActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ContactActivity.this.i.setAction("android.intent.action.VIEW");
                ContactActivity.this.i.setData(Uri.parse("https://".concat(ContactActivity.this.textview2.getText().toString())));
                ContactActivity.this.startActivity(ContactActivity.this.i);
                SketchwareUtil.showMessage(ContactActivity.this.getApplicationContext(), "Messenger");
            }
        });
        this.imageview1.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.ContactActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ContactActivity.this.i.setAction("android.intent.action.VIEW");
                ContactActivity.this.i.setData(Uri.parse("https://".concat(ContactActivity.this.textview2.getText().toString())));
                ContactActivity.this.startActivity(ContactActivity.this.i);
                ContactActivity.this._clickAnimation(ContactActivity.this.imageview1);
                SketchwareUtil.showMessage(ContactActivity.this.getApplicationContext(), "Messenger");
            }
        });
        this.imageview2.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.ContactActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ContactActivity.this.i.setAction("android.intent.action.VIEW");
                ContactActivity.this.i.setData(Uri.parse("https://".concat(ContactActivity.this.textview4.getText().toString())));
                ContactActivity contactActivity = ContactActivity.this;
                ContactActivity.this.getApplicationContext();
                ((ClipboardManager) contactActivity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("clipboard", ContactActivity.this.textview4.getText().toString()));
                ContactActivity.this.startActivity(ContactActivity.this.i);
                SketchwareUtil.showMessage(ContactActivity.this.getApplicationContext(), "Telegram User Name Copy");
                ContactActivity.this._clickAnimation(ContactActivity.this.imageview2);
            }
        });
        this.imageview3.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.ContactActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ContactActivity contactActivity = ContactActivity.this;
                ContactActivity.this.getApplicationContext();
                ((ClipboardManager) contactActivity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("clipboard", ContactActivity.this.textview6.getText().toString()));
                SketchwareUtil.showMessage(ContactActivity.this.getApplicationContext(), "Viber Phone Copy");
                ContactActivity.this._clickAnimation(ContactActivity.this.imageview3);
            }
        });
    }

    private void initializeLogic() throws IOException {
        if (getIntent().getBooleanExtra("dialogTheme", true)) {
            getWindow().getDecorView().setBackgroundResource(android.R.color.transparent);
            GradientDrawable gradientDrawable = new GradientDrawable();
            int i = (int) getApplicationContext().getResources().getDisplayMetrics().density;
            gradientDrawable.setColor(-1);
            gradientDrawable.setCornerRadius(i * 15);
            ((ViewGroup) getWindow().getDecorView()).getChildAt(0).setBackground(gradientDrawable);
        }
        this.textview2.setSelected(true);
        this.textview2.setSingleLine(true);
        this.textview2.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        _rippleRoundStroke(this.linear1, "#FF0000B6", "#27282D", 15.0d, 3.0d, "#27282D");
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getAssets().open("Messenger.json")));
            String str = "";
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                } else {
                    str = String.valueOf(str) + line + "\n";
                }
            }
            this.textview2.setText(str);
        } catch (IOException e) {
            showMessage(e.toString());
        }
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(getAssets().open("Viber.json")));
            String str2 = "";
            while (true) {
                String line2 = bufferedReader2.readLine();
                if (line2 == null) {
                    break;
                } else {
                    str2 = String.valueOf(str2) + line2 + "\n";
                }
            }
            this.textview6.setText(str2);
        } catch (IOException e2) {
            showMessage(e2.toString());
        }
        try {
            BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(getAssets().open("Telegram.json")));
            String str3 = "";
            while (true) {
                String line3 = bufferedReader3.readLine();
                if (line3 == null) {
                    break;
                } else {
                    str3 = String.valueOf(str3) + line3 + "\n";
                }
            }
            this.textview4.setText(str3);
        } catch (IOException e3) {
            showMessage(e3.toString());
        }
        this.textview2.setVisibility(8);
        this.textview4.setVisibility(8);
        this.textview6.setVisibility(8);
        this.textview1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/passport.ttf"), 1);
        _round_image(this.imageview4);
    }

    public void _dialogTheme() {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i) {
        Class<?> cls = null;
        if (getIntent().getBooleanExtra("dialogTheme", true)) {
            supportRequestWindowFeature(1);
            setTheme(2131689996);
            setFinishOnTouchOutside(true);
            try {
                Method declaredMethod = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(this, new Object[0]);
                Class<?>[] declaredClasses = Activity.class.getDeclaredClasses();
                int length = declaredClasses.length;
                int i2 = 0;
                while (i2 < length) {
                    Class<?> cls2 = declaredClasses[i2];
                    if (!cls2.getSimpleName().contains("TranslucentConversionListener")) {
                        cls2 = cls;
                    }
                    i2++;
                    cls = cls2;
                }
                Method declaredMethod2 = Activity.class.getDeclaredMethod("convertToTranslucent", cls, ActivityOptions.class);
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(this, null, objInvoke);
            } catch (Throwable th) {
            }
        }
        super.setContentView(i);
    }

    public void _rippleRoundStroke(View view, String str, String str2, double d, double d2, String str3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius((float) d);
        gradientDrawable.setStroke((int) d2, Color.parseColor("#" + str3.replace("#", "")));
        view.setBackground(new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor(str2)}), gradientDrawable, null));
    }

    public void _clickAnimation(View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.9f, 1.0f, 0.9f, 1.0f, 1, 0.5f, 1, 0.7f);
        scaleAnimation.setDuration(300L);
        scaleAnimation.setFillAfter(true);
        view.startAnimation(scaleAnimation);
    }

    public void _round_image(ImageView imageView) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(android.R.color.transparent);
        gradientDrawable.setCornerRadius(60.0f);
        imageView.setClipToOutline(true);
        imageView.setBackground(gradientDrawable);
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
