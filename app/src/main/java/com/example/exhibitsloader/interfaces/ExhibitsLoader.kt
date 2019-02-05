package com.example.exhibitsloader.interfaces

import com.example.exhibitsloader.models.ExhibitonsList

interface ExhibitsLoader {
    fun getExhibitList(): ExhibitonsList?
}