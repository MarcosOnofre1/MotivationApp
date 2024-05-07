package com.example.motivationapp.data

import com.example.motivationapp.infra.MotivationConstants
import kotlin.random.Random


data class Phrase(val description: String, val categoryId: Int, val lang: String )
class Mock {

    private val All = MotivationConstants.FILTER.ALL
    private val Happy = MotivationConstants.FILTER.HAPPY
    private val Sunny = MotivationConstants.FILTER.SUNNY

    private val langPt = MotivationConstants.LANGUAGE.PORTUGUESE
    private val langEn = MotivationConstants.LANGUAGE.ENGLISH

    private val mListPhrase = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", Happy, langPt),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", Happy, langPt),
        Phrase("Quando está mais escuro, vemos mais estrelas!", Happy, langPt),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", Happy, langPt),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", Happy, langPt),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", Happy, langPt),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", Sunny, langPt),
        Phrase("Você perde todas as chances que você não aproveita.", Sunny, langPt),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", Sunny, langPt),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", Sunny, langPt),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", Sunny, langPt),
        Phrase("Se você acredita, faz toda a diferença.", Sunny, langPt),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", Sunny, langPt),

        Phrase("Not knowing it was impossible, he went there and did it.", Happy, langEn),
        Phrase("You are not defeated when you lose, you are defeated when you give up!", Happy, langEn),
        Phrase("When it's darker, we see more stars!", Happy, langEn),
        Phrase("Insanity is always doing the same thing and expecting a different result.", Happy, langEn),
        Phrase("Don't stop when you're tired, stop when you're done.", Happy, langEn),
        Phrase("What can you do now that has the biggest impact on your success?", Happy, langEn),
        Phrase("The best way to predict the future is to invent it.", Sunny, langEn),
        Phrase("You lose every chance you don't take.", Sunny, langEn),
        Phrase("Failure is the spice that flavors success.", Sunny, langEn),
        Phrase(" As long as we are not committed, there will be hesitation!", Sunny, langEn),
        Phrase("If you don't know where you want to go, any way will do.", Sunny, langEn),
        Phrase("If you believe, it makes all the difference.", Sunny, langEn),
        Phrase("Risks must be taken, because the greatest danger is not risking anything!", Sunny, langEn),

    )

    fun getPhrase(value: Int, lang: String): String {
        // Lista de frases baseado na categoria
        val filtrered = mListPhrase.filter {
            (it.categoryId == value || value == All) && it.lang == lang}
        // Random vai pegar do min_value ate o max_value
        return filtrered[Random.nextInt(filtrered.size)].description

    }


}