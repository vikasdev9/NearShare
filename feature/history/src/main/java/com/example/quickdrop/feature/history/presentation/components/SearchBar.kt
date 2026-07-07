package com.example.quickdrop.feature.history.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.quickdrop.core.designsystem.theme.BorderLight
import com.example.quickdrop.core.designsystem.theme.SlateGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistorySearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        placeholder = {
            Text(
                text = "Search transfers...",
                color = SlateGray
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Search,
                contentDescription = null,
                tint = SlateGray
            )
        },
        shape = RoundedCornerShape(28.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = BorderLight,
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            containerColor = Color.White
        ),
        singleLine = true
    )
}
