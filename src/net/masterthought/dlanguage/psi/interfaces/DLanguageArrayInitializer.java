// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi.interfaces;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageArrayInitializer extends PsiElement {

  @Nullable
  DLanguageArrayMemberInitializations getArrayMemberInitializations();

  @NotNull
  PsiElement getOpBracketLeft();

  @NotNull
  PsiElement getOpBracketRight();

}