package ua.od.amatsegor.presentation

import androidx.annotation.CallSuper

abstract class IPresenter<V: IView> {

    var view: V? = null

    @CallSuper
    open fun attach(view: V) {
        this.view = view
    }

    abstract fun detach()
}