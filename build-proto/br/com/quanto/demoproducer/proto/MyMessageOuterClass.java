// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: my-message.proto

package br.com.quanto.demoproducer.proto;

public final class MyMessageOuterClass {
  private MyMessageOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_br_com_quanto_demoproducer_proto_MyMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_br_com_quanto_demoproducer_proto_MyMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020my-message.proto\022 br.com.quanto.demopr" +
      "oducer.proto\"-\n\tMyMessage\022\017\n\007content\030\001 \001" +
      "(\t\022\017\n\007subject\030\003 \001(\tB$\n br.com.quanto.dem" +
      "oproducer.protoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_br_com_quanto_demoproducer_proto_MyMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_br_com_quanto_demoproducer_proto_MyMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_br_com_quanto_demoproducer_proto_MyMessage_descriptor,
        new java.lang.String[] { "Content", "Subject", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}