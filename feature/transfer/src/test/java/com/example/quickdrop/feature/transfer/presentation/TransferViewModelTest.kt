package com.example.quickdrop.feature.transfer.presentation

import android.net.Uri
import com.example.quickdrop.feature.transfer.domain.SendFileUseCase
import com.example.quickdrop.feature.transfer.domain.TransferStatus
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class TransferViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var viewModel: TransferViewModel
    private val sendFileUseCase: SendFileUseCase = mockk()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = TransferViewModel(sendFileUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when transfer starts, uiState should emit transferring`() = runTest {
        val uri = mockk<Uri>()
        val address = "192.168.1.1"
        
        every { sendFileUseCase(uri, address) } returns flowOf(
            TransferStatus.Progress(50, 100, 10.0, "file.txt")
        )

        viewModel.startTransfer(uri, address)
        testDispatcher.scheduler.advanceUntilIdle()

        val state = viewModel.uiState.value
        assertTrue(state is TransferUiState.Transferring)
        val transferring = state as TransferUiState.Transferring
        assertTrue(transferring.progress == 0.5f)
    }
}
