package eu.balticit.domain.interactor.bookmark

import eu.balticit.domain.executor.PostExecutionThread
import eu.balticit.domain.interactor.ObservableUseCase
import eu.balticit.domain.model.Project
import eu.balticit.domain.repository.ProjectsRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * UseCase to retrieve observable list of bookmarked Projects
 */
class GetBookmarkedProjects @Inject constructor(
        private val projectsRepository: ProjectsRepository,
        postExecutionThread: PostExecutionThread)
    : ObservableUseCase<List<Project>, Nothing>(postExecutionThread) {

    public override fun buildUseCaseObservable(params: Nothing?): Observable<List<Project>> {
        return projectsRepository.getBookmarkedProjects()
    }
}