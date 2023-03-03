package com.aman.domain.usecases

import com.aman.domain.repository.CredRepository

class ReadCredsUseCase(
  private val credRepository: CredRepository
) {
  suspend operator fun invoke() = credRepository.readCreds()
}
