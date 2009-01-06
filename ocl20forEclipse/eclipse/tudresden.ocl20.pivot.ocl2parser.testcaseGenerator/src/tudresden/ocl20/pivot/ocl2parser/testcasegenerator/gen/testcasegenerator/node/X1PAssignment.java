/* This file was generated by SableCC (http://www.sablecc.org/). */

package tudresden.ocl20.pivot.ocl2parser.testcasegenerator.gen.testcasegenerator.node;

import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.gen.testcasegenerator.analysis.*;

public final class X1PAssignment extends XPAssignment
{
    private XPAssignment _xPAssignment_;
    private PAssignment _pAssignment_;

    public X1PAssignment()
    {
    }

    public X1PAssignment(
        XPAssignment _xPAssignment_,
        PAssignment _pAssignment_)
    {
        setXPAssignment(_xPAssignment_);
        setPAssignment(_pAssignment_);
    }

    public Object clone()
    {
        throw new RuntimeException("Unsupported Operation");
    }

    public void apply(Switch sw) {
        throw new RuntimeException("Switch not supported.");
    }
    public Object apply(SwitchWithReturn sw, Object param) throws AttrEvalException {
        throw new RuntimeException("Switch not supported.");
    }

    public XPAssignment getXPAssignment() {
        return _xPAssignment_;
    }

    public void setXPAssignment(XPAssignment node) {
        if(_xPAssignment_ != null) {
            _xPAssignment_.parent(null);
        }

        if(node != null) {
            if(node.parent() != null) {
                node.parent().removeChild(node);
            }
            node.parent(this);
        }

        _xPAssignment_ = node;
    }

    public PAssignment getPAssignment() {
        return _pAssignment_;
    }

    public void setPAssignment(PAssignment node)
    {
        if(_pAssignment_ != null)
        {
            _pAssignment_.parent(null);
        }

        if(node != null) {
            if(node.parent() != null) {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _pAssignment_ = node;
    }

    void removeChild(Node child) {
        if(_xPAssignment_ == child)
        {
            _xPAssignment_ = null;
        }

        if(_pAssignment_ == child)
        {
            _pAssignment_ = null;
        }
    }

    void replaceChild(Node oldChild, Node newChild)
    {
    }

    public String toString()
    {
        return "" +
            toString(_xPAssignment_) +
            toString(_pAssignment_);
    }
}
