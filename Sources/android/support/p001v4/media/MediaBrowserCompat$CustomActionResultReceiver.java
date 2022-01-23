package android.support.p001v4.media;

import android.os.Bundle;
import android.support.p001v4.media.session.MediaSessionCompat;
import android.util.Log;
import p135d.p136a.p137a.p138a.C3770b;

/* renamed from: android.support.v4.media.MediaBrowserCompat$CustomActionResultReceiver */
class MediaBrowserCompat$CustomActionResultReceiver extends C3770b {

    /* renamed from: d */
    private final String f2d;

    /* renamed from: e */
    private final Bundle f3e;

    /* renamed from: f */
    private final C0009a f4f;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3a(int i, Bundle bundle) {
        if (this.f4f != null) {
            MediaSessionCompat.m63a(bundle);
            if (i == -1) {
                this.f4f.mo41a(this.f2d, this.f3e, bundle);
            } else if (i == 0) {
                this.f4f.mo43c(this.f2d, this.f3e, bundle);
            } else if (i != 1) {
                Log.w("MediaBrowserCompat", "Unknown result code: " + i + " (extras=" + this.f3e + ", resultData=" + bundle + ")");
            } else {
                this.f4f.mo42b(this.f2d, this.f3e, bundle);
            }
        }
    }
}
