package android.support.p001v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p001v4.media.C0012d;
import android.support.p001v4.media.C0014e;
import android.text.TextUtils;

/* renamed from: android.support.v4.media.MediaDescriptionCompat */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new C0005a();

    /* renamed from: b */
    private final String f12b;

    /* renamed from: c */
    private final CharSequence f13c;

    /* renamed from: d */
    private final CharSequence f14d;

    /* renamed from: e */
    private final CharSequence f15e;

    /* renamed from: f */
    private final Bitmap f16f;

    /* renamed from: g */
    private final Uri f17g;

    /* renamed from: h */
    private final Bundle f18h;

    /* renamed from: i */
    private final Uri f19i;

    /* renamed from: j */
    private Object f20j;

    /* renamed from: android.support.v4.media.MediaDescriptionCompat$a */
    static class C0005a implements Parcelable.Creator<MediaDescriptionCompat> {
        C0005a() {
        }

        /* renamed from: a */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            if (Build.VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(parcel);
            }
            return MediaDescriptionCompat.m10a(C0012d.m35a(parcel));
        }

        /* renamed from: b */
        public MediaDescriptionCompat[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    }

    /* renamed from: android.support.v4.media.MediaDescriptionCompat$b */
    public static final class C0006b {

        /* renamed from: a */
        private String f21a;

        /* renamed from: b */
        private CharSequence f22b;

        /* renamed from: c */
        private CharSequence f23c;

        /* renamed from: d */
        private CharSequence f24d;

        /* renamed from: e */
        private Bitmap f25e;

        /* renamed from: f */
        private Uri f26f;

        /* renamed from: g */
        private Bundle f27g;

        /* renamed from: h */
        private Uri f28h;

        /* renamed from: a */
        public MediaDescriptionCompat mo19a() {
            return new MediaDescriptionCompat(this.f21a, this.f22b, this.f23c, this.f24d, this.f25e, this.f26f, this.f27g, this.f28h);
        }

        /* renamed from: b */
        public C0006b mo20b(CharSequence charSequence) {
            this.f24d = charSequence;
            return this;
        }

        /* renamed from: c */
        public C0006b mo21c(Bundle bundle) {
            this.f27g = bundle;
            return this;
        }

        /* renamed from: d */
        public C0006b mo22d(Bitmap bitmap) {
            this.f25e = bitmap;
            return this;
        }

        /* renamed from: e */
        public C0006b mo23e(Uri uri) {
            this.f26f = uri;
            return this;
        }

        /* renamed from: f */
        public C0006b mo24f(String str) {
            this.f21a = str;
            return this;
        }

        /* renamed from: g */
        public C0006b mo25g(Uri uri) {
            this.f28h = uri;
            return this;
        }

        /* renamed from: h */
        public C0006b mo26h(CharSequence charSequence) {
            this.f23c = charSequence;
            return this;
        }

        /* renamed from: i */
        public C0006b mo27i(CharSequence charSequence) {
            this.f22b = charSequence;
            return this;
        }
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f12b = str;
        this.f13c = charSequence;
        this.f14d = charSequence2;
        this.f15e = charSequence3;
        this.f16f = bitmap;
        this.f17g = uri;
        this.f18h = bundle;
        this.f19i = uri2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006d  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.p001v4.media.MediaDescriptionCompat m10a(java.lang.Object r9) {
        /*
            r0 = 0
            if (r9 == 0) goto L_0x007e
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r1 < r2) goto L_0x007e
            android.support.v4.media.MediaDescriptionCompat$b r2 = new android.support.v4.media.MediaDescriptionCompat$b
            r2.<init>()
            java.lang.String r3 = android.support.p001v4.media.C0012d.m40f(r9)
            r2.mo24f(r3)
            java.lang.CharSequence r3 = android.support.p001v4.media.C0012d.m42h(r9)
            r2.mo27i(r3)
            java.lang.CharSequence r3 = android.support.p001v4.media.C0012d.m41g(r9)
            r2.mo26h(r3)
            java.lang.CharSequence r3 = android.support.p001v4.media.C0012d.m36b(r9)
            r2.mo20b(r3)
            android.graphics.Bitmap r3 = android.support.p001v4.media.C0012d.m38d(r9)
            r2.mo22d(r3)
            android.net.Uri r3 = android.support.p001v4.media.C0012d.m39e(r9)
            r2.mo23e(r3)
            android.os.Bundle r3 = android.support.p001v4.media.C0012d.m37c(r9)
            java.lang.String r4 = "android.support.v4.media.description.MEDIA_URI"
            if (r3 == 0) goto L_0x004a
            android.support.p001v4.media.session.MediaSessionCompat.m63a(r3)
            android.os.Parcelable r5 = r3.getParcelable(r4)
            android.net.Uri r5 = (android.net.Uri) r5
            goto L_0x004b
        L_0x004a:
            r5 = r0
        L_0x004b:
            if (r5 == 0) goto L_0x0063
            java.lang.String r6 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r7 = r3.containsKey(r6)
            if (r7 == 0) goto L_0x005d
            int r7 = r3.size()
            r8 = 2
            if (r7 != r8) goto L_0x005d
            goto L_0x0064
        L_0x005d:
            r3.remove(r4)
            r3.remove(r6)
        L_0x0063:
            r0 = r3
        L_0x0064:
            r2.mo21c(r0)
            if (r5 == 0) goto L_0x006d
            r2.mo25g(r5)
            goto L_0x0078
        L_0x006d:
            r0 = 23
            if (r1 < r0) goto L_0x0078
            android.net.Uri r0 = android.support.p001v4.media.C0014e.m53a(r9)
            r2.mo25g(r0)
        L_0x0078:
            android.support.v4.media.MediaDescriptionCompat r0 = r2.mo19a()
            r0.f20j = r9
        L_0x007e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p001v4.media.MediaDescriptionCompat.m10a(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    /* renamed from: c */
    public Object mo11c() {
        int i;
        Object obj = this.f20j;
        if (obj != null || (i = Build.VERSION.SDK_INT) < 21) {
            return obj;
        }
        Object b = C0012d.C0013a.m45b();
        C0012d.C0013a.m50g(b, this.f12b);
        C0012d.C0013a.m52i(b, this.f13c);
        C0012d.C0013a.m51h(b, this.f14d);
        C0012d.C0013a.m46c(b, this.f15e);
        C0012d.C0013a.m48e(b, this.f16f);
        C0012d.C0013a.m49f(b, this.f17g);
        Bundle bundle = this.f18h;
        if (i < 23 && this.f19i != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }
            bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.f19i);
        }
        C0012d.C0013a.m47d(b, bundle);
        if (i >= 23) {
            C0014e.C0015a.m54a(b, this.f19i);
        }
        Object a = C0012d.C0013a.m44a(b);
        this.f20j = a;
        return a;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.f13c + ", " + this.f14d + ", " + this.f15e;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (Build.VERSION.SDK_INT < 21) {
            parcel.writeString(this.f12b);
            TextUtils.writeToParcel(this.f13c, parcel, i);
            TextUtils.writeToParcel(this.f14d, parcel, i);
            TextUtils.writeToParcel(this.f15e, parcel, i);
            parcel.writeParcelable(this.f16f, i);
            parcel.writeParcelable(this.f17g, i);
            parcel.writeBundle(this.f18h);
            parcel.writeParcelable(this.f19i, i);
            return;
        }
        C0012d.m43i(mo11c(), parcel, i);
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.f12b = parcel.readString();
        this.f13c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f14d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f15e = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        ClassLoader classLoader = MediaDescriptionCompat.class.getClassLoader();
        this.f16f = (Bitmap) parcel.readParcelable(classLoader);
        this.f17g = (Uri) parcel.readParcelable(classLoader);
        this.f18h = parcel.readBundle(classLoader);
        this.f19i = (Uri) parcel.readParcelable(classLoader);
    }
}
