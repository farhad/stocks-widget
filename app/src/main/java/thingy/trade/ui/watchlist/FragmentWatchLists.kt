package thingy.trade.ui.watchlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import thingy.trade.databinding.FragmentWatchListsBinding

class FragmentWatchLists : Fragment() {

    private var _binding: FragmentWatchListsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: WatchListViewModel by viewModels {
        return@viewModels ThingyViewModelFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentWatchListsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenCreated {
            viewModel.watchList.collect { viewState ->
                when (viewState) {
                    is WatchListsViewState.Success -> {
                        // show list
                    }

                    is WatchListsViewState.Error -> {
                        Toast.makeText(requireActivity(), viewState.message, Toast.LENGTH_LONG).show()
                    }

                    else -> {

                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}