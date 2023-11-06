package com.example.movieapp.presentation.di

import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppModule::class,
        DatabaseModule::class,
        CacheDataModule::class,
        LocalDataModule::class,
        MovieModule::class,
        NetModule::class,
        RemoteDataModule::class,
        RepositoryModule::class,
        UseCaseModule::class,
    ]
)
interface AppComponent {

    fun movieSubcomponent() : MovieSubComponent.Factory

}