package okhttp3.internal.http2;

import p225l.C4431s;
import p225l.p226g0.C4402c;
import p230m.C4455f;

/* renamed from: okhttp3.internal.http2.b */
/* compiled from: Header */
public final class C6510b {

    /* renamed from: d */
    public static final C4455f f17600d = C4455f.m17622i(":");

    /* renamed from: e */
    public static final C4455f f17601e = C4455f.m17622i(":status");

    /* renamed from: f */
    public static final C4455f f17602f = C4455f.m17622i(":method");

    /* renamed from: g */
    public static final C4455f f17603g = C4455f.m17622i(":path");

    /* renamed from: h */
    public static final C4455f f17604h = C4455f.m17622i(":scheme");

    /* renamed from: i */
    public static final C4455f f17605i = C4455f.m17622i(":authority");

    /* renamed from: a */
    public final C4455f f17606a;

    /* renamed from: b */
    public final C4455f f17607b;

    /* renamed from: c */
    final int f17608c;

    /* renamed from: okhttp3.internal.http2.b$a */
    /* compiled from: Header */
    interface C6511a {
        /* renamed from: a */
        void mo35779a(C4431s sVar);
    }

    public C6510b(String str, String str2) {
        this(C4455f.m17622i(str), C4455f.m17622i(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C6510b)) {
            return false;
        }
        C6510b bVar = (C6510b) obj;
        if (!this.f17606a.equals(bVar.f17606a) || !this.f17607b.equals(bVar.f17607b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((527 + this.f17606a.hashCode()) * 31) + this.f17607b.hashCode();
    }

    public String toString() {
        return C4402c.m17197r("%s: %s", this.f17606a.mo22480y(), this.f17607b.mo22480y());
    }

    public C6510b(C4455f fVar, String str) {
        this(fVar, C4455f.m17622i(str));
    }

    public C6510b(C4455f fVar, C4455f fVar2) {
        this.f17606a = fVar;
        this.f17607b = fVar2;
        this.f17608c = fVar.size() + 32 + fVar2.size();
    }
}
