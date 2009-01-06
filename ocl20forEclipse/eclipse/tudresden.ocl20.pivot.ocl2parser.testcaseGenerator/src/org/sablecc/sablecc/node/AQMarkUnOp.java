/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.sablecc.node;

import java.util.*;

import org.sablecc.sablecc.analysis.*;
import org.sablecc.sablecc.node.AQMarkUnOp;
import org.sablecc.sablecc.node.Node;
import org.sablecc.sablecc.node.PUnOp;
import org.sablecc.sablecc.node.Switch;
import org.sablecc.sablecc.node.TQMark;



public final class AQMarkUnOp extends PUnOp
{
    private TQMark _qMark_;

    public AQMarkUnOp()
    {
    }

    public AQMarkUnOp(
        TQMark _qMark_)
    {
        setQMark(_qMark_);

    }
    public Object clone()
    {
        return new AQMarkUnOp(
            (TQMark) cloneNode(_qMark_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAQMarkUnOp(this);
    }

    public TQMark getQMark()
    {
        return _qMark_;
    }

    public void setQMark(TQMark node)
    {
        if(_qMark_ != null)
        {
            _qMark_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _qMark_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_qMark_);
    }

    void removeChild(Node child)
    {
        if(_qMark_ == child)
        {
            _qMark_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_qMark_ == oldChild)
        {
            setQMark((TQMark) newChild);
            return;
        }

    }
}
