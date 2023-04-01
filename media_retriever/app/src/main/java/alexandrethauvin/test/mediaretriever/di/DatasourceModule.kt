package alexandrethauvin.test.mediaretriever.di

import alexandrethauvin.test.mediaretriever.api.MediaService
import alexandrethauvin.test.mediaretriever.internal.MediaDatasource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DatasourceModule {

    @Provides
    fun providesMediaDatasource(mediaService: MediaService): MediaDatasource = MediaDatasource(mediaService)
}