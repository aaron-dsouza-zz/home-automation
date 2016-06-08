/**
 * Copyright 2016 Tridium, Inc. All Rights Reserved.
 */
package com.tridium.spherobb8.comm;

import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.nre.annotations.*;

import com.tridium.ndriver.comm.IMessageFactory;
import com.tridium.ndriver.comm.LinkMessage;
import com.tridium.ndriver.comm.NLinkMessageFactory;
import com.tridium.ndriver.datatypes.BTcpCommConfig;

import com.tridium.spherobb8.message.SpheroBB8MessageFactory;

/**
 * BSpheroBB8TcpCommConfig Handles the tcp communication for the driver. 
 *
 * @author   Aaron D'souza
 * @creation 24-May-16 
 *
 */
//@NiagaraSlots( properties = { } )
public class BSpheroBB8TcpCommConfig
  extends BTcpCommConfig
{
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSpheroBB8TcpCommConfig.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  /** Empty constructor  */
  public BSpheroBB8TcpCommConfig() {  }
  
//  /** Override to configure the maximum number of request messages that can
//   *  be outstanding at the same time.  Default implementation returns 32. */
//  public int getMaxOutstandingTransactions() { return 1; }

  /** Provide custom LinkMessage factory.   */
  protected NLinkMessageFactory makeLinkMessageFactory()
  {    
    // link message factory must create
    return new NLinkMessageFactory(1024)
      {
        protected LinkMessage createLinkMessage()
        {
          return new SpheroBB8TcpLinkMessage(1024); 
        }
      };
  }
  
  /** Provide custom Message factory.   */
  protected IMessageFactory makeMessageFactory()
  {
    return new SpheroBB8MessageFactory();
  }
  
}
