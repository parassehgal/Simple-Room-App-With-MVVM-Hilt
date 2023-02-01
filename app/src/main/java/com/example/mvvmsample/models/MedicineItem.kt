package com.example.mvvmsample.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Data class to hold medicine item
 */
@Entity
data class MedicineItem(
    @SerializedName("company")
    @ColumnInfo(name = "company") val company: String?,

    @SerializedName("id")
    @PrimaryKey @ColumnInfo(name = "id") val id: String,

    @SerializedName("name")
    @ColumnInfo(name = "name") val name: String?,

    @SerializedName("packform")
    @ColumnInfo(name = "packform") val packform: String?,

    @SerializedName("strength")
    @ColumnInfo(name = "strength") val strength: String?,

    @SerializedName("strengthtype")
    @ColumnInfo(name = "strengthtype") val strengthtype: String?,

    @SerializedName("type")
    @ColumnInfo(name = "type") val type: String?
)
