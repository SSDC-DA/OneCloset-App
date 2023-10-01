package com.dadada.onecloset.presentation.ui.clothes.component.row

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dadada.onecloset.presentation.ui.components.DropDownRow
import com.dadada.onecloset.presentation.ui.theme.Green
import com.dadada.onecloset.presentation.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomEditRow(title: String, content: String, sheetState: SheetState, onClick: () -> Unit) {
    val reverse = sheetState.isVisible
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = title,
            style = Typography.titleMedium,
        )
        DropDownRow(
            component = {
                AssistChip(
                    onClick = { },
                    label = { Text(text = content, color = Color.White) },
                    colors = AssistChipDefaults.assistChipColors(containerColor = Green),
                    border = AssistChipDefaults.assistChipBorder(borderColor = Green),
                )
            },
            reverse = reverse,
            onClick = { onClick() },
        )
    }
}
