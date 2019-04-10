package ru.surfstudio.standard.ui.navigation

import ru.surfstudio.standard.ui.navigation.FeatureRoute.FragmentCrossFeatureRoute

class MainFolderFragmentRoute: FragmentCrossFeatureRoute() {
    override fun targetClassPath(): String {
        return "com.example.cf_main_folder.MainFolderFragmentView"
    }
}