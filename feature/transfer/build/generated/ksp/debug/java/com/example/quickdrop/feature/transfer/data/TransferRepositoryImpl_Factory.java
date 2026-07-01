package com.example.quickdrop.feature.transfer.data;

import com.example.quickdrop.core.network.socket.SocketClient;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class TransferRepositoryImpl_Factory implements Factory<TransferRepositoryImpl> {
  private final Provider<SocketClient> socketClientProvider;

  public TransferRepositoryImpl_Factory(Provider<SocketClient> socketClientProvider) {
    this.socketClientProvider = socketClientProvider;
  }

  @Override
  public TransferRepositoryImpl get() {
    return newInstance(socketClientProvider.get());
  }

  public static TransferRepositoryImpl_Factory create(Provider<SocketClient> socketClientProvider) {
    return new TransferRepositoryImpl_Factory(socketClientProvider);
  }

  public static TransferRepositoryImpl newInstance(SocketClient socketClient) {
    return new TransferRepositoryImpl(socketClient);
  }
}
