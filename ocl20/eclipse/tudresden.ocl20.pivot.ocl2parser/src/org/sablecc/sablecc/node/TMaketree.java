/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.sablecc.node;

import org.sablecc.sablecc.analysis.*;

public final class TMaketree extends Token
{
    public TMaketree()
    {
        super.setText("#maketree");
    }

    public TMaketree(int line, int pos)
    {
        super.setText("#maketree");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TMaketree(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTMaketree(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TMaketree text.");
    }
}