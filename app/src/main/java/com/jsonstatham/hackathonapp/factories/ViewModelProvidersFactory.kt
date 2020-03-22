package com.jsonstatham.hackathonapp.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import javax.inject.Inject
import javax.inject.Provider

class ViewModelProvidersFactory @Inject constructor(private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var currentCreator: Provider<out ViewModel>? = creators[modelClass]
        if (currentCreator === null) {
            for (entry in creators.entries) {
                if (modelClass.isAssignableFrom(entry.key)) {
                    currentCreator = entry.value
                    break
                }
            }
        }

        if (currentCreator === null) throw IllegalArgumentException("unknown model class ${modelClass.toString()}")

        try {
            return currentCreator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}
