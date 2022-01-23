package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.http2.C6510b;
import p225l.C4431s;
import p225l.p226g0.C4402c;
import p230m.C4446a;
import p230m.C4450c;
import p230m.C4454e;
import p230m.C4459r;
import p230m.C4460s;
import p230m.C4461t;

/* renamed from: okhttp3.internal.http2.h */
/* compiled from: Http2Stream */
public final class C4466h {

    /* renamed from: a */
    long f12520a = 0;

    /* renamed from: b */
    long f12521b;

    /* renamed from: c */
    final int f12522c;

    /* renamed from: d */
    final C6518f f12523d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Deque<C4431s> f12524e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C6510b.C6511a f12525f;

    /* renamed from: g */
    private boolean f12526g;

    /* renamed from: h */
    private final C4468b f12527h;

    /* renamed from: i */
    final C4467a f12528i;

    /* renamed from: j */
    final C4469c f12529j;

    /* renamed from: k */
    final C4469c f12530k;

    /* renamed from: l */
    C6509a f12531l;

    /* renamed from: okhttp3.internal.http2.h$a */
    /* compiled from: Http2Stream */
    final class C4467a implements C4459r {

        /* renamed from: b */
        private final C4450c f12532b = new C4450c();

        /* renamed from: c */
        boolean f12533c;

        /* renamed from: d */
        boolean f12534d;

        C4467a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            r1.f12530k.mo22528u();
            r11.f12535e.mo22511e();
            r9 = java.lang.Math.min(r11.f12535e.f12521b, r11.f12532b.mo22398S());
            r1 = r11.f12535e;
            r1.f12521b -= r9;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void m17709a(boolean r12) throws java.io.IOException {
            /*
                r11 = this;
                okhttp3.internal.http2.h r0 = okhttp3.internal.http2.C4466h.this
                monitor-enter(r0)
                okhttp3.internal.http2.h r1 = okhttp3.internal.http2.C4466h.this     // Catch:{ all -> 0x007f }
                okhttp3.internal.http2.h$c r1 = r1.f12530k     // Catch:{ all -> 0x007f }
                r1.mo22363k()     // Catch:{ all -> 0x007f }
            L_0x000a:
                okhttp3.internal.http2.h r1 = okhttp3.internal.http2.C4466h.this     // Catch:{ all -> 0x0076 }
                long r2 = r1.f12521b     // Catch:{ all -> 0x0076 }
                r4 = 0
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 > 0) goto L_0x0024
                boolean r2 = r11.f12534d     // Catch:{ all -> 0x0076 }
                if (r2 != 0) goto L_0x0024
                boolean r2 = r11.f12533c     // Catch:{ all -> 0x0076 }
                if (r2 != 0) goto L_0x0024
                okhttp3.internal.http2.a r2 = r1.f12531l     // Catch:{ all -> 0x0076 }
                if (r2 != 0) goto L_0x0024
                r1.mo22525t()     // Catch:{ all -> 0x0076 }
                goto L_0x000a
            L_0x0024:
                okhttp3.internal.http2.h$c r1 = r1.f12530k     // Catch:{ all -> 0x007f }
                r1.mo22528u()     // Catch:{ all -> 0x007f }
                okhttp3.internal.http2.h r1 = okhttp3.internal.http2.C4466h.this     // Catch:{ all -> 0x007f }
                r1.mo22511e()     // Catch:{ all -> 0x007f }
                okhttp3.internal.http2.h r1 = okhttp3.internal.http2.C4466h.this     // Catch:{ all -> 0x007f }
                long r1 = r1.f12521b     // Catch:{ all -> 0x007f }
                m.c r3 = r11.f12532b     // Catch:{ all -> 0x007f }
                long r3 = r3.mo22398S()     // Catch:{ all -> 0x007f }
                long r9 = java.lang.Math.min(r1, r3)     // Catch:{ all -> 0x007f }
                okhttp3.internal.http2.h r1 = okhttp3.internal.http2.C4466h.this     // Catch:{ all -> 0x007f }
                long r2 = r1.f12521b     // Catch:{ all -> 0x007f }
                long r2 = r2 - r9
                r1.f12521b = r2     // Catch:{ all -> 0x007f }
                monitor-exit(r0)     // Catch:{ all -> 0x007f }
                okhttp3.internal.http2.h$c r0 = r1.f12530k
                r0.mo22363k()
                okhttp3.internal.http2.h r0 = okhttp3.internal.http2.C4466h.this     // Catch:{ all -> 0x006d }
                okhttp3.internal.http2.f r5 = r0.f12523d     // Catch:{ all -> 0x006d }
                int r6 = r0.f12522c     // Catch:{ all -> 0x006d }
                if (r12 == 0) goto L_0x005e
                m.c r12 = r11.f12532b     // Catch:{ all -> 0x006d }
                long r0 = r12.mo22398S()     // Catch:{ all -> 0x006d }
                int r12 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r12 != 0) goto L_0x005e
                r12 = 1
                r7 = 1
                goto L_0x0060
            L_0x005e:
                r12 = 0
                r7 = 0
            L_0x0060:
                m.c r8 = r11.f12532b     // Catch:{ all -> 0x006d }
                r5.mo35795S(r6, r7, r8, r9)     // Catch:{ all -> 0x006d }
                okhttp3.internal.http2.h r12 = okhttp3.internal.http2.C4466h.this
                okhttp3.internal.http2.h$c r12 = r12.f12530k
                r12.mo22528u()
                return
            L_0x006d:
                r12 = move-exception
                okhttp3.internal.http2.h r0 = okhttp3.internal.http2.C4466h.this
                okhttp3.internal.http2.h$c r0 = r0.f12530k
                r0.mo22528u()
                throw r12
            L_0x0076:
                r12 = move-exception
                okhttp3.internal.http2.h r1 = okhttp3.internal.http2.C4466h.this     // Catch:{ all -> 0x007f }
                okhttp3.internal.http2.h$c r1 = r1.f12530k     // Catch:{ all -> 0x007f }
                r1.mo22528u()     // Catch:{ all -> 0x007f }
                throw r12     // Catch:{ all -> 0x007f }
            L_0x007f:
                r12 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x007f }
                goto L_0x0083
            L_0x0082:
                throw r12
            L_0x0083:
                goto L_0x0082
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.C4466h.C4467a.m17709a(boolean):void");
        }

        /* renamed from: O */
        public void mo22370O(C4450c cVar, long j) throws IOException {
            this.f12532b.mo22370O(cVar, j);
            while (this.f12532b.mo22398S() >= 16384) {
                m17709a(false);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
            if (r8.f12532b.mo22398S() <= 0) goto L_0x002d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
            if (r8.f12532b.mo22398S() <= 0) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
            m17709a(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x002d, code lost:
            r0 = r8.f12535e;
            r0.f12523d.mo35795S(r0.f12522c, true, (p230m.C4450c) null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x003a, code lost:
            r2 = r8.f12535e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r8.f12533c = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003f, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0040, code lost:
            r8.f12535e.f12523d.flush();
            r8.f12535e.mo22510d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x004c, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
            if (r8.f12535e.f12528i.f12534d != false) goto L_0x003a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() throws java.io.IOException {
            /*
                r8 = this;
                okhttp3.internal.http2.h r0 = okhttp3.internal.http2.C4466h.this
                monitor-enter(r0)
                boolean r1 = r8.f12533c     // Catch:{ all -> 0x0050 }
                if (r1 == 0) goto L_0x0009
                monitor-exit(r0)     // Catch:{ all -> 0x0050 }
                return
            L_0x0009:
                monitor-exit(r0)     // Catch:{ all -> 0x0050 }
                okhttp3.internal.http2.h r0 = okhttp3.internal.http2.C4466h.this
                okhttp3.internal.http2.h$a r0 = r0.f12528i
                boolean r0 = r0.f12534d
                r1 = 1
                if (r0 != 0) goto L_0x003a
                m.c r0 = r8.f12532b
                long r2 = r0.mo22398S()
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x002d
            L_0x001f:
                m.c r0 = r8.f12532b
                long r2 = r0.mo22398S()
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x003a
                r8.m17709a(r1)
                goto L_0x001f
            L_0x002d:
                okhttp3.internal.http2.h r0 = okhttp3.internal.http2.C4466h.this
                okhttp3.internal.http2.f r2 = r0.f12523d
                int r3 = r0.f12522c
                r4 = 1
                r5 = 0
                r6 = 0
                r2.mo35795S(r3, r4, r5, r6)
            L_0x003a:
                okhttp3.internal.http2.h r2 = okhttp3.internal.http2.C4466h.this
                monitor-enter(r2)
                r8.f12533c = r1     // Catch:{ all -> 0x004d }
                monitor-exit(r2)     // Catch:{ all -> 0x004d }
                okhttp3.internal.http2.h r0 = okhttp3.internal.http2.C4466h.this
                okhttp3.internal.http2.f r0 = r0.f12523d
                r0.flush()
                okhttp3.internal.http2.h r0 = okhttp3.internal.http2.C4466h.this
                r0.mo22510d()
                return
            L_0x004d:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x004d }
                throw r0
            L_0x0050:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0050 }
                goto L_0x0054
            L_0x0053:
                throw r1
            L_0x0054:
                goto L_0x0053
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.C4466h.C4467a.close():void");
        }

        /* renamed from: e */
        public C4461t mo22372e() {
            return C4466h.this.f12530k;
        }

        public void flush() throws IOException {
            synchronized (C4466h.this) {
                C4466h.this.mo22511e();
            }
            while (this.f12532b.mo22398S() > 0) {
                m17709a(false);
                C4466h.this.f12523d.flush();
            }
        }
    }

    /* renamed from: okhttp3.internal.http2.h$b */
    /* compiled from: Http2Stream */
    private final class C4468b implements C4460s {

        /* renamed from: b */
        private final C4450c f12536b = new C4450c();

        /* renamed from: c */
        private final C4450c f12537c = new C4450c();

        /* renamed from: d */
        private final long f12538d;

        /* renamed from: e */
        boolean f12539e;

        /* renamed from: f */
        boolean f12540f;

        C4468b(long j) {
            this.f12538d = j;
        }

        /* renamed from: b */
        private void m17712b(long j) {
            C4466h.this.f12523d.mo35794M(j);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo22527a(C4454e eVar, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            while (j > 0) {
                synchronized (C4466h.this) {
                    z = this.f12540f;
                    z2 = true;
                    z3 = this.f12537c.mo22398S() + j > this.f12538d;
                }
                if (z3) {
                    eVar.skip(j);
                    C4466h.this.mo22513h(C6509a.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    eVar.skip(j);
                    return;
                } else {
                    long n0 = eVar.mo22377n0(this.f12536b, j);
                    if (n0 != -1) {
                        j -= n0;
                        synchronized (C4466h.this) {
                            if (this.f12537c.mo22398S() != 0) {
                                z2 = false;
                            }
                            this.f12537c.mo22396P(this.f12536b);
                            if (z2) {
                                C4466h.this.notifyAll();
                            }
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }

        public void close() throws IOException {
            long S;
            C6510b.C6511a aVar;
            ArrayList<C4431s> arrayList;
            synchronized (C4466h.this) {
                this.f12539e = true;
                S = this.f12537c.mo22398S();
                this.f12537c.mo22404a();
                aVar = null;
                if (C4466h.this.f12524e.isEmpty() || C4466h.this.f12525f == null) {
                    arrayList = null;
                } else {
                    ArrayList arrayList2 = new ArrayList(C4466h.this.f12524e);
                    C4466h.this.f12524e.clear();
                    ArrayList arrayList3 = arrayList2;
                    aVar = C4466h.this.f12525f;
                    arrayList = arrayList3;
                }
                C4466h.this.notifyAll();
            }
            if (S > 0) {
                m17712b(S);
            }
            C4466h.this.mo22510d();
            if (aVar != null) {
                for (C4431s a : arrayList) {
                    aVar.mo35779a(a);
                }
            }
        }

        /* renamed from: e */
        public C4461t mo22376e() {
            return C4466h.this.f12529j;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v33, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: l.s} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: n0 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long mo22377n0(p230m.C4450c r17, long r18) throws java.io.IOException {
            /*
                r16 = this;
                r1 = r16
                r2 = r18
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 < 0) goto L_0x00e0
            L_0x000a:
                okhttp3.internal.http2.h r6 = okhttp3.internal.http2.C4466h.this
                monitor-enter(r6)
                okhttp3.internal.http2.h r0 = okhttp3.internal.http2.C4466h.this     // Catch:{ all -> 0x00dd }
                okhttp3.internal.http2.h$c r0 = r0.f12529j     // Catch:{ all -> 0x00dd }
                r0.mo22363k()     // Catch:{ all -> 0x00dd }
                okhttp3.internal.http2.h r0 = okhttp3.internal.http2.C4466h.this     // Catch:{ all -> 0x00d4 }
                okhttp3.internal.http2.a r7 = r0.f12531l     // Catch:{ all -> 0x00d4 }
                if (r7 == 0) goto L_0x001b
                goto L_0x001c
            L_0x001b:
                r7 = 0
            L_0x001c:
                boolean r9 = r1.f12539e     // Catch:{ all -> 0x00d4 }
                if (r9 != 0) goto L_0x00cc
                java.util.Deque r0 = r0.f12524e     // Catch:{ all -> 0x00d4 }
                boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x00d4 }
                if (r0 != 0) goto L_0x0049
                okhttp3.internal.http2.h r0 = okhttp3.internal.http2.C4466h.this     // Catch:{ all -> 0x00d4 }
                okhttp3.internal.http2.b$a r0 = r0.f12525f     // Catch:{ all -> 0x00d4 }
                if (r0 == 0) goto L_0x0049
                okhttp3.internal.http2.h r0 = okhttp3.internal.http2.C4466h.this     // Catch:{ all -> 0x00d4 }
                java.util.Deque r0 = r0.f12524e     // Catch:{ all -> 0x00d4 }
                java.lang.Object r0 = r0.removeFirst()     // Catch:{ all -> 0x00d4 }
                r8 = r0
                l.s r8 = (p225l.C4431s) r8     // Catch:{ all -> 0x00d4 }
                okhttp3.internal.http2.h r0 = okhttp3.internal.http2.C4466h.this     // Catch:{ all -> 0x00d4 }
                okhttp3.internal.http2.b$a r0 = r0.f12525f     // Catch:{ all -> 0x00d4 }
                r13 = r17
                r10 = r0
                goto L_0x00a6
            L_0x0049:
                m.c r0 = r1.f12537c     // Catch:{ all -> 0x00d4 }
                long r11 = r0.mo22398S()     // Catch:{ all -> 0x00d4 }
                int r0 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x008d
                m.c r0 = r1.f12537c     // Catch:{ all -> 0x00d4 }
                long r11 = r0.mo22398S()     // Catch:{ all -> 0x00d4 }
                long r11 = java.lang.Math.min(r2, r11)     // Catch:{ all -> 0x00d4 }
                r13 = r17
                long r11 = r0.mo22377n0(r13, r11)     // Catch:{ all -> 0x00d4 }
                okhttp3.internal.http2.h r0 = okhttp3.internal.http2.C4466h.this     // Catch:{ all -> 0x00d4 }
                long r14 = r0.f12520a     // Catch:{ all -> 0x00d4 }
                long r14 = r14 + r11
                r0.f12520a = r14     // Catch:{ all -> 0x00d4 }
                if (r7 != 0) goto L_0x008a
                okhttp3.internal.http2.f r0 = r0.f12523d     // Catch:{ all -> 0x00d4 }
                okhttp3.internal.http2.l r0 = r0.f17656o     // Catch:{ all -> 0x00d4 }
                int r0 = r0.mo35853d()     // Catch:{ all -> 0x00d4 }
                int r0 = r0 / 2
                long r8 = (long) r0     // Catch:{ all -> 0x00d4 }
                int r0 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
                if (r0 < 0) goto L_0x008a
                okhttp3.internal.http2.h r0 = okhttp3.internal.http2.C4466h.this     // Catch:{ all -> 0x00d4 }
                okhttp3.internal.http2.f r8 = r0.f12523d     // Catch:{ all -> 0x00d4 }
                int r9 = r0.f12522c     // Catch:{ all -> 0x00d4 }
                long r14 = r0.f12520a     // Catch:{ all -> 0x00d4 }
                r8.mo35800d0(r9, r14)     // Catch:{ all -> 0x00d4 }
                okhttp3.internal.http2.h r0 = okhttp3.internal.http2.C4466h.this     // Catch:{ all -> 0x00d4 }
                r0.f12520a = r4     // Catch:{ all -> 0x00d4 }
            L_0x008a:
                r8 = 0
                r10 = 0
                goto L_0x00a8
            L_0x008d:
                r13 = r17
                boolean r0 = r1.f12540f     // Catch:{ all -> 0x00d4 }
                if (r0 != 0) goto L_0x00a4
                if (r7 != 0) goto L_0x00a4
                okhttp3.internal.http2.h r0 = okhttp3.internal.http2.C4466h.this     // Catch:{ all -> 0x00d4 }
                r0.mo22525t()     // Catch:{ all -> 0x00d4 }
                okhttp3.internal.http2.h r0 = okhttp3.internal.http2.C4466h.this     // Catch:{ all -> 0x00dd }
                okhttp3.internal.http2.h$c r0 = r0.f12529j     // Catch:{ all -> 0x00dd }
                r0.mo22528u()     // Catch:{ all -> 0x00dd }
                monitor-exit(r6)     // Catch:{ all -> 0x00dd }
                goto L_0x000a
            L_0x00a4:
                r8 = 0
                r10 = 0
            L_0x00a6:
                r11 = -1
            L_0x00a8:
                okhttp3.internal.http2.h r0 = okhttp3.internal.http2.C4466h.this     // Catch:{ all -> 0x00dd }
                okhttp3.internal.http2.h$c r0 = r0.f12529j     // Catch:{ all -> 0x00dd }
                r0.mo22528u()     // Catch:{ all -> 0x00dd }
                monitor-exit(r6)     // Catch:{ all -> 0x00dd }
                if (r8 == 0) goto L_0x00b9
                if (r10 == 0) goto L_0x00b9
                r10.mo35779a(r8)
                goto L_0x000a
            L_0x00b9:
                r2 = -1
                int r0 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
                if (r0 == 0) goto L_0x00c3
                r1.m17712b(r11)
                return r11
            L_0x00c3:
                if (r7 != 0) goto L_0x00c6
                return r2
            L_0x00c6:
                okhttp3.internal.http2.StreamResetException r0 = new okhttp3.internal.http2.StreamResetException
                r0.<init>(r7)
                throw r0
            L_0x00cc:
                java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00d4 }
                java.lang.String r2 = "stream closed"
                r0.<init>(r2)     // Catch:{ all -> 0x00d4 }
                throw r0     // Catch:{ all -> 0x00d4 }
            L_0x00d4:
                r0 = move-exception
                okhttp3.internal.http2.h r2 = okhttp3.internal.http2.C4466h.this     // Catch:{ all -> 0x00dd }
                okhttp3.internal.http2.h$c r2 = r2.f12529j     // Catch:{ all -> 0x00dd }
                r2.mo22528u()     // Catch:{ all -> 0x00dd }
                throw r0     // Catch:{ all -> 0x00dd }
            L_0x00dd:
                r0 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x00dd }
                throw r0
            L_0x00e0:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "byteCount < 0: "
                r4.append(r5)
                r4.append(r2)
                java.lang.String r2 = r4.toString()
                r0.<init>(r2)
                goto L_0x00f8
            L_0x00f7:
                throw r0
            L_0x00f8:
                goto L_0x00f7
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.C4466h.C4468b.mo22377n0(m.c, long):long");
        }
    }

    /* renamed from: okhttp3.internal.http2.h$c */
    /* compiled from: Http2Stream */
    class C4469c extends C4446a {
        C4469c() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: o */
        public IOException mo22367o(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* access modifiers changed from: protected */
        /* renamed from: t */
        public void mo22358t() {
            C4466h.this.mo22513h(C6509a.CANCEL);
        }

        /* renamed from: u */
        public void mo22528u() throws IOException {
            if (mo22366n()) {
                throw mo22367o((IOException) null);
            }
        }
    }

    C4466h(int i, C6518f fVar, boolean z, boolean z2, @Nullable C4431s sVar) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f12524e = arrayDeque;
        this.f12529j = new C4469c();
        this.f12530k = new C4469c();
        this.f12531l = null;
        if (fVar != null) {
            this.f12522c = i;
            this.f12523d = fVar;
            this.f12521b = (long) fVar.f17657p.mo35853d();
            C4468b bVar = new C4468b((long) fVar.f17656o.mo35853d());
            this.f12527h = bVar;
            C4467a aVar = new C4467a();
            this.f12528i = aVar;
            bVar.f12540f = z2;
            aVar.f12534d = z;
            if (sVar != null) {
                arrayDeque.add(sVar);
            }
            if (mo22517l() && sVar != null) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            } else if (!mo22517l() && sVar == null) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            throw new NullPointerException("connection == null");
        }
    }

    /* renamed from: g */
    private boolean m17690g(C6509a aVar) {
        synchronized (this) {
            if (this.f12531l != null) {
                return false;
            }
            if (this.f12527h.f12540f && this.f12528i.f12534d) {
                return false;
            }
            this.f12531l = aVar;
            notifyAll();
            this.f12523d.mo35790F(this.f12522c);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo22509c(long j) {
        this.f12521b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo22510d() throws IOException {
        boolean z;
        boolean m;
        synchronized (this) {
            C4468b bVar = this.f12527h;
            if (!bVar.f12540f && bVar.f12539e) {
                C4467a aVar = this.f12528i;
                if (aVar.f12534d || aVar.f12533c) {
                    z = true;
                    m = mo22518m();
                }
            }
            z = false;
            m = mo22518m();
        }
        if (z) {
            mo22512f(C6509a.CANCEL);
        } else if (!m) {
            this.f12523d.mo35790F(this.f12522c);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo22511e() throws IOException {
        C4467a aVar = this.f12528i;
        if (aVar.f12533c) {
            throw new IOException("stream closed");
        } else if (aVar.f12534d) {
            throw new IOException("stream finished");
        } else if (this.f12531l != null) {
            throw new StreamResetException(this.f12531l);
        }
    }

    /* renamed from: f */
    public void mo22512f(C6509a aVar) throws IOException {
        if (m17690g(aVar)) {
            this.f12523d.mo35797X(this.f12522c, aVar);
        }
    }

    /* renamed from: h */
    public void mo22513h(C6509a aVar) {
        if (m17690g(aVar)) {
            this.f12523d.mo35798Y(this.f12522c, aVar);
        }
    }

    /* renamed from: i */
    public int mo22514i() {
        return this.f12522c;
    }

    /* renamed from: j */
    public C4459r mo22515j() {
        synchronized (this) {
            if (!this.f12526g) {
                if (!mo22517l()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
        }
        return this.f12528i;
    }

    /* renamed from: k */
    public C4460s mo22516k() {
        return this.f12527h;
    }

    /* renamed from: l */
    public boolean mo22517l() {
        if (this.f12523d.f17643b == ((this.f12522c & 1) == 1)) {
            return true;
        }
        return false;
    }

    /* renamed from: m */
    public synchronized boolean mo22518m() {
        if (this.f12531l != null) {
            return false;
        }
        C4468b bVar = this.f12527h;
        if (bVar.f12540f || bVar.f12539e) {
            C4467a aVar = this.f12528i;
            if ((aVar.f12534d || aVar.f12533c) && this.f12526g) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: n */
    public C4461t mo22519n() {
        return this.f12529j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public void mo22520o(C4454e eVar, int i) throws IOException {
        this.f12527h.mo22527a(eVar, (long) i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public void mo22521p() {
        boolean m;
        synchronized (this) {
            this.f12527h.f12540f = true;
            m = mo22518m();
            notifyAll();
        }
        if (!m) {
            this.f12523d.mo35790F(this.f12522c);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public void mo22522q(List<C6510b> list) {
        boolean m;
        synchronized (this) {
            this.f12526g = true;
            this.f12524e.add(C4402c.m17177H(list));
            m = mo22518m();
            notifyAll();
        }
        if (!m) {
            this.f12523d.mo35790F(this.f12522c);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public synchronized void mo22523r(C6509a aVar) {
        if (this.f12531l == null) {
            this.f12531l = aVar;
            notifyAll();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
        r2.f12529j.mo22528u();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* renamed from: s */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized p225l.C4431s mo22524s() throws java.io.IOException {
        /*
            r2 = this;
            monitor-enter(r2)
            okhttp3.internal.http2.h$c r0 = r2.f12529j     // Catch:{ all -> 0x003c }
            r0.mo22363k()     // Catch:{ all -> 0x003c }
        L_0x0006:
            java.util.Deque<l.s> r0 = r2.f12524e     // Catch:{ all -> 0x0035 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0016
            okhttp3.internal.http2.a r0 = r2.f12531l     // Catch:{ all -> 0x0035 }
            if (r0 != 0) goto L_0x0016
            r2.mo22525t()     // Catch:{ all -> 0x0035 }
            goto L_0x0006
        L_0x0016:
            okhttp3.internal.http2.h$c r0 = r2.f12529j     // Catch:{ all -> 0x003c }
            r0.mo22528u()     // Catch:{ all -> 0x003c }
            java.util.Deque<l.s> r0 = r2.f12524e     // Catch:{ all -> 0x003c }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x003c }
            if (r0 != 0) goto L_0x002d
            java.util.Deque<l.s> r0 = r2.f12524e     // Catch:{ all -> 0x003c }
            java.lang.Object r0 = r0.removeFirst()     // Catch:{ all -> 0x003c }
            l.s r0 = (p225l.C4431s) r0     // Catch:{ all -> 0x003c }
            monitor-exit(r2)
            return r0
        L_0x002d:
            okhttp3.internal.http2.StreamResetException r0 = new okhttp3.internal.http2.StreamResetException     // Catch:{ all -> 0x003c }
            okhttp3.internal.http2.a r1 = r2.f12531l     // Catch:{ all -> 0x003c }
            r0.<init>(r1)     // Catch:{ all -> 0x003c }
            throw r0     // Catch:{ all -> 0x003c }
        L_0x0035:
            r0 = move-exception
            okhttp3.internal.http2.h$c r1 = r2.f12529j     // Catch:{ all -> 0x003c }
            r1.mo22528u()     // Catch:{ all -> 0x003c }
            throw r0     // Catch:{ all -> 0x003c }
        L_0x003c:
            r0 = move-exception
            monitor-exit(r2)
            goto L_0x0040
        L_0x003f:
            throw r0
        L_0x0040:
            goto L_0x003f
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.C4466h.mo22524s():l.s");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public void mo22525t() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    /* renamed from: u */
    public C4461t mo22526u() {
        return this.f12530k;
    }
}
