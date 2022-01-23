package okhttp3.internal.connection;

import java.io.IOException;
import p225l.p226g0.C4402c;

public final class RouteException extends RuntimeException {

    /* renamed from: b */
    private IOException f17553b;

    /* renamed from: c */
    private IOException f17554c;

    public RouteException(IOException iOException) {
        super(iOException);
        this.f17553b = iOException;
        this.f17554c = iOException;
    }

    /* renamed from: a */
    public void mo35749a(IOException iOException) {
        C4402c.m17180a(this.f17553b, iOException);
        this.f17554c = iOException;
    }

    /* renamed from: b */
    public IOException mo35750b() {
        return this.f17553b;
    }

    /* renamed from: d */
    public IOException mo35751d() {
        return this.f17554c;
    }
}
