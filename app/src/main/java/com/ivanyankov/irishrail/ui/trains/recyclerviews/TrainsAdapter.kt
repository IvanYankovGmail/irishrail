package com.ivanyankov.irishrail.ui.trains.recyclerviews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ivanyankov.irishrail.databinding.ItemTrainBinding
import com.ivanyankov.irishrail.ui.trains.uimodel.TrainUiModel

class TrainsAdapter(
    private val trainsPositions: List<TrainUiModel>,
    private val listener: TrainAdapterClickListener
) :

    RecyclerView.Adapter<TrainsAdapter.TrainViewHolder>() {

    class TrainViewHolder(
        private val binding: ItemTrainBinding,
        private val listener: TrainAdapterClickListener
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(train: TrainUiModel) {
            binding.apply {
                root.setOnClickListener {
                    listener.onTrainClicked(train)
                }
                tvCode.text = train.trainCode
                tvDirection.text = train.direction
                tvStatus.text = train.status
                tvMessage.text = train.message
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TrainViewHolder(ItemTrainBinding.inflate(inflater, parent, false), listener)
    }

    override fun getItemCount() = trainsPositions.size

    override fun onBindViewHolder(holder: TrainViewHolder, position: Int) =
        holder.bind(trainsPositions[position])

    interface TrainAdapterClickListener {
        fun onTrainClicked(trainUiModel: TrainUiModel)
    }
}