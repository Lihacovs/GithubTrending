package eu.balticit.remote.model

import com.google.gson.annotations.SerializedName

/**
 * Implementation of Data module representation
 */
class OwnerModel(@SerializedName("login") val ownerName: String,
                 @SerializedName("avatar_url") val ownerAvatar: String) {
}