package com.br.samples.apis.utils.http

class DefaultHttpRequestManager: TemplateHttpRequestManager() {
    override fun executeOnError() = Unit
}