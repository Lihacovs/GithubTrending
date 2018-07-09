package eu.balticit.data.repository

import eu.balticit.data.model.ProjectEntity
import io.reactivex.Observable

interface ProjectsRemote {

    fun getProjects(): Observable<List<ProjectEntity>>
}