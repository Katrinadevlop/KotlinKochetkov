/*Лабораторная работа №27
Тема: Работа с регулярными выражениями
Подготовить многострочный текст достаточного объема для проверки работы регулярных выражений.
1. Проверить, есть ли в тексте указанное слово;
2. Проверить, есть ли в тексте указанное слово с учетом различных окончаний;
3. Найти в тексте все слова с одинаковым корнем;
4. Посчитать количество слов, длина которых более 5 символов;
5. Найти в тексте все даты;
6. Найти в тексте все время;
7. Разделить текст по определённому слову;
8. Определить по тексту ответа на телефонный звонок, что ответил ребёнок (как можно больше вариантов ответа, постарайтесь)
*/
package com.example.laba27

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val text = "11 ноября 2024 года я встретил своего друга Андрея. Мы договорились обсудить планы на ближайшие дни. Встреча началась в 10:30 утра и продлилась до 11:45. Он рассказал, как недавно организовал крупное мероприятие по планированию. Организация оказалась сложной, но результат оправдал ожидания.\n" +
                "\n" +
                "После обсуждения мы договорились встретиться 13 ноября в 18:00 в кафе. Дети Андрея позвонили ему в этот момент, и один из них ответил: «Алло!», другой сказал: «Да, это я». Они ждали его возвращения. Пока мы сидели в кафе, Андрей поделился планами на следующий год. Он хочет организовать спортивное мероприятие и привлечь как можно больше людей к активному образу жизни.\n" +
                "\n" +
                "Затем разговор перешел к его детям. Андрей рассказал, что старший сын недавно начал заниматься плаванием, а младшая дочь учится играть на пианино. Они уже добились успехов, и ему особенно приятно видеть, как дети увлечены своими хобби. Мы также обсудили его недавние успехи на работе, где он взял на себя организацию новых проектов. Весь процесс оказался трудоемким, но его организованность и упорство помогли справиться с трудностями.\n" +
                "\n" +
                "После встречи я занялся подготовкой к завтрашней тренировке. Организованность всегда важна в жизни, ведь она помогает достигать успехов. Иногда, конечно, возникают трудности, но они закаляют нас. Надеюсь, наш план поможет избежать возможных проблем. Жизнь часто преподносит сюрпризы, но с правильным подходом можно справиться с любой ситуацией. Закончился вечер поздним звонком от Андрея — он напомнил о предстоящей встрече, и мы снова обсудили все детали. \n"

        val view = findViewById<TextView>(R.id.textView)
        view.text = text

        val button = findViewById<Button>(R.id.button)
        val spinner = findViewById<Spinner>(R.id.spinner)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                when (p2) {
                    0 -> button.setOnClickListener {
                        findSpecifiedWord(text)
                    }
                    1 -> button.setOnClickListener {
                        findSpecifiedWordAccountEndings(text)
                    }
                    2 -> button.setOnClickListener {
                        findWordsSameRoot(text)
                    }
                    3 -> button.setOnClickListener {
                        countNumberLayers(text)
                    }
                    4-> button.setOnClickListener {
                        findDates(text)
                    }
                    5-> button.setOnClickListener {
                        findTimes(text)
                    }
                    6-> button.setOnClickListener {
                        splitTextSpecificWord(text)
                    }
                    7-> button.setOnClickListener {
                        identifyChildReplied(text)
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(this@MainActivity, "Выберите вариант", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun findSpecifiedWord(text: String) {
        val textView: TextView = findViewById(R.id.textView2)
        val containsWord = Regex("договорились")
        val foundWord = containsWord.find(text)?.value
        if (foundWord != null)
            textView.text = foundWord
        else
            textView.text = "Слово не найдено"
    }

    fun findSpecifiedWordAccountEndings(text: String) {
        val textView: TextView = findViewById(R.id.textView2)
        val containsWord = Regex("встр[а-я]*", RegexOption.IGNORE_CASE)
        val foundWords = containsWord.findAll(text).map { it.value }.toList()
        if (foundWords.isNotEmpty())
            textView.text = foundWords.joinToString(", ")
        else
            textView.text = "Слова не найдены"
    }

    fun findWordsSameRoot(text: String) {
        val textView: TextView = findViewById(R.id.textView2)
        val containsWord = Regex("[а-я]*говорил[а-я]*", RegexOption.IGNORE_CASE)
        val foundWords = containsWord.findAll(text).map { it.value }.toList()
        if (foundWords.isNotEmpty())
            textView.text = foundWords.joinToString(", " )
        else
            textView.text = "Слова не найдены"
    }

    fun countNumberLayers(text: String) {
        val textView: TextView = findViewById(R.id.textView2)
        val containsWord = Regex("\\w{6}", RegexOption.IGNORE_CASE)
        val foundWords = containsWord.findAll(text).map { it.value }.toList()
        if (foundWords.isNotEmpty()) {
            var count = 0
            for (i in 0..foundWords.size) count++
            textView.text = count.toString()
        }
        else
            textView.text = "Слова не найдены"
    }

    fun findDates(text: String) {
        val textView: TextView = findViewById(R.id.textView2)
        val containsWord = Regex("\\d{1,2} \\w+ \\d{4}", RegexOption.IGNORE_CASE)
        val foundWords = containsWord.findAll(text).map { it.value }.toList()
        if (foundWords.isNotEmpty())
            textView.text = foundWords.joinToString(", " )
        else
            textView.text = "Слова не найдены"
    }

    fun findTimes(text: String) {
        val textView: TextView = findViewById(R.id.textView2)
        val containsWord = Regex("\\d{1,2}:\\d{2}", RegexOption.IGNORE_CASE)
        val foundWords = containsWord.findAll(text).map { it.value }.toList()
        if (foundWords.isNotEmpty())
            textView.text = foundWords.joinToString(", " )
        else
            textView.text = "Слова не найдены"
    }

    fun splitTextSpecificWord(text: String) {
        val textView: TextView = findViewById(R.id.textView2)
        val containsWord = text.split("(?<=кафе)".toRegex(RegexOption.IGNORE_CASE))
        if (containsWord.isNotEmpty())
            textView.text = containsWord.joinToString("\n\n\n" )
        else
            textView.text = "Слова не найдены"
    }

    fun identifyChildReplied(text: String) {
        val textView: TextView = findViewById(R.id.textView2)
        val containsWord = Regex("(алло|да|привет, кто это)", RegexOption.IGNORE_CASE)
        val foundWords = containsWord.findAll(text).map { it.value }.toList()
        if (foundWords.isNotEmpty())
            textView.text = foundWords.joinToString(", " )
        else
            textView.text = "Слова не найдены"
    }
}