/**
 * Represents the home page. Currently shows some
 * static text an ImageView and a randomly selected
 * featured cat. Data is hard coded.
 * @author Chris Loftus
 * @version 2
 */
package uk.ac.aber.dcs.cs31620.faa.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uk.ac.aber.dcs.cs31620.faa.databinding.FragmentHomeBinding
import uk.ac.aber.dcs.cs31620.faa.datasource.FaaRepository
import java.time.LocalDateTime

class HomeFragment : Fragment() {

    private lateinit var  homeFragmentBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeFragmentBinding = FragmentHomeBinding.inflate(inflater, container, false)
        //val catList = CatList()
        //val listOfCats = catList.cats
        //val catPos = Random.nextInt(listOfCats.size)

        // val featuredCatImg = homeFragmentBinding.featuredImage
        //featuredCatImg.setImageResource(listOfCats[catPos].resourceId)

        val repository = FaaRepository(requireActivity().application)
        val past = LocalDateTime.now().minusDays(30)
        val recentCats = repository.getRecentCatsSync(past, LocalDateTime.now())

        return homeFragmentBinding.root
    }

}