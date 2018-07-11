package eu.balticit.cache.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import eu.balticit.cache.db.ProjectConstants.DELETE_PROJECTS
import eu.balticit.cache.db.ProjectConstants.QUERY_BOOKMARKED_PROJECTS
import eu.balticit.cache.db.ProjectConstants.QUERY_PROJECTS
import eu.balticit.cache.db.ProjectConstants.QUERY_UPDATE_BOOKMARK_STATUS
import eu.balticit.cache.model.CachedProject
import io.reactivex.Flowable
import io.reactivex.Observable


@Dao
abstract class CachedProjectsDao {

    @Query(QUERY_PROJECTS)
    @JvmSuppressWildcards
    abstract fun getProjects(): Observable<List<CachedProject>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract fun insertProjects(projects: List<CachedProject>)

    @Query(DELETE_PROJECTS)
    abstract fun deleteProjects()

    @Query(QUERY_BOOKMARKED_PROJECTS)
    abstract fun getBookmarkedProjects(): Observable<List<CachedProject>>

    @Query(QUERY_UPDATE_BOOKMARK_STATUS)
    abstract fun setBookmarkStatus(isBookmarked: Boolean,
                                   projectId: String)

}