package com.dadada.onecloset.presentation.ui.account.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import com.dadada.onecloset.domain.model.fitting.FittingModelInfo
import com.dadada.onecloset.presentation.ui.theme.BackGround
import com.dadada.onecloset.presentation.ui.utils.NetworkResultHandler
import com.dadada.onecloset.presentation.viewmodel.fitting.FittingViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FittingModelListBottomSheet(
    navHostController: NavHostController,
    fittingViewModel: FittingViewModel,
    onDismissRequest: () -> Unit
) {
    val modelListState by fittingViewModel.modelListState.collectAsState()
    var modelList by remember {
        mutableStateOf<List<FittingModelInfo>>(listOf())
    }

    LaunchedEffect(Unit) {
        fittingViewModel.getModelList()
    }

    NetworkResultHandler(state = modelListState, action = { modelList = it })

    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = {
            scope.launch { sheetState.hide() }
            onDismissRequest()
        },
        containerColor = BackGround
    ) {
        ModelListView(navHostController, modelList, fittingViewModel)
    }
}