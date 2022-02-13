package com.petruciostech.conversordemoeda.util.retrofit

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

const val BASE_URL = "http://api.currencylayer.com/"

@Module
@InstallIn(SingletonComponent::class)
class RetrofitCurrencyTask{

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun task(retrofit: Retrofit):RetrofitCurrencyApi = retrofit.create(RetrofitCurrencyApi::class.java)
}