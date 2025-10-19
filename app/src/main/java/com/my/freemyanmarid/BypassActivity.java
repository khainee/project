package com.my.freemyanmarid;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.HttpStatus;

/* loaded from: classes57.dex */
public class BypassActivity extends AppCompatActivity {
    private Timer _timer = new Timer();
    private Calendar c = Calendar.getInstance();
    private ImageView imageview2;
    private LinearLayout linear1;
    private LinearLayout linear2;
    private TimerTask t;
    private TextView textview2;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bypass);
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
        this.linear2 = (LinearLayout) findViewById(R.id.linear2);
        this.imageview2 = (ImageView) findViewById(R.id.imageview2);
        this.linear1 = (LinearLayout) findViewById(R.id.linear1);
        this.textview2 = (TextView) findViewById(R.id.textview2);
    }

    private void initializeLogic() {
        if (getIntent().getBooleanExtra("dialogTheme", true)) {
            getWindow().getDecorView().setBackgroundResource(android.R.color.transparent);
            GradientDrawable gradientDrawable = new GradientDrawable();
            int i = (int) getApplicationContext().getResources().getDisplayMetrics().density;
            gradientDrawable.setColor(-1);
            gradientDrawable.setCornerRadius(i * 15);
            ((ViewGroup) getWindow().getDecorView()).getChildAt(0).setBackground(gradientDrawable);
        }
        this.t = new TimerTask() { // from class: com.my.freemyanmarid.BypassActivity.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                BypassActivity.this.runOnUiThread(new Runnable() { // from class: com.my.freemyanmarid.BypassActivity.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BypassActivity.this.imageview2.setVisibility(0);
                        BypassActivity.this.textview2.setText("Device Error📵");
                        BypassActivity.this.linear1.setVisibility(8);
                    }
                });
            }
        };
        this._timer.schedule(this.t, 1500L);
        this.t = new TimerTask() { // from class: com.my.freemyanmarid.BypassActivity.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                BypassActivity.this.runOnUiThread(new Runnable() { // from class: com.my.freemyanmarid.BypassActivity.2.1
                    @Override // java.lang.Runnable
                    public void run() throws IOException {
                        BypassActivity.this.c = Calendar.getInstance();
                        BypassActivity.this._SaveViewAsImage(BypassActivity.this.imageview2, FileUtil.getPublicDir(Environment.DIRECTORY_PICTURES).concat("/Bypass Activity/".concat(new SimpleDateFormat("ddMMyyyy-hhmmss").format(BypassActivity.this.c.getTime()).concat(".png"))));
                        SketchwareUtil.showMessage(BypassActivity.this.getApplicationContext(), "😎😎😎😎");
                    }
                });
            }
        };
        this._timer.schedule(this.t, 1600L);
        _round_image(this.imageview2);
        _DotLoadingProgress();
        _rippleRoundStroke(this.linear2, "#FF0000B6", "#27282D", 15.0d, 3.0d, "#27282D");
        this.imageview2.setVisibility(8);
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

    public void _round_image(ImageView imageView) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(android.R.color.transparent);
        gradientDrawable.setCornerRadius(30.0f);
        imageView.setClipToOutline(true);
        imageView.setBackground(gradientDrawable);
    }

    public void _DotLoadingProgress() {
        DilatingDotsProgressBar dilatingDotsProgressBar = new DilatingDotsProgressBar(this);
        dilatingDotsProgressBar.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        dilatingDotsProgressBar.setDotRadius(20.0f);
        dilatingDotsProgressBar.setDotColors(SupportMenu.CATEGORY_MASK, -16711936);
        dilatingDotsProgressBar.setNumberOfDots(4);
        dilatingDotsProgressBar.setDotScaleMultiplier(1.5f);
        dilatingDotsProgressBar.setGrowthSpeed(HttpStatus.SC_INTERNAL_SERVER_ERROR);
        dilatingDotsProgressBar.setDotSpacing(20.0f);
        this.linear1.addView(dilatingDotsProgressBar);
        dilatingDotsProgressBar.showNow();
    }

    public static class DilatingDotDrawable extends Drawable {
        private static final String TAG = DilatingDotDrawable.class.getSimpleName();
        private float maxRadius;
        private float radius;
        private Paint mPaint = new Paint(1);
        final Rect mDirtyBounds = new Rect(0, 0, 0, 0);

        public DilatingDotDrawable(int i, float f, float f2) {
            this.mPaint.setColor(i);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setStrokeCap(Paint.Cap.ROUND);
            this.mPaint.setStrokeJoin(Paint.Join.ROUND);
            this.radius = f;
            setMaxRadius(f2);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Rect bounds = getBounds();
            canvas.drawCircle(bounds.centerX(), bounds.centerY(), this.radius - 1.0f, this.mPaint);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            if (i != this.mPaint.getAlpha()) {
                this.mPaint.setAlpha(i);
                invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            this.mPaint.setColorFilter(colorFilter);
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        public void setColor(int i) {
            this.mPaint.setColor(i);
            invalidateSelf();
        }

        public void setRadius(float f) {
            this.radius = f;
            invalidateSelf();
        }

        public float getRadius() {
            return this.radius;
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return ((int) (this.maxRadius * 2.0f)) + 2;
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return ((int) (this.maxRadius * 2.0f)) + 2;
        }

        public void setMaxRadius(float f) {
            this.maxRadius = f;
            this.mDirtyBounds.bottom = ((int) (f * 2.0f)) + 2;
            this.mDirtyBounds.right = ((int) (f * 2.0f)) + 2;
        }

        @Override // android.graphics.drawable.Drawable
        public Rect getDirtyBounds() {
            return this.mDirtyBounds;
        }

        @Override // android.graphics.drawable.Drawable
        protected void onBoundsChange(Rect rect) {
            super.onBoundsChange(rect);
            this.mDirtyBounds.offsetTo(rect.left, rect.top);
        }
    }

    public static class DilatingDotsProgressBar extends View {
        private static final float DEFAULT_GROWTH_MULTIPLIER = 1.75f;
        private static final int MIN_DELAY = 500;
        private static final int MIN_SHOW_TIME = 500;
        public static final double START_DELAY_FACTOR = 0.35d;
        public static final String TAG = DilatingDotsProgressBar.class.getSimpleName();
        private boolean mAnimateColors;
        private int mAnimationDuration;
        private final List<Animator> mAnimations;
        private final Runnable mDelayedHide;
        private final Runnable mDelayedShow;
        private boolean mDismissed;
        private int mDotColor;
        private int mDotEndColor;
        private float mDotMaxRadius;
        private float mDotRadius;
        private float mDotScaleMultiplier;
        private ArrayList<DilatingDotDrawable> mDrawables;
        private float mHorizontalSpacing;
        private boolean mIsRunning;
        private int mNumberDots;
        private boolean mShouldAnimate;
        private long mStartTime;
        private int mWidthBetweenDotCenters;

        public DilatingDotsProgressBar(Context context) {
            this(context, null);
        }

        public DilatingDotsProgressBar(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        public DilatingDotsProgressBar(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.mStartTime = -1L;
            this.mDismissed = false;
            this.mIsRunning = false;
            this.mAnimateColors = false;
            this.mDrawables = new ArrayList<>();
            this.mAnimations = new ArrayList();
            this.mDelayedHide = new Runnable() { // from class: com.my.freemyanmarid.BypassActivity.DilatingDotsProgressBar.1
                @Override // java.lang.Runnable
                public void run() {
                    DilatingDotsProgressBar.this.mStartTime = -1L;
                    DilatingDotsProgressBar.this.mIsRunning = false;
                    DilatingDotsProgressBar.this.setVisibility(8);
                    DilatingDotsProgressBar.this.stopAnimations();
                }
            };
            this.mDelayedShow = new Runnable() { // from class: com.my.freemyanmarid.BypassActivity.DilatingDotsProgressBar.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!DilatingDotsProgressBar.this.mDismissed) {
                        DilatingDotsProgressBar.this.mStartTime = System.currentTimeMillis();
                        DilatingDotsProgressBar.this.setVisibility(0);
                        DilatingDotsProgressBar.this.startAnimations();
                    }
                }
            };
            init(attributeSet);
        }

        private void init(AttributeSet attributeSet) {
            this.mNumberDots = 3;
            this.mDotRadius = 8.0f;
            this.mDotColor = SupportMenu.CATEGORY_MASK;
            this.mDotEndColor = this.mDotColor;
            this.mDotScaleMultiplier = DEFAULT_GROWTH_MULTIPLIER;
            this.mAnimationDuration = HttpStatus.SC_MULTIPLE_CHOICES;
            this.mHorizontalSpacing = 12.0f;
            this.mShouldAnimate = false;
            this.mAnimateColors = this.mDotColor != this.mDotEndColor;
            calculateMaxRadius();
            calculateWidthBetweenDotCenters();
            initDots();
            updateDots();
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            if (computeMaxHeight() != i2 || i != computeMaxWidth()) {
                updateDots();
            }
        }

        @Override // android.view.View
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            removeCallbacks();
        }

        private void removeCallbacks() {
            removeCallbacks(this.mDelayedHide);
            removeCallbacks(this.mDelayedShow);
        }

        public void reset() {
            hideNow();
        }

        public void hide() {
            hide(HttpStatus.SC_INTERNAL_SERVER_ERROR);
        }

        public void hide(int i) {
            this.mDismissed = true;
            removeCallbacks(this.mDelayedShow);
            long jCurrentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            if (jCurrentTimeMillis >= i || this.mStartTime == -1) {
                this.mDelayedHide.run();
            } else if (i - jCurrentTimeMillis <= 0) {
                this.mDelayedHide.run();
            } else {
                postDelayed(this.mDelayedHide, i - jCurrentTimeMillis);
            }
        }

        public void show() {
            show(HttpStatus.SC_INTERNAL_SERVER_ERROR);
        }

        public void showNow() {
            show(0);
        }

        public void hideNow() {
            hide(0);
        }

        public void show(int i) {
            if (!this.mIsRunning) {
                this.mIsRunning = true;
                this.mStartTime = -1L;
                this.mDismissed = false;
                removeCallbacks(this.mDelayedHide);
                if (i == 0) {
                    this.mDelayedShow.run();
                } else {
                    postDelayed(this.mDelayedShow, i);
                }
            }
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (shouldAnimate()) {
                Iterator<DilatingDotDrawable> it = this.mDrawables.iterator();
                while (it.hasNext()) {
                    it.next().draw(canvas);
                }
            }
        }

        @Override // android.view.View
        protected boolean verifyDrawable(Drawable drawable) {
            return shouldAnimate() ? this.mDrawables.contains(drawable) : super.verifyDrawable(drawable);
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            setMeasuredDimension((int) computeMaxWidth(), (int) computeMaxHeight());
        }

        private float computeMaxHeight() {
            return this.mDotMaxRadius * 2.0f;
        }

        private float computeMaxWidth() {
            return computeWidth() + ((this.mDotMaxRadius - this.mDotRadius) * 2.0f);
        }

        private float computeWidth() {
            return (((this.mDotRadius * 2.0f) + this.mHorizontalSpacing) * this.mDrawables.size()) - this.mHorizontalSpacing;
        }

        private void calculateMaxRadius() {
            this.mDotMaxRadius = this.mDotRadius * this.mDotScaleMultiplier;
        }

        private void calculateWidthBetweenDotCenters() {
            this.mWidthBetweenDotCenters = ((int) (this.mDotRadius * 2.0f)) + ((int) this.mHorizontalSpacing);
        }

        private void initDots() {
            this.mDrawables.clear();
            this.mAnimations.clear();
            for (int i = 1; i <= this.mNumberDots; i++) {
                final DilatingDotDrawable dilatingDotDrawable = new DilatingDotDrawable(this.mDotColor, this.mDotRadius, this.mDotMaxRadius);
                dilatingDotDrawable.setCallback(this);
                this.mDrawables.add(dilatingDotDrawable);
                long j = (i - 1) * ((int) (0.35d * this.mAnimationDuration));
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(dilatingDotDrawable, "radius", this.mDotRadius, this.mDotMaxRadius, this.mDotRadius);
                objectAnimatorOfFloat.setDuration(this.mAnimationDuration);
                objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                if (i == this.mNumberDots) {
                    objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.my.freemyanmarid.BypassActivity.DilatingDotsProgressBar.3
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (DilatingDotsProgressBar.this.shouldAnimate()) {
                                DilatingDotsProgressBar.this.startAnimations();
                            }
                        }
                    });
                }
                objectAnimatorOfFloat.setStartDelay(j);
                this.mAnimations.add(objectAnimatorOfFloat);
                if (this.mAnimateColors) {
                    ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.mDotEndColor, this.mDotColor);
                    valueAnimatorOfInt.setDuration(this.mAnimationDuration);
                    valueAnimatorOfInt.setEvaluator(new ArgbEvaluator());
                    valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.my.freemyanmarid.BypassActivity.DilatingDotsProgressBar.4
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            dilatingDotDrawable.setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    if (i == this.mNumberDots) {
                        valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: com.my.freemyanmarid.BypassActivity.DilatingDotsProgressBar.5
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (DilatingDotsProgressBar.this.shouldAnimate()) {
                                    DilatingDotsProgressBar.this.startAnimations();
                                }
                            }
                        });
                    }
                    valueAnimatorOfInt.setStartDelay(j);
                    this.mAnimations.add(valueAnimatorOfInt);
                }
            }
        }

        private void updateDots() {
            if (this.mDotRadius <= 0.0f) {
                this.mDotRadius = (getHeight() / 2) / this.mDotScaleMultiplier;
            }
            int i = (int) (this.mDotMaxRadius - this.mDotRadius);
            int i2 = ((int) (i + (this.mDotRadius * 2.0f))) + 2;
            int i3 = ((int) (this.mDotMaxRadius * 2.0f)) + 2;
            int i4 = i2;
            for (int i5 = 0; i5 < this.mDrawables.size(); i5++) {
                DilatingDotDrawable dilatingDotDrawable = this.mDrawables.get(i5);
                dilatingDotDrawable.setRadius(this.mDotRadius);
                dilatingDotDrawable.setBounds(i, 0, i4, i3);
                ((ValueAnimator) this.mAnimations.get(i5)).setFloatValues(this.mDotRadius, this.mDotRadius * this.mDotScaleMultiplier, this.mDotRadius);
                i += this.mWidthBetweenDotCenters;
                i4 += this.mWidthBetweenDotCenters;
            }
        }

        protected void startAnimations() {
            this.mShouldAnimate = true;
            Iterator<Animator> it = this.mAnimations.iterator();
            while (it.hasNext()) {
                it.next().start();
            }
        }

        protected void stopAnimations() {
            this.mShouldAnimate = false;
            removeCallbacks();
            Iterator<Animator> it = this.mAnimations.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
        }

        protected boolean shouldAnimate() {
            return this.mShouldAnimate;
        }

        public void setDotRadius(float f) {
            reset();
            this.mDotRadius = f;
            calculateMaxRadius();
            calculateWidthBetweenDotCenters();
            setupDots();
        }

        public void setDotSpacing(float f) {
            reset();
            this.mHorizontalSpacing = f;
            calculateWidthBetweenDotCenters();
            setupDots();
        }

        public void setGrowthSpeed(int i) {
            reset();
            this.mAnimationDuration = i;
            setupDots();
        }

        public void setNumberOfDots(int i) {
            reset();
            this.mNumberDots = i;
            setupDots();
        }

        public void setDotScaleMultiplier(float f) {
            reset();
            this.mDotScaleMultiplier = f;
            calculateMaxRadius();
            setupDots();
        }

        public void setDotColor(int i) {
            if (i != this.mDotColor) {
                if (this.mAnimateColors) {
                    reset();
                    this.mDotColor = i;
                    this.mDotEndColor = i;
                    this.mAnimateColors = false;
                    setupDots();
                    return;
                }
                this.mDotColor = i;
                Iterator<DilatingDotDrawable> it = this.mDrawables.iterator();
                while (it.hasNext()) {
                    it.next().setColor(this.mDotColor);
                }
            }
        }

        public void setDotColors(int i, int i2) {
            if (this.mDotColor != i || this.mDotEndColor != i2) {
                if (this.mAnimateColors) {
                    reset();
                }
                this.mDotColor = i;
                this.mDotEndColor = i2;
                this.mAnimateColors = this.mDotColor != this.mDotEndColor;
                setupDots();
            }
        }

        private void setupDots() {
            initDots();
            updateDots();
            showNow();
        }

        public int getDotGrowthSpeed() {
            return this.mAnimationDuration;
        }

        public float getDotRadius() {
            return this.mDotRadius;
        }

        public float getHorizontalSpacing() {
            return this.mHorizontalSpacing;
        }

        public int getNumberOfDots() {
            return this.mNumberDots;
        }

        public float getDotScaleMultiplier() {
            return this.mDotScaleMultiplier;
        }
    }

    public void _rippleRoundStroke(View view, String str, String str2, double d, double d2, String str3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius((float) d);
        gradientDrawable.setStroke((int) d2, Color.parseColor("#" + str3.replace("#", "")));
        view.setBackground(new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor(str2)}), gradientDrawable, null));
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
