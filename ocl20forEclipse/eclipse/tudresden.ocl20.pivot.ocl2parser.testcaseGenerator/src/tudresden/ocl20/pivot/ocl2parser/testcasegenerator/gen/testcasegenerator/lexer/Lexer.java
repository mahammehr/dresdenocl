/* This file was generated by SableCC (http://www.sablecc.org/). */

package tudresden.ocl20.pivot.ocl2parser.testcasegenerator.gen.testcasegenerator.lexer;

import java.io.*;
import java.util.*;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.gen.testcasegenerator.node.*;

public class Lexer
{
    protected Token token;
    protected State state = State.INIT_STATE;

    private PushbackReader in;
    private int line;
    private int pos;
    private boolean cr;
    private boolean eof;
    private final StringBuffer text = new StringBuffer();

    protected void filter() throws LexerException, IOException
    {
    }

    public Lexer(PushbackReader in)
    {
        this.in = in;

        if(gotoTable == null)
        {
            try
            {
                DataInputStream s = new DataInputStream(
                    new BufferedInputStream(
                    Lexer.class.getResourceAsStream("lexer.dat")));

                // read gotoTable
                int length = s.readInt();
                gotoTable = new int[length][][][];
                for(int i = 0; i < gotoTable.length; i++)
                {
                    length = s.readInt();
                    gotoTable[i] = new int[length][][];
                    for(int j = 0; j < gotoTable[i].length; j++)
                    {
                        length = s.readInt();
                        gotoTable[i][j] = new int[length][3];
                        for(int k = 0; k < gotoTable[i][j].length; k++)
                        {
                            for(int l = 0; l < 3; l++)
                            {
                                gotoTable[i][j][k][l] = s.readInt();
                            }
                        }
                    }
                }

                // read accept
                length = s.readInt();
                accept = new int[length][];
                for(int i = 0; i < accept.length; i++)
                {
                    length = s.readInt();
                    accept[i] = new int[length];
                    for(int j = 0; j < accept[i].length; j++)
                    {
                        accept[i][j] = s.readInt();
                    }
                }

                s.close();
            }
            catch(Exception e)
            {
                throw new RuntimeException("The file \"lexer.dat\" is either missing or corrupted.");
            }
        }
    }

    public Token peek() throws LexerException, IOException
    {
        while(token == null)
        {
            token = getToken();
            filter();
        }

        return token;
    }

    public Token next() throws LexerException, IOException
    {
        while(token == null)
        {
            token = getToken();
            filter();
        }

        Token result = token;
        token = null;
        return result;
    }

    protected Token getToken() throws IOException, LexerException
    {
        int dfa_state = 0;

        int start_pos = pos;
        int start_line = line;

        int accept_state = -1;
        int accept_token = -1;
        int accept_length = -1;
        int accept_pos = -1;
        int accept_line = -1;

        int[][][] gotoTable = this.gotoTable[state.id()];
        int[] accept = this.accept[state.id()];
        text.setLength(0);

        while(true)
        {
            int c = getChar();

            if(c != -1)
            {
                switch(c)
                {
                case 10:
                    if(cr)
                    {
                        cr = false;
                    }
                    else
                    {
                        line++;
                        pos = 0;
                    }
                    break;
                case 13:
                    line++;
                    pos = 0;
                    cr = true;
                    break;
                default:
                    pos++;
                    cr = false;
                    break;
                };

                text.append((char) c);

                do
                {
                    int oldState = (dfa_state < -1) ? (-2 -dfa_state) : dfa_state;

                    dfa_state = -1;

                    int[][] tmp1 =  gotoTable[oldState];
                    int low = 0;
                    int high = tmp1.length - 1;

                    while(low <= high)
                    {
                        int middle = (low + high) / 2;
                        int[] tmp2 = tmp1[middle];

                        if(c < tmp2[0])
                        {
                            high = middle - 1;
                        }
                        else if(c > tmp2[1])
                        {
                            low = middle + 1;
                        }
                        else
                        {
                            dfa_state = tmp2[2];
                            break;
                        }
                    }
                }while(dfa_state < -1);
            }
            else
            {
                dfa_state = -1;
            }

            if(dfa_state >= 0)
            {
                if(accept[dfa_state] != -1)
                {
                    accept_state = dfa_state;
                    accept_token = accept[dfa_state];
                    accept_length = text.length();
                    accept_pos = pos;
                    accept_line = line;
                }
            }
            else
            {
                if(accept_state != -1)
                {
                    switch(accept_token)
                    {
                    case 0:
                        {
                            Token token = new0(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.TICK_STATE; break;
                                case 2: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 1:
                        {
                            Token token = new1(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 2:
                        {
                            Token token = new2(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 3:
                        {
                            Token token = new3(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                                case 1: state = State.OCL_STATE; break;
                            }
                            return token;
                        }
                    case 4:
                        {
                            Token token = new4(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                                case 1: state = State.OCL_STATE; break;
                            }
                            return token;
                        }
                    case 5:
                        {
                            Token token = new5(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 6:
                        {
                            Token token = new6(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 7:
                        {
                            Token token = new7(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 8:
                        {
                            Token token = new8(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 9:
                        {
                            Token token = new9(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 10:
                        {
                            Token token = new10(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 11:
                        {
                            Token token = new11(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 12:
                        {
                            Token token = new12(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 13:
                        {
                            Token token = new13(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 14:
                        {
                            Token token = new14(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 15:
                        {
                            Token token = new15(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 16:
                        {
                            Token token = new16(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 17:
                        {
                            Token token = new17(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 18:
                        {
                            Token token = new18(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 19:
                        {
                            Token token = new19(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 20:
                        {
                            Token token = new20(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 21:
                        {
                            Token token = new21(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 22:
                        {
                            Token token = new22(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 23:
                        {
                            Token token = new23(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.OCL_STATE; break;
                            }
                            return token;
                        }
                    case 24:
                        {
                            Token token = new24(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 25:
                        {
                            Token token = new25(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 26:
                        {
                            Token token = new26(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 27:
                        {
                            Token token = new27(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 28:
                        {
                            Token token = new28(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 29:
                        {
                            Token token = new29(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 30:
                        {
                            Token token = new30(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 1: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 31:
                        {
                            Token token = new31(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 2: state = State.TICK_STATE; break;
                            }
                            return token;
                        }
                    }
                }
                else
                {
                    if(text.length() > 0)
                    {
                        throw new LexerException(
                            "[" + (start_line + 1) + "," + (start_pos + 1) + "]" +
                            " Unknown token: " + text);
                    }
                    else
                    {
                        EOF token = new EOF(
                            start_line + 1,
                            start_pos + 1);
                        return token;
                    }
                }
            }
        }
    }

    Token new0(String text, int line, int pos) { return new TTick(text, line, pos); }
    Token new1(int line, int pos) { return new TNew(line, pos); }
    Token new2(int line, int pos) { return new TNull(line, pos); }
    Token new3(String text, int line, int pos) { return new TNewLine(text, line, pos); }
    Token new4(String text, int line, int pos) { return new TBlank(text, line, pos); }
    Token new5(int line, int pos) { return new TPackage(line, pos); }
    Token new6(int line, int pos) { return new TMetamodel(line, pos); }
    Token new7(int line, int pos) { return new TModel(line, pos); }
    Token new8(int line, int pos) { return new TInclude(line, pos); }
    Token new9(int line, int pos) { return new TTestname(line, pos); }
    Token new10(int line, int pos) { return new TSuitename(line, pos); }
    Token new11(String text, int line, int pos) { return new TBraceOpen(text, line, pos); }
    Token new12(String text, int line, int pos) { return new TBraceClose(text, line, pos); }
    Token new13(int line, int pos) { return new TError(line, pos); }
    Token new14(int line, int pos) { return new TAssign(line, pos); }
    Token new15(int line, int pos) { return new TComma(line, pos); }
    Token new16(int line, int pos) { return new TFirstName(line, pos); }
    Token new17(int line, int pos) { return new TColon(line, pos); }
    Token new18(int line, int pos) { return new TOpenparen(line, pos); }
    Token new19(int line, int pos) { return new TCloseparen(line, pos); }
    Token new20(int line, int pos) { return new TAtpre(line, pos); }
    Token new21(int line, int pos) { return new TTestcase(line, pos); }
    Token new22(int line, int pos) { return new TAbstractmodel(line, pos); }
    Token new23(int line, int pos) { return new TOclexpression(line, pos); }
    Token new24(String text, int line, int pos) { return new TRealValue(text, line, pos); }
    Token new25(String text, int line, int pos) { return new TIntegerValue(text, line, pos); }
    Token new26(String text, int line, int pos) { return new TIdent(text, line, pos); }
    Token new27(String text, int line, int pos) { return new TPackageName(text, line, pos); }
    Token new28(String text, int line, int pos) { return new TCommentblock(text, line, pos); }
    Token new29(String text, int line, int pos) { return new TCommentline(text, line, pos); }
    Token new30(String text, int line, int pos) { return new TOclblock(text, line, pos); }
    Token new31(String text, int line, int pos) { return new TStringLiteral(text, line, pos); }

    private int getChar() throws IOException
    {
        if(eof)
        {
            return -1;
        }

        int result = in.read();

        if(result == -1)
        {
            eof = true;
        }

        return result;
    }

    private void pushBack(int acceptLength) throws IOException
    {
        int length = text.length();
        for(int i = length - 1; i >= acceptLength; i--)
        {
            eof = false;

            in.unread(text.charAt(i));
        }
    }

    protected void unread(Token token) throws IOException
    {
        String text = token.getText();
        int length = text.length();

        for(int i = length - 1; i >= 0; i--)
        {
            eof = false;

            in.unread(text.charAt(i));
        }

        pos = token.getPos() - 1;
        line = token.getLine() - 1;
    }

    private String getText(int acceptLength)
    {
        StringBuffer s = new StringBuffer(acceptLength);
        for(int i = 0; i < acceptLength; i++)
        {
            s.append(text.charAt(i));
        }

        return s.toString();
    }

    private static int[][][][] gotoTable;
/*  {
        { // INIT_STATE
            {{9, 9, 1}, {10, 10, 2}, {13, 13, 3}, {32, 32, 4}, {35, 35, 5}, {39, 39, 6}, {40, 40, 7}, {41, 41, 8}, {44, 44, 9}, {46, 46, 10}, {47, 47, 11}, {48, 48, 12}, {49, 57, 13}, {58, 58, 14}, {64, 64, 15}, {65, 90, 16}, {97, 108, 17}, {109, 109, 18}, {110, 110, 19}, {111, 122, 17}, {123, 123, 20}, },
            {{9, 9, 1}, {32, 32, 4}, },
            {},
            {{10, 10, 21}, },
            {{9, 32, -3}, },
            {{97, 97, 22}, {101, 101, 23}, {105, 105, 24}, {109, 109, 25}, {111, 111, 26}, {112, 112, 27}, {115, 115, 28}, {116, 116, 29}, {125, 125, 30}, },
            {},
            {},
            {},
            {},
            {{48, 57, 31}, },
            {{42, 42, 32}, {47, 47, 33}, },
            {{46, 46, 10}, },
            {{46, 46, 10}, {48, 57, 34}, },
            {{61, 61, 35}, },
            {{112, 112, 36}, },
            {{46, 46, 37}, {48, 57, 38}, {65, 90, 39}, {95, 95, 40}, {97, 122, 41}, },
            {{46, 122, -18}, },
            {{46, 95, -18}, {97, 110, 41}, {111, 111, 42}, {112, 122, 41}, },
            {{46, 95, -18}, {97, 100, 41}, {101, 101, 43}, {102, 116, 41}, {117, 117, 44}, {118, 122, 41}, },
            {{35, 35, 45}, },
            {},
            {{98, 98, 46}, },
            {{114, 114, 47}, },
            {{110, 110, 48}, },
            {{101, 101, 49}, {111, 111, 50}, },
            {{99, 99, 51}, },
            {{97, 97, 52}, },
            {{117, 117, 53}, },
            {{101, 101, 54}, },
            {},
            {{48, 57, 31}, {69, 69, 55}, {101, 101, 56}, },
            {{0, 41, 57}, {42, 42, 58}, {43, 65535, 57}, },
            {{0, 9, 59}, {10, 10, 60}, {11, 12, 59}, {13, 13, 61}, {14, 65535, 59}, },
            {{46, 57, -15}, },
            {},
            {{114, 114, 62}, },
            {{65, 90, 63}, {97, 122, 64}, },
            {{46, 122, -18}, },
            {{46, 122, -18}, },
            {{48, 57, 65}, {65, 90, 66}, {97, 122, 67}, },
            {{46, 122, -18}, },
            {{46, 95, -18}, {97, 99, 41}, {100, 100, 68}, {101, 122, 41}, },
            {{46, 95, -18}, {97, 118, 41}, {119, 119, 69}, {120, 122, 41}, },
            {{46, 95, -18}, {97, 107, 41}, {108, 108, 70}, {109, 122, 41}, },
            {},
            {{115, 115, 71}, },
            {{114, 114, 72}, },
            {{99, 99, 73}, },
            {{116, 116, 74}, },
            {{100, 100, 75}, },
            {{108, 108, 76}, },
            {{99, 99, 77}, },
            {{105, 105, 78}, },
            {{115, 115, 79}, },
            {{43, 43, 80}, {45, 45, 81}, {48, 57, 82}, },
            {{43, 57, -57}, },
            {{0, 65535, -34}, },
            {{0, 46, 83}, {47, 47, 84}, {48, 65535, 83}, },
            {{0, 65535, -35}, },
            {},
            {{10, 10, 85}, },
            {{101, 101, 86}, },
            {{46, 46, 37}, {48, 57, 87}, {65, 90, 88}, {95, 95, 89}, {97, 122, 90}, },
            {{46, 122, -65}, },
            {{46, 122, -18}, },
            {{46, 122, -18}, },
            {{46, 122, -18}, },
            {{46, 100, -21}, {101, 101, 91}, {102, 122, 41}, },
            {{46, 122, -18}, },
            {{46, 107, -46}, {108, 108, 92}, {109, 122, 41}, },
            {{116, 116, 93}, },
            {{111, 111, 94}, },
            {{108, 108, 95}, },
            {{97, 97, 96}, },
            {{101, 101, 97}, },
            {{101, 101, 98}, },
            {{107, 107, 99}, },
            {{116, 116, 100}, },
            {{116, 116, 101}, },
            {{48, 57, 82}, },
            {{48, 57, 82}, },
            {{48, 57, 82}, },
            {{0, 65535, -34}, },
            {},
            {},
            {},
            {{46, 122, -65}, },
            {{46, 122, -65}, },
            {{48, 57, 102}, {65, 90, 103}, {97, 122, 104}, },
            {{46, 122, -65}, },
            {{46, 107, -46}, {108, 108, 105}, {109, 122, 41}, },
            {{46, 122, -18}, },
            {{114, 114, 106}, },
            {{114, 114, 107}, },
            {{117, 117, 108}, },
            {{109, 109, 109}, },
            {{108, 108, 110}, },
            {{120, 120, 111}, },
            {{97, 97, 112}, },
            {{101, 101, 113}, },
            {{99, 99, 114}, {110, 110, 115}, },
            {{46, 122, -65}, },
            {{46, 122, -65}, },
            {{46, 122, -65}, },
            {{46, 122, -18}, },
            {{97, 97, 116}, },
            {},
            {{100, 100, 117}, },
            {{111, 111, 118}, },
            {},
            {{112, 112, 119}, },
            {{103, 103, 120}, },
            {{110, 110, 121}, },
            {{97, 97, 122}, },
            {{97, 97, 123}, },
            {{99, 99, 124}, },
            {{101, 101, 125}, },
            {{100, 100, 126}, },
            {{114, 114, 127}, },
            {{101, 101, 128}, },
            {{97, 97, 129}, },
            {{115, 115, 130}, },
            {{109, 109, 131}, },
            {{116, 116, 132}, },
            {},
            {{101, 101, 133}, },
            {{101, 101, 134}, },
            {},
            {{109, 109, 135}, },
            {{101, 101, 136}, },
            {{101, 101, 137}, },
            {{109, 109, 138}, },
            {{108, 108, 139}, },
            {{115, 115, 140}, },
            {{101, 101, 141}, },
            {},
            {},
            {{111, 111, 142}, },
            {},
            {{115, 115, 143}, },
            {},
            {{100, 100, 144}, },
            {{105, 105, 145}, },
            {{101, 101, 146}, },
            {{111, 111, 147}, },
            {{108, 108, 148}, },
            {{110, 110, 149}, },
            {},
            {},
        }
        { // OCL_STATE
            {{9, 9, 1}, {10, 10, 2}, {13, 13, 3}, {32, 32, 4}, {123, 123, 5}, },
            {{9, 9, 1}, {32, 32, 4}, },
            {},
            {{10, 10, 6}, },
            {{9, 32, -3}, },
            {{35, 35, 7}, },
            {},
            {{0, 34, 8}, {35, 35, 9}, {36, 65535, 8}, },
            {{0, 65535, -9}, },
            {{0, 34, 10}, {35, 35, 9}, {36, 124, 10}, {125, 125, 11}, {126, 65535, 10}, },
            {{0, 34, 12}, {35, 35, 13}, {36, 65535, 12}, },
            {},
            {{0, 65535, -12}, },
            {{0, 34, 10}, {35, 35, 13}, {36, 65535, -11}, },
        }
        { // TICK_STATE
            {{0, 9, 1}, {11, 12, 1}, {14, 38, 1}, {39, 39, 2}, {40, 65535, 1}, },
            {{0, 38, -2}, {40, 65535, 1}, },
            {},
        }
    };*/

    private static int[][] accept;
/*  {
        // INIT_STATE
        {-1, 4, 3, 3, 4, -1, 0, 18, 19, 15, -1, -1, 25, 25, 17, -1, 26, 26, 26, 26, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, 12, 24, -1, -1, 25, 14, -1, -1, 26, 26, -1, 26, 26, 26, 26, 11, -1, -1, -1, -1, -1, -1, -1, -1, -1, 24, 24, -1, -1, -1, 29, 29, -1, 27, 27, 26, 26, 26, 26, 1, 26, -1, -1, -1, -1, -1, -1, -1, -1, -1, 24, 24, 24, -1, 28, 29, 20, 27, 27, -1, 27, 26, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, 27, 27, 27, 16, -1, 13, -1, -1, 7, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 8, -1, -1, 5, -1, -1, -1, -1, -1, -1, -1, 21, 9, -1, 6, -1, 10, -1, -1, -1, -1, -1, -1, 22, 23, },
        // OCL_STATE
        {-1, 4, 3, 3, 4, -1, 3, -1, -1, -1, -1, 30, -1, -1, },
        // TICK_STATE
        {31, 31, 0, },

    };*/

    public static class State
    {
        public final static State INIT_STATE = new State(0);
        public final static State OCL_STATE = new State(1);
        public final static State TICK_STATE = new State(2);

        private int id;

        private State(int id)
        {
            this.id = id;
        }

        public int id()
        {
            return id;
        }
    }
}
