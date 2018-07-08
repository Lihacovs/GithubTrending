package eu.balticit.domain.repository

import eu.balticit.domain.model.Project
import io.reactivex.Completable
import io.reactivex.Observable

/**
 * Rules to manipulate Project data model. Interface is used for abstraction to separate data access
 * from Data module.
 */
interface ProjectsRepository {

    fun getProjects(): Observable<List<Project>>

    fun bookmarkProject(projectId: String): Completable

    fun unbookmarkProject(projectId: String): Completable

    fun getBookmarkedProjects(): Observable<List<Project>>
}