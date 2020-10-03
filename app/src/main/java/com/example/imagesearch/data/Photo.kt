package com.example.imagesearch.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photo(
    val id: String,
    val description: String?,
    val urls: PhotoUrl,
    val user: PhotoUser
) : Parcelable {

    @Parcelize
    data class PhotoUrl(
        val raw: String,
        val full: String,
        val regular: String,
        val small: String,
        val thumb: String,
    ) : Parcelable

    @Parcelize
    data class PhotoUser(
        val name: String,
        val username: String
    ) : Parcelable {
   //     val attributionUrl get() = "https://unsplash.com/$username?utm_source=Testmyskillkoko&utm_medium=referral"
    }

}