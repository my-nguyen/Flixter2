package com.rahulpandey.recyclerview2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahulpandey.recyclerview2.databinding.ActivityMainBinding

private const val TAG = "MainActivity-Truong"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "onCreate")

        val contacts = mutableListOf<Contact>()
        // contacts.addAll(createContacts())
        val adapter = ContactsAdapter(contacts)
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(this)

        val viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        viewModel.contacts.observe(this, Observer {
            Log.d(TAG, "received contacts from ViewModel")
            contacts.clear()
            contacts.addAll(it)
            adapter.notifyDataSetChanged()
        })
    }

    private fun createContacts(): List<Contact> {
        Log.d(TAG, "createContacts")
        val contacts = mutableListOf<Contact>()
        for (i in 1..150)
            contacts.add(Contact("Person #$i", i))
        return contacts
    }
}