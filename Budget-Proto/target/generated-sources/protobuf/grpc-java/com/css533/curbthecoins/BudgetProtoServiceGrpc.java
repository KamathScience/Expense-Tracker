package com.css533.curbthecoins;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: target/budget-schema.proto")
public final class BudgetProtoServiceGrpc {

  private BudgetProtoServiceGrpc() {}

  public static final String SERVICE_NAME = "com.css533.curbthecoins.BudgetProtoService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.css533.curbthecoins.BudgetProto,
      com.css533.curbthecoins.BudgetProto> METHOD_SET_BUDGET =
      io.grpc.MethodDescriptor.<com.css533.curbthecoins.BudgetProto, com.css533.curbthecoins.BudgetProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.css533.curbthecoins.BudgetProtoService", "SetBudget"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.css533.curbthecoins.BudgetProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.css533.curbthecoins.BudgetProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.css533.curbthecoins.BudgetProto,
      com.css533.curbthecoins.BudgetProto> METHOD_EDIT_BUDGET =
      io.grpc.MethodDescriptor.<com.css533.curbthecoins.BudgetProto, com.css533.curbthecoins.BudgetProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.css533.curbthecoins.BudgetProtoService", "EditBudget"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.css533.curbthecoins.BudgetProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.css533.curbthecoins.BudgetProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.css533.curbthecoins.BudgetProto,
      com.css533.curbthecoins.BudgetProto> METHOD_EDIT_BUDGET_PARTNER =
      io.grpc.MethodDescriptor.<com.css533.curbthecoins.BudgetProto, com.css533.curbthecoins.BudgetProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.css533.curbthecoins.BudgetProtoService", "EditBudgetPartner"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.css533.curbthecoins.BudgetProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.css533.curbthecoins.BudgetProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.css533.curbthecoins.BudgetProto,
      com.css533.curbthecoins.BudgetProto> METHOD_DELETE_BUDGET =
      io.grpc.MethodDescriptor.<com.css533.curbthecoins.BudgetProto, com.css533.curbthecoins.BudgetProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.css533.curbthecoins.BudgetProtoService", "DeleteBudget"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.css533.curbthecoins.BudgetProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.css533.curbthecoins.BudgetProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.css533.curbthecoins.BudgetProto,
      com.css533.curbthecoins.BudgetProto> METHOD_READ_BUDGET =
      io.grpc.MethodDescriptor.<com.css533.curbthecoins.BudgetProto, com.css533.curbthecoins.BudgetProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.css533.curbthecoins.BudgetProtoService", "ReadBudget"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.css533.curbthecoins.BudgetProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.css533.curbthecoins.BudgetProto.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BudgetProtoServiceStub newStub(io.grpc.Channel channel) {
    return new BudgetProtoServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BudgetProtoServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BudgetProtoServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BudgetProtoServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BudgetProtoServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class BudgetProtoServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void setBudget(com.css533.curbthecoins.BudgetProto request,
        io.grpc.stub.StreamObserver<com.css533.curbthecoins.BudgetProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_BUDGET, responseObserver);
    }

    /**
     */
    public void editBudget(com.css533.curbthecoins.BudgetProto request,
        io.grpc.stub.StreamObserver<com.css533.curbthecoins.BudgetProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_EDIT_BUDGET, responseObserver);
    }

    /**
     */
    public void editBudgetPartner(com.css533.curbthecoins.BudgetProto request,
        io.grpc.stub.StreamObserver<com.css533.curbthecoins.BudgetProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_EDIT_BUDGET_PARTNER, responseObserver);
    }

    /**
     */
    public void deleteBudget(com.css533.curbthecoins.BudgetProto request,
        io.grpc.stub.StreamObserver<com.css533.curbthecoins.BudgetProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE_BUDGET, responseObserver);
    }

    /**
     */
    public void readBudget(com.css533.curbthecoins.BudgetProto request,
        io.grpc.stub.StreamObserver<com.css533.curbthecoins.BudgetProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_BUDGET, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_SET_BUDGET,
            asyncUnaryCall(
              new MethodHandlers<
                com.css533.curbthecoins.BudgetProto,
                com.css533.curbthecoins.BudgetProto>(
                  this, METHODID_SET_BUDGET)))
          .addMethod(
            METHOD_EDIT_BUDGET,
            asyncUnaryCall(
              new MethodHandlers<
                com.css533.curbthecoins.BudgetProto,
                com.css533.curbthecoins.BudgetProto>(
                  this, METHODID_EDIT_BUDGET)))
          .addMethod(
            METHOD_EDIT_BUDGET_PARTNER,
            asyncUnaryCall(
              new MethodHandlers<
                com.css533.curbthecoins.BudgetProto,
                com.css533.curbthecoins.BudgetProto>(
                  this, METHODID_EDIT_BUDGET_PARTNER)))
          .addMethod(
            METHOD_DELETE_BUDGET,
            asyncUnaryCall(
              new MethodHandlers<
                com.css533.curbthecoins.BudgetProto,
                com.css533.curbthecoins.BudgetProto>(
                  this, METHODID_DELETE_BUDGET)))
          .addMethod(
            METHOD_READ_BUDGET,
            asyncUnaryCall(
              new MethodHandlers<
                com.css533.curbthecoins.BudgetProto,
                com.css533.curbthecoins.BudgetProto>(
                  this, METHODID_READ_BUDGET)))
          .build();
    }
  }

  /**
   */
  public static final class BudgetProtoServiceStub extends io.grpc.stub.AbstractStub<BudgetProtoServiceStub> {
    private BudgetProtoServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BudgetProtoServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BudgetProtoServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BudgetProtoServiceStub(channel, callOptions);
    }

    /**
     */
    public void setBudget(com.css533.curbthecoins.BudgetProto request,
        io.grpc.stub.StreamObserver<com.css533.curbthecoins.BudgetProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_BUDGET, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void editBudget(com.css533.curbthecoins.BudgetProto request,
        io.grpc.stub.StreamObserver<com.css533.curbthecoins.BudgetProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_EDIT_BUDGET, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void editBudgetPartner(com.css533.curbthecoins.BudgetProto request,
        io.grpc.stub.StreamObserver<com.css533.curbthecoins.BudgetProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_EDIT_BUDGET_PARTNER, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteBudget(com.css533.curbthecoins.BudgetProto request,
        io.grpc.stub.StreamObserver<com.css533.curbthecoins.BudgetProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_BUDGET, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readBudget(com.css533.curbthecoins.BudgetProto request,
        io.grpc.stub.StreamObserver<com.css533.curbthecoins.BudgetProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_BUDGET, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BudgetProtoServiceBlockingStub extends io.grpc.stub.AbstractStub<BudgetProtoServiceBlockingStub> {
    private BudgetProtoServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BudgetProtoServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BudgetProtoServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BudgetProtoServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.css533.curbthecoins.BudgetProto setBudget(com.css533.curbthecoins.BudgetProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_BUDGET, getCallOptions(), request);
    }

    /**
     */
    public com.css533.curbthecoins.BudgetProto editBudget(com.css533.curbthecoins.BudgetProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_EDIT_BUDGET, getCallOptions(), request);
    }

    /**
     */
    public com.css533.curbthecoins.BudgetProto editBudgetPartner(com.css533.curbthecoins.BudgetProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_EDIT_BUDGET_PARTNER, getCallOptions(), request);
    }

    /**
     */
    public com.css533.curbthecoins.BudgetProto deleteBudget(com.css533.curbthecoins.BudgetProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE_BUDGET, getCallOptions(), request);
    }

    /**
     */
    public com.css533.curbthecoins.BudgetProto readBudget(com.css533.curbthecoins.BudgetProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_BUDGET, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BudgetProtoServiceFutureStub extends io.grpc.stub.AbstractStub<BudgetProtoServiceFutureStub> {
    private BudgetProtoServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BudgetProtoServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BudgetProtoServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BudgetProtoServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.css533.curbthecoins.BudgetProto> setBudget(
        com.css533.curbthecoins.BudgetProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_BUDGET, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.css533.curbthecoins.BudgetProto> editBudget(
        com.css533.curbthecoins.BudgetProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_EDIT_BUDGET, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.css533.curbthecoins.BudgetProto> editBudgetPartner(
        com.css533.curbthecoins.BudgetProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_EDIT_BUDGET_PARTNER, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.css533.curbthecoins.BudgetProto> deleteBudget(
        com.css533.curbthecoins.BudgetProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_BUDGET, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.css533.curbthecoins.BudgetProto> readBudget(
        com.css533.curbthecoins.BudgetProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_BUDGET, getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_BUDGET = 0;
  private static final int METHODID_EDIT_BUDGET = 1;
  private static final int METHODID_EDIT_BUDGET_PARTNER = 2;
  private static final int METHODID_DELETE_BUDGET = 3;
  private static final int METHODID_READ_BUDGET = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BudgetProtoServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BudgetProtoServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SET_BUDGET:
          serviceImpl.setBudget((com.css533.curbthecoins.BudgetProto) request,
              (io.grpc.stub.StreamObserver<com.css533.curbthecoins.BudgetProto>) responseObserver);
          break;
        case METHODID_EDIT_BUDGET:
          serviceImpl.editBudget((com.css533.curbthecoins.BudgetProto) request,
              (io.grpc.stub.StreamObserver<com.css533.curbthecoins.BudgetProto>) responseObserver);
          break;
        case METHODID_EDIT_BUDGET_PARTNER:
          serviceImpl.editBudgetPartner((com.css533.curbthecoins.BudgetProto) request,
              (io.grpc.stub.StreamObserver<com.css533.curbthecoins.BudgetProto>) responseObserver);
          break;
        case METHODID_DELETE_BUDGET:
          serviceImpl.deleteBudget((com.css533.curbthecoins.BudgetProto) request,
              (io.grpc.stub.StreamObserver<com.css533.curbthecoins.BudgetProto>) responseObserver);
          break;
        case METHODID_READ_BUDGET:
          serviceImpl.readBudget((com.css533.curbthecoins.BudgetProto) request,
              (io.grpc.stub.StreamObserver<com.css533.curbthecoins.BudgetProto>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class BudgetProtoServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.css533.curbthecoins.BudgetSchema.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (BudgetProtoServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BudgetProtoServiceDescriptorSupplier())
              .addMethod(METHOD_SET_BUDGET)
              .addMethod(METHOD_EDIT_BUDGET)
              .addMethod(METHOD_EDIT_BUDGET_PARTNER)
              .addMethod(METHOD_DELETE_BUDGET)
              .addMethod(METHOD_READ_BUDGET)
              .build();
        }
      }
    }
    return result;
  }
}
