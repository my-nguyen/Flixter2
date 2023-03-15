package com.rahulpandey.recyclerview2

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

private const val TAG = "ViewModel-Truong"

class MyViewModel: ViewModel() {
    val contacts = MutableLiveData<List<Contact>>()
    init {
        Log.d(TAG, "init")
        contacts.value = createContacts()
    }

    // fun getContacts(): LiveData<List<Contact>> = contacts

    private fun createContacts(): List<Contact> {
        Log.d(TAG, "createContacts")
        val contacts = mutableListOf<Contact>()
        for (i in 1..150)
            contacts.add(Contact("Person #$i", i))
        return contacts
    }
}