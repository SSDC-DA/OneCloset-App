package com.dadada.onecloset.presentation.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dadada.onecloset.presentation.ui.theme.Gray
import com.dadada.onecloset.presentation.ui.theme.Green
import com.dadada.onecloset.presentation.ui.theme.Paddings
import com.dadada.onecloset.presentation.ui.theme.Typography

@Composable
fun DropDownRow(
    modifier: Modifier = Modifier,
    component: @Composable () -> Unit,
    reverse: Boolean,
    onClick: () -> Unit,
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        component()
        DropDownButton(reverse = reverse) {
            onClick()
        }
    }
}

@Composable
fun ColorInformRow(title: String, content: Color, colorName: String) {
    Row(
        modifier = screenModifier.padding(vertical = Paddings.small),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            modifier = Modifier.padding(start = Paddings.medium),
            text = title,
            style = Typography.titleMedium.copy(fontWeight = FontWeight.ExtraBold),
        )
        if (content == Color.Magenta) {
            OtherColorItem()
        } else {
            ColorItem(color = content, name = colorName)
        }
    }
}

@Composable
fun ClothInformRow(title: String, content: String) {
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
            style = Typography.titleMedium.copy(fontWeight = FontWeight.ExtraBold),
        )
        SuggestionChip(
            border = SuggestionChipDefaults.suggestionChipBorder(borderColor = Green),
            onClick = { },
            label = { Text(text = content, color = Color.White) },
            colors = SuggestionChipDefaults.suggestionChipColors(containerColor = Green),
        )
    }
}

@Composable
fun TwoButtonRow(
    modifier: Modifier = Modifier,
    left: String,
    right: String,
    onClickLeft: () -> Unit,
    onClickRight: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(),
    ) {
        Text(
            modifier = Modifier
                .clickable { onClickLeft() }
                .weight(1f)
                .padding(vertical = 12.dp),
            text = left,
            style = Typography.titleLarge.copy(fontWeight = FontWeight.ExtraBold),
            textAlign = TextAlign.Center,
        )
        Text(
            modifier = Modifier
                .clickable { onClickRight() }
                .weight(1f)
                .padding(vertical = 12.dp),
            text = right,
            style = Typography.titleLarge.copy(fontWeight = FontWeight.ExtraBold),
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun RowWithSmallTwoButtons(
    modifier: Modifier = Modifier,
    left: String,
    right: String,
    onClickLeft: () -> Unit,
    onClickRight: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(),
    ) {
        Text(
            modifier = Modifier
                .clickable { onClickLeft() }
                .weight(1f)
                .padding(vertical = 12.dp),
            text = left,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center,
        )
        Text(
            modifier = Modifier
                .clickable { onClickRight() }
                .weight(1f)
                .padding(vertical = 12.dp),
            text = right,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun ClickableRow(id: Int, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(text = stringResource(id = id))
        Icon(
            imageVector = Icons.Filled.KeyboardArrowRight,
            contentDescription = "",
            tint = Color.LightGray,
        )
    }
}

@Composable
fun LicenseRow(content: String, version: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(text = content)
        Text(
            modifier = Modifier.padding(end = 4.dp),
            text = version,
            style = Typography.titleSmall.copy(Gray),
        )
    }
}
