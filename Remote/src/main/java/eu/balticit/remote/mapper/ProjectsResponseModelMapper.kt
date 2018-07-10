package eu.balticit.remote.mapper

import eu.balticit.data.model.ProjectEntity
import eu.balticit.remote.model.ProjectModel

class ProjectsResponseModelMapper: ModelMapper<ProjectModel, ProjectEntity> {

    override fun mapFromModel(model: ProjectModel): ProjectEntity {
        return ProjectEntity(model.id, model.name, model.fullName, model.starCount.toString(),
                model.dateCreated, model.owner.ownerName, model.owner.ownerAvatar, false)
    }
}