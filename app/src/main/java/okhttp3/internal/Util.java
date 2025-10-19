package okhttp3.internal;

import androidx.core.location.LocationRequestCompat;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import org.apache.http.protocol.HTTP;

/* loaded from: classes54.dex */
public final class Util {
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final ResponseBody EMPTY_RESPONSE = ResponseBody.create((MediaType) null, EMPTY_BYTE_ARRAY);
    public static final RequestBody EMPTY_REQUEST = RequestBody.create((MediaType) null, EMPTY_BYTE_ARRAY);
    private static final ByteString UTF_8_BOM = ByteString.decodeHex("efbbbf");
    private static final ByteString UTF_16_BE_BOM = ByteString.decodeHex("feff");
    private static final ByteString UTF_16_LE_BOM = ByteString.decodeHex("fffe");
    private static final ByteString UTF_32_BE_BOM = ByteString.decodeHex("0000ffff");
    private static final ByteString UTF_32_LE_BOM = ByteString.decodeHex("ffff0000");
    public static final Charset UTF_8 = Charset.forName(HTTP.UTF_8);
    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    private static final Charset UTF_16_BE = Charset.forName("UTF-16BE");
    private static final Charset UTF_16_LE = Charset.forName("UTF-16LE");
    private static final Charset UTF_32_BE = Charset.forName("UTF-32BE");
    private static final Charset UTF_32_LE = Charset.forName("UTF-32LE");
    public static final TimeZone UTC = TimeZone.getTimeZone("GMT");
    public static final Comparator<String> NATURAL_ORDER = new Comparator<String>() { // from class: okhttp3.internal.Util.1
        @Override // java.util.Comparator
        public int compare(String a, String b) {
            return a.compareTo(b);
        }
    };
    private static final Pattern VERIFY_AS_IP_ADDRESS = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    private Util() {
    }

    public static void checkOffsetAndCount(long arrayLength, long offset, long count) {
        if ((offset | count) < 0 || offset > arrayLength || arrayLength - offset < count) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static boolean equal(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    public static void closeQuietly(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException rethrown) {
                throw rethrown;
            } catch (Exception e) {
            }
        }
    }

    public static void closeQuietly(Socket socket) throws IOException {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e) {
                if (!isAndroidGetsocknameError(e)) {
                    throw e;
                }
            } catch (RuntimeException rethrown) {
                throw rethrown;
            } catch (Exception e2) {
            }
        }
    }

    public static void closeQuietly(ServerSocket serverSocket) throws IOException {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (RuntimeException rethrown) {
                throw rethrown;
            } catch (Exception e) {
            }
        }
    }

    public static boolean discard(Source source, int timeout, TimeUnit timeUnit) {
        try {
            return skipAll(source, timeout, timeUnit);
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean skipAll(Source source, int duration, TimeUnit timeUnit) throws IOException {
        long now = System.nanoTime();
        long originalDuration = source.timeout().hasDeadline() ? source.timeout().deadlineNanoTime() - now : Long.MAX_VALUE;
        source.timeout().deadlineNanoTime(Math.min(originalDuration, timeUnit.toNanos(duration)) + now);
        try {
            Buffer skipBuffer = new Buffer();
            while (source.read(skipBuffer, 8192L) != -1) {
                skipBuffer.clear();
            }
            if (originalDuration == LocationRequestCompat.PASSIVE_INTERVAL) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(now + originalDuration);
            }
            return true;
        } catch (InterruptedIOException e) {
            if (originalDuration == LocationRequestCompat.PASSIVE_INTERVAL) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(now + originalDuration);
            }
            return false;
        } catch (Throwable th) {
            if (originalDuration == LocationRequestCompat.PASSIVE_INTERVAL) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(now + originalDuration);
            }
            throw th;
        }
    }

    public static <T> List<T> immutableList(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> immutableList(T... elements) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) elements.clone()));
    }

    public static ThreadFactory threadFactory(final String name, final boolean daemon) {
        return new ThreadFactory() { // from class: okhttp3.internal.Util.2
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread result = new Thread(runnable, name);
                result.setDaemon(daemon);
                return result;
            }
        };
    }

    public static String[] intersect(Comparator<? super String> comparator, String[] first, String[] second) {
        List<String> result = new ArrayList<>();
        for (String a : first) {
            int length = second.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    String b = second[i];
                    if (comparator.compare(a, b) != 0) {
                        i++;
                    } else {
                        result.add(a);
                        break;
                    }
                }
            }
        }
        return (String[]) result.toArray(new String[result.size()]);
    }

    public static boolean nonEmptyIntersection(Comparator<String> comparator, String[] first, String[] second) {
        if (first == null || second == null || first.length == 0 || second.length == 0) {
            return false;
        }
        for (String a : first) {
            for (String b : second) {
                if (comparator.compare(a, b) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String hostHeader(HttpUrl url, boolean includeDefaultPort) {
        String host;
        if (url.host().contains(":")) {
            host = "[" + url.host() + "]";
        } else {
            host = url.host();
        }
        if (!includeDefaultPort && url.port() == HttpUrl.defaultPort(url.scheme())) {
            return host;
        }
        return host + ":" + url.port();
    }

    public static String toHumanReadableAscii(String s) {
        int i = 0;
        int length = s.length();
        while (i < length) {
            int c = s.codePointAt(i);
            if (c > 31 && c < 127) {
                i += Character.charCount(c);
            } else {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(s, 0, i);
                int j = i;
                while (j < length) {
                    int c2 = s.codePointAt(j);
                    buffer.writeUtf8CodePoint((c2 <= 31 || c2 >= 127) ? 63 : c2);
                    j += Character.charCount(c2);
                }
                return buffer.readUtf8();
            }
        }
        return s;
    }

    public static boolean isAndroidGetsocknameError(AssertionError e) {
        return (e.getCause() == null || e.getMessage() == null || !e.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static int indexOf(Comparator<String> comparator, String[] array, String value) {
        int size = array.length;
        for (int i = 0; i < size; i++) {
            if (comparator.compare(array[i], value) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static String[] concat(String[] array, String value) {
        String[] result = new String[array.length + 1];
        System.arraycopy(array, 0, result, 0, array.length);
        result[result.length - 1] = value;
        return result;
    }

    public static int skipLeadingAsciiWhitespace(String input, int pos, int limit) {
        for (int i = pos; i < limit; i++) {
            switch (input.charAt(i)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                default:
                    return i;
            }
        }
        return limit;
    }

    public static int skipTrailingAsciiWhitespace(String input, int pos, int limit) {
        for (int i = limit - 1; i >= pos; i--) {
            switch (input.charAt(i)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                default:
                    return i + 1;
            }
        }
        return pos;
    }

    public static String trimSubstring(String string, int pos, int limit) {
        int start = skipLeadingAsciiWhitespace(string, pos, limit);
        int end = skipTrailingAsciiWhitespace(string, start, limit);
        return string.substring(start, end);
    }

    public static int delimiterOffset(String input, int pos, int limit, String delimiters) {
        for (int i = pos; i < limit; i++) {
            if (delimiters.indexOf(input.charAt(i)) != -1) {
                return i;
            }
        }
        return limit;
    }

    public static int delimiterOffset(String input, int pos, int limit, char delimiter) {
        for (int i = pos; i < limit; i++) {
            if (input.charAt(i) == delimiter) {
                return i;
            }
        }
        return limit;
    }

    public static String canonicalizeHost(String host) {
        InetAddress inetAddress;
        if (host.contains(":")) {
            if (host.startsWith("[") && host.endsWith("]")) {
                inetAddress = decodeIpv6(host, 1, host.length() - 1);
            } else {
                inetAddress = decodeIpv6(host, 0, host.length());
            }
            if (inetAddress == null) {
                return null;
            }
            byte[] address = inetAddress.getAddress();
            if (address.length == 16) {
                return inet6AddressToAscii(address);
            }
            throw new AssertionError("Invalid IPv6 address: '" + host + "'");
        }
        try {
            String result = IDN.toASCII(host).toLowerCase(Locale.US);
            if (result.isEmpty()) {
                return null;
            }
            if (containsInvalidHostnameAsciiCodes(result)) {
                return null;
            }
            return result;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private static boolean containsInvalidHostnameAsciiCodes(String hostnameAscii) {
        for (int i = 0; i < hostnameAscii.length(); i++) {
            char c = hostnameAscii.charAt(i);
            if (c <= 31 || c >= 127 || " #%/:?@[\\]".indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }

    public static int indexOfControlOrNonAscii(String input) {
        int i = 0;
        int length = input.length();
        while (i < length) {
            char c = input.charAt(i);
            if (c > 31 && c < 127) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }

    public static boolean verifyAsIpAddress(String host) {
        return VERIFY_AS_IP_ADDRESS.matcher(host).matches();
    }

    public static String format(String format, Object... args) {
        return String.format(Locale.US, format, args);
    }

    public static Charset bomAwareCharset(BufferedSource source, Charset charset) throws IOException {
        if (source.rangeEquals(0L, UTF_8_BOM)) {
            source.skip(UTF_8_BOM.size());
            Charset charset2 = UTF_8;
            return charset2;
        }
        if (source.rangeEquals(0L, UTF_16_BE_BOM)) {
            source.skip(UTF_16_BE_BOM.size());
            Charset charset3 = UTF_16_BE;
            return charset3;
        }
        if (source.rangeEquals(0L, UTF_16_LE_BOM)) {
            source.skip(UTF_16_LE_BOM.size());
            Charset charset4 = UTF_16_LE;
            return charset4;
        }
        if (source.rangeEquals(0L, UTF_32_BE_BOM)) {
            source.skip(UTF_32_BE_BOM.size());
            Charset charset5 = UTF_32_BE;
            return charset5;
        }
        if (source.rangeEquals(0L, UTF_32_LE_BOM)) {
            source.skip(UTF_32_LE_BOM.size());
            Charset charset6 = UTF_32_LE;
            return charset6;
        }
        return charset;
    }

    public static int checkDuration(String name, long duration, TimeUnit unit) {
        if (duration < 0) {
            throw new IllegalArgumentException(name + " < 0");
        }
        if (unit == null) {
            throw new NullPointerException("unit == null");
        }
        long millis = unit.toMillis(duration);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException(name + " too large.");
        }
        if (millis != 0 || duration <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException(name + " too small.");
    }

    public static AssertionError assertionError(String message, Exception e) {
        return (AssertionError) new AssertionError(message).initCause(e);
    }

    public static int decodeHexDigit(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 'a') + 10;
        }
        if (c < 'A' || c > 'F') {
            return -1;
        }
        return (c - 'A') + 10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
    
        if (r2 == r1.length) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0034, code lost:
    
        if (r5 != (-1)) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0036, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0094, code lost:
    
        java.lang.System.arraycopy(r1, r5, r1, r1.length - (r2 - r5), r2 - r5);
        java.util.Arrays.fill(r1, r5, (r1.length - r2) + r5, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b0, code lost:
    
        throw new java.lang.AssertionError();
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:?, code lost:
    
        return java.net.InetAddress.getByAddress(r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004c  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static InetAddress decodeIpv6(String input, int pos, int limit) {
        int groupLength;
        byte[] address = new byte[16];
        int b = 0;
        int compress = -1;
        int groupOffset = -1;
        int i = pos;
        while (true) {
            if (i < limit) {
                if (b != address.length) {
                    if (i + 2 <= limit && input.regionMatches(i, "::", 0, 2)) {
                        if (compress == -1) {
                            i += 2;
                            b += 2;
                            compress = b;
                            if (i == limit) {
                                break;
                            }
                            int value = 0;
                            groupOffset = i;
                            while (i < limit) {
                            }
                            groupLength = i - groupOffset;
                            if (groupLength == 0) {
                                break;
                            }
                            break;
                            break;
                        }
                        return null;
                    }
                    if (b != 0) {
                        if (input.regionMatches(i, ":", 0, 1)) {
                            i++;
                        } else {
                            if (!input.regionMatches(i, ".", 0, 1) || !decodeIpv4Suffix(input, groupOffset, limit, address, b - 2)) {
                                return null;
                            }
                            b += 2;
                        }
                    }
                    int value2 = 0;
                    groupOffset = i;
                    while (i < limit) {
                        char c = input.charAt(i);
                        int hexDigit = decodeHexDigit(c);
                        if (hexDigit == -1) {
                            break;
                        }
                        value2 = (value2 << 4) + hexDigit;
                        i++;
                    }
                    groupLength = i - groupOffset;
                    if (groupLength == 0 || groupLength > 4) {
                        break;
                    }
                    int b2 = b + 1;
                    address[b] = (byte) ((value2 >>> 8) & 255);
                    b = b2 + 1;
                    address[b2] = (byte) (value2 & 255);
                } else {
                    return null;
                }
            } else {
                break;
            }
        }
        return null;
    }

    private static boolean decodeIpv4Suffix(String input, int pos, int limit, byte[] address, int addressOffset) {
        int i = pos;
        int b = addressOffset;
        while (i < limit) {
            if (b == address.length) {
                return false;
            }
            if (b != addressOffset) {
                if (input.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int value = 0;
            int groupOffset = i;
            while (i < limit) {
                char c = input.charAt(i);
                if (c < '0' || c > '9') {
                    break;
                }
                if ((value == 0 && groupOffset != i) || ((value * 10) + c) - 48 > 255) {
                    return false;
                }
                i++;
            }
            int groupLength = i - groupOffset;
            if (groupLength == 0) {
                return false;
            }
            address[b] = (byte) value;
            b++;
        }
        return b == addressOffset + 4;
    }

    private static String inet6AddressToAscii(byte[] address) {
        int longestRunOffset = -1;
        int longestRunLength = 0;
        int i = 0;
        while (i < address.length) {
            int currentRunOffset = i;
            while (i < 16 && address[i] == 0 && address[i + 1] == 0) {
                i += 2;
            }
            int currentRunLength = i - currentRunOffset;
            if (currentRunLength > longestRunLength && currentRunLength >= 4) {
                longestRunOffset = currentRunOffset;
                longestRunLength = currentRunLength;
            }
            i += 2;
        }
        Buffer result = new Buffer();
        int i2 = 0;
        while (i2 < address.length) {
            if (i2 == longestRunOffset) {
                result.writeByte(58);
                i2 += longestRunLength;
                if (i2 == 16) {
                    result.writeByte(58);
                }
            } else {
                if (i2 > 0) {
                    result.writeByte(58);
                }
                int group = ((address[i2] & 255) << 8) | (address[i2 + 1] & 255);
                result.writeHexadecimalUnsignedLong(group);
                i2 += 2;
            }
        }
        return result.readUtf8();
    }
}
