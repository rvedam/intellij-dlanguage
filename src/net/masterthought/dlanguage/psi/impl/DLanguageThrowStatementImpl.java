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

public class DLanguageThrowStatementImpl extends ASTWrapperPsiElement implements DLanguageThrowStatement {

  public DLanguageThrowStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DLanguageVisitor) ((DLanguageVisitor)visitor).visitThrowStatement(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public DLanguageExpression getExpression() {
    return findNotNullChildByClass(DLanguageExpression.class);
  }

  @Override
  @NotNull
  public PsiElement getKwThrow() {
    return findNotNullChildByType(KW_THROW);
  }

  @Override
  @NotNull
  public PsiElement getOpScolon() {
    return findNotNullChildByType(OP_SCOLON);
  }

}