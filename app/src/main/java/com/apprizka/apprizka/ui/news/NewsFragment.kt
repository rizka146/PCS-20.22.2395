package com.example.appfood.ui.news

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appfood.R

class NewsFragment : Fragment() {
    private val parent: MainActivity by lazy { activity as MainActivity }

    private lateinit var binding: FragmentNewsBinding
    private val viewModel: NewsViewModel by lazy { NewsViewModel() }

    private lateinit var viewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(inflater, container, false).apply {
            viewModel = this@NewsFragment.viewModel
            lifecycleOwner = this@NewsFragment
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
        observe()
    }


    private fun init() {
        binding.recycleView.adapter = NewsAdapter(parent)
        viewModel.listNews()
    }

    private fun observe(){
        viewModel.loading.observe(viewLifecycleOwner){

        }

        viewModel.actionState.observe(viewLifecycleOwner){
            if (it.isConsumed){
                Log.i("ActionState", "isConsumed")
            }else if (!it.isSuccess){
                Toast.makeText(parent, it.message, Toast.LENGTH_SHORT).show()
            }
        }
    }


}