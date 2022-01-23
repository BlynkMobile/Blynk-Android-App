package android.support.p001v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p001v4.media.session.C0039g;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.media.session.PlaybackStateCompat */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new C0023a();

    /* renamed from: b */
    final int f50b;

    /* renamed from: c */
    final long f51c;

    /* renamed from: d */
    final long f52d;

    /* renamed from: e */
    final float f53e;

    /* renamed from: f */
    final long f54f;

    /* renamed from: g */
    final int f55g;

    /* renamed from: h */
    final CharSequence f56h;

    /* renamed from: i */
    final long f57i;

    /* renamed from: j */
    List<CustomAction> f58j;

    /* renamed from: k */
    final long f59k;

    /* renamed from: l */
    final Bundle f60l;

    /* renamed from: m */
    private Object f61m;

    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$a */
    static class C0023a implements Parcelable.Creator<PlaybackStateCompat> {
        C0023a() {
        }

        /* renamed from: a */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        /* renamed from: b */
        public PlaybackStateCompat[] newArray(int i) {
            return new PlaybackStateCompat[i];
        }
    }

    PlaybackStateCompat(int i, long j, long j2, float f, long j3, int i2, CharSequence charSequence, long j4, List<CustomAction> list, long j5, Bundle bundle) {
        this.f50b = i;
        this.f51c = j;
        this.f52d = j2;
        this.f53e = f;
        this.f54f = j3;
        this.f55g = i2;
        this.f56h = charSequence;
        this.f57i = j4;
        this.f58j = new ArrayList(list);
        this.f59k = j5;
        this.f60l = bundle;
    }

    /* renamed from: a */
    public static PlaybackStateCompat m77a(Object obj) {
        ArrayList arrayList;
        Object obj2 = obj;
        int i = Build.VERSION.SDK_INT;
        Bundle bundle = null;
        if (obj2 == null || i < 21) {
            return null;
        }
        List<Object> d = C0039g.m144d(obj);
        if (d != null) {
            ArrayList arrayList2 = new ArrayList(d.size());
            for (Object a : d) {
                arrayList2.add(CustomAction.m78a(a));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        if (i >= 22) {
            bundle = C0041h.m154a(obj);
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(C0039g.m149i(obj), C0039g.m148h(obj), C0039g.m143c(obj), C0039g.m147g(obj), C0039g.m141a(obj), 0, C0039g.m145e(obj), C0039g.m146f(obj), arrayList, C0039g.m142b(obj), bundle);
        playbackStateCompat.f61m = obj2;
        return playbackStateCompat;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PlaybackState {" + "state=" + this.f50b + ", position=" + this.f51c + ", buffered position=" + this.f52d + ", speed=" + this.f53e + ", updated=" + this.f57i + ", actions=" + this.f54f + ", error code=" + this.f55g + ", error message=" + this.f56h + ", custom actions=" + this.f58j + ", active item id=" + this.f59k + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f50b);
        parcel.writeLong(this.f51c);
        parcel.writeFloat(this.f53e);
        parcel.writeLong(this.f57i);
        parcel.writeLong(this.f52d);
        parcel.writeLong(this.f54f);
        TextUtils.writeToParcel(this.f56h, parcel, i);
        parcel.writeTypedList(this.f58j);
        parcel.writeLong(this.f59k);
        parcel.writeBundle(this.f60l);
        parcel.writeInt(this.f55g);
    }

    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$CustomAction */
    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new C0022a();

        /* renamed from: b */
        private final String f62b;

        /* renamed from: c */
        private final CharSequence f63c;

        /* renamed from: d */
        private final int f64d;

        /* renamed from: e */
        private final Bundle f65e;

        /* renamed from: f */
        private Object f66f;

        /* renamed from: android.support.v4.media.session.PlaybackStateCompat$CustomAction$a */
        static class C0022a implements Parcelable.Creator<CustomAction> {
            C0022a() {
            }

            /* renamed from: a */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            /* renamed from: b */
            public CustomAction[] newArray(int i) {
                return new CustomAction[i];
            }
        }

        CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.f62b = str;
            this.f63c = charSequence;
            this.f64d = i;
            this.f65e = bundle;
        }

        /* renamed from: a */
        public static CustomAction m78a(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            CustomAction customAction = new CustomAction(C0039g.C0040a.m150a(obj), C0039g.C0040a.m153d(obj), C0039g.C0040a.m152c(obj), C0039g.C0040a.m151b(obj));
            customAction.f66f = obj;
            return customAction;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + this.f63c + ", mIcon=" + this.f64d + ", mExtras=" + this.f65e;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f62b);
            TextUtils.writeToParcel(this.f63c, parcel, i);
            parcel.writeInt(this.f64d);
            parcel.writeBundle(this.f65e);
        }

        CustomAction(Parcel parcel) {
            this.f62b = parcel.readString();
            this.f63c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f64d = parcel.readInt();
            this.f65e = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f50b = parcel.readInt();
        this.f51c = parcel.readLong();
        this.f53e = parcel.readFloat();
        this.f57i = parcel.readLong();
        this.f52d = parcel.readLong();
        this.f54f = parcel.readLong();
        this.f56h = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f58j = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f59k = parcel.readLong();
        this.f60l = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f55g = parcel.readInt();
    }
}
