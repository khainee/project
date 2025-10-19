package androidx.documentfile.provider;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(19)
/* loaded from: classes46.dex */
class DocumentsContractApi19 {
    private static final int FLAG_VIRTUAL_DOCUMENT = 512;
    private static final String TAG = "DocumentFile";

    public static boolean isVirtual(Context context, Uri uri) {
        if (DocumentsContract.isDocumentUri(context, uri)) {
            return (getFlags(context, uri) & 512) != 0;
        }
        return false;
    }

    @Nullable
    public static String getName(Context context, Uri uri) {
        return queryForString(context, uri, "_display_name", null);
    }

    @Nullable
    private static String getRawType(Context context, Uri uri) {
        return queryForString(context, uri, "mime_type", null);
    }

    @Nullable
    public static String getType(Context context, Uri uri) {
        String rawType = getRawType(context, uri);
        if ("vnd.android.document/directory".equals(rawType)) {
            return null;
        }
        return rawType;
    }

    public static long getFlags(Context context, Uri uri) {
        return queryForLong(context, uri, "flags", 0L);
    }

    public static boolean isDirectory(Context context, Uri uri) {
        return "vnd.android.document/directory".equals(getRawType(context, uri));
    }

    public static boolean isFile(Context context, Uri uri) {
        String rawType = getRawType(context, uri);
        return ("vnd.android.document/directory".equals(rawType) || TextUtils.isEmpty(rawType)) ? false : true;
    }

    public static long lastModified(Context context, Uri uri) {
        return queryForLong(context, uri, "last_modified", 0L);
    }

    public static long length(Context context, Uri uri) {
        return queryForLong(context, uri, "_size", 0L);
    }

    public static boolean canRead(Context context, Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 1) == 0 && !TextUtils.isEmpty(getRawType(context, uri))) {
            return true;
        }
        return false;
    }

    public static boolean canWrite(Context context, Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 2) != 0) {
            return false;
        }
        String rawType = getRawType(context, uri);
        int iQueryForInt = queryForInt(context, uri, "flags", 0);
        if (TextUtils.isEmpty(rawType)) {
            return false;
        }
        if ((iQueryForInt & 4) != 0) {
            return true;
        }
        if ("vnd.android.document/directory".equals(rawType) && (iQueryForInt & 8) != 0) {
            return true;
        }
        if (!TextUtils.isEmpty(rawType) && (iQueryForInt & 2) != 0) {
            return true;
        }
        return false;
    }

    public static boolean exists(Context context, Uri uri) throws Exception {
        boolean z;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(uri, new String[]{"document_id"}, null, null, null);
                boolean z2 = cursorQuery.getCount() > 0;
                closeQuietly(cursorQuery);
                z = z2;
            } catch (Exception e) {
                Log.w(TAG, "Failed query: " + e);
                closeQuietly(cursorQuery);
                z = false;
            }
            return z;
        } catch (Throwable th) {
            closeQuietly(cursorQuery);
            throw th;
        }
    }

    @Nullable
    private static String queryForString(Context context, Uri uri, String str, @Nullable String str2) throws Exception {
        String str3;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
                if (cursorQuery.moveToFirst() && !cursorQuery.isNull(0)) {
                    String string = cursorQuery.getString(0);
                    closeQuietly(cursorQuery);
                    str3 = string;
                } else {
                    closeQuietly(cursorQuery);
                    str3 = str2;
                }
            } catch (Exception e) {
                Log.w(TAG, "Failed query: " + e);
                closeQuietly(cursorQuery);
                str3 = str2;
            }
            return str3;
        } catch (Throwable th) {
            closeQuietly(cursorQuery);
            throw th;
        }
    }

    private static int queryForInt(Context context, Uri uri, String str, int i) {
        return (int) queryForLong(context, uri, str, i);
    }

    private static long queryForLong(Context context, Uri uri, String str, long j) throws Exception {
        long j2;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
                if (cursorQuery.moveToFirst() && !cursorQuery.isNull(0)) {
                    long j3 = cursorQuery.getLong(0);
                    closeQuietly(cursorQuery);
                    j2 = j3;
                } else {
                    closeQuietly(cursorQuery);
                    j2 = j;
                }
            } catch (Exception e) {
                Log.w(TAG, "Failed query: " + e);
                closeQuietly(cursorQuery);
                j2 = j;
            }
            return j2;
        } catch (Throwable th) {
            closeQuietly(cursorQuery);
            throw th;
        }
    }

    private static void closeQuietly(@Nullable AutoCloseable autoCloseable) throws Exception {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    private DocumentsContractApi19() {
    }
}
