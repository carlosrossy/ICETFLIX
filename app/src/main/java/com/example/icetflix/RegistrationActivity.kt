package com.example.icetflix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.icetflix.databinding.ActivityRegistrationBinding

import com.google.firebase.auth.FirebaseAuth

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.txtConectarConta.setOnClickListener {
            val intent = Intent(this,SingInActivity::class.java)
            startActivity(intent)
        }
        binding.btnCadastrar.setOnClickListener{
            val email = binding.editEmail.text.toString()
            val pass = binding.editSenha.text.toString()
            val confirmPass = binding.editRepitirSenha.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()){
                if (pass == confirmPass){

                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if(it.isSuccessful){
                            val intent = Intent(this,SingInActivity::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    Toast.makeText(this, "A senha não corresponde", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Campos vazios não são permitidos !!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}