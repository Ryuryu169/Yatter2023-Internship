package com.dmm.bootcamp.yatter2023.di

import com.dmm.bootcamp.yatter2023.MainViewModel
import com.dmm.bootcamp.yatter2023.ui.login.LoginViewModel
import com.dmm.bootcamp.yatter2023.ui.post.PostViewModel
import com.dmm.bootcamp.yatter2023.ui.settings.SettingsViewModel
import com.dmm.bootcamp.yatter2023.ui.account.AccountViewModel
import com.dmm.bootcamp.yatter2023.ui.more.MoreViewModel
import com.dmm.bootcamp.yatter2023.ui.register.RegisterAccountViewModel
import com.dmm.bootcamp.yatter2023.ui.timeline.PublicTimelineViewModel
import com.dmm.bootcamp.yatter2023.ui.updateuser.UpdateUserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val viewModelModule = module {
  viewModel { MainViewModel(get()) }
  viewModel { PublicTimelineViewModel(get()) }
  viewModel { PostViewModel(get(), get()) }
  viewModel { RegisterAccountViewModel(get()) }
  viewModel { LoginViewModel(get()) }
  viewModel { SettingsViewModel(get())}
  viewModel { AccountViewModel(get()) }
  viewModel { UpdateUserViewModel(get()) }
  viewModel { MoreViewModel(get()) }
}
