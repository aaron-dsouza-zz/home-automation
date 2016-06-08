/**
 * Copyright 2016 Tridium, Inc. All Rights Reserved.
 */
package com.tridium.spherobb8.message;

import com.tridium.ndriver.comm.*;


/**
 * SpheroBB8MessageFactory implementation of IMessageFactory.
 *
 * @author   Aaron D'souza
 * @creation 24-May-16 
 */
public class SpheroBB8MessageFactory
  implements IMessageFactory
{
  
  public SpheroBB8MessageFactory() {}
  
  public NMessage makeMessage(LinkMessage lm) 
      throws Exception
  {
    //
    // TODO - convert linkMessage driver specific NMessage
    return null;
  }

}
