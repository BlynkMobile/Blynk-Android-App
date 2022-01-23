package kotlin.p343b.p344a;

import java.util.Arrays;

/* renamed from: kotlin.b.a.b */
/* compiled from: Intrinsics */
public class C6343b {
    private C6343b() {
    }

    /* renamed from: a */
    public static void m24754a(Object obj) {
        if (obj == null) {
            m24760g();
            throw null;
        }
    }

    /* renamed from: b */
    public static void m24755b(Object obj, String str) {
        if (obj == null) {
            NullPointerException nullPointerException = new NullPointerException(str + " must not be null");
            m24758e(nullPointerException);
            throw nullPointerException;
        }
    }

    /* renamed from: c */
    public static void m24756c(Object obj, String str) {
        if (obj == null) {
            m24761h(str);
            throw null;
        }
    }

    /* renamed from: d */
    private static String m24757d(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        return "Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str;
    }

    /* renamed from: e */
    private static <T extends Throwable> T m24758e(T t) {
        m24759f(t, C6343b.class.getName());
        return t;
    }

    /* renamed from: f */
    static <T extends Throwable> T m24759f(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return t;
    }

    /* renamed from: g */
    public static void m24760g() {
        NullPointerException nullPointerException = new NullPointerException();
        m24758e(nullPointerException);
        throw nullPointerException;
    }

    /* renamed from: h */
    private static void m24761h(String str) {
        NullPointerException nullPointerException = new NullPointerException(m24757d(str));
        m24758e(nullPointerException);
        throw nullPointerException;
    }
}
