package com.dev0.deliveryfood.di

import android.app.Application
import androidx.room.Room
import com.dev0.deliveryfood.core.data.DeliveryDatabase
import com.dev0.deliveryfood.feacture_order.data.repository.OrderRepositoryImpl
import com.dev0.deliveryfood.feacture_order.domain.repository.OrderRepository
import com.dev0.deliveryfood.feature_food.domain.repository.FoodRepository
import com.dev0.deliveryfood.feature_food.data.repository.FoodRepositoryImpl
import com.dev0.deliveryfood.feature_restaurant.data.repository.RestaurantRepositoryImpl
import com.dev0.deliveryfood.feature_restaurant.domain.repository.RestaurantRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Named("dbAssetName")
    @Provides
    @Singleton
    fun provideDatabaseFromAsset(): String {
        return "delivery.db"
    }

    @Provides
    @Singleton
    fun provideDeliveryDatabase(
        app: Application,
        @Named("dbAssetName") dbAsset: String
    ): DeliveryDatabase {
        return Room.databaseBuilder(app, DeliveryDatabase::class.java, DeliveryDatabase.DATABASE_NAME)
            .createFromAsset(dbAsset)
            .build()
    }


    @Provides
    @Singleton
    fun provideRestaurantRepository(db: DeliveryDatabase): RestaurantRepository {
        return RestaurantRepositoryImpl(db.restaurantDao)
    }

    @Provides
    @Singleton
    fun provideFoodRepository(db: DeliveryDatabase): FoodRepository {
        return FoodRepositoryImpl(db.foodDao)
    }

    @Provides
    @Singleton
    fun provideOrderRepository(db: DeliveryDatabase): OrderRepository {
        return OrderRepositoryImpl(db.orderHeaderDao, db.orderDetailDao)
    }

}