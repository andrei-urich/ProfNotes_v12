package ru.profsoft.profnotes_v1.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import ru.profsoft.profnotes_v1.R
import ru.profsoft.profnotes_v1.databinding.FragmentHomeBinding
import ru.profsoft.profnotes_v1.model.entity.Note
import ru.profsoft.profnotes_v1.model.entity.Task

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    private val viewPagerAdapter by lazy(::NotesAdapter)
    private val taskAdapter by lazy(::TaskAdapter)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(requireContext(), "Test0", Toast.LENGTH_SHORT).show()
        init()
    }

    fun init() {
        Toast.makeText(requireContext(), "Test", Toast.LENGTH_SHORT).show()
        binding.apply {
            vpNotes.adapter = viewPagerAdapter

            //Анимация перелистывания записей в ViewPager2
            vpNotes.offscreenPageLimit = 1
            val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
            val currentItemHorizontalMarginPx =
                resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
            val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx

            val pageTransformer =
                ViewPager2.PageTransformer { page, position ->
                    page.translationX = -pageTranslationX * position

                    page.scaleY = 1 - (0.25f * kotlin.math.abs(position))

                    page.alpha = 0.25f + (1 - kotlin.math.abs(position))
                }

            vpNotes.setPageTransformer(pageTransformer)

            val itemDecoration = HorizontalMarginItemDecoration(
                requireContext(),
                R.dimen.viewpager_current_item_horizontal_margin
            )
            vpNotes.addItemDecoration(itemDecoration)


            //Тестовые заметки
            viewPagerAdapter.addNote(
                listOf(
                    Note(
                        imageId = R.drawable.ic_test_note,
                        title = "Подключаем кнопки в метод",
                        date = "12/03/2022",
                        description = "Код будет похож на код, который мы обычно используем",
                        userImage = R.drawable.ic_test_user
                    ),
                    Note(
                        imageId = R.drawable.ic_test_note1,
                        title = "Подключаем кнопки в метод",
                        date = "16.05.2023",
                        description = "Для начала просто выведем сообщение, что кнопка нажата.",
                        userImage = R.drawable.ic_test_user
                    ),
                    Note(
                        imageId = R.drawable.ic_test_note2,
                        title = "Подключаем кнопки в метод",
                        date = "12/03/2022",
                        description = "Код будет похож на код, который мы обычно используем",
                        userImage = R.drawable.ic_test_user
                    ),
                    Note(
                        imageId = R.drawable.ic_test_note3,
                        title = "Подключаем кнопки в метод",
                        date = "16.05.2023",
                        description = "Для начала просто выведем сообщение, что кнопка нажата.",
                        userImage = R.drawable.ic_test_user
                    )
                )
            )

            rvNotes.adapter = taskAdapter
            rvNotes.layoutManager = object : LinearLayoutManager(requireContext()) {
            }
            //Тестовые задачи
            taskAdapter.addTask(
                listOf(
                    Task(
                        status = "Новая",
                        head = "Берегите себя и родных",
                        body = "Класс экрана отправителя имеет такое же название как у оригинала, с добавлением слова Directions в конце",
                        date = "11.08.2022"
                    ),
                    Task(
                        status = "В работе",
                        head = "Всё станет понятнее",
                        body = "Класс получателя имеет такое же имя как у оригинала, с добавлением слова Args в конце.",
                        date = "12.03.2023"
                    ),
                    Task(
                        status = "Новая",
                        head = "Берегите себя и родных",
                        body = "Класс экрана отправителя имеет такое же название как у оригинала, с добавлением слова Directions в конце",
                        date = "11.08.2022"
                    ),
                    Task(
                        status = "В работе",
                        head = "Всё станет понятнее",
                        body = "Класс получателя имеет такое же имя как у оригинала, с добавлением слова Args в конце.",
                        date = "12.03.2023"
                    ),
                    Task(
                        status = "Новая",
                        head = "Берегите себя и родных",
                        body = "Класс экрана отправителя имеет такое же название как у оригинала, с добавлением слова Directions в конце",
                        date = "11.08.2022"
                    ),
                    Task(
                        status = "В работе",
                        head = "Всё станет понятнее",
                        body = "Класс получателя имеет такое же имя как у оригинала, с добавлением слова Args в конце.",
                        date = "12.03.2023"
                    )
                )
            )
        }
    }


}

