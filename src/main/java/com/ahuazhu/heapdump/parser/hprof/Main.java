package com.ahuazhu.heapdump.parser.hprof;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class Main {

    public static final String HPROF_LOCATION = "/tmp/heapdump.phrof";

    public static void main(String[] args) throws IOException {
        FileChannel fileChannel = new RandomAccessFile(new File(HPROF_LOCATION), "r").getChannel();
        long size = fileChannel.size();
        System.out.println("File size " + size);
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, size);

        int currentPosition = 0;


        for (int i = currentPosition; i < size; i++) {
            if (mappedByteBuffer.get(i) == 0) {
                MappedByteBuffer slice = mappedByteBuffer.slice(currentPosition, i);
                byte[] bytes = new byte[i - currentPosition];
                slice.get(bytes); //copy
                String header = new String(bytes);
                System.out.println(header);
                currentPosition = i + 1;
                break;
            }
        }
        mappedByteBuffer.position(currentPosition);
        int idSize = mappedByteBuffer.getInt();

        System.out.println("ID SIZE: " + idSize);

        long timeStamp = mappedByteBuffer.getLong();

        System.out.println("time stamp: " + timeStamp);

        while (mappedByteBuffer.position() < mappedByteBuffer.limit()) {
            byte tag = mappedByteBuffer.get();
            int bytes = mappedByteBuffer.getInt();

            byte[] body = new byte[bytes];
            mappedByteBuffer.get(body);
            if (tag == Tag.HPROF_UTF8) {
                System.out.println("Tag: " + tag);
                System.out.println("  String: " + new String(body, 8, bytes - 8));
            }
        }


        fileChannel.close();
    }
}
