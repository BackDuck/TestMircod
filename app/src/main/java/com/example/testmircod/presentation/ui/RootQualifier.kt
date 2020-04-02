package com.example.testmircod.presentation.ui

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class RootQualifier(val name: String = "")