package kotlin;

import kotlin.p343b.p344a.C6343b;
import p057ch.qos.logback.core.CoreConstants;

/* renamed from: kotlin.a */
/* compiled from: KotlinVersion.kt */
public final class C6341a implements Comparable<C6341a> {

    /* renamed from: f */
    public static final C6341a f17240f = new C6341a(1, 4, 10);

    /* renamed from: b */
    private final int f17241b;

    /* renamed from: c */
    private final int f17242c;

    /* renamed from: d */
    private final int f17243d;

    /* renamed from: e */
    private final int f17244e;

    public C6341a(int i, int i2, int i3) {
        this.f17242c = i;
        this.f17243d = i2;
        this.f17244e = i3;
        this.f17241b = m24752b(i, i2, i3);
    }

    /* renamed from: b */
    private final int m24752b(int i, int i2, int i3) {
        if (i >= 0 && 255 >= i && i2 >= 0 && 255 >= i2 && i3 >= 0 && 255 >= i3) {
            return (i << 16) + (i2 << 8) + i3;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i + CoreConstants.DOT + i2 + CoreConstants.DOT + i3).toString());
    }

    /* renamed from: a */
    public int compareTo(C6341a aVar) {
        C6343b.m24756c(aVar, "other");
        return this.f17241b - aVar.f17241b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C6341a)) {
            obj = null;
        }
        C6341a aVar = (C6341a) obj;
        if (aVar == null || this.f17241b != aVar.f17241b) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f17241b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f17242c);
        sb.append(CoreConstants.DOT);
        sb.append(this.f17243d);
        sb.append(CoreConstants.DOT);
        sb.append(this.f17244e);
        return sb.toString();
    }
}
