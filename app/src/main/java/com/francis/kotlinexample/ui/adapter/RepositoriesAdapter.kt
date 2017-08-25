package com.francis.kotlinexample.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.francis.kotlinexample.R
import com.francis.kotlinexample.api.model.Repository
import kotlinx.android.synthetic.main.item_repository.view.*

/**
 * Created by Francis on 2017-5-31.
 */
class RepositoriesAdapter(private val repositories: MutableList<Repository>,
                          val onClick: (Repository) -> Unit):
        RecyclerView.Adapter<RepositoriesAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return repositories.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder ?.bindData(repositories[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder{
        return LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_repository, parent, false)
                .let { ViewHolder(it, onClick) }
    }

    class ViewHolder(itemView: View, val onClick: (Repository) -> Unit) : RecyclerView.ViewHolder(itemView){
        fun bindData(repository: Repository){
            with(repository){
                itemView.textViewTitle.text = repository.name
                itemView.textViewDescription.text = repository.description
                itemView.setOnClickListener { onClick(this) }
            }
        }
    }

}