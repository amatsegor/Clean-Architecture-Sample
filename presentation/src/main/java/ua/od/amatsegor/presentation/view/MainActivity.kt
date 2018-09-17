package ua.od.amatsegor.presentation.view

import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main2.*
import ua.od.amatsegor.presentation.IMainPresenter
import ua.od.amatsegor.presentation.R
import ua.od.amatsegor.presentation.di.DaggerPresentationComponent
import ua.od.amatsegor.presentation.di.NetworkModule
import ua.od.amatsegor.presentation.di.PresentationModule
import ua.od.amatsegor.presentation.entity.PresentationUserEntity
import java.lang.Exception
import javax.inject.Inject

class MainActivity : AppCompatActivity(), IMainView {

    @Inject
    lateinit var presenter: IMainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        DaggerPresentationComponent.builder()
            .networkModule(NetworkModule("https://jsonplaceholder.typicode.com/"))
            .presentationModule(PresentationModule(this))
            .build()
            .inject(this)

        button.setOnClickListener {
            presenter.onLoginButtonPressed()
        }
    }

    override fun showUsers(users: List<PresentationUserEntity>) {
        Log.e("MainActivity", "showUsers")
        Toast.makeText(this, "List size: ${users.size}", Toast.LENGTH_LONG).show()
    }

    override fun showError(exception: Exception) {
        Toast.makeText(this, exception.message ?: "Exception", Toast.LENGTH_LONG).show()
    }

    override fun onStart() {
        super.onStart()
        presenter.attach(this)
    }

    override fun onStop() {
        presenter.detach()
        super.onStop()
    }
}
