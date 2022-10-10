package com.ahuazhu.heapdump.parser.hprof;

public interface Tag {
        // top-level records
        byte HPROF_UTF8                    = 0x01;
        byte HPROF_LOAD_CLASS              = 0x02;
        byte HPROF_UNLOAD_CLASS            = 0x03;
        byte HPROF_FRAME                   = 0x04;
        byte HPROF_TRACE                   = 0x05;
        byte HPROF_ALLOC_SITES             = 0x06;
        byte HPROF_HEAP_SUMMARY            = 0x07;
        byte HPROF_START_THREAD            = 0x0A;
        byte HPROF_END_THREAD              = 0x0B;
        byte HPROF_HEAP_DUMP               = 0x0C;
        byte HPROF_CPU_SAMPLES             = 0x0D;
        byte HPROF_CONTROL_SETTINGS        = 0x0E;

        // 1.0.2 record types
        byte HPROF_HEAP_DUMP_SEGMENT       = 0x1C;
        byte HPROF_HEAP_DUMP_END           = 0x2C;

        // field types
        byte HPROF_ARRAY_OBJECT            = 0x01;
        byte HPROF_NORMAL_OBJECT           = 0x02;
        byte HPROF_BOOLEAN                 = 0x04;
        byte HPROF_CHAR                    = 0x05;
        byte HPROF_FLOAT                   = 0x06;
        byte HPROF_DOUBLE                  = 0x07;
        byte HPROF_BYTE                    = 0x08;
        byte HPROF_SHORT                   = 0x09;
        byte HPROF_INT                     = 0x0A;
        byte HPROF_LONG                    = 0x0B;

        // data-dump sub-records
        byte HPROF_GC_ROOT_UNKNOWN         = (byte) 0xFF;
        byte HPROF_GC_ROOT_JNI_GLOBAL      = 0x01;
        byte HPROF_GC_ROOT_JNI_LOCAL       = 0x02;
        byte HPROF_GC_ROOT_JAVA_FRAME      = 0x03;
        byte HPROF_GC_ROOT_NATIVE_STACK    = 0x04;
        byte HPROF_GC_ROOT_STICKY_CLASS    = 0x05;
        byte HPROF_GC_ROOT_THREAD_BLOCK    = 0x06;
        byte HPROF_GC_ROOT_MONITOR_USED    = 0x07;
        byte HPROF_GC_ROOT_THREAD_OBJ      = 0x08;
        byte HPROF_GC_CLASS_DUMP           = 0x20;
        byte HPROF_GC_INSTANCE_DUMP        = 0x21;
        byte HPROF_GC_OBJ_ARRAY_DUMP       = 0x22;
        byte HPROF_GC_PRIM_ARRAY_DUMP      = 0x23;

        static Tag of(byte tagByte) {
                return null;
        }
}
