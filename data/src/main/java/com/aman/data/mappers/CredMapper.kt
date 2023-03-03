package com.aman.data.mappers

import com.aman.data.models.DCredential
import com.aman.domain.models.Credential

fun Credential.toDCredential() = DCredential(id, type, userId, password)
fun DCredential.toCredential() = Credential(id, type, userId, password)
