package alexandrethauvin.test.mediaretriever.di

import alexandrethauvin.test.mediaretriever.internal.MediaRepository
import alexandrethauvin.test.mediaretriever.internal.MediaRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object RepositoriesModule {

    @Provides
    fun providesMediaRepository(mediaRepositoryImpl: MediaRepositoryImpl): MediaRepository = mediaRepositoryImpl
}