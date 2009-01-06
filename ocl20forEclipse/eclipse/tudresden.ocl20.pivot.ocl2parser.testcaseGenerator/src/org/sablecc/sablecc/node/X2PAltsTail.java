/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.sablecc.node;

import org.sablecc.sablecc.analysis.*;
import org.sablecc.sablecc.node.Node;
import org.sablecc.sablecc.node.PAltsTail;
import org.sablecc.sablecc.node.Switch;
import org.sablecc.sablecc.node.XPAltsTail;

public final class X2PAltsTail extends XPAltsTail
{
    private PAltsTail _pAltsTail_;

    public X2PAltsTail()
    {
    }

    public X2PAltsTail(
        PAltsTail _pAltsTail_)
    {
        setPAltsTail(_pAltsTail_);
    }

    public Object clone()
    {
        throw new RuntimeException("Unsupported Operation");
    }

    public void apply(Switch sw)
    {
        throw new RuntimeException("Switch not supported.");
    }

    public PAltsTail getPAltsTail()
    {
        return _pAltsTail_;
    }

    public void setPAltsTail(PAltsTail node)
    {
        if(_pAltsTail_ != null)
        {
            _pAltsTail_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _pAltsTail_ = node;
    }

    void removeChild(Node child)
    {
        if(_pAltsTail_ == child)
        {
            _pAltsTail_ = null;
        }
    }

    void replaceChild(Node oldChild, Node newChild)
    {
    }

    public String toString()
    {
        return "" +
            toString(_pAltsTail_);
    }
}
