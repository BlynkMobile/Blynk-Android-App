package okhttp3.internal.http2;

/* renamed from: okhttp3.internal.http2.a */
/* compiled from: ErrorCode */
public enum C6509a {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8),
    COMPRESSION_ERROR(9),
    CONNECT_ERROR(10),
    ENHANCE_YOUR_CALM(11),
    INADEQUATE_SECURITY(12),
    HTTP_1_1_REQUIRED(13);
    

    /* renamed from: b */
    public final int f17599b;

    private C6509a(int i) {
        this.f17599b = i;
    }

    /* renamed from: a */
    public static C6509a m25406a(int i) {
        for (C6509a aVar : values()) {
            if (aVar.f17599b == i) {
                return aVar;
            }
        }
        return null;
    }
}
