// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi.interfaces;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageInvariant extends PsiElement {

  @NotNull
  DLanguageBlockStatement getBlockStatement();

  @NotNull
  PsiElement getKwInvariant();

  @Nullable
  PsiElement getOpParLeft();

  @Nullable
  PsiElement getOpParRight();

}