package com.viniciussantos.authenticationsystem

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.viniciussantos.authenticationsystem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        val autenticacao = FirebaseAuth.getInstance()
       binding.btnCadastrar.setOnClickListener{
           val email = binding.editEmail.text.toString()
           val senha = binding.editSenha.text.toString()
           autenticacao.createUserWithEmailAndPassword(
                email,
                senha
              ).addOnSuccessListener {
               Toast.makeText(this, "Sucesso ao cadastrar", Toast.LENGTH_SHORT).show()
              }.addOnFailureListener{
               Toast.makeText(this, "Erro ao cadastrar", Toast.LENGTH_SHORT).show()
           }
       }
        binding.btnLogar.setOnClickListener{
            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()
            autenticacao.signInWithEmailAndPassword(
                email,
                senha
            ).addOnSuccessListener {
                Toast.makeText(this, "Sucesso ao Logar", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, HomeActivity::class.java))
            }.addOnFailureListener{
                Toast.makeText(this, "Erro ao Logar", Toast.LENGTH_SHORT).show()
            }


        }

    }
}