package com.example.exam

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exam.databinding.ListItemBinding

interface ShowPersonListner{
    fun showPerson(name:String)
}

class AdapterPerson(private val clickListener: ShowPersonListner)
    : RecyclerView.Adapter<AdapterPerson.PersonViewHolder>() {


    var persons: List<Data> = emptyList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return PersonViewHolder(binding)
    }

    override fun getItemCount(): Int = persons.size

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = persons[position]

        holder.itemView.setOnClickListener{
            clickListener.showPerson(person.name)
        }

        with(holder.binding) {
            name.text = person.name
            surname.text = person.surname
            minimalInfo.text = person.minimalInfo
            image.setImageResource(person.pictureRes)

        }
    }

    class PersonViewHolder(var binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

}