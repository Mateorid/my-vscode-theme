package com.github.dinbtechit.vscodetheme.annotators

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import com.intellij.util.ObjectUtils

class FSharpAnnotator : BaseAnnotator() {
    companion object {
        val DEFAULT_KEYWORD: TextAttributesKey =
            ObjectUtils.notNull(
                TextAttributesKey.find("DEFAULT_KEYWORD"),
                DefaultLanguageHighlighterColors.KEYWORD,
            )
        val SECONDARY_KEYWORD: TextAttributesKey =
            TextAttributesKey.createTextAttributesKey("DEFAULT_SECONDARY_KEYWORD", DEFAULT_KEYWORD)
    }

    override fun getKeywordType(element: PsiElement): TextAttributesKey? {
        return when (element.text) {
            // control flow: if, then, else, elif, match, with
            "if",
            "then",
            "else",
            "elif",
            "match",
            "with" -> SECONDARY_KEYWORD

            // loops: for, in, do, while, yield
            "for",
            "in",
            "do",
            "while",
            "yield" -> SECONDARY_KEYWORD

            // Async/computation: return
            "return",
            "do!" -> SECONDARY_KEYWORD

            // Exceptions: try, with, finally
            "try",
            "finally" -> SECONDARY_KEYWORD

            else -> null
        }
    }
}
