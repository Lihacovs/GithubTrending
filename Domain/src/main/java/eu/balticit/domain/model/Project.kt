package eu.balticit.domain.model

/**
 * Data model representation for Project entity
 */
class Project(val id: String, val name: String, val fullName: String,
              val starCount: String, val dateCreated: String,
              val ownerName: String, val ownerAvatar: String,
              val isBookmarked: Boolean)