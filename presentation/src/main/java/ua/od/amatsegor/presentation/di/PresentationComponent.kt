package ua.od.amatsegor.presentation.di

import dagger.Component
import ua.od.amatsegor.presentation.view.MainActivity

@Component(modules = [PresentationModule::class, RepoModule::class])
interface PresentationComponent {
    fun inject(activity: MainActivity)
}