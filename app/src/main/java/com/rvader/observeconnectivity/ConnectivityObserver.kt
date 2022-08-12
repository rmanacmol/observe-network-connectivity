package com.rvader.observeconnectivity

import kotlinx.coroutines.flow.Flow

/**
 * Created by Renz Manacmol 12/08/2022.
 */

interface ConnectivityObserver {

    fun observe(): Flow<Status>

    enum class Status {
        Available, Unavailable, Losing, Lost
    }
}