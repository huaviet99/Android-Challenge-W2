package com.ceslab.androidchallengew1.model

class User(
    var fullName: String = "CR7",
    var email: String = "ronaldo@gmail.com",
    var password: String = "123456",
    var phoneNumber: String = ""
) {
    override fun toString(): String {
        return fullName + " \n " + email + " \n " + password + " \n " + phoneNumber
    }
}