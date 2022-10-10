package com.ahuazhu.heapdump.parser.hprof;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class StreamHprofReader implements HprofReader {
    private final Path hprofFilePath;
    private final DataInputStream dataInputStream;

    private final String hprofVersion;

    private final int idSize;

    private final long timestamp;

    private RecordFilter recordFilter = RecordFilter.defaultFilter();

    private RecordHole recordHole = RecordHole.defaultObserver();


    public StreamHprofReader(Path filePath) throws IOException {
        if (filePath == null || ! filePath.toFile().isFile()) {
            throw new IOException("Illegal hprof file: " + filePath);
        }
        this.hprofFilePath = filePath;
        this.dataInputStream = new DataInputStream(new FileInputStream(filePath.toFile()));

        this.hprofVersion = readHprofVersion();
        this.idSize = readIdSize();
        this.timestamp = readTimestamp();
    }

    @Override
    public void analyze() throws IOException {
        while (dataInputStream.available() > 0) {
            readRecord();
        }
    }

    private String readHprofVersion() throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DataOutputStream versionStream = new DataOutputStream(out);
        byte trailingZero = 0x0;
        byte b = dataInputStream.readByte();
        while (b != trailingZero) {
            versionStream.writeByte(b);
            b = dataInputStream.readByte();
        }
        return out.toString(StandardCharsets.UTF_8);
    }

    private int readIdSize() throws IOException {
        return dataInputStream.readInt();
    }

    private long readTimestamp() throws IOException {
        return dataInputStream.readLong();
    }


    private void readRecord() throws IOException {
        byte tagByte = dataInputStream.readByte();
        dataInputStream.readInt(); //discard timestamp;
        int bodyBytes = dataInputStream.readInt();
        if (recordFilter.filter(tagByte)) {
            byte[] body = dataInputStream.readNBytes(bodyBytes);
            recordHole.onRecord(tagByte, body);
        } else {
            dataInputStream.skipBytes(bodyBytes);
        }
    }


}
