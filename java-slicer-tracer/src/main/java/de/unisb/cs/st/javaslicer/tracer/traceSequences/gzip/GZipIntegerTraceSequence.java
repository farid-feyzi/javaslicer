package de.unisb.cs.st.javaslicer.tracer.traceSequences.gzip;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

import de.unisb.cs.st.javaslicer.tracer.Tracer;
import de.unisb.cs.st.javaslicer.tracer.traceSequences.uncompressed.UncompressedIntegerTraceSequence;
import de.unisb.cs.st.javaslicer.tracer.util.MultiplexedFileWriter.MultiplexOutputStream;

public class GZipIntegerTraceSequence extends UncompressedIntegerTraceSequence {

    public GZipIntegerTraceSequence(final int index, final Tracer tracer) throws IOException {
        super(index, tracer);
    }

    @Override
    protected OutputStream getOutputStream(final MultiplexOutputStream out) throws IOException {
        return new GZIPOutputStream(out);
    }

    @Override
    protected byte getFormat() {
        return FORMAT_GZIP;
    }

}
