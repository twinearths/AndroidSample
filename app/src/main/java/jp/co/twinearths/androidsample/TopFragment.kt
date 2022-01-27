package jp.co.twinearths.androidsample
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import jp.co.twinearths.androidsample.databinding.FragmentTopBinding

class TopFragment : Fragment() {
    private  lateinit var viewModel: TopViewModel
    private  lateinit var binding: FragmentTopBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTopBinding.inflate(layoutInflater)
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel = ViewModelProvider(this).get(TopViewModel::class.java)
        viewModel.inputMessage.observe(viewLifecycleOwner,
            { value ->
                binding.inputResultTextView.text = value
            }
        )
        binding.topViewModel = viewModel

        binding.inputText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.setMessage(s.toString())
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      }
}