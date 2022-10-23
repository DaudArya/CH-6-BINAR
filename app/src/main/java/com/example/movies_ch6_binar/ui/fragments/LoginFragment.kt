package com.example.movies_ch6_binar.ui.fragments

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.movies_ch6_binar.R
import com.example.movies_ch6_binar.databinding.FragmentLoginBinding
import com.example.movies_ch6_binar.model.UserDatabase
import com.example.movies_ch6_binar.ui.MainActivity
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class LoginFragment : Fragment() {
    private var bind : FragmentLoginBinding? = null
    private val binding get() = bind!!
    private var dataUser: UserDatabase? = null
    private val viewModel : AuthViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bind = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataUser = UserDatabase.getData(requireContext())
        viewModel.getAccountData().observe(requireActivity()) {
            Log.e("Account Data ", "Username : ${it.username} Pass: ${it.password}")
        }


        binding.apply {
            snackbaropen()


            btn_login.setOnClickListener {
                binding.apply {
                    val user = etUsername.text.toString()
                    val pass = etPassword.text.toString()

                    when {
                        user.isEmpty() && pass.isEmpty() -> {
                            etUsername.error = "Fill the username"
                            etPassword.error = "Fill the password"
                        }
                        user.isEmpty() -> etUsername.error = "Fill the username"
                        pass.isEmpty() -> etPassword.error = "Fill the password"
                        else -> {

                            lifecycleScope.launch(Dispatchers.IO){
                                val data = dataUser?.userDao()?.getUsername(user)

                                activity?.runOnUiThread {
                                    when (data?.username) {
                                        user -> when (data.password) {
                                            pass -> {
//                                                var validateForm = false
//                                                viewModel.getAccountData().observe(requireActivity()) {
//                                                    validateForm = user == it.username && pass == it.password
//                                                }
                                                Toast.makeText(requireContext(), "Login Success", Toast.LENGTH_SHORT).show()
                                                activity?.let {
                                                    val intent = Intent(it, MainActivity::class.java)
                                                    it.startActivity(intent)}
                                            }
                                            else -> Toast.makeText(requireContext(), "Wrong Password", Toast.LENGTH_SHORT).show()
                                        }
                                        else -> Toast.makeText(requireContext(), "Wrong Username", Toast.LENGTH_SHORT).show()
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }
    }

    //SnackBar
    private fun snackbaropen() {
        tv_register.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            Snackbar.make(it,"Please Enter Your Data", Snackbar.LENGTH_LONG)
                .setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE)
                .setBackgroundTint(Color.parseColor("#000000"))
                .show()
        }
    }


//    override fun onStart() {
//        super.onStart()
//        if (shared.getBoolean(Constant.LOGIN, false)){
//            activity?.let {
//                val intent = Intent(it,MainActivity::class.java)
//                it.startActivity(intent)}
//        }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        bind = null
    }

//    private fun loginSession(user: String, pass: String) {
//        shared.apply {
//            put(Constant.USERNAME, user)
//            put(Constant.PASSWORD, pass)
//            put(Constant.LOGIN, true)
//        }
//    }
}