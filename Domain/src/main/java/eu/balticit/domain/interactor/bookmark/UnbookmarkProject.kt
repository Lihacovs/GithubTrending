package eu.balticit.domain.interactor.bookmark

import eu.balticit.domain.executor.PostExecutionThread
import eu.balticit.domain.interactor.CompletableUseCase
import eu.balticit.domain.repository.ProjectsRepository
import io.reactivex.Completable
import javax.inject.Inject

/**
 * UseCase to unbookmark Project
 */
class UnbookmarkProject @Inject constructor(
        private val projectsRepository: ProjectsRepository,
        postExecutionThread: PostExecutionThread)
    : CompletableUseCase<UnbookmarkProject.Params>(postExecutionThread) {

    override fun buildUseCaseCompletable(params: Params?): Completable {
        if (params == null) throw IllegalArgumentException("Params can'not be null")
        return projectsRepository.unbookmarkProject(params.projectId)
    }

    data class Params constructor(val projectId: String) {
        companion object {
            fun forProject(projectId: String): Params {
                return Params(projectId)
            }
        }
    }
}