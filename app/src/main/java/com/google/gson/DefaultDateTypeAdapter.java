package com.google.gson;

import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.PreJava9DateFormatProvider;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes53.dex */
final class DefaultDateTypeAdapter extends TypeAdapter<Date> {
    private static final String SIMPLE_NAME = "DefaultDateTypeAdapter";
    private final List<DateFormat> dateFormats;
    private final Class<? extends Date> dateType;

    DefaultDateTypeAdapter(Class<? extends Date> dateType) {
        this.dateFormats = new ArrayList();
        this.dateType = verifyDateType(dateType);
        this.dateFormats.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (JavaVersion.isJava9OrLater()) {
            this.dateFormats.add(PreJava9DateFormatProvider.getUSDateTimeFormat(2, 2));
        }
    }

    DefaultDateTypeAdapter(Class<? extends Date> dateType, String datePattern) {
        this.dateFormats = new ArrayList();
        this.dateType = verifyDateType(dateType);
        this.dateFormats.add(new SimpleDateFormat(datePattern, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(new SimpleDateFormat(datePattern));
        }
    }

    DefaultDateTypeAdapter(Class<? extends Date> dateType, int style) {
        this.dateFormats = new ArrayList();
        this.dateType = verifyDateType(dateType);
        this.dateFormats.add(DateFormat.getDateInstance(style, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(DateFormat.getDateInstance(style));
        }
        if (JavaVersion.isJava9OrLater()) {
            this.dateFormats.add(PreJava9DateFormatProvider.getUSDateFormat(style));
        }
    }

    public DefaultDateTypeAdapter(int dateStyle, int timeStyle) {
        this(Date.class, dateStyle, timeStyle);
    }

    public DefaultDateTypeAdapter(Class<? extends Date> dateType, int dateStyle, int timeStyle) {
        this.dateFormats = new ArrayList();
        this.dateType = verifyDateType(dateType);
        this.dateFormats.add(DateFormat.getDateTimeInstance(dateStyle, timeStyle, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(DateFormat.getDateTimeInstance(dateStyle, timeStyle));
        }
        if (JavaVersion.isJava9OrLater()) {
            this.dateFormats.add(PreJava9DateFormatProvider.getUSDateTimeFormat(dateStyle, timeStyle));
        }
    }

    private static Class<? extends Date> verifyDateType(Class<? extends Date> dateType) {
        if (dateType != Date.class && dateType != java.sql.Date.class && dateType != Timestamp.class) {
            throw new IllegalArgumentException("Date type must be one of " + Date.class + ", " + Timestamp.class + ", or " + java.sql.Date.class + " but was " + dateType);
        }
        return dateType;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter out, Date value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }
        synchronized (this.dateFormats) {
            String dateFormatAsString = this.dateFormats.get(0).format(value);
            out.value(dateFormatAsString);
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read, reason: avoid collision after fix types in other method */
    public Date read2(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        Date date = deserializeToDate(in.nextString());
        if (this.dateType != Date.class) {
            if (this.dateType == Timestamp.class) {
                return new Timestamp(date.getTime());
            }
            if (this.dateType == java.sql.Date.class) {
                return new java.sql.Date(date.getTime());
            }
            throw new AssertionError();
        }
        return date;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
    
        r2 = com.google.gson.internal.bind.util.ISO8601Utils.parse(r6, new java.text.ParsePosition(0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Date deserializeToDate(String s) {
        Date date;
        synchronized (this.dateFormats) {
            Iterator<DateFormat> it = this.dateFormats.iterator();
            while (true) {
                if (it.hasNext()) {
                    DateFormat dateFormat = it.next();
                    try {
                        date = dateFormat.parse(s);
                        break;
                    } catch (ParseException e) {
                    }
                } else {
                    try {
                        break;
                    } catch (ParseException e2) {
                        throw new JsonSyntaxException(s, e2);
                    }
                }
            }
        }
        return date;
    }

    public String toString() {
        DateFormat defaultFormat = this.dateFormats.get(0);
        return defaultFormat instanceof SimpleDateFormat ? "DefaultDateTypeAdapter(" + ((SimpleDateFormat) defaultFormat).toPattern() + ')' : "DefaultDateTypeAdapter(" + defaultFormat.getClass().getSimpleName() + ')';
    }
}
