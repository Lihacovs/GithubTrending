package eu.balticit.mobile_ui.injection.module

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.Provides
import eu.balticit.cache.ProjectsCacheImpl
import eu.balticit.cache.db.ProjectsDatabase
import eu.balticit.data.repository.ProjectsCache

@Module
abstract class CacheModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun providesDataBase(application: Application): ProjectsDatabase {
            return ProjectsDatabase.getInstance(application)
        }
    }

    @Binds
    abstract fun bindProjectsCache(projectsCache: ProjectsCacheImpl): ProjectsCache
}