package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import androidx.annotation.RestrictTo;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes22.dex */
public class AnimationUtilsCompat {
    public static Interpolator loadInterpolator(Context context, int i) throws Resources.NotFoundException {
        Interpolator interpolatorCreateInterpolatorFromXml;
        if (Build.VERSION.SDK_INT >= 21) {
            return AnimationUtils.loadInterpolator(context, i);
        }
        XmlResourceParser animation = null;
        try {
            try {
                try {
                    if (i == 17563663) {
                        interpolatorCreateInterpolatorFromXml = new FastOutLinearInInterpolator();
                    } else if (i == 17563661) {
                        interpolatorCreateInterpolatorFromXml = new FastOutSlowInInterpolator();
                        if (0 != 0) {
                            animation.close();
                        }
                    } else if (i == 17563662) {
                        interpolatorCreateInterpolatorFromXml = new LinearOutSlowInInterpolator();
                        if (0 != 0) {
                            animation.close();
                        }
                    } else {
                        animation = context.getResources().getAnimation(i);
                        interpolatorCreateInterpolatorFromXml = createInterpolatorFromXml(context, context.getResources(), context.getTheme(), animation);
                        if (animation != null) {
                            animation.close();
                        }
                    }
                    return interpolatorCreateInterpolatorFromXml;
                } catch (XmlPullParserException e) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                    notFoundException.initCause(e);
                    throw notFoundException;
                }
            } catch (IOException e2) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException2.initCause(e2);
                throw notFoundException2;
            }
        } finally {
            if (animation != null) {
                animation.close();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00cc, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Interpolator createInterpolatorFromXml(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        Interpolator linearInterpolator = null;
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                break;
            }
            if (next == 2) {
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
                String name = xmlPullParser.getName();
                if (name.equals("linearInterpolator")) {
                    linearInterpolator = new LinearInterpolator();
                } else if (name.equals("accelerateInterpolator")) {
                    linearInterpolator = new AccelerateInterpolator(context, attributeSetAsAttributeSet);
                } else if (name.equals("decelerateInterpolator")) {
                    linearInterpolator = new DecelerateInterpolator(context, attributeSetAsAttributeSet);
                } else if (name.equals("accelerateDecelerateInterpolator")) {
                    linearInterpolator = new AccelerateDecelerateInterpolator();
                } else if (name.equals("cycleInterpolator")) {
                    linearInterpolator = new CycleInterpolator(context, attributeSetAsAttributeSet);
                } else if (name.equals("anticipateInterpolator")) {
                    linearInterpolator = new AnticipateInterpolator(context, attributeSetAsAttributeSet);
                } else if (name.equals("overshootInterpolator")) {
                    linearInterpolator = new OvershootInterpolator(context, attributeSetAsAttributeSet);
                } else if (name.equals("anticipateOvershootInterpolator")) {
                    linearInterpolator = new AnticipateOvershootInterpolator(context, attributeSetAsAttributeSet);
                } else if (name.equals("bounceInterpolator")) {
                    linearInterpolator = new BounceInterpolator();
                } else if (name.equals("pathInterpolator")) {
                    linearInterpolator = new PathInterpolatorCompat(context, attributeSetAsAttributeSet, xmlPullParser);
                } else {
                    throw new RuntimeException("Unknown interpolator name: " + xmlPullParser.getName());
                }
            }
        }
    }

    private AnimationUtilsCompat() {
    }
}
