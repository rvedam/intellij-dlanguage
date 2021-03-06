package net.masterthought.dlanguage.psi.impl.named;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReference;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.util.PsiTreeUtil;
import net.masterthought.dlanguage.icons.DLanguageIcons;
import net.masterthought.dlanguage.psi.*;
import net.masterthought.dlanguage.psi.impl.DNamedStubbedPsiElementBase;
import net.masterthought.dlanguage.psi.references.DReference;
import net.masterthought.dlanguage.stubs.DLanguageTemplateParameterStub;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class DLanguageTemplateParameterImpl extends DNamedStubbedPsiElementBase<DLanguageTemplateParameterStub> implements DLanguageTemplateParameter {

    public DLanguageTemplateParameterImpl(final DLanguageTemplateParameterStub stub, final IStubElementType type) {
        super(stub, type);
    }

    public DLanguageTemplateParameterImpl(final ASTNode node) {
        super(node);
    }

    public void accept(@NotNull final DLanguageVisitor visitor) {
        visitor.visitTemplateParameter(this);
    }

    public void accept(@NotNull final PsiElementVisitor visitor) {
        if (visitor instanceof DLanguageVisitor) accept((DLanguageVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public DLanguageTemplateAliasParameter getTemplateAliasParameter() {
        return PsiTreeUtil.getChildOfType(this, DLanguageTemplateAliasParameter.class);
    }

    @Override
    @Nullable
    public DLanguageTemplateThisParameter getTemplateThisParameter() {
        return PsiTreeUtil.getChildOfType(this, DLanguageTemplateThisParameter.class);
    }

    @Override
    @Nullable
    public DLanguageTemplateTupleParameter getTemplateTupleParameter() {
        return PsiTreeUtil.getChildOfType(this, DLanguageTemplateTupleParameter.class);
    }

    @Override
    @Nullable
    public DLanguageTemplateTypeParameter getTemplateTypeParameter() {
        return PsiTreeUtil.getChildOfType(this, DLanguageTemplateTypeParameter.class);
    }

    @Override
    @Nullable
    public DLanguageTemplateValueParameter getTemplateValueParameter() {
        return PsiTreeUtil.getChildOfType(this, DLanguageTemplateValueParameter.class);
    }

    private DLanguageIdentifier getIdentifier() {
        if (getTemplateAliasParameter() != null) {
            return getTemplateAliasParameter().getIdentifier();
        }
        if (getTemplateThisParameter() != null) {
            return getTemplateThisParameter().getTemplateTypeParameter().getIdentifier();
        }
        if (getTemplateTupleParameter() != null) {
            return getTemplateTupleParameter().getIdentifier();
        }
        if (getTemplateTypeParameter() != null) {
            return getTemplateTypeParameter().getIdentifier();
        }
        if (getTemplateValueParameter() != null) {
            return getTemplateValueParameter().getIdentifier();
        }
        throw new IllegalStateException("this shouldn't happen. Apparently theres some kind of template parameter that is neither, alias,this,tuple,type,or value");
    }


    @NotNull
    public String getName() {
        if (getStub() != null) {
            return getStub().getName();
        }
        if (getIdentifier() == null) {
            return DReference.Companion.getNAME_NOT_FOUND_STRING();
        }
        return getIdentifier().getName();
    }

//  public String getFullName() {
//    return DPsiImplUtil.getFullName(this);
//  }

    @Nullable
    public PsiElement getNameIdentifier() {
        final ASTNode keyNode = getNode();
        return keyNode.getPsi();
    }

    @NotNull
    public PsiReference getReference() {
        return new DReference(this, TextRange.from(0, (this).getName().length()));
    }

    @NotNull
    public PsiElement setName(@NotNull final String newName) {
        this.getIdentifier().setName(newName);
        return this;
    }

    @NotNull
    public ItemPresentation getPresentation() {
        return new ItemPresentation() {
            @NotNull
            @Override
            public String getPresentableText() {
                return getName();
            }

            /**
             * This is needed to decipher between files when resolving multiple references.
             */
            @Nullable
            @Override
            public String getLocationString() {
                final PsiFile psiFile = getContainingFile();
                return psiFile instanceof DLanguageFile ? ((DLanguageFile) psiFile).getModuleOrFileName() : null;
            }

            @Nullable
            @Override
            public Icon getIcon(final boolean unused) {
                return DLanguageIcons.FILE;
            }
        };
    }

}
