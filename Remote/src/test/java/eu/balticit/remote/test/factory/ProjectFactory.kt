package eu.balticit.remote.test.factory

import eu.balticit.remote.model.ProjectModel


object ProjectFactory {

    fun makeProjectModel(): ProjectModel {
        return ProjectModel(DataFactory.randomUuid(),
                DataFactory.randomUuid(), DataFactory.randomUuid(),
                DataFactory.randomInt(), DataFactory.randomUuid(),
                OwnerFactory.makeOwnerModel())
    }

}