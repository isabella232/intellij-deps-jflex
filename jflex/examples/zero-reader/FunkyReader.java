/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * JFlex ZeroReader example                                                *
 *                                                                         *
 * Copyright (C) 1998-2015  Gerwin Klein <lsf@jflex.de>                    *
 * All rights reserved.                                                    *
 *                                                                         *
 * License: BSD                                                            *
 *                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


import java.io.Reader;
import java.io.IOException;


/**
 * Reader that returns 0 chars read every once in a while.
 * 
 * This is a demonstration of a problematic Reader that does not
 * implement the Reader specification correctly. Do not use.
 */
public class FunkyReader extends Reader {

  boolean do_zero;
  Reader reader;

  public FunkyReader(Reader r) {
    this.reader = r;
  }

  public int read(char[] cbuf, int off, int len) throws IOException {
    if (!do_zero) {
      do_zero = true;
      return reader.read(cbuf,off,Math.min(10,len));
    }
    else {
      do_zero = false;
      return 0;
    }
  }

  public void close() throws IOException {
    reader.close();
  }

}
