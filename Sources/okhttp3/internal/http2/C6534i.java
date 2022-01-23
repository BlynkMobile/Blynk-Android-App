package okhttp3.internal.http2;

import com.blynk.android.model.widget.Widget;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.danlew.android.joda.DateUtils;
import okhttp3.internal.http2.C6512c;
import p225l.p226g0.C4402c;
import p230m.C4450c;
import p230m.C4453d;

/* renamed from: okhttp3.internal.http2.i */
/* compiled from: Http2Writer */
final class C6534i implements Closeable {

    /* renamed from: h */
    private static final Logger f17714h = Logger.getLogger(C6515d.class.getName());

    /* renamed from: b */
    private final C4453d f17715b;

    /* renamed from: c */
    private final boolean f17716c;

    /* renamed from: d */
    private final C4450c f17717d;

    /* renamed from: e */
    private int f17718e = DateUtils.FORMAT_ABBREV_TIME;

    /* renamed from: f */
    private boolean f17719f;

    /* renamed from: g */
    final C6512c.C6514b f17720g;

    C6534i(C4453d dVar, boolean z) {
        this.f17715b = dVar;
        this.f17716c = z;
        C4450c cVar = new C4450c();
        this.f17717d = cVar;
        this.f17720g = new C6512c.C6514b(cVar);
    }

    /* renamed from: A */
    private static void m25530A(C4453d dVar, int i) throws IOException {
        dVar.mo22449y((i >>> 16) & Widget.DEFAULT_MAX);
        dVar.mo22449y((i >>> 8) & Widget.DEFAULT_MAX);
        dVar.mo22449y(i & Widget.DEFAULT_MAX);
    }

    /* renamed from: z */
    private void m25531z(int i, long j) throws IOException {
        while (j > 0) {
            int min = (int) Math.min((long) this.f17718e, j);
            long j2 = (long) min;
            j -= j2;
            mo35833g(i, min, (byte) 9, j == 0 ? (byte) 4 : 0);
            this.f17715b.mo22370O(this.f17717d, j2);
        }
    }

    /* renamed from: a */
    public synchronized void mo35827a(C6539l lVar) throws IOException {
        if (!this.f17719f) {
            this.f17718e = lVar.mo35855f(this.f17718e);
            if (lVar.mo35852c() != -1) {
                this.f17720g.mo35784e(lVar.mo35852c());
            }
            mo35833g(0, 0, (byte) 4, (byte) 1);
            this.f17715b.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: b */
    public synchronized void mo35828b() throws IOException {
        if (this.f17719f) {
            throw new IOException("closed");
        } else if (this.f17716c) {
            Logger logger = f17714h;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(C4402c.m17197r(">> CONNECTION %s", C6515d.f17628a.mo22469l()));
            }
            this.f17715b.mo22411f0(C6515d.f17628a.mo22479x());
            this.f17715b.flush();
        }
    }

    public synchronized void close() throws IOException {
        this.f17719f = true;
        this.f17715b.close();
    }

    /* renamed from: d */
    public synchronized void mo35830d(boolean z, int i, C4450c cVar, int i2) throws IOException {
        if (!this.f17719f) {
            byte b = 0;
            if (z) {
                b = (byte) 1;
            }
            mo35831f(i, b, cVar, i2);
        } else {
            throw new IOException("closed");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo35831f(int i, byte b, C4450c cVar, int i2) throws IOException {
        mo35833g(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.f17715b.mo22370O(cVar, (long) i2);
        }
    }

    public synchronized void flush() throws IOException {
        if (!this.f17719f) {
            this.f17715b.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: g */
    public void mo35833g(int i, int i2, byte b, byte b2) throws IOException {
        Logger logger = f17714h;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(C6515d.m25436b(false, i, i2, b, b2));
        }
        int i3 = this.f17718e;
        if (i2 > i3) {
            C6515d.m25437c("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
            throw null;
        } else if ((Integer.MIN_VALUE & i) == 0) {
            m25530A(this.f17715b, i2);
            this.f17715b.mo22449y(b & 255);
            this.f17715b.mo22449y(b2 & 255);
            this.f17715b.mo22437s(i & Integer.MAX_VALUE);
        } else {
            C6515d.m25437c("reserved bit set: %s", Integer.valueOf(i));
            throw null;
        }
    }

    /* renamed from: j */
    public synchronized void mo35834j(int i, C6509a aVar, byte[] bArr) throws IOException {
        if (this.f17719f) {
            throw new IOException("closed");
        } else if (aVar.f17599b != -1) {
            mo35833g(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f17715b.mo22437s(i);
            this.f17715b.mo22437s(aVar.f17599b);
            if (bArr.length > 0) {
                this.f17715b.mo22411f0(bArr);
            }
            this.f17715b.flush();
        } else {
            C6515d.m25437c("errorCode.httpCode == -1", new Object[0]);
            throw null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo35835k(boolean z, int i, List<C6510b> list) throws IOException {
        if (!this.f17719f) {
            this.f17720g.mo35786g(list);
            long S = this.f17717d.mo22398S();
            int min = (int) Math.min((long) this.f17718e, S);
            long j = (long) min;
            byte b = S == j ? (byte) 4 : 0;
            if (z) {
                b = (byte) (b | 1);
            }
            mo35833g(i, min, (byte) 1, b);
            this.f17715b.mo22370O(this.f17717d, j);
            if (S > j) {
                m25531z(i, S - j);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }

    /* renamed from: m */
    public int mo35836m() {
        return this.f17718e;
    }

    /* renamed from: n */
    public synchronized void mo35837n(boolean z, int i, int i2) throws IOException {
        if (!this.f17719f) {
            mo35833g(0, 8, (byte) 6, z ? (byte) 1 : 0);
            this.f17715b.mo22437s(i);
            this.f17715b.mo22437s(i2);
            this.f17715b.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: p */
    public synchronized void mo35838p(int i, int i2, List<C6510b> list) throws IOException {
        if (!this.f17719f) {
            this.f17720g.mo35786g(list);
            long S = this.f17717d.mo22398S();
            int min = (int) Math.min((long) (this.f17718e - 4), S);
            long j = (long) min;
            mo35833g(i, min + 4, (byte) 5, S == j ? (byte) 4 : 0);
            this.f17715b.mo22437s(i2 & Integer.MAX_VALUE);
            this.f17715b.mo22370O(this.f17717d, j);
            if (S > j) {
                m25531z(i, S - j);
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: q */
    public synchronized void mo35839q(int i, C6509a aVar) throws IOException {
        if (this.f17719f) {
            throw new IOException("closed");
        } else if (aVar.f17599b != -1) {
            mo35833g(i, 4, (byte) 3, (byte) 0);
            this.f17715b.mo22437s(aVar.f17599b);
            this.f17715b.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: r */
    public synchronized void mo35840r(C6539l lVar) throws IOException {
        if (!this.f17719f) {
            int i = 0;
            mo35833g(0, lVar.mo35859j() * 6, (byte) 4, (byte) 0);
            while (i < 10) {
                if (lVar.mo35856g(i)) {
                    this.f17715b.mo22424o(i == 4 ? 3 : i == 7 ? 4 : i);
                    this.f17715b.mo22437s(lVar.mo35851b(i));
                }
                i++;
            }
            this.f17715b.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: u */
    public synchronized void mo35841u(boolean z, int i, int i2, List<C6510b> list) throws IOException {
        if (!this.f17719f) {
            mo35835k(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: v */
    public synchronized void mo35842v(int i, long j) throws IOException {
        if (this.f17719f) {
            throw new IOException("closed");
        } else if (j == 0 || j > 2147483647L) {
            C6515d.m25437c("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
            throw null;
        } else {
            mo35833g(i, 4, (byte) 8, (byte) 0);
            this.f17715b.mo22437s((int) j);
            this.f17715b.flush();
        }
    }
}
