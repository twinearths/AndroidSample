package jp.co.twinearths.androidsample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TopViewModel: ViewModel() {
    val inputMessage = MutableLiveData<String>()
    val isNumber = MutableLiveData<Boolean>()

    fun setMessage(text:String) {
        inputMessage.value = text
        try {
            val num: Int = text.toInt()
            isNumber.value = true
        } catch (e: NumberFormatException) {
            isNumber.value = false
        }
    }
}