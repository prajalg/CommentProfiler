package com.example.commentprofiler.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.commentprofiler.MainActivity
import com.example.commentprofiler.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var mAuth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mAuth = Firebase.auth
        binding.registerLogin.setOnClickListener{
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
        binding.btnLogin.setOnClickListener {
            val email = binding.editTextEmailAddress.text.toString()
            val pass = binding.editTextPassword.text.toString()
            if(email.isNotEmpty() && pass.isNotEmpty()){
                mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this){task->
                    if(task.isSuccessful){
                        Toast.makeText(this@Login, "Login successful", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@Login,MainActivity::class.java))
                    }
                    else{
                        Toast.makeText(this@Login, task.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }
    }
    override fun onStart() {
        super.onStart()
        val currentUser = mAuth.currentUser
        if(currentUser!=null){
            startActivity(Intent(this@Login,MainActivity::class.java))
        }
    }
}