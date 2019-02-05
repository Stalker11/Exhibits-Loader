package com.example.exhibitsloader.utils

import android.content.Context

class AssetJsonReader {
    companion object {
        /**
         * Method read file from assets and return string. Use for reading text files
         * @param context Context context for opening input stream
         * @param link String asset file name
         * @return String? return read file
         */
        fun readJson(context: Context, link:String):String?{
            return context.assets?.open(link)?.bufferedReader()?.readText()
        }
    }
}