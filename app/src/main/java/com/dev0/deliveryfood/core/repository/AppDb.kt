package com.dev0.deliveryfood.core.repository


import com.dev0.deliveryfood.core.data.DBHelper

class AppDb {
    companion object{
        lateinit var db: DBHelper
    }
}