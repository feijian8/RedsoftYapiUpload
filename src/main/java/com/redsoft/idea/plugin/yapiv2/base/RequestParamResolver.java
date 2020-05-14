package com.redsoft.idea.plugin.yapiv2.base;

import com.intellij.psi.PsiMethod;
import com.redsoft.idea.plugin.yapiv2.model.YApiParam;
import org.jetbrains.annotations.NotNull;

public interface RequestParamResolver {

    void resolve(@NotNull PsiMethod m, @NotNull YApiParam target);
}
