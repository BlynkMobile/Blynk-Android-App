package net.danlew.android.joda;

import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Marker;
import p057ch.qos.logback.core.CoreConstants;

public class ResUtils {
    private static final String TZDATA_PREFIX = "joda_";
    private static Map<Class<?>, Map<String, Integer>> sIdentifierCache = new ConcurrentHashMap();

    private static String convertPathToResource(String str) {
        File file = new File(str);
        ArrayList arrayList = new ArrayList();
        do {
            arrayList.add(file.getName());
            file = file.getParentFile();
        } while (file != null);
        StringBuffer stringBuffer = new StringBuffer();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append("_");
            }
            stringBuffer.append((String) arrayList.get(size));
        }
        return stringBuffer.toString().replace(CoreConstants.DASH_CHAR, '_').replace(Marker.ANY_NON_NULL_MARKER, "plus").toLowerCase(Locale.US);
    }

    public static int getIdentifier(Class<?> cls, String str) {
        Map map;
        if (!sIdentifierCache.containsKey(cls)) {
            map = new ConcurrentHashMap();
            sIdentifierCache.put(cls, map);
        } else {
            map = sIdentifierCache.get(cls);
        }
        if (map.containsKey(str)) {
            return ((Integer) map.get(str)).intValue();
        }
        try {
            int i = cls.getField(str).getInt((Object) null);
            if (i != 0) {
                map.put(str, Integer.valueOf(i));
            }
            return i;
        } catch (Exception e) {
            Log.e("JodaTimeAndroid", "Failed to retrieve identifier: type=" + cls + " name=" + str, e);
            return 0;
        }
    }

    public static String getTzResource(String str) {
        return TZDATA_PREFIX + convertPathToResource(str);
    }

    public static String getZoneInfoMapResource() {
        return TZDATA_PREFIX + convertPathToResource("ZoneInfoMap");
    }
}
