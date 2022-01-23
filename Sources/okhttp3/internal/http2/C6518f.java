package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import net.danlew.android.joda.DateUtils;
import okhttp3.internal.http2.C6531g;
import p225l.p226g0.C4402c;
import p225l.p226g0.C6347b;
import p225l.p226g0.p229h.C4416f;
import p230m.C4450c;
import p230m.C4453d;
import p230m.C4454e;
import p230m.C4455f;

/* renamed from: okhttp3.internal.http2.f */
/* compiled from: Http2Connection */
public final class C6518f implements Closeable {
    /* access modifiers changed from: private */

    /* renamed from: v */
    public static final ExecutorService f17642v = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C4402c.m17176G("OkHttp Http2Connection", true));

    /* renamed from: b */
    final boolean f17643b;

    /* renamed from: c */
    final C4464h f17644c;

    /* renamed from: d */
    final Map<Integer, C4466h> f17645d = new LinkedHashMap();

    /* renamed from: e */
    final String f17646e;

    /* renamed from: f */
    int f17647f;

    /* renamed from: g */
    int f17648g;

    /* renamed from: h */
    boolean f17649h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final ScheduledExecutorService f17650i;

    /* renamed from: j */
    private final ExecutorService f17651j;

    /* renamed from: k */
    final C6537k f17652k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f17653l;

    /* renamed from: m */
    long f17654m = 0;

    /* renamed from: n */
    long f17655n;

    /* renamed from: o */
    C6539l f17656o = new C6539l();

    /* renamed from: p */
    final C6539l f17657p;

    /* renamed from: q */
    boolean f17658q;

    /* renamed from: r */
    final Socket f17659r;

    /* renamed from: s */
    final C6534i f17660s;

    /* renamed from: t */
    final C6527j f17661t;

    /* renamed from: u */
    final Set<Integer> f17662u;

    /* renamed from: okhttp3.internal.http2.f$h */
    /* compiled from: Http2Connection */
    public static abstract class C4464h {

        /* renamed from: a */
        public static final C4464h f12519a = new C4465a();

        /* renamed from: okhttp3.internal.http2.f$h$a */
        /* compiled from: Http2Connection */
        class C4465a extends C4464h {
            C4465a() {
            }

            /* renamed from: c */
            public void mo22497c(C4466h hVar) throws IOException {
                hVar.mo22512f(C6509a.REFUSED_STREAM);
            }
        }

        /* renamed from: b */
        public void mo22496b(C6518f fVar) {
        }

        /* renamed from: c */
        public abstract void mo22497c(C4466h hVar) throws IOException;
    }

    /* renamed from: okhttp3.internal.http2.f$a */
    /* compiled from: Http2Connection */
    class C6519a extends C6347b {

        /* renamed from: c */
        final /* synthetic */ int f17663c;

        /* renamed from: d */
        final /* synthetic */ C6509a f17664d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C6519a(String str, Object[] objArr, int i, C6509a aVar) {
            super(str, objArr);
            this.f17663c = i;
            this.f17664d = aVar;
        }

        /* renamed from: k */
        public void mo22359k() {
            try {
                C6518f.this.mo35797X(this.f17663c, this.f17664d);
            } catch (IOException unused) {
                C6518f.this.m25453j();
            }
        }
    }

    /* renamed from: okhttp3.internal.http2.f$b */
    /* compiled from: Http2Connection */
    class C6520b extends C6347b {

        /* renamed from: c */
        final /* synthetic */ int f17666c;

        /* renamed from: d */
        final /* synthetic */ long f17667d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C6520b(String str, Object[] objArr, int i, long j) {
            super(str, objArr);
            this.f17666c = i;
            this.f17667d = j;
        }

        /* renamed from: k */
        public void mo22359k() {
            try {
                C6518f.this.f17660s.mo35842v(this.f17666c, this.f17667d);
            } catch (IOException unused) {
                C6518f.this.m25453j();
            }
        }
    }

    /* renamed from: okhttp3.internal.http2.f$c */
    /* compiled from: Http2Connection */
    class C6521c extends C6347b {

        /* renamed from: c */
        final /* synthetic */ int f17669c;

        /* renamed from: d */
        final /* synthetic */ List f17670d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C6521c(String str, Object[] objArr, int i, List list) {
            super(str, objArr);
            this.f17669c = i;
            this.f17670d = list;
        }

        /* renamed from: k */
        public void mo22359k() {
            if (C6518f.this.f17652k.mo35846a(this.f17669c, this.f17670d)) {
                try {
                    C6518f.this.f17660s.mo35839q(this.f17669c, C6509a.CANCEL);
                    synchronized (C6518f.this) {
                        C6518f.this.f17662u.remove(Integer.valueOf(this.f17669c));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    /* renamed from: okhttp3.internal.http2.f$d */
    /* compiled from: Http2Connection */
    class C6522d extends C6347b {

        /* renamed from: c */
        final /* synthetic */ int f17672c;

        /* renamed from: d */
        final /* synthetic */ List f17673d;

        /* renamed from: e */
        final /* synthetic */ boolean f17674e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C6522d(String str, Object[] objArr, int i, List list, boolean z) {
            super(str, objArr);
            this.f17672c = i;
            this.f17673d = list;
            this.f17674e = z;
        }

        /* renamed from: k */
        public void mo22359k() {
            boolean b = C6518f.this.f17652k.mo35847b(this.f17672c, this.f17673d, this.f17674e);
            if (b) {
                try {
                    C6518f.this.f17660s.mo35839q(this.f17672c, C6509a.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (b || this.f17674e) {
                synchronized (C6518f.this) {
                    C6518f.this.f17662u.remove(Integer.valueOf(this.f17672c));
                }
            }
        }
    }

    /* renamed from: okhttp3.internal.http2.f$e */
    /* compiled from: Http2Connection */
    class C6523e extends C6347b {

        /* renamed from: c */
        final /* synthetic */ int f17676c;

        /* renamed from: d */
        final /* synthetic */ C4450c f17677d;

        /* renamed from: e */
        final /* synthetic */ int f17678e;

        /* renamed from: f */
        final /* synthetic */ boolean f17679f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C6523e(String str, Object[] objArr, int i, C4450c cVar, int i2, boolean z) {
            super(str, objArr);
            this.f17676c = i;
            this.f17677d = cVar;
            this.f17678e = i2;
            this.f17679f = z;
        }

        /* renamed from: k */
        public void mo22359k() {
            try {
                boolean d = C6518f.this.f17652k.mo35849d(this.f17676c, this.f17677d, this.f17678e, this.f17679f);
                if (d) {
                    C6518f.this.f17660s.mo35839q(this.f17676c, C6509a.CANCEL);
                }
                if (d || this.f17679f) {
                    synchronized (C6518f.this) {
                        C6518f.this.f17662u.remove(Integer.valueOf(this.f17676c));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: okhttp3.internal.http2.f$f */
    /* compiled from: Http2Connection */
    class C6524f extends C6347b {

        /* renamed from: c */
        final /* synthetic */ int f17681c;

        /* renamed from: d */
        final /* synthetic */ C6509a f17682d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C6524f(String str, Object[] objArr, int i, C6509a aVar) {
            super(str, objArr);
            this.f17681c = i;
            this.f17682d = aVar;
        }

        /* renamed from: k */
        public void mo22359k() {
            C6518f.this.f17652k.mo35848c(this.f17681c, this.f17682d);
            synchronized (C6518f.this) {
                C6518f.this.f17662u.remove(Integer.valueOf(this.f17681c));
            }
        }
    }

    /* renamed from: okhttp3.internal.http2.f$g */
    /* compiled from: Http2Connection */
    public static class C6525g {

        /* renamed from: a */
        Socket f17684a;

        /* renamed from: b */
        String f17685b;

        /* renamed from: c */
        C4454e f17686c;

        /* renamed from: d */
        C4453d f17687d;

        /* renamed from: e */
        C4464h f17688e = C4464h.f12519a;

        /* renamed from: f */
        C6537k f17689f = C6537k.f17728a;

        /* renamed from: g */
        boolean f17690g;

        /* renamed from: h */
        int f17691h;

        public C6525g(boolean z) {
            this.f17690g = z;
        }

        /* renamed from: a */
        public C6518f mo35810a() {
            return new C6518f(this);
        }

        /* renamed from: b */
        public C6525g mo35811b(C4464h hVar) {
            this.f17688e = hVar;
            return this;
        }

        /* renamed from: c */
        public C6525g mo35812c(int i) {
            this.f17691h = i;
            return this;
        }

        /* renamed from: d */
        public C6525g mo35813d(Socket socket, String str, C4454e eVar, C4453d dVar) {
            this.f17684a = socket;
            this.f17685b = str;
            this.f17686c = eVar;
            this.f17687d = dVar;
            return this;
        }
    }

    /* renamed from: okhttp3.internal.http2.f$i */
    /* compiled from: Http2Connection */
    final class C6526i extends C6347b {

        /* renamed from: c */
        final boolean f17692c;

        /* renamed from: d */
        final int f17693d;

        /* renamed from: e */
        final int f17694e;

        C6526i(boolean z, int i, int i2) {
            super("OkHttp %s ping %08x%08x", C6518f.this.f17646e, Integer.valueOf(i), Integer.valueOf(i2));
            this.f17692c = z;
            this.f17693d = i;
            this.f17694e = i2;
        }

        /* renamed from: k */
        public void mo22359k() {
            C6518f.this.mo35796V(this.f17692c, this.f17693d, this.f17694e);
        }
    }

    /* renamed from: okhttp3.internal.http2.f$j */
    /* compiled from: Http2Connection */
    class C6527j extends C6347b implements C6531g.C6533b {

        /* renamed from: c */
        final C6531g f17696c;

        /* renamed from: okhttp3.internal.http2.f$j$a */
        /* compiled from: Http2Connection */
        class C6528a extends C6347b {

            /* renamed from: c */
            final /* synthetic */ C4466h f17698c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C6528a(String str, Object[] objArr, C4466h hVar) {
                super(str, objArr);
                this.f17698c = hVar;
            }

            /* renamed from: k */
            public void mo22359k() {
                try {
                    C6518f.this.f17644c.mo22497c(this.f17698c);
                } catch (IOException e) {
                    C4416f j = C4416f.m17252j();
                    j.mo22163p(4, "Http2Connection.Listener failure for " + C6518f.this.f17646e, e);
                    try {
                        this.f17698c.mo22512f(C6509a.PROTOCOL_ERROR);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        /* renamed from: okhttp3.internal.http2.f$j$b */
        /* compiled from: Http2Connection */
        class C6529b extends C6347b {
            C6529b(String str, Object... objArr) {
                super(str, objArr);
            }

            /* renamed from: k */
            public void mo22359k() {
                C6518f fVar = C6518f.this;
                fVar.f17644c.mo22496b(fVar);
            }
        }

        /* renamed from: okhttp3.internal.http2.f$j$c */
        /* compiled from: Http2Connection */
        class C6530c extends C6347b {

            /* renamed from: c */
            final /* synthetic */ C6539l f17701c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C6530c(String str, Object[] objArr, C6539l lVar) {
                super(str, objArr);
                this.f17701c = lVar;
            }

            /* renamed from: k */
            public void mo22359k() {
                try {
                    C6518f.this.f17660s.mo35827a(this.f17701c);
                } catch (IOException unused) {
                    C6518f.this.m25453j();
                }
            }
        }

        C6527j(C6531g gVar) {
            super("OkHttp %s", C6518f.this.f17646e);
            this.f17696c = gVar;
        }

        /* renamed from: l */
        private void m25487l(C6539l lVar) {
            try {
                C6518f.this.f17650i.execute(new C6530c("OkHttp %s ACK Settings", new Object[]{C6518f.this.f17646e}, lVar));
            } catch (RejectedExecutionException unused) {
            }
        }

        /* renamed from: a */
        public void mo35814a() {
        }

        /* JADX WARNING: type inference failed for: r1v11, types: [java.lang.Object[]] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo35815b(boolean r11, okhttp3.internal.http2.C6539l r12) {
            /*
                r10 = this;
                okhttp3.internal.http2.f r0 = okhttp3.internal.http2.C6518f.this
                monitor-enter(r0)
                okhttp3.internal.http2.f r1 = okhttp3.internal.http2.C6518f.this     // Catch:{ all -> 0x008b }
                okhttp3.internal.http2.l r1 = r1.f17657p     // Catch:{ all -> 0x008b }
                int r1 = r1.mo35853d()     // Catch:{ all -> 0x008b }
                if (r11 == 0) goto L_0x0014
                okhttp3.internal.http2.f r11 = okhttp3.internal.http2.C6518f.this     // Catch:{ all -> 0x008b }
                okhttp3.internal.http2.l r11 = r11.f17657p     // Catch:{ all -> 0x008b }
                r11.mo35850a()     // Catch:{ all -> 0x008b }
            L_0x0014:
                okhttp3.internal.http2.f r11 = okhttp3.internal.http2.C6518f.this     // Catch:{ all -> 0x008b }
                okhttp3.internal.http2.l r11 = r11.f17657p     // Catch:{ all -> 0x008b }
                r11.mo35857h(r12)     // Catch:{ all -> 0x008b }
                r10.m25487l(r12)     // Catch:{ all -> 0x008b }
                okhttp3.internal.http2.f r11 = okhttp3.internal.http2.C6518f.this     // Catch:{ all -> 0x008b }
                okhttp3.internal.http2.l r11 = r11.f17657p     // Catch:{ all -> 0x008b }
                int r11 = r11.mo35853d()     // Catch:{ all -> 0x008b }
                r12 = -1
                r2 = 0
                r4 = 1
                r5 = 0
                if (r11 == r12) goto L_0x005b
                if (r11 == r1) goto L_0x005b
                int r11 = r11 - r1
                long r11 = (long) r11     // Catch:{ all -> 0x008b }
                okhttp3.internal.http2.f r1 = okhttp3.internal.http2.C6518f.this     // Catch:{ all -> 0x008b }
                boolean r6 = r1.f17658q     // Catch:{ all -> 0x008b }
                if (r6 != 0) goto L_0x0039
                r1.f17658q = r4     // Catch:{ all -> 0x008b }
            L_0x0039:
                java.util.Map<java.lang.Integer, okhttp3.internal.http2.h> r1 = r1.f17645d     // Catch:{ all -> 0x008b }
                boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x008b }
                if (r1 != 0) goto L_0x005c
                okhttp3.internal.http2.f r1 = okhttp3.internal.http2.C6518f.this     // Catch:{ all -> 0x008b }
                java.util.Map<java.lang.Integer, okhttp3.internal.http2.h> r1 = r1.f17645d     // Catch:{ all -> 0x008b }
                java.util.Collection r1 = r1.values()     // Catch:{ all -> 0x008b }
                okhttp3.internal.http2.f r5 = okhttp3.internal.http2.C6518f.this     // Catch:{ all -> 0x008b }
                java.util.Map<java.lang.Integer, okhttp3.internal.http2.h> r5 = r5.f17645d     // Catch:{ all -> 0x008b }
                int r5 = r5.size()     // Catch:{ all -> 0x008b }
                okhttp3.internal.http2.h[] r5 = new okhttp3.internal.http2.C4466h[r5]     // Catch:{ all -> 0x008b }
                java.lang.Object[] r1 = r1.toArray(r5)     // Catch:{ all -> 0x008b }
                r5 = r1
                okhttp3.internal.http2.h[] r5 = (okhttp3.internal.http2.C4466h[]) r5     // Catch:{ all -> 0x008b }
                goto L_0x005c
            L_0x005b:
                r11 = r2
            L_0x005c:
                java.util.concurrent.ExecutorService r1 = okhttp3.internal.http2.C6518f.f17642v     // Catch:{ all -> 0x008b }
                okhttp3.internal.http2.f$j$b r6 = new okhttp3.internal.http2.f$j$b     // Catch:{ all -> 0x008b }
                java.lang.String r7 = "OkHttp %s settings"
                java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x008b }
                okhttp3.internal.http2.f r8 = okhttp3.internal.http2.C6518f.this     // Catch:{ all -> 0x008b }
                java.lang.String r8 = r8.f17646e     // Catch:{ all -> 0x008b }
                r9 = 0
                r4[r9] = r8     // Catch:{ all -> 0x008b }
                r6.<init>(r7, r4)     // Catch:{ all -> 0x008b }
                r1.execute(r6)     // Catch:{ all -> 0x008b }
                monitor-exit(r0)     // Catch:{ all -> 0x008b }
                if (r5 == 0) goto L_0x008a
                int r0 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
                if (r0 == 0) goto L_0x008a
                int r0 = r5.length
            L_0x007b:
                if (r9 >= r0) goto L_0x008a
                r1 = r5[r9]
                monitor-enter(r1)
                r1.mo22509c(r11)     // Catch:{ all -> 0x0087 }
                monitor-exit(r1)     // Catch:{ all -> 0x0087 }
                int r9 = r9 + 1
                goto L_0x007b
            L_0x0087:
                r11 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0087 }
                throw r11
            L_0x008a:
                return
            L_0x008b:
                r11 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x008b }
                goto L_0x008f
            L_0x008e:
                throw r11
            L_0x008f:
                goto L_0x008e
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.C6518f.C6527j.mo35815b(boolean, okhttp3.internal.http2.l):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x006e, code lost:
            r0.mo22522q(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0071, code lost:
            if (r10 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0073, code lost:
            r0.mo22521p();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            return;
         */
        /* renamed from: c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo35816c(boolean r10, int r11, int r12, java.util.List<okhttp3.internal.http2.C6510b> r13) {
            /*
                r9 = this;
                okhttp3.internal.http2.f r12 = okhttp3.internal.http2.C6518f.this
                boolean r12 = r12.mo35789C(r11)
                if (r12 == 0) goto L_0x000e
                okhttp3.internal.http2.f r12 = okhttp3.internal.http2.C6518f.this
                r12.mo35808v(r11, r13, r10)
                return
            L_0x000e:
                okhttp3.internal.http2.f r12 = okhttp3.internal.http2.C6518f.this
                monitor-enter(r12)
                okhttp3.internal.http2.f r0 = okhttp3.internal.http2.C6518f.this     // Catch:{ all -> 0x0077 }
                okhttp3.internal.http2.h r0 = r0.mo35803k(r11)     // Catch:{ all -> 0x0077 }
                if (r0 != 0) goto L_0x006d
                okhttp3.internal.http2.f r0 = okhttp3.internal.http2.C6518f.this     // Catch:{ all -> 0x0077 }
                boolean r1 = r0.f17649h     // Catch:{ all -> 0x0077 }
                if (r1 == 0) goto L_0x0021
                monitor-exit(r12)     // Catch:{ all -> 0x0077 }
                return
            L_0x0021:
                int r1 = r0.f17647f     // Catch:{ all -> 0x0077 }
                if (r11 > r1) goto L_0x0027
                monitor-exit(r12)     // Catch:{ all -> 0x0077 }
                return
            L_0x0027:
                int r1 = r11 % 2
                int r0 = r0.f17648g     // Catch:{ all -> 0x0077 }
                r2 = 2
                int r0 = r0 % r2
                if (r1 != r0) goto L_0x0031
                monitor-exit(r12)     // Catch:{ all -> 0x0077 }
                return
            L_0x0031:
                l.s r8 = p225l.p226g0.C4402c.m17177H(r13)     // Catch:{ all -> 0x0077 }
                okhttp3.internal.http2.h r13 = new okhttp3.internal.http2.h     // Catch:{ all -> 0x0077 }
                okhttp3.internal.http2.f r5 = okhttp3.internal.http2.C6518f.this     // Catch:{ all -> 0x0077 }
                r6 = 0
                r3 = r13
                r4 = r11
                r7 = r10
                r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0077 }
                okhttp3.internal.http2.f r10 = okhttp3.internal.http2.C6518f.this     // Catch:{ all -> 0x0077 }
                r10.f17647f = r11     // Catch:{ all -> 0x0077 }
                java.util.Map<java.lang.Integer, okhttp3.internal.http2.h> r10 = r10.f17645d     // Catch:{ all -> 0x0077 }
                java.lang.Integer r0 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0077 }
                r10.put(r0, r13)     // Catch:{ all -> 0x0077 }
                java.util.concurrent.ExecutorService r10 = okhttp3.internal.http2.C6518f.f17642v     // Catch:{ all -> 0x0077 }
                okhttp3.internal.http2.f$j$a r0 = new okhttp3.internal.http2.f$j$a     // Catch:{ all -> 0x0077 }
                java.lang.String r1 = "OkHttp %s stream %d"
                java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0077 }
                r3 = 0
                okhttp3.internal.http2.f r4 = okhttp3.internal.http2.C6518f.this     // Catch:{ all -> 0x0077 }
                java.lang.String r4 = r4.f17646e     // Catch:{ all -> 0x0077 }
                r2[r3] = r4     // Catch:{ all -> 0x0077 }
                r3 = 1
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0077 }
                r2[r3] = r11     // Catch:{ all -> 0x0077 }
                r0.<init>(r1, r2, r13)     // Catch:{ all -> 0x0077 }
                r10.execute(r0)     // Catch:{ all -> 0x0077 }
                monitor-exit(r12)     // Catch:{ all -> 0x0077 }
                return
            L_0x006d:
                monitor-exit(r12)     // Catch:{ all -> 0x0077 }
                r0.mo22522q(r13)
                if (r10 == 0) goto L_0x0076
                r0.mo22521p()
            L_0x0076:
                return
            L_0x0077:
                r10 = move-exception
                monitor-exit(r12)     // Catch:{ all -> 0x0077 }
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.C6518f.C6527j.mo35816c(boolean, int, int, java.util.List):void");
        }

        /* renamed from: d */
        public void mo35817d(int i, long j) {
            if (i == 0) {
                synchronized (C6518f.this) {
                    C6518f fVar = C6518f.this;
                    fVar.f17655n += j;
                    fVar.notifyAll();
                }
                return;
            }
            C4466h k = C6518f.this.mo35803k(i);
            if (k != null) {
                synchronized (k) {
                    k.mo22509c(j);
                }
            }
        }

        /* renamed from: e */
        public void mo35818e(boolean z, int i, C4454e eVar, int i2) throws IOException {
            if (C6518f.this.mo35789C(i)) {
                C6518f.this.mo35807r(i, eVar, i2, z);
                return;
            }
            C4466h k = C6518f.this.mo35803k(i);
            if (k == null) {
                C6518f.this.mo35798Y(i, C6509a.PROTOCOL_ERROR);
                long j = (long) i2;
                C6518f.this.mo35794M(j);
                eVar.skip(j);
                return;
            }
            k.mo22520o(eVar, i2);
            if (z) {
                k.mo22521p();
            }
        }

        /* renamed from: f */
        public void mo35819f(boolean z, int i, int i2) {
            if (z) {
                synchronized (C6518f.this) {
                    boolean unused = C6518f.this.f17653l = false;
                    C6518f.this.notifyAll();
                }
                return;
            }
            try {
                C6518f.this.f17650i.execute(new C6526i(true, i, i2));
            } catch (RejectedExecutionException unused2) {
            }
        }

        /* renamed from: g */
        public void mo35820g(int i, int i2, int i3, boolean z) {
        }

        /* renamed from: h */
        public void mo35821h(int i, C6509a aVar) {
            if (C6518f.this.mo35789C(i)) {
                C6518f.this.mo35788A(i, aVar);
                return;
            }
            C4466h F = C6518f.this.mo35790F(i);
            if (F != null) {
                F.mo22523r(aVar);
            }
        }

        /* renamed from: i */
        public void mo35822i(int i, int i2, List<C6510b> list) {
            C6518f.this.mo35809z(i2, list);
        }

        /* renamed from: j */
        public void mo35823j(int i, C6509a aVar, C4455f fVar) {
            C4466h[] hVarArr;
            fVar.size();
            synchronized (C6518f.this) {
                hVarArr = (C4466h[]) C6518f.this.f17645d.values().toArray(new C4466h[C6518f.this.f17645d.size()]);
                C6518f.this.f17649h = true;
            }
            for (C4466h hVar : hVarArr) {
                if (hVar.mo22514i() > i && hVar.mo22517l()) {
                    hVar.mo22523r(C6509a.REFUSED_STREAM);
                    C6518f.this.mo35790F(hVar.mo22514i());
                }
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r0 = okhttp3.internal.http2.C6509a.PROTOCOL_ERROR;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            r4.f17697d.mo35802g(r0, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x002c, code lost:
            r2 = th;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x001f */
        /* renamed from: k */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo22359k() {
            /*
                r4 = this;
                okhttp3.internal.http2.a r0 = okhttp3.internal.http2.C6509a.INTERNAL_ERROR
                okhttp3.internal.http2.g r1 = r4.f17696c     // Catch:{ IOException -> 0x001e, all -> 0x001b }
                r1.mo35826d(r4)     // Catch:{ IOException -> 0x001e, all -> 0x001b }
            L_0x0007:
                okhttp3.internal.http2.g r1 = r4.f17696c     // Catch:{ IOException -> 0x001e, all -> 0x001b }
                r2 = 0
                boolean r1 = r1.mo35824b(r2, r4)     // Catch:{ IOException -> 0x001e, all -> 0x001b }
                if (r1 == 0) goto L_0x0011
                goto L_0x0007
            L_0x0011:
                okhttp3.internal.http2.a r1 = okhttp3.internal.http2.C6509a.NO_ERROR     // Catch:{ IOException -> 0x001e, all -> 0x001b }
                okhttp3.internal.http2.a r0 = okhttp3.internal.http2.C6509a.CANCEL     // Catch:{ IOException -> 0x001f }
                okhttp3.internal.http2.f r2 = okhttp3.internal.http2.C6518f.this     // Catch:{ IOException -> 0x0026 }
                r2.mo35802g(r1, r0)     // Catch:{ IOException -> 0x0026 }
                goto L_0x0026
            L_0x001b:
                r2 = move-exception
                r1 = r0
                goto L_0x002d
            L_0x001e:
                r1 = r0
            L_0x001f:
                okhttp3.internal.http2.a r0 = okhttp3.internal.http2.C6509a.PROTOCOL_ERROR     // Catch:{ all -> 0x002c }
                okhttp3.internal.http2.f r1 = okhttp3.internal.http2.C6518f.this     // Catch:{ IOException -> 0x0026 }
                r1.mo35802g(r0, r0)     // Catch:{ IOException -> 0x0026 }
            L_0x0026:
                okhttp3.internal.http2.g r0 = r4.f17696c
                p225l.p226g0.C4402c.m17186g(r0)
                return
            L_0x002c:
                r2 = move-exception
            L_0x002d:
                okhttp3.internal.http2.f r3 = okhttp3.internal.http2.C6518f.this     // Catch:{ IOException -> 0x0032 }
                r3.mo35802g(r1, r0)     // Catch:{ IOException -> 0x0032 }
            L_0x0032:
                okhttp3.internal.http2.g r0 = r4.f17696c
                p225l.p226g0.C4402c.m17186g(r0)
                goto L_0x0039
            L_0x0038:
                throw r2
            L_0x0039:
                goto L_0x0038
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.C6518f.C6527j.mo22359k():void");
        }
    }

    static {
        Class<C6518f> cls = C6518f.class;
    }

    C6518f(C6525g gVar) {
        C6525g gVar2 = gVar;
        C6539l lVar = new C6539l();
        this.f17657p = lVar;
        this.f17658q = false;
        this.f17662u = new LinkedHashSet();
        this.f17652k = gVar2.f17689f;
        boolean z = gVar2.f17690g;
        this.f17643b = z;
        this.f17644c = gVar2.f17688e;
        int i = z ? 1 : 2;
        this.f17648g = i;
        if (z) {
            this.f17648g = i + 2;
        }
        if (z) {
            this.f17656o.mo35858i(7, 16777216);
        }
        String str = gVar2.f17685b;
        this.f17646e = str;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, C4402c.m17176G(C4402c.m17197r("OkHttp %s Writer", str), false));
        this.f17650i = scheduledThreadPoolExecutor;
        if (gVar2.f17691h != 0) {
            C6526i iVar = new C6526i(false, 0, 0);
            int i2 = gVar2.f17691h;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(iVar, (long) i2, (long) i2, TimeUnit.MILLISECONDS);
        }
        this.f17651j = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), C4402c.m17176G(C4402c.m17197r("OkHttp %s Push Observer", str), true));
        lVar.mo35858i(7, 65535);
        lVar.mo35858i(5, DateUtils.FORMAT_ABBREV_TIME);
        this.f17655n = (long) lVar.mo35853d();
        this.f17659r = gVar2.f17684a;
        this.f17660s = new C6534i(gVar2.f17687d, z);
        this.f17661t = new C6527j(new C6531g(gVar2.f17686c, z));
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m25453j() {
        try {
            C6509a aVar = C6509a.PROTOCOL_ERROR;
            mo35802g(aVar, aVar);
        } catch (IOException unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0041  */
    /* renamed from: p */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private okhttp3.internal.http2.C4466h m25454p(int r11, java.util.List<okhttp3.internal.http2.C6510b> r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            okhttp3.internal.http2.i r7 = r10.f17660s
            monitor-enter(r7)
            monitor-enter(r10)     // Catch:{ all -> 0x0076 }
            int r0 = r10.f17648g     // Catch:{ all -> 0x0073 }
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L_0x0013
            okhttp3.internal.http2.a r0 = okhttp3.internal.http2.C6509a.REFUSED_STREAM     // Catch:{ all -> 0x0073 }
            r10.mo35791G(r0)     // Catch:{ all -> 0x0073 }
        L_0x0013:
            boolean r0 = r10.f17649h     // Catch:{ all -> 0x0073 }
            if (r0 != 0) goto L_0x006d
            int r8 = r10.f17648g     // Catch:{ all -> 0x0073 }
            int r0 = r8 + 2
            r10.f17648g = r0     // Catch:{ all -> 0x0073 }
            okhttp3.internal.http2.h r9 = new okhttp3.internal.http2.h     // Catch:{ all -> 0x0073 }
            r5 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0073 }
            if (r13 == 0) goto L_0x003a
            long r0 = r10.f17655n     // Catch:{ all -> 0x0073 }
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x003a
            long r0 = r9.f12521b     // Catch:{ all -> 0x0073 }
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L_0x0038
            goto L_0x003a
        L_0x0038:
            r13 = 0
            goto L_0x003b
        L_0x003a:
            r13 = 1
        L_0x003b:
            boolean r0 = r9.mo22518m()     // Catch:{ all -> 0x0073 }
            if (r0 == 0) goto L_0x004a
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.h> r0 = r10.f17645d     // Catch:{ all -> 0x0073 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0073 }
            r0.put(r1, r9)     // Catch:{ all -> 0x0073 }
        L_0x004a:
            monitor-exit(r10)     // Catch:{ all -> 0x0073 }
            if (r11 != 0) goto L_0x0053
            okhttp3.internal.http2.i r0 = r10.f17660s     // Catch:{ all -> 0x0076 }
            r0.mo35841u(r6, r8, r11, r12)     // Catch:{ all -> 0x0076 }
            goto L_0x005c
        L_0x0053:
            boolean r0 = r10.f17643b     // Catch:{ all -> 0x0076 }
            if (r0 != 0) goto L_0x0065
            okhttp3.internal.http2.i r0 = r10.f17660s     // Catch:{ all -> 0x0076 }
            r0.mo35838p(r11, r8, r12)     // Catch:{ all -> 0x0076 }
        L_0x005c:
            monitor-exit(r7)     // Catch:{ all -> 0x0076 }
            if (r13 == 0) goto L_0x0064
            okhttp3.internal.http2.i r11 = r10.f17660s
            r11.flush()
        L_0x0064:
            return r9
        L_0x0065:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0076 }
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch:{ all -> 0x0076 }
            throw r11     // Catch:{ all -> 0x0076 }
        L_0x006d:
            okhttp3.internal.http2.ConnectionShutdownException r11 = new okhttp3.internal.http2.ConnectionShutdownException     // Catch:{ all -> 0x0073 }
            r11.<init>()     // Catch:{ all -> 0x0073 }
            throw r11     // Catch:{ all -> 0x0073 }
        L_0x0073:
            r11 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0073 }
            throw r11     // Catch:{ all -> 0x0076 }
        L_0x0076:
            r11 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0076 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.C6518f.m25454p(int, java.util.List, boolean):okhttp3.internal.http2.h");
    }

    /* renamed from: u */
    private synchronized void m25455u(C6347b bVar) {
        if (!mo35804m()) {
            this.f17651j.execute(bVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: A */
    public void mo35788A(int i, C6509a aVar) {
        m25455u(new C6524f("OkHttp %s Push Reset[%s]", new Object[]{this.f17646e, Integer.valueOf(i)}, i, aVar));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: C */
    public boolean mo35789C(int i) {
        return i != 0 && (i & 1) == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: F */
    public synchronized C4466h mo35790F(int i) {
        C4466h remove;
        remove = this.f17645d.remove(Integer.valueOf(i));
        notifyAll();
        return remove;
    }

    /* renamed from: G */
    public void mo35791G(C6509a aVar) throws IOException {
        synchronized (this.f17660s) {
            synchronized (this) {
                if (!this.f17649h) {
                    this.f17649h = true;
                    int i = this.f17647f;
                    this.f17660s.mo35834j(i, aVar, C4402c.f12252a);
                }
            }
        }
    }

    /* renamed from: H */
    public void mo35792H() throws IOException {
        mo35793I(true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: I */
    public void mo35793I(boolean z) throws IOException {
        if (z) {
            this.f17660s.mo35828b();
            this.f17660s.mo35840r(this.f17656o);
            int d = this.f17656o.mo35853d();
            if (d != 65535) {
                this.f17660s.mo35842v(0, (long) (d - 65535));
            }
        }
        new Thread(this.f17661t).start();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: M */
    public synchronized void mo35794M(long j) {
        long j2 = this.f17654m + j;
        this.f17654m = j2;
        if (j2 >= ((long) (this.f17656o.mo35853d() / 2))) {
            mo35800d0(0, this.f17654m);
            this.f17654m = 0;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:26|27|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r3), r8.f17660s.mo35836m());
        r6 = (long) r3;
        r8.f17655n -= r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0064, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0058 */
    /* renamed from: S */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo35795S(int r9, boolean r10, p230m.C4450c r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x000d
            okhttp3.internal.http2.i r12 = r8.f17660s
            r12.mo35830d(r10, r9, r11, r0)
            return
        L_0x000d:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0067
            monitor-enter(r8)
        L_0x0012:
            long r3 = r8.f17655n     // Catch:{ InterruptedException -> 0x0058 }
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L_0x0030
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.h> r3 = r8.f17645d     // Catch:{ InterruptedException -> 0x0058 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ InterruptedException -> 0x0058 }
            boolean r3 = r3.containsKey(r4)     // Catch:{ InterruptedException -> 0x0058 }
            if (r3 == 0) goto L_0x0028
            r8.wait()     // Catch:{ InterruptedException -> 0x0058 }
            goto L_0x0012
        L_0x0028:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ InterruptedException -> 0x0058 }
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch:{ InterruptedException -> 0x0058 }
            throw r9     // Catch:{ InterruptedException -> 0x0058 }
        L_0x0030:
            long r3 = java.lang.Math.min(r12, r3)     // Catch:{ all -> 0x0056 }
            int r4 = (int) r3     // Catch:{ all -> 0x0056 }
            okhttp3.internal.http2.i r3 = r8.f17660s     // Catch:{ all -> 0x0056 }
            int r3 = r3.mo35836m()     // Catch:{ all -> 0x0056 }
            int r3 = java.lang.Math.min(r4, r3)     // Catch:{ all -> 0x0056 }
            long r4 = r8.f17655n     // Catch:{ all -> 0x0056 }
            long r6 = (long) r3     // Catch:{ all -> 0x0056 }
            long r4 = r4 - r6
            r8.f17655n = r4     // Catch:{ all -> 0x0056 }
            monitor-exit(r8)     // Catch:{ all -> 0x0056 }
            long r12 = r12 - r6
            okhttp3.internal.http2.i r4 = r8.f17660s
            if (r10 == 0) goto L_0x0051
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x0051
            r5 = 1
            goto L_0x0052
        L_0x0051:
            r5 = 0
        L_0x0052:
            r4.mo35830d(r5, r9, r11, r3)
            goto L_0x000d
        L_0x0056:
            r9 = move-exception
            goto L_0x0065
        L_0x0058:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0056 }
            r9.interrupt()     // Catch:{ all -> 0x0056 }
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0056 }
            r9.<init>()     // Catch:{ all -> 0x0056 }
            throw r9     // Catch:{ all -> 0x0056 }
        L_0x0065:
            monitor-exit(r8)     // Catch:{ all -> 0x0056 }
            throw r9
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.C6518f.mo35795S(int, boolean, m.c, long):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: V */
    public void mo35796V(boolean z, int i, int i2) {
        boolean z2;
        if (!z) {
            synchronized (this) {
                z2 = this.f17653l;
                this.f17653l = true;
            }
            if (z2) {
                m25453j();
                return;
            }
        }
        try {
            this.f17660s.mo35837n(z, i, i2);
        } catch (IOException unused) {
            m25453j();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: X */
    public void mo35797X(int i, C6509a aVar) throws IOException {
        this.f17660s.mo35839q(i, aVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: Y */
    public void mo35798Y(int i, C6509a aVar) {
        try {
            this.f17650i.execute(new C6519a("OkHttp %s stream %d", new Object[]{this.f17646e, Integer.valueOf(i)}, i, aVar));
        } catch (RejectedExecutionException unused) {
        }
    }

    public void close() throws IOException {
        mo35802g(C6509a.NO_ERROR, C6509a.CANCEL);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d0 */
    public void mo35800d0(int i, long j) {
        try {
            this.f17650i.execute(new C6520b("OkHttp Window Update %s stream %d", new Object[]{this.f17646e, Integer.valueOf(i)}, i, j));
        } catch (RejectedExecutionException unused) {
        }
    }

    public void flush() throws IOException {
        this.f17660s.flush();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo35802g(C6509a aVar, C6509a aVar2) throws IOException {
        C4466h[] hVarArr = null;
        try {
            mo35791G(aVar);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        synchronized (this) {
            if (!this.f17645d.isEmpty()) {
                hVarArr = (C4466h[]) this.f17645d.values().toArray(new C4466h[this.f17645d.size()]);
                this.f17645d.clear();
            }
        }
        if (hVarArr != null) {
            for (C4466h f : hVarArr) {
                try {
                    f.mo22512f(aVar2);
                } catch (IOException e2) {
                    if (e != null) {
                        e = e2;
                    }
                }
            }
        }
        try {
            this.f17660s.close();
        } catch (IOException e3) {
            if (e == null) {
                e = e3;
            }
        }
        try {
            this.f17659r.close();
        } catch (IOException e4) {
            e = e4;
        }
        this.f17650i.shutdown();
        this.f17651j.shutdown();
        if (e != null) {
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public synchronized C4466h mo35803k(int i) {
        return this.f17645d.get(Integer.valueOf(i));
    }

    /* renamed from: m */
    public synchronized boolean mo35804m() {
        return this.f17649h;
    }

    /* renamed from: n */
    public synchronized int mo35805n() {
        return this.f17657p.mo35854e(Integer.MAX_VALUE);
    }

    /* renamed from: q */
    public C4466h mo35806q(List<C6510b> list, boolean z) throws IOException {
        return m25454p(0, list, z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public void mo35807r(int i, C4454e eVar, int i2, boolean z) throws IOException {
        C4450c cVar = new C4450c();
        long j = (long) i2;
        eVar.mo22448x0(j);
        eVar.mo22377n0(cVar, j);
        if (cVar.mo22398S() == j) {
            m25455u(new C6523e("OkHttp %s Push Data[%s]", new Object[]{this.f17646e, Integer.valueOf(i)}, i, cVar, i2, z));
            return;
        }
        throw new IOException(cVar.mo22398S() + " != " + i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public void mo35808v(int i, List<C6510b> list, boolean z) {
        try {
            m25455u(new C6522d("OkHttp %s Push Headers[%s]", new Object[]{this.f17646e, Integer.valueOf(i)}, i, list, z));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: z */
    public void mo35809z(int i, List<C6510b> list) {
        synchronized (this) {
            if (this.f17662u.contains(Integer.valueOf(i))) {
                mo35798Y(i, C6509a.PROTOCOL_ERROR);
                return;
            }
            this.f17662u.add(Integer.valueOf(i));
            try {
                m25455u(new C6521c("OkHttp %s Push Request[%s]", new Object[]{this.f17646e, Integer.valueOf(i)}, i, list));
            } catch (RejectedExecutionException unused) {
            }
        }
    }
}
