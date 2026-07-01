package com.example.quickdrop.feature.transfer.domain;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

@ScopeMetadata
@QualifierMetadata("com.example.quickdrop.core.common.IoDispatcher")
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
public final class SendFileUseCase_Factory implements Factory<SendFileUseCase> {
  private final Provider<TransferRepository> repositoryProvider;

  private final Provider<CoroutineDispatcher> ioDispatcherProvider;

  public SendFileUseCase_Factory(Provider<TransferRepository> repositoryProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider) {
    this.repositoryProvider = repositoryProvider;
    this.ioDispatcherProvider = ioDispatcherProvider;
  }

  @Override
  public SendFileUseCase get() {
    return newInstance(repositoryProvider.get(), ioDispatcherProvider.get());
  }

  public static SendFileUseCase_Factory create(Provider<TransferRepository> repositoryProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider) {
    return new SendFileUseCase_Factory(repositoryProvider, ioDispatcherProvider);
  }

  public static SendFileUseCase newInstance(TransferRepository repository,
      CoroutineDispatcher ioDispatcher) {
    return new SendFileUseCase(repository, ioDispatcher);
  }
}
