package com.dadada.onecloset.presentation.ui.closet

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.navigation.NavHostController
import com.dadada.onecloset.presentation.ui.NavigationItem
import com.dadada.onecloset.presentation.ui.common.ChipEditRow
import com.dadada.onecloset.presentation.ui.common.ColorEditRow
import com.dadada.onecloset.presentation.ui.common.RoundedSquareImageItem
import com.dadada.onecloset.presentation.ui.common.RowWithTwoButtons
import com.dadada.onecloset.presentation.ui.common.SelectColorBottomSheet
import com.dadada.onecloset.presentation.ui.common.SelectMaterialBottomSheet
import com.dadada.onecloset.presentation.ui.common.SelectTypeBottomSheet
import com.dadada.onecloset.presentation.ui.common.roundedSquareLargeModifier
import com.dadada.onecloset.presentation.ui.common.screenModifier
import com.dadada.onecloset.presentation.ui.theme.Gray
import com.dadada.onecloset.presentation.ui.theme.Typography
import com.dadada.onecloset.presentation.ui.utils.ClothColor
import com.dadada.onecloset.presentation.ui.utils.Material
import com.dadada.onecloset.presentation.ui.utils.Type
import com.dadada.onecloset.presentation.ui.utils.colorToHexString
import com.dadada.onecloset.presentation.viewmodel.closet.ClosetViewModel


private const val TAG = "ClothAnalysisScreen"
@Composable
fun ClothAnalysisScreen(navHostController: NavHostController, closetViewModel: ClosetViewModel) {
    closetViewModel.cloth.material = Material.Denim.name
    closetViewModel.cloth.type = Type.Blouse.name
    closetViewModel.cloth.colorCode = colorToHexString(ClothColor.Black.color)

    Column(
        modifier = screenModifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RoundedSquareImageItem(
            modifier = roundedSquareLargeModifier,
            imageUri = closetViewModel.cloth.img.toUri(),
            icon = null,
        ) {

        }
        Spacer(modifier = Modifier.size(16.dp))
        ClothCreateInputView()
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = "*분석 결과가 정확한가요? 버튼을 클릭하면 수정할 수 있어요!",
            style = Typography.titleSmall.copy(color = Gray)
        )
        Spacer(modifier = Modifier.weight(1f))
        RowWithTwoButtons(left = "다시하기", right = "추천받기", onClickLeft = { /*TODO*/ }) {
            navHostController.navigate(NavigationItem.ClothCourseNav.route)
        }
    }
}

@Composable
fun ClothCreateInputView() {
    var showType = remember { mutableStateOf(false) }
    var showColor = remember { mutableStateOf(false) }
    var showMaterial = remember { mutableStateOf(false) }

    var type = remember { mutableStateOf<Type>(Type.Blouse) }
    var material = remember { mutableStateOf<Material>(Material.Denim) }
    var color = remember {
        mutableStateOf<ClothColor>(ClothColor.Black)
    }
    if (showType.value) {
        SelectTypeBottomSheet(show = showType, type)
    }

    if (showMaterial.value) {
        SelectMaterialBottomSheet(show = showMaterial, curMaterial = material)
    }

    if (showColor.value) {
        SelectColorBottomSheet(show = showColor, curColor = color)
    }

    Column(
        modifier = roundedSquareLargeModifier
    ) {
        Spacer(modifier = Modifier.size(12.dp))
        ChipEditRow("종류", type.value.name, reverse = showType)
        ChipEditRow("재질", material.value.name, reverse = showMaterial)
        ColorEditRow("색상", color.value.color, reverse = showColor)
        Spacer(modifier = Modifier.size(12.dp))
    }
}