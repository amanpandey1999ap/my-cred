package com.aman.domain.usecases

import com.aman.domain.models.Credential
import com.aman.domain.repository.CredRepository

class DeleteCredUseCase(
  private val credRepository: CredRepository
) {
  suspend operator fun invoke(credId: Int) = credRepository.deleteCred(credId)
}
