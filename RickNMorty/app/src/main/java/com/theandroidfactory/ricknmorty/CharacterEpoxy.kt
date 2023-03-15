package com.theandroidfactory.ricknmorty

import com.airbnb.epoxy.EpoxyController
import com.squareup.picasso.Picasso
import com.theandroidfactory.ricknmorty.databinding.DetailHeaderBinding
import com.theandroidfactory.ricknmorty.databinding.DetailImageBinding
import com.theandroidfactory.ricknmorty.databinding.DetailItemBinding

class CharacterEpoxy : EpoxyController() {
    var isLoading = true
        set(value) {
            field = value
            if (field) {
                requestModelBuild()
            }
        }
    var response: MyResponse<Character>? = null
        set(value) {
            field = value
            if (field != null) {
                isLoading = false
                requestModelBuild()
            }
        }

    override fun buildModels() {
        if (isLoading) {
            // show loading state
            return
        }

        val body = response!!.data!!.body()!!
        Header(body.name, body.gender, body.status).id("header").addTo(this)
        Image(body.image).id("image").addTo(this)
        Item("Origin", body.origin.name).id("item_1").addTo(this)
    }

    data class Header(val name: String, val gender: String, val status: String): ViewBindingKotlinModel<DetailHeaderBinding>(R.layout.detail_header) {
        override fun DetailHeaderBinding.bind() {
            tvName.text = name
            tvStatus.text = status
            ivGender.setImageResource(
                if (gender.equals("male", true)) R.drawable.ic_male else R.drawable.ic_female
            )
        }
    }

    data class Image(val imageUrl: String): ViewBindingKotlinModel<DetailImageBinding>(R.layout.detail_image) {
        override fun DetailImageBinding.bind() {
            Picasso.get().load(imageUrl).into(ivImage)
        }
    }

    data class Item(val title: String, val description: String): ViewBindingKotlinModel<DetailItemBinding>(R.layout.detail_item) {
        override fun DetailItemBinding.bind() {
            tvTitle.text = title
            tvDescription.text = description
        }
    }
}