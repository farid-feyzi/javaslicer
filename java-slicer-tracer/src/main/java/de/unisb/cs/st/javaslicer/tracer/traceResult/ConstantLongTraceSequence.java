package de.unisb.cs.st.javaslicer.tracer.traceResult;

import java.io.DataInput;
import java.io.IOException;
import java.util.Iterator;

import de.unisb.cs.st.javaslicer.tracer.traceSequences.TraceSequence;
import de.unisb.cs.st.javaslicer.tracer.util.MultiplexedFileReader;

public abstract class ConstantLongTraceSequence extends ConstantTraceSequence {

    public abstract Iterator<Long> backwardIterator();

    public static ConstantLongTraceSequence readFrom(final DataInput in, final byte format, final MultiplexedFileReader file)
            throws IOException {
        if (format == TraceSequence.FORMAT_GZIP) {
            throw new UnsupportedOperationException();
            // return ConstantGZipLongTraceSequence.readFrom(in, file);
        } else if (format == TraceSequence.FORMAT_UNCOMPRESSED) {
            return ConstantUncompressedLongTraceSequence.readFrom(in, file);
        } else {
            throw new RuntimeException("Unknown format: " + format);
        }
    }

}
