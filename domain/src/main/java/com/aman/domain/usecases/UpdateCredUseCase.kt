package com.aman.domain.usecases

import com.aman.domain.models.Credential
import com.aman.domain.repository.CredRepository

class UpdateCredUseCase(
  private val credRepository: CredRepository
) {
  suspend operator fun invoke(cred: Credential) = credRepository.updateCred(cred)
}
