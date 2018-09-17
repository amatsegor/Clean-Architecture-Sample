package ua.od.amatsegor.presentation

import android.util.Log
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import ua.od.amatsegor.domain.Interactor
import ua.od.amatsegor.presentation.mapper.PresentationUserMapper

class MainPresenter(
    private val interactor: Interactor,
    private val uiScheduler: Scheduler,
    private val ioScheduler: Scheduler
) : IMainPresenter() {

    private var disposable: Disposable? = null

    override fun onLoginButtonPressed() {
        Log.d("MainPresenter", "onLoginButtonPressed")

        disposable = interactor()
            .observeOn(uiScheduler)
            .subscribeOn(ioScheduler)
            .subscribe({ list ->
                view?.showUsers(list.map { PresentationUserMapper.map(it) })
            }, {
                view?.showError(Exception("Error"))
            })
    }

    fun cancel() {
        disposable?.dispose()
    }

    override fun detach() {
        cancel()
        view = null
    }
}