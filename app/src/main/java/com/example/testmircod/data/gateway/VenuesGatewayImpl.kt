package com.example.testmircod.data.gateway

import android.util.Log
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import com.example.testmircod.data.mappers.VenueMapper
import com.example.testmircod.data.mappers.VenuePhotoMapper
import com.example.testmircod.data.network.Api
import com.example.testmircod.data.storage.database.AppDatabase
import com.example.testmircod.data.storage.database.entity.VenueDbEntity
import com.example.testmircod.data.storage.database.entity.VenuePhotoDBEntity
import com.example.testmircod.domain.entity.VenueEntity
import com.example.testmircod.domain.gateway.VenuesGateway

class VenuesGatewayImpl constructor(
    private val api: Api,
    private val db: AppDatabase
) : VenuesGateway {

    override fun getVenuePhotos(venueId: String): Single<List<String>> {
        return api.getVenuePhotos(venueId)
            .flatMap {response ->
                Observable.fromIterable(response.response.photosList.items)
                    .map( VenuePhotoMapper::map)
                    .toList()
                    .doAfterSuccess {photoList ->
                        val venuePhotoDao = db.venuePhotoDao()
                        for(photo in photoList){
                            val photoDBEntity = VenuePhotoDBEntity(0, venueId, photo)
                            venuePhotoDao.insert(photoDBEntity)
                        }
                    }

            }.onErrorResumeNext {
                val venuePhotoDao = db.venuePhotoDao()
                val photoList = venuePhotoDao.getById(venueId)
                photoList?.let { list ->
                    Observable.fromIterable(list)
                        .map { item -> item.url }
                        .toList()
                }?:throw it

            }

    }

    override fun getVenues(limit: Int, location: String, radius: Int): Single<List<VenueEntity>> {
            return api.getVenues(limit, location, radius)
                .flatMap {
                    Observable.fromIterable(it.response.venuesList)
                        .map (VenueMapper::map)
                        .toList()
                }
                .doAfterSuccess {venueList ->
                    val venueDao = db.venueDao()
                    val venuePhotoDao = db.venuePhotoDao()
                    venueDao.removeAll()
                    venuePhotoDao.removeAll()
                    for(venueItem in venueList) {
                        val venue = VenueDbEntity(
                            0,
                            venueItem.id,
                            venueItem.name,
                            venueItem.address,
                            venueItem.distance,
                            venueItem.category,
                            venueItem.categoryIcon,
                            venueItem.postalCode,
                            venueItem.lat,
                            venueItem.lon
                        )
                        venueDao.insert(venue)
                    }
                }
                .onErrorResumeNext {
                    val venueDao = db.venueDao()
                    val venuesList = venueDao.getAll()
                    venuesList?.let {list ->
                        Observable.fromIterable(list)
                            .map {dbEntity ->
                                VenueEntity(//////
                                    dbEntity.venue_id,
                                    dbEntity.name,
                                    dbEntity.address,
                                    dbEntity.distance,
                                    dbEntity.category,
                                    dbEntity.categoryIcon,
                                    dbEntity.postalCode,
                                    dbEntity.lat,
                                    dbEntity.lon
                                )
                            }
                            .toList()
                    }?:throw it
                }

    }

    override fun clearCache(): Completable {
        return Completable.fromAction {
            db.venueDao().removeAll()
            db.venuePhotoDao().removeAll()
        }
    }

    override fun clearCacheById(venueId: String): Completable {
        return Completable.fromAction {
            val removeCount = db.venueDao().removeById(venueId)
            db.venuePhotoDao().removeById(venueId)

            Log.i("DATABASE", "$removeCount objects is removed")
        }
    }


}