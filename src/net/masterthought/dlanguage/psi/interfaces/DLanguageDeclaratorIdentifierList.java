// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi.interfaces;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageDeclaratorIdentifierList extends PsiElement {

  @NotNull
  DLanguageDeclaratorIdentifier getDeclaratorIdentifier();

  @Nullable
  DLanguageDeclaratorIdentifierList getDeclaratorIdentifierList();

  @Nullable
  PsiElement getOpComma();

}