package amailp.parser

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.extapi.psi.ASTWrapperPsiElement
import RobotASTTypes._
import amailp.elements.RobotTokenTypes.Ellipsis

class PsiElementBuilder(node: ASTNode) {
  def build(): PsiElement = {
    node.getElementType match {
      case Ellipsis => new amailp.psi.Ellipsis(node)
      case SettingsTable => new amailp.psi.Settings(node)
      case SettingName | ResourceName => new amailp.psi.SettingName(node)
      case ResourceValue => new amailp.psi.ResourceValue(node)
      case TestCaseName => new amailp.psi.TestCaseName(node)
      case KeywordName => new amailp.psi.KeywordName(node)
      case Keyword => new amailp.psi.Keyword(node)
      case _ => new ASTWrapperPsiElement(node)
    }
  }
}
