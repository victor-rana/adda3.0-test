package women.fashion.compare.clothes.shop.womenshopping.offers.ui.register.viewmodel

import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable
import women.fashion.compare.clothes.shop.womenshopping.offers.data.repository.UserRepository
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.base.BaseViewModel
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.network.NetworkHelper
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.rx.SchedulerProvider

class FragmentSignupSecondViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val userRepository: UserRepository
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    val nameField: MutableLiveData<String> = MutableLiveData()
    val lastNameField: MutableLiveData<String> = MutableLiveData()
    val usernameField: MutableLiveData<String> = MutableLiveData()
    val bioField: MutableLiveData<String> = MutableLiveData()
    val dobField: MutableLiveData<String> = MutableLiveData()
    val genderSelection: MutableLiveData<String> = MutableLiveData()

    override fun onCreate() { }

    fun onNameChange(name: String){
        nameField.postValue(name)
    }

    fun onLastNameChange(lastName: String){
        lastNameField.postValue(lastName)
    }

    fun onUsernameChange(username: String){
        usernameField.postValue(username)
    }

    fun onBioChange(bio: String){
        bioField.postValue(bio)
    }

    fun onDobChange(name: String){
        dobField.postValue(name)
    }

    fun onGenderSelected(name: String){
        genderSelection.postValue(name)
    }

//    fun onUserSignUp(){
//        val email
//    }

}