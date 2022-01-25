package jp.co.twinearths.androidsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.navigation.Navigation

class TopFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_top, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textList = mutableListOf(
            TableData(RecyclerAdapter.HEADER_TYPE,"魚"),
            TableData(RecyclerAdapter.ITEM_TYPE,"マグロ"),
            TableData(RecyclerAdapter.ITEM_TYPE,"カツオ"),
            TableData(RecyclerAdapter.ITEM_TYPE,"サンマ"),
            TableData(RecyclerAdapter.HEADER_TYPE,"果物"),
            TableData(RecyclerAdapter.ITEM_TYPE,"リンゴ"),
            TableData(RecyclerAdapter.ITEM_TYPE,"イチゴ"),
            TableData(RecyclerAdapter.ITEM_TYPE,"ナシ"),
            TableData(RecyclerAdapter.ITEM_TYPE,"ミカン"),
            TableData(RecyclerAdapter.ITEM_TYPE,"スイカ"),
            TableData(RecyclerAdapter.ITEM_TYPE,"オレンジ"),
            TableData(RecyclerAdapter.ITEM_TYPE,"イチジク"),
            TableData(RecyclerAdapter.ITEM_TYPE,"モモ"),
            TableData(RecyclerAdapter.ITEM_TYPE,"マンゴー"),
        )

        recyclerView = view.findViewById(R.id.RecyclerList)
        val adapter = context?.let { RecyclerAdapter(it,textList, listener = {
            val bundle = bundleOf("title" to it)
            Navigation.findNavController(view).navigate(R.id.action_topFrament_to_secondFragment, bundle)
        }) }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }
}