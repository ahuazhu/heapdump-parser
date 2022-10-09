package com.ahuazhu.heapdump.parser.hprof;

public class HProfUTF8 {
    private ID id;
    private byte[] utf8Bytes;

    public ID getId() {
        return id;
    }

    public String getString() {
        return new String(utf8Bytes);
    }
}
