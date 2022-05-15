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
    comments = "Source: user-schema.proto")
public final class UserProtoServiceGrpc {

  private UserProtoServiceGrpc() {}

  public static final String SERVICE_NAME = "com.css533.curbthecoins.UserProtoService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.css533.curbthecoins.UserProto,
      com.css533.curbthecoins.UserProto> METHOD_REGISTER_USER_PROTO =
      io.grpc.MethodDescriptor.<com.css533.curbthecoins.UserProto, com.css533.curbthecoins.UserProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.css533.curbthecoins.UserProtoService", "RegisterUserProto"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.css533.curbthecoins.UserProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.css533.curbthecoins.UserProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.css533.curbthecoins.UserProto,
      com.css533.curbthecoins.UserProto> METHOD_LOGIN_USER_PROTO =
      io.grpc.MethodDescriptor.<com.css533.curbthecoins.UserProto, com.css533.curbthecoins.UserProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.css533.curbthecoins.UserProtoService", "LoginUserProto"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.css533.curbthecoins.UserProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.css533.curbthecoins.UserProto.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserProtoServiceStub newStub(io.grpc.Channel channel) {
    return new UserProtoServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserProtoServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UserProtoServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserProtoServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UserProtoServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class UserProtoServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void registerUserProto(com.css533.curbthecoins.UserProto request,
        io.grpc.stub.StreamObserver<com.css533.curbthecoins.UserProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_REGISTER_USER_PROTO, responseObserver);
    }

    /**
     * <pre>
     *login
     * </pre>
     */
    public void loginUserProto(com.css533.curbthecoins.UserProto request,
        io.grpc.stub.StreamObserver<com.css533.curbthecoins.UserProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LOGIN_USER_PROTO, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_REGISTER_USER_PROTO,
            asyncUnaryCall(
              new MethodHandlers<
                com.css533.curbthecoins.UserProto,
                com.css533.curbthecoins.UserProto>(
                  this, METHODID_REGISTER_USER_PROTO)))
          .addMethod(
            METHOD_LOGIN_USER_PROTO,
            asyncUnaryCall(
              new MethodHandlers<
                com.css533.curbthecoins.UserProto,
                com.css533.curbthecoins.UserProto>(
                  this, METHODID_LOGIN_USER_PROTO)))
          .build();
    }
  }

  /**
   */
  public static final class UserProtoServiceStub extends io.grpc.stub.AbstractStub<UserProtoServiceStub> {
    private UserProtoServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserProtoServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserProtoServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserProtoServiceStub(channel, callOptions);
    }

    /**
     */
    public void registerUserProto(com.css533.curbthecoins.UserProto request,
        io.grpc.stub.StreamObserver<com.css533.curbthecoins.UserProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_REGISTER_USER_PROTO, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *login
     * </pre>
     */
    public void loginUserProto(com.css533.curbthecoins.UserProto request,
        io.grpc.stub.StreamObserver<com.css533.curbthecoins.UserProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LOGIN_USER_PROTO, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UserProtoServiceBlockingStub extends io.grpc.stub.AbstractStub<UserProtoServiceBlockingStub> {
    private UserProtoServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserProtoServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserProtoServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserProtoServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.css533.curbthecoins.UserProto registerUserProto(com.css533.curbthecoins.UserProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_REGISTER_USER_PROTO, getCallOptions(), request);
    }

    /**
     * <pre>
     *login
     * </pre>
     */
    public com.css533.curbthecoins.UserProto loginUserProto(com.css533.curbthecoins.UserProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LOGIN_USER_PROTO, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserProtoServiceFutureStub extends io.grpc.stub.AbstractStub<UserProtoServiceFutureStub> {
    private UserProtoServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserProtoServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserProtoServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserProtoServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.css533.curbthecoins.UserProto> registerUserProto(
        com.css533.curbthecoins.UserProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_REGISTER_USER_PROTO, getCallOptions()), request);
    }

    /**
     * <pre>
     *login
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.css533.curbthecoins.UserProto> loginUserProto(
        com.css533.curbthecoins.UserProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LOGIN_USER_PROTO, getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER_USER_PROTO = 0;
  private static final int METHODID_LOGIN_USER_PROTO = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserProtoServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserProtoServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER_USER_PROTO:
          serviceImpl.registerUserProto((com.css533.curbthecoins.UserProto) request,
              (io.grpc.stub.StreamObserver<com.css533.curbthecoins.UserProto>) responseObserver);
          break;
        case METHODID_LOGIN_USER_PROTO:
          serviceImpl.loginUserProto((com.css533.curbthecoins.UserProto) request,
              (io.grpc.stub.StreamObserver<com.css533.curbthecoins.UserProto>) responseObserver);
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

  private static final class UserProtoServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.css533.curbthecoins.UserSchema.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UserProtoServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserProtoServiceDescriptorSupplier())
              .addMethod(METHOD_REGISTER_USER_PROTO)
              .addMethod(METHOD_LOGIN_USER_PROTO)
              .build();
        }
      }
    }
    return result;
  }
}
