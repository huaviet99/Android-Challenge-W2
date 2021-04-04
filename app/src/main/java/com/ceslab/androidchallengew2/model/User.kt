package com.ceslab.androidchallengew2.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class User(
    var fullName: String = "CR7",
    var email: String = "ronaldo@gmail.com",
    var password: String = "123456",
    var phoneNumber: String = ""
) : Parcelable {
    override fun toString(): String {
        return fullName + " \n " + email + " \n " + password + " \n " + phoneNumber
    }
}