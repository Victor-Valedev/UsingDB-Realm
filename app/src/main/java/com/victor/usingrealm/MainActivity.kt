package com.victor.usingrealm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.victor.usingrealm.database.DataBaseRealm
import com.victor.usingrealm.databinding.ActivityMainBinding
import com.victor.usingrealm.model.User
import org.mongodb.kbson.ObjectId

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate( layoutInflater )
    }

    private val realm by lazy {
        DataBaseRealm()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( binding.root )

        binding.btnSalvar.setOnClickListener {

            val recoveredName = binding.editTextNome.text.toString()

            val user = User().apply {
                name = recoveredName
                age = 23
            }
            realm.save( user )
        }

        binding.btnListar.setOnClickListener {

            val list = realm.list()

            var listText = ""

            list.forEach{ user ->
                listText += "${user.name} - age: ${user.age} \n"
                Log.i("info_realm","${user.id} - ${user.name}")
            }
            binding.textResultado.text = listText

        }

        binding.btnRemover.setOnClickListener {
            //exemple ID: 65fce2b29cb1524572fadc7d
            val id = ObjectId("example id selected")
            realm.remove( id )

        }

        binding.btnAtualizar.setOnClickListener {
            val recoveredName = binding.editTextNome.text.toString()
            val idSelected = ObjectId("65fe3bc24060344977b76e9b")
            val user = User().apply {
                id = idSelected
                name = recoveredName
                age = 27
            }

            realm.update( user )

        }


    }


}