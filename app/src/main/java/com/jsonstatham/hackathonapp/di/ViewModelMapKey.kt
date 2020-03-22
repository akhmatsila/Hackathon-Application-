package com.jsonstatham.hackathonapp.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import java.lang.annotation.Documented
import java.lang.annotation.ElementType
import java.lang.annotation.RetentionPolicy
import kotlin.reflect.KClass


@Suppress("DEPRECATED_JAVA_ANNOTATION")
@Documented
@java.lang.annotation.Target(ElementType.METHOD)
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
@MapKey
annotation class ViewModelMapKey(val value : KClass<out ViewModel>)

