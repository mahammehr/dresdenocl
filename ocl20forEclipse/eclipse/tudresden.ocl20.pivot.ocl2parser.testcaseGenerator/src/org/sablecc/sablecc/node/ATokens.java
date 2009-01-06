/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.sablecc.node;

import java.util.*;

import org.sablecc.sablecc.analysis.*;
import org.sablecc.sablecc.node.ATokens;
import org.sablecc.sablecc.node.Cast;
import org.sablecc.sablecc.node.Node;
import org.sablecc.sablecc.node.PTokenDef;
import org.sablecc.sablecc.node.PTokens;
import org.sablecc.sablecc.node.Switch;
import org.sablecc.sablecc.node.TTokens;
import org.sablecc.sablecc.node.TypedLinkedList;
import org.sablecc.sablecc.node.X1PTokenDef;
import org.sablecc.sablecc.node.X2PTokenDef;
import org.sablecc.sablecc.node.XPTokenDef;



public final class ATokens extends PTokens
{
    private TTokens _tokens_;
    private final LinkedList _tokenDefs_ = new TypedLinkedList(new TokenDefs_Cast());

    public ATokens()
    {
    }

    public ATokens(
        TTokens _tokens_,
        List _tokenDefs_)
    {
        setTokens(_tokens_);

        {
            this._tokenDefs_.clear();
            this._tokenDefs_.addAll(_tokenDefs_);
        }

    }

    public ATokens(
        TTokens _tokens_,
        XPTokenDef _tokenDefs_)
    {
        setTokens(_tokens_);

        if(_tokenDefs_ != null)
        {
            while(_tokenDefs_ instanceof X1PTokenDef)
            {
                this._tokenDefs_.addFirst(((X1PTokenDef) _tokenDefs_).getPTokenDef());
                _tokenDefs_ = ((X1PTokenDef) _tokenDefs_).getXPTokenDef();
            }
            this._tokenDefs_.addFirst(((X2PTokenDef) _tokenDefs_).getPTokenDef());
        }

    }
    public Object clone()
    {
        return new ATokens(
            (TTokens) cloneNode(_tokens_),
            cloneList(_tokenDefs_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseATokens(this);
    }

    public TTokens getTokens()
    {
        return _tokens_;
    }

    public void setTokens(TTokens node)
    {
        if(_tokens_ != null)
        {
            _tokens_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _tokens_ = node;
    }

    public LinkedList getTokenDefs()
    {
        return _tokenDefs_;
    }

    public void setTokenDefs(List list)
    {
        _tokenDefs_.clear();
        _tokenDefs_.addAll(list);
    }

    public String toString()
    {
        return ""
            + toString(_tokens_)
            + toString(_tokenDefs_);
    }

    void removeChild(Node child)
    {
        if(_tokens_ == child)
        {
            _tokens_ = null;
            return;
        }

        if(_tokenDefs_.remove(child))
        {
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_tokens_ == oldChild)
        {
            setTokens((TTokens) newChild);
            return;
        }

        for(ListIterator i = _tokenDefs_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set(newChild);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

    }

    private class TokenDefs_Cast implements Cast
    {
        public Object cast(Object o)
        {
            PTokenDef node = (PTokenDef) o;

            if((node.parent() != null) &&
                (node.parent() != ATokens.this))
            {
                node.parent().removeChild(node);
            }

            if((node.parent() == null) ||
                (node.parent() != ATokens.this))
            {
                node.parent(ATokens.this);
            }

            return node;
        }
    }
}
