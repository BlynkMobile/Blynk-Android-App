package android.support.p001v4.media;

import android.media.MediaDescription;
import android.net.Uri;

/* renamed from: android.support.v4.media.e */
/* compiled from: MediaDescriptionCompatApi23 */
class C0014e {

    /* renamed from: android.support.v4.media.e$a */
    /* compiled from: MediaDescriptionCompatApi23 */
    static class C0015a {
        /* renamed from: a */
        public static void m54a(Object obj, Uri uri) {
            ((MediaDescription.Builder) obj).setMediaUri(uri);
        }
    }

    /* renamed from: a */
    public static Uri m53a(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }
}
