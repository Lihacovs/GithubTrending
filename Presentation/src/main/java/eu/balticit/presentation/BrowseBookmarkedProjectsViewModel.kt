package eu.balticit.presentation

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import eu.balticit.domain.interactor.bookmark.GetBookmarkedProjects
import eu.balticit.domain.model.Project
import eu.balticit.presentation.mapper.ProjectViewMapper
import eu.balticit.presentation.model.ProjectView
import eu.balticit.presentation.state.Resource
import eu.balticit.presentation.state.ResourceState
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class BrowseBookmarkedProjectsViewModel @Inject constructor(
        private val getBookmarkedProjects: GetBookmarkedProjects,
        private val mapper: ProjectViewMapper): ViewModel() {

    private val liveData: MutableLiveData<Resource<List<ProjectView>>> =
            MutableLiveData()

    override fun onCleared() {
        getBookmarkedProjects.dispose()
        super.onCleared()
    }

    fun getProjects(): LiveData<Resource<List<ProjectView>>> {
        return liveData
    }

    fun fetchProjects() {
        liveData.postValue(Resource(ResourceState.LOADING, null, null))
        return getBookmarkedProjects.execute(ProjectsSubscriber())
    }

    inner class ProjectsSubscriber: DisposableObserver<List<Project>>() {
        override fun onNext(t: List<Project>) {
            liveData.postValue(Resource(ResourceState.SUCCESS,
                    t.map { mapper.mapToView(it) }, null))
        }

        override fun onError(e: Throwable) {
            liveData.postValue(Resource(ResourceState.ERROR, null,
                    e.localizedMessage))
        }

        override fun onComplete() { }

    }

}