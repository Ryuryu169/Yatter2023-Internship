package com.dmm.bootcamp.yatter2023.ui.timeline

import com.dmm.bootcamp.yatter2023.ui.timeline.bindingmodel.MediaBindingModel
import com.dmm.bootcamp.yatter2023.ui.timeline.bindingmodel.StatusBindingModel

data class MoreUiState(
    val status: StatusBindingModel?,
    val isLoading: Boolean,
    var currentNum: String,
) {
    companion object {
        fun empty(): MoreUiState = MoreUiState(
            status = StatusBindingModel(
                id = "id",
                displayName = "mito",
                username = "mitohato14",
                avatar = "https://avatars.githubusercontent.com/u/19385268?v=4",
                content = "preview content",
                attachmentMediaList = listOf(
                    MediaBindingModel(
                        id = "id",
                        type = "image",
                        url = "https://avatars.githubusercontent.com/u/39693306?v=4",
                        description = "icon"
                    )
                )
            ),
            currentNum = "id",
            isLoading = false,
        )
    }
}