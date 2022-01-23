package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
import p225l.C4420k;
import p225l.p226g0.C4401a;

/* renamed from: okhttp3.internal.connection.b */
/* compiled from: ConnectionSpecSelector */
public final class C6503b {

    /* renamed from: a */
    private final List<C4420k> f17556a;

    /* renamed from: b */
    private int f17557b = 0;

    /* renamed from: c */
    private boolean f17558c;

    /* renamed from: d */
    private boolean f17559d;

    public C6503b(List<C4420k> list) {
        this.f17556a = list;
    }

    /* renamed from: c */
    private boolean m25371c(SSLSocket sSLSocket) {
        for (int i = this.f17557b; i < this.f17556a.size(); i++) {
            if (this.f17556a.get(i).mo22186c(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public C4420k mo35752a(SSLSocket sSLSocket) throws IOException {
        C4420k kVar;
        int i = this.f17557b;
        int size = this.f17556a.size();
        while (true) {
            if (i >= size) {
                kVar = null;
                break;
            }
            kVar = this.f17556a.get(i);
            if (kVar.mo22186c(sSLSocket)) {
                this.f17557b = i + 1;
                break;
            }
            i++;
        }
        if (kVar != null) {
            this.f17558c = m25371c(sSLSocket);
            C4401a.f12251a.mo22142c(kVar, sSLSocket, this.f17559d);
            return kVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f17559d + ", modes=" + this.f17556a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    /* renamed from: b */
    public boolean mo35753b(IOException iOException) {
        this.f17559d = true;
        if (!this.f17558c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        if (z || (iOException instanceof SSLProtocolException) || (iOException instanceof SSLException)) {
            return true;
        }
        return false;
    }
}
