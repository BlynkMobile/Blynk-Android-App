package android.support.p001v4.media.session;

import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.List;

/* renamed from: android.support.v4.media.session.e */
/* compiled from: MediaControllerCompatApi21 */
class C0034e {

    /* renamed from: android.support.v4.media.session.e$a */
    /* compiled from: MediaControllerCompatApi21 */
    public interface C0035a {
        /* renamed from: a */
        void mo121a(Bundle bundle);

        /* renamed from: b */
        void mo122b(List<?> list);

        /* renamed from: c */
        void mo123c(CharSequence charSequence);

        /* renamed from: d */
        void mo124d();

        /* renamed from: e */
        void mo125e(Object obj);

        /* renamed from: f */
        void mo126f(int i, int i2, int i3, int i4, int i5);

        /* renamed from: g */
        void mo127g(Object obj);

        /* renamed from: h */
        void mo128h(String str, Bundle bundle);
    }

    /* renamed from: android.support.v4.media.session.e$b */
    /* compiled from: MediaControllerCompatApi21 */
    static class C0036b<T extends C0035a> extends MediaController.Callback {

        /* renamed from: a */
        protected final T f73a;

        public C0036b(T t) {
            this.f73a = t;
        }

        public void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
            this.f73a.mo126f(playbackInfo.getPlaybackType(), C0037c.m137b(playbackInfo), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
        }

        public void onExtrasChanged(Bundle bundle) {
            MediaSessionCompat.m63a(bundle);
            this.f73a.mo121a(bundle);
        }

        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            this.f73a.mo125e(mediaMetadata);
        }

        public void onPlaybackStateChanged(PlaybackState playbackState) {
            this.f73a.mo127g(playbackState);
        }

        public void onQueueChanged(List<MediaSession.QueueItem> list) {
            this.f73a.mo122b(list);
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
            this.f73a.mo123c(charSequence);
        }

        public void onSessionDestroyed() {
            this.f73a.mo124d();
        }

        public void onSessionEvent(String str, Bundle bundle) {
            MediaSessionCompat.m63a(bundle);
            this.f73a.mo128h(str, bundle);
        }
    }

    /* renamed from: android.support.v4.media.session.e$c */
    /* compiled from: MediaControllerCompatApi21 */
    public static class C0037c {
        /* renamed from: a */
        public static AudioAttributes m136a(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getAudioAttributes();
        }

        /* renamed from: b */
        public static int m137b(Object obj) {
            return m138c(m136a(obj));
        }

        /* renamed from: c */
        private static int m138c(AudioAttributes audioAttributes) {
            if ((audioAttributes.getFlags() & 1) == 1) {
                return 7;
            }
            if ((audioAttributes.getFlags() & 4) == 4) {
                return 6;
            }
            int usage = audioAttributes.getUsage();
            if (usage == 13) {
                return 1;
            }
            switch (usage) {
                case 2:
                    return 0;
                case 3:
                    return 8;
                case 4:
                    return 4;
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return 5;
                case 6:
                    return 2;
                default:
                    return 3;
            }
        }
    }

    /* renamed from: a */
    public static Object m127a(C0035a aVar) {
        return new C0036b(aVar);
    }
}
