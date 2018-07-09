package eu.balticit.data.store

import eu.balticit.data.repository.ProjectsDataStore
import javax.inject.Inject

/**
 * Used to Choose between Cache or Remote data source
 */
open class ProjectsDataStoreFactory @Inject constructor(
        private val projectsCacheDataStroe: ProjectsCacheDataStore,
        private val projectsRemoteDataStore: ProjectsRemoteDataStore) {

    open fun getDataStore(projectsCached: Boolean,
                          cacheExpired: Boolean): ProjectsDataStore{
        return if (projectsCached && !cacheExpired){
            projectsCacheDataStroe
        } else {
            projectsRemoteDataStore
        }
    }

    open fun getCacheDataStore(): ProjectsDataStore {
        return projectsCacheDataStroe
    }
}