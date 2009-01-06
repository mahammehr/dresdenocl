/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.sablecc.node;

import org.sablecc.sablecc.analysis.*;
import org.sablecc.sablecc.node.Switch;
import org.sablecc.sablecc.node.TChain;
import org.sablecc.sablecc.node.Token;



public final class TChain extends Token
{
    public TChain()
    {
        super.setText("#chain");
    }

    public TChain(int line, int pos)
    {
        super.setText("#chain");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TChain(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTChain(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TChain text.");
    }
}
