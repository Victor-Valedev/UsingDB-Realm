package com.victor.usingrealm.database


import com.victor.usingrealm.model.User
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

class DataBaseRealm {

    private val config = RealmConfiguration.Builder(
        schema = setOf( User::class )
    )

    private val realm = Realm.open( config.build() )

    fun save( user: User ){

        realm.writeBlocking {
            copyToRealm( user )
        }


    }

}