package com.apprizka.apprizka.data.model

@Parcelize
data class News (
        val judul:String ="",
        val link:String ="",
        val poster:String ="",
        val tipe:String ="",
        val waktu:String =""
) : Parcelable