package com.example.motivationapp.data

import com.example.motivationapp.infra.MotivationConstants
import kotlin.random.Random


data class Phrase(val description: String, val categoryId: Int)
class Mock {

    private val All = MotivationConstants.FILTER.ALL
    private val Happy = MotivationConstants.FILTER.HAPPY
    private val Sunny = MotivationConstants.FILTER.SUNNY

    private val mListPhrase = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", Happy),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", Happy),
        Phrase("Quando está mais escuro, vemos mais estrelas!", Happy),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", Happy),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", Happy),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", Happy),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", Sunny),
        Phrase("Você perde todas as chances que você não aproveita.", Sunny),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", Sunny),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", Sunny),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", Sunny),
        Phrase("Se você acredita, faz toda a diferença.", Sunny),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", Sunny)
    )

    fun getPhrase(value: Int): String {
        // Lista de frases baseado na categoria
        val filtrered = mListPhrase.filter { it.categoryId == value || value == All}
        // Random vai pegar do min_value ate o max_value
        return filtrered[Random.nextInt(filtrered.size)].description

    }


}