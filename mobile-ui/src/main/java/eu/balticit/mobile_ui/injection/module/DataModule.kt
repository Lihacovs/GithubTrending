package eu.balticit.mobile_ui.injection.module

import dagger.Binds
import dagger.Module
import eu.balticit.data.ProjectsDataRepository
import eu.balticit.domain.repository.ProjectsRepository

@Module
abstract class DataModule {

    @Binds
    abstract fun bindDataRepository(dataRepository: ProjectsDataRepository): ProjectsRepository
}