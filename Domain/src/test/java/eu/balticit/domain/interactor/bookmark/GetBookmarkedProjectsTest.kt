package eu.balticit.domain.interactor.bookmark

import com.nhaarman.mockito_kotlin.whenever
import eu.balticit.domain.executor.PostExecutionThread
import eu.balticit.domain.model.Project
import eu.balticit.domain.repository.ProjectsRepository
import eu.balticit.domain.test.ProjectDataFactory
import io.reactivex.Observable
import io.reactivex.Single
import jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetBookmarkedProjectsTest {

    private lateinit var getBookmarkedProjects: GetBookmarkedProjects
    @Mock lateinit var projectsRepository: ProjectsRepository
    @Mock lateinit var postExecutionThread: PostExecutionThread

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        getBookmarkedProjects = GetBookmarkedProjects(projectsRepository, postExecutionThread)
    }

    @Test
    fun getBookmarkedProjectsCompletes() {
        stubProjectsRepositoryGetBookmarkedProjects(
                Observable.just(ProjectDataFactory.makeProjectList(2)))

        val testObserver = getBookmarkedProjects.buildUseCaseObservable().test()
        testObserver.assertComplete()
    }

    private fun stubProjectsRepositoryGetBookmarkedProjects(single: Observable<List<Project>>) {
        whenever(projectsRepository.getBookmarkedProjects())
                .thenReturn(single)
    }

}