package com.dev.androidapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.androidapp.Item
import com.dev.androidapp.ItemAdapter
import com.dev.androidapp.R
import com.dev.androidapp.databinding.FragmentFilesBinding
import kotlinx.android.synthetic.main.fragment_files.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FilesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FilesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var searchView: SearchView
    private lateinit var binding: FragmentFilesBinding

    // dummy data
    private var metrics = listOf<Item>(
        Item(1, "Room1", "temperature", 25.1),
        Item(2, "Kitchen", "temperature", 22.2),
        Item(3, "Room1", "luminous intensity", 12.0),
        Item(4, "Kitchen", "luminous intensity",  3.2),
        Item(5, "Room1", "ac temperature set", 20.2),
        Item(6, "Room2", "ac temperature set", 19.5)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        binding = FragmentFilesBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_files, container, false)

        searchView = view.findViewById(R.id.widgetsSearch)
        searchView.clearFocus()
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d("TAG", "here")
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterList(newText)
                return true
            }
        })

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_files, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        showItems(metrics)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FilesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FilesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun showItems(items: List<Item>) {
        widgetsRecycler.layoutManager = LinearLayoutManager(activity)
        widgetsRecycler.adapter = ItemAdapter(items)
    }

    private fun filterList(text: String) {
        Toast.makeText(activity, "aaaaaaaaaaa", Toast.LENGTH_SHORT)

        val filteredList: MutableList<Item> = ArrayList<Item>()
        for (item in metrics) {
            if (item.title.lowercase().contains(text.lowercase())) {
                filteredList.add(item)
            }
        }

        if (filteredList.isEmpty()) {
            Toast.makeText(activity, "result not found for search", Toast.LENGTH_SHORT)
        }
        else {
//            widgetsRecycler.setFilteredList()
        }
    }
}