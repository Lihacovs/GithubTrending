package eu.balticit.remote

import eu.balticit.data.model.ProjectEntity
import eu.balticit.data.repository.ProjectsRemote
import eu.balticit.remote.mapper.ProjectsResponseModelMapper
import eu.balticit.remote.service.GithubTrendingService
import io.reactivex.Observable
import javax.inject.Inject

class ProjectsRemoteImpl @Inject constructor(
        private val service: GithubTrendingService,
        private val mapper: ProjectsResponseModelMapper)
    : ProjectsRemote {

    override fun getProjects(): Observable<List<ProjectEntity>> {
        return service.searchRepositories("language:kotlin", "stars", "desc")
                .map {
                    it.items.map { mapper.mapFromModel(it) }
                }
    }
}