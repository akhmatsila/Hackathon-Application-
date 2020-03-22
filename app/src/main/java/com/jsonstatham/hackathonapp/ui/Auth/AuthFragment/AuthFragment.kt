package com.jsonstatham.hackathonapp.ui.Auth.AuthFragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.jsonstatham.hackathonapp.Manager
import com.jsonstatham.hackathonapp.Models.Auth.Auth.Status
import com.jsonstatham.hackathonapp.R
import com.jsonstatham.hackathonapp.ui.Main.MainActivity
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class AuthFragment : DaggerFragment(), View.OnClickListener {

    private lateinit var registerButton: TextView
    private lateinit var logButton: Button
    private lateinit var navController: NavController
    private lateinit var progressBar: ProgressBar


    @Inject
    lateinit var factory: ViewModelProvider.Factory

    @Inject
    lateinit var manager: Manager

    private lateinit var viewModel: AuthFragmentViewModel
    private lateinit var userInput: EditText
    private lateinit var passwordInput: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_auth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBar = view.findViewById(R.id.progress_bar_auth)
        logButton = view.findViewById(R.id.sign_in)
        logButton.setOnClickListener(this)
        registerButton = view.findViewById(R.id.register_button)
        passwordInput = view.findViewById(R.id.password_input)
        userInput = view.findViewById(R.id.user_input)
        registerButton.setOnClickListener(this)
        navController = Navigation.findNavController(view)
        viewModel = ViewModelProviders.of(this, factory).get(AuthFragmentViewModel::class.java)
        manager.authStatus.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.ERROR -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(view.context, it.message, Toast.LENGTH_LONG).show()
                }
                Status.LOGIN -> {
                    progressBar.visibility = View.GONE
                    val i: Intent = Intent(activity, MainActivity::class.java)
                    startActivity(i)
                }
                Status.SIGNING -> {
                    progressBar.visibility = View.VISIBLE
                }
                Status.LOGOUT -> {
                    progressBar.visibility = View.GONE
                }
            }
        })

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.register_button -> navController.navigate(R.id.action_authFragment_to_registrationFragment)
            R.id.sign_in -> viewModel.tryLogin(
                userInput.text.toString(),
                passwordInput.text.toString()
            )

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onStopWorking()
    }

}
