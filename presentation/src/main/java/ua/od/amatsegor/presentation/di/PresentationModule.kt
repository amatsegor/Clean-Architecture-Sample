package ua.od.amatsegor.presentation.di

import android.content.Context
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import ua.od.amatsegor.data.Repo
import ua.od.amatsegor.domain.Interactor
import ua.od.amatsegor.presentation.IMainPresenter
import ua.od.amatsegor.presentation.MainPresenter
import javax.inject.Named

@Module
class PresentationModule(private val context: Context) {

    @Provides
    fun provideContext(): Context = context

    @Provides
    fun providePresenter(interactor: Interactor, @Named("ui") uiScheduler: Scheduler, @Named("io") ioScheduler: Scheduler): IMainPresenter =
        MainPresenter(interactor, uiScheduler, ioScheduler)

    @Provides
    fun provideInteractor(repo: Repo): Interactor = Interactor(repo)
}