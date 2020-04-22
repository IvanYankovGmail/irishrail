package com.ivanyankov.irishrail.ui.trains.recyclerviews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ivanyankov.irishrail.R
import com.ivanyankov.irishrail.data.model.TrainMovements
import com.ivanyankov.irishrail.databinding.ItemStationBinding

class TrainStationsAdapter(private val trainsMovements: List<TrainMovements>) :

    RecyclerView.Adapter<TrainStationsAdapter.TrainStationViewHolder>() {

    class TrainStationViewHolder(private val binding: ItemStationBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(trainStation: TrainMovements) {
            val context = binding.root.context
            binding.apply {
                tvLocationFullName.text = trainStation.locationFullName
                tvArrival.text =
                    context.getString(R.string.scheduled_arrival, trainStation.scheduledArrival)
                tvDeparture.text =
                    context.getString(R.string.scheduled_departure, trainStation.scheduledDeparture)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainStationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TrainStationViewHolder(ItemStationBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount() = trainsMovements.size


    override fun onBindViewHolder(holder: TrainStationViewHolder, position: Int) =
        holder.bind(trainsMovements[position])
}