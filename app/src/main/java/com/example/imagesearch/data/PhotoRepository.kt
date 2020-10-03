package com.example.imagesearch.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.imagesearch.api.PhotoApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhotoRepository @Inject constructor(private val photoApi: PhotoApi) {

    fun getSearchPhoto(query: String) = Pager (
        config = PagingConfig(
            pageSize = 20,
            maxSize = 100,
            enablePlaceholders = false

        ), pagingSourceFactory = { PhotoPaging(photoApi, query) }
    ).liveData

}