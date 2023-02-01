package com.example.mvvmsample.utils

sealed class LoadingStatusType {
    class Loading: LoadingStatusType()
    class Loaded: LoadingStatusType()
}