package com.aman.mycred

import android.app.Application
import com.aman.data.di.DataModule
import com.aman.domain.di.DomainModule
import com.aman.mycred.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level.ERROR

class CredApplication: Application() {
  override fun onCreate() {
    super.onCreate()
    startKoin {
      androidLogger(level = ERROR)
      androidContext(this@CredApplication)
      modules(
        DomainModule,
        DataModule,
        PresentationModule
      )
    }
  }
}
