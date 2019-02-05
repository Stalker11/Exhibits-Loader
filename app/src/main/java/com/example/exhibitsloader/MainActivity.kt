package com.example.exhibitsloader

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.exhibitsloader.adapters.MainAdapter
import com.example.exhibitsloader.adapters.VerticalAdapter
import com.example.exhibitsloader.interfaces.ExhibitsLoader
import com.example.exhibitsloader.interfaces.HorizontalOnClick
import com.example.exhibitsloader.interfaces.VerticalScrollOnClick
import com.example.exhibitsloader.loaders.FileExhibitsLoader
import com.example.exhibitsloader.models.ExhibitonsList
import com.example.exhibitsloader.utils.AssetJsonReader
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), HorizontalOnClick<Pair<String, String>>,
    VerticalScrollOnClick<ExhibitonsList.Exhibit> {
    private val mAssestLink: String = "images.json"
    override fun onClickHorizontal(model: Pair<String, String>) {

    }

    override fun onClickVertical(model: ExhibitonsList.Exhibit) {

    }

    private lateinit var mExhibitsLoader: ExhibitsLoader
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mExhibitsLoader = FileExhibitsLoader(
            AssetJsonReader.readJson(
                context = this,
                link = mAssestLink
            )
        )
        main_recycler_view.apply {
            adapter = MainAdapter(mExhibitsLoader.getExhibitList()!!, this@MainActivity, this@MainActivity)
            layoutManager = LinearLayoutManager(context)
        }
    }
}
