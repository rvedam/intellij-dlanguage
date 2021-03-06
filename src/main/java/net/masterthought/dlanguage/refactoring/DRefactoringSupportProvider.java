package net.masterthought.dlanguage.refactoring;

import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import net.masterthought.dlanguage.psi.DLanguageIdentifier;
import net.masterthought.dlanguage.resolve.DResolveUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

/**
 * Created by francis on 4/18/2017.
 */
public class DRefactoringSupportProvider extends RefactoringSupportProvider {
    @Override
    public boolean isSafeDeleteAvailable(@NotNull PsiElement element) {
        if (!(element instanceof DLanguageIdentifier))
            return false;
        final Set<PsiNamedElement> resolve = DResolveUtil.INSTANCE.findDefinitionNode(element.getProject(), (PsiNamedElement) element);
        return resolve.size() == 1;
    }


}
