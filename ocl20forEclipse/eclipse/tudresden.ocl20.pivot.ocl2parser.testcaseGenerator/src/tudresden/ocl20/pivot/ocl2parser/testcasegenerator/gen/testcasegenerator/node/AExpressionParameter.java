/* This file was generated by SableCC (http://www.sablecc.org/). */

package tudresden.ocl20.pivot.ocl2parser.testcasegenerator.gen.testcasegenerator.node;

import java.util.*;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.gen.testcasegenerator.analysis.*;

public final class AExpressionParameter extends PParameter
{
    private PModelExpression _modelExpression_;

    public AExpressionParameter()
    {
    }

    public AExpressionParameter(
        PModelExpression _modelExpression_)
    {
        setModelExpression(_modelExpression_);

    }
    public Object clone()
    {
        return new AExpressionParameter(
            (PModelExpression) cloneNode(_modelExpression_));
    }

    public void apply(Switch sw) {
        ((Analysis) sw).caseAExpressionParameter(this);
    }

    public Object apply(SwitchWithReturn sw, Object param) throws AttrEvalException {
        return ((AnalysisWithReturn) sw).caseAExpressionParameter(this, param);
    }

    public PModelExpression getModelExpression()
    {
        return _modelExpression_;
    }

    public void setModelExpression(PModelExpression node)
    {
        if(_modelExpression_ != null)
        {
            _modelExpression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _modelExpression_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_modelExpression_);
    }

    void removeChild(Node child)
    {
        if(_modelExpression_ == child)
        {
            _modelExpression_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_modelExpression_ == oldChild)
        {
            setModelExpression((PModelExpression) newChild);
            return;
        }

    }
}
