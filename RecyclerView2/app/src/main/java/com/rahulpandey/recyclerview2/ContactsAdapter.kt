package com.rahulpandey.recyclerview2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rahulpandey.recyclerview2.databinding.ItemContactBinding

class ContactsAdapter(val contacts: List<Contact>): RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemContactBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(contact: Contact) {
            binding.name.text = contact.name
            binding.age.text = contact.age.toString()
            Glide.with(itemView).load(contact.imageUrl).into(binding.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemContactBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contacts[position])
    }

    override fun getItemCount() = contacts.size
}