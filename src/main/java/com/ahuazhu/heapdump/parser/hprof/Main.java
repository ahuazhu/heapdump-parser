package com.ahuazhu.heapdump.parser.hprof;

import java.io.*;
import java.nio.file.Path;

public class Main {

    public static final String HPROF_LOCATION = "/tmp/heapdump.phrof";

    public static void main(String[] args) throws IOException {
        HprofReader hprofReader = new StreamHprofReader(Path.of(HPROF_LOCATION));

        hprofReader.analyze();

    }
}
