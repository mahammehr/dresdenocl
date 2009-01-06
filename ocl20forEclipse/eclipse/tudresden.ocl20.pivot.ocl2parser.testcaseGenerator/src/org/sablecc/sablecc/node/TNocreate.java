/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.sablecc.node;

import org.sablecc.sablecc.analysis.*;
import org.sablecc.sablecc.node.Switch;
import org.sablecc.sablecc.node.TNocreate;
import org.sablecc.sablecc.node.Token;



public final class TNocreate extends Token
{
    public TNocreate()
    {
        super.setText("#nocreate");
    }

    public TNocreate(int line, int pos)
    {
        super.setText("#nocreate");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TNocreate(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTNocreate(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TNocreate text.");
    }
}
