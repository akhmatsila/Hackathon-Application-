package com.jsonstatham.hackathonapp.ui.Auth.Registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.gms.maps.model.Marker
import com.jsonstatham.hackathonapp.Models.Auth.Registration.Status
import com.jsonstatham.hackathonapp.R
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_auth.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class RegistrationFragment : DaggerFragment() {

    @Inject
    lateinit var factory : ViewModelProvider.Factory

    lateinit var viewModel : RegistrationFragmentViewModel
    lateinit var inputMail : EditText
    lateinit var inputUserName : EditText
    lateinit var inputPassword : EditText
    lateinit var regButton : Button
    lateinit var navController: NavController
    lateinit var progressBar : ProgressBar



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBar = view.findViewById(R.id.progress_bar_registration)

        navController = Navigation.findNavController(view)

        viewModel = ViewModelProviders.of(this,factory).get(RegistrationFragmentViewModel::class.java)

        inputMail = view.findViewById(R.id.mail_input)
        inputUserName = view.findViewById(R.id.user_name_input)
        inputPassword = view.findViewById(R.id.password_input)
        regButton = view.findViewById(R.id.registrate_button)


        regButton.setOnClickListener {
            viewModel.registrate(inputMail.text.toString(),inputUserName.text.toString(), inputPassword.text.toString())
        }

        viewModel.liveData.observe(viewLifecycleOwner , Observer {
            when(it.status) {
                 Status.REGISTRED-> {
                     progressBar.visibility = View.GONE
                     navController.navigate(R.id.authFragment)
                 }
                 Status.DUPLICATE -> {
                     progressBar.visibility = View.GONE
                     Toast.makeText(view.context, "This user already exists",Toast.LENGTH_LONG).show()
                 }
                 Status.ERROR -> {
                     progressBar.visibility = View.GONE
                     Toast.makeText(view.context, it.message!!,Toast.LENGTH_LONG).show()
                 }
                 Status.REGISTRATION -> progressBar.visibility = View.VISIBLE
            }
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onStopWorking()
    }

}
