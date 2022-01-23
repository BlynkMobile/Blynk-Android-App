package okhttp3.internal.http2;

import java.io.IOException;
import p225l.p226g0.C4402c;
import p230m.C4455f;

/* renamed from: okhttp3.internal.http2.d */
/* compiled from: Http2 */
public final class C6515d {

    /* renamed from: a */
    static final C4455f f17628a = C4455f.m17622i("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: b */
    private static final String[] f17629b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: c */
    static final String[] f17630c = new String[64];

    /* renamed from: d */
    static final String[] f17631d = new String[256];

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = f17631d;
            if (i2 >= strArr.length) {
                break;
            }
            strArr[i2] = C4402c.m17197r("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
            i2++;
        }
        String[] strArr2 = f17630c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i3 = 0; i3 < 1; i3++) {
            int i4 = iArr[i3];
            String[] strArr3 = f17630c;
            strArr3[i4 | 8] = strArr3[i4] + "|PADDED";
        }
        String[] strArr4 = f17630c;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i5 = 0; i5 < 3; i5++) {
            int i6 = iArr2[i5];
            for (int i7 = 0; i7 < 1; i7++) {
                int i8 = iArr[i7];
                String[] strArr5 = f17630c;
                int i9 = i8 | i6;
                strArr5[i9] = strArr5[i8] + '|' + strArr5[i6];
                strArr5[i9 | 8] = strArr5[i8] + '|' + strArr5[i6] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr6 = f17630c;
            if (i < strArr6.length) {
                if (strArr6[i] == null) {
                    strArr6[i] = f17631d[i];
                }
                i++;
            } else {
                return;
            }
        }
    }

    private C6515d() {
    }

    /* renamed from: a */
    static String m25435a(byte b, byte b2) {
        if (b2 == 0) {
            return "";
        }
        if (!(b == 2 || b == 3)) {
            if (b == 4 || b == 6) {
                if (b2 == 1) {
                    return "ACK";
                }
                return f17631d[b2];
            } else if (!(b == 7 || b == 8)) {
                String[] strArr = f17630c;
                String str = b2 < strArr.length ? strArr[b2] : f17631d[b2];
                if (b != 5 || (b2 & 4) == 0) {
                    return (b != 0 || (b2 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return f17631d[b2];
    }

    /* renamed from: b */
    static String m25436b(boolean z, int i, int i2, byte b, byte b2) {
        String[] strArr = f17629b;
        String r = b < strArr.length ? strArr[b] : C4402c.m17197r("0x%02x", Byte.valueOf(b));
        String a = m25435a(b, b2);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = r;
        objArr[4] = a;
        return C4402c.m17197r("%s 0x%08x %5d %-13s %s", objArr);
    }

    /* renamed from: c */
    static IllegalArgumentException m25437c(String str, Object... objArr) {
        throw new IllegalArgumentException(C4402c.m17197r(str, objArr));
    }

    /* renamed from: d */
    static IOException m25438d(String str, Object... objArr) throws IOException {
        throw new IOException(C4402c.m17197r(str, objArr));
    }
}
