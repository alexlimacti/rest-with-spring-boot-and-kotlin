package com.indeas.restspringkotlin.exception

import java.util.*

class ExceptionResponse(
    val timestamp: Date,
    val message: String?,
    val details: String
)