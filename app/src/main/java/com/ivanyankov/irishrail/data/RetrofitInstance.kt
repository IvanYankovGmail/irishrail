package com.ivanyankov.irishrail.data

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.simpleframework.xml.convert.AnnotationStrategy
import org.simpleframework.xml.core.Persister
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class RetrofitInstance {
    companion object {
        private const val BASE_URL = "http://api.irishrail.ie/realtime/realtime.asmx/"
        private lateinit var retrofit: Retrofit

        fun getInstance(): Retrofit {
            if (!::retrofit.isInitialized) {
                val interceptor = HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }

                val client = OkHttpClient.Builder()
                    .addInterceptor(interceptor)

                val simplexXml =
                    SimpleXmlConverterFactory.createNonStrict(Persister(AnnotationStrategy()))

                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .addConverterFactory(simplexXml)
                    .client(client.build())
                    .build()
            }
            return retrofit
        }
    }
}