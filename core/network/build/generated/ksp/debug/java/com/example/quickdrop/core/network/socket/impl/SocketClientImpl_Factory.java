package com.example.quickdrop.core.network.socket.impl;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class SocketClientImpl_Factory implements Factory<SocketClientImpl> {
  @Override
  public SocketClientImpl get() {
    return newInstance();
  }

  public static SocketClientImpl_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static SocketClientImpl newInstance() {
    return new SocketClientImpl();
  }

  private static final class InstanceHolder {
    private static final SocketClientImpl_Factory INSTANCE = new SocketClientImpl_Factory();
  }
}
