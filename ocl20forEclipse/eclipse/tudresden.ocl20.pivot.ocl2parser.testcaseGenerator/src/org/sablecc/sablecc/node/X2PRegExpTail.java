/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.sablecc.node;

import org.sablecc.sablecc.analysis.*;
import org.sablecc.sablecc.node.Node;
import org.sablecc.sablecc.node.PRegExpTail;
import org.sablecc.sablecc.node.Switch;
import org.sablecc.sablecc.node.XPRegExpTail;

public final class X2PRegExpTail extends XPRegExpTail
{
    private PRegExpTail _pRegExpTail_;

    public X2PRegExpTail()
    {
    }

    public X2PRegExpTail(
        PRegExpTail _pRegExpTail_)
    {
        setPRegExpTail(_pRegExpTail_);
    }

    public Object clone()
    {
        throw new RuntimeException("Unsupported Operation");
    }

    public void apply(Switch sw)
    {
        throw new RuntimeException("Switch not supported.");
    }

    public PRegExpTail getPRegExpTail()
    {
        return _pRegExpTail_;
    }

    public void setPRegExpTail(PRegExpTail node)
    {
        if(_pRegExpTail_ != null)
        {
            _pRegExpTail_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _pRegExpTail_ = node;
    }

    void removeChild(Node child)
    {
        if(_pRegExpTail_ == child)
        {
            _pRegExpTail_ = null;
        }
    }

    void replaceChild(Node oldChild, Node newChild)
    {
    }

    public String toString()
    {
        return "" +
            toString(_pRegExpTail_);
    }
}
