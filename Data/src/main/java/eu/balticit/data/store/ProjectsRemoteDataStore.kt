package eu.balticit.data.store

import eu.balticit.data.model.ProjectEntity
import eu.balticit.data.repository.ProjectsDataStore
import eu.balticit.data.repository.ProjectsRemote
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class ProjectsRemoteDataStore @Inject constructor(
        private val projectsRemote: ProjectsRemote
) : ProjectsDataStore {

    override fun getProjects(): Observable<List<ProjectEntity>> {
        return projectsRemote.getProjects()
    }

    override fun saveProjects(projects: List<ProjectEntity>): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clearProjects(): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBookmarkedProjects(): Observable<List<ProjectEntity>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setProjectAsBookmarked(projectId: String): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setProjectAsNotBookmarked(projectId: String): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}