package android.support.p001v4.media;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.p001v4.media.session.MediaSessionCompat;
import java.util.ArrayList;
import p135d.p136a.p137a.p138a.C3770b;

/* renamed from: android.support.v4.media.MediaBrowserCompat$SearchResultReceiver */
class MediaBrowserCompat$SearchResultReceiver extends C3770b {

    /* renamed from: d */
    private final String f9d;

    /* renamed from: e */
    private final Bundle f10e;

    /* renamed from: f */
    private final C0011c f11f;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3a(int i, Bundle bundle) {
        MediaSessionCompat.m63a(bundle);
        if (i != 0 || bundle == null || !bundle.containsKey("search_results")) {
            this.f11f.mo46a(this.f9d, this.f10e);
            return;
        }
        Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
        ArrayList arrayList = null;
        if (parcelableArray != null) {
            arrayList = new ArrayList();
            for (Parcelable parcelable : parcelableArray) {
                arrayList.add((MediaBrowserCompat$MediaItem) parcelable);
            }
        }
        this.f11f.mo47b(this.f9d, this.f10e, arrayList);
    }
}
