package com.sph.sgnetworkdata.userInterface

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sph.sgnetworkdata.R
import com.sph.sgnetworkdata.network.model.Record
import kotlinx.android.synthetic.main.layout_city_list.view.*


class NetworkDataAdapter(val networkDataList: MutableMap<String, MutableList<Record>>) :
    RecyclerView.Adapter<NetworkDataAdapter.NetworkDataViewHolder>() {

    private val keysSet: Array<String>


    init {
        keysSet = networkDataList.keys.toTypedArray()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NetworkDataViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_city_list, parent, false)
        return NetworkDataViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: NetworkDataViewHolder, position: Int) {

        holder.bindView(keysSet[position], networkDataList[keysSet[position]])
    }

    override fun getItemCount(): Int {
        return networkDataList.size
    }


    inner class NetworkDataViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindView(key: String, recordList: MutableList<Record>?) {
            itemView.tvLayoutYear.text = key
            itemView.tvLayoutNetWorkData.text = calculateYearData(recordList).toString()
            itemView.ivDecreaseIndicator.visibility =   if (compareQuarterData(recordList)) View.VISIBLE else View.INVISIBLE
        }


        fun calculateYearData(recordList: MutableList<Record>?): Double {

            var totatYearData = 0.0
            recordList!!.forEach { record ->
                totatYearData += record.volumeOfMobileData!!.toDouble()
            }
            return totatYearData
        }


        fun compareQuarterData(recordList: MutableList<Record>?): Boolean {

            var data = 0.0
            var compare = false

            recordList!!.forEachIndexed({ index, record ->

                if (index != 0 && data < record.volumeOfMobileData!!.toDouble()) {
                    compare = true
                    return true
                }
                data = record.volumeOfMobileData!!.toDouble()
            })

            return compare


        }


    }
}
