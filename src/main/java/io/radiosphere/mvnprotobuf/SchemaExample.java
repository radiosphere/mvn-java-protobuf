package io.radiosphere.mvnprotobuf;

import org.infinispan.protostream.GeneratedSchema;
import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder;

@AutoProtoSchemaBuilder(includeClasses = { CounterState.class }, schemaPackageName = "book_sample")
public interface SchemaExample extends GeneratedSchema {
}
