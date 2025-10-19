package com.my.freemyanmarid;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.ScaleAnimation;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes57.dex */
public class ImageActivity extends AppCompatActivity {
    private LinearLayout linear1;
    private LinearLayout linear2;
    private ListView listview1;
    private TimerTask t;
    private TextView textview2;
    private Timer _timer = new Timer();
    private double n = 0.0d;
    private HashMap<String, Object> map = new HashMap<>();
    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<HashMap<String, Object>> maplist = new ArrayList<>();
    private Intent i = new Intent();

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.image);
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
        this.linear2 = (LinearLayout) findViewById(R.id.linear2);
        this.listview1 = (ListView) findViewById(R.id.listview1);
        this.textview2 = (TextView) findViewById(R.id.textview2);
    }

    private void initializeLogic() {
        if (Build.VERSION.SDK_INT > 19) {
            Window window = getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(-10354454);
        }
        FileUtil.listDir(FileUtil.getExternalStorageDir().concat(getIntent().getStringExtra("nrc")), this.list);
        this.n = 0.0d;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.list.size()) {
                if (this.list.get((int) this.n).endsWith(".png")) {
                    this.map = new HashMap<>();
                    this.map.put("image_path", this.list.get((int) this.n));
                    this.map.put("image_name", Uri.parse(this.list.get((int) this.n)).getLastPathSegment());
                    this.maplist.add(this.map);
                }
                this.n += 1.0d;
                i = i2 + 1;
            } else {
                GridView gridView = new GridView(this);
                gridView.setNumColumns(1);
                gridView.setAdapter((ListAdapter) new Listview1Adapter(this.maplist));
                this.linear1.addView(gridView);
                this.textview2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/bold.ttf"), 1);
                this.textview2.setText(getIntent().getStringExtra("nrt"));
                this.textview2.setSelected(true);
                this.textview2.setSingleLine(true);
                this.textview2.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                return;
            }
        }
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
        gradientDrawable.setCornerRadius(40.0f);
        imageView.setClipToOutline(true);
        imageView.setBackground(gradientDrawable);
    }

    public class Listview1Adapter extends BaseAdapter {
        ArrayList<HashMap<String, Object>> _data;

        public Listview1Adapter(ArrayList<HashMap<String, Object>> arrayList) {
            this._data = arrayList;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this._data.size();
        }

        @Override // android.widget.Adapter
        public HashMap<String, Object> getItem(int i) {
            return this._data.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = ImageActivity.this.getLayoutInflater();
            if (view == null) {
                view = layoutInflater.inflate(R.layout.custom, (ViewGroup) null);
            }
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linear1);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageview1);
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.linear3);
            TextView textView = (TextView) view.findViewById(R.id.textview1);
            textView.setText(((HashMap) ImageActivity.this.maplist.get(i)).get("image_name").toString());
            imageView.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(((HashMap) ImageActivity.this.maplist.get(i)).get("image_path").toString(), 1024, 1024));
            ImageActivity.this._rippleRoundStroke(linearLayout, "#EEEEEE", "#27282D", 30.0d, 3.0d, "#E0E0E0");
            ImageActivity.this._rippleRoundStroke(linearLayout2, "#FFFFFF", "#EEEEEE", 20.0d, 3.0d, "#E0E0E0");
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.my.freemyanmarid.ImageActivity.Listview1Adapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    ImageActivity.this.i.setAction("android.intent.action.VIEW");
                    ImageActivity.this.i.putExtra("image", ((HashMap) ImageActivity.this.maplist.get(i)).get("image_path").toString());
                    ImageActivity.this.i.setClass(ImageActivity.this.getApplicationContext(), ImageImgActivity.class);
                    ImageActivity.this.startActivity(ImageActivity.this.i);
                }
            });
            textView.setSelected(true);
            textView.setSingleLine(true);
            textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            ImageActivity.this._round_image(imageView);
            textView.setTypeface(Typeface.createFromAsset(ImageActivity.this.getAssets(), "fonts/passport.ttf"), 1);
            return view;
        }
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
