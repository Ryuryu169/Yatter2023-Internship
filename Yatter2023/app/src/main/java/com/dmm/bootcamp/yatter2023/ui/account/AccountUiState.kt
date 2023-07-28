package com.dmm.bootcamp.yatter2023.ui.account

import com.dmm.bootcamp.yatter2023.domain.model.AccountId
import com.dmm.bootcamp.yatter2023.domain.model.Me
import com.dmm.bootcamp.yatter2023.domain.model.Username
import com.dmm.bootcamp.yatter2023.infra.domain.model.MeImpl

data class AccountUiState(
    val myself: Me,
    val isLoading: Boolean,
) {
    companion object {
        fun empty(): AccountUiState = AccountUiState(
            myself = MeImpl(
                id = AccountId(""),
                username = Username(""),
                displayName = "",
                note = "",
                avatar = null,
                header = null,
                followingCount = 0,
                followerCount = 0,
            ),
            isLoading = false,
        )
    }
}