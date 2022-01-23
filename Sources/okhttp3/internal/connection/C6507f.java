package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
import okhttp3.internal.connection.C6505e;
import p225l.C4379a;
import p225l.C4395e;
import p225l.C4397e0;
import p225l.C4418j;
import p225l.C4424p;
import p225l.C4440x;
import p225l.C6389u;
import p225l.p226g0.C4401a;
import p225l.p226g0.C4402c;
import p225l.p226g0.p228f.C6356c;

/* renamed from: okhttp3.internal.connection.f */
/* compiled from: StreamAllocation */
public final class C6507f {

    /* renamed from: a */
    public final C4379a f17571a;

    /* renamed from: b */
    private C6505e.C6506a f17572b;

    /* renamed from: c */
    private C4397e0 f17573c;

    /* renamed from: d */
    private final C4418j f17574d;

    /* renamed from: e */
    public final C4395e f17575e;

    /* renamed from: f */
    public final C4424p f17576f;

    /* renamed from: g */
    private final Object f17577g;

    /* renamed from: h */
    private final C6505e f17578h;

    /* renamed from: i */
    private int f17579i;

    /* renamed from: j */
    private C4463c f17580j;

    /* renamed from: k */
    private boolean f17581k;

    /* renamed from: l */
    private boolean f17582l;

    /* renamed from: m */
    private boolean f17583m;

    /* renamed from: n */
    private C6356c f17584n;

    /* renamed from: okhttp3.internal.connection.f$a */
    /* compiled from: StreamAllocation */
    public static final class C6508a extends WeakReference<C6507f> {

        /* renamed from: a */
        public final Object f17585a;

        C6508a(C6507f fVar, Object obj) {
            super(fVar);
            this.f17585a = obj;
        }
    }

    public C6507f(C4418j jVar, C4379a aVar, C4395e eVar, C4424p pVar, Object obj) {
        this.f17574d = jVar;
        this.f17571a = aVar;
        this.f17575e = eVar;
        this.f17576f = pVar;
        this.f17578h = new C6505e(aVar, m25393p(), eVar, pVar);
        this.f17577g = obj;
    }

    /* renamed from: e */
    private Socket m25388e(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (z3) {
            this.f17584n = null;
        }
        if (z2) {
            this.f17582l = true;
        }
        C4463c cVar = this.f17580j;
        if (cVar == null) {
            return null;
        }
        if (z) {
            cVar.f12514k = true;
        }
        if (this.f17584n != null) {
            return null;
        }
        if (!this.f17582l && !cVar.f12514k) {
            return null;
        }
        m25391l(cVar);
        if (this.f17580j.f12517n.isEmpty()) {
            this.f17580j.f12518o = System.nanoTime();
            if (C4401a.f12251a.mo22144e(this.f17574d, this.f17580j)) {
                socket = this.f17580j.mo22506r();
                this.f17580j = null;
                return socket;
            }
        }
        socket = null;
        this.f17580j = null;
        return socket;
    }

    /* renamed from: f */
    private C4463c m25389f(int i, int i2, int i3, int i4, boolean z) throws IOException {
        C4463c cVar;
        Socket n;
        C4463c cVar2;
        Socket socket;
        boolean z2;
        C4397e0 e0Var;
        boolean z3;
        C6505e.C6506a aVar;
        synchronized (this.f17574d) {
            if (this.f17582l) {
                throw new IllegalStateException("released");
            } else if (this.f17584n != null) {
                throw new IllegalStateException("codec != null");
            } else if (!this.f17583m) {
                cVar = this.f17580j;
                n = m25392n();
                cVar2 = this.f17580j;
                socket = null;
                if (cVar2 != null) {
                    cVar = null;
                } else {
                    cVar2 = null;
                }
                if (!this.f17581k) {
                    cVar = null;
                }
                if (cVar2 == null) {
                    C4401a.f12251a.mo22147h(this.f17574d, this.f17571a, this, (C4397e0) null);
                    C4463c cVar3 = this.f17580j;
                    if (cVar3 != null) {
                        cVar2 = cVar3;
                        z2 = true;
                        e0Var = null;
                    } else {
                        e0Var = this.f17573c;
                    }
                } else {
                    e0Var = null;
                }
                z2 = false;
            } else {
                throw new IOException("Canceled");
            }
        }
        C4402c.m17187h(n);
        if (cVar != null) {
            this.f17576f.mo22218h(this.f17575e, cVar);
        }
        if (z2) {
            this.f17576f.mo22217g(this.f17575e, cVar2);
        }
        if (cVar2 != null) {
            return cVar2;
        }
        if (e0Var != null || ((aVar = this.f17572b) != null && aVar.mo35761b())) {
            z3 = false;
        } else {
            this.f17572b = this.f17578h.mo35759e();
            z3 = true;
        }
        synchronized (this.f17574d) {
            if (!this.f17583m) {
                if (z3) {
                    List<C4397e0> a = this.f17572b.mo35760a();
                    int size = a.size();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= size) {
                            break;
                        }
                        C4397e0 e0Var2 = a.get(i5);
                        C4401a.f12251a.mo22147h(this.f17574d, this.f17571a, this, e0Var2);
                        C4463c cVar4 = this.f17580j;
                        if (cVar4 != null) {
                            this.f17573c = e0Var2;
                            cVar2 = cVar4;
                            z2 = true;
                            break;
                        }
                        i5++;
                    }
                }
                if (!z2) {
                    if (e0Var == null) {
                        e0Var = this.f17572b.mo35762c();
                    }
                    this.f17573c = e0Var;
                    this.f17579i = 0;
                    cVar2 = new C4463c(this.f17574d, e0Var);
                    mo35763a(cVar2, false);
                }
            } else {
                throw new IOException("Canceled");
            }
        }
        if (z2) {
            this.f17576f.mo22217g(this.f17575e, cVar2);
            return cVar2;
        }
        cVar2.mo22499e(i, i2, i3, i4, z, this.f17575e, this.f17576f);
        m25393p().mo35754a(cVar2.mo22505q());
        synchronized (this.f17574d) {
            this.f17581k = true;
            C4401a.f12251a.mo22148i(this.f17574d, cVar2);
            if (cVar2.mo22503o()) {
                socket = C4401a.f12251a.mo22145f(this.f17574d, this.f17571a, this);
                cVar2 = this.f17580j;
            }
        }
        C4402c.m17187h(socket);
        this.f17576f.mo22217g(this.f17575e, cVar2);
        return cVar2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r0.mo22502n(r9) != false) goto L_0x0018;
     */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private okhttp3.internal.connection.C4463c m25390g(int r4, int r5, int r6, int r7, boolean r8, boolean r9) throws java.io.IOException {
        /*
            r3 = this;
        L_0x0000:
            okhttp3.internal.connection.c r0 = r3.m25389f(r4, r5, r6, r7, r8)
            l.j r1 = r3.f17574d
            monitor-enter(r1)
            int r2 = r0.f12515l     // Catch:{ all -> 0x0019 }
            if (r2 != 0) goto L_0x000d
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            return r0
        L_0x000d:
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            boolean r1 = r0.mo22502n(r9)
            if (r1 != 0) goto L_0x0018
            r3.mo35769j()
            goto L_0x0000
        L_0x0018:
            return r0
        L_0x0019:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            goto L_0x001d
        L_0x001c:
            throw r4
        L_0x001d:
            goto L_0x001c
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.C6507f.m25390g(int, int, int, int, boolean, boolean):okhttp3.internal.connection.c");
    }

    /* renamed from: l */
    private void m25391l(C4463c cVar) {
        int size = cVar.f12517n.size();
        for (int i = 0; i < size; i++) {
            if (cVar.f12517n.get(i).get() == this) {
                cVar.f12517n.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    /* renamed from: n */
    private Socket m25392n() {
        C4463c cVar = this.f17580j;
        if (cVar == null || !cVar.f12514k) {
            return null;
        }
        return m25388e(false, false, true);
    }

    /* renamed from: p */
    private C6504d m25393p() {
        return C4401a.f12251a.mo22149j(this.f17574d);
    }

    /* renamed from: a */
    public void mo35763a(C4463c cVar, boolean z) {
        if (this.f17580j == null) {
            this.f17580j = cVar;
            this.f17581k = z;
            cVar.f12517n.add(new C6508a(this, this.f17577g));
            return;
        }
        throw new IllegalStateException();
    }

    /* renamed from: b */
    public void mo35764b() {
        C6356c cVar;
        C4463c cVar2;
        synchronized (this.f17574d) {
            this.f17583m = true;
            cVar = this.f17584n;
            cVar2 = this.f17580j;
        }
        if (cVar != null) {
            cVar.cancel();
        } else if (cVar2 != null) {
            cVar2.mo22498d();
        }
    }

    /* renamed from: c */
    public C6356c mo35765c() {
        C6356c cVar;
        synchronized (this.f17574d) {
            cVar = this.f17584n;
        }
        return cVar;
    }

    /* renamed from: d */
    public synchronized C4463c mo35766d() {
        return this.f17580j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f17572b;
     */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo35767h() {
        /*
            r1 = this;
            l.e0 r0 = r1.f17573c
            if (r0 != 0) goto L_0x0019
            okhttp3.internal.connection.e$a r0 = r1.f17572b
            if (r0 == 0) goto L_0x000e
            boolean r0 = r0.mo35761b()
            if (r0 != 0) goto L_0x0019
        L_0x000e:
            okhttp3.internal.connection.e r0 = r1.f17578h
            boolean r0 = r0.mo35758c()
            if (r0 == 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r0 = 0
            goto L_0x001a
        L_0x0019:
            r0 = 1
        L_0x001a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.C6507f.mo35767h():boolean");
    }

    /* renamed from: i */
    public C6356c mo35768i(C4440x xVar, C6389u.C4435a aVar, boolean z) {
        try {
            C6356c p = m25390g(aVar.mo22299e(), aVar.mo22295a(), aVar.mo22296b(), xVar.mo22338y(), xVar.mo22317E(), z).mo22504p(xVar, aVar, this);
            synchronized (this.f17574d) {
                this.f17584n = p;
            }
            return p;
        } catch (IOException e) {
            throw new RouteException(e);
        }
    }

    /* renamed from: j */
    public void mo35769j() {
        C4463c cVar;
        Socket e;
        synchronized (this.f17574d) {
            cVar = this.f17580j;
            e = m25388e(true, false, false);
            if (this.f17580j != null) {
                cVar = null;
            }
        }
        C4402c.m17187h(e);
        if (cVar != null) {
            this.f17576f.mo22218h(this.f17575e, cVar);
        }
    }

    /* renamed from: k */
    public void mo35770k() {
        C4463c cVar;
        Socket e;
        synchronized (this.f17574d) {
            cVar = this.f17580j;
            e = m25388e(false, true, false);
            if (this.f17580j != null) {
                cVar = null;
            }
        }
        C4402c.m17187h(e);
        if (cVar != null) {
            C4401a.f12251a.mo22150k(this.f17575e, (IOException) null);
            this.f17576f.mo22218h(this.f17575e, cVar);
            this.f17576f.mo22211a(this.f17575e);
        }
    }

    /* renamed from: m */
    public Socket mo35771m(C4463c cVar) {
        if (this.f17584n == null && this.f17580j.f12517n.size() == 1) {
            Socket e = m25388e(true, false, false);
            this.f17580j = cVar;
            cVar.f12517n.add(this.f17580j.f12517n.get(0));
            return e;
        }
        throw new IllegalStateException();
    }

    /* renamed from: o */
    public C4397e0 mo35772o() {
        return this.f17573c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0051  */
    /* renamed from: q */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo35773q(java.io.IOException r7) {
        /*
            r6 = this;
            l.j r0 = r6.f17574d
            monitor-enter(r0)
            boolean r1 = r7 instanceof okhttp3.internal.http2.StreamResetException     // Catch:{ all -> 0x0065 }
            r2 = 0
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0023
            okhttp3.internal.http2.StreamResetException r7 = (okhttp3.internal.http2.StreamResetException) r7     // Catch:{ all -> 0x0065 }
            okhttp3.internal.http2.a r7 = r7.f17586b     // Catch:{ all -> 0x0065 }
            okhttp3.internal.http2.a r1 = okhttp3.internal.http2.C6509a.REFUSED_STREAM     // Catch:{ all -> 0x0065 }
            if (r7 != r1) goto L_0x001c
            int r7 = r6.f17579i     // Catch:{ all -> 0x0065 }
            int r7 = r7 + r4
            r6.f17579i = r7     // Catch:{ all -> 0x0065 }
            if (r7 <= r4) goto L_0x0046
            r6.f17573c = r3     // Catch:{ all -> 0x0065 }
            goto L_0x0044
        L_0x001c:
            okhttp3.internal.http2.a r1 = okhttp3.internal.http2.C6509a.CANCEL     // Catch:{ all -> 0x0065 }
            if (r7 == r1) goto L_0x0046
            r6.f17573c = r3     // Catch:{ all -> 0x0065 }
            goto L_0x0044
        L_0x0023:
            okhttp3.internal.connection.c r1 = r6.f17580j     // Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0046
            boolean r1 = r1.mo22503o()     // Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0031
            boolean r1 = r7 instanceof okhttp3.internal.http2.ConnectionShutdownException     // Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0046
        L_0x0031:
            okhttp3.internal.connection.c r1 = r6.f17580j     // Catch:{ all -> 0x0065 }
            int r1 = r1.f12515l     // Catch:{ all -> 0x0065 }
            if (r1 != 0) goto L_0x0044
            l.e0 r1 = r6.f17573c     // Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0042
            if (r7 == 0) goto L_0x0042
            okhttp3.internal.connection.e r5 = r6.f17578h     // Catch:{ all -> 0x0065 }
            r5.mo35757a(r1, r7)     // Catch:{ all -> 0x0065 }
        L_0x0042:
            r6.f17573c = r3     // Catch:{ all -> 0x0065 }
        L_0x0044:
            r7 = 1
            goto L_0x0047
        L_0x0046:
            r7 = 0
        L_0x0047:
            okhttp3.internal.connection.c r1 = r6.f17580j     // Catch:{ all -> 0x0065 }
            java.net.Socket r7 = r6.m25388e(r7, r2, r4)     // Catch:{ all -> 0x0065 }
            okhttp3.internal.connection.c r2 = r6.f17580j     // Catch:{ all -> 0x0065 }
            if (r2 != 0) goto L_0x0057
            boolean r2 = r6.f17581k     // Catch:{ all -> 0x0065 }
            if (r2 != 0) goto L_0x0056
            goto L_0x0057
        L_0x0056:
            r3 = r1
        L_0x0057:
            monitor-exit(r0)     // Catch:{ all -> 0x0065 }
            p225l.p226g0.C4402c.m17187h(r7)
            if (r3 == 0) goto L_0x0064
            l.p r7 = r6.f17576f
            l.e r0 = r6.f17575e
            r7.mo22218h(r0, r3)
        L_0x0064:
            return
        L_0x0065:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0065 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.C6507f.mo35773q(java.io.IOException):void");
    }

    /* renamed from: r */
    public void mo35774r(boolean z, C6356c cVar, long j, IOException iOException) {
        C4463c cVar2;
        Socket e;
        boolean z2;
        this.f17576f.mo22225p(this.f17575e, j);
        synchronized (this.f17574d) {
            if (cVar != null) {
                if (cVar == this.f17584n) {
                    if (!z) {
                        this.f17580j.f12515l++;
                    }
                    cVar2 = this.f17580j;
                    e = m25388e(z, false, true);
                    if (this.f17580j != null) {
                        cVar2 = null;
                    }
                    z2 = this.f17582l;
                }
            }
            throw new IllegalStateException("expected " + this.f17584n + " but was " + cVar);
        }
        C4402c.m17187h(e);
        if (cVar2 != null) {
            this.f17576f.mo22218h(this.f17575e, cVar2);
        }
        if (iOException != null) {
            this.f17576f.mo22212b(this.f17575e, C4401a.f12251a.mo22150k(this.f17575e, iOException));
        } else if (z2) {
            C4401a.f12251a.mo22150k(this.f17575e, (IOException) null);
            this.f17576f.mo22211a(this.f17575e);
        }
    }

    public String toString() {
        C4463c d = mo35766d();
        return d != null ? d.toString() : this.f17571a.toString();
    }
}
