package kr.lul.study.list.app.configuration

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.lul.study.list.model.DataModel
import kr.lul.study.list.model.DataModelImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ComponentConfiguration {
    companion object {
        val TAG = ComponentConfiguration::class.simpleName
    }

    @Singleton
    @Provides
    fun provideDataModel(): DataModel = DataModelImpl()
}