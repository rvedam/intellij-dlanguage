// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static net.masterthought.dlanguage.psi.interfaces.DLanguageTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import net.masterthought.dlanguage.psi.*;

public class DLanguageAsmLogOrExpImpl extends ASTWrapperPsiElement implements DLanguageAsmLogOrExp {

  public DLanguageAsmLogOrExpImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DLanguageVisitor) ((DLanguageVisitor)visitor).visitAsmLogOrExp(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public DLanguageAsmLogAndExp getAsmLogAndExp() {
    return findNotNullChildByClass(DLanguageAsmLogAndExp.class);
  }

  @Override
  @Nullable
  public DLanguageAsmLogOrExp getAsmLogOrExp() {
    return findChildByClass(DLanguageAsmLogOrExp.class);
  }

  @Override
  @Nullable
  public PsiElement getOpBoolOr() {
    return findChildByType(OP_BOOL_OR);
  }

}