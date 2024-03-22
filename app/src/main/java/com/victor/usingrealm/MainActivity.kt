package com.victor.usingrealm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.victor.usingrealm.database.DataBaseRealm
import com.victor.usingrealm.databinding.ActivityMainBinding
import com.victor.usingrealm.model.User

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


    }


}