package alexandrethauvin.test.mediaretriever.di

import alexandrethauvin.test.mediaretriever.api.GetLatestEpisodes
import alexandrethauvin.test.mediaretriever.internal.GetLatestEpisodesImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object UseCasesModule {

    @Provides
    fun providesGetLatestEpisodes(getLatestEpisodesImpl: GetLatestEpisodesImpl): GetLatestEpisodes = getLatestEpisodesImpl
}