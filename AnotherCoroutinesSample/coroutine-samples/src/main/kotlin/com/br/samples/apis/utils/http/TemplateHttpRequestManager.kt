package com.br.samples.apis.utils.http

import com.br.samples.apis.utils.http.model.AbstractWrapperResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class TemplateHttpRequestManager {

    abstract fun executeOnError()

    suspend fun <T> makeRequest(request: () -> T): AbstractWrapperResult {
        return withContext(Dispatchers.IO) {
            try {
                AbstractWrapperResult.Success(request())
            } catch (e: Exception) {
                executeOnError()
                AbstractWrapperResult.Failure(e)
            }
        }
    }
}
