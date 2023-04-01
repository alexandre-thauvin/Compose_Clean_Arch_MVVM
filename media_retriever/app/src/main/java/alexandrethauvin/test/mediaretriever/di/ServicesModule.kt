package alexandrethauvin.test.mediaretriever.di

import alexandrethauvin.test.mediaretriever.api.MediaService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
object ServicesModule {

    @Provides
    fun providesMediaService(retrofit: Retrofit): MediaService = retrofit.create()
}