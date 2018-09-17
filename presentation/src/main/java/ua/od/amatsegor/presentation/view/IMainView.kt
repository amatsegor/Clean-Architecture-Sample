package ua.od.amatsegor.presentation.view

import androidx.lifecycle.MutableLiveData
import ua.od.amatsegor.presentation.IView
import ua.od.amatsegor.presentation.entity.PresentationUserEntity

interface IMainView : IView {
    fun showError(exception: Exception)

    fun showUsers(users: List<PresentationUserEntity>)
}