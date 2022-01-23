package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.C6512c;
import p225l.p226g0.C4402c;
import p230m.C4450c;
import p230m.C4454e;
import p230m.C4455f;
import p230m.C4460s;
import p230m.C4461t;

/* renamed from: okhttp3.internal.http2.g */
/* compiled from: Http2Reader */
final class C6531g implements Closeable {

    /* renamed from: f */
    static final Logger f17703f = Logger.getLogger(C6515d.class.getName());

    /* renamed from: b */
    private final C4454e f17704b;

    /* renamed from: c */
    private final C6532a f17705c;

    /* renamed from: d */
    private final boolean f17706d;

    /* renamed from: e */
    final C6512c.C6513a f17707e;

    /* renamed from: okhttp3.internal.http2.g$a */
    /* compiled from: Http2Reader */
    static final class C6532a implements C4460s {

        /* renamed from: b */
        private final C4454e f17708b;

        /* renamed from: c */
        int f17709c;

        /* renamed from: d */
        byte f17710d;

        /* renamed from: e */
        int f17711e;

        /* renamed from: f */
        int f17712f;

        /* renamed from: g */
        short f17713g;

        C6532a(C4454e eVar) {
            this.f17708b = eVar;
        }

        /* renamed from: a */
        private void m25517a() throws IOException {
            int i = this.f17711e;
            int m = C6531g.m25507m(this.f17708b);
            this.f17712f = m;
            this.f17709c = m;
            byte readByte = (byte) (this.f17708b.readByte() & 255);
            this.f17710d = (byte) (this.f17708b.readByte() & 255);
            Logger logger = C6531g.f17703f;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(C6515d.m25436b(true, this.f17711e, this.f17709c, readByte, this.f17710d));
            }
            int readInt = this.f17708b.readInt() & Integer.MAX_VALUE;
            this.f17711e = readInt;
            if (readByte != 9) {
                C6515d.m25438d("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
                throw null;
            } else if (readInt != i) {
                C6515d.m25438d("TYPE_CONTINUATION streamId changed", new Object[0]);
                throw null;
            }
        }

        public void close() throws IOException {
        }

        /* renamed from: e */
        public C4461t mo22376e() {
            return this.f17708b.mo22376e();
        }

        /* renamed from: n0 */
        public long mo22377n0(C4450c cVar, long j) throws IOException {
            while (true) {
                int i = this.f17712f;
                if (i == 0) {
                    this.f17708b.skip((long) this.f17713g);
                    this.f17713g = 0;
                    if ((this.f17710d & 4) != 0) {
                        return -1;
                    }
                    m25517a();
                } else {
                    long n0 = this.f17708b.mo22377n0(cVar, Math.min(j, (long) i));
                    if (n0 == -1) {
                        return -1;
                    }
                    this.f17712f = (int) (((long) this.f17712f) - n0);
                    return n0;
                }
            }
        }
    }

    /* renamed from: okhttp3.internal.http2.g$b */
    /* compiled from: Http2Reader */
    interface C6533b {
        /* renamed from: a */
        void mo35814a();

        /* renamed from: b */
        void mo35815b(boolean z, C6539l lVar);

        /* renamed from: c */
        void mo35816c(boolean z, int i, int i2, List<C6510b> list);

        /* renamed from: d */
        void mo35817d(int i, long j);

        /* renamed from: e */
        void mo35818e(boolean z, int i, C4454e eVar, int i2) throws IOException;

        /* renamed from: f */
        void mo35819f(boolean z, int i, int i2);

        /* renamed from: g */
        void mo35820g(int i, int i2, int i3, boolean z);

        /* renamed from: h */
        void mo35821h(int i, C6509a aVar);

        /* renamed from: i */
        void mo35822i(int i, int i2, List<C6510b> list) throws IOException;

        /* renamed from: j */
        void mo35823j(int i, C6509a aVar, C4455f fVar);
    }

    C6531g(C4454e eVar, boolean z) {
        this.f17704b = eVar;
        this.f17706d = z;
        C6532a aVar = new C6532a(eVar);
        this.f17705c = aVar;
        this.f17707e = new C6512c.C6513a(4096, aVar);
    }

    /* renamed from: a */
    static int m25502a(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        C6515d.m25438d("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
        throw null;
    }

    /* renamed from: f */
    private void m25503f(C6533b bVar, int i, byte b, int i2) throws IOException {
        short s = 0;
        if (i2 != 0) {
            boolean z = true;
            boolean z2 = (b & 1) != 0;
            if ((b & 32) == 0) {
                z = false;
            }
            if (!z) {
                if ((b & 8) != 0) {
                    s = (short) (this.f17704b.readByte() & 255);
                }
                bVar.mo35818e(z2, i2, this.f17704b, m25502a(i, b, s));
                this.f17704b.skip((long) s);
                return;
            }
            C6515d.m25438d("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            throw null;
        }
        C6515d.m25438d("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        throw null;
    }

    /* renamed from: g */
    private void m25504g(C6533b bVar, int i, byte b, int i2) throws IOException {
        if (i < 8) {
            C6515d.m25438d("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
            throw null;
        } else if (i2 == 0) {
            int readInt = this.f17704b.readInt();
            int readInt2 = this.f17704b.readInt();
            int i3 = i - 8;
            C6509a a = C6509a.m25406a(readInt2);
            if (a != null) {
                C4455f fVar = C4455f.f12487f;
                if (i3 > 0) {
                    fVar = this.f17704b.mo22420l((long) i3);
                }
                bVar.mo35823j(readInt, a, fVar);
                return;
            }
            C6515d.m25438d("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
            throw null;
        } else {
            C6515d.m25438d("TYPE_GOAWAY streamId != 0", new Object[0]);
            throw null;
        }
    }

    /* renamed from: j */
    private List<C6510b> m25505j(int i, short s, byte b, int i2) throws IOException {
        C6532a aVar = this.f17705c;
        aVar.f17712f = i;
        aVar.f17709c = i;
        aVar.f17713g = s;
        aVar.f17710d = b;
        aVar.f17711e = i2;
        this.f17707e.mo35782k();
        return this.f17707e.mo35780e();
    }

    /* renamed from: k */
    private void m25506k(C6533b bVar, int i, byte b, int i2) throws IOException {
        short s = 0;
        if (i2 != 0) {
            boolean z = (b & 1) != 0;
            if ((b & 8) != 0) {
                s = (short) (this.f17704b.readByte() & 255);
            }
            if ((b & 32) != 0) {
                m25509p(bVar, i2);
                i -= 5;
            }
            bVar.mo35816c(z, i2, -1, m25505j(m25502a(i, b, s), s, b, i2));
            return;
        }
        C6515d.m25438d("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        throw null;
    }

    /* renamed from: m */
    static int m25507m(C4454e eVar) throws IOException {
        return (eVar.readByte() & 255) | ((eVar.readByte() & 255) << 16) | ((eVar.readByte() & 255) << 8);
    }

    /* renamed from: n */
    private void m25508n(C6533b bVar, int i, byte b, int i2) throws IOException {
        boolean z = false;
        if (i != 8) {
            C6515d.m25438d("TYPE_PING length != 8: %s", Integer.valueOf(i));
            throw null;
        } else if (i2 == 0) {
            int readInt = this.f17704b.readInt();
            int readInt2 = this.f17704b.readInt();
            if ((b & 1) != 0) {
                z = true;
            }
            bVar.mo35819f(z, readInt, readInt2);
        } else {
            C6515d.m25438d("TYPE_PING streamId != 0", new Object[0]);
            throw null;
        }
    }

    /* renamed from: p */
    private void m25509p(C6533b bVar, int i) throws IOException {
        int readInt = this.f17704b.readInt();
        bVar.mo35820g(i, readInt & Integer.MAX_VALUE, (this.f17704b.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    /* renamed from: q */
    private void m25510q(C6533b bVar, int i, byte b, int i2) throws IOException {
        if (i != 5) {
            C6515d.m25438d("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
            throw null;
        } else if (i2 != 0) {
            m25509p(bVar, i2);
        } else {
            C6515d.m25438d("TYPE_PRIORITY streamId == 0", new Object[0]);
            throw null;
        }
    }

    /* renamed from: r */
    private void m25511r(C6533b bVar, int i, byte b, int i2) throws IOException {
        short s = 0;
        if (i2 != 0) {
            if ((b & 8) != 0) {
                s = (short) (this.f17704b.readByte() & 255);
            }
            bVar.mo35822i(i2, this.f17704b.readInt() & Integer.MAX_VALUE, m25505j(m25502a(i - 4, b, s), s, b, i2));
            return;
        }
        C6515d.m25438d("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        throw null;
    }

    /* renamed from: u */
    private void m25512u(C6533b bVar, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            C6515d.m25438d("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
            throw null;
        } else if (i2 != 0) {
            int readInt = this.f17704b.readInt();
            C6509a a = C6509a.m25406a(readInt);
            if (a != null) {
                bVar.mo35821h(i2, a);
                return;
            }
            C6515d.m25438d("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
            throw null;
        } else {
            C6515d.m25438d("TYPE_RST_STREAM streamId == 0", new Object[0]);
            throw null;
        }
    }

    /* renamed from: v */
    private void m25513v(C6533b bVar, int i, byte b, int i2) throws IOException {
        if (i2 != 0) {
            C6515d.m25438d("TYPE_SETTINGS streamId != 0", new Object[0]);
            throw null;
        } else if ((b & 1) != 0) {
            if (i == 0) {
                bVar.mo35814a();
            } else {
                C6515d.m25438d("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                throw null;
            }
        } else if (i % 6 == 0) {
            C6539l lVar = new C6539l();
            for (int i3 = 0; i3 < i; i3 += 6) {
                short readShort = this.f17704b.readShort() & 65535;
                int readInt = this.f17704b.readInt();
                if (readShort != 2) {
                    if (readShort == 3) {
                        readShort = 4;
                    } else if (readShort == 4) {
                        readShort = 7;
                        if (readInt < 0) {
                            C6515d.m25438d("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                            throw null;
                        }
                    } else if (readShort == 5 && (readInt < 16384 || readInt > 16777215)) {
                        C6515d.m25438d("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                        throw null;
                    }
                } else if (!(readInt == 0 || readInt == 1)) {
                    C6515d.m25438d("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                    throw null;
                }
                lVar.mo35858i(readShort, readInt);
            }
            bVar.mo35815b(false, lVar);
        } else {
            C6515d.m25438d("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
            throw null;
        }
    }

    /* renamed from: z */
    private void m25514z(C6533b bVar, int i, byte b, int i2) throws IOException {
        if (i == 4) {
            long readInt = ((long) this.f17704b.readInt()) & 2147483647L;
            if (readInt != 0) {
                bVar.mo35817d(i2, readInt);
                return;
            }
            C6515d.m25438d("windowSizeIncrement was 0", Long.valueOf(readInt));
            throw null;
        }
        C6515d.m25438d("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        throw null;
    }

    /* renamed from: b */
    public boolean mo35824b(boolean z, C6533b bVar) throws IOException {
        try {
            this.f17704b.mo22448x0(9);
            int m = m25507m(this.f17704b);
            if (m < 0 || m > 16384) {
                C6515d.m25438d("FRAME_SIZE_ERROR: %s", Integer.valueOf(m));
                throw null;
            }
            byte readByte = (byte) (this.f17704b.readByte() & 255);
            if (!z || readByte == 4) {
                byte readByte2 = (byte) (this.f17704b.readByte() & 255);
                int readInt = this.f17704b.readInt() & Integer.MAX_VALUE;
                Logger logger = f17703f;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(C6515d.m25436b(true, readInt, m, readByte, readByte2));
                }
                switch (readByte) {
                    case 0:
                        m25503f(bVar, m, readByte2, readInt);
                        break;
                    case 1:
                        m25506k(bVar, m, readByte2, readInt);
                        break;
                    case 2:
                        m25510q(bVar, m, readByte2, readInt);
                        break;
                    case 3:
                        m25512u(bVar, m, readByte2, readInt);
                        break;
                    case 4:
                        m25513v(bVar, m, readByte2, readInt);
                        break;
                    case 5:
                        m25511r(bVar, m, readByte2, readInt);
                        break;
                    case 6:
                        m25508n(bVar, m, readByte2, readInt);
                        break;
                    case 7:
                        m25504g(bVar, m, readByte2, readInt);
                        break;
                    case 8:
                        m25514z(bVar, m, readByte2, readInt);
                        break;
                    default:
                        this.f17704b.skip((long) m);
                        break;
                }
                return true;
            }
            C6515d.m25438d("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
            throw null;
        } catch (IOException unused) {
            return false;
        }
    }

    public void close() throws IOException {
        this.f17704b.close();
    }

    /* renamed from: d */
    public void mo35826d(C6533b bVar) throws IOException {
        if (!this.f17706d) {
            C4454e eVar = this.f17704b;
            C4455f fVar = C6515d.f17628a;
            C4455f l = eVar.mo22420l((long) fVar.size());
            Logger logger = f17703f;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(C4402c.m17197r("<< CONNECTION %s", l.mo22469l()));
            }
            if (!fVar.equals(l)) {
                C6515d.m25438d("Expected a connection header but was %s", l.mo22480y());
                throw null;
            }
        } else if (!mo35824b(true, bVar)) {
            C6515d.m25438d("Required SETTINGS preface not received", new Object[0]);
            throw null;
        }
    }
}
