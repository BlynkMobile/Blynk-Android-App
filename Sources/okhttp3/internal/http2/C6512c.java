package okhttp3.internal.http2;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.danlew.android.joda.DateUtils;
import p225l.p226g0.C4402c;
import p230m.C4450c;
import p230m.C4454e;
import p230m.C4455f;
import p230m.C4460s;
import p230m.C6397l;

/* renamed from: okhttp3.internal.http2.c */
/* compiled from: Hpack */
final class C6512c {

    /* renamed from: a */
    static final C6510b[] f17609a;

    /* renamed from: b */
    static final Map<C4455f, Integer> f17610b = m25409b();

    /* renamed from: okhttp3.internal.http2.c$a */
    /* compiled from: Hpack */
    static final class C6513a {

        /* renamed from: a */
        private final List<C6510b> f17611a;

        /* renamed from: b */
        private final C4454e f17612b;

        /* renamed from: c */
        private final int f17613c;

        /* renamed from: d */
        private int f17614d;

        /* renamed from: e */
        C6510b[] f17615e;

        /* renamed from: f */
        int f17616f;

        /* renamed from: g */
        int f17617g;

        /* renamed from: h */
        int f17618h;

        C6513a(int i, C4460s sVar) {
            this(i, i, sVar);
        }

        /* renamed from: a */
        private void m25410a() {
            int i = this.f17614d;
            int i2 = this.f17618h;
            if (i >= i2) {
                return;
            }
            if (i == 0) {
                m25411b();
            } else {
                m25413d(i2 - i);
            }
        }

        /* renamed from: b */
        private void m25411b() {
            Arrays.fill(this.f17615e, (Object) null);
            this.f17616f = this.f17615e.length - 1;
            this.f17617g = 0;
            this.f17618h = 0;
        }

        /* renamed from: c */
        private int m25412c(int i) {
            return this.f17616f + 1 + i;
        }

        /* renamed from: d */
        private int m25413d(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.f17615e.length;
                while (true) {
                    length--;
                    i2 = this.f17616f;
                    if (length < i2 || i <= 0) {
                        C6510b[] bVarArr = this.f17615e;
                        System.arraycopy(bVarArr, i2 + 1, bVarArr, i2 + 1 + i3, this.f17617g);
                        this.f17616f += i3;
                    } else {
                        C6510b[] bVarArr2 = this.f17615e;
                        i -= bVarArr2[length].f17608c;
                        this.f17618h -= bVarArr2[length].f17608c;
                        this.f17617g--;
                        i3++;
                    }
                }
                C6510b[] bVarArr3 = this.f17615e;
                System.arraycopy(bVarArr3, i2 + 1, bVarArr3, i2 + 1 + i3, this.f17617g);
                this.f17616f += i3;
            }
            return i3;
        }

        /* renamed from: f */
        private C4455f m25414f(int i) throws IOException {
            if (m25416h(i)) {
                return C6512c.f17609a[i].f17606a;
            }
            int c = m25412c(i - C6512c.f17609a.length);
            if (c >= 0) {
                C6510b[] bVarArr = this.f17615e;
                if (c < bVarArr.length) {
                    return bVarArr[c].f17606a;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        /* renamed from: g */
        private void m25415g(int i, C6510b bVar) {
            this.f17611a.add(bVar);
            int i2 = bVar.f17608c;
            if (i != -1) {
                i2 -= this.f17615e[m25412c(i)].f17608c;
            }
            int i3 = this.f17614d;
            if (i2 > i3) {
                m25411b();
                return;
            }
            int d = m25413d((this.f17618h + i2) - i3);
            if (i == -1) {
                int i4 = this.f17617g + 1;
                C6510b[] bVarArr = this.f17615e;
                if (i4 > bVarArr.length) {
                    C6510b[] bVarArr2 = new C6510b[(bVarArr.length * 2)];
                    System.arraycopy(bVarArr, 0, bVarArr2, bVarArr.length, bVarArr.length);
                    this.f17616f = this.f17615e.length - 1;
                    this.f17615e = bVarArr2;
                }
                int i5 = this.f17616f;
                this.f17616f = i5 - 1;
                this.f17615e[i5] = bVar;
                this.f17617g++;
            } else {
                this.f17615e[i + m25412c(i) + d] = bVar;
            }
            this.f17618h += i2;
        }

        /* renamed from: h */
        private boolean m25416h(int i) {
            return i >= 0 && i <= C6512c.f17609a.length - 1;
        }

        /* renamed from: i */
        private int m25417i() throws IOException {
            return this.f17612b.readByte() & 255;
        }

        /* renamed from: l */
        private void m25418l(int i) throws IOException {
            if (m25416h(i)) {
                this.f17611a.add(C6512c.f17609a[i]);
                return;
            }
            int c = m25412c(i - C6512c.f17609a.length);
            if (c >= 0) {
                C6510b[] bVarArr = this.f17615e;
                if (c < bVarArr.length) {
                    this.f17611a.add(bVarArr[c]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        /* renamed from: n */
        private void m25419n(int i) throws IOException {
            m25415g(-1, new C6510b(m25414f(i), mo35781j()));
        }

        /* renamed from: o */
        private void m25420o() throws IOException {
            C4455f j = mo35781j();
            C6512c.m25408a(j);
            m25415g(-1, new C6510b(j, mo35781j()));
        }

        /* renamed from: p */
        private void m25421p(int i) throws IOException {
            this.f17611a.add(new C6510b(m25414f(i), mo35781j()));
        }

        /* renamed from: q */
        private void m25422q() throws IOException {
            C4455f j = mo35781j();
            C6512c.m25408a(j);
            this.f17611a.add(new C6510b(j, mo35781j()));
        }

        /* renamed from: e */
        public List<C6510b> mo35780e() {
            ArrayList arrayList = new ArrayList(this.f17611a);
            this.f17611a.clear();
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public C4455f mo35781j() throws IOException {
            int i = m25417i();
            boolean z = (i & 128) == 128;
            int m = mo35783m(i, 127);
            if (z) {
                return C4455f.m17623m(C6535j.m25548f().mo35843c(this.f17612b.mo22406b0((long) m)));
            }
            return this.f17612b.mo22420l((long) m);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public void mo35782k() throws IOException {
            while (!this.f17612b.mo22447x()) {
                byte readByte = this.f17612b.readByte() & 255;
                if (readByte == 128) {
                    throw new IOException("index == 0");
                } else if ((readByte & 128) == 128) {
                    m25418l(mo35783m(readByte, 127) - 1);
                } else if (readByte == 64) {
                    m25420o();
                } else if ((readByte & 64) == 64) {
                    m25419n(mo35783m(readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int m = mo35783m(readByte, 31);
                    this.f17614d = m;
                    if (m < 0 || m > this.f17613c) {
                        throw new IOException("Invalid dynamic table size update " + this.f17614d);
                    }
                    m25410a();
                } else if (readByte == 16 || readByte == 0) {
                    m25422q();
                } else {
                    m25421p(mo35783m(readByte, 15) - 1);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: m */
        public int mo35783m(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int i5 = m25417i();
                if ((i5 & 128) == 0) {
                    return i2 + (i5 << i4);
                }
                i2 += (i5 & 127) << i4;
                i4 += 7;
            }
        }

        C6513a(int i, int i2, C4460s sVar) {
            this.f17611a = new ArrayList();
            C6510b[] bVarArr = new C6510b[8];
            this.f17615e = bVarArr;
            this.f17616f = bVarArr.length - 1;
            this.f17617g = 0;
            this.f17618h = 0;
            this.f17613c = i;
            this.f17614d = i2;
            this.f17612b = C6397l.m24926b(sVar);
        }
    }

    /* renamed from: okhttp3.internal.http2.c$b */
    /* compiled from: Hpack */
    static final class C6514b {

        /* renamed from: a */
        private final C4450c f17619a;

        /* renamed from: b */
        private final boolean f17620b;

        /* renamed from: c */
        private int f17621c;

        /* renamed from: d */
        private boolean f17622d;

        /* renamed from: e */
        int f17623e;

        /* renamed from: f */
        C6510b[] f17624f;

        /* renamed from: g */
        int f17625g;

        /* renamed from: h */
        int f17626h;

        /* renamed from: i */
        int f17627i;

        C6514b(C4450c cVar) {
            this(4096, true, cVar);
        }

        /* renamed from: a */
        private void m25427a() {
            int i = this.f17623e;
            int i2 = this.f17627i;
            if (i >= i2) {
                return;
            }
            if (i == 0) {
                m25428b();
            } else {
                m25429c(i2 - i);
            }
        }

        /* renamed from: b */
        private void m25428b() {
            Arrays.fill(this.f17624f, (Object) null);
            this.f17625g = this.f17624f.length - 1;
            this.f17626h = 0;
            this.f17627i = 0;
        }

        /* renamed from: c */
        private int m25429c(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.f17624f.length;
                while (true) {
                    length--;
                    i2 = this.f17625g;
                    if (length < i2 || i <= 0) {
                        C6510b[] bVarArr = this.f17624f;
                        System.arraycopy(bVarArr, i2 + 1, bVarArr, i2 + 1 + i3, this.f17626h);
                        C6510b[] bVarArr2 = this.f17624f;
                        int i4 = this.f17625g;
                        Arrays.fill(bVarArr2, i4 + 1, i4 + 1 + i3, (Object) null);
                        this.f17625g += i3;
                    } else {
                        C6510b[] bVarArr3 = this.f17624f;
                        i -= bVarArr3[length].f17608c;
                        this.f17627i -= bVarArr3[length].f17608c;
                        this.f17626h--;
                        i3++;
                    }
                }
                C6510b[] bVarArr4 = this.f17624f;
                System.arraycopy(bVarArr4, i2 + 1, bVarArr4, i2 + 1 + i3, this.f17626h);
                C6510b[] bVarArr22 = this.f17624f;
                int i42 = this.f17625g;
                Arrays.fill(bVarArr22, i42 + 1, i42 + 1 + i3, (Object) null);
                this.f17625g += i3;
            }
            return i3;
        }

        /* renamed from: d */
        private void m25430d(C6510b bVar) {
            int i = bVar.f17608c;
            int i2 = this.f17623e;
            if (i > i2) {
                m25428b();
                return;
            }
            m25429c((this.f17627i + i) - i2);
            int i3 = this.f17626h + 1;
            C6510b[] bVarArr = this.f17624f;
            if (i3 > bVarArr.length) {
                C6510b[] bVarArr2 = new C6510b[(bVarArr.length * 2)];
                System.arraycopy(bVarArr, 0, bVarArr2, bVarArr.length, bVarArr.length);
                this.f17625g = this.f17624f.length - 1;
                this.f17624f = bVarArr2;
            }
            int i4 = this.f17625g;
            this.f17625g = i4 - 1;
            this.f17624f[i4] = bVar;
            this.f17626h++;
            this.f17627i += i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo35784e(int i) {
            int min = Math.min(i, DateUtils.FORMAT_ABBREV_TIME);
            int i2 = this.f17623e;
            if (i2 != min) {
                if (min < i2) {
                    this.f17621c = Math.min(this.f17621c, min);
                }
                this.f17622d = true;
                this.f17623e = min;
                m25427a();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public void mo35785f(C4455f fVar) throws IOException {
            if (!this.f17620b || C6535j.m25548f().mo35845e(fVar) >= fVar.size()) {
                mo35787h(fVar.size(), 127, 0);
                this.f17619a.mo22409d0(fVar);
                return;
            }
            C4450c cVar = new C4450c();
            C6535j.m25548f().mo35844d(fVar, cVar);
            C4455f A = cVar.mo22380A();
            mo35787h(A.size(), 127, 128);
            this.f17619a.mo22409d0(A);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public void mo35786g(List<C6510b> list) throws IOException {
            int i;
            int i2;
            if (this.f17622d) {
                int i3 = this.f17621c;
                if (i3 < this.f17623e) {
                    mo35787h(i3, 31, 32);
                }
                this.f17622d = false;
                this.f17621c = Integer.MAX_VALUE;
                mo35787h(this.f17623e, 31, 32);
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                C6510b bVar = list.get(i4);
                C4455f w = bVar.f17606a.mo22478w();
                C4455f fVar = bVar.f17607b;
                Integer num = C6512c.f17610b.get(w);
                if (num != null) {
                    i2 = num.intValue() + 1;
                    if (i2 > 1 && i2 < 8) {
                        C6510b[] bVarArr = C6512c.f17609a;
                        if (C4402c.m17196q(bVarArr[i2 - 1].f17607b, fVar)) {
                            i = i2;
                        } else if (C4402c.m17196q(bVarArr[i2].f17607b, fVar)) {
                            i = i2;
                            i2++;
                        }
                    }
                    i = i2;
                    i2 = -1;
                } else {
                    i2 = -1;
                    i = -1;
                }
                if (i2 == -1) {
                    int i5 = this.f17625g + 1;
                    int length = this.f17624f.length;
                    while (true) {
                        if (i5 >= length) {
                            break;
                        }
                        if (C4402c.m17196q(this.f17624f[i5].f17606a, w)) {
                            if (C4402c.m17196q(this.f17624f[i5].f17607b, fVar)) {
                                i2 = C6512c.f17609a.length + (i5 - this.f17625g);
                                break;
                            } else if (i == -1) {
                                i = (i5 - this.f17625g) + C6512c.f17609a.length;
                            }
                        }
                        i5++;
                    }
                }
                if (i2 != -1) {
                    mo35787h(i2, 127, 128);
                } else if (i == -1) {
                    this.f17619a.mo22418j0(64);
                    mo35785f(w);
                    mo35785f(fVar);
                    m25430d(bVar);
                } else if (!w.mo22476u(C6510b.f17600d) || C6510b.f17605i.equals(w)) {
                    mo35787h(i, 63, 64);
                    mo35785f(fVar);
                    m25430d(bVar);
                } else {
                    mo35787h(i, 15, 0);
                    mo35785f(fVar);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public void mo35787h(int i, int i2, int i3) {
            if (i < i2) {
                this.f17619a.mo22418j0(i | i3);
                return;
            }
            this.f17619a.mo22418j0(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.f17619a.mo22418j0(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.f17619a.mo22418j0(i4);
        }

        C6514b(int i, boolean z, C4450c cVar) {
            this.f17621c = Integer.MAX_VALUE;
            C6510b[] bVarArr = new C6510b[8];
            this.f17624f = bVarArr;
            this.f17625g = bVarArr.length - 1;
            this.f17626h = 0;
            this.f17627i = 0;
            this.f17623e = i;
            this.f17620b = z;
            this.f17619a = cVar;
        }
    }

    static {
        C4455f fVar = C6510b.f17602f;
        C4455f fVar2 = C6510b.f17603g;
        C4455f fVar3 = C6510b.f17604h;
        C4455f fVar4 = C6510b.f17601e;
        f17609a = new C6510b[]{new C6510b(C6510b.f17605i, ""), new C6510b(fVar, "GET"), new C6510b(fVar, "POST"), new C6510b(fVar2, "/"), new C6510b(fVar2, "/index.html"), new C6510b(fVar3, "http"), new C6510b(fVar3, "https"), new C6510b(fVar4, "200"), new C6510b(fVar4, "204"), new C6510b(fVar4, "206"), new C6510b(fVar4, "304"), new C6510b(fVar4, "400"), new C6510b(fVar4, "404"), new C6510b(fVar4, "500"), new C6510b("accept-charset", ""), new C6510b("accept-encoding", "gzip, deflate"), new C6510b("accept-language", ""), new C6510b("accept-ranges", ""), new C6510b("accept", ""), new C6510b("access-control-allow-origin", ""), new C6510b("age", ""), new C6510b("allow", ""), new C6510b("authorization", ""), new C6510b("cache-control", ""), new C6510b("content-disposition", ""), new C6510b("content-encoding", ""), new C6510b("content-language", ""), new C6510b("content-length", ""), new C6510b("content-location", ""), new C6510b("content-range", ""), new C6510b("content-type", ""), new C6510b("cookie", ""), new C6510b("date", ""), new C6510b("etag", ""), new C6510b("expect", ""), new C6510b("expires", ""), new C6510b((String) Constants.MessagePayloadKeys.FROM, ""), new C6510b("host", ""), new C6510b("if-match", ""), new C6510b("if-modified-since", ""), new C6510b("if-none-match", ""), new C6510b("if-range", ""), new C6510b("if-unmodified-since", ""), new C6510b("last-modified", ""), new C6510b("link", ""), new C6510b((String) FirebaseAnalytics.Param.LOCATION, ""), new C6510b("max-forwards", ""), new C6510b("proxy-authenticate", ""), new C6510b("proxy-authorization", ""), new C6510b("range", ""), new C6510b("referer", ""), new C6510b("refresh", ""), new C6510b("retry-after", ""), new C6510b("server", ""), new C6510b("set-cookie", ""), new C6510b("strict-transport-security", ""), new C6510b("transfer-encoding", ""), new C6510b("user-agent", ""), new C6510b("vary", ""), new C6510b("via", ""), new C6510b("www-authenticate", "")};
    }

    /* renamed from: a */
    static C4455f m25408a(C4455f fVar) throws IOException {
        int size = fVar.size();
        int i = 0;
        while (i < size) {
            byte k = fVar.mo22468k(i);
            if (k < 65 || k > 90) {
                i++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + fVar.mo22480y());
            }
        }
        return fVar;
    }

    /* renamed from: b */
    private static Map<C4455f, Integer> m25409b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f17609a.length);
        int i = 0;
        while (true) {
            C6510b[] bVarArr = f17609a;
            if (i >= bVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(bVarArr[i].f17606a)) {
                linkedHashMap.put(bVarArr[i].f17606a, Integer.valueOf(i));
            }
            i++;
        }
    }
}
