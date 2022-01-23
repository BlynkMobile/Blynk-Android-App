package android.support.p001v4.media;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: android.support.v4.media.RatingCompat */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new C0008a();

    /* renamed from: b */
    private final int f32b;

    /* renamed from: c */
    private final float f33c;

    /* renamed from: android.support.v4.media.RatingCompat$a */
    static class C0008a implements Parcelable.Creator<RatingCompat> {
        C0008a() {
        }

        /* renamed from: a */
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        /* renamed from: b */
        public RatingCompat[] newArray(int i) {
            return new RatingCompat[i];
        }
    }

    RatingCompat(int i, float f) {
        this.f32b = i;
        this.f33c = f;
    }

    public int describeContents() {
        return this.f32b;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Rating:style=");
        sb.append(this.f32b);
        sb.append(" rating=");
        float f = this.f33c;
        if (f < 0.0f) {
            str = "unrated";
        } else {
            str = String.valueOf(f);
        }
        sb.append(str);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f32b);
        parcel.writeFloat(this.f33c);
    }
}
