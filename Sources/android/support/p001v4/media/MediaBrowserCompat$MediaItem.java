package android.support.p001v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import p057ch.qos.logback.core.CoreConstants;

/* renamed from: android.support.v4.media.MediaBrowserCompat$MediaItem */
public class MediaBrowserCompat$MediaItem implements Parcelable {
    public static final Parcelable.Creator<MediaBrowserCompat$MediaItem> CREATOR = new C0004a();

    /* renamed from: b */
    private final int f7b;

    /* renamed from: c */
    private final MediaDescriptionCompat f8c;

    /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaItem$a */
    static class C0004a implements Parcelable.Creator<MediaBrowserCompat$MediaItem> {
        C0004a() {
        }

        /* renamed from: a */
        public MediaBrowserCompat$MediaItem createFromParcel(Parcel parcel) {
            return new MediaBrowserCompat$MediaItem(parcel);
        }

        /* renamed from: b */
        public MediaBrowserCompat$MediaItem[] newArray(int i) {
            return new MediaBrowserCompat$MediaItem[i];
        }
    }

    MediaBrowserCompat$MediaItem(Parcel parcel) {
        this.f7b = parcel.readInt();
        this.f8c = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "MediaItem{" + "mFlags=" + this.f7b + ", mDescription=" + this.f8c + CoreConstants.CURLY_RIGHT;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7b);
        this.f8c.writeToParcel(parcel, i);
    }
}
