package okhttp3.internal.connection;

import java.io.IOException;
import p225l.C4380a0;
import p225l.C4388c0;
import p225l.C4440x;
import p225l.C6389u;
import p225l.p226g0.p228f.C6361g;

/* renamed from: okhttp3.internal.connection.a */
/* compiled from: ConnectInterceptor */
public final class C6502a implements C6389u {

    /* renamed from: a */
    public final C4440x f17555a;

    public C6502a(C4440x xVar) {
        this.f17555a = xVar;
    }

    /* renamed from: a */
    public C4388c0 mo34066a(C6389u.C4435a aVar) throws IOException {
        C6361g gVar = (C6361g) aVar;
        C4380a0 f = gVar.mo22300f();
        C6507f k = gVar.mo35576k();
        return gVar.mo35575j(f, k, k.mo35768i(this.f17555a, aVar, !f.mo22046f().equals("GET")), k.mo35766d());
    }
}
