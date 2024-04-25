package uz.beko404.sharedelementtransaction.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import uz.beko404.sharedelementtransaction.databinding.ItemImageBinding

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {
    var listener: ((Int, ShapeableImageView) -> Unit)? = null
    private val dif = AsyncListDiffer(this, ITEM_DIFF)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = dif.currentList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(position)

    inner class ViewHolder(private val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(position: Int) = with(binding) {
            image.setImageResource(dif.currentList[position])
            image.transitionName = "${dif.currentList[position]}"

            root.setOnClickListener {
                listener?.invoke(dif.currentList[position], image)
            }
        }
    }

    fun submitList(items: List<Int>) {
        dif.submitList(items)
    }

    companion object {
        private val ITEM_DIFF = object : DiffUtil.ItemCallback<Int>() {
            override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean =
                oldItem == newItem
        }
    }
}