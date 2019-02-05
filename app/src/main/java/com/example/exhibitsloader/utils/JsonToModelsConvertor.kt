package com.example.exhibitsloader.utils

import com.example.exhibitsloader.models.ExhibitonsList
import com.google.gson.Gson
import java.io.IOException

class JsonToModelsConvertor {
    /**
     * Transform json to [ExhibitonsList] model
     * @param json String json file
     * @return ExhibitonsList return converted model
     * @throws IOException throw exception if [Gson] cannot parse this format
     */
    @Throws(IOException::class)
    fun convertExhibit(json:String):ExhibitonsList{
        return Gson().fromJson(json,ExhibitonsList::class.java)
    }
}