// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: target/budget-schema.proto

package com.css533.curbthecoins;

public final class BudgetSchema {
  private BudgetSchema() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_css533_curbthecoins_BudgetProto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_css533_curbthecoins_BudgetProto_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\032target/budget-schema.proto\022\027com.css533" +
      ".curbthecoins\"\232\001\n\013BudgetProto\022\021\n\tbudget_" +
      "id\030\001 \001(\005\022\017\n\007user_id\030\002 \001(\005\022\022\n\npartner_id\030" +
      "\003 \001(\005\022\016\n\006budget\030\004 \001(\001\022\r\n\005title\030\005 \001(\t\022\023\n\013" +
      "description\030\006 \001(\t\022\020\n\010hasError\030\007 \001(\010\022\r\n\005e" +
      "rror\030\010 \001(\t2\350\003\n\022BudgetProtoService\022Y\n\tSet" +
      "Budget\022$.com.css533.curbthecoins.BudgetP" +
      "roto\032$.com.css533.curbthecoins.BudgetPro" +
      "to\"\000\022Z\n\nEditBudget\022$.com.css533.curbthec" +
      "oins.BudgetProto\032$.com.css533.curbthecoi",
      "ns.BudgetProto\"\000\022a\n\021EditBudgetPartner\022$." +
      "com.css533.curbthecoins.BudgetProto\032$.co" +
      "m.css533.curbthecoins.BudgetProto\"\000\022\\\n\014D" +
      "eleteBudget\022$.com.css533.curbthecoins.Bu" +
      "dgetProto\032$.com.css533.curbthecoins.Budg" +
      "etProto\"\000\022Z\n\nReadBudget\022$.com.css533.cur" +
      "bthecoins.BudgetProto\032$.com.css533.curbt" +
      "hecoins.BudgetProto\"\000B\002P\001b\006proto3"
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
    internal_static_com_css533_curbthecoins_BudgetProto_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_css533_curbthecoins_BudgetProto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_css533_curbthecoins_BudgetProto_descriptor,
        new java.lang.String[] { "BudgetId", "UserId", "PartnerId", "Budget", "Title", "Description", "HasError", "Error", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
