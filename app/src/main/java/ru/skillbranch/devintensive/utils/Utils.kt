package ru.skillbranch.devintensive.utils

object Utils {

    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)

        //return firstName to lastName
        return if (firstName == "") {
            Pair(null, null)
        } else {
            Pair(firstName, lastName)
        }
    }

    fun transliteration(payload: String, divider: String = " "): String {
        val firstName = replaceChars(payload.substringBefore(" ")).capitalize()
        val lastName = replaceChars(payload.substringAfter(" ")).capitalize()

        return firstName + divider + lastName
    }

    private fun replaceChars(payload: String): String {
        return payload.toLowerCase().replace(Regex("[абвгдеёжзийклмнопрстуфхцчшщъыьэюя]")) {
            when (it.value) {
                "а" -> "a"
                "б" -> "b"
                "в" -> "v"
                "г" -> "g"
                "д" -> "d"
                "е" -> "e"
                "ё" -> "e"
                "ж" -> "zh"
                "з" -> "z"
                "и" -> "i"
                "й" -> "i"
                "к" -> "k"
                "л" -> "l"
                "м" -> "m"
                "н" -> "n"
                "о" -> "o"
                "п" -> "p"
                "р" -> "r"
                "с" -> "s"
                "т" -> "t"
                "у" -> "u"
                "ф" -> "f"
                "х" -> "h"
                "ц" -> "c"
                "ч" -> "ch"
                "ш" -> "sh"
                "щ" -> "sh'"
                "ъ" -> ""
                "ы" -> "i"
                "ь" -> ""
                "э" -> "e"
                "ю" -> "yu"
                "я" -> "ya"
                else -> ""
            }
        }
    }

    fun toInitials(firstName: String?, lastName: String?): String? {

        if (firstName == "" || firstName == " ") {
            return null
        }

        if (lastName == "" || lastName == " ") {
            return null
        }

        val first = firstName?.get(0)?.toUpperCase()
        val last = lastName?.get(0)?.toUpperCase()

        if (first == null && last == null) {
            return null
        }

        if (first != null && last == null) {
            return "$first"
        }

        if (first == null && last != null) {
            return "$last"
        }

        return "$first$last"
    }
}