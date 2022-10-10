package com.ahuazhu.heapdump.parser.hprof;

public interface RecordFilter {

    boolean filter(byte tag);

    static RecordFilter defaultFilter() {
        return t -> true;
    }
}
