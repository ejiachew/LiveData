package com.example.livedata.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AccountModel(accNo:String, owner:String, balance:Double) :ViewModel(){
    var accNo = ""
    var owner = ""
    private var _balance = MutableLiveData<Double>()
    val balance : LiveData<Double>
                    get() = _balance


    // MutableLiveData = the content can change
    // LiveData = the content cannot change anymore

    // Auto initialize, default constructor
    init {
        this.accNo = accNo
        this.owner = owner
        this._balance.value = balance
    }

    fun deposit(amount: Double) {
        _balance.value = (_balance.value)?.plus(amount)
    }

    fun withdraw(amount:Double){
        _balance.value = (_balance.value)?.minus(amount)
    }

}