package android.support.p001v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;

/* renamed from: android.support.v4.media.d */
/* compiled from: MediaDescriptionCompatApi21 */
class C0012d {

    /* renamed from: android.support.v4.media.d$a */
    /* compiled from: MediaDescriptionCompatApi21 */
    static class C0013a {
        /* renamed from: a */
        public static Object m44a(Object obj) {
            return ((MediaDescription.Builder) obj).build();
        }

        /* renamed from: b */
        public static Object m45b() {
            return new MediaDescription.Builder();
        }

        /* renamed from: c */
        public static void m46c(Object obj, CharSequence charSequence) {
            ((MediaDescription.Builder) obj).setDescription(charSequence);
        }

        /* renamed from: d */
        public static void m47d(Object obj, Bundle bundle) {
            ((MediaDescription.Builder) obj).setExtras(bundle);
        }

        /* renamed from: e */
        public static void m48e(Object obj, Bitmap bitmap) {
            ((MediaDescription.Builder) obj).setIconBitmap(bitmap);
        }

        /* renamed from: f */
        public static void m49f(Object obj, Uri uri) {
            ((MediaDescription.Builder) obj).setIconUri(uri);
        }

        /* renamed from: g */
        public static void m50g(Object obj, String str) {
            ((MediaDescription.Builder) obj).setMediaId(str);
        }

        /* renamed from: h */
        public static void m51h(Object obj, CharSequence charSequence) {
            ((MediaDescription.Builder) obj).setSubtitle(charSequence);
        }

        /* renamed from: i */
        public static void m52i(Object obj, CharSequence charSequence) {
            ((MediaDescription.Builder) obj).setTitle(charSequence);
        }
    }

    /* renamed from: a */
    public static Object m35a(Parcel parcel) {
        return MediaDescription.CREATOR.createFromParcel(parcel);
    }

    /* renamed from: b */
    public static CharSequence m36b(Object obj) {
        return ((MediaDescription) obj).getDescription();
    }

    /* renamed from: c */
    public static Bundle m37c(Object obj) {
        return ((MediaDescription) obj).getExtras();
    }

    /* renamed from: d */
    public static Bitmap m38d(Object obj) {
        return ((MediaDescription) obj).getIconBitmap();
    }

    /* renamed from: e */
    public static Uri m39e(Object obj) {
        return ((MediaDescription) obj).getIconUri();
    }

    /* renamed from: f */
    public static String m40f(Object obj) {
        return ((MediaDescription) obj).getMediaId();
    }

    /* renamed from: g */
    public static CharSequence m41g(Object obj) {
        return ((MediaDescription) obj).getSubtitle();
    }

    /* renamed from: h */
    public static CharSequence m42h(Object obj) {
        return ((MediaDescription) obj).getTitle();
    }

    /* renamed from: i */
    public static void m43i(Object obj, Parcel parcel, int i) {
        ((MediaDescription) obj).writeToParcel(parcel, i);
    }
}
