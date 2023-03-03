package com.aman.domain.models

import com.aman.domain.usecases.CreateCredUseCase
import com.aman.domain.usecases.DeleteCredUseCase
import com.aman.domain.usecases.ReadCredsUseCase
import com.aman.domain.usecases.UpdateCredUseCase

data class CredUseCases(
  val createCredUseCase: CreateCredUseCase,
  val readCredsUseCase: ReadCredsUseCase,
  val updateCredUseCase: UpdateCredUseCase,
  val deleteCredUseCase: DeleteCredUseCase
)
