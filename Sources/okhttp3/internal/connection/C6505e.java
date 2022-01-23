package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import p225l.C4379a;
import p225l.C4395e;
import p225l.C4397e0;
import p225l.C4424p;
import p225l.C4433t;
import p225l.p226g0.C4402c;

/* renamed from: okhttp3.internal.connection.e */
/* compiled from: RouteSelector */
public final class C6505e {

    /* renamed from: a */
    private final C4379a f17561a;

    /* renamed from: b */
    private final C6504d f17562b;

    /* renamed from: c */
    private final C4395e f17563c;

    /* renamed from: d */
    private final C4424p f17564d;

    /* renamed from: e */
    private List<Proxy> f17565e = Collections.emptyList();

    /* renamed from: f */
    private int f17566f;

    /* renamed from: g */
    private List<InetSocketAddress> f17567g = Collections.emptyList();

    /* renamed from: h */
    private final List<C4397e0> f17568h = new ArrayList();

    /* renamed from: okhttp3.internal.connection.e$a */
    /* compiled from: RouteSelector */
    public static final class C6506a {

        /* renamed from: a */
        private final List<C4397e0> f17569a;

        /* renamed from: b */
        private int f17570b = 0;

        C6506a(List<C4397e0> list) {
            this.f17569a = list;
        }

        /* renamed from: a */
        public List<C4397e0> mo35760a() {
            return new ArrayList(this.f17569a);
        }

        /* renamed from: b */
        public boolean mo35761b() {
            return this.f17570b < this.f17569a.size();
        }

        /* renamed from: c */
        public C4397e0 mo35762c() {
            if (mo35761b()) {
                List<C4397e0> list = this.f17569a;
                int i = this.f17570b;
                this.f17570b = i + 1;
                return list.get(i);
            }
            throw new NoSuchElementException();
        }
    }

    public C6505e(C4379a aVar, C6504d dVar, C4395e eVar, C4424p pVar) {
        this.f17561a = aVar;
        this.f17562b = dVar;
        this.f17563c = eVar;
        this.f17564d = pVar;
        m25381h(aVar.mo22039l(), aVar.mo22033g());
    }

    /* renamed from: b */
    static String m25377b(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    /* renamed from: d */
    private boolean m25378d() {
        return this.f17566f < this.f17565e.size();
    }

    /* renamed from: f */
    private Proxy m25379f() throws IOException {
        if (m25378d()) {
            List<Proxy> list = this.f17565e;
            int i = this.f17566f;
            this.f17566f = i + 1;
            Proxy proxy = list.get(i);
            m25380g(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f17561a.mo22039l().mo22274m() + "; exhausted proxy configurations: " + this.f17565e);
    }

    /* renamed from: g */
    private void m25380g(Proxy proxy) throws IOException {
        String str;
        int i;
        this.f17567g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            str = this.f17561a.mo22039l().mo22274m();
            i = this.f17561a.mo22039l().mo22280z();
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                str = m25377b(inetSocketAddress);
                i = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        }
        if (i < 1 || i > 65535) {
            throw new SocketException("No route to " + str + ":" + i + "; port is out of range");
        } else if (proxy.type() == Proxy.Type.SOCKS) {
            this.f17567g.add(InetSocketAddress.createUnresolved(str, i));
        } else {
            this.f17564d.mo22220j(this.f17563c, str);
            List<InetAddress> a = this.f17561a.mo22028c().mo9325a(str);
            if (!a.isEmpty()) {
                this.f17564d.mo22219i(this.f17563c, str, a);
                int size = a.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f17567g.add(new InetSocketAddress(a.get(i2), i));
                }
                return;
            }
            throw new UnknownHostException(this.f17561a.mo22028c() + " returned no addresses for " + str);
        }
    }

    /* renamed from: h */
    private void m25381h(C4433t tVar, Proxy proxy) {
        List<Proxy> list;
        if (proxy != null) {
            this.f17565e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f17561a.mo22036i().select(tVar.mo22265I());
            if (select == null || select.isEmpty()) {
                list = C4402c.m17200u(Proxy.NO_PROXY);
            } else {
                list = C4402c.m17199t(select);
            }
            this.f17565e = list;
        }
        this.f17566f = 0;
    }

    /* renamed from: a */
    public void mo35757a(C4397e0 e0Var, IOException iOException) {
        if (!(e0Var.mo22123b().type() == Proxy.Type.DIRECT || this.f17561a.mo22036i() == null)) {
            this.f17561a.mo22036i().connectFailed(this.f17561a.mo22039l().mo22265I(), e0Var.mo22123b().address(), iOException);
        }
        this.f17562b.mo35755b(e0Var);
    }

    /* renamed from: c */
    public boolean mo35758c() {
        return m25378d() || !this.f17568h.isEmpty();
    }

    /* renamed from: e */
    public C6506a mo35759e() throws IOException {
        if (mo35758c()) {
            ArrayList arrayList = new ArrayList();
            while (m25378d()) {
                Proxy f = m25379f();
                int size = this.f17567g.size();
                for (int i = 0; i < size; i++) {
                    C4397e0 e0Var = new C4397e0(this.f17561a, f, this.f17567g.get(i));
                    if (this.f17562b.mo35756c(e0Var)) {
                        this.f17568h.add(e0Var);
                    } else {
                        arrayList.add(e0Var);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.f17568h);
                this.f17568h.clear();
            }
            return new C6506a(arrayList);
        }
        throw new NoSuchElementException();
    }
}
