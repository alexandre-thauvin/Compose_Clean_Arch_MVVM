package alexandrethauvin.test.mediaretriever

import alexandrethauvin.test.mediaretriever.api.GetLatestEpisodes
import alexandrethauvin.test.mediaretriever.models.Media
import alexandrethauvin.test.mediaretriever.models.MediaFetchingState
import alexandrethauvin.test.mediaretriever.ui.viewmodels.MainScreenViewModel
import app.cash.turbine.test
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.unmockkAll
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.time.ExperimentalTime

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
internal class MainScreenViewModelTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule(order = 1)
    val coroutineTestRule: CoroutineTestRule = CoroutineTestRule()

    @MockK
    lateinit var getLatestEpisodes: GetLatestEpisodes

    @Before
    fun setup() = MockKAnnotations.init(this)

    @After
    fun tearDown() = unmockkAll()

    @OptIn(ExperimentalCoroutinesApi::class, ExperimentalTime::class)
    @Test
    fun `should fetch data and emit state`() = runTest {
        val expectedList = listOf(Media(title = "toto", duration = 1000, urn = "my_urn"))
        coEvery { getLatestEpisodes() } returns expectedList

        val viewModel = obtainViewModel()

        viewModel.mediaFetchingState.test {
            Assert.assertEquals(
                MediaFetchingState.Loading,
                awaitItem()
            )
        }

        advanceUntilIdle()

        viewModel.mediaFetchingState.test {
            Assert.assertEquals(
                MediaFetchingState.Success(expectedList),
                awaitItem()
            )
        }

        coVerify { getLatestEpisodes() }
    }

    private fun obtainViewModel(): MainScreenViewModel = MainScreenViewModel(getLatestEpisodes)
}