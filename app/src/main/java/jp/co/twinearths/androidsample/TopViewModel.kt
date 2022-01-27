package jp.co.twinearths.androidsample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TopViewModel: ViewModel() {
    private val _inputMessage = MutableLiveData<String>()
    val inputMessage: LiveData<String> = _inputMessage

    val isNumber = MutableLiveData<Boolean>()
    fun setMessage(text:String) {
        _inputMessage.value = text
        try {
            val num: Int = text.toInt()
            isNumber.value = true
        } catch (e: NumberFormatException) {
            isNumber.value = false
        }
    }
}