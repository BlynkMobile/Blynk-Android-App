package android.support.p001v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: android.support.v4.app.a */
/* compiled from: INotificationSideChannel */
public interface C0001a extends IInterface {

    /* renamed from: android.support.v4.app.a$a */
    /* compiled from: INotificationSideChannel */
    public static abstract class C0002a extends Binder implements C0001a {

        /* renamed from: android.support.v4.app.a$a$a */
        /* compiled from: INotificationSideChannel */
        private static class C0003a implements C0001a {

            /* renamed from: b */
            public static C0001a f0b;

            /* renamed from: a */
            private IBinder f1a;

            C0003a(IBinder iBinder) {
                this.f1a = iBinder;
            }

            public IBinder asBinder() {
                return this.f1a;
            }

            /* renamed from: m */
            public void mo1m(String str, int i, String str2, Notification notification) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.f1a.transact(1, obtain, (Parcel) null, 1) || C0002a.m3r() == null) {
                        obtain.recycle();
                    } else {
                        C0002a.m3r().mo1m(str, i, str2, notification);
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        /* renamed from: q */
        public static C0001a m2q(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C0001a)) {
                return new C0003a(iBinder);
            }
            return (C0001a) queryLocalInterface;
        }

        /* renamed from: r */
        public static C0001a m3r() {
            return C0003a.f0b;
        }
    }

    /* renamed from: m */
    void mo1m(String str, int i, String str2, Notification notification) throws RemoteException;
}
