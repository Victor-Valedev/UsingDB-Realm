package com.victor.usingrealm.database


import com.victor.usingrealm.model.User
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults

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

    fun list() : RealmResults<User>{

        return realm.query<User>()
                    .find()
    }

}