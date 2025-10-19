package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.os.Bundle;
import androidx.tracing.Trace;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes29.dex */
public final class AppInitializer {
    private static final String SECTION_NAME = "Startup";
    private static volatile AppInitializer sInstance;
    private static final Object sLock = new Object();
    final Context mContext;
    final Set<Class<? extends Initializer<?>>> mDiscovered = new HashSet();
    final Map<Class<?>, Object> mInitialized = new HashMap();

    AppInitializer(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static AppInitializer getInstance(Context context) {
        if (sInstance == null) {
            synchronized (sLock) {
                if (sInstance == null) {
                    sInstance = new AppInitializer(context);
                }
            }
        }
        return sInstance;
    }

    public <T> T initializeComponent(Class<? extends Initializer<T>> cls) {
        return (T) doInitialize(cls, new HashSet());
    }

    public boolean isEagerlyInitialized(Class<? extends Initializer<?>> component) {
        return this.mDiscovered.contains(component);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007b A[Catch: all -> 0x0090, TRY_ENTER, TryCatch #0 {all -> 0x0090, blocks: (B:6:0x0009, B:7:0x0010, B:9:0x0017, B:11:0x001f, B:24:0x0068, B:25:0x006d, B:26:0x006e, B:32:0x007b, B:33:0x008f, B:12:0x0022, B:14:0x003c, B:15:0x0040, B:17:0x0046, B:19:0x0054, B:21:0x0058), top: B:42:0x0009, outer: #1, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0017 A[Catch: all -> 0x0090, TryCatch #0 {all -> 0x0090, blocks: (B:6:0x0009, B:7:0x0010, B:9:0x0017, B:11:0x001f, B:24:0x0068, B:25:0x006d, B:26:0x006e, B:32:0x007b, B:33:0x008f, B:12:0x0022, B:14:0x003c, B:15:0x0040, B:17:0x0046, B:19:0x0054, B:21:0x0058), top: B:42:0x0009, outer: #1, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    <T> T doInitialize(Class<? extends Initializer<?>> cls, Set<Class<?>> set) {
        T t;
        synchronized (sLock) {
            if (Trace.isEnabled()) {
                try {
                    Trace.beginSection(cls.getSimpleName());
                    if (!set.contains(cls)) {
                        throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
                    }
                    if (!this.mInitialized.containsKey(cls)) {
                        set.add(cls);
                        try {
                            Initializer<?> initializerNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                            List<Class<? extends Initializer<?>>> listDependencies = initializerNewInstance.dependencies();
                            if (!listDependencies.isEmpty()) {
                                for (Class<? extends Initializer<?>> cls2 : listDependencies) {
                                    if (!this.mInitialized.containsKey(cls2)) {
                                        doInitialize(cls2, set);
                                    }
                                }
                            }
                            t = (T) initializerNewInstance.create(this.mContext);
                            set.remove(cls);
                            this.mInitialized.put(cls, t);
                        } catch (Throwable th) {
                            throw new StartupException(th);
                        }
                    } else {
                        t = (T) this.mInitialized.get(cls);
                    }
                } finally {
                    Trace.endSection();
                }
            } else if (!set.contains(cls)) {
            }
        }
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void discoverAndInitialize() {
        try {
            try {
                Trace.beginSection(SECTION_NAME);
                ComponentName provider = new ComponentName(this.mContext.getPackageName(), InitializationProvider.class.getName());
                ProviderInfo providerInfo = this.mContext.getPackageManager().getProviderInfo(provider, 128);
                Bundle metadata = providerInfo.metaData;
                String startup = this.mContext.getString(R.string.androidx_startup);
                if (metadata != null) {
                    Set<Class<?>> initializing = new HashSet<>();
                    Set<String> keys = metadata.keySet();
                    for (String key : keys) {
                        String value = metadata.getString(key, null);
                        if (startup.equals(value)) {
                            Class<?> clazz = Class.forName(key);
                            if (Initializer.class.isAssignableFrom(clazz)) {
                                this.mDiscovered.add(clazz);
                                doInitialize(clazz, initializing);
                            }
                        }
                    }
                }
            } finally {
                Trace.endSection();
            }
        } catch (PackageManager.NameNotFoundException | ClassNotFoundException exception) {
            throw new StartupException(exception);
        }
    }
}
