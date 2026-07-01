package com.example.quickdrop.feature.transfer.presentation;

import com.example.quickdrop.feature.transfer.domain.SendFileUseCase;
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
public final class TransferViewModel_Factory implements Factory<TransferViewModel> {
  private final Provider<SendFileUseCase> sendFileUseCaseProvider;

  public TransferViewModel_Factory(Provider<SendFileUseCase> sendFileUseCaseProvider) {
    this.sendFileUseCaseProvider = sendFileUseCaseProvider;
  }

  @Override
  public TransferViewModel get() {
    return newInstance(sendFileUseCaseProvider.get());
  }

  public static TransferViewModel_Factory create(
      Provider<SendFileUseCase> sendFileUseCaseProvider) {
    return new TransferViewModel_Factory(sendFileUseCaseProvider);
  }

  public static TransferViewModel newInstance(SendFileUseCase sendFileUseCase) {
    return new TransferViewModel(sendFileUseCase);
  }
}
