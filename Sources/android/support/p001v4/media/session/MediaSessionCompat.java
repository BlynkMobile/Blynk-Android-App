package android.support.p001v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.p001v4.media.MediaDescriptionCompat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.media.session.MediaSessionCompat */
public class MediaSessionCompat {

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper */
    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new C0019a();

        /* renamed from: b */
        ResultReceiver f42b;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper$a */
        static class C0019a implements Parcelable.Creator<ResultReceiverWrapper> {
            C0019a() {
            }

            /* renamed from: a */
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            /* renamed from: b */
            public ResultReceiverWrapper[] newArray(int i) {
                return new ResultReceiverWrapper[i];
            }
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.f42b = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.f42b.writeToParcel(parcel, i);
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$Token */
    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new C0020a();

        /* renamed from: b */
        private final Object f43b;

        /* renamed from: c */
        private C0026b f44c;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$Token$a */
        static class C0020a implements Parcelable.Creator<Token> {
            C0020a() {
            }

            /* renamed from: a */
            public Token createFromParcel(Parcel parcel) {
                Object obj;
                if (Build.VERSION.SDK_INT >= 21) {
                    obj = parcel.readParcelable((ClassLoader) null);
                } else {
                    obj = parcel.readStrongBinder();
                }
                return new Token(obj);
            }

            /* renamed from: b */
            public Token[] newArray(int i) {
                return new Token[i];
            }
        }

        Token(Object obj) {
            this(obj, (C0026b) null, (Bundle) null);
        }

        /* renamed from: a */
        public C0026b mo69a() {
            return this.f44c;
        }

        /* renamed from: c */
        public void mo70c(C0026b bVar) {
            this.f44c = bVar;
        }

        public int describeContents() {
            return 0;
        }

        /* renamed from: e */
        public void mo72e(Bundle bundle) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            Object obj2 = this.f43b;
            if (obj2 != null) {
                Object obj3 = token.f43b;
                if (obj3 == null) {
                    return false;
                }
                return obj2.equals(obj3);
            } else if (token.f43b == null) {
                return true;
            } else {
                return false;
            }
        }

        public int hashCode() {
            Object obj = this.f43b;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public void writeToParcel(Parcel parcel, int i) {
            if (Build.VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.f43b, i);
            } else {
                parcel.writeStrongBinder((IBinder) this.f43b);
            }
        }

        Token(Object obj, C0026b bVar, Bundle bundle) {
            this.f43b = obj;
            this.f44c = bVar;
        }
    }

    /* renamed from: a */
    public static void m63a(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$QueueItem */
    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new C0018a();

        /* renamed from: b */
        private final MediaDescriptionCompat f39b;

        /* renamed from: c */
        private final long f40c;

        /* renamed from: d */
        private Object f41d;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$QueueItem$a */
        static class C0018a implements Parcelable.Creator<QueueItem> {
            C0018a() {
            }

            /* renamed from: a */
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            /* renamed from: b */
            public QueueItem[] newArray(int i) {
                return new QueueItem[i];
            }
        }

        private QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            } else if (j != -1) {
                this.f39b = mediaDescriptionCompat;
                this.f40c = j;
                this.f41d = obj;
            } else {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
        }

        /* renamed from: a */
        public static QueueItem m64a(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new QueueItem(obj, MediaDescriptionCompat.m10a(C0038f.m139a(obj)), C0038f.m140b(obj));
        }

        /* renamed from: c */
        public static List<QueueItem> m65c(List<?> list) {
            if (list == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object a : list) {
                arrayList.add(m64a(a));
            }
            return arrayList;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f39b + ", Id=" + this.f40c + " }";
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.f39b.writeToParcel(parcel, i);
            parcel.writeLong(this.f40c);
        }

        QueueItem(Parcel parcel) {
            this.f39b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f40c = parcel.readLong();
        }
    }
}
