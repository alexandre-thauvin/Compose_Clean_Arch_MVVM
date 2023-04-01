package alexandrethauvin.test.mediaretriever.internal

import alexandrethauvin.test.mediaretriever.api.GetLatestEpisodes
import alexandrethauvin.test.mediaretriever.models.Media
import javax.inject.Inject

internal class GetLatestEpisodesImpl @Inject constructor(private val getMediaRepository: MediaRepository): GetLatestEpisodes {

    override suspend operator fun invoke(): List<Media> = getMediaRepository.getLatestEpisodes()
}