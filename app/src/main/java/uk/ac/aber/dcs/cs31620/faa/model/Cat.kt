/**
 * Represents a Cat. This time as a Room Entity
 * @author Chris Loftus
 * @version 2
 */
package uk.ac.aber.dcs.cs31620.faa.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

@Entity(tableName = "cats")
data class Cat(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    var id: Int = 0,
    var name: String = "",
    var gender: Gender = Gender.FEMALE,
    var breed: String = "",
    var description: String = "",
    var dob: LocalDateTime = LocalDateTime.now(),
    @ColumnInfo(name = "admission_date")
    var admissionDate: LocalDateTime = LocalDateTime.now(),
    @ColumnInfo(name = "main_image_path")
    var imagePath: String = ""){

    fun isKitten(): Boolean {
        val today = LocalDate.now()
        val fromDays = dob.until(today, ChronoUnit.DAYS)

        return (fromDays < 365 )
    }

}