package eu.balticit.remote.test.factory

import eu.balticit.remote.model.OwnerModel

object OwnerFactory {

    fun makeOwnerModel(): OwnerModel {
        return OwnerModel(DataFactory.randomUuid(), DataFactory.randomUuid())
    }

}