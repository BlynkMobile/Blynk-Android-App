package okhttp3.internal.connection;

import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.http2.C4466h;
import okhttp3.internal.http2.C6509a;
import okhttp3.internal.http2.C6516e;
import okhttp3.internal.http2.C6518f;
import p057ch.qos.logback.core.CoreConstants;
import p225l.C4379a;
import p225l.C4380a0;
import p225l.C4384b0;
import p225l.C4388c0;
import p225l.C4395e;
import p225l.C4397e0;
import p225l.C4417i;
import p225l.C4418j;
import p225l.C4424p;
import p225l.C4430r;
import p225l.C4433t;
import p225l.C4440x;
import p225l.C6389u;
import p225l.C6390y;
import p225l.p226g0.C4401a;
import p225l.p226g0.C4402c;
import p225l.p226g0.C6348d;
import p225l.p226g0.p228f.C6356c;
import p225l.p226g0.p228f.C6359e;
import p225l.p226g0.p229h.C4416f;
import p225l.p226g0.p346g.C6365a;
import p225l.p226g0.p348j.C6378d;
import p230m.C4453d;
import p230m.C4454e;
import p230m.C4460s;
import p230m.C6397l;

/* renamed from: okhttp3.internal.connection.c */
/* compiled from: RealConnection */
public final class C4463c extends C6518f.C4464h implements C4417i {

    /* renamed from: b */
    private final C4418j f12505b;

    /* renamed from: c */
    private final C4397e0 f12506c;

    /* renamed from: d */
    private Socket f12507d;

    /* renamed from: e */
    private Socket f12508e;

    /* renamed from: f */
    private C4430r f12509f;

    /* renamed from: g */
    private C6390y f12510g;

    /* renamed from: h */
    private C6518f f12511h;

    /* renamed from: i */
    private C4454e f12512i;

    /* renamed from: j */
    private C4453d f12513j;

    /* renamed from: k */
    public boolean f12514k;

    /* renamed from: l */
    public int f12515l;

    /* renamed from: m */
    public int f12516m = 1;

    /* renamed from: n */
    public final List<Reference<C6507f>> f12517n = new ArrayList();

    /* renamed from: o */
    public long f12518o = Long.MAX_VALUE;

    public C4463c(C4418j jVar, C4397e0 e0Var) {
        this.f12505b = jVar;
        this.f12506c = e0Var;
    }

    /* renamed from: f */
    private void m17665f(int i, int i2, C4395e eVar, C4424p pVar) throws IOException {
        Socket socket;
        Proxy b = this.f12506c.mo22123b();
        C4379a a = this.f12506c.mo22122a();
        if (b.type() == Proxy.Type.DIRECT || b.type() == Proxy.Type.HTTP) {
            socket = a.mo22037j().createSocket();
        } else {
            socket = new Socket(b);
        }
        this.f12507d = socket;
        pVar.mo22216f(eVar, this.f12506c.mo22125d(), b);
        this.f12507d.setSoTimeout(i2);
        try {
            C4416f.m17252j().mo22158h(this.f12507d, this.f12506c.mo22125d(), i);
            try {
                this.f12512i = C6397l.m24926b(C6397l.m24933i(this.f12507d));
                this.f12513j = C6397l.m24925a(C6397l.m24929e(this.f12507d));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f12506c.mo22125d());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.net.Socket, javax.net.ssl.SSLSocket] */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x010f A[Catch:{ all -> 0x0106 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0115 A[Catch:{ all -> 0x0106 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0118  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m17666g(okhttp3.internal.connection.C6503b r8) throws java.io.IOException {
        /*
            r7 = this;
            l.e0 r0 = r7.f12506c
            l.a r0 = r0.mo22122a()
            javax.net.ssl.SSLSocketFactory r1 = r0.mo22038k()
            r2 = 0
            java.net.Socket r3 = r7.f12507d     // Catch:{ AssertionError -> 0x0108 }
            l.t r4 = r0.mo22039l()     // Catch:{ AssertionError -> 0x0108 }
            java.lang.String r4 = r4.mo22274m()     // Catch:{ AssertionError -> 0x0108 }
            l.t r5 = r0.mo22039l()     // Catch:{ AssertionError -> 0x0108 }
            int r5 = r5.mo22280z()     // Catch:{ AssertionError -> 0x0108 }
            r6 = 1
            java.net.Socket r1 = r1.createSocket(r3, r4, r5, r6)     // Catch:{ AssertionError -> 0x0108 }
            javax.net.ssl.SSLSocket r1 = (javax.net.ssl.SSLSocket) r1     // Catch:{ AssertionError -> 0x0108 }
            l.k r8 = r8.mo35752a(r1)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            boolean r3 = r8.mo22189f()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            if (r3 == 0) goto L_0x0041
            l.g0.h.f r3 = p225l.p226g0.p229h.C4416f.m17252j()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            l.t r4 = r0.mo22039l()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r4 = r4.mo22274m()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.util.List r5 = r0.mo22032f()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r3.mo22157g(r1, r4, r5)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
        L_0x0041:
            r1.startHandshake()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            javax.net.ssl.SSLSession r3 = r1.getSession()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            l.r r4 = p225l.C4430r.m17340b(r3)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            javax.net.ssl.HostnameVerifier r5 = r0.mo22030e()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            l.t r6 = r0.mo22039l()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r6 = r6.mo22274m()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            boolean r3 = r5.verify(r6, r3)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            if (r3 == 0) goto L_0x00ae
            l.g r3 = r0.mo22026a()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            l.t r0 = r0.mo22039l()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r0 = r0.mo22274m()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.util.List r5 = r4.mo22240c()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r3.mo22129a(r0, r5)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            boolean r8 = r8.mo22189f()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            if (r8 == 0) goto L_0x007f
            l.g0.h.f r8 = p225l.p226g0.p229h.C4416f.m17252j()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r2 = r8.mo22160l(r1)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
        L_0x007f:
            r7.f12508e = r1     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            m.s r8 = p230m.C6397l.m24933i(r1)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            m.e r8 = p230m.C6397l.m24926b(r8)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r7.f12512i = r8     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.net.Socket r8 = r7.f12508e     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            m.r r8 = p230m.C6397l.m24929e(r8)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            m.d r8 = p230m.C6397l.m24925a(r8)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r7.f12513j = r8     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r7.f12509f = r4     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            if (r2 == 0) goto L_0x00a0
            l.y r8 = p225l.C6390y.m24897a(r2)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            goto L_0x00a2
        L_0x00a0:
            l.y r8 = p225l.C6390y.HTTP_1_1     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
        L_0x00a2:
            r7.f12510g = r8     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            if (r1 == 0) goto L_0x00ad
            l.g0.h.f r8 = p225l.p226g0.p229h.C4416f.m17252j()
            r8.mo22174a(r1)
        L_0x00ad:
            return
        L_0x00ae:
            java.util.List r8 = r4.mo22240c()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r2 = 0
            java.lang.Object r8 = r8.get(r2)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.security.cert.X509Certificate r8 = (java.security.cert.X509Certificate) r8     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            javax.net.ssl.SSLPeerUnverifiedException r2 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r3.<init>()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r4 = "Hostname "
            r3.append(r4)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            l.t r0 = r0.mo22039l()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r0 = r0.mo22274m()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r3.append(r0)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r0 = " not verified:\n    certificate: "
            r3.append(r0)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r0 = p225l.C4398g.m17150c(r8)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r3.append(r0)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r0 = "\n    DN: "
            r3.append(r0)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.security.Principal r0 = r8.getSubjectDN()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r0 = r0.getName()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r3.append(r0)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r0 = "\n    subjectAltNames: "
            r3.append(r0)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.util.List r8 = p225l.p226g0.p348j.C6378d.m24873a(r8)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r3.append(r8)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r8 = r3.toString()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r2.<init>(r8)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            throw r2     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
        L_0x0100:
            r8 = move-exception
            r2 = r1
            goto L_0x0116
        L_0x0103:
            r8 = move-exception
            r2 = r1
            goto L_0x0109
        L_0x0106:
            r8 = move-exception
            goto L_0x0116
        L_0x0108:
            r8 = move-exception
        L_0x0109:
            boolean r0 = p225l.p226g0.C4402c.m17170A(r8)     // Catch:{ all -> 0x0106 }
            if (r0 == 0) goto L_0x0115
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0106 }
            r0.<init>(r8)     // Catch:{ all -> 0x0106 }
            throw r0     // Catch:{ all -> 0x0106 }
        L_0x0115:
            throw r8     // Catch:{ all -> 0x0106 }
        L_0x0116:
            if (r2 == 0) goto L_0x011f
            l.g0.h.f r0 = p225l.p226g0.p229h.C4416f.m17252j()
            r0.mo22174a(r2)
        L_0x011f:
            p225l.p226g0.C4402c.m17187h(r2)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.C4463c.m17666g(okhttp3.internal.connection.b):void");
    }

    /* renamed from: h */
    private void m17667h(int i, int i2, int i3, C4395e eVar, C4424p pVar) throws IOException {
        C4380a0 j = m17669j();
        C4433t h = j.mo22048h();
        int i4 = 0;
        while (i4 < 21) {
            m17665f(i, i2, eVar, pVar);
            j = m17668i(i2, i3, j, h);
            if (j != null) {
                C4402c.m17187h(this.f12507d);
                this.f12507d = null;
                this.f12513j = null;
                this.f12512i = null;
                pVar.mo22214d(eVar, this.f12506c.mo22125d(), this.f12506c.mo22123b(), (C6390y) null);
                i4++;
            } else {
                return;
            }
        }
    }

    /* renamed from: i */
    private C4380a0 m17668i(int i, int i2, C4380a0 a0Var, C4433t tVar) throws IOException {
        String str = "CONNECT " + C4402c.m17198s(tVar, true) + " HTTP/1.1";
        while (true) {
            C4454e eVar = this.f12512i;
            C6365a aVar = new C6365a((C4440x) null, (C6507f) null, eVar, this.f12513j);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            eVar.mo22376e().mo22494g((long) i, timeUnit);
            this.f12513j.mo22372e().mo22494g((long) i2, timeUnit);
            aVar.mo35588o(a0Var.mo22044d(), str);
            aVar.mo35563a();
            C4388c0.C4389a d = aVar.mo35567d(false);
            d.mo22092p(a0Var);
            C4388c0 c = d.mo22081c();
            long b = C6359e.m24798b(c);
            if (b == -1) {
                b = 0;
            }
            C4460s k = aVar.mo35585k(b);
            C4402c.m17173D(k, Integer.MAX_VALUE, timeUnit);
            k.close();
            int d2 = c.mo22066d();
            if (d2 != 200) {
                if (d2 == 407) {
                    C4380a0 a = this.f12506c.mo22122a().mo22034h().mo22059a(this.f12506c, c);
                    if (a == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    } else if ("close".equalsIgnoreCase(c.mo22068g("Connection"))) {
                        return a;
                    } else {
                        a0Var = a;
                    }
                } else {
                    throw new IOException("Unexpected response code for CONNECT: " + c.mo22066d());
                }
            } else if (this.f12512i.mo22407c().mo22447x() && this.f12513j.mo22407c().mo22447x()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    /* renamed from: j */
    private C4380a0 m17669j() throws IOException {
        C4380a0.C4381a aVar = new C4380a0.C4381a();
        aVar.mo22058i(this.f12506c.mo22122a().mo22039l());
        aVar.mo22055f("CONNECT", (C4384b0) null);
        aVar.mo22053d("Host", C4402c.m17198s(this.f12506c.mo22122a().mo22039l(), true));
        aVar.mo22053d("Proxy-Connection", "Keep-Alive");
        aVar.mo22053d(AbstractSpiCall.HEADER_USER_AGENT, C6348d.m24767a());
        C4380a0 b = aVar.mo22051b();
        C4388c0.C4389a aVar2 = new C4388c0.C4389a();
        aVar2.mo22092p(b);
        aVar2.mo22090n(C6390y.HTTP_1_1);
        aVar2.mo22083g(407);
        aVar2.mo22087k("Preemptive Authenticate");
        aVar2.mo22080b(C4402c.f12254c);
        aVar2.mo22093q(-1);
        aVar2.mo22091o(-1);
        aVar2.mo22085i("Proxy-Authenticate", "OkHttp-Preemptive");
        C4380a0 a = this.f12506c.mo22122a().mo22034h().mo22059a(this.f12506c, aVar2.mo22081c());
        return a != null ? a : b;
    }

    /* renamed from: k */
    private void m17670k(C6503b bVar, int i, C4395e eVar, C4424p pVar) throws IOException {
        if (this.f12506c.mo22122a().mo22038k() == null) {
            List<C6390y> f = this.f12506c.mo22122a().mo22032f();
            C6390y yVar = C6390y.H2_PRIOR_KNOWLEDGE;
            if (f.contains(yVar)) {
                this.f12508e = this.f12507d;
                this.f12510g = yVar;
                m17671s(i);
                return;
            }
            this.f12508e = this.f12507d;
            this.f12510g = C6390y.HTTP_1_1;
            return;
        }
        pVar.mo22230u(eVar);
        m17666g(bVar);
        pVar.mo22229t(eVar, this.f12509f);
        if (this.f12510g == C6390y.HTTP_2) {
            m17671s(i);
        }
    }

    /* renamed from: s */
    private void m17671s(int i) throws IOException {
        this.f12508e.setSoTimeout(0);
        C6518f.C6525g gVar = new C6518f.C6525g(true);
        gVar.mo35813d(this.f12508e, this.f12506c.mo22122a().mo22039l().mo22274m(), this.f12512i, this.f12513j);
        gVar.mo35811b(this);
        gVar.mo35812c(i);
        C6518f a = gVar.mo35810a();
        this.f12511h = a;
        a.mo35792H();
    }

    /* renamed from: a */
    public C6390y mo22177a() {
        return this.f12510g;
    }

    /* renamed from: b */
    public void mo22496b(C6518f fVar) {
        synchronized (this.f12505b) {
            this.f12516m = fVar.mo35805n();
        }
    }

    /* renamed from: c */
    public void mo22497c(C4466h hVar) throws IOException {
        hVar.mo22512f(C6509a.REFUSED_STREAM);
    }

    /* renamed from: d */
    public void mo22498d() {
        C4402c.m17187h(this.f12507d);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0090 A[Catch:{ IOException -> 0x00f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0135  */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo22499e(int r17, int r18, int r19, int r20, boolean r21, p225l.C4395e r22, p225l.C4424p r23) {
        /*
            r16 = this;
            r7 = r16
            r8 = r22
            r9 = r23
            l.y r0 = r7.f12510g
            if (r0 != 0) goto L_0x0150
            l.e0 r0 = r7.f12506c
            l.a r0 = r0.mo22122a()
            java.util.List r0 = r0.mo22027b()
            okhttp3.internal.connection.b r10 = new okhttp3.internal.connection.b
            r10.<init>(r0)
            l.e0 r1 = r7.f12506c
            l.a r1 = r1.mo22122a()
            javax.net.ssl.SSLSocketFactory r1 = r1.mo22038k()
            if (r1 != 0) goto L_0x0074
            l.k r1 = p225l.C4420k.f12323h
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0067
            l.e0 r0 = r7.f12506c
            l.a r0 = r0.mo22122a()
            l.t r0 = r0.mo22039l()
            java.lang.String r0 = r0.mo22274m()
            l.g0.h.f r1 = p225l.p226g0.p229h.C4416f.m17252j()
            boolean r1 = r1.mo22162n(r0)
            if (r1 == 0) goto L_0x0046
            goto L_0x0086
        L_0x0046:
            okhttp3.internal.connection.RouteException r1 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r2 = new java.net.UnknownServiceException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "CLEARTEXT communication to "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = " not permitted by network security policy"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            r1.<init>(r2)
            throw r1
        L_0x0067:
            okhttp3.internal.connection.RouteException r0 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
            java.lang.String r2 = "CLEARTEXT communication not enabled for client"
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x0074:
            l.e0 r0 = r7.f12506c
            l.a r0 = r0.mo22122a()
            java.util.List r0 = r0.mo22032f()
            l.y r1 = p225l.C6390y.H2_PRIOR_KNOWLEDGE
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L_0x0143
        L_0x0086:
            r11 = 0
            r12 = r11
        L_0x0088:
            l.e0 r0 = r7.f12506c     // Catch:{ IOException -> 0x00f9 }
            boolean r0 = r0.mo22124c()     // Catch:{ IOException -> 0x00f9 }
            if (r0 == 0) goto L_0x00a9
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r22
            r6 = r23
            r1.m17667h(r2, r3, r4, r5, r6)     // Catch:{ IOException -> 0x00f9 }
            java.net.Socket r0 = r7.f12507d     // Catch:{ IOException -> 0x00f9 }
            if (r0 != 0) goto L_0x00a4
            goto L_0x00c6
        L_0x00a4:
            r13 = r17
            r14 = r18
            goto L_0x00b0
        L_0x00a9:
            r13 = r17
            r14 = r18
            r7.m17665f(r13, r14, r8, r9)     // Catch:{ IOException -> 0x00f7 }
        L_0x00b0:
            r15 = r20
            r7.m17670k(r10, r15, r8, r9)     // Catch:{ IOException -> 0x00f5 }
            l.e0 r0 = r7.f12506c     // Catch:{ IOException -> 0x00f5 }
            java.net.InetSocketAddress r0 = r0.mo22125d()     // Catch:{ IOException -> 0x00f5 }
            l.e0 r1 = r7.f12506c     // Catch:{ IOException -> 0x00f5 }
            java.net.Proxy r1 = r1.mo22123b()     // Catch:{ IOException -> 0x00f5 }
            l.y r2 = r7.f12510g     // Catch:{ IOException -> 0x00f5 }
            r9.mo22214d(r8, r0, r1, r2)     // Catch:{ IOException -> 0x00f5 }
        L_0x00c6:
            l.e0 r0 = r7.f12506c
            boolean r0 = r0.mo22124c()
            if (r0 == 0) goto L_0x00e0
            java.net.Socket r0 = r7.f12507d
            if (r0 == 0) goto L_0x00d3
            goto L_0x00e0
        L_0x00d3:
            java.net.ProtocolException r0 = new java.net.ProtocolException
            java.lang.String r1 = "Too many tunnel connections attempted: 21"
            r0.<init>(r1)
            okhttp3.internal.connection.RouteException r1 = new okhttp3.internal.connection.RouteException
            r1.<init>(r0)
            throw r1
        L_0x00e0:
            okhttp3.internal.http2.f r0 = r7.f12511h
            if (r0 == 0) goto L_0x00f4
            l.j r1 = r7.f12505b
            monitor-enter(r1)
            okhttp3.internal.http2.f r0 = r7.f12511h     // Catch:{ all -> 0x00f1 }
            int r0 = r0.mo35805n()     // Catch:{ all -> 0x00f1 }
            r7.f12516m = r0     // Catch:{ all -> 0x00f1 }
            monitor-exit(r1)     // Catch:{ all -> 0x00f1 }
            goto L_0x00f4
        L_0x00f1:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00f1 }
            throw r0
        L_0x00f4:
            return
        L_0x00f5:
            r0 = move-exception
            goto L_0x0100
        L_0x00f7:
            r0 = move-exception
            goto L_0x00fe
        L_0x00f9:
            r0 = move-exception
            r13 = r17
            r14 = r18
        L_0x00fe:
            r15 = r20
        L_0x0100:
            java.net.Socket r1 = r7.f12508e
            p225l.p226g0.C4402c.m17187h(r1)
            java.net.Socket r1 = r7.f12507d
            p225l.p226g0.C4402c.m17187h(r1)
            r7.f12508e = r11
            r7.f12507d = r11
            r7.f12512i = r11
            r7.f12513j = r11
            r7.f12509f = r11
            r7.f12510g = r11
            r7.f12511h = r11
            l.e0 r1 = r7.f12506c
            java.net.InetSocketAddress r3 = r1.mo22125d()
            l.e0 r1 = r7.f12506c
            java.net.Proxy r4 = r1.mo22123b()
            r5 = 0
            r1 = r23
            r2 = r22
            r6 = r0
            r1.mo22215e(r2, r3, r4, r5, r6)
            if (r12 != 0) goto L_0x0135
            okhttp3.internal.connection.RouteException r12 = new okhttp3.internal.connection.RouteException
            r12.<init>(r0)
            goto L_0x0138
        L_0x0135:
            r12.mo35749a(r0)
        L_0x0138:
            if (r21 == 0) goto L_0x0142
            boolean r0 = r10.mo35753b(r0)
            if (r0 == 0) goto L_0x0142
            goto L_0x0088
        L_0x0142:
            throw r12
        L_0x0143:
            okhttp3.internal.connection.RouteException r0 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
            java.lang.String r2 = "H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x0150:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "already connected"
            r0.<init>(r1)
            goto L_0x0159
        L_0x0158:
            throw r0
        L_0x0159:
            goto L_0x0158
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.C4463c.mo22499e(int, int, int, int, boolean, l.e, l.p):void");
    }

    /* renamed from: l */
    public C4430r mo22500l() {
        return this.f12509f;
    }

    /* renamed from: m */
    public boolean mo22501m(C4379a aVar, @Nullable C4397e0 e0Var) {
        if (this.f12517n.size() >= this.f12516m || this.f12514k || !C4401a.f12251a.mo22146g(this.f12506c.mo22122a(), aVar)) {
            return false;
        }
        if (aVar.mo22039l().mo22274m().equals(mo22505q().mo22122a().mo22039l().mo22274m())) {
            return true;
        }
        if (this.f12511h == null || e0Var == null || e0Var.mo22123b().type() != Proxy.Type.DIRECT || this.f12506c.mo22123b().type() != Proxy.Type.DIRECT || !this.f12506c.mo22125d().equals(e0Var.mo22125d()) || e0Var.mo22122a().mo22030e() != C6378d.f17312a || !mo22507t(aVar.mo22039l())) {
            return false;
        }
        try {
            aVar.mo22026a().mo22129a(aVar.mo22039l().mo22274m(), mo22500l().mo22240c());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    /* renamed from: n */
    public boolean mo22502n(boolean z) {
        int soTimeout;
        if (this.f12508e.isClosed() || this.f12508e.isInputShutdown() || this.f12508e.isOutputShutdown()) {
            return false;
        }
        C6518f fVar = this.f12511h;
        if (fVar != null) {
            return !fVar.mo35804m();
        }
        if (z) {
            try {
                soTimeout = this.f12508e.getSoTimeout();
                this.f12508e.setSoTimeout(1);
                if (this.f12512i.mo22447x()) {
                    this.f12508e.setSoTimeout(soTimeout);
                    return false;
                }
                this.f12508e.setSoTimeout(soTimeout);
                return true;
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            } catch (Throwable th) {
                this.f12508e.setSoTimeout(soTimeout);
                throw th;
            }
        }
        return true;
    }

    /* renamed from: o */
    public boolean mo22503o() {
        return this.f12511h != null;
    }

    /* renamed from: p */
    public C6356c mo22504p(C4440x xVar, C6389u.C4435a aVar, C6507f fVar) throws SocketException {
        if (this.f12511h != null) {
            return new C6516e(xVar, aVar, fVar, this.f12511h);
        }
        this.f12508e.setSoTimeout(aVar.mo22295a());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f12512i.mo22376e().mo22494g((long) aVar.mo22295a(), timeUnit);
        this.f12513j.mo22372e().mo22494g((long) aVar.mo22296b(), timeUnit);
        return new C6365a(xVar, fVar, this.f12512i, this.f12513j);
    }

    /* renamed from: q */
    public C4397e0 mo22505q() {
        return this.f12506c;
    }

    /* renamed from: r */
    public Socket mo22506r() {
        return this.f12508e;
    }

    /* renamed from: t */
    public boolean mo22507t(C4433t tVar) {
        if (tVar.mo22280z() != this.f12506c.mo22122a().mo22039l().mo22280z()) {
            return false;
        }
        if (tVar.mo22274m().equals(this.f12506c.mo22122a().mo22039l().mo22274m())) {
            return true;
        }
        if (this.f12509f == null || !C6378d.f17312a.mo35601c(tVar.mo22274m(), (X509Certificate) this.f12509f.mo22240c().get(0))) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f12506c.mo22122a().mo22039l().mo22274m());
        sb.append(":");
        sb.append(this.f12506c.mo22122a().mo22039l().mo22280z());
        sb.append(", proxy=");
        sb.append(this.f12506c.mo22123b());
        sb.append(" hostAddress=");
        sb.append(this.f12506c.mo22125d());
        sb.append(" cipherSuite=");
        C4430r rVar = this.f12509f;
        sb.append(rVar != null ? rVar.mo22239a() : "none");
        sb.append(" protocol=");
        sb.append(this.f12510g);
        sb.append(CoreConstants.CURLY_RIGHT);
        return sb.toString();
    }
}
