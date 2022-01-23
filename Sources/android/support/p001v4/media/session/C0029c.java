package android.support.p001v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.support.p001v4.media.MediaMetadataCompat;
import android.support.p001v4.media.session.C0024a;
import android.support.p001v4.media.session.C0034e;
import android.support.p001v4.media.session.MediaSessionCompat;
import java.lang.ref.WeakReference;
import java.util.List;

/* renamed from: android.support.v4.media.session.c */
/* compiled from: MediaControllerCompat */
public abstract class C0029c implements IBinder.DeathRecipient {

    /* renamed from: a */
    final Object f68a;

    /* renamed from: b */
    C0030a f69b;

    /* renamed from: c */
    C0024a f70c;

    /* renamed from: android.support.v4.media.session.c$a */
    /* compiled from: MediaControllerCompat */
    private class C0030a extends Handler {
    }

    /* renamed from: android.support.v4.media.session.c$b */
    /* compiled from: MediaControllerCompat */
    private static class C0031b implements C0034e.C0035a {

        /* renamed from: a */
        private final WeakReference<C0029c> f71a;

        C0031b(C0029c cVar) {
            this.f71a = new WeakReference<>(cVar);
        }

        /* renamed from: a */
        public void mo121a(Bundle bundle) {
            C0029c cVar = (C0029c) this.f71a.get();
            if (cVar != null) {
                cVar.mo112b(bundle);
            }
        }

        /* renamed from: b */
        public void mo122b(List<?> list) {
            C0029c cVar = (C0029c) this.f71a.get();
            if (cVar != null) {
                cVar.mo116e(MediaSessionCompat.QueueItem.m65c(list));
            }
        }

        /* renamed from: c */
        public void mo123c(CharSequence charSequence) {
            C0029c cVar = (C0029c) this.f71a.get();
            if (cVar != null) {
                cVar.mo117f(charSequence);
            }
        }

        /* renamed from: d */
        public void mo124d() {
            C0029c cVar = (C0029c) this.f71a.get();
            if (cVar != null) {
                cVar.mo118g();
            }
        }

        /* renamed from: e */
        public void mo125e(Object obj) {
            C0029c cVar = (C0029c) this.f71a.get();
            if (cVar != null) {
                cVar.mo114c(MediaMetadataCompat.m23a(obj));
            }
        }

        /* renamed from: f */
        public void mo126f(int i, int i2, int i3, int i4, int i5) {
            C0029c cVar = (C0029c) this.f71a.get();
            if (cVar != null) {
                cVar.mo111a(new C0033d(i, i2, i3, i4, i5));
            }
        }

        /* renamed from: g */
        public void mo127g(Object obj) {
            C0029c cVar = (C0029c) this.f71a.get();
            if (cVar != null && cVar.f70c == null) {
                cVar.mo115d(PlaybackStateCompat.m77a(obj));
            }
        }

        /* renamed from: h */
        public void mo128h(String str, Bundle bundle) {
            C0029c cVar = (C0029c) this.f71a.get();
            if (cVar == null) {
                return;
            }
            if (cVar.f70c == null || Build.VERSION.SDK_INT >= 23) {
                cVar.mo119h(str, bundle);
            }
        }
    }

    /* renamed from: android.support.v4.media.session.c$c */
    /* compiled from: MediaControllerCompat */
    private static class C0032c extends C0024a.C0025a {

        /* renamed from: a */
        private final WeakReference<C0029c> f72a;

        C0032c(C0029c cVar) {
            this.f72a = new WeakReference<>(cVar);
        }

        /* renamed from: a */
        public void mo50a(Bundle bundle) throws RemoteException {
            C0029c cVar = (C0029c) this.f72a.get();
            if (cVar != null) {
                cVar.mo120i(7, bundle, (Bundle) null);
            }
        }

        /* renamed from: b */
        public void mo51b(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
            C0029c cVar = (C0029c) this.f72a.get();
            if (cVar != null) {
                cVar.mo120i(5, list, (Bundle) null);
            }
        }

        /* renamed from: c */
        public void mo52c(CharSequence charSequence) throws RemoteException {
            C0029c cVar = (C0029c) this.f72a.get();
            if (cVar != null) {
                cVar.mo120i(6, charSequence, (Bundle) null);
            }
        }

        /* renamed from: d */
        public void mo53d() throws RemoteException {
            C0029c cVar = (C0029c) this.f72a.get();
            if (cVar != null) {
                cVar.mo120i(8, (Object) null, (Bundle) null);
            }
        }

        /* renamed from: f */
        public void mo100f() throws RemoteException {
            C0029c cVar = (C0029c) this.f72a.get();
            if (cVar != null) {
                cVar.mo120i(13, (Object) null, (Bundle) null);
            }
        }

        /* renamed from: h */
        public void mo101h(boolean z) throws RemoteException {
            C0029c cVar = (C0029c) this.f72a.get();
            if (cVar != null) {
                cVar.mo120i(11, Boolean.valueOf(z), (Bundle) null);
            }
        }

        /* renamed from: i */
        public void mo102i(boolean z) throws RemoteException {
        }

        /* renamed from: j */
        public void mo54j(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
            C0029c cVar = (C0029c) this.f72a.get();
            if (cVar != null) {
                cVar.mo120i(3, mediaMetadataCompat, (Bundle) null);
            }
        }

        /* renamed from: k */
        public void mo103k(int i) throws RemoteException {
            C0029c cVar = (C0029c) this.f72a.get();
            if (cVar != null) {
                cVar.mo120i(9, Integer.valueOf(i), (Bundle) null);
            }
        }

        /* renamed from: l */
        public void mo104l(int i) throws RemoteException {
            C0029c cVar = (C0029c) this.f72a.get();
            if (cVar != null) {
                cVar.mo120i(12, Integer.valueOf(i), (Bundle) null);
            }
        }

        /* renamed from: n */
        public void mo105n(PlaybackStateCompat playbackStateCompat) throws RemoteException {
            C0029c cVar = (C0029c) this.f72a.get();
            if (cVar != null) {
                cVar.mo120i(2, playbackStateCompat, (Bundle) null);
            }
        }

        public void onEvent(String str, Bundle bundle) throws RemoteException {
            C0029c cVar = (C0029c) this.f72a.get();
            if (cVar != null) {
                cVar.mo120i(1, str, bundle);
            }
        }

        /* renamed from: p */
        public void mo55p(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
            C0029c cVar = (C0029c) this.f72a.get();
            if (cVar != null) {
                cVar.mo120i(4, parcelableVolumeInfo != null ? new C0033d(parcelableVolumeInfo.f45b, parcelableVolumeInfo.f46c, parcelableVolumeInfo.f47d, parcelableVolumeInfo.f48e, parcelableVolumeInfo.f49f) : null, (Bundle) null);
            }
        }
    }

    public C0029c() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f68a = C0034e.m127a(new C0031b(this));
        } else {
            this.f70c = new C0032c(this);
        }
    }

    /* renamed from: a */
    public void mo111a(C0033d dVar) {
    }

    /* renamed from: b */
    public void mo112b(Bundle bundle) {
    }

    public void binderDied() {
        mo120i(8, (Object) null, (Bundle) null);
    }

    /* renamed from: c */
    public void mo114c(MediaMetadataCompat mediaMetadataCompat) {
    }

    /* renamed from: d */
    public void mo115d(PlaybackStateCompat playbackStateCompat) {
    }

    /* renamed from: e */
    public void mo116e(List<MediaSessionCompat.QueueItem> list) {
    }

    /* renamed from: f */
    public void mo117f(CharSequence charSequence) {
    }

    /* renamed from: g */
    public void mo118g() {
    }

    /* renamed from: h */
    public void mo119h(String str, Bundle bundle) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo120i(int i, Object obj, Bundle bundle) {
        C0030a aVar = this.f69b;
        if (aVar != null) {
            Message obtainMessage = aVar.obtainMessage(i, obj);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
        }
    }
}
