package android.support.p001v4.media;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.p001v4.media.session.MediaSessionCompat;
import p135d.p136a.p137a.p138a.C3770b;

/* renamed from: android.support.v4.media.MediaBrowserCompat$ItemReceiver */
class MediaBrowserCompat$ItemReceiver extends C3770b {

    /* renamed from: d */
    private final String f5d;

    /* renamed from: e */
    private final C0010b f6e;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3a(int i, Bundle bundle) {
        MediaSessionCompat.m63a(bundle);
        if (i != 0 || bundle == null || !bundle.containsKey("media_item")) {
            this.f6e.mo44a(this.f5d);
            return;
        }
        Parcelable parcelable = bundle.getParcelable("media_item");
        if (parcelable == null || (parcelable instanceof MediaBrowserCompat$MediaItem)) {
            this.f6e.mo45b((MediaBrowserCompat$MediaItem) parcelable);
        } else {
            this.f6e.mo44a(this.f5d);
        }
    }
}
