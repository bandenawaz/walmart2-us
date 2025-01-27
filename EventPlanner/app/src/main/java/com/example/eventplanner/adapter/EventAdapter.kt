package com.example.eventplanner.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.eventplanner.R
import com.example.eventplanner.model.Event

class EventAdapter(private val events: List<Event>): RecyclerView.Adapter<EventAdapter.EventViewHolder>(){


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EventAdapter.EventViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_event, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventAdapter.EventViewHolder, position: Int) {

        val event = events[position]
        holder.bind(event)
    }

    override fun getItemCount(): Int {

        return events.size

    }
    class EventViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        private val tvDate: TextView = itemView.findViewById(R.id.tvDate)
        private val tvTme: TextView = itemView.findViewById(R.id.tvTime)
        private val tvLocation: TextView = itemView.findViewById(R.id.tvLocation)

        fun bind(event: Event){
            tvTitle.text = event.title
            tvDate.text = event.date
            tvTme.text = event.title
            tvLocation.text = event.location
        }


    }

}