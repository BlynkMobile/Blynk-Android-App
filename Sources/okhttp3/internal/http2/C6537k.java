package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import p230m.C4454e;

/* renamed from: okhttp3.internal.http2.k */
/* compiled from: PushObserver */
public interface C6537k {

    /* renamed from: a */
    public static final C6537k f17728a = new C6538a();

    /* renamed from: okhttp3.internal.http2.k$a */
    /* compiled from: PushObserver */
    class C6538a implements C6537k {
        C6538a() {
        }

        /* renamed from: a */
        public boolean mo35846a(int i, List<C6510b> list) {
            return true;
        }

        /* renamed from: b */
        public boolean mo35847b(int i, List<C6510b> list, boolean z) {
            return true;
        }

        /* renamed from: c */
        public void mo35848c(int i, C6509a aVar) {
        }

        /* renamed from: d */
        public boolean mo35849d(int i, C4454e eVar, int i2, boolean z) throws IOException {
            eVar.skip((long) i2);
            return true;
        }
    }

    /* renamed from: a */
    boolean mo35846a(int i, List<C6510b> list);

    /* renamed from: b */
    boolean mo35847b(int i, List<C6510b> list, boolean z);

    /* renamed from: c */
    void mo35848c(int i, C6509a aVar);

    /* renamed from: d */
    boolean mo35849d(int i, C4454e eVar, int i2, boolean z) throws IOException;
}
