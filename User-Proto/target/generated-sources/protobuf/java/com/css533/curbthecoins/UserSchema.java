// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: user-schema.proto

package com.css533.curbthecoins;

public final class UserSchema {
  private UserSchema() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_css533_curbthecoins_UserProto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_css533_curbthecoins_UserProto_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021user-schema.proto\022\027com.css533.curbthec" +
      "oins\"\256\001\n\tUserProto\022\017\n\007user_id\030\001 \001(\005\022\022\n\nf" +
      "irst_name\030\002 \001(\t\022\021\n\tlast_name\030\003 \001(\t\022\r\n\005em" +
      "ail\030\004 \001(\t\022\020\n\010password\030\005 \001(\t\022\023\n\013invite_co" +
      "de\030\006 \001(\t\022\022\n\npartner_id\030\007 \001(\005\022\020\n\010hasError" +
      "\030\010 \001(\010\022\r\n\005error\030\t \001(\t2\315\001\n\020UserProtoServi" +
      "ce\022]\n\021RegisterUserProto\022\".com.css533.cur" +
      "bthecoins.UserProto\032\".com.css533.curbthe" +
      "coins.UserProto\"\000\022Z\n\016LoginUserProto\022\".co" +
      "m.css533.curbthecoins.UserProto\032\".com.cs",
      "s533.curbthecoins.UserProto\"\000B\002P\001b\006proto" +
      "3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_com_css533_curbthecoins_UserProto_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_css533_curbthecoins_UserProto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_css533_curbthecoins_UserProto_descriptor,
        new java.lang.String[] { "UserId", "FirstName", "LastName", "Email", "Password", "InviteCode", "PartnerId", "HasError", "Error", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
