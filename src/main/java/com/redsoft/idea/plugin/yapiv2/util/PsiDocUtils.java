package com.redsoft.idea.plugin.yapiv2.util;

import com.intellij.psi.PsiElement;
import com.intellij.psi.javadoc.PsiDocComment;
import com.intellij.psi.javadoc.PsiDocTag;
import com.intellij.psi.javadoc.PsiDocTagValue;
import com.jgoodies.common.base.Strings;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PsiDocUtils {

    private PsiDocUtils() {
    }

    public static PsiDocTag[] getTags(@NotNull PsiDocComment docComment) {
        return docComment.getTags();
    }

    @Nullable
    public static PsiDocTag getTagByName(@NotNull PsiDocComment docComment, String name) {
        return docComment.findTagByName(name);
    }

    @Nullable
    public static String getTagValueByName(@NotNull PsiDocComment docComment, String name) {
        PsiDocTag tag = getTagByName(docComment, name);
        PsiDocTagValue value;
        if (Objects.isNull(tag) || Objects.isNull(value = tag.getValueElement())) {
            return null;
        }
        return value.getText();
    }

    public static String getTagDescription(@NotNull PsiDocComment docComment) {
        return Stream.of(docComment.getDescriptionElements())
                .map(PsiElement::getText)
                .map(String::trim)
                .filter(Strings::isNotBlank)
                .collect(Collectors.joining());
    }

    public static boolean hasTag(@NotNull PsiDocComment docComment, String name) {
        return Objects.nonNull(getTagByName(docComment, name));
    }
}
