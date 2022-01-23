package okhttp3.internal.http2;

import com.blynk.android.model.widget.other.webhook.Header;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.connection.C6507f;
import p225l.C4380a0;
import p225l.C4388c0;
import p225l.C4392d0;
import p225l.C4431s;
import p225l.C4440x;
import p225l.C6389u;
import p225l.C6390y;
import p225l.p226g0.C4401a;
import p225l.p226g0.C4402c;
import p225l.p226g0.p228f.C4407h;
import p225l.p226g0.p228f.C6356c;
import p225l.p226g0.p228f.C6359e;
import p225l.p226g0.p228f.C6362i;
import p225l.p226g0.p228f.C6364k;
import p230m.C4450c;
import p230m.C4455f;
import p230m.C4459r;
import p230m.C4460s;
import p230m.C6393h;
import p230m.C6397l;

/* renamed from: okhttp3.internal.http2.e */
/* compiled from: Http2Codec */
public final class C6516e implements C6356c {

    /* renamed from: f */
    private static final List<String> f17632f = C4402c.m17200u("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* renamed from: g */
    private static final List<String> f17633g = C4402c.m17200u("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* renamed from: a */
    private final C6389u.C4435a f17634a;

    /* renamed from: b */
    final C6507f f17635b;

    /* renamed from: c */
    private final C6518f f17636c;

    /* renamed from: d */
    private C4466h f17637d;

    /* renamed from: e */
    private final C6390y f17638e;

    /* renamed from: okhttp3.internal.http2.e$a */
    /* compiled from: Http2Codec */
    class C6517a extends C6393h {

        /* renamed from: c */
        boolean f17639c = false;

        /* renamed from: d */
        long f17640d = 0;

        C6517a(C4460s sVar) {
            super(sVar);
        }

        /* renamed from: b */
        private void m25447b(IOException iOException) {
            if (!this.f17639c) {
                this.f17639c = true;
                C6516e eVar = C6516e.this;
                eVar.f17635b.mo35774r(false, eVar, this.f17640d, iOException);
            }
        }

        public void close() throws IOException {
            super.close();
            m25447b((IOException) null);
        }

        /* renamed from: n0 */
        public long mo22377n0(C4450c cVar, long j) throws IOException {
            try {
                long n0 = mo35612a().mo22377n0(cVar, j);
                if (n0 > 0) {
                    this.f17640d += n0;
                }
                return n0;
            } catch (IOException e) {
                m25447b(e);
                throw e;
            }
        }
    }

    public C6516e(C4440x xVar, C6389u.C4435a aVar, C6507f fVar, C6518f fVar2) {
        this.f17634a = aVar;
        this.f17635b = fVar;
        this.f17636c = fVar2;
        List<C6390y> z = xVar.mo22339z();
        C6390y yVar = C6390y.H2_PRIOR_KNOWLEDGE;
        this.f17638e = !z.contains(yVar) ? C6390y.HTTP_2 : yVar;
    }

    /* renamed from: g */
    public static List<C6510b> m25439g(C4380a0 a0Var) {
        C4431s d = a0Var.mo22044d();
        ArrayList arrayList = new ArrayList(d.mo22247h() + 4);
        arrayList.add(new C6510b(C6510b.f17602f, a0Var.mo22046f()));
        arrayList.add(new C6510b(C6510b.f17603g, C6362i.m24823c(a0Var.mo22048h())));
        String c = a0Var.mo22043c("Host");
        if (c != null) {
            arrayList.add(new C6510b(C6510b.f17605i, c));
        }
        arrayList.add(new C6510b(C6510b.f17604h, a0Var.mo22048h().mo22264H()));
        int h = d.mo22247h();
        for (int i = 0; i < h; i++) {
            C4455f i2 = C4455f.m17622i(d.mo22244e(i).toLowerCase(Locale.US));
            if (!f17632f.contains(i2.mo22480y())) {
                arrayList.add(new C6510b(i2, d.mo22249i(i)));
            }
        }
        return arrayList;
    }

    /* renamed from: h */
    public static C4388c0.C4389a m25440h(C4431s sVar, C6390y yVar) throws IOException {
        C4431s.C4432a aVar = new C4431s.C4432a();
        int h = sVar.mo22247h();
        C6364k kVar = null;
        for (int i = 0; i < h; i++) {
            String e = sVar.mo22244e(i);
            String i2 = sVar.mo22249i(i);
            if (e.equals(":status")) {
                kVar = C6364k.m24834a("HTTP/1.1 " + i2);
            } else if (!f17633g.contains(e)) {
                C4401a.f12251a.mo22141b(aVar, e, i2);
            }
        }
        if (kVar != null) {
            C4388c0.C4389a aVar2 = new C4388c0.C4389a();
            aVar2.mo22090n(yVar);
            aVar2.mo22083g(kVar.f17282b);
            aVar2.mo22087k(kVar.f17283c);
            aVar2.mo22086j(aVar.mo22255d());
            return aVar2;
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    /* renamed from: a */
    public void mo35563a() throws IOException {
        this.f17637d.mo22515j().close();
    }

    /* renamed from: b */
    public void mo35564b(C4380a0 a0Var) throws IOException {
        if (this.f17637d == null) {
            C4466h q = this.f17636c.mo35806q(m25439g(a0Var), a0Var.mo22041a() != null);
            this.f17637d = q;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            q.mo22519n().mo22494g((long) this.f17634a.mo22295a(), timeUnit);
            this.f17637d.mo22526u().mo22494g((long) this.f17634a.mo22296b(), timeUnit);
        }
    }

    /* renamed from: c */
    public C4392d0 mo35565c(C4388c0 c0Var) throws IOException {
        C6507f fVar = this.f17635b;
        fVar.f17576f.mo22226q(fVar.f17575e);
        return new C4407h(c0Var.mo22068g(Header.CONTENT_TYPE), C6359e.m24798b(c0Var), C6397l.m24926b(new C6517a(this.f17637d.mo22516k())));
    }

    public void cancel() {
        C4466h hVar = this.f17637d;
        if (hVar != null) {
            hVar.mo22513h(C6509a.CANCEL);
        }
    }

    /* renamed from: d */
    public C4388c0.C4389a mo35567d(boolean z) throws IOException {
        C4388c0.C4389a h = m25440h(this.f17637d.mo22524s(), this.f17638e);
        if (!z || C4401a.f12251a.mo22143d(h) != 100) {
            return h;
        }
        return null;
    }

    /* renamed from: e */
    public void mo35568e() throws IOException {
        this.f17636c.flush();
    }

    /* renamed from: f */
    public C4459r mo35569f(C4380a0 a0Var, long j) {
        return this.f17637d.mo22515j();
    }
}
