package com.neeraj.whileinuselocation

import android.app.PendingIntent
import android.location.Location
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

enum class Status {
    SUCCESS, FAILURE
}

@Parcelize
open class Result constructor(
   private val status: Status,
    val pendingIntent: PendingIntent? = null,
    val location: Location? = null
) : Parcelable {

    companion object {
        fun success(location: Location): Result =
            Result(Status.SUCCESS, pendingIntent = null, location)

        fun error(pendingIntent: PendingIntent): Result = Result(Status.FAILURE, pendingIntent)
    }

    val isSuccess = status == Status.SUCCESS
}
