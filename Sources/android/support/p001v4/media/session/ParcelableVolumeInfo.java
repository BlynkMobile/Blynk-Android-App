package android.support.p001v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: android.support.v4.media.session.ParcelableVolumeInfo */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new C0021a();

    /* renamed from: b */
    public int f45b;

    /* renamed from: c */
    public int f46c;

    /* renamed from: d */
    public int f47d;

    /* renamed from: e */
    public int f48e;

    /* renamed from: f */
    public int f49f;

    /* renamed from: android.support.v4.media.session.ParcelableVolumeInfo$a */
    static class C0021a implements Parcelable.Creator<ParcelableVolumeInfo> {
        C0021a() {
        }

        /* renamed from: a */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        /* renamed from: b */
        public ParcelableVolumeInfo[] newArray(int i) {
            return new ParcelableVolumeInfo[i];
        }
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f45b = parcel.readInt();
        this.f47d = parcel.readInt();
        this.f48e = parcel.readInt();
        this.f49f = parcel.readInt();
        this.f46c = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f45b);
        parcel.writeInt(this.f47d);
        parcel.writeInt(this.f48e);
        parcel.writeInt(this.f49f);
        parcel.writeInt(this.f46c);
    }
}
