package com.dadada.onecloset.presentation.ui.clothes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.dadada.onecloset.domain.model.clothes.ClothesInfo
import com.dadada.onecloset.presentation.ui.NavigationItem
import com.dadada.onecloset.presentation.ui.clothes.component.view.ClothesListTabGridView
import com.dadada.onecloset.presentation.ui.components.button.CustomFloatingActionButton
import com.dadada.onecloset.presentation.ui.components.header.CustomHeader
import com.dadada.onecloset.presentation.ui.theme.screenModifier
import com.dadada.onecloset.presentation.ui.utils.NetworkResultHandler
import com.dadada.onecloset.presentation.ui.utils.PermissionRequester
import com.dadada.onecloset.presentation.ui.utils.Permissions
import com.dadada.onecloset.presentation.ui.utils.ShowToast
import com.dadada.onecloset.presentation.viewmodel.MainViewModel
import com.dadada.onecloset.presentation.viewmodel.closet.ClosetViewModel

@Composable
fun ClothListScreen(
    navHostController: NavHostController,
    mainViewModel: MainViewModel,
    closetViewModel: ClosetViewModel,
) {
    val clothListState by closetViewModel.clothListState.collectAsState()
    var clothList by remember { mutableStateOf(listOf<ClothesInfo>()) }
    var allClothList by remember { mutableStateOf(listOf<ClothesInfo>()) }

    var clickCourse by remember { mutableStateOf(false) }
    if (clickCourse) {
        PermissionRequester(
            permission = Permissions.readExternalStoragePermission,
            onDismissRequest = { clickCourse = !clickCourse },
            onPermissionGranted = {
                navHostController.navigate(NavigationItem.GalleryNav.route)
            },
        ) {
            clickCourse = !clickCourse
        }
    }

    LaunchedEffect(Unit) {
        closetViewModel.getClothList()
    }

    NetworkResultHandler(state = clothListState, mainViewModel = mainViewModel) {
        clothList = it
        allClothList = it
    }
    var showToast by remember {
        mutableStateOf(false)
    }
    if (showToast) {
        ShowToast(text = "옷장이 삭제됐어요.")
    }
    val closetDeleteState by closetViewModel.closetDeleteState.collectAsState()
    NetworkResultHandler(state = closetDeleteState, mainViewModel = mainViewModel) {
        showToast = true
        closetViewModel.resetNetworkStates()
        navHostController.popBackStack()
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        floatingActionButton = {
            CustomFloatingActionButton(title = "의류", icon = Icons.Default.Add) {
                clickCourse = !clickCourse
            }
        },
        topBar = {
            CustomHeader(
                navController = navHostController,
                isMore = !closetViewModel.isBasicCloset,
                isEdit = false,
                onClickEdit = { /*TODO*/ },
            ) {
                closetViewModel.deleteCloset()
            }
        },
    ) { paddingValues ->
        Column(modifier = screenModifier.padding(paddingValues)) {
            ClothesListTabGridView(
                clothItems = clothList,
                onClick = { id ->
                    navHostController.navigate("${NavigationItem.ClothNav.route}/$id")
                },
                onClickTab = { upperType ->
                    clothList = if (upperType == "전체") {
                        allClothList
                    } else {
                        allClothList.filter { it.upperType == upperType }
                    }
                },
            )
        }
    }
}
