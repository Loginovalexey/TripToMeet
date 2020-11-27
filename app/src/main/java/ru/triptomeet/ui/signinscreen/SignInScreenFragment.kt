package ru.triptomeet.ui.signinscreen


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.screen_sign_in.*
import org.koin.android.viewmodel.ext.android.viewModel
import ru.triptomeet.R
import ru.triptomeet.ui.IOnCallChangeScreen
import ru.triptomeet.ui.questionsscreen.QuestionsScreenFragment


class SignInScreenFragment : Fragment() {

    private val signInViewModel: SignInViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.screen_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        signInViewModel.signInPermission.observe(viewLifecycleOwner,
            { result ->
                when (result) {
                    SignInPermissionState.ALLOWED ->
                        (requireActivity() as IOnCallChangeScreen)
                            .replaceFragment(QuestionsScreenFragment())
                }
            }
        )

        continueAsGuestButton.setOnClickListener {
            signInViewModel.serverRequest()
        }
    }
}