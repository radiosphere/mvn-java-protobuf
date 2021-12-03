package io.radiosphere.mvnprotobuf;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class CounterState {
    private Long index;

    @ProtoFactory
    public CounterState(Long index) {
        this.index = index;
    }

    @ProtoField(number = 1)
    public Long getIndex() {
        return index;
    }
}
