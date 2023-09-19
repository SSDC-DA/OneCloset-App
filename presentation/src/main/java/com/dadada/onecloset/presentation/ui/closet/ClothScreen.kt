package com.dadada.onecloset.presentation.ui.closet

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.navigation.NavHostController
import com.dadada.onecloset.domain.model.Cloth
import com.dadada.onecloset.presentation.ui.closet.component.ClothCourseView
import com.dadada.onecloset.presentation.ui.closet.component.ClothInformView
import com.dadada.onecloset.presentation.ui.common.ChipEditRow
import com.dadada.onecloset.presentation.ui.common.ColorEditRow
import com.dadada.onecloset.presentation.ui.common.CustomTabRow
import com.dadada.onecloset.presentation.ui.common.RoundedSquare
import com.dadada.onecloset.presentation.ui.common.RoundedSquareImageItem
import com.dadada.onecloset.presentation.ui.common.roundedSquareLargeModifier
import com.dadada.onecloset.presentation.ui.common.screenModifier
import com.dadada.onecloset.presentation.ui.utils.NetworkResultHandler
import com.dadada.onecloset.presentation.ui.utils.hexStringToColor
import com.dadada.onecloset.presentation.viewmodel.closet.ClosetViewModel

private const val TAG = "ClothScreen"
@Composable
fun ClothScreen(navHostController: NavHostController, closetViewModel: ClosetViewModel) {
    val clothState by closetViewModel.clothState.collectAsState()
    var cloth by remember { mutableStateOf(Cloth()) }

    LaunchedEffect(Unit) {
        closetViewModel.getCloth()
    }

    NetworkResultHandler(state = clothState) {
        cloth = it
    }

    var showType = remember { mutableStateOf(false) }
    var showColor = remember { mutableStateOf(false) }
    var showMaterial = remember { mutableStateOf(false) }

    var type = remember { mutableStateOf(cloth.type) }
    var material = remember { mutableStateOf(cloth.material) }
    var color = remember { mutableStateOf(cloth.color) }

    val titleList = listOf("세탁", "건조", "에어드레서")
    val contentList = listOf(cloth.laundry, cloth.dryer, cloth.airDressor)

    var selectedTabIndex by remember { mutableStateOf(0) }
    val handleTabClick = { newIndex: Int ->
        selectedTabIndex = newIndex
    }

    val tabs = listOf("코스 정보", "의류 정보")
    val tabWidths = remember {
        val tabWidthStateList = mutableStateListOf<Dp>()
        repeat(tabs.size) {
            tabWidthStateList.add(0.dp)
        }
        tabWidthStateList
    }


    Box(modifier = screenModifier) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            RoundedSquareImageItem(
                modifier = roundedSquareLargeModifier,
                imageUri = cloth.img.toUri(),
                icon = null,
            ) {

            }

            CustomTabRow(
                modifier = Modifier,
                tabs = tabs,
                selectedTabIndex = selectedTabIndex,
                tabWidths = tabWidths,
                tabClick = handleTabClick
            )

            when (selectedTabIndex) {
                0 -> { ClothCourseView(titleList = titleList, contentList = contentList) }
                else -> { ClothInformView(cloth = cloth) }
            }
        }
    }
}