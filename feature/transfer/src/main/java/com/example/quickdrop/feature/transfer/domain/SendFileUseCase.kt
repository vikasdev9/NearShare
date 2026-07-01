package com.example.quickdrop.feature.transfer.domain

import android.net.Uri
import com.example.quickdrop.core.common.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class SendFileUseCase @Inject constructor(
    private val repository: TransferRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {
    operator fun invoke(uri: Uri, address: String): Flow<TransferStatus> {
        return repository.sendFile(uri, address).flowOn(ioDispatcher)
    }
}
