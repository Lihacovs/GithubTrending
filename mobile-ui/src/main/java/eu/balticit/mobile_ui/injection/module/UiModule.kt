package eu.balticit.mobile_ui.injection.module

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import eu.balticit.domain.executor.PostExecutionThread
import eu.balticit.mobile_ui.UiThread
import eu.balticit.mobile_ui.bookmarked.BookmarkedActivity
import eu.balticit.mobile_ui.browse.BrowseActivity

@Module
abstract class UiModule {

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UiThread): PostExecutionThread

    @ContributesAndroidInjector
    abstract fun contributesBrowseActivity(): BrowseActivity

    @ContributesAndroidInjector
    abstract fun contributesBookmarkedActivity(): BookmarkedActivity
}