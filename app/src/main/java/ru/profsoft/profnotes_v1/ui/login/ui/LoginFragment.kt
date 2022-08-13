package ru.profsoft.profnotes_v1.ui.login.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import ru.profsoft.profnotes_v1.R
import ru.profsoft.profnotes_v1.core.spanString
import ru.profsoft.profnotes_v1.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvLoginWithoutAuth.apply {
            text = text.spanString(
                startIndex = 4,
                endIndex = 24,
                color = requireContext().getColor(R.color.green)
            )
        }
        binding.tvRecoverPassword.apply {
            text = text.spanString(
                startIndex = 24,
                endIndex = 43,
                color = requireContext().getColor(R.color.yellow)
            )
        }
        binding.btnLogin.apply {

            setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_navigation_home)
            }
        }

        fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
    }
}



