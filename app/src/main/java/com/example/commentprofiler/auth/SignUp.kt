package com.example.commentprofiler.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.commentprofiler.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth

import com.google.firebase.ktx.Firebase

class SignUp : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var mAuth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mAuth = Firebase.auth
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginSignup.setOnClickListener{
            val intent = Intent(this,Login::class.java)
            startActivity(intent)
        }

        val actionBar = supportActionBar
        actionBar!!.title = "Sign up"

        binding.btnSignup.setOnClickListener{

            val email = binding.editTextEmailAddressSignup.text.toString()
            val pass = binding.editTextPasswordSignup.text.toString()
            val name = binding.editTextName.text.toString()

            if(email.isNotEmpty() && pass.isNotEmpty()){
                mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this){ task->
                    if(task.isSuccessful){
                        Toast.makeText(this@SignUp, "Sign up successful", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@SignUp,Login::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this@SignUp, task.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }
            else {
                Toast.makeText(this@SignUp, "Error", Toast.LENGTH_SHORT).show()
            }
        }


    }
}