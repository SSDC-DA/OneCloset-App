package com.dadada.onecloset.presentation.ui


object MainTabNav: Destination {
    override val route: String = NavigationRouteName.TAB
    override val title: String = NavigationTitle.TAB
}
object HomeNav : Destination {
    override val route: String = NavigationRouteName.HOME
    override val title: String = NavigationTitle.HOME
}

object ClosetNav: Destination {
    override val route: String = NavigationRouteName.CLOSET
    override val title: String = NavigationTitle.CLOSET
}

object CameraNav: Destination {
    override val route: String = NavigationRouteName.CAMERA
    override val title: String = NavigationTitle.CAMERA
}

object ClosetDetailNav: Destination {
    override val route: String = NavigationRouteName.CLOSET_DETAIL
    override val title: String = NavigationTitle.CLOSET_DETAIL
}

object ClothAnalysisNav: Destination {
    override val route: String = NavigationRouteName.CLOTH_ANALYSIS
    override val title: String = NavigationTitle.CLOTH_ANALYSIS
}

object ClothCourseNav: Destination {
    override val route: String = NavigationRouteName.CLOTH_COURSE
    override val title: String = NavigationTitle.CLOTH_COURSE
}

object ClothNav: Destination {
    override val route: String = NavigationRouteName.CLOTH
    override val title: String = NavigationTitle.CLOTH
}

object FittingNav: Destination {
    override val route: String = NavigationRouteName.FITTING
    override val title: String = NavigationTitle.FITTING
}

object CoordinationNav: Destination {
    override val route: String = NavigationRouteName.COORDINATION
    override val title: String = NavigationTitle.COORDINATION
}

object CoordinationResultNav: Destination {
    override val route: String = NavigationRouteName.COORDINATION_RESULT
    override val title: String = NavigationTitle.COORDINATION_RESULT
}

object GalleryNav: Destination {
    override val route: String = NavigationRouteName.CLOTH_ANALYSIS
    override val title: String = NavigationTitle.CLOTH_ANALYSIS
}

object AccountNav: Destination {
    override val route: String = NavigationRouteName.ACCOUNT
    override val title: String = NavigationTitle.ACCOUNT
}

object PhotoNav: Destination {
    override val route: String = NavigationRouteName.PHOTO
    override val title: String = NavigationTitle.PHOTO
}

object FittingResultNav: Destination {
    override val route: String = NavigationRouteName.FITTING_RESULT
    override val title: String = NavigationTitle.FITTING_RESULT
}

interface Destination {
    val route: String
    val title: String
}

object NavigationRouteName {
    const val TAB ="tab"
    const val HOME = "home"
    const val CLOSET = "closet"
    const val CAMERA = "camera"
    const val CLOSET_DETAIL = "closet_detail"
    const val CLOTH_ANALYSIS = "cloth_analysis"
    const val CLOTH_COURSE = "cloth_course"
    const val GALLERY = "gallery"
    const val CLOTH = "cloth"
    const val ACCOUNT = "account"
    const val FITTING = "fitting"
    const val COORDINATION = "coordination"
    const val COORDINATION_RESULT = "coordination_result"
    const val FITTING_RESULT = "fitting_result"
    const val PHOTO = "photo"
}

object NavigationTitle {
    const val TAB ="탭"
    const val HOME = "빠른 실행"
    const val CLOSET = "옷장"
    const val CAMERA = "카메라"
    const val CLOSET_DETAIL = "옷장 상세"
    const val CLOTH_ANALYSIS = "의류 등록"
    const val CLOTH_COURSE = "코스 추천"
    const val GALLERY = "갤러리"
    const val CLOTH = "옷 상세"
    const val ACCOUNT = "계정"
    const val FITTING = "가상피팅"
    const val COORDINATION = "데일리코디"
    const val COORDINATION_RESULT = "coordination"
    const val FITTING_RESULT = "가상피팅 결과"
    const val PHOTO = "사진"
}