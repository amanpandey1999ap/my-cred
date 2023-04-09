package com.aman.data.di

import androidx.room.Room
import com.aman.data.repository.CredRepositoryImpl
import com.aman.data.sources.local.CredDatabase
import com.aman.domain.repository.CredRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val DataModule = module {
  single {
    Room.databaseBuilder(
      context = androidContext(),
      CredDatabase::class.java,
      name = "cred_db"
    ).build()
  }

  single {
    get<CredDatabase>().getCredentialsDao()
  }

  single<CredRepository> { CredRepositoryImpl(get()) }
}
