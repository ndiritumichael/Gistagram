package com.vickikbt.gistagram.di

import com.vickikbt.gistagram.ui.screens.auth.AuthViewModel
import com.vickikbt.gistagram.ui.screens.profile.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel { AuthViewModel() }
    viewModel { ProfileViewModel(get()) }

}