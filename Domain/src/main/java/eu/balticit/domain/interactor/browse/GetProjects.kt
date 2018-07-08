package eu.balticit.domain.interactor.browse

import eu.balticit.domain.executor.PostExecutionThread
import eu.balticit.domain.interactor.ObservableUseCase
import eu.balticit.domain.model.Project
import eu.balticit.domain.repository.ProjectsRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * UseCase to retrieve Project entity list observable
 */
class GetProjects @Inject constructor(
        private val projectsRepository: ProjectsRepository,
        postExecutionThread: PostExecutionThread)
    : ObservableUseCase<List<Project>, Nothing>(postExecutionThread) {

    public override fun buildUseCaseObservable(params: Nothing?): Observable<List<Project>> {
        return projectsRepository.getProjects()
    }
}