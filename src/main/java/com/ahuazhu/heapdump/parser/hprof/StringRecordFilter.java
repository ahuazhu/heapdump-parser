package com.ahuazhu.heapdump.parser.hprof;

public class StringRecordFilter implements RecordFilter {
    @Override
    public boolean filter(byte tag) {
        return tag == Tag.HPROF_UTF8;
    }
}
