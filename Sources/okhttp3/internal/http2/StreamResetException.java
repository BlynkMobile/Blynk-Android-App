package okhttp3.internal.http2;

import java.io.IOException;

public final class StreamResetException extends IOException {

    /* renamed from: b */
    public final C6509a f17586b;

    public StreamResetException(C6509a aVar) {
        super("stream was reset: " + aVar);
        this.f17586b = aVar;
    }
}
