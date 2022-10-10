package com.ahuazhu.heapdump.parser.hprof;

public interface RecordHole {

    void onRecord(byte tagByte, byte[] body);
    static RecordHole defaultObserver() {
        return (tagByte, body) -> {
           if(tagByte == Tag.HPROF_UTF8) {
               String x = new String(body, 8, body.length - 8);
               if (x.equals("Hello, world 100"))
                System.out.println(x);
           }
        };
    }

    class CounterRecordHole implements RecordHole {

        private long count;
        @Override
        public void onRecord(byte tagByte, byte[] body) {
            count ++;
        }

        public long count() {
            return count;
        }
    }
}
