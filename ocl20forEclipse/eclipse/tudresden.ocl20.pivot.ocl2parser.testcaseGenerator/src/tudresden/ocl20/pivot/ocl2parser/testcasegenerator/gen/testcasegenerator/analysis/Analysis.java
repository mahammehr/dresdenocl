/* This file was generated by SableCC (http://www.sablecc.org/). */

package tudresden.ocl20.pivot.ocl2parser.testcasegenerator.gen.testcasegenerator.analysis;

import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.gen.testcasegenerator.node.*;

public interface Analysis extends Switch
{
    Object getIn(Node node);
    void setIn(Node node, Object in);
    Object getOut(Node node);
    void setOut(Node node, Object out);

    void caseStart(Start node);
    // void caseStart(Start node, Object param);
    void caseASuiteTestpackage(ASuiteTestpackage node);
    // void caseASuiteTestpackage(ASuiteTestpackage node, Object param);
    void caseATestcaseTestpackage(ATestcaseTestpackage node);
    // void caseATestcaseTestpackage(ATestcaseTestpackage node, Object param);
    void caseATestsuite(ATestsuite node);
    // void caseATestsuite(ATestsuite node, Object param);
    void caseANames(ANames node);
    // void caseANames(ANames node, Object param);
    void caseASuiteElement(ASuiteElement node);
    // void caseASuiteElement(ASuiteElement node, Object param);
    void caseATestcasefile(ATestcasefile node);
    // void caseATestcasefile(ATestcasefile node, Object param);
    void caseAName(AName node);
    // void caseAName(AName node, Object param);
    void caseAPackageDeclaration(APackageDeclaration node);
    // void caseAPackageDeclaration(APackageDeclaration node, Object param);
    void caseAMetamodelModelDeclaration(AMetamodelModelDeclaration node);
    // void caseAMetamodelModelDeclaration(AMetamodelModelDeclaration node, Object param);
    void caseAModelModelDeclaration(AModelModelDeclaration node);
    // void caseAModelModelDeclaration(AModelModelDeclaration node, Object param);
    void caseAMetamodelDesc(AMetamodelDesc node);
    // void caseAMetamodelDesc(AMetamodelDesc node, Object param);
    void caseAModelDesc(AModelDesc node);
    // void caseAModelDesc(AModelDesc node, Object param);
    void caseATestcaseElement(ATestcaseElement node);
    // void caseATestcaseElement(ATestcaseElement node, Object param);
    void caseATestcasename(ATestcasename node);
    // void caseATestcasename(ATestcasename node, Object param);
    void caseAOclExpression(AOclExpression node);
    // void caseAOclExpression(AOclExpression node, Object param);
    void caseAAbstractmodelResult(AAbstractmodelResult node);
    // void caseAAbstractmodelResult(AAbstractmodelResult node, Object param);
    void caseAErrorResult(AErrorResult node);
    // void caseAErrorResult(AErrorResult node, Object param);
    void caseAAbstractModel(AAbstractModel node);
    // void caseAAbstractModel(AAbstractModel node, Object param);
    void caseAAssignment(AAssignment node);
    // void caseAAssignment(AAssignment node, Object param);
    void caseAModelelementModelExpression(AModelelementModelExpression node);
    // void caseAModelelementModelExpression(AModelelementModelExpression node, Object param);
    void caseAIdentModelExpression(AIdentModelExpression node);
    // void caseAIdentModelExpression(AIdentModelExpression node, Object param);
    void caseANullModelExpression(ANullModelExpression node);
    // void caseANullModelExpression(ANullModelExpression node, Object param);
    void caseASimpleModelExpression(ASimpleModelExpression node);
    // void caseASimpleModelExpression(ASimpleModelExpression node, Object param);
    void caseANewModelExpression(ANewModelExpression node);
    // void caseANewModelExpression(ANewModelExpression node, Object param);
    void caseARealSimpleExpression(ARealSimpleExpression node);
    // void caseARealSimpleExpression(ARealSimpleExpression node, Object param);
    void caseAIntegerSimpleExpression(AIntegerSimpleExpression node);
    // void caseAIntegerSimpleExpression(AIntegerSimpleExpression node, Object param);
    void caseAStringSimpleExpression(AStringSimpleExpression node);
    // void caseAStringSimpleExpression(AStringSimpleExpression node, Object param);
    void caseAElementParameter(AElementParameter node);
    // void caseAElementParameter(AElementParameter node, Object param);
    void caseASingleParameters(ASingleParameters node);
    // void caseASingleParameters(ASingleParameters node, Object param);
    void caseAMultipleParameters(AMultipleParameters node);
    // void caseAMultipleParameters(AMultipleParameters node, Object param);
    void caseAExpressionParameter(AExpressionParameter node);
    // void caseAExpressionParameter(AExpressionParameter node, Object param);

    void caseTTick(TTick node);
    // void caseTTick(TTick node, Object param);
    void caseTNew(TNew node);
    // void caseTNew(TNew node, Object param);
    void caseTNull(TNull node);
    // void caseTNull(TNull node, Object param);
    void caseTNewLine(TNewLine node);
    // void caseTNewLine(TNewLine node, Object param);
    void caseTBlank(TBlank node);
    // void caseTBlank(TBlank node, Object param);
    void caseTPackage(TPackage node);
    // void caseTPackage(TPackage node, Object param);
    void caseTMetamodel(TMetamodel node);
    // void caseTMetamodel(TMetamodel node, Object param);
    void caseTModel(TModel node);
    // void caseTModel(TModel node, Object param);
    void caseTInclude(TInclude node);
    // void caseTInclude(TInclude node, Object param);
    void caseTTestname(TTestname node);
    // void caseTTestname(TTestname node, Object param);
    void caseTSuitename(TSuitename node);
    // void caseTSuitename(TSuitename node, Object param);
    void caseTBraceOpen(TBraceOpen node);
    // void caseTBraceOpen(TBraceOpen node, Object param);
    void caseTBraceClose(TBraceClose node);
    // void caseTBraceClose(TBraceClose node, Object param);
    void caseTError(TError node);
    // void caseTError(TError node, Object param);
    void caseTAssign(TAssign node);
    // void caseTAssign(TAssign node, Object param);
    void caseTComma(TComma node);
    // void caseTComma(TComma node, Object param);
    void caseTFirstName(TFirstName node);
    // void caseTFirstName(TFirstName node, Object param);
    void caseTColon(TColon node);
    // void caseTColon(TColon node, Object param);
    void caseTOpenparen(TOpenparen node);
    // void caseTOpenparen(TOpenparen node, Object param);
    void caseTCloseparen(TCloseparen node);
    // void caseTCloseparen(TCloseparen node, Object param);
    void caseTTestcase(TTestcase node);
    // void caseTTestcase(TTestcase node, Object param);
    void caseTAbstractmodel(TAbstractmodel node);
    // void caseTAbstractmodel(TAbstractmodel node, Object param);
    void caseTOclexpression(TOclexpression node);
    // void caseTOclexpression(TOclexpression node, Object param);
    void caseTRealValue(TRealValue node);
    // void caseTRealValue(TRealValue node, Object param);
    void caseTIntegerValue(TIntegerValue node);
    // void caseTIntegerValue(TIntegerValue node, Object param);
    void caseTIdent(TIdent node);
    // void caseTIdent(TIdent node, Object param);
    void caseTPackageName(TPackageName node);
    // void caseTPackageName(TPackageName node, Object param);
    void caseTCommentblock(TCommentblock node);
    // void caseTCommentblock(TCommentblock node, Object param);
    void caseTCommentline(TCommentline node);
    // void caseTCommentline(TCommentline node, Object param);
    void caseTOclblock(TOclblock node);
    // void caseTOclblock(TOclblock node, Object param);
    void caseTStringLiteral(TStringLiteral node);
    // void caseTStringLiteral(TStringLiteral node, Object param);
    void caseEOF(EOF node);
    // void caseEOF(EOF node, Object param);
}
