package eu.balticit.mobile_ui.injection.module

import dagger.Binds
import dagger.Module
import dagger.Provides
import eu.balticit.data.repository.ProjectsRemote
import eu.balticit.mobile_ui.BuildConfig
import eu.balticit.remote.ProjectsRemoteImpl
import eu.balticit.remote.service.GithubTrendingService
import eu.balticit.remote.service.GithubTrendingServiceFactory

@Module
abstract class RemoteModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideGithubService(): GithubTrendingService {
            return GithubTrendingServiceFactory.makeGithubTrendingService(BuildConfig.DEBUG)
        }
    }

    @Binds
    abstract fun bindProjectsRemote(projectsRemote: ProjectsRemoteImpl): ProjectsRemote
}