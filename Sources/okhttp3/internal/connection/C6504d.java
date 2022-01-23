package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import p225l.C4397e0;

/* renamed from: okhttp3.internal.connection.d */
/* compiled from: RouteDatabase */
public final class C6504d {

    /* renamed from: a */
    private final Set<C4397e0> f17560a = new LinkedHashSet();

    /* renamed from: a */
    public synchronized void mo35754a(C4397e0 e0Var) {
        this.f17560a.remove(e0Var);
    }

    /* renamed from: b */
    public synchronized void mo35755b(C4397e0 e0Var) {
        this.f17560a.add(e0Var);
    }

    /* renamed from: c */
    public synchronized boolean mo35756c(C4397e0 e0Var) {
        return this.f17560a.contains(e0Var);
    }
}
