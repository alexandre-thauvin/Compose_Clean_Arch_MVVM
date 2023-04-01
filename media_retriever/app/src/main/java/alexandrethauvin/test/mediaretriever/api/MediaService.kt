package alexandrethauvin.test.mediaretriever.api

import alexandrethauvin.test.mediaretriever.models.GetLatestEpisodesResponse
import retrofit2.http.GET

interface MediaService {

    @GET("integrationlayer/2.0/rts/mediaList/video/latestEpisodes")
    suspend fun getLatestEpisodes(): GetLatestEpisodesResponse
}