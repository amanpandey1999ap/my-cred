package com.aman.domain.di

import com.aman.domain.usecases.CreateCredUseCase
import com.aman.domain.usecases.DeleteCredUseCase
import com.aman.domain.usecases.ReadCredsUseCase
import com.aman.domain.usecases.UpdateCredUseCase
import org.koin.dsl.module

val DomainModule = module {
  single { CreateCredUseCase(get()) }
  single { ReadCredsUseCase(get()) }
  single { UpdateCredUseCase(get()) }
  single { DeleteCredUseCase(get()) }
}

/*
 We use Singles to provide the dependencies
 get() method will search the required parameter in its global container
*/
