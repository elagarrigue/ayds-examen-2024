package ayds.apolo.songinfo.main

import ayds.apolo.songinfo.home.controller.HomeControllerInjector
import ayds.apolo.songinfo.home.model.HomeModelInjector
import ayds.apolo.songinfo.home.view.HomeViewInjector

fun main() {
    initGraph()
    HomeViewInjector.homeView.openView()
}

private fun initGraph() {
    HomeControllerInjector.init()
    HomeViewInjector.homeView.setHomeModel(HomeModelInjector.homeModel)
}
