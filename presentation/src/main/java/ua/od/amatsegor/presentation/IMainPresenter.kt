package ua.od.amatsegor.presentation

import ua.od.amatsegor.presentation.view.IMainView

abstract class IMainPresenter: IPresenter<IMainView>() {
    abstract fun onLoginButtonPressed()
}