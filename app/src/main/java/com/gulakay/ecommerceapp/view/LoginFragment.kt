package com.gulakay.ecommerceapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.gulakay.ecommerceapp.R
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {


    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth

        val currentUser = auth.currentUser
        if (currentUser!= null){
            val action = LoginFragmentDirections.actionLoginFragmentToProductsFragment()
            findNavController().navigate(action)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        logInButton.setOnClickListener{
            // Log in butonuna tıklandığında kullanıcı giriş işlemi yapılacak.

            auth.signInWithEmailAndPassword(
                emailText.text.toString(),
                passwordText.text.toString()
            ).addOnSuccessListener {
                val action =
                    LoginFragmentDirections.actionLoginFragmentToProductsFragment()
                findNavController().navigate(action)

            }.addOnFailureListener {
                // Hata aldık. Bu bize Exception olarak verildi

                Toast.makeText(requireContext(), it.localizedMessage, Toast.LENGTH_LONG).show()

            }

        }

            signUpButton.setOnClickListener {
                // Sign up butonuna tıklandığında kullanıcı kayıt işlemi yapılacak.

                auth.createUserWithEmailAndPassword(
                    emailText.text.toString(),
                    passwordText.text.toString()
                ).addOnFailureListener {
                    //Kullanıcı oluşturuldu

                    val action =
                        LoginFragmentDirections.actionLoginFragmentToProductsFragment()
                    findNavController().navigate(action)

                }.addOnFailureListener { exception ->
                    // Hata aldık. Bu bize Exception olarak verildi

                    Toast.makeText(requireContext(), exception.localizedMessage, Toast.LENGTH_LONG)
                        .show()

                }
            } }
}
