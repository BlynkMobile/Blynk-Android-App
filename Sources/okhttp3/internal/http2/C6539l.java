package okhttp3.internal.http2;

import java.util.Arrays;

/* renamed from: okhttp3.internal.http2.l */
/* compiled from: Settings */
public final class C6539l {

    /* renamed from: a */
    private int f17729a;

    /* renamed from: b */
    private final int[] f17730b = new int[10];

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo35850a() {
        this.f17729a = 0;
        Arrays.fill(this.f17730b, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo35851b(int i) {
        return this.f17730b[i];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo35852c() {
        if ((this.f17729a & 2) != 0) {
            return this.f17730b[1];
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo35853d() {
        if ((this.f17729a & 128) != 0) {
            return this.f17730b[7];
        }
        return 65535;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo35854e(int i) {
        return (this.f17729a & 16) != 0 ? this.f17730b[4] : i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int mo35855f(int i) {
        return (this.f17729a & 32) != 0 ? this.f17730b[5] : i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo35856g(int i) {
        return ((1 << i) & this.f17729a) != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo35857h(C6539l lVar) {
        for (int i = 0; i < 10; i++) {
            if (lVar.mo35856g(i)) {
                mo35858i(i, lVar.mo35851b(i));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public C6539l mo35858i(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.f17730b;
            if (i < iArr.length) {
                this.f17729a = (1 << i) | this.f17729a;
                iArr[i] = i2;
            }
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public int mo35859j() {
        return Integer.bitCount(this.f17729a);
    }
}
