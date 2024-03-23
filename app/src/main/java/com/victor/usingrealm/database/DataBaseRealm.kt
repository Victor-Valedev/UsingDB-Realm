package com.victor.usingrealm.database


import com.victor.usingrealm.model.User
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import org.mongodb.kbson.ObjectId

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

    fun remove( id: ObjectId ){

        realm.writeBlocking {
            val removeUser = query<User>("id == $0", id)
                             .find()
                             .first()

            delete( removeUser )

        }

    }

    fun update( user: User ){

        realm.writeBlocking {
            val updateUser = query<User>("id == $0", user.id)
                            .find()
                            .first()

            updateUser.name = user.name
            updateUser.age = user.age
        }


    }

}