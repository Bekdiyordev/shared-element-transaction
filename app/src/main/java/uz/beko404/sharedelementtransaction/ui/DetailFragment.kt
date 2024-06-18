package uz.beko404.sharedelementtransaction.ui

import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.View
import uz.beko404.sharedelementtransaction.R
import uz.beko404.sharedelementtransaction.databinding.FragmentDetailBinding
import uz.beko404.sharedelementtransaction.utill.viewBinding

class DetailFragment : Fragment(R.layout.fragment_detail) {
    private val binding by viewBinding { FragmentDetailBinding.bind(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val animation =
            TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.move)
        binding.image.setImageResource(arguments?.getInt("image")!!)
        sharedElementEnterTransition = animation
        sharedElementReturnTransition = animation
    }
}