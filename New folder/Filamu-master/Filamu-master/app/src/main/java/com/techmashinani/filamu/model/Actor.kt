package com.techmashinani.filamu.model

import android.os.Parcel
import android.os.Parcelable

data class Actor(val cast_id: Long,
                 val id: Long,
                 val character: String,
                 val creditId: String,
                 val gender: Int,
                 val name: String,
                 val order: Int,
                 val profile_path: String?)
    :Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readLong(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(cast_id)
        parcel.writeLong(id)
        parcel.writeString(character)
        parcel.writeString(creditId)
        parcel.writeInt(gender)
        parcel.writeString(name)
        parcel.writeInt(order)
        parcel.writeString(profile_path)
    }

    override fun describeContents(): Int {
        return hashCode()
    }

    companion object CREATOR : Parcelable.Creator<Actor> {
        override fun createFromParcel(parcel: Parcel): Actor {
            return Actor(parcel)
        }

        override fun newArray(size: Int): Array<Actor?> {
            return arrayOfNulls(size)
        }
    }

}


