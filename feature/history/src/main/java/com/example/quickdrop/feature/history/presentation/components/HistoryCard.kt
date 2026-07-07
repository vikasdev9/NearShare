package com.example.quickdrop.feature.history.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.quickdrop.core.designsystem.theme.BorderLight
import com.example.quickdrop.core.ui.components.PrimaryCard
import com.example.quickdrop.feature.history.domain.model.TransferRecord

@Composable
fun HistoryCard(
    records: List<TransferRecord>,
    modifier: Modifier = Modifier
) {
    PrimaryCard(
        modifier = modifier.fillMaxWidth(),
        elevation = 8.dp
    ) {
        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
            records.forEachIndexed { index, record ->
                TransferItem(record = record)
                if (index < records.size - 1) {
                    HorizontalDivider(
                        color = BorderLight,
                        thickness = 1.dp,
                        modifier = Modifier.padding(horizontal = 4.dp)
                    )
                }
            }
        }
    }
}
