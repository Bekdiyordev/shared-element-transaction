package uz.beko404.sharedelementtransaction.ui

import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.doOnPreDraw
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import uz.beko404.sharedelementtransaction.R
import uz.beko404.sharedelementtransaction.adapter.Adapter
import uz.beko404.sharedelementtransaction.databinding.FragmentListBinding
import uz.beko404.sharedelementtransaction.utill.navigateSafe
import uz.beko404.sharedelementtransaction.utill.viewBinding

class ListFragment : Fragment(R.layout.fragment_list) {
    private val binding by viewBinding { FragmentListBinding.bind(it) }
    private val adapter by lazy { Adapter() }
    private val dataList = mutableListOf<Int>()
    private lateinit var layoutManager: StaggeredGridLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val animation =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        sharedElementEnterTransition = animation
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }
        loadData()
        setupUI()
    }

    private fun setupUI() = with(binding) {
        layoutManager = StaggeredGridLayoutManager(2, 1)
        recycler.layoutManager = layoutManager
        recycler.adapter = adapter

        adapter.listener = { image, view ->
            val extras = FragmentNavigatorExtras(view to "image_large")
            findNavController().navigateSafe(
                R.id.action_listFragment_to_detailFragment,
                bundleOf("image" to image),
                null,
                extras
            )
        }
    }

    private fun loadData() {
        dataList.clear()
        dataList.add(R.drawable.img_1)
        dataList.add(R.drawable.img_2)
        dataList.add(R.drawable.img_3)
        dataList.add(R.drawable.img_4)
        dataList.add(R.drawable.img_5)
        dataList.add(R.drawable.img_6)
        dataList.add(R.drawable.img_7)
        dataList.add(R.drawable.img_8)
        dataList.add(R.drawable.img_9)
        dataList.add(R.drawable.img_10)
        dataList.add(R.drawable.img_11)
        dataList.add(R.drawable.img_12)
        dataList.add(R.drawable.img_13)
        dataList.add(R.drawable.img_14)
        dataList.add(R.drawable.img_15)
        dataList.add(R.drawable.img_16)
        dataList.add(R.drawable.img_17)

        dataList.add(R.drawable.img_1)
        dataList.add(R.drawable.img_2)
        dataList.add(R.drawable.img_3)
        dataList.add(R.drawable.img_4)
        dataList.add(R.drawable.img_5)
        dataList.add(R.drawable.img_6)
        dataList.add(R.drawable.img_7)
        dataList.add(R.drawable.img_8)
        dataList.add(R.drawable.img_9)
        dataList.add(R.drawable.img_10)
        dataList.add(R.drawable.img_11)
        dataList.add(R.drawable.img_12)
        dataList.add(R.drawable.img_13)
        dataList.add(R.drawable.img_14)
        dataList.add(R.drawable.img_15)
        dataList.add(R.drawable.img_16)
        dataList.add(R.drawable.img_17)
        adapter.submitList(dataList)
    }
}