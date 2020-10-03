package com.example.imagesearch.data

import androidx.paging.PagingSource
import com.example.imagesearch.api.PhotoApi
import retrofit2.HttpException
import java.io.IOException

private const val STARTED_POSITION_INDEX = 1

class PhotoPaging (
    private val photoApi: PhotoApi,
    private val query: String
): PagingSource<Int, Photo>(){

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        val positions = params.key ?: STARTED_POSITION_INDEX

        return try {
            val response = photoApi.searchPhotos(query, positions, params.loadSize)
            val photos = response.results

            LoadResult.Page(
                data = photos,
                prevKey = if (positions == STARTED_POSITION_INDEX ) null else positions - 1,
                nextKey = if (photos.isEmpty()) null else positions + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }

        }
}