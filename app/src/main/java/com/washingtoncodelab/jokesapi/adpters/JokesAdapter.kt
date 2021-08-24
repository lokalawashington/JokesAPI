package com.washingtoncodelab.jokesapi.adpters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.washingtoncodelab.jokesapi.databinding.JokesRowBinding
import com.washingtoncodelab.jokesapi.models.Jokes

class JokesAdapter : ListAdapter<Jokes.JokesItem,JokesAdapter.MyViewHolder>(MyDiffUtil) {
    object MyDiffUtil: DiffUtil.ItemCallback<Jokes.JokesItem>() {
        override fun areItemsTheSame(oldItem: Jokes.JokesItem, newItem: Jokes.JokesItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: Jokes.JokesItem,
            newItem: Jokes.JokesItem
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }


    inner class MyViewHolder(private val binding:JokesRowBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(jokes: Jokes.JokesItem?) {
            binding.general.text = jokes?.type
            binding.punchline.text =jokes?.punchline
            binding.setup.text = jokes?.setup
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(JokesRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val jokes =getItem(position)
        holder.bind(jokes)
    }
}