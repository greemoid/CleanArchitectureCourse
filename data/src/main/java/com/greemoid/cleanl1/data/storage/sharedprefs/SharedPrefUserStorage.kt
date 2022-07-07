package com.greemoid.cleanl1.data.storage.sharedprefs

import android.content.Context
import com.greemoid.cleanl1.data.storage.models.User
import com.greemoid.cleanl1.data.storage.UserStorage


private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRSTNAME = "firstname"
private const val KEY_LASTNAME = "lastname"
private const val DEF_LAST_NAME = "Def lastname"
private const val DEF_FIRST_NAME = "Def firstName"

class SharedPrefUserStorage(context: Context) : UserStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRSTNAME, user.firstName).apply()
        sharedPreferences.edit().putString(KEY_LASTNAME, user.lastName).apply()
        return true
    }

    override fun get(): User {
        val firstName = sharedPreferences.getString(KEY_FIRSTNAME, DEF_FIRST_NAME) ?: DEF_FIRST_NAME
        val lastName = sharedPreferences.getString(KEY_LASTNAME, DEF_LAST_NAME) ?: DEF_LAST_NAME

        return User(
            firstName = firstName,
            lastName = lastName
        )

    }
}