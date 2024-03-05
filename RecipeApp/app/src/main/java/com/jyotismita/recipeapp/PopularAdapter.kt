package com.jyotismita.recipeapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jyotismita.recipeapp.databinding.PopularRvItemBinding

class PopularAdapter(var dataList:ArrayList<Recipe>, var context: Context):RecyclerView.Adapter<PopularAdapter.ViewHolder> {
    inner class ViewHolder(var binding: PopularRvItemBinding):RecyclerView.ViewHolder(binding.row)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = PopularRvItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.popularImg
        holder.binding.popularTxt.text=dataList.get(position).title

        holder.binding.popularTime
    }
}