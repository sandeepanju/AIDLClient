package com.example.aidlserver
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DummyUser(val name:String,val age:Int) :Parcelable
