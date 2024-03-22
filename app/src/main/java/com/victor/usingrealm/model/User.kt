package com.victor.usingrealm.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class User : RealmObject {

    @PrimaryKey
    var id: ObjectId = ObjectId.invoke()

    var name = ""
    var age = 0

}