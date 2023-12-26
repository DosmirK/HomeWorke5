package com.example.homeworke5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homeworke5.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    lateinit var binding: FragmentFirstBinding
    var number = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener{
            if (binding.btnNext.text == "+1"){
                if (number < 10){
                    number++
                } else{
                    binding.btnNext.text = "-1"
                }
            } else {
                if (number > 0) {
                    number--
                } else{
                    openFragment()
                }
            }
            changText()
        }
    }

    private fun changText() {
        if(number == 10){
            binding.btnNext.text == "-1"
        }
        binding.textView.text = number.toString()
    }
    private fun openFragment(){
        var number = binding.textView.text.toString()
        var bundle = Bundle()
        bundle.putString("key",number)
        val secondFragment = SecondFragment()
        secondFragment.arguments = bundle
        val fragmentManager = requireActivity().supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, secondFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}