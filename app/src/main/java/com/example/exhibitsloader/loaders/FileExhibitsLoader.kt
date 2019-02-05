package com.example.exhibitsloader.loaders

import com.example.exhibitsloader.interfaces.ExhibitsLoader
import com.example.exhibitsloader.models.ExhibitonsList
import com.example.exhibitsloader.utils.JsonToModelsConvertor

class FileExhibitsLoader(val json: String?): ExhibitsLoader {
    private val mExhibit by lazy {
        json?.let { JsonToModelsConvertor().convertExhibit(it) }
    }
    override fun getExhibitList(): ExhibitonsList? {
        return mExhibit
    }
}