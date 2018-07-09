package eu.balticit.data.repository

import eu.balticit.data.model.ProjectEntity
import io.reactivex.Completable
import io.reactivex.Observable

/**
 * Used to access data from both cache and remote sources
 */
interface ProjectsDataStore {

    fun getProjects(): Observable<List<ProjectEntity>>

    fun saveProjects(projects: List<ProjectEntity>): Completable

    fun clearProjects(): Completable

    fun getBookmarkedProjects(): Observable<List<ProjectEntity>>

    fun setProjectAsBookmarked(projectId: String): Completable

    fun setProjectAsNotBookmarked(projectId: String): Completable
}