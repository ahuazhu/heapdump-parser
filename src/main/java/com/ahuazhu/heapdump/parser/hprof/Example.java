package com.ahuazhu.heapdump.parser.hprof;

import java.util.ArrayList;
import java.util.List;

public class Example {

    public static void main(String[] args) throws InterruptedException {
        String msg = "Hello, world ";

        List<String> list = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        int c = 0;
        while (true) {
            list.add(msg + c);
            integers.add(c ++);

            if (list.size() > 1000) {
                list.clear();
                integers.clear();
            }

            Thread.sleep(1);
        }
    }
}
