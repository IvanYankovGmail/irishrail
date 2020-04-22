package com.ivanyankov.irishrail.ui.stations.recyclerviews

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.ivanyankov.irishrail.data.model.StationObject
import com.ivanyankov.irishrail.databinding.ItemStationBinding

class StationsAdapter(
    private val stations: List<StationObject>,
    private val listener: StationAdapterClickListener
) :
    RecyclerView.Adapter<StationsAdapter.StationViewHolder>(), Filterable {

    private val filteredStations = stations.toMutableList()

    class StationViewHolder(
        private val binding: ItemStationBinding,
        private val listener: StationAdapterClickListener
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(station: StationObject) {
            binding.apply {
                root.setOnClickListener {
                    listener.onStationClicked(station)
                }
                tvLocationFullName.text = station.stationDesc
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return StationViewHolder(ItemStationBinding.inflate(inflater, parent, false), listener)
    }

    override fun getItemCount() = filteredStations.size

    override fun onBindViewHolder(holder: StationViewHolder, position: Int) =
        holder.bind(filteredStations[position])

    override fun getFilter() = filter

    private val filter: Filter = object : Filter() {

        override fun performFiltering(sequence: CharSequence): FilterResults {
            return FilterResults().apply {
                values =
                    if (sequence.isEmpty()) {
                        stations
                    } else {
                        stations.filter { stationObject ->
                            stationObject.stationDesc?.contains(
                                sequence,
                                ignoreCase = true
                            ) == true
                        }
                    }
            }
        }

        override fun publishResults(sequence: CharSequence, result: FilterResults) {
            filteredStations.apply {
                clear()
                addAll((result.values as List<StationObject>))
            }
            notifyDataSetChanged()
        }
    }

    interface StationAdapterClickListener {
        fun onStationClicked(stationObject: StationObject)
    }
}